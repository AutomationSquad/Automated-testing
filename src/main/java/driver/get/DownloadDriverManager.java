package driver.get;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.slf4j.Logger;

import static driver.get.DriverData.getOs;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class DownloadDriverManager {
    public static boolean DOWNLOAD_DRIVER = true;
    static final Logger logger = getLogger(lookup().lookupClass());

    private static boolean hasVersion(String version) {
        char c = version.charAt(0);
        return (c >= '0' && c <= '9');
    }

    public static void downloadDriver(DriverTypes driverType,
                                      PlatformType platformType, String version) {
        WebDriverManager wdm;
        try {
            String driverName = driverType.toString();
            switch (driverType) {
                case CHROME:
                    wdm = WebDriverManager.chromedriver();
                    break;
                case FIREFOX:
                    wdm = WebDriverManager.firefoxdriver();
                    break;
                case IE:
                    wdm = WebDriverManager.iedriver();
                    break;
                case EDGE:
                    wdm = WebDriverManager.edgedriver();
                    break;
                case PHANTOMJS:
                    wdm = WebDriverManager.phantomjs();
                    break;
                case OPERA:
                    wdm = WebDriverManager.operadriver();
                    break;
                default:
                    throw new RuntimeException("Unknown driver: " + driverType);
            }
            if (getOs() == Platform.WINDOWS) {
                switch (platformType) {
                    case X32:
                        wdm = wdm.arch32();
                        break;
                    case X64:
                        wdm = wdm.arch64();
                        break;
                }
                driverName += " " + platformType;
            }
            if (hasVersion(version)) {
                wdm = wdm.version(version);
                driverName += " " + version;
            }
            wdm.setup();
            logger.info("Download driver: " + driverName);
        } catch (Exception ex) {
            throw new RuntimeException("Can't download latest driver for " + driverType
                    + ". Exception " + ex.getMessage());
        }
    }
}
