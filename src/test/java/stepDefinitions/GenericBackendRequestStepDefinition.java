package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericBackendRequestSteps;

public class GenericBackendRequestStepDefinition {

    @Steps
    GenericBackendRequestSteps genericBackendRequestSteps;

    @When("^I create \"([^\"]*)\" vehicle ([^\"]*) adr details$")
    public void iCreateVehicleWithWithoutAdrDetails(String vehicleType, String withWithoutAdr) {
        genericBackendRequestSteps.createTechRecord(vehicleType, withWithoutAdr);
    }

    @When("^I create \"([^\"]*)\" vehicle$")
    public void iCreateVehicle(String vehicleType) {
        genericBackendRequestSteps.createTechRecord(vehicleType);
    }

    @When("^I create test record with status \"([^\"]*)\" and result \"([^\"]*)\" and test type \"([^\"]*)\" " +
            "for previously created vehicle$")
    public void iCreateTestRecordWithStatusResultForPreviouslyCreatedVehicle(String testStatus, String testResult,
                                                                             String testCode) {
        genericBackendRequestSteps.createTestRecord(testStatus, testResult, testCode, true);
    }

    @When("^I create test record with status \"([^\"]*)\" and result \"([^\"]*)\" and test type \"([^\"]*)\" " +
            "without defects for previously created vehicle$")
    public void iCreateTestRecordWithStatusResultWithoutDefectsForPreviouslyCreatedVehicle(String testStatus, String testResult,
                                                                                           String testCode) {
        genericBackendRequestSteps.createTestRecord(testStatus, testResult, testCode, false);
    }


}
