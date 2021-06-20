package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    public WebDriver driver;
    WebDriverWait wait;

    By newsLetter = By.xpath("//*[text()='Join Our Newsletter']");
    By noThanks = By.xpath("//*[text()='NO THANKS']");
    By logo = By.cssSelector(".img-responsive.logo");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void ignoreNewsletterPopupIfAppeared() {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newsLetter));
//        if(driver.findElements(newsLetter).size()>0){
            driver.findElement(noThanks).click();
//        }
    }

    public void clickRSLogo(){
        driver.findElement(logo).click();
    }
}
