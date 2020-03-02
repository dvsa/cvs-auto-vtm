package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.SearchPageSteps;

public class SearchPageStepDefinition {

    @Steps
    SearchPageSteps searchPageSteps;

    @When("^I search for vehicle with identifier \"([^\"]*)\"$")
    public void iSearchForVehicleWithIdentifier(String arg0){
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(arg0);
        searchPageSteps.searchVehicle();
    }

    @When("^I search for vehicle using wrong identifier \"([^\"]*)\"$")
    public void iSearchForVehicleUsingWrongIdentifier(String arg0) {
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(arg0);
        searchPageSteps.searchVehicleIncorrectIdentifier();
    }

    @Then("^wait until I see search error message \"([^\"]*)\"$")
    public void waitUntilISeeErrorMessage(String arg0) {
        searchPageSteps.waitUntilISeeSearchErrorMessage(arg0);
    }
}
