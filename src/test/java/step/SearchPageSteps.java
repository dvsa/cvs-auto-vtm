package step;

import net.thucydides.core.annotations.Step;
import pages.SearchPage;

public class SearchPageSteps extends GenericPageSteps {

    SearchPage searchPage;

    @Step
    public void inputVehicleIdentifier(String arg0) {
        searchPage.inputVehicleIdentifier(arg0);
    }

    @Step
    public void clearSearchInput() {
        searchPage.clearSearchInput();
    }

    @Step
    public void searchVehicle() {
        searchPage.searchVehicle();
    }

    @Step
    public void waitForPageToLoad() {
        searchPage.waitForPageToLoad();
    }

    @Step
    public void checkTextIsPresentInPage(String arg0) {
        searchPage.checkTextIsPresentInPage(arg0);
    }

    @Step
    public void checkTextIsNotPresentInPage(String arg0) {
        searchPage.checkTextIsNotPresentInPage(arg0);
    }

    @Step
    public void elementWithIdShouldBePresent(String id) {
        searchPage.elementWithIdShouldBePresent(id);
    }

    @Step
    public void searchVehicleIncorrectIdentifier() {
        searchPage.searchVehicleIncorrectIdentifier();
    }

    @Step
    public void waitUntilISeeSearchErrorMessage(String arg0) {
        searchPage.waitUntilISeeSearchErrorMessage(arg0);
    }

    @Step
    public void navigateAwayFromVtmAndGoBack() {
        searchPage.navigateAwayFromVtmAndGoBack();
    }

    @Step
    public void refreshPage() {
        searchPage.refreshPage();
    }

    @Step
    public void clearSessionStorage() {
        searchPage.clearSessionStorage();
    }
}
