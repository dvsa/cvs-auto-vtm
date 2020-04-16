package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends GenericPage {

    private static final String SEARCH_INPUT = "#searchIdentifier";
    private static final String SEARCH_BUTTON = "a.govuk-button";
    private static final String LOG_OUT_LINK = "#navigation>li:last-of-type>a";
    private static final String SEARCH_OPTIONS_DROPDOWN = "#test-search-criteria";
    private static final String LOG_OUT_LINK_IN_HAMBURGER_MENU = "#menuLinks>a:last-of-type";
    private static final String SPECIFIC_ERROR = "#name-error>div";

    private static final String HAMBURGER_MENU = "a.icon";

    public void inputVehicleIdentifier(String identifier) {
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(SEARCH_INPUT)));
        findElementByCss(SEARCH_INPUT).sendKeys(identifier);
    }

    public void searchVehicle() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEARCH_BUTTON)));
        findElementByCss(SEARCH_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#test-change-btn")));
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.cssSelector("#test-change-btn")), "Change technical record"));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        waitForAngularRequestsToFinish();
    }

    public void searchVehicles() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEARCH_BUTTON)));
        findElementByCss(SEARCH_BUTTON).click();
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        waitForAngularRequestsToFinish();
    }

    public void searchVehicleCorrectIdentifier() {
        findElementByCss(SEARCH_BUTTON).click();
    }

    public void searchVehicleIncorrectIdentifier() {
        findElementByCss(SEARCH_BUTTON).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(SPECIFIC_ERROR)));
    }

    public void waitUntilISeeSearchErrorMessage(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span#name-error")));
        new WebDriverWait(getDriver(), 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span#name-error"), text));
    }

    public void clearInput(String cssSelector) {
        findElementByCss(cssSelector).clear();
    }

    public void clearSearchInput() {
        clearInput(SEARCH_INPUT);
    }

    public void optionShouldBeSelected(String searchCriteria) {
        Select selectSearchCriteria = new Select(findElementByCss(SEARCH_OPTIONS_DROPDOWN));
        Assert.assertEquals(selectSearchCriteria.getFirstSelectedOption().getAttribute("value"), searchCriteria);
    }

    public void otherSearchCriteriaInclude(String searchCriteria) {
        Assert.assertNotNull(findElementByCss(SEARCH_OPTIONS_DROPDOWN + ">option[value='" + searchCriteria + "']"));
    }

    public void selectSearchCriteria(String searchCriteria) {
        selectOptionFromDropdown(findElementByCss(SEARCH_OPTIONS_DROPDOWN), searchCriteria);
    }

    public void specificErrorContains(String text) {
        if (text.contains("\\n")) {
            Assert.assertTrue(findElementByCss(SPECIFIC_ERROR).getText().contains(text.replace("\\n","\n")));
        }
        else {
            Assert.assertTrue(findElementByCss(SPECIFIC_ERROR).getText().contains(text));
        }
    }
}
