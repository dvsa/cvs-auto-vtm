package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.SearchPageSteps;

public class SearchPageStepDefinition {

    @Steps
    SearchPageSteps searchPageSteps;

    @When("^I search for vehicle with identifier \"([^\"]*)\"$")
    public void iSearchForVehicleWithIdentifier(String identifier){
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(identifier);
        searchPageSteps.searchVehicle();
    }

    @When("^I search for vehicle using wrong identifier \"([^\"]*)\"$")
    public void iSearchForVehicleUsingWrongIdentifier(String identifier) {
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(identifier);
        searchPageSteps.searchVehicleIncorrectIdentifier();
    }

    @Then("^wait until I see search error message \"([^\"]*)\"$")
    public void waitUntilISeeErrorMessage(String message) {
        searchPageSteps.waitUntilISeeSearchErrorMessage(message);
    }
}
