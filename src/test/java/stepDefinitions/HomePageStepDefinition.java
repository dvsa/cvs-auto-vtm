package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import step.GenericPageSteps;
import step.HomePageSteps;

public class HomePageStepDefinition {

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    GenericPageSteps genericPageSteps;

    @Then("^I go to search tech record page")
    public void iGoToSearchTechRecordPage() {
        homePageSteps.goToSearchTechRecordPage();
    }

    @Then("^I go to create tech record page")
    public void iGoToCreateTechRecordPage() {
        homePageSteps.goToCreateTechRecordPage();
    }

    @Then("^the \"([^\"]*)\" hyperlink description is correct$")
    public void hyperlinkDescriptionIsCorrect(String hyperlinkTitle) {
        homePageSteps.hyperlinkDescriptionIsCorrect(hyperlinkTitle);
    }

    @Then("^search vehicle link should be present$")
    public void searchVehicleLinkShouldBePresent() {
        genericPageSteps.elementWithIdShouldBePresent("test-search-vehicle");
    }

    @Then("^create new vehicle link should be present$")
    public void createNewVehicleLinkShouldBePresent() {
        genericPageSteps.elementWithIdShouldBePresent("test-create-new-vehicle");
    }
}
