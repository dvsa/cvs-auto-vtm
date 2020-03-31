package util;

import exceptions.AutomationException;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

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
        caps.setCapability("os", properties.getProperty("browserstack.os"));
        caps.setCapability("os_version", properties.getProperty("browserstack.os.version"));
        caps.setCapability("resolution", "2048x1536");
        caps.setCapability("browser", properties.getProperty("browserstack.browser"));
        caps.setCapability("browser_version", properties.getProperty("browserstack.browser.version"));
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
