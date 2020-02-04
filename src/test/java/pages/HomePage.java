package pages;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends GenericPage {

    private static final String SEARCH_INPUT = "#searchIdentifier";
    private static final String SEARCH_BUTTON = "a.govuk-button";
    private static final String LOG_OUT_LINK = "#navigation>li:last-of-type>a";
    private static final String LOG_OUT_LINK_IN_HAMBURGER_MENU = "#menuLinks>a:last-of-type";
    private static final String HAMBURGER_MENU = "a.icon";
    private static String homePageUrl = null;

    public void inputVehicleIdentifier(String arg0) {
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(SEARCH_INPUT)));
        findElementByCss(SEARCH_INPUT).sendKeys(arg0);
    }

    public void searchVehicle() {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(SEARCH_BUTTON)));
        findElementByCss(SEARCH_BUTTON).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("#test-change-btn")));
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                textToBePresentInElement(getDriver().findElement(By.cssSelector("#test-change-btn")), "Change technical record"));
    }

    public void elementWithIdShouldBePresent(String id) {
        Assert.assertNotNull(findElementById(id));
    }

    public void goBackToSearchPage() {
        getDriver().get(getDriver().getCurrentUrl().substring(0, getDriver().getCurrentUrl().lastIndexOf("/")) + "/index.html");
    }

    public void searchVehicleIncorrectIdentifier() {
        findElementByCss(SEARCH_BUTTON).click();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("span#name-error")));
    }

    public void clearInput(String cssSelector) {
        findElementByCss(cssSelector).clear();
    }

    public void clearSearchInput() {
        clearInput(SEARCH_INPUT);
    }

    public void navigateAwayFromVtmAndGoBack() {
        if (getDriver().getCurrentUrl().contains("localhost")) {
            homePageUrl = getDriver().getCurrentUrl();
        }
        else {
            int pos = StringUtils.ordinalIndexOf(getDriver().getCurrentUrl(), "/", 4);
            homePageUrl = getDriver().getCurrentUrl().substring(0, pos) + "/index.html";
        }
        getDriver().get("https://www.gov.uk/government/organisations/driver-and-vehicle-standards-agency");
        waitForTextToAppear("Driver and Vehicle Standards Agency");
        getDriver().get(homePageUrl);
    }

    public void logoutFromVtmApp() {
        if (findElementByCss(LOG_OUT_LINK).isDisplayed()) {
            findElementByCss(LOG_OUT_LINK).click();
        }
        else {
            findElementByCss(HAMBURGER_MENU).click();
            new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOG_OUT_LINK_IN_HAMBURGER_MENU)));
            findElementByCss(LOG_OUT_LINK_IN_HAMBURGER_MENU).click();
        }
    }
}
