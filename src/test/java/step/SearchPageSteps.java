package step;

import net.thucydides.core.annotations.Step;
import pages.SearchPage;

public class SearchPageSteps extends GenericPageSteps {

    SearchPage searchPage;

    @Step
    public void inputVehicleIdentifier(String identifier) {
        searchPage.inputVehicleIdentifier(identifier);
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
    public void checkTextIsPresentInPage(String text) {
        searchPage.checkTextIsPresentInPage(text);
    }

    @Step
    public void checkTextIsNotPresentInPage(String text) {
        searchPage.checkTextIsNotPresentInPage(text);
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
    public void searchVehicleCorrectIdentifier() {
        searchPage.searchVehicleCorrectIdentifier();
    }

    @Step
    public void waitUntilISeeSearchErrorMessage(String message) {
        searchPage.waitUntilISeeSearchErrorMessage(message);
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

    @Step
    public void optionShouldBeSelected(String searchCriteria) {
        searchPage.optionShouldBeSelected(searchCriteria);
    }

    @Step
    public void otherSearchCriteriaInclude(String searchCriteria) {
        searchPage.otherSearchCriteriaInclude(searchCriteria);
    }

    @Step
    public void selectSearchCriteria(String searchCriteria) {
        searchPage.selectSearchCriteria(searchCriteria);
    }

    @Step
    public void specificErrorContains(String text) {
        searchPage.specificErrorContains(text);
    }
}
