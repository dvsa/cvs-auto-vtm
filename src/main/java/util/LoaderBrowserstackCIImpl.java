package util;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoaderBrowserstackCIImpl implements Loader {

    private final static String username = System.getProperty("BROWSERSTACK_USERNAME");
    private final static String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY");
    private final static String browserstackLocal = System.getProperty("BROWSERSTACK_LOCAL");
    private final static String browserstackBrowser = System.getProperty("BROWSERSTACK_BROWSER");
    private final static String browserstackBrowserVersion = System.getProperty("BROWSERSTACK_BROWSER_VERSION");
    private final static String browserstackSeleniumVersion = System.getProperty("BROWSERSTACK_SELENIUM_VERSION");


    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", browserstackBrowser);
        caps.setCapability("browser_version", browserstackBrowserVersion);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.selenium_version", browserstackSeleniumVersion);
        caps.setCapability("browserstack.video", "false");
        caps.setCapability("browserstack.timezone", "UTC");
        caps.setCapability("browserstack.idleTimeout", "300");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.console", "verbose");
        return caps;
    }


    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL("http://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
    }
}
