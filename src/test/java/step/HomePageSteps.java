package step;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomePageSteps extends GenericPageSteps {

    HomePage homePage;

    @Step
    public void goToSearchTechRecordPage() {
        homePage.goToSearchTechRecordPage();
    }

    @Step
    public void goToCreateTechRecordPage() {
        homePage.goToCreateTechRecordPage();
    }
}
