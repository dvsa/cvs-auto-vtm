package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericBackendRequestSteps;
import step.GenericPageSteps;
import step.SearchPageSteps;

public class SearchPageStepDefinition {

    @Steps
    SearchPageSteps searchPageSteps;

    @Steps
    GenericBackendRequestSteps genericBackendRequestSteps;

    @Steps
    GenericPageSteps genericPageSteps;

    @When("^I search for vehicle with identifier \"([^\"]*)\"$")
    public void iSearchForVehicleWithIdentifier(String identifier){
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(identifier);
        searchPageSteps.searchVehicle();
    }

    @When("^I search for vehicle with shared identifier \"([^\"]*)\"$")
    public void iSearchForVehicleWithSharedIdentifier(String identifier){
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(identifier);
        searchPageSteps.searchVehicles();
    }

    @When("^I search for previously created vehicle$")
    public void searchForPreviouslyCreatedVehicle(){
        searchPageSteps.clearSearchInput();
        searchPageSteps.inputVehicleIdentifier(genericBackendRequestSteps.getNewVehicleAttribute("vin"));
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

    @Then("^\"([^\"]*)\" search option should be selected$")
    public void optionShouldBeSelected(String searchCriteria) {
        searchPageSteps.optionShouldBeSelected(searchCriteria);
    }

    @Then("^other search criteria include \"([^\"]*)\"$")
    public void otherSearchCriteriaInclude(String searchCriteria) {
        searchPageSteps.otherSearchCriteriaInclude(searchCriteria);
    }

    @When("^I select \"([^\"]*)\" search criteria$")
    public void iSelectSearchCriteria(String searchCriteria) {
        searchPageSteps.selectSearchCriteria(searchCriteria);

    }

    @Then("^the specific error contains \"([^\"]*)\"$")
    public void theSpecificErrorContains(String text) {
        searchPageSteps.specificErrorContains(text);
    }

    @Then("^search vehicle input field should be present$")
    public void searchVehicleInputFieldShouldBePresent() {
        genericPageSteps.elementWithIdShouldBePresent("searchIdentifier");
    }
}
