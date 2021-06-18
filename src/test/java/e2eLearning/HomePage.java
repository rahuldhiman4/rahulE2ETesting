package e2eLearning;

import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends TestBase
{
    @Test
    public void basePageNavigation() throws IOException, InterruptedException {
        driver = initilizeDriver();
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }
}
