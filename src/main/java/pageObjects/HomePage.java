package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    By login = By.xpath("//a//span[text()='Login']");
    By contact  = By.xpath("//a[text()='Contact']");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton(){
        driver.findElement(login).click();
    }

    public void clickContactButton(){
        driver.findElement(contact).click();
    }
}
