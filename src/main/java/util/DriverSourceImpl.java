package util;

import exceptions.AutomationException;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSourceImpl implements DriverSource {


    @Override
    public WebDriver newDriver() {

        WebDriver webDriver = null;
        EnvironmentType envType = TypeLoader.getType();

        switch (envType) {
            case CI_BROWSERSTACK:
                webDriver = setupWebDriver(new LoaderBrowserstackCIImpl());
                break;
            case LOCAL_BROWSERSTACK:
                webDriver = setupWebDriver(new LoaderBrowserstackLocalImpl());
                break;
            default:
                throw new AutomationException("Environment configuration not found");

        }

        return webDriver;

    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }

    private WebDriver setupWebDriver(Loader loader) {
        DesiredCapabilities caps = getDesireCapByImpl(loader);
        return new RemoteWebDriver(getUrl(loader), caps);
    }


    private DesiredCapabilities getDesireCapByImpl(Loader loader) {
        return loader.loadCapabilities();
    }

    private URL getUrl(Loader loader) {

        URL url = null;
        try {
            url = loader.loadUrl();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
