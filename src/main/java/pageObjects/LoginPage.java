package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;

    By email = By.xpath("//input[@id='user_email']");
    By password  = By.xpath("//input[@id='user_password']");
    By loginMsg = By.cssSelector(".main-hero h1");
    By loginBtn = By.cssSelector(".login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmailId(String userEmail){
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }

    public boolean checkLoginPageLoaded(){
        return driver.findElement(loginMsg).getText().contains("Log In to WebServices Testing");
    }
}
