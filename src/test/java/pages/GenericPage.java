package pages;

import exceptions.AutomationException;
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
import util.TypeLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static java.time.Duration.ofMillis;

public class GenericPage extends PageObject {

    static final String SPINNER = "div.spinner-container";
    static final String HEADER_ERROR = "div.govuk-error-summary";
    static final String HEADER_SPECIFIC_ERRORS = "div.govuk-error-summary>span.govuk-error-message";
    static final String SIGNOUT_CONFIRMATION_SCREEN = "vtm-logout-modal";

    public void checkTextInElementWithCssSelector(String cssSelector, String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));

    }

    public void checkTextInElementWithXpath(String xpath, String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    public void checkTextIsPresentInPage(String text) {
        FluentWait wait = globalFluentWait(30, 200);
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
        Assert.assertNotNull("Hyperlink with text '" + text + "' was not found!", getDriver().findElement(By.xpath(
                "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]")));
    }

    public void checkTextIsPresentInHyperlinkInElement(String text, String locator) {
        String selector = "//" + locator + "//a[contains(text(),'" + text + "')] | //" + locator + "//a/span[contains(text(),'" + text + "')]";
        Assert.assertNotNull("Hyperlink with text '" + text + "' was not found in element with locator '" + locator +
                "'!", getDriver().findElement(By.xpath(selector)));
    }

    public void checkTextIsPresentInButton(String text) {
        Assert.assertNotNull("Button with text '" + text + "' was not found!", getDriver().findElement(By.xpath(
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
        waitForAngular();
    }

    protected void waitForAngular() {
        try {
            waitForAngularRequestsToFinish();
        } catch (Exception e) {
            System.out.println("NgWebDriver.waitForAngularRequestsToFinish() timeout!");
        }

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

    public void clickLinkInElement(String text, String locator) {
        String selector = "//" + locator + "//a[contains(text(),'" + text + "')] | //" + locator + "//a/span[contains(text(),'" + text + "')]";
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
        findElementByXpath(selector).click();
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
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(HEADER_ERROR), text));
    }

    public void headerErrorNotContains(String text) {
        waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(HEADER_SPECIFIC_ERRORS)));
        Assert.assertFalse("Text '" + text + "' was not found in '" + findElementByCss(HEADER_SPECIFIC_ERRORS).getText() + "'",
                findElementByCss(HEADER_SPECIFIC_ERRORS).getText().contains(text));
    }

    public void goBackToPreviousPage() {
        getDriver().navigate().back();
    }

    public void checkPageUrl(String url) {
        Assert.assertEquals("Page url '" + getDriver().getCurrentUrl() + "' is not the expected one '" + url + "'",
                url, getDriver().getCurrentUrl());
    }

    public void checkSignOutScreenNotPresent() {
        Assert.assertEquals("Sign out screen still present!", 0, getDriver().findElements(By.cssSelector(SIGNOUT_CONFIRMATION_SCREEN)).size());
    }

    void inputText(WebElement field, String text) {
        if (text.contentEquals("")) {
            int limit = field.getAttribute("value").length();
            for (int i = 0; i < limit; i++) {
                field.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            field.clear();
            field.sendKeys(text);
        }
    }

    FluentWait globalFluentWait(int timeOutSeconds, int pollingEveryMilliseconds) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(ofMillis(pollingEveryMilliseconds))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        return wait;
    }

    public void checkTextIsPresentInElementWithCssSelector(String cssSelector, String text) {
        WebElement element = findElementByCss(cssSelector);
        Assert.assertTrue("Element with css selector '" + cssSelector + "' has text '" + element.getText().contains(text)
                + "' which does not contain expected text '" + text + "'", element.getText().contains(text));
    }

    public void checkFieldEditable(String field) {
        if (getDriver().findElements(By.id("test-" + field)).size() > 0) {
            WebElement element = getDriver().findElement(By.id("test-" + field));
            Assert.assertNull("Element with id 'test-" + field + "' has the 'disabled' attribute",
                    element.getAttribute("disabled"));
        }
        else {
            if (getDriver().findElements(By.cssSelector("[id^='test-" + field + "'")).size() > 0) {
                List<WebElement> list = getDriver().findElements(By.cssSelector("[id^='test-" + field + "'"));
                for (WebElement element : list) {
                    Assert.assertTrue("Element is not editable",
                            element.getTagName().contentEquals("input") || element.getTagName().contentEquals("select"));
                    Assert.assertNull("Element with id starting with 'test-" + field + "' has the 'disabled' attribute",
                            element.getAttribute("disabled"));
                }
            }
        }
    }

    public void checkFieldNotEditable(String field) {
        if (getDriver().findElement(By.id("test-" + field)).getTagName().contentEquals("input") ||
                getDriver().findElement(By.id("test-" + field)).getTagName().contentEquals("select")) {
            WebElement element = getDriver().findElement(By.id("test-" + field));
            Assert.assertNotNull("Element with id 'test-" + field + "' does not have the 'disabled' attribute",
                    element.getAttribute("disabled"));
        }
        else {
            System.out.println("Element with id 'test-" + field + "' is not editable since it is a <dd> element");
        }
    }

    public void setValueForInputField(String inputField, String value) {
        FluentWait wait = globalFluentWait(10, 300);
        if (inputField.endsWith("-day") || inputField.endsWith("-month") || inputField.endsWith("-year") ||
                inputField.endsWith("-hour") || inputField.endsWith("-minute")) {
            String[] parts = inputField.split("-");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='test-" + parts[0] + "'][id$='-" +
                    parts[parts.length-1] + "']")));
            WebElement element = getDriver().findElement(By.cssSelector("[id^='test-" + parts[0] + "'][id$='-" + parts[parts.length-1] + "']"));
            element.clear();
            element.sendKeys(value);
        }
        else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-" + inputField)));
            WebElement element = getDriver().findElement(By.id("test-" + inputField));
            element.clear();
            element.sendKeys(value);
        }
    }

    public void setValueForRadioButtonField(String radioButtonField, String value) {
        WebElement element = getDriver().findElement(By.xpath("//input[starts-with(@id,'test-" + radioButtonField + "')]" +
                "/following-sibling::label[normalize-space(text())='" + value + "']/preceding-sibling::input"));
        element.click();
    }

    public void setValueForSelectField(String selectField, String value) {
        Select selectElement = new Select(getDriver().findElement(By.id("test-" + selectField)));
        selectElement.selectByVisibleText(value);
    }

    private void setValueForCheckboxField(String checkboxField, String value) {
        if (!(value.toLowerCase().contentEquals("checked")) && !(value.toLowerCase().contentEquals("unchecked"))) {
            throw new AutomationException("Value '" + value + "' is not applicable for checkbox fields");
        }
        WebElement element = getDriver().findElement(By.id("test-" + checkboxField));
        if (value.toLowerCase().contentEquals("checked")) {
            if (element.getAttribute("value").contentEquals("false")) {
                element.click();
            }
        }
        else {
            if (element.getAttribute("value").contentEquals("true")) {
                element.click();
            }
        }
    }

    public void checkValueForInputField(String inputField, String value) {
        if (inputField.endsWith("-day") || inputField.endsWith("-month") || inputField.endsWith("-year") ||
                inputField.endsWith("-hour") || inputField.endsWith("-minute")) {
            String[] parts = inputField.split("-");
            WebElement element = getDriver().findElement(By.cssSelector("[id^='test-" + parts[0] + "'][id$='-" + parts[parts.length-1] + "']"));
            Assert.assertEquals("Value in element with id starting with 'test-" + parts[0] + "' and ending with '-"
                    + parts[parts.length-1] + "' is '" +
                    element.getAttribute("value") + "' instead of '" + value + "'", value, element.getAttribute("value"));
        }
        else {
            WebElement element = getDriver().findElement(By.id("test-" + inputField));
            Assert.assertEquals("Value in element with id 'test-" + inputField + "' is '" +
                    element.getAttribute("value") + "' instead of '" + value + "'", value, element.getAttribute("value"));
        }
    }

    public void checkValueForCheckboxField(String checkboxField, String value) {
        if (!(value.toLowerCase().contentEquals("checked")) && !(value.toLowerCase().contentEquals("unchecked"))) {
            throw new AutomationException("Value '" + value + "' is not applicable for checkbox fields");
        }
        WebElement element = getDriver().findElement(By.id("test-" + checkboxField));
        if (value.toLowerCase().contentEquals("checked")) {
            Assert.assertEquals("Value in element with id 'test-" + checkboxField + "' is '" +
                    element.getAttribute("value") + "' instead of 'true'", "true", element.getAttribute("value"));
            if (element.getAttribute("value").contentEquals("false")) {
                Assert.assertEquals("Value in element with id 'test-" + checkboxField + "' is '" +
                        element.getAttribute("value") + "' instead of 'false'", "false", element.getAttribute("value"));
            }
        }
    }

    public void checkValueForRadioButtonField(String radioButtonField, String value) {
        WebElement element = getDriver().findElement(By.xpath("//input[starts-with(@id,'test-" + radioButtonField + "')]" +
                "/following-sibling::label[normalize-space(text())='" + value + "']/preceding-sibling::input"));
        Assert.assertTrue("Value '" + value + "' should be selected but it is not", element.isSelected());
    }

    public void checkValueForSelectField(String selectField, String value) {
        Select select = new Select(getDriver().findElement(By.id("test-" + selectField)));
        WebElement option = select.getFirstSelectedOption();
        Assert.assertTrue("Option '" + value + "' should be selected but it is not", option.getText().contentEquals(value));
    }

    public void setValueForField(String field, String value) {
        WebElement element;
        String tagName;
        if (field.endsWith("-day") || field.endsWith("-month") || field.endsWith("-year") ||
                field.endsWith("-hour") || field.endsWith("-minute")) {
            tagName = "input";
        }
        else {
            element = getDriver().findElement(By.cssSelector("[id^=test-" + field + "]"));
            if (element.getAttribute("type").contentEquals("radio")) {
                tagName = "radio";
            } else if (element.getAttribute("type").contentEquals("checkbox")) {
                tagName = "checkbox";
            } else {
                tagName = element.getTagName();
            }
        }
        switch (tagName) {
            case "select":
                setValueForSelectField(field, value);
                break;
            case "input":
            case "textarea":
                setValueForInputField(field, value);
                break;
            case "radio":
                setValueForRadioButtonField(field, value);
                break;
            case "checkbox":
                setValueForCheckboxField(field, value);
                break;
        }
    }

    public void checkValueForField(String field, String value) {
        String tagName;
        WebElement element;
        if (field.endsWith("-day") || field.endsWith("-month") || field.endsWith("-year") ||
                field.endsWith("-hour") || field.endsWith("-minute")) {
            tagName = "input";
        }
        else {
            element = getDriver().findElement(By.cssSelector("[id^=test-" + field + "]"));
            if (element.getAttribute("type").contentEquals("radio")) {
                tagName = "radio";
            } else if (element.getAttribute("type").contentEquals("checkbox")) {
                tagName = "checkbox";
            }
            else {
                tagName = element.getTagName();
            }
        }
        switch (tagName) {
            case "select":
                checkValueForSelectField(field, value);
                break;
            case "input":
            case "textarea":
                checkValueForInputField(field, value);
                break;
            case "radio":
                checkValueForRadioButtonField(field, value);
                break;
            case "checkbox":
                checkValueForCheckboxField(field, value);
                break;
            default:
                checkFieldValue(field, value);
                break;
        }
    }

    private void checkFieldValue(String field, String value) {
        if (value.equals("TODAYS_DATE")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            value = dateFormat.format(date);
        }
        if (value.equals("VTM_USER_EMAIL")) {
            value = TypeLoader.getAppUsername().substring(0, 1).toUpperCase() + TypeLoader.getAppUsername().substring(1);
        }
        if (value.equals("VTM_USER")) {
            value = TypeLoader.getAppUsername().split("-")[0];
        }
        if (StringUtils.isNumeric(value)) {
            Assert.assertTrue("Expected value '" + value + "' for field '" + field + "' is not the actual one '"
                    + getValueInField(field) + "'", getValueInField(field).contentEquals(value));
        }
        else {
            Assert.assertTrue("Expected value '" + value + "' for field '" + field + "' is not the actual one '"
                    + getValueInField(field) + "'", getValueInField(field).contains(value));
        }
    }

    public String getValueInField(String field) {
        WebElement element = getDriver().findElement(By.cssSelector("#test-" + field));
        FluentWait wait = globalFluentWait(10, 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#test-" + field)));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        return element.getText();
    }
}
