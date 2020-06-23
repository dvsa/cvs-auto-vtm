package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.ComparisonFailure;
import step.GenericBackendRequestSteps;
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
    public void iOpenAllTestRecordSections() {
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
        testRecordPageSteps.setValueForTestRecordInputField("countryOfRegistration", value);
    }

    @When("^I select \"([^\"]*)\" as EU vehicle category$")
    public void iSelectAsEUVehicleCategory(String value) {
        testRecordPageSteps.setValueForTestRecordRadioButtonField("euVehicleCategory", value);
    }

    @When("^I set odometer reading to \"([^\"]*)\"$")
    public void iSetOdometerReadingTo(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("odometerReading", value);
    }

    @When("^I set odometer reading unit to \"([^\"]*)\"$")
    public void iSetOdometerReadingUnitTo(String value) {
        testRecordPageSteps.setValueForTestRecordSelectField("odometerReadingUnit", value);
    }

    @When("^I set preparer to \"([^\"]*)\"$")
    public void iSetPreparerTo(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("preparer", value);
    }

    @When("^I set test facility name to \"([^\"]*)\"$")
    public void iSetTestFacilityNameTo(String name) {
        testRecordPageSteps.setValueForTestRecordInputField("testStationNameNumber", name);
    }

    @When("^I set tester name to \"([^\"]*)\"$")
    public void iSetTesterNameTo(String name) {
        testRecordPageSteps.setValueForTestRecordInputField("testerName", name);
    }

    @When("^I set email address to \"([^\"]*)\"$")
    public void iSetEmailAddressTo(String emailAddress) {
        testRecordPageSteps.setValueForTestRecordInputField("testerEmailAddress", emailAddress);
    }

    @When("^I set \"([^\"]*)\" as test notes$")
    public void iSetAsTestNotes(String text) {
        testRecordPageSteps.setValueForTestRecordInputField("additionalNotesRecorded", text);
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

    @Then("^I should see \"([^\"]*)\" as country of registration$")
    public void iShouldSeeAsCountryOfRegistration(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("countryOfRegistration", value);
    }

    @Then("^I should see \"([^\"]*)\" as eu vehicle category$")
    public void iShouldSeeAsEuVehicleCategory(String value) {
        testRecordPageSteps.checkTestRecordRadioButtonFieldValue("euVehicleCategory", value);
    }

    @Then("^I should see \"([^\"]*)\" as odometer reading unit$")
    public void iShouldSeeAsOdometerReadingUnit(String value) {
        testRecordPageSteps.checkTestRecordSelectFieldValue("odometerReadingUnit", value);
    }

    @Then("^I should see \"([^\"]*)\" as odometer reading$")
    public void iShouldSeeAsOdometerReading(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("odometerReading", value);
    }

    @Then("^I should see \"([^\"]*)\" as preparer$")
    public void iShouldSeeAsPreparer(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("preparer", value);
    }

    @Then("^I should see \"([^\"]*)\" as emission standard$")
    public void iShouldSeeAsEmissionStandard(String value) {
        testRecordPageSteps.checkTestRecordRadioButtonFieldValue("emissionStandard", value);
    }

    @Then("^I should see \"([^\"]*)\" as smoke test K limit applied$")
    public void iShouldSeeAsSmokeTestKLimitApplied(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("smokeTestKLimitApplied", value);
    }

    @Then("^I should see \"([^\"]*)\" as fuel type$")
    public void iShouldSeeAsFuelType(String value) {
        testRecordPageSteps.checkTestRecordRadioButtonFieldValue("fuelType", value);
    }

    @Then("^I should see \"([^\"]*)\" as modification type$")
    public void iShouldSeeAsModificationType(String value) {
        testRecordPageSteps.checkTestRecordRadioButtonFieldValue("modType", value);
    }

    @Then("^I should see \"([^\"]*)\" as particulate trap fitted$")
    public void iShouldSeeAsParticulateTrappFitted(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("particulateTrapFitted", value);
    }

    @Then("^I should see \"([^\"]*)\" as particulate trap serial number$")
    public void iShouldSeeAsParticulateTrapSerialNumber(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("particulateTrapSerialNumber", value);
    }

    @Then("^I should see \"([^\"]*)\" as test facility name$")
    public void iShouldSeeAsTestFacilityName(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("testStationNameNumber", value);
    }

    @Then("^I should see \"([^\"]*)\" as tester name$")
    public void iShouldSeeAsTesterName(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("testerName", value);
    }

    @Then("^I should see \"([^\"]*)\" as email address$")
    public void iShouldSeeAsEmailAddress(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("testerEmailAddress", value);
    }

    @Then("^I should see \"([^\"]*)\" as test station type$")
    public void iShouldSeeAsTestStationType(String value) {
        testRecordPageSteps.checkTestStationType(value);
    }

    @When("^I select \"([^\"]*)\" as emission standard$")
    public void iSelectAsEmissionStandard(String value) {
        testRecordPageSteps.setValueForTestRecordRadioButtonField("emissionStandard", value);
    }

    @When("^I set \"([^\"]*)\" as smoke test limit applied$")
    public void iSetAsSmokeTestLimitApplied(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("smokeTestKLimitApplied", value);
    }

    @When("^I select \"([^\"]*)\" as fuel type$")
    public void iSelectAsFuelType(String value) {
        testRecordPageSteps.setValueForTestRecordRadioButtonField("fuelType", value);
    }

    @When("^I select \"([^\"]*)\" as modification type$")
    public void iSelectAsModificationType(String value) {
        testRecordPageSteps.setValueForTestRecordRadioButtonField("modType", value);
    }

    @When("^I set \"([^\"]*)\" as particulate trap fitted$")
    public void iSelectAsParticulateTrapFitted(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("particulateTrapFitted", value);
    }
    @When("^I set \"([^\"]*)\" as particulate trap serial number$")
    public void iSetAsParticulateTrapSerialNumber(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("particulateTrapSerialNumber", value);
    }

    @Then("^I should see \"([^\"]*)\" as test notes$")
    public void iShouldSeeAsTestNotes(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("additionalNotesRecorded", value);
    }

    @When("^I set \"([^\"]*)\" as modification type used$")
    public void iSetAsModificationTypeUsed(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("modificationTypeUsed", value);
    }

    @Then("^I should see carried out during test set to \"([^\"]*)\"$")
    public void iShouldSeeCarriedOutDuringTestSetTo(String value) {
        testRecordPageSteps.checkTestRecordRadioButtonFieldValue("seatbelt", value);
    }

    @Then("^I should see \"([^\"]*)\" as number of seatbelts fitted$")
    public void iShouldSeeAsNumberOfSeatbeltsFitted(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("numberOfSeatbeltsFitted", value);
    }

    @Then("^I should see \"([^\"]*)\" as day of most recent installation check$")
    public void iShouldSeeAsDayOfMostRecentInstallationCheck(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("lastSeatbeltInstallationCheckDate-1-day", value);
    }

    @Then("^I should see \"([^\"]*)\" as month of most recent installation check$")
    public void iShouldSeeAsMonthOfMostRecentInstallationCheck(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("lastSeatbeltInstallationCheckDate-1-month", value);
    }

    @Then("^I should see \"([^\"]*)\" as year of most recent installation check$")
    public void iShouldSeeAsYearOfMostRecentInstallationCheck(String value) {
        testRecordPageSteps.checkTestRecordInputFieldValue("lastSeatbeltInstallationCheckDate-1-year", value);
    }

    @When("^I set carried out during test set to \"([^\"]*)\"$")
    public void iSetCarriedOutDuringTestSetTo(String value) {
        testRecordPageSteps.setValueForTestRecordRadioButtonField("seatbelt", value);
    }

    @When("^I set number of seatbelts fitted to \"([^\"]*)\"$")
    public void iSetNumberOfSeatbeltsFittedTo(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("numberOfSeatbeltsFitted", value);
    }

    @When("^I set day of most recent installation check to \"([^\"]*)\"$")
    public void iSetDayOfMostRecentInstallationCheckTo(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("lastSeatbeltInstallationCheckDate-1-day", value);
    }

    @When("^I set month of most recent installation check to \"([^\"]*)\"$")
    public void iSetMonthOfMostRecentInstallationCheckTo(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("lastSeatbeltInstallationCheckDate-1-month", value);
    }

    @When("^I set year of most recent installation check to \"([^\"]*)\"$")
    public void iSetYearOfMostRecentInstallationCheckTo(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("lastSeatbeltInstallationCheckDate-1-year", value);
    }

    @And("^I should see \"([^\"]*)\" as modification type used$")
    public void iShouldSeeAsModificationTypeUsed(String value) {
        testRecordPageSteps.setValueForTestRecordInputField("modificationTypeUsed", value);
    }
}
