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
    public void checkTextIsPresentInPage(String arg0) {
        genericPage.checkTextIsPresentInPage(arg0);
    }

    @Step
    public void checkTextIsNotPresentInPage(String arg0) {
        genericPage.checkTextIsNotPresentInPage(arg0);
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
    public void waitForTextToAppear(String arg0) {
        genericPage.waitForTextToAppear(arg0, 20);
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
}
