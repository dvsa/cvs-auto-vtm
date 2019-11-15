package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.HomeSteps;

public class HomeStepDefinition {
    @Steps
    HomeSteps homeSteps;

    @When("^I input vehicle identifier$")
    public void iInputVehicleidentifier(String arg0) throws Throwable {
        homeSteps.inputVinVrm(arg0);
    }

    @When("^I search for vehicle$")
    public void iSearchForVehicle() throws Throwable {
        homeSteps.searchVehicle();
    }

    @When("^I create new vehicle$")
    public void iCreateNewVehicle() throws Throwable {
        homeSteps.createVehicle();
    }

    @When("^I wait until page is loaded$")
    public void iWaitUntilPageIsLoaded() throws Throwable {
        homeSteps.waitForPageToLoad();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSeeText(String arg0) throws Throwable {
        homeSteps.checkTextIsPresentInPage(arg0);
    }
}
