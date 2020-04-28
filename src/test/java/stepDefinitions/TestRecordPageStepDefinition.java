package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.ComparisonFailure;
import step.GenericBackendRequestSteps;
import step.GenericPageSteps;
import step.TestRecordPageSteps;

import java.util.List;
import java.util.Map;

public class TestRecordPageStepDefinition {

    @Steps
    TestRecordPageSteps testRecordPageSteps;

    @Steps
    GenericBackendRequestSteps genericBackendRequestSteps;

    @Then("^test record fields should have values$")
    public void testRecordFieldShouldHaveValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            testRecordPageSteps.checkValueInTestRecordField(stringMap.get("Value"), stringMap.get("Field"));
        }
    }

    @Then("^test record fields of newly created test should have expected values$")
    public void testRecordFieldForNewlyCreatedTestShouldHaveValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            testRecordPageSteps.checkValueInTestRecordField(
                    genericBackendRequestSteps.getNewTestAttribute(stringMap.get("Field")), stringMap.get("Field"));
        }
    }

    @Then("^I should be taken to the correct test record page$")
    public void iShouldBeTakenToTheCorrectTestRecordPage() {
        testRecordPageSteps.checkTestRecordPageUrl();
    }

    @Then("^I open all test record sections$")
    public void iOpenAllTechRecordSections() {
        testRecordPageSteps.openAllSections();
    }

    @Then("^I close all test record sections$")
    public void iCloseAllTechRecordSections() {
        testRecordPageSteps.closeAllSections();
    }

    @When("^I open test record \"([^\"]*)\" section$")
    public void iOpenTechRecordSection(String section) {
        testRecordPageSteps.openSection(section);
    }

    @When("^I close test record \"([^\"]*)\" section$")
    public void iCloseTechRecordSection(String section) {
        testRecordPageSteps.closeSection(section);
    }

    @When("^I enter \"([^\"]*)\" as reason for test record changes$")
    public void iEnterAsReasonForTestRecordChanges(String reason) {
        testRecordPageSteps.setReasonForChanges(reason);
    }

    @When("^I confirm saving the test record changes$")
    public void iConfirmSavingTheTestRecordChanges() {
        testRecordPageSteps.confirmSavingChanges();
    }

    @When("^I cancel saving the test record changes$")
    public void iCancelSavingTheTestRecordChanges() {
        testRecordPageSteps.cancelSavingChanges();
    }

    @When("^I am increasing the odometer reading by (\\d+)$")
    public void iAmIncreasingTheOdometerReadingBy(int value) {
        testRecordPageSteps.increaseOdometerReadingBy(value);
    }

    @Then("^I should see \"([^\"]*)\" in the save changes modal$")
    public void iShouldSeeInTheSaveChangesModal(String text) {
        testRecordPageSteps.checkTextIsPresentInSaveChangesModal(text);
    }

    @Then("^odometer reading should have expected value$")
    public void odometerReadingShouldHaveExpectedValue() {
        testRecordPageSteps.checkOdometerReadingValue();
    }

    @Then("^odometer reading should have expected value on edit$")
    public void odometerReadingShouldHaveExpectedValueOnEdit() {
        testRecordPageSteps.checkOdometerReadingValueOnEdit();
    }

    @Then("^I cancel saving the test record details$")
    public void iCancelSavingTheTestRecordDetails() {
        testRecordPageSteps.cancelSavingDetails();
    }

    @Then("^I should see the \"([^\"]*)\" attribute of newly created vehicle$")
    public void iShouldSeeTheAttributeOfNewlyCreatedVehicle(String attribute) {
        testRecordPageSteps.checkValueInTestRecordField(genericBackendRequestSteps.getNewVehicleAttribute(attribute),
                attribute);
    }

    @Then("^I should see the \"([^\"]*)\" attribute of newly created test$")
    public void iShouldSeeTheAttributeOfNewlyCreatedTest(String attribute) {
        testRecordPageSteps.checkValueInTestRecordField(genericBackendRequestSteps.getNewTestAttribute(attribute),
                attribute);
    }

    @Then("^test record fields should be editable$")
    public void testRecordFieldsShouldBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            testRecordPageSteps.checkFieldEditable(stringMap.get("Field"));
        }
    }

    @Then("^test record fields should not be editable$")
    public void testRecordFieldsShouldNotBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            testRecordPageSteps.checkFieldNotEditable(stringMap.get("Field"));
        }
    }

    @When("^I set \"([^\"]*)\" as country of registration$")
    public void iSetAsCountryOfRegistration(String value) {
        testRecordPageSteps.setInputTestRecordField("countryOfRegistration", value);
    }

    @When("^I select \"([^\"]*)\" as EU vehicle category$")
    public void iSelectAsEUVehicleCategory(String value) {
        testRecordPageSteps.setRadioButtonTestRecordField("euVehicleCategory", value);
    }

    @When("^I set odometer reading to \"([^\"]*)\"$")
    public void iSetOdometerReadingTo(String value) {
        testRecordPageSteps.setInputTestRecordField("odometerReading", value);
    }

    @When("^I set odometer reading unit to \"([^\"]*)\"$")
    public void iSetOdometerReadingUnitTo(String value) {
        testRecordPageSteps.setSelectTestRecordField("odometerReadingUnit", value);
    }

    @When("^I set preparer to \"([^\"]*)\"$")
    public void iSetPreparerTo(String value) {
        testRecordPageSteps.setInputTestRecordField("preparer", value);
    }

    @When("^I set test facility name to \"([^\"]*)\"$")
    public void iSetTestFacilityNameTo(String name) {
        testRecordPageSteps.setInputTestRecordField("testStationNameNumber", name);
    }

    @When("^I set tester name to \"([^\"]*)\"$")
    public void iSetTesterNameTo(String name) {
        testRecordPageSteps.setInputTestRecordField("testerName", name);
    }

    @When("^I set email address to \"([^\"]*)\"$")
    public void iSetEmailAddressTo(String emailAddress) {
        testRecordPageSteps.setInputTestRecordField("testerEmailAddress", emailAddress);
    }

    @When("^I add test notes \"([^\"]*)\"$")
    public void iAddTestNotes(String text) {
        testRecordPageSteps.setInputTestRecordField("additionalNotesRecorded", text);
    }

    @Then("^the \"([^\"]*)\" test record section should have (\\d+) entry$")
    public void theTestRecordSectionShouldHaveEntry(String section, int numberOfEntries) {
        testRecordPageSteps.checkNumberOfEntriesInSection(section, numberOfEntries);
    }

    @Then("^the \"([^\"]*)\" test record section should have (\\d+) entries$")
    public void theTestRecordSectionShouldHaveEntries(String section, int numberOfEntries) {
        testRecordPageSteps.checkNumberOfEntriesInSection(section, numberOfEntries);
    }

    @Then("^\"([^\"]*)\" test record section should be expanded$")
    public void checkSectionIsExpanded(String section) {
        testRecordPageSteps.checkSectionIsExpanded(section);
    }

    @Then("^all test record sections should be expanded$")
    public void checkAllSectionsAreExpanded() {
        testRecordPageSteps.checkAllSectionsAreExpanded();
    }

    @Then("^all test record sections should be collapsed$")
    public void checkAllSectionsAreCollapsed() {
        testRecordPageSteps.checkAllSectionsAreCollapsed();
    }

    @When("^I expand \"([^\"]*)\" test record section$")
    public void iExpandTestRecordSection(String section) {
        testRecordPageSteps.expandSection(section);
    }

    @When("^I collapse \"([^\"]*)\" test record section$")
    public void iCollapseTestRecordSection(String section) {
        testRecordPageSteps.collapseSection(section);
    }

    @Then("^test record sections are displayed$")
    public void iShouldSeeTestRecordSections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            testRecordPageSteps.checkSectionIsPresent(stringMap.get("Section"));
        }
    }

    @Then("^test record sections are not displayed$")
    public void iShouldNotSeeTestRecordSections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            testRecordPageSteps.checkSectionIsNotPresent(stringMap.get("Section"));
        }
    }

    @Then("^I should not see \"([^\"]*)\" in \"([^\"]*)\" test record section$")
    public void iShouldNotSeeInTestRecordSection(String field, String section) {
        testRecordPageSteps.checkTextIsNotPresentInSection(field, section);
    }

    @Then("^I should see \"([^\"]*)\" in \"([^\"]*)\" test record section$")
    public void iShouldSeeInTestRecordSection(String field, String section) {
        testRecordPageSteps.checkTextIsPresentInSection(field, section);
    }

    @Then("^\"([^\"]*)\" test record section should be empty$")
    public void thenSectionShouldBeEmpty(String section) {
        testRecordPageSteps.checkSectionEmpty(section);
    }
}
