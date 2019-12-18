package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.core.environment.WebDriverConfiguredEnvironment.getEnvironmentVariables;

public class HomePage extends GenericPage {

    private static final String SEARCH_INPUT = "#searchIdentifier";
    private static final String SEARCH_BUTTON = "a.govuk-button";

    public void inputVehicleIdentifier(String arg0) {
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(SEARCH_INPUT)));
        findElementByCss(SEARCH_INPUT).sendKeys(arg0);
    }

    public void searchVehicle() {
        findElementByCss(SEARCH_BUTTON).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("h1.title")));
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                textToBePresentInElement(getDriver().findElement(By.cssSelector("h1.title")), "Technical record"));
    }

    public void elementWithIdShouldBePresent(String id) {
        Assert.assertNotNull(findElementById(id));
    }

    public void goBackToSearchPage() {
        getDriver().get(getEnvironmentVariables().getProperty("webdriver.base.url"));
    }
}
