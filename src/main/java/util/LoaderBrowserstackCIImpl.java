package util;

import io.restassured.response.Response;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.backend.GenericData;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class LoaderBrowserstackCIImpl implements Loader {

    private final static String username = System.getenv("BROWSERSTACK_USERNAME");
    private final static String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
    private final static String browserstackBrowser = System.getProperty("BROWSERSTACK_BROWSER");
    private final static String browserstackBrowserVersion = System.getProperty("BROWSERSTACK_BROWSER_VERSION");

    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "2048x1536");
        Response response = given().auth().basic(username, accessKey)
                .get("https://api.browserstack.com/automate/browsers.json");
        String supportedVersions = "";
        if (System.getProperty("BROWSERSTACK_BROWSER_VERSION").toLowerCase().equals("latest")) {
            supportedVersions = GenericData.extractJsonArrayValueFromJsonString(response.asString(),
                    "$[?(@.os=='Windows' && @.os_version=='10' && " +
                            "@.browser=='" + browserstackBrowser.toLowerCase() +
                            "' && @.browser_version=~/^((?!beta).)*$/i)]").toString();
            String latestSupportedVersion = GenericData.extractStringValueFromJsonString
                    (supportedVersions, "$[-1].browser_version");
            caps.setCapability("browser_version", latestSupportedVersion);
        }
        else {
            caps.setCapability("browser_version", browserstackBrowserVersion);;
        }
        caps.setCapability("browser", browserstackBrowser);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.selenium_version", "3.14.0");
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
