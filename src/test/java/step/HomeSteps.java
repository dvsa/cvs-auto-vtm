package step;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage;

    @Step
    public void inputVinVrm(String arg0) {
        homePage.inputVinVrm(arg0);
    }

    @Step
    public void searchVehicle() {
        homePage.searchVehicle();
    }

    @Step
    public void createVehicle() {
        homePage.createVehicle();
    }

    @Step
    public void waitForPageToLoad() {
        homePage.waitForPageToLoad();
    }

    public void checkTextIsPresentInPage(String arg0) {
        homePage.checkTextIsPresentInPage(arg0);
    }
}
