package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Header extends GenericPage {

    private static final String LOG_OUT_LINK = "#navigation>li:last-of-type>a";
    private static final String LOG_OUT_LINK_IN_HAMBURGER_MENU = "#menuLinks>a:last-of-type";
    private static final String HEADER_USER_NAME = "#navigation>li:first-of-type>a";
    private static final String HEADER_TITLE = "#header-nav-item";
    private static final String HAMBURGER_MENU = "a.icon";
    private static final String HEADER = "vtm-header";

    public void signOutFromVtmApp() {
        if (findElementByCss(LOG_OUT_LINK).isDisplayed()) {
            findElementByCss(LOG_OUT_LINK).click();
        }
        else {
            findElementByCss(HAMBURGER_MENU).click();
            new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOG_OUT_LINK_IN_HAMBURGER_MENU)));
            findElementByCss(LOG_OUT_LINK_IN_HAMBURGER_MENU).click();
        }
    }

    public void clickHeaderTitleLink() {
        waitForRenderedElementsToBePresent(By.cssSelector(HEADER_TITLE));
        findElementByCss(HEADER_TITLE).click();
    }

    public void validateHeaderTitle(String title) {
        if (findElementByCss(HEADER_TITLE).isDisplayed()) {
            Assert.assertTrue(findElementByCss(HEADER_TITLE).getText().contentEquals(title));
        }
        else {
            getDriver().manage().window().maximize();
            if (findElementByCss(HEADER_TITLE).isDisplayed()) {
                Assert.assertTrue(findElementByCss(HEADER_TITLE).getText().contentEquals(title));
            }
        }
    }

    public void checkUserNameInHeader(String name) {
        if (findElementByCss(HEADER_USER_NAME).isDisplayed()) {
            Assert.assertTrue(findElementByCss(HEADER_USER_NAME).getText().contentEquals(name));
        }
        else {
            getDriver().manage().window().maximize();
            if (findElementByCss(HEADER_USER_NAME).isDisplayed()) {
                Assert.assertTrue(findElementByCss(HEADER_USER_NAME).getText().contentEquals(name));
            }
        }
    }

    public void checkTextInHeader(String text) {
        Assert.assertTrue(findElementByCss(HEADER).getText().contains(text));
    }

    public void goBackToHomePage() {
        String locator = "//vtm-header//a/span[contains(text(),'Vehicle testing management')]";
        List<WebElement> homePageLinks = getDriver().findElements(By.xpath(locator));
        for (WebElement homePageLink : homePageLinks) {
            if (homePageLink.isDisplayed()) {
                homePageLink.click();
                break;
            }
        }
    }
}
