package step;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.FluentWait;
import pages.GenericPage;
import pages.Header;
import pages.HomePage;

import java.time.Duration;
import java.util.NoSuchElementException;

public class GenericPageSteps {

    GenericPage genericPage;
    Header header;
    HomePage homePage;

    @Step
    public void waitForPageToLoad() {
        genericPage.waitForPageToLoad();
    }

    @Step
    public void checkTextIsPresentInPage(String text) {
        genericPage.checkTextIsPresentInPage(text);
    }

    @Step
    public void checkTextIsNotPresentInPage(String text) {
        genericPage.checkTextIsNotPresentInPage(text);
    }

    @Step
    public void elementWithIdShouldBePresent(String id) {
        genericPage.elementWithIdShouldBePresent(id);
    }

    @Step
    public void clearSession() {
        genericPage.clearSession();
    }

    @Step
    public void navigateAwayFromVtmAndGoBack() {
        genericPage.navigateAwayFromVtmAndGoBack();
    }

    @Step
    public void waitForTextToAppear(String text) {
        genericPage.waitForTextToAppearInPage(text);
    }

    @Step
    public void refreshPage() {
        genericPage.refreshPage();
    }

    @Step
    public void clearSessionStorage() {
        genericPage.clearSessionStorage();
    }

    @Step
    public void checkTextIsPresentInHyperlink(String text) {
        genericPage.checkTextIsPresentInHyperlink(text);
    }

    @Step
    public void goBackToSearchPage() {
        header.clickHeaderTitleLink();
        homePage.goToSearchTechRecordPage();
    }

    @Step
    public void goBackToCreatePage() {
        header.clickHeaderTitleLink();
        homePage.goToCreateTechRecordPage();
    }

    @Step
    public void checkTextIsPresentInButton(String text) {
        genericPage.checkTextIsPresentInButton(text);
    }

    @Step
    public void clickButton(String text) {
        genericPage.clickButton(text);
    }

    @Step
    public void clickLink(String text) {
        genericPage.clickLink(text);
    }

    @Step
    public void headerErrorContains(String text) {
        genericPage.headerErrorContains(text);
    }

    @Step
    public void headerErrorNotContains(String text) {
        genericPage.headerErrorNotContains(text);
    }

    @Step
    public void goBackToPreviousPage() {
        genericPage.goBackToPreviousPage();
    }

    @Step
    public void checkPageUrl(String url) {
        genericPage.checkPageUrl(url);
    }

    @Step
    public void checkSignOutScreenNotPresent() {
        genericPage.checkSignOutScreenNotPresent();
    }
}
