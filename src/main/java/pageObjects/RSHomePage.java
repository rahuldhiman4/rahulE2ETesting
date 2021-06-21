package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RSHomePage {
    public WebDriver driver;
    By login = By.xpath("//a[@class='theme-btn']/../following-sibling::div/a");
    By courses = By.xpath("//a[normalize-space()='Courses']");
    By learningPathTab = By.xpath(("//a[@class='new-navbar-highlighter'][normalize-space()='Learning paths']"));


    public RSHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginIcon(){
        driver.findElement(login).click();
    }

    public void clickCourseTab(){
        driver.findElement(courses).click();
    }

    public void clickLearningPathTab(){
        driver.findElement(learningPathTab).click();
    }
}
