package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class GenericPage extends PageObject{

    private static final String SPINNER = "div.spinner-container";
    private static final String HEADER_ERROR = "div.govuk-error-summary";
    private static final String HEADER_SPECIFIC_ERRORS = "div.govuk-error-summary>span.govuk-error-message";
    private static final String SIGNOUT_CONFIRMATION_SCREEN = "vtm-logout-modal";

    public void checkTextInElementWithCssSelector(String cssSelector, String text) {
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));

    }

    public void checkTextInElementWithXpath(String xpath, String text) {
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    public void checkTextIsPresentInPage(String text) {
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body"), text));
    }

    public void checkTextIsNotPresentInPage(String text) {
        String bodyText = getDriver().findElement(By.tagName("body")).getText();
        Assert.assertFalse("Text was found!", bodyText.contains(text));
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), 15).until(
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

    protected WebElement findElementByCss(String css) {
        System.out.println("Finding element: " + css);
        return getDriver().findElement(By.cssSelector(css));
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

    public void goBackToHomePage() {
        getDriver().get(getDriver().getCurrentUrl().substring(0, getDriver().getCurrentUrl().lastIndexOf("/")));
    }

    public void goBackToSearchPage() {

        getDriver().get(getDriver().getCurrentUrl().substring(0, getDriver().getCurrentUrl().lastIndexOf("/")) + "/search");
    }

    public void goBackToCreatePage() {
        getDriver().get(getDriver().getCurrentUrl().substring(0, getDriver().getCurrentUrl().lastIndexOf("/")) + "/create");
    }

    public void checkTextIsPresentInButton(String text) {
        Assert.assertNotNull("Button with text was not found!", getDriver().findElement(By.xpath(
                "//button[contains(text(),'" + text + "')]")));
    }

    public void clickButton(String text) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(text(),'" + text + "')]")));
        findElementByXpath("//button[contains(text(),'" + text + "')]").click();
        try {
            new WebDriverWait(getDriver(), 1).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
    }

    public void clickLink(String text) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]")));
        findElementByXpath("//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]").click();
        try {
            new WebDriverWait(getDriver(), 1).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
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
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 15).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(HEADER_ERROR), text));
    }

    public void headerErrorNotContains(String text) {
        waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_SPECIFIC_ERRORS)));
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

    public void waitForTextToAppearInPage(String text) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.textToBePresentInElement(findElementByCss("body"), text));
    }
}
