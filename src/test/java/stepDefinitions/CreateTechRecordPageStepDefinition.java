package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.CreateTechRecordPageSteps;
import step.GenericPageSteps;

public class CreateTechRecordPageStepDefinition {

    @Steps
    CreateTechRecordPageSteps createTechRecordPageSteps;

    @Steps
    GenericPageSteps genericPageSteps;

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

    @Then("^the specific \"([^\"]*)\" error contains \"([^\"]*)\"$")
    public void specificErrorContains(String errorType, String text) throws Exception {
        createTechRecordPageSteps.specificErrorContains(errorType, text);
    }

    @Then("^I should see \"([^\"]*)\" in \"([^\"]*)\" input field$")
    public void iShouldSeeInInputField(String text, String input) throws Exception {
        createTechRecordPageSteps.checkInputFieldText(text, input);
    }

    @Then("^I should not see \"([^\"]*)\" in \"([^\"]*)\" input field$")
    public void iShouldNotSeeInInputField(String text, String input) throws Exception {
        createTechRecordPageSteps.checkNotInputFieldText(text, input);
    }

    @Then("^I should see \"([^\"]*)\" in \"([^\"]*)\" field description$")
    public void iShouldSeeLabel(String text, String field) throws Exception {
        createTechRecordPageSteps.checkInputDescription(text, field);
    }

    @Then("^I should not see \"([^\"]*)\" in \"([^\"]*)\" field description$")
    public void iShouldNotSeeInFieldDescription(String text, String field) throws Throwable {
        createTechRecordPageSteps.checkNotInputDescription(text, field);
    }

    @Then("^there are no \"([^\"]*)\" related errors$")
    public void noRelatedErrorsForField(String fieldType) throws Exception {
        createTechRecordPageSteps.checkNoSpecificErrorForField(fieldType);
    }

    @When("^I fill in random vin$")
    public String iFillInRandomVin() {
        return createTechRecordPageSteps.fillInRandomVin();
    }

    @When("^I fill in random vrm$")
    public String iFillInRandomVrm() {
        return createTechRecordPageSteps.fillInRandomVrm();
    }

    @Then("^vin input field should be present$")
    public void vinInputFieldShouldBePresent() {
        genericPageSteps.elementWithIdShouldBePresent("test-vin");
    }
}
