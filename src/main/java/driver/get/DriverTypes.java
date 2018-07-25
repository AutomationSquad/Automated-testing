package driver.get;


public enum DriverTypes {
    IPHONE("iphone"),
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    EDGE("edge"),
    PHANTOMJS("phantom"),
    OPERA("opera");

    public final String name;

    DriverTypes(String name) {
        this.name = name;
    }

    public static DriverTypes getByName(String name) {
        switch (name.toLowerCase()) {
            case "iphone":
                return IPHONE;
            case "chrome":
                return CHROME;
            case "firefox":
                return FIREFOX;
            case "ie":
            case "internetexplorer":
                return IE;
            case "edge":
                return EDGE;
            case "phantom":
            case "phantomjs":
                return PHANTOMJS;
            case "opera":
                return OPERA;
            default:
                throw new RuntimeException("Unknown driver: " + name);
        }
    }

}