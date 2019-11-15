package util;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoaderBrowserstackCIImpl implements Loader {

    private final static String username = System.getenv("BROWSERSTACK_USERNAME");
    private final static String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
    private final static String browserstackBrowser = System.getenv("BROWSERSTACK_BROWSER");
    private final static String browserstackBrowserVersion = System.getenv("BROWSERSTACK_BROWSER_VERSION");


    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", browserstackBrowser);
        caps.setCapability("browser_version", browserstackBrowserVersion);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.selenium_version", "3.5.2");
        return caps;
    }


    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL("http://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
    }



}
