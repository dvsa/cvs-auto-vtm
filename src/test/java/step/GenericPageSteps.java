package step;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pages.GenericPage;
import pages.Header;
import pages.HomePage;

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
        genericPage.waitForTextToAppear(text, 20);
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
        header.clickHeaderLink();
        homePage.goToSearchTechRecordPage();
    }

    @Step
    public void goBackToCreatePage() {
        header.clickHeaderLink();
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
}
