package stepDefinitions;

import cucumber.api.PendingException;
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

    @When("^I create \"([^\"]*)\" vehicle with identifiers containing special characters$")
    public void iCreateVehicleWithIdentifiersContainingSpecialAttributes(String vehicleType) {
        genericBackendRequestSteps.createTechRecordWithSpecialAttributes(vehicleType);
    }

    @When("^I create test record with status \"([^\"]*)\" and result \"([^\"]*)\" and test type \"([^\"]*)\" " +
            "for previously created vehicle$")
    public void iCreateTestRecordWithStatusResultForPreviouslyCreatedVehicle(String testStatus, String testResult,
                                                                             String testCode) {
        genericBackendRequestSteps.createTestRecord(testStatus, testResult, testCode, true);
    }

    @When("^I create test record with status \"([^\"]*)\" and result \"([^\"]*)\" and test type \"([^\"]*)\" " +
            "without defects for previously created vehicle$")
    public void iCreateTestRecordWithStatusResultWithoutDefectsForPreviouslyCreatedVehicle(String testStatus, String testResult, String testCode) {
        genericBackendRequestSteps.createTestRecord(testStatus, testResult, testCode, false);
    }

    @When("^I update previously created test record$")
    public void iUpdatePreviouslyCreatedTestRecord() {
        genericBackendRequestSteps.updateTestRecord();
    }

    @When("^I create test record with status \"([^\"]*)\" and result \"([^\"]*)\" and test type \"([^\"]*)\" for new \"([^\"]*)\" vehicle$")
    public void iCreateTestRecordWithStatusAndResultAndTestTypeForNewVehicle(String status, String result, String testType,
                                                                              String vehicleType) {
        genericBackendRequestSteps.createTestRecordWithStatusAndResultAndTestTypeForNewVehicle(status, result, testType,
                vehicleType);
    }
}
