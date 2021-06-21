package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearningPathPage {
    public WebDriver driver;

    By javascript = By.xpath("//*[@data-id='javascript']");
    By python = By.xpath("//*[@data-id='python']");
    By javaBy = By.xpath("//*[@data-id='java']");
    By title = By.cssSelector(".inner-box h1");

    public LearningPathPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickJavaScriptToggle(){
        driver.findElement(javascript).click();
    }

    public void clickPythonToggle(){
        driver.findElement(python).click();
    }

    public void clickJavaToggle(){
        driver.findElement(javaBy).click();
    }

    public String getPageHeading(){
        return driver.findElement(title).getText();
    }


}
