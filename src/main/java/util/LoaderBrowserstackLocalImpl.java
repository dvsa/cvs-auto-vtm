package util;

import exceptions.AutomationException;
import io.restassured.response.Response;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.backend.GenericData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class LoaderBrowserstackLocalImpl implements Loader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";

    static {
        try {

            properties = new Properties();
            properties.load(Objects.requireNonNull(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AutomationException("Could not load environment setup");
        }
    }

    public static String getUsername() {
        return properties.getProperty("browserstack.username");
    }

    public static String getPassword() {
        return properties.getProperty("browserstack.password");
    }

    @Override
    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        Response response = given().auth().basic(getUsername(), getPassword())
                .get("https://api.browserstack.com/automate/browsers.json");
        String supportedVersions = "";
        if (properties.getProperty("browserstack.browser.version").toLowerCase().equals("latest")) {
            supportedVersions = GenericData.extractJsonArrayValueFromJsonString(response.asString(),
                    "$[?(@.os=='" + properties.getProperty("browserstack.os") + "' && " +
                            "@.os_version=='" + properties.getProperty("browserstack.os.version") + "' && " +
                            "@.browser=='" + properties.getProperty("browserstack.browser").toLowerCase() + "' && " +
                            "@.browser_version=~/^((?!beta).)*$/i)]").toString();
            String latestSupportedVersion = GenericData.extractStringValueFromJsonString
                    (supportedVersions, "$[-1].browser_version");
            caps.setCapability("browser_version", latestSupportedVersion);
        }
        else {
            caps.setCapability("browser_version", properties.getProperty("browserstack.browser.version"));
        }
        caps.setCapability("os", properties.getProperty("browserstack.os"));
        caps.setCapability("os_version", properties.getProperty("browserstack.os.version"));
        caps.setCapability("resolution", "2048x1536");
        caps.setCapability("browser", properties.getProperty("browserstack.browser"));
        caps.setCapability("browserstack.local", properties.getProperty("browserstack.local"));
        caps.setCapability("browserstack.selenium_version", properties.getProperty("browserstack.selenium.version"));
        caps.setCapability("name", properties.getProperty("local.name"));
        caps.setCapability("browserstack.video", "true");
        caps.setCapability("browserstack.idleTimeout", "300");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.debug", "true");
        return caps;

    }

    @Override
    public URL loadUrl() throws MalformedURLException {
        return new URL("http://" + getUsername() + ":" + getPassword() + "@" + properties.getProperty("browserstack.hostname") + "/wd/hub");
    }
}
