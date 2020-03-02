package stepDefinitions;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import step.HomePageSteps;

public class HomePageStepDefinition {

    @Steps
    HomePageSteps homePageSteps;

    @Then("^I go to search tech record page")
    public void iGoToSearchTechRecordPage() {
        homePageSteps.goToSearchTechRecordPage();
    }

    @Then("^I go to create tech record page")
    public void iGoToCreateTechRecordPage() {
        homePageSteps.goToCreateTechRecordPage();
    }
}
