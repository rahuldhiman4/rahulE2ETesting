package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    public WebDriver driver;

    By search = By.cssSelector("#search-courses");
    By searchBtn = By.cssSelector("#search-course-button");
    By coursesListed = By.cssSelector(".course-list .course-listing");
    By userName = By.cssSelector(".navbar-current-user");
    By logout = By.cssSelector(".dropdown-menu .user-signout");


    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String product){
        driver.findElement(search).clear();
        driver.findElement(search).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public int numberOfCoursesSearched(){
        return driver.findElements(coursesListed).size();
    }

    public void logout(){
        driver.findElement(userName).click();
        driver.findElement(logout).click();
    }


}
