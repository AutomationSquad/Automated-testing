package driver.get;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static driver.get.PlatformType.X32;
import static java.lang.System.getProperty;
import static java.util.regex.Pattern.compile;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.ie.InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR;
import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;
import static org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT;

public class DriverData {
    public static final String PROJECT_PATH = path("");
    public static Properties properties = readProperties();
    public static String SRC_PATH = mergePath(PROJECT_PATH, "main");
    public static String TEST_PATH = mergePath(PROJECT_PATH, "test");
    public static String LOGS_PATH = mergePath(TEST_PATH, ".logs");
    public static String DRIVERS_FOLDER = mergePath(SRC_PATH, "resources", "drivers");
    public static String DOWNLOADS_DIR = mergePath(TEST_PATH, "resources", "downloads");
    public static PageLoadStrategy PAGE_LOAD_STRATEGY = NORMAL;
    public static String BROWSER_SIZE = properties.getProperty("browser.size","MAXIMIZE");
    public static final String DRIVER_NAME = properties.getProperty("driver");
    public static String DRIVER_VERSION = "LATEST";
    public static PlatformType PLATFORM_TYPE = X32;
    // GET DRIVER
    public static FirefoxOptions FIREFOX_OPTIONS () {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xls;text/csv;text/plain");
        firefoxProfile.setPreference("browser.download.dir", DOWNLOADS_DIR);
        firefoxProfile.setPreference("print.always_print_silent", "true");
        firefoxProfile.setPreference("print.show_print_progress", "false");
        firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        firefoxProfile.setPreference("network.http.phishy-userpass-length", 255);
        FirefoxOptions cap = new FirefoxOptions();
        cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY);
        cap.setCapability(ACCEPT_SSL_CERTS, true);
        cap.addArguments(getBrowserSizeOption());
        cap.setProfile(firefoxProfile);
        return cap;
    };
    public static ChromeOptions CHROME_OPTIONS() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("download.default_directory", DOWNLOADS_DIR);
        chromePrefs.put("profile.default_content_setting_values.notifications", 0);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.password_manager_enabled", false);
        ChromeOptions cap = new ChromeOptions();
        cap.addArguments("--disable-web-security", "--disable-extensions", "test-type");
        cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY);
        cap.setCapability(ACCEPT_SSL_CERTS, true);
        cap.addArguments(getBrowserSizeOption());
        cap.setExperimentalOption("prefs", chromePrefs);
        return cap;
    };
    public static DesiredCapabilities CHROME_OPTIONS(String deviseName) {
        DesiredCapabilities capabilities =  DesiredCapabilities.iphone();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviseName);
        Map<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setBrowserName("chrome");
        return capabilities;
    }
    public static InternetExplorerOptions IE_OPTIONS() {
        InternetExplorerOptions cap = new InternetExplorerOptions();
        cap.introduceFlakinessByIgnoringSecurityDomains();
        cap.ignoreZoomSettings();
        //cap.setCapability("requireWindowFocus", true);
        cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY);
        cap.takeFullPageScreenshot();
        cap.setCapability(ACCEPT_SSL_CERTS, true);
        cap.destructivelyEnsureCleanSession();
        cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, true);
        cap.is(SUPPORTS_JAVASCRIPT);
        return cap;
    };

    public static String chromeDriverPath() {
        return mergePath(DRIVERS_FOLDER,
                getOs() == Platform.WINDOWS ? "chromedriver.exe" : "chromedriver");
    }

    public static String ieDriverPath() {
        return mergePath(DRIVERS_FOLDER,
                "IEDriverServer.exe");
    }

    public static String edgeDriverPath() {
        return mergePath(DRIVERS_FOLDER,
                "MicrosoftWebDriver.exe");
    }

    public static String operaDriverPath() {
        return mergePath(DRIVERS_FOLDER,
                getOs() == Platform.WINDOWS ? "operadriver.exe" : "operadriver");
    }

    public static String phantomDriverPath() {
        return mergePath(DRIVERS_FOLDER,
                getOs() == Platform.WINDOWS ? "phantomjs.exe" : "phantomjs");
    }

    public static String firefoxDriverPath() {
        return mergePath(DRIVERS_FOLDER,
                getOs() == Platform.WINDOWS ? "geckodriver.exe" : "geckodriver");
    }

    public static Platform getOs() {
        String osName = getProperty("osName","win10").toLowerCase();
        if (!osName.isEmpty()){
            return Platform.fromString(osName).family();
        }
        return Platform.getCurrent();
    }

    private static String getBrowserSizeOption() {
        List<String> groups = matches(BROWSER_SIZE, "([0-9]+)[^0-9]*([0-9]+)");
        return groups.size() == 2
                ? "--window-size=" + groups.get(0) + "," + groups.get(1)
                : "--start-maximized";
    }

    private static List<String> matches(String str, String regEx) {
        List<String> result = new ArrayList<>();
        Pattern pattern = compile(regEx);
        Matcher m = pattern.matcher(str);
        if (m.matches()) {
            for (int i = 1; i <= m.groupCount(); i++)
                result.add(m.group(i));
        }
        return result;
    }

    private static String path(String first, String... more) {
        return Paths.get(first, more).toAbsolutePath().toString();
    }

    private static String mergePath(String path, String... suffix) {
        return path + String.join(File.separator, suffix);
    }

    private static Properties readProperties() {
        properties = new Properties();
        try(InputStream inputStream = System.class.getResourceAsStream("/gradle.properties")){
            properties.load(inputStream);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return properties;
    }
}
