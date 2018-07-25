package lesson7;

import driver.get.User;
import js.JSActions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        String searchString = "Ukraine";
        searchInput.sendKeys(searchString);

        WebElement element = driver.findElement(By.cssSelector("[type='submit']"));
        jsActions.scrollToElement(element);
        jsActions.higlightRed(element);
        jsActions.setText("testsggsgs",searchInput);
        element.click();
        User customer = User.CUSTOMER;

        assertEquals(searchString, driver.findElement(By.id("firstHeading")).getText(),
                "Wrong title");

    }
}
