package lesson7;

import driver.WebDriverFactory;
import driver.get.DriverTypes;
import js.JSActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected JSActions jsActions;

    @BeforeEach
    public void prepare() {
        driver = WebDriverFactory.getDriver("firefox");
//        driver = WebDriverFactory.getDriver("chrome");
//        driver = WebDriverFactory.getDriver(DriverTypes.CHROME);
        jsActions = new JSActions(driver);

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
//        Set<Cookie> cookies = driver.manage().getCookies();

//        Set<String> availableLogTypes = driver.manage().logs().getAvailableLogTypes();
//        driver.manage().logs().get(availableLogTypes.toArray()[0].toString());

    }

    public WebDriverWait getElementWait(){
        return new WebDriverWait(driver, 10);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

//<iframe style="width: 629px; height: 100%;" frameborder="0" aria-describedby="cke_70" title="Rich text editor, productDescription_en" src="" tabindex="-1" allowtransparency="true"></iframe>