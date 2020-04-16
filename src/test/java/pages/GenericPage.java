package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.List;

import static java.time.Duration.ofMillis;

public class GenericPage extends PageObject {

    static final String SPINNER = "div.spinner-container";
    static final String HEADER_ERROR = "div.govuk-error-summary";
    static final String HEADER_SPECIFIC_ERRORS = "div.govuk-error-summary>span.govuk-error-message";
    static final String SIGNOUT_CONFIRMATION_SCREEN = "vtm-logout-modal";

    public void checkTextInElementWithCssSelector(String cssSelector, String text) {
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));

    }

    public void checkTextInElementWithXpath(String xpath, String text) {
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    public void checkTextIsPresentInPage(String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body"), text));
    }

    public void checkTextIsNotPresentInPage(String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.not(ExpectedConditions.
                textToBePresentInElementLocated(By.cssSelector("body"), text)));
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

    public void clearSession() {
        ThucydidesWebDriverSupport.getDriver().manage().deleteAllCookies();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("localStorage.removeItem('adal.access.token.key54d151b6-2ca8-4018-8c70-f9ee600d91c7');");
        jsExecutor.executeScript("localStorage.removeItem('adal.expiration.key54d151b6-2ca8-4018-8c70-f9ee600d91c7');");
        jsExecutor.executeScript("localStorage.removeItem('adal.token.renew.status54d151b6-2ca8-4018-8c70-f9ee600d91c7');");
        jsExecutor.executeScript("localStorage.removeItem('adal.error');");
        jsExecutor.executeScript("localStorage.removeItem('adal.error.description');");
        jsExecutor.executeScript("localStorage.removeItem('adal.idtoken');");
        jsExecutor.executeScript("localStorage.removeItem('adal.login.error');");
        jsExecutor.executeScript("localStorage.removeItem('adal.login.request');");
        jsExecutor.executeScript("localStorage.removeItem('adal.nonce.idtoken');");
        jsExecutor.executeScript("localStorage.removeItem('adal.session.state');");
        jsExecutor.executeScript("localStorage.removeItem('adal.state.login');");
        jsExecutor.executeScript("localStorage.removeItem('adal.token.keys');");
        jsExecutor.executeScript("localStorage.removeItem('adal.token.renew.status');");
        getDriver().get("https://login.microsoftonline.com/dvsagov.onmicrosoft.com/oauth2/logout");
        try
        {
            getDriver().switchTo().alert().accept();
        }   // try
        catch (NoAlertPresentException Ex)
        {
            System.out.println("No alerts present");
        }
        ThucydidesWebDriverSupport.clearSession();
    }

    protected WebElement findElementById(String id) {
        System.out.println("Searching for element: " + id);
        return getDriver().findElement(By.id(id));
    }

    protected WebElement findElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    protected WebElement findElementByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        return getDriver().findElement(By.xpath(xpath));
    }
    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected WebElement findElementByText(String text) {
        System.out.println("Finding element with text: " + text);
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    protected WebElement findElementByCss(String css) {
        System.out.println("Finding element: " + css);
        return getDriver().findElement(By.cssSelector(css));
    }

    protected void scrollToAndClickByCss(String css) {
        System.out.println("Finding element: " + css);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByCss(css));
        actions.perform();
        getDriver().findElement(By.cssSelector(css)).click();
    }

    protected void scrollToAndClickByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByXpath(xpath));
        actions.perform();
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void selectCheckbox(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")));
        if (!(getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).isSelected())) {
            getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).click();
        }
    }

    public void deselectCheckbox(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")));
        if (getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).isSelected()) {
            getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).click();
        }
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void clearSessionStorage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.sessionStorage.clear()");
    }

    public void elementWithIdShouldBePresent(String id) {
        waitForRenderedElementsToBePresent(By.id(id));
    }

    public void navigateAwayFromVtmAndGoBack() {
        String homePageUrl = null;
        if (getDriver().getCurrentUrl().contains("localhost")) {
            homePageUrl = getDriver().getCurrentUrl();
        }
        else {
            int pos = StringUtils.ordinalIndexOf(getDriver().getCurrentUrl(), "/", 4);
            if (pos != -1) {
                homePageUrl = getDriver().getCurrentUrl().substring(0, pos) + "/index.html";
            }
            else {
                homePageUrl = getDriver().getCurrentUrl() + "index.html";
            }
        }
        getDriver().get("https://www.gov.uk/government/organisations/driver-and-vehicle-standards-agency");
        waitForTextToAppear("Driver and Vehicle Standards Agency");
        getDriver().get(homePageUrl);
    }

    public void checkTextIsPresentInHyperlink(String text) {
        Assert.assertNotNull("Hyperlink with text was not found!", getDriver().findElement(By.xpath(
                "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]")));
    }

    public void checkTextIsPresentInButton(String text) {
        Assert.assertNotNull("Button with text was not found!", getDriver().findElement(By.xpath(
                "//button[contains(text(),'" + text + "')]")));
    }

    public void clickButton(String text) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(text(),'" + text + "')]")));
        findElementByXpath("//button[contains(text(),'" + text + "')]").click();
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
        waitForAngularRequestsToFinish();
    }

    public void clickLink(String text) {
        String locator = "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]";
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        findElementByXpath(locator).click();
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
    }


    void selectOptionFromDropdown(WebElement element, String searchCriteria) {
        new Select(element).selectByValue(searchCriteria);
    }

    public void headerErrorContains(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(HEADER_ERROR), text));
    }

    public void headerErrorNotContains(String text) {
        waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_SPECIFIC_ERRORS)));
        Assert.assertFalse(findElementByCss(HEADER_SPECIFIC_ERRORS).getText().contains(text));
    }

    public void goBackToPreviousPage() {
        getDriver().navigate().back();
    }

    public void checkPageUrl(String url) {
        Assert.assertEquals(url, getDriver().getCurrentUrl());
    }

    public void checkSignOutScreenNotPresent() {
        Assert.assertEquals(0, getDriver().findElements(By.cssSelector(SIGNOUT_CONFIRMATION_SCREEN)).size());
    }

    FluentWait globalFluentWait(int timeOutSeconds, int pollingEveryMilliseconds) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(ofMillis(pollingEveryMilliseconds))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        return wait;
    }
}
