package e2eLearning;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.TestBase;

import java.io.IOException;

public class SurfingAcademy extends TestBase
{
    HomePage hp;
    LoginPage lp;
    @BeforeClass
    public void startupMethod() throws IOException {
        driver = initilizeDriver();
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
    }

    @Test
    public void LoginWithValidUser() throws InterruptedException {
        hp.clickLoginButton();
        Assert.assertTrue(lp.checkLoginPageLoaded(),"Login Page not loaded successfully.");
        lp.enterEmailId("rahuldhiman4@gmail.com");
        lp.enterPassword("Rahul@123");
        lp.clickLoginButton();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDownMethod(){
        driver.quit();
    }
}
