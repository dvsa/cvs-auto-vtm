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

    @Then("^I should be taken to the correct page for changing test type of test record$")
    public void iShouldBeTakenToTheCorrectPageChangeTestTypeOfTestRecord() {
        testRecordPageSteps.checkChangeTestTypePageUrl();
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
        testRecordPageSteps.setValueForField("countryOfRegistration", value);
    }

    @When("^I select \"([^\"]*)\" as EU vehicle category$")
    public void iSelectAsEUVehicleCategory(String value) {
        testRecordPageSteps.setValueForField("euVehicleCategory", value);
    }

    @When("^I set odometer reading to \"([^\"]*)\"$")
    public void iSetOdometerReadingTo(String value) {
        testRecordPageSteps.setValueForField("odometerReading", value);
    }

    @When("^I set odometer reading unit to \"([^\"]*)\"$")
    public void iSetOdometerReadingUnitTo(String value) {
        testRecordPageSteps.setValueForField("odometerReadingUnit", value);
    }

    @When("^I set preparer to \"([^\"]*)\"$")
    public void iSetPreparerTo(String value) {
        testRecordPageSteps.setValueForField("preparer", value);
    }

    @When("^I set test facility name to \"([^\"]*)\"$")
    public void iSetTestFacilityNameTo(String name) {
        testRecordPageSteps.setValueForField("testStationNameNumber", name);
    }

    @When("^I set tester name to \"([^\"]*)\"$")
    public void iSetTesterNameTo(String name) {
        testRecordPageSteps.setValueForField("testerName", name);
    }

    @When("^I set email address to \"([^\"]*)\"$")
    public void iSetEmailAddressTo(String emailAddress) {
        testRecordPageSteps.setValueForField("testerEmailAddress", emailAddress);
    }

    @When("^I set \"([^\"]*)\" as test notes$")
    public void iSetAsTestNotes(String text) {
        testRecordPageSteps.setValueForField("additionalNotesRecorded", text);
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
        testRecordPageSteps.checkValueForField("countryOfRegistration", value);
    }

    @Then("^I should see \"([^\"]*)\" as EU vehicle category$")
    public void iShouldSeeAsEuVehicleCategory(String value) {
        testRecordPageSteps.checkValueForField("euVehicleCategory", value);
    }

    @Then("^I should see \"([^\"]*)\" as odometer reading unit$")
    public void iShouldSeeAsOdometerReadingUnit(String value) {
        testRecordPageSteps.checkValueForField("odometerReadingUnit", value);
    }

    @Then("^I should see \"([^\"]*)\" as odometer reading$")
    public void iShouldSeeAsOdometerReading(String value) {
        testRecordPageSteps.checkValueForField("odometerReading", value);
    }

    @Then("^I should see \"([^\"]*)\" as preparer$")
    public void iShouldSeeAsPreparer(String value) {
        testRecordPageSteps.checkValueForField("preparer", value);
    }

    @Then("^I should see \"([^\"]*)\" as emission standard$")
    public void iShouldSeeAsEmissionStandard(String value) {
        testRecordPageSteps.checkValueForField("emissionStandard", value);
    }

    @Then("^I should see \"([^\"]*)\" as smoke test K limit applied$")
    public void iShouldSeeAsSmokeTestKLimitApplied(String value) {
        testRecordPageSteps.checkValueForField("smokeTestKLimitApplied", value);
    }

    @Then("^I should see \"([^\"]*)\" as fuel type$")
    public void iShouldSeeAsFuelType(String value) {
        testRecordPageSteps.checkValueForField("fuelType", value);
    }

    @Then("^I should see \"([^\"]*)\" as modification type$")
    public void iShouldSeeAsModificationType(String value) {
        testRecordPageSteps.checkValueForField("modType", value);
    }

    @Then("^I should see \"([^\"]*)\" as particulate trap fitted$")
    public void iShouldSeeAsParticulateTrappFitted(String value) {
        testRecordPageSteps.checkValueForField("particulateTrapFitted", value);
    }

    @Then("^I should see \"([^\"]*)\" as particulate trap serial number$")
    public void iShouldSeeAsParticulateTrapSerialNumber(String value) {
        testRecordPageSteps.checkValueForField("particulateTrapSerialNumber", value);
    }

    @Then("^I should see \"([^\"]*)\" as test facility name$")
    public void iShouldSeeAsTestFacilityName(String value) {
        testRecordPageSteps.checkValueForField("testStationNameNumber", value);
    }

    @Then("^I should see \"([^\"]*)\" as tester name$")
    public void iShouldSeeAsTesterName(String value) {
        testRecordPageSteps.checkValueForField("testerName", value);
    }

    @Then("^I should see \"([^\"]*)\" as email address$")
    public void iShouldSeeAsEmailAddress(String value) {
        testRecordPageSteps.checkValueForField("testerEmailAddress", value);
    }

    @Then("^I should see \"([^\"]*)\" as test station type$")
    public void iShouldSeeAsTestStationType(String value) {
        testRecordPageSteps.checkTestStationType(value);
    }

    @When("^I select \"([^\"]*)\" as emission standard$")
    public void iSelectAsEmissionStandard(String value) {
        testRecordPageSteps.setValueForField("emissionStandard", value);
    }

    @When("^I set \"([^\"]*)\" as smoke test limit applied$")
    public void iSetAsSmokeTestLimitApplied(String value) {
        testRecordPageSteps.setValueForField("smokeTestKLimitApplied", value);
    }

    @When("^I select \"([^\"]*)\" as fuel type$")
    public void iSelectAsFuelType(String value) {
        testRecordPageSteps.setValueForField("fuelType", value);
    }

    @When("^I select \"([^\"]*)\" as modification type$")
    public void iSelectAsModificationType(String value) {
        testRecordPageSteps.setValueForField("modType", value);
    }

    @When("^I set \"([^\"]*)\" as particulate trap fitted$")
    public void iSelectAsParticulateTrapFitted(String value) {
        testRecordPageSteps.setValueForField("particulateTrapFitted", value);
    }
    @When("^I set \"([^\"]*)\" as particulate trap serial number$")
    public void iSetAsParticulateTrapSerialNumber(String value) {
        testRecordPageSteps.setValueForField("particulateTrapSerialNumber", value);
    }

    @Then("^I should see \"([^\"]*)\" as test notes$")
    public void iShouldSeeAsTestNotes(String value) {
        testRecordPageSteps.setValueForField("additionalNotesRecorded", value);
    }

    @When("^I set \"([^\"]*)\" as modification type used$")
    public void iSetAsModificationTypeUsed(String value) {
        testRecordPageSteps.setValueForField("modificationTypeUsed", value);
    }

    @Then("^I should see carried out during test set to \"([^\"]*)\"$")
    public void iShouldSeeCarriedOutDuringTestSetTo(String value) {
        testRecordPageSteps.checkValueForField("seatbelt", value);
    }

    @Then("^I should see \"([^\"]*)\" as number of seatbelts fitted$")
    public void iShouldSeeAsNumberOfSeatbeltsFitted(String value) {
        testRecordPageSteps.checkValueForField("numberOfSeatbeltsFitted", value);
    }

    @Then("^I should see \"([^\"]*)\" as day of most recent installation check$")
    public void iShouldSeeAsDayOfMostRecentInstallationCheck(String value) {
        testRecordPageSteps.checkValueForField("lastSeatbeltInstallationCheckDate-1-day", value);
    }

    @Then("^I should see \"([^\"]*)\" as month of most recent installation check$")
    public void iShouldSeeAsMonthOfMostRecentInstallationCheck(String value) {
        testRecordPageSteps.checkValueForField("lastSeatbeltInstallationCheckDate-1-month", value);
    }

    @Then("^I should see \"([^\"]*)\" as year of most recent installation check$")
    public void iShouldSeeAsYearOfMostRecentInstallationCheck(String value) {
        testRecordPageSteps.checkValueForField("lastSeatbeltInstallationCheckDate-1-year", value);
    }

    @When("^I set carried out during test set to \"([^\"]*)\"$")
    public void iSetCarriedOutDuringTestSetTo(String value) {
        testRecordPageSteps.setValueForField("seatbelt", value);
    }

    @When("^I set number of seatbelts fitted to \"([^\"]*)\"$")
    public void iSetNumberOfSeatbeltsFittedTo(String value) {
        testRecordPageSteps.setValueForField("numberOfSeatbeltsFitted", value);
    }

    @When("^I set day of most recent installation check to \"([^\"]*)\"$")
    public void iSetDayOfMostRecentInstallationCheckTo(String value) {
        testRecordPageSteps.setValueForField("lastSeatbeltInstallationCheckDate-1-day", value);
    }

    @When("^I set month of most recent installation check to \"([^\"]*)\"$")
    public void iSetMonthOfMostRecentInstallationCheckTo(String value) {
        testRecordPageSteps.setValueForField("lastSeatbeltInstallationCheckDate-1-month", value);
    }

    @When("^I set year of most recent installation check to \"([^\"]*)\"$")
    public void iSetYearOfMostRecentInstallationCheckTo(String value) {
        testRecordPageSteps.setValueForField("lastSeatbeltInstallationCheckDate-1-year", value);
    }

    @Then("^I should see \"([^\"]*)\" as modification type used$")
    public void iShouldSeeAsModificationTypeUsed(String value) {
        testRecordPageSteps.checkValueForField("modificationTypeUsed", value);
    }

    @Then("^I should see \"([^\"]*)\" as test result$")
    public void iShouldSeeAsTestResult(String result) {
        testRecordPageSteps.checkValueForField("testResult", result);
    }

    @Then("^I should see correct certificate number$")
    public void iShouldSeeCorrectCertificateNumber() {
        testRecordPageSteps.checkValueForField("certificateNumber", genericBackendRequestSteps.getNewTestAttribute("certificateNumber"));
    }

    @Then("^I should see correct expiry date$")
    public void iShouldSeeCorrectExpiryDate() {
        if (genericBackendRequestSteps.getNewTestAttribute("testExpiryDate").contentEquals("-")) {
            testRecordPageSteps.checkValueForField("testExpiryDate-day", "");
            testRecordPageSteps.checkValueForField("testExpiryDate-month", "");
            testRecordPageSteps.checkValueForField("testExpiryDate-year", "");
        }
        else {
            String[] parts = genericBackendRequestSteps.getNewTestAttribute("testExpiryDate").split("/");
            testRecordPageSteps.checkValueForField("testExpiryDate-day", parts[0]);
            testRecordPageSteps.checkValueForField("testExpiryDate-month", parts[1]);
            testRecordPageSteps.checkValueForField("testExpiryDate-year", parts[2]);
        }
    }

    @Then("^I should see correct anniversary date$")
    public void iShouldSeeCorrectAnniversaryDate() {
        if (genericBackendRequestSteps.getNewTestAttribute("testAnniversaryDate").contentEquals("-")) {
            testRecordPageSteps.checkValueForField("testAnniversaryDate-day", "");
            testRecordPageSteps.checkValueForField("testAnniversaryDate-month", "");
            testRecordPageSteps.checkValueForField("testAnniversaryDate-year", "");
        }
        else {
            String[] parts = genericBackendRequestSteps.getNewTestAttribute("testAnniversaryDate").split("/");
//            testRecordPageSteps.checkValueForField("testAnniversaryDate-day", parts[0]);
            testRecordPageSteps.checkValueForField("testAnniversaryDate-month", parts[1]);
            testRecordPageSteps.checkValueForField("testAnniversaryDate-year", parts[2]);
        }
    }

    @Then("^I should see correct start time$")
    public void iShouldSeeCorrectStartTime() {
        String[] parts = genericBackendRequestSteps.getNewTestAttribute("testTypeStartTimestamp").split("[: .]");
        if (parts[2].contentEquals("PM")) {
            testRecordPageSteps.checkValueForField("testTypeStartTimestamp-hour", Integer.toString(Integer.parseInt(parts[0]) + 12));
        }
        else {
            testRecordPageSteps.checkValueForField("testTypeStartTimestamp-hour", parts[0]);
        }
        if (parts[1].substring(0,1).contentEquals("0")) {
            testRecordPageSteps.checkValueForField("testTypeStartTimestamp-minute", parts[1].substring(1,2));
        }
        else {
            testRecordPageSteps.checkValueForField("testTypeStartTimestamp-minute", parts[1]);
        }
    }

    @Then("^I should see correct end time$")
    public void iShouldSeeCorrectEndTime() {
        String[] parts = genericBackendRequestSteps.getNewTestAttribute("testTypeEndTimestamp").split("[: .]");
        if (parts[2].contentEquals("PM")) {
            testRecordPageSteps.checkValueForField("testTypeEndTimestamp-hour", Integer.toString(Integer.parseInt(parts[0]) + 12));
        }
        else {
            testRecordPageSteps.checkValueForField("testTypeEndTimestamp-hour", parts[0]);
        }
        if (parts[1].substring(0,1).contentEquals("0")) {
            testRecordPageSteps.checkValueForField("testTypeEndTimestamp-minute", parts[1].substring(1,2));
        }
        else {
            testRecordPageSteps.checkValueForField("testTypeEndTimestamp-minute", parts[1]);
        }
    }

    @When("^I set test result as \"([^\"]*)\"$")
    public void iSetTestResultAs(String testResult) {
        testRecordPageSteps.setValueForField("testResult", testResult);
    }

    @When("^I set certificate number as \"([^\"]*)\"$")
    public void iSetCertificateNumberAs(String certificateNumber) {
        testRecordPageSteps.setValueForField("certificateNumber", certificateNumber);
    }

    @When("^I set expiry date to \"([^\"]*)\"$")
    public void iSetExpiryDateTo(String expiryDate) {
        String[] parts = expiryDate.split("/");
        testRecordPageSteps.setValueForField("testExpiryDate-day", parts[0]);
        testRecordPageSteps.setValueForField("testExpiryDate-month", parts[1]);
        testRecordPageSteps.setValueForField("testExpiryDate-year", parts[2]);
    }

    @When("^I set anniversary date to \"([^\"]*)\"$")
    public void iSetAnniversaryDateTo(String expiryDate) {
        String[] parts = expiryDate.split("/");
        testRecordPageSteps.setValueForField("testAnniversaryDate-day", parts[0]);
        testRecordPageSteps.setValueForField("testAnniversaryDate-month", parts[1]);
        testRecordPageSteps.setValueForField("testAnniversaryDate-year", parts[2]);
    }

    @When("^I set start time to \"([^\"]*)\"$")
    public void iSetStartTimeTo(String startTime) {
        String[] parts = startTime.split(":");
        testRecordPageSteps.setValueForField("testTypeStartTimestamp-hour", parts[0]);
        testRecordPageSteps.setValueForField("testTypeStartTimestamp-minute", parts[1]);
    }

    @When("^I set end time to \"([^\"]*)\"$")
    public void iSetEndTimeTo(String endTime) {
        String[] parts = endTime.split(":");
        testRecordPageSteps.setValueForField("testTypeEndTimestamp-hour", parts[0]);
        testRecordPageSteps.setValueForField("testTypeEndTimestamp-minute", parts[1]);
    }

    @Then("^I should see \"([^\"]*)\" as most recent installation check date$")
    public void iShouldSeeAsMostRecentInstallationCheckDate(String checkDate) {
        String[] parts = checkDate.split("/");
        testRecordPageSteps.checkValueForField("lastSeatbeltInstallationCheckDate-day", parts[0]);
        testRecordPageSteps.checkValueForField("lastSeatbeltInstallationCheckDate-month", parts[1]);
        testRecordPageSteps.checkValueForField("lastSeatbeltInstallationCheckDate-year", parts[2]);
    }

    @When("^I set most recent installation check date to \"([^\"]*)\"$")
    public void iSetMostRecentInstallationCheckDateTo(String checkDate) {
        String[] parts = checkDate.split("/");
        testRecordPageSteps.setValueForField("lastSeatbeltInstallationCheckDate-day", parts[0]);
        testRecordPageSteps.setValueForField("lastSeatbeltInstallationCheckDate-month", parts[1]);
        testRecordPageSteps.setValueForField("lastSeatbeltInstallationCheckDate-year", parts[2]);
    }

    @When("^I set prohibition issued to \"([^\"]*)\"$")
    public void iSetProhibitionIssuedTo(String value) {
        testRecordPageSteps.setValueForField("prohibitionIssued", value);
    }
}
