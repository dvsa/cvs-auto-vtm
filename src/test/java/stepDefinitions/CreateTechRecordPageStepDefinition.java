package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.CreateTechRecordPageSteps;

public class CreateTechRecordPageStepDefinition {

    @Steps
    CreateTechRecordPageSteps createTechRecordPageSteps;

    @When("^I fill in vin \"([^\"]*)\"$")
    public void iFillInVin(String vin) {
        createTechRecordPageSteps.fillInVin(vin);
    }

    @When("^I fill in vrm \"([^\"]*)\"$")
    public void iFillInVrm(String vrm) {
        createTechRecordPageSteps.fillInVrm(vrm);
    }

    @When("^I select vehicle type \"([^\"]*)\"$")
    public void iSelectVehicleType(String vehicleType) throws Exception {
        createTechRecordPageSteps.selectVehicleType(vehicleType);

    }

    @When("^I continue record creation process$")
    public void iContinueRecordCreationProcess() {
        createTechRecordPageSteps.continueRecordCreationProcess();
    }

    @Then("^the header error contains \"([^\"]*)\"$")
    public void headerErrorContains(String text) throws Throwable {
        createTechRecordPageSteps.headerErrorContains(text);
    }

    @And("^the specific \"([^\"]*)\" error contains \"([^\"]*)\"$")
    public void specificErrorContains(String errorType, String text) throws Exception {
        createTechRecordPageSteps.specificErrorContains(errorType, text);
    }
}
