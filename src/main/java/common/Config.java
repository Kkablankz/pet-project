package common;

public class Config {
    /**
     * Specify the browser platform for test:
     * CHROME
     * MOZILLA
     */
    public static final String BROWSER_AND_PLATFORM = "chrome";
    /**Clean browser cookies after each iteration*/
    public static final boolean CLEAR_COOKIES = false;
    /**To keep the browser open after all scenario*/
    public static final boolean HOLD_BROWSER_OPEN = false;
    /**Clear screenshots before starting build*/
    public static final boolean CLEAR_REPORT_DIRECTORY = true;
}
