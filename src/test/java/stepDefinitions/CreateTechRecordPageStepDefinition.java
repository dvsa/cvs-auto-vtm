package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.ComparisonFailure;
import step.CreateTechRecordPageSteps;
import step.GenericPageSteps;

import java.util.List;
import java.util.Map;

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
    public void iSelectVehicleType(String vehicleType) {
        createTechRecordPageSteps.selectVehicleType(vehicleType);

    }

    @Then("^the specific \"([^\"]*)\" error contains \"([^\"]*)\"$")
    public void specificErrorContains(String errorType, String text) {
        createTechRecordPageSteps.specificErrorContains(errorType, text);
    }

    @Then("^the specific \"([^\"]*)\" error does not contain \"([^\"]*)\"$")
    public void specificErrorNotContains(String errorType, String text) {
        createTechRecordPageSteps.specificErrorNotContains(errorType, text);
    }

    @Then("^I should see \"([^\"]*)\" in \"([^\"]*)\" input field$")
    public void iShouldSeeInInputField(String text, String input) {
        createTechRecordPageSteps.checkInputFieldText(text, input);
    }

    @Then("^I should not see \"([^\"]*)\" in \"([^\"]*)\" input field$")
    public void iShouldNotSeeInInputField(String text, String input) {
        createTechRecordPageSteps.checkNotInputFieldText(text, input);
    }

    @Then("^I should see \"([^\"]*)\" in \"([^\"]*)\" field description$")
    public void iShouldSeeLabel(String text, String field) {
        createTechRecordPageSteps.checkInputDescription(text, field);
    }

    @Then("^I should not see \"([^\"]*)\" in \"([^\"]*)\" field description$")
    public void iShouldNotSeeInFieldDescription(String text, String field) {
        createTechRecordPageSteps.checkNotInputDescription(text, field);
    }

    @Then("^there are no \"([^\"]*)\" related errors$")
    public void noRelatedErrorsForField(String fieldType) {
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

    @When("^I set vin to random value$")
    public void iSetVinToRandomValue() {
        createTechRecordPageSteps.setVinToRandomValue();
    }

    @When("^I set vrm to random value$")
    public void iSetVrmToRandomValue() {
        createTechRecordPageSteps.setVrmToRandomValue();
    }

    @Then("^sections in create tech record page are displayed$")
    public void sectionsInCreateTechRecordPageAreDisplayed(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            createTechRecordPageSteps.checkSectionIsPresent(stringMap.get("Section"));
        }
    }

    @Then("^sections in create tech record page are not displayed$")
    public void sectionsInCreateTechRecordPageAreNotDisplayed(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            createTechRecordPageSteps.checkSectionIsNotPresent(stringMap.get("Section"));
        }
    }

    @Then("^all sections in create tech record page should be expanded$")
    public void allSectionsInCreateTechRecordPageShouldBeExpanded() {
        createTechRecordPageSteps.checkAllSectionsAreExpanded();
    }

    @Then("^fields in create tech record page should be editable$")
    public void fieldsShouldBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            createTechRecordPageSteps.checkFieldEditable(stringMap.get("Field"));
        }
    }

    @Then("^fields in create tech record page should not be editable$")
    public void fieldsShouldNotBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            createTechRecordPageSteps.checkFieldNotEditable(stringMap.get("Field"));
        }
    }

    @Then("^all sections in create tech record page should be collapsed$")
    public void allSectionsInCreateTechRecordPageShouldBeCollapsed() {
        createTechRecordPageSteps.checkAllSectionsAreCollapsed();
    }
}
