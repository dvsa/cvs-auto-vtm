package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage extends PageObject{

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

    public void waitUntilISeeErrorMessage(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span#name-error")));
        new WebDriverWait(getDriver(), 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span#name-error"), text));
    }
}
