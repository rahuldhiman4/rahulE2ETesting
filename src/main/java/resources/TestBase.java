package resources;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Properties prop;
    public WebDriver initilizeDriver() throws IOException {
        prop = new Properties();
        FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
        prop.load(propFile);
        String browserName = prop.getProperty("Browser");
        String osName = prop.getProperty("OperatingSystem");
        if(browserName.equals("chrome") && osName.equals("mac"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("chrome") && osName.equals("windows"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("safari")) {
            driver = new SafariDriver();
        }
        else{
            System.out.println("Check Property file for correct browser name or OS");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(src,new File(destinationFile));
        return destinationFile;
    }
}
