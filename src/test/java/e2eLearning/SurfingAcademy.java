package e2eLearning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.CatalogPage;
import pageObjects.HomePage;
import pageObjects.RSHomePage;
import pageObjects.RSLoginPage;
import resources.TestBase;

import java.io.IOException;

public class SurfingAcademy extends TestBase
{
    public WebDriver driver;
    HomePage hp;
    RSHomePage rhp;
    RSLoginPage lp;
    CatalogPage cp;

    @BeforeClass(alwaysRun = true)
    public void startupMethod() throws IOException {
        driver = initilizeDriver();
        hp = new HomePage(driver);
        rhp = new RSHomePage(driver);
        lp = new RSLoginPage(driver);
        cp = new CatalogPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void launchURL(){
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test(groups = {"Regression"})
    @Parameters({"username","password"})
    public void LoginWithValidUser(String user, String key) {
        hp.ignoreNewsletterPopupIfAppeared();
        hp.clickRSLogo();
        rhp.clickLoginIcon();
        Assert.assertFalse(lp.checkLoginPageLoaded(),"Login Page not loaded successfully.");
        lp.enterEmailId(user);
        lp.enterPassword(key);
        lp.clickLoginButton();
    }

    @Test(groups = {"Smoke"})
    public void searchingProduct(){
        hp.ignoreNewsletterPopupIfAppeared();
        hp.clickRSLogo();
        rhp.clickCourseTab();
        cp.searchProduct("Python");
        System.out.println("Number of courses searched ========> "+cp.numberOfCoursesSearched());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }
}
