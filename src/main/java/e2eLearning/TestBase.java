package e2eLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public WebDriver initilizeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream propFile = new FileInputStream("/Users/rahul/Documents/E2E Framework/src/main/java/e2eLearning/data.properties");
        prop.load(propFile);
        String browserName = prop.getProperty("Browser");
        String osName = prop.getProperty("OperatingSystem");
        if(browserName.equals("chrome") && osName.equals("mac"))
        {
            System.setProperty("webdriver.chrome.driver","/Users/rahul/Documents/E2E Framework/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("chrome") && osName.equals("windows"))
        {
            System.setProperty("webdriver.chrome.driver","/Users/rahul/Documents/E2E Framework/chromedriver.exe");
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
}
