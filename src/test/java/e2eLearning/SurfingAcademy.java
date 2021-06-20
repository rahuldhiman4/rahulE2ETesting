package e2eLearning;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CatalogPage;
import pageObjects.HomePage;
import pageObjects.RSHomePage;
import pageObjects.RSLoginPage;
import resources.TestBase;

import java.io.IOException;

public class SurfingAcademy extends TestBase
{
    HomePage hp;
    RSHomePage rhp;
    RSLoginPage lp;
    CatalogPage cp;
    @BeforeClass
    public void startupMethod() throws IOException {
        driver = initilizeDriver();
        hp = new HomePage(driver);
        rhp = new RSHomePage(driver);
        lp = new RSLoginPage(driver);
        cp = new CatalogPage(driver);
    }

    @BeforeMethod
    public void launchURL(){
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();
    }

    @Test(groups = {"Regression"})
    public void LoginWithValidUser() {
        hp.ignoreNewsletterPopupIfAppeared();
        hp.clickRSLogo();
        rhp.clickLoginIcon();
        Assert.assertTrue(lp.checkLoginPageLoaded(),"Login Page not loaded successfully.");
        lp.enterEmailId("rahuldhiman4@gmail.com");
        lp.enterPassword("Rahul@123");
        lp.clickLoginButton();
    }

    @Test(groups = {"Sanity"})
    public void searchingProduct(){
        hp.ignoreNewsletterPopupIfAppeared();
        hp.clickRSLogo();
        rhp.clickCourseTab();
        cp.searchProduct("Python");
        System.out.println("Number of courses searched ========> "+cp.numberOfCoursesSearched());
    }

    @AfterClass
    public void tearDownMethod(){
        driver.quit();
    }
}
