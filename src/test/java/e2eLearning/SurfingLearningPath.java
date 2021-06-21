package e2eLearning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import resources.TestBase;

import java.io.IOException;

public class SurfingLearningPath extends TestBase {
    public WebDriver driver;
    LearningPathPage lpp;
    HomePage hp;
    RSHomePage rhp;

    @BeforeClass(alwaysRun = true)
    public void startupMethod() throws IOException {
        driver = initilizeDriver();
        hp = new HomePage(driver);
        rhp = new RSHomePage(driver);
        lpp = new LearningPathPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void launchURL(){
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test(groups = {"Regression"})
    public void navigateLearningPathTab(){
        hp.ignoreNewsletterPopupIfAppeared();
        hp.clickRSLogo();
        rhp.clickLearningPathTab();
        Assert.assertEquals(lpp.getPageHeading(),"LEARNING PATHS");
        lpp.clickJavaScriptToggle();
        lpp.clickPythonToggle();
        lpp.clickJavaToggle();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }
}
