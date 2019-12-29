package step;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage;

    @Step
    public void inputVehicleIdentifier(String arg0) {
        homePage.inputVehicleIdentifier(arg0);
    }

    @Step
    public void clearSearchInput() {
        homePage.clearSearchInput();
    }

    @Step
    public void searchVehicle() {
        homePage.searchVehicle();
    }

    @Step
    public void waitForPageToLoad() {
        homePage.waitForPageToLoad();
    }

    @Step
    public void checkTextIsPresentInPage(String arg0) {
        homePage.checkTextIsPresentInPage(arg0);
    }

    @Step
    public void checkTextIsNotPresentInPage(String arg0) {
        homePage.checkTextIsNotPresentInPage(arg0);
    }

    @Step
    public void elementWithIdShouldBePresent(String id) {
        homePage.elementWithIdShouldBePresent(id);
    }

    @Step
    public void goBackToSearchPage() {
        homePage.goBackToSearchPage();
    }

    @Step
    public void searchVehicleIncorrectIdentifier() {
        homePage.searchVehicleIncorrectIdentifier();
    }

    @Step
    public void waitUntilISeeErrorMessage(String arg0) {
        homePage.waitUntilISeeErrorMessage(arg0);
    }
}
