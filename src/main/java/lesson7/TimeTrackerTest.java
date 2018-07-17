package lesson7;

import org.openqa.selenium.By;

public class TimeTrackerTest extends BaseTest {

    public void test(){
        driver.get("https://qa.reports.spd-ukraine.com/");

        driver.findElement(By.name("username")).sendKeys("e.voloshyn@spd-ukraine.com");
        driver.findElement(By.name("password")).sendKeys("JMSgzZVz");

        driver.findElement(By.cssSelector("[role='submit']")).click();

    }
}
