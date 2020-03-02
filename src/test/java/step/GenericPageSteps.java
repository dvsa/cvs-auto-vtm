package step;

import net.thucydides.core.annotations.Step;
import pages.GenericPage;

public class GenericPageSteps {

    GenericPage genericPage;

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
}
