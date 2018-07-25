package driver;


import driver.get.DriverTypes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static driver.get.DownloadDriverManager.downloadDriver;
import static driver.get.DriverData.*;
import static driver.get.DriverTypes.*;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static java.util.Objects.nonNull;

public class WebDriverFactory {
    private static Map<String, WebDriver> runDrivers = new HashMap<>();
    public static final String HUB_URL = getProperty("hub.url");
    private WebDriverFactory() {
    }

    public static boolean hasRunDrivers() {
        return runDrivers != null && runDrivers.size()>0;
    }

    private static WebDriver initDriver(DriverTypes type) throws MalformedURLException {
        WebDriver driver;
        switch (type) {
            case CHROME:
                if (null != HUB_URL && !HUB_URL.trim().isEmpty()){
                    URL url = new URL(HUB_URL);
                    driver = new RemoteWebDriver(url,CHROME_OPTIONS());
                    break;
                }
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.chrome.driver", chromeDriverPath());
                else
                    downloadDriver(CHROME, PLATFORM_TYPE, DRIVER_VERSION);
                driver = new ChromeDriver(CHROME_OPTIONS());
                break;
            case IPHONE:
                if (null != HUB_URL && !HUB_URL.trim().isEmpty()){
                    URL url = new URL(HUB_URL);
                    driver = new RemoteWebDriver(url,CHROME_OPTIONS("iPhone X"));
                    break;
                }
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.chrome.driver", chromeDriverPath());
                else
                    downloadDriver(CHROME, PLATFORM_TYPE, DRIVER_VERSION);
                driver = new ChromeDriver(CHROME_OPTIONS("iPhone X"));
                break;
            case FIREFOX:
                if (null != HUB_URL && !HUB_URL.trim().isEmpty()){
                    URL url = new URL(HUB_URL);
                    driver = new RemoteWebDriver(url,FIREFOX_OPTIONS());
                    break;
                }
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.gecko.driver", firefoxDriverPath());
                else
                    downloadDriver(FIREFOX, PLATFORM_TYPE, DRIVER_VERSION);
                driver = new FirefoxDriver(FIREFOX_OPTIONS());
                break;
            case IE:
                if (null != HUB_URL && !HUB_URL.trim().isEmpty()){
                    URL url = new URL(HUB_URL);
                    driver = new RemoteWebDriver(url,IE_OPTIONS());
                    break;
                }
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.ie.driver", ieDriverPath());
                else
                    downloadDriver(IE, PLATFORM_TYPE, DRIVER_VERSION);
                driver = new InternetExplorerDriver(IE_OPTIONS());
                break;
            case EDGE:
                // TODO
                driver = new EdgeDriver(new EdgeOptions());
                break;
            default:
                throw new RuntimeException("Unknown driver: " + type);
        }
        return driver;
    }

    public static void jsExecute(String script, Object... args) {
        ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public static WebDriver getDriver() {
        try {
            if (!DRIVER_NAME.equals(""))
                return getDriver(DRIVER_NAME);
            return getDriver(CHROME.name);
        } catch (Exception ex) {
            throw new RuntimeException("Can't get WebDriver. \n"  + ex.getMessage());
        }
    }

    public static WebDriver getDriver(String driverName) {
        if (hasRunDrivers())
            return runDrivers.get(driverName);
        try {
            return initDriver(DriverTypes.getByName(driverName));
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Can't get WebDriver. \n"  + ex.getMessage());
        }
    }

    public static WebDriver getDriver(DriverTypes driverType) {
        if (hasRunDrivers())
            return runDrivers.get(driverType.name);
        try {
            return initDriver(driverType);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Can't get WebDriver. \n"  + ex.getMessage());
        }
    }

    public static JavascriptExecutor getJSExecutor() {
        if (getDriver() instanceof JavascriptExecutor)
            return (JavascriptExecutor) getDriver();
        else
            throw new ClassCastException("JavaScript Executor doesn't support");
    }

    public static void close() {
        if (nonNull(runDrivers)) {
            for (Map.Entry<String, WebDriver> pair : runDrivers.entrySet()) {
                pair.getValue().quit();
            }
            runDrivers.clear();
        } else {
            throw new RuntimeException("None Driver has been found for current thread. Probably Fixture configuration is wrong.");
        }
    }

    public static void quit() {
        close();
    }
}