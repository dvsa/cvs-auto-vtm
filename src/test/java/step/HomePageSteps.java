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
}
