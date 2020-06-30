package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.ComparisonFailure;
import step.GenericBackendRequestSteps;
import step.TechRecordPageSteps;

import java.util.List;
import java.util.Map;

public class TechRecordPageStepDefinition {

    @Steps
    TechRecordPageSteps techRecordPageSteps;

    @Steps
    GenericBackendRequestSteps genericBackendRequestSteps;

    @Then("^tech record fields should have values$")
    public void techRecordFieldShouldHaveValue(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkValueInTechRecordField(stringMap.get("Value"), stringMap.get("Field"));
        }
    }

    @Then("^I open all tech record sections$")
    public void iOpenAllTechRecordSections() {
        techRecordPageSteps.openAllSections();
    }

    @Then("^I close all tech record sections$")
    public void iCloseAllTechRecordSections() {
        techRecordPageSteps.closeAllSections();
    }

    @When("^I open tech record \"([^\"]*)\" section$")
    public void iOpenTechRecordSection(String section) {
        techRecordPageSteps.openSection(section);
    }

    @When("^I close tech record \"([^\"]*)\" section$")
    public void iCloseTechRecordSection(String section) {
        techRecordPageSteps.closeSection(section);
    }

    @When("^I click the change technical record button$")
    public void iClickChangeTechnicalRecordButton() {
        techRecordPageSteps.editTechRecordDetails();
    }

    @When("^I click the save technical record button$")
    public void iClickSaveTechnicalRecordButton() {
        techRecordPageSteps.saveTechRecordDetails();
    }

    @When("^I select \"([^\"]*)\" dangerous good$")
    public void iSelectDangerousGood(String dangerousGood) {
        techRecordPageSteps.selectDangerousGoodCheckbox(dangerousGood);
    }

    @When("^I deselect \"([^\"]*)\" dangerous good$")
    public void iDeselectDangerousGood(String dangerousGood) {
        techRecordPageSteps.deselectDangerousGoodCheckbox(dangerousGood);
    }

    @When("^I select \"([^\"]*)\" from tank statement$")
    public void iSelectFromTankStatement(String option) {
        techRecordPageSteps.iSelectFromTankStatement(option);
    }

    @Then("^I should see \"([^\"]*)\" statement field$")
    public void iShouldSeeStatementField(String statementField) {
        techRecordPageSteps.iShouldSeeStatementField(statementField);
    }

    @Then("^I should not see statement fields$")
    public void iShouldNotSeeStatementFields() {
        techRecordPageSteps.iShouldNotSeeStatementFields();
    }

    @Then("^I should see \"([^\"]*)\" product list field$")
    public void iShouldSeeProductListField(String field) {
        techRecordPageSteps.iShouldSeeProductListField(field);
    }

    @Then("^I should not see product list fields$")
    public void iShouldNotSeeProductListFields() {
        techRecordPageSteps.iShouldNotSeeProductListFields();
    }

    @When("^I select \"([^\"]*)\" adr vehicle type$")
    public void iSelectAdrVehicleType(String vehicleType) {
        techRecordPageSteps.iSelectAdrVehicleType(vehicleType);
    }

    @When("^I set battery list applicable to \"([^\"]*)\"$")
    public void iSetBatteryListApplicable(String option) {
        techRecordPageSteps.setBatteryListApplicable(option);
    }

    @Then("^I should see \"([^\"]*)\" battery list field$")
    public void iShouldSeeBatteryListField(String field) {
        techRecordPageSteps.iShouldSeeBatteryListField(field);
    }

    @Then("^I should not see battery list fields$")
    public void iShouldNotSeeBatteryListFields() {
        techRecordPageSteps.iShouldNotSeeBatteryListFields();
    }

    @When("^I select \"([^\"]*)\" checkbox$")
    public void iSelectCheckbox(String text) {
        techRecordPageSteps.iSelectCheckbox(text);
    }

    @When("^I deselect \"([^\"]*)\" checkbox$")
    public void iDeselectCheckbox(String text) {
        techRecordPageSteps.iDeselectCheckbox(text);
    }

    @Then("^I should see \"([^\"]*)\" manufacturer brake declaration field$")
    public void iShouldSeeManufacturerBrakeDeclarationField(String field) {
        techRecordPageSteps.iShouldSeeManufacturerBrakeDeclarationField(field);
    }

    @Then("^I should not see manufacturer brake declaration fields$")
    public void iShouldNotSeeManufacturerBrakeDeclarationField() {
        techRecordPageSteps.iShouldNotSeeManufacturerBrakeDeclarationFields();
    }

    @Then("^I should see \"([^\"]*)\" brake endurance field$")
    public void iShouldSeeBrakeEnduranceField(String field) {
        techRecordPageSteps.iShouldSeeBrakeEnduranceField(field);
    }

    @Then("^I should not see brake endurance fields$")
    public void iShouldNotSeeBrakeEnduranceField() {
        techRecordPageSteps.iShouldNotSeeBrakeEnduranceFields();
    }

    @When("^I click \"([^\"]*)\" adr details link$")
    public void iClickLink(String linkText) {
        techRecordPageSteps.iClickAdrDetailsLink(linkText);
    }

    @When("^I select \"([^\"]*)\" custom dangerous good$")
    public void iSelectCustomDangerousGood(String customDangerousGood) {
        techRecordPageSteps.iSelectCustomDangerousGoodCheckbox(customDangerousGood);
    }

    @When("^I deselect \"([^\"]*)\" custom dangerous good$")
    public void iDeselectCustomDangerousGood(String customDangerousGood) {
        techRecordPageSteps.iDeselectCustomDangerousGoodCheckbox(customDangerousGood);
    }

    @When("^I input \"([^\"]*)\" custom dangerous good$")
    public void iInputCustomDangerousGood(String customDangerousGood) {
        techRecordPageSteps.iInputCustomDangerousGood(customDangerousGood);
    }

    @When("^I input \"([^\"]*)\" custom guidance note$")
    public void iInputCustomGuidanceNote(String note) {
        techRecordPageSteps.iInputCustomGuidanceNote(note);
    }

    @When("^I select \"([^\"]*)\" guidance note$")
    public void iSelectCustomGuidanceNote(String note) {
        techRecordPageSteps.iSelectGuidanceNoteCheckbox(note);
    }

    @When("^I deselect \"([^\"]*)\" custom guidance note$")
    public void iDeselectCustomGuidanceNote(String note) {
        techRecordPageSteps.iDeselectCustomGuidanceNoteCheckbox(note);
    }

    @When("^I input \"([^\"]*)\" as new UN number$")
    public void iInputNewUnNumber(String unNumber) {
        techRecordPageSteps.iInputNewUnNumber(unNumber);
    }

    @Then("^I should see \"([^\"]*)\" section heading$")
    public void iShouldSeeSectionHeading(String heading) {
        techRecordPageSteps.checkSectionIsPresent(heading);
    }

    @Then("^I should see \"([^\"]*)\" adr field$")
    public void iShouldSeeAdrField(String adrField) {
        techRecordPageSteps.checkAdrFieldDisplayed(adrField);
    }

    @Then("^tech record fields of newly created tech record should have expected values$")
    public void techRecordFieldForNewlyCreatedVehicleShouldHaveValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkValueInTechRecordField(
                    genericBackendRequestSteps.getNewVehicleAttribute(stringMap.get("Field")), stringMap.get("Field"));
        }
    }

    @Then("^I should see adr subsections$")
    public void iShouldSeeAdrSubsections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkAdrSubsectionIsPresent(stringMap.get("Subsection"));
        }
    }

    @Then("^I should not see adr subsections$")
    public void iShouldNotSeeAdrSubsections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkAdrSubsectionIsNotPresent(stringMap.get("Subsection"));
        }
    }

    @When("^I enter \"([^\"]*)\" as reason for tech record changes$")
    public void iEnterAsReasonForTechRecordChanges(String reason) {
        techRecordPageSteps.setReasonForChanges(reason);
    }

    @When("^I confirm saving the tech record changes$")
    public void iConfirmSavingTheTechRecordChanges() {
        techRecordPageSteps.confirmSavingChanges();
    }

    @Then("^I should see \"([^\"]*)\" in the adr \"([^\"]*)\" subsection$")
    public void iShouldSeeInTheAdrSubsection(String text, String subsection) {
        techRecordPageSteps.checkTextInAdrSubsection(text, subsection);
    }

    @When("^I upload adr document$")
    public void iUploadAdrDocument() {
        techRecordPageSteps.uploadAdrDocument();
    }

    @When("^I remove all adr documents$")
    public void iRemoveAllAdrDocuments() {
        techRecordPageSteps.removeAllAdrDocuments();
    }

    @When("^I remove adr documents with index$")
    public void iRemoveAdrDocuments(int index) {
        techRecordPageSteps.removeAdrDocuments(index);
    }

    @Then("^(?:I confirm adr document is uploaded|I confirm adr documents are uploaded)$")
    public void iConfirmDocumentIsUploaded() {
        techRecordPageSteps.checkNumberOfTankDocumentsOnEdit();
    }

    @Then("^(?:I confirm adr document is removed from the tank details|I confirm adr documents are removed from the tank details)$")
    public void iConfirmDocumentIsRemovedFrom() {
        techRecordPageSteps.checkNumberOfTankDocumentsOnEdit();
    }

    @Then("^(?:I confirm adr document is not added on the tank details|I confirm adr documents are not added on the tank details)$")
    public void iConfirmDocumentIsNotAddedOnTankDetails() {
        techRecordPageSteps.checkNumberOfTankDocuments();
    }

    @Then("^(?:I confirm adr document is added on the tank details|I confirm adr documents are added on the tank details)$")
    public void iConfirmDocumentIsAddedOnTankDetails() {
        techRecordPageSteps.checkNumberOfTankDocuments();
    }

    @Then("^(?:I confirm adr document is deleted from the tank details|I confirm adr documents are deleted from the tank details)$")
    public void iConfirmDocumentIsRemovedFromTankDetails() {
        techRecordPageSteps.checkNumberOfTankDocuments();
    }

    @Then("^(?:I confirm adr document is not deleted from the tank details|I confirm adr documents are not deleted from the tank details)$")
    public void iConfirmDocumentIsNotRemovedFromTankDetails() {
        techRecordPageSteps.checkNumberOfTankDocuments();
    }

    @When("^I download tank document with index (\\d+)$")
    public void iDownloadTankDocumentWithIndex(int index) {
        techRecordPageSteps.downloadTankDocument(index);
    }

    @When("^I select substances permitted \"([^\"]*)\" option$")
    public void iSelectSubstancesPermittedOption(String substancesPermittedType) {
        techRecordPageSteps.selectSubstancesPermittedOption(substancesPermittedType);
    }

    @When("^I input \"([^\"]*)\" as product list reference number$")
    public void iInputAsProductListReferenceNumber(String refNo) {
        techRecordPageSteps.setProductListReferenceNumber(refNo);
    }

    @When("^I input \"([^\"]*)\" as battery list reference number$")
    public void iInputAsBatteryListReferenceNumber(String refNo) {
        techRecordPageSteps.setBatteryListReferenceNumber(refNo);
    }

    @When("^I add UN number \"([^\"]*)\"$")
    public void iAddUNNumber(String unNumber) {
        techRecordPageSteps.iClickAdrDetailsLink("Add a UN number");
        techRecordPageSteps.iInputNewUnNumber(unNumber);
    }

    @When("^I remove UN number with index (\\d+)$")
    public void iRemoveUNNumberWithIndex(int index) {
        techRecordPageSteps.removeUnNumber(index);
    }

    @Then("^I should see the \"([^\"]*)\" of newly created vehicle$")
    public void iShouldSeeAttributeOfNewlyCreatedVehicle(String attribute) {
        techRecordPageSteps.checkValueInTechRecordField(genericBackendRequestSteps.getNewVehicleAttribute(attribute),
                attribute);
    }

    @When("^I add initial inspection with certificate \"([^\"]*)\" and expiry date \"([^\"]*)\"$")
    public void addInitialInspectionWithCertificateAndExpiryDate(String certificateNo, String expiryDate) {
        techRecordPageSteps.addInitialInspection(certificateNo, expiryDate);
    }

    @When("^I add subsequent inspection with index (\\d+) of type \"([^\"]*)\" with certificate \"([^\"]*)\" and expiry date \"([^\"]*)\"$")
    public void addSubsequentInspectionOfTypeWithCertificateAndExpiryDate
            (int index, String inspectionType, String certificateNo, String expiryDate) {
        techRecordPageSteps.addSubsequentInspection(index, inspectionType, certificateNo, expiryDate);
    }

    @When("^I add subsequent inspection of type \"([^\"]*)\" with certificate \"([^\"]*)\" and expiry date \"([^\"]*)\"$")
    public void addSubsequentInspectionOfTypeWithCertificateAndExpiryDate
            (String inspectionType, String certificateNo, String expiryDate) {
        techRecordPageSteps.addSubsequentInspection(inspectionType, certificateNo, expiryDate);
    }

    @When("^I set the vehicle to ([^\"]*) able to carry dangerous goods$")
    public void iSelectTheVehicleToBeAbleToCarryDangerousGoods(String option) {
        techRecordPageSteps.selectHasAdrDetails(option);
    }

    @When("^I fill in applicant ([^\"]*) with \"([^\"]*)\"$")
    public void iFillInApplicantFieldWithValue(String applicantField, String value) {
        techRecordPageSteps.fillInApplicantFieldWithValue(applicantField, value);
    }

    @When("^I set processed date to \"([^\"]*)\"$")
    public void iSetProcessedDateTo(String processedDate) {
        techRecordPageSteps.setProcessedDate(processedDate);
    }

    @When("^I set compatibility group J to \"([^\"]*)\"$")
    public void iSetCompatibilityGroupJTo(String option)  {
        techRecordPageSteps.setCompatibilityGroupJ(option);
    }

    @When("^I fill in adr approval type number with \"([^\"]*)\"$")
    public void iFillInAdrApprovalTypeNumberWithValue(String approvalNo) {
        techRecordPageSteps.fillInAdrApprovalTypeNumberWithValue(approvalNo);
    }

    @When("^I fill in tank ([^\"]*) with \"([^\"]*)\"$")
    public void iFillInTankMakeWith(String tankField, String value) {
        techRecordPageSteps.fillInTankFieldWithValue(tankField, value);
    }

    @When("^I fill in special provisions with \"([^\"]*)\"$")
    public void iFillInSpecialProvisionsWith(String provisions) {
        techRecordPageSteps.fillInSpecialProvisions(provisions);
    }

    @When("^I set memo 07/09 to \"([^\"]*)\"$")
    public void iSetMemoTo(String option) {
        techRecordPageSteps.setMemoTo(option);
    }

    @And("^I set certificate required to \"([^\"]*)\"$")
    public void iSetCertificateRequiredTo(String option) {
        techRecordPageSteps.setCertificateRequiredTo(option);
    }

    @And("^I fill in additional adr details with \"([^\"]*)\"$")
    public void iFillInAdditionalAdrDetailsWith(String details) {
        techRecordPageSteps.fillInAdditionalAdrDetailsWith(details);
    }

    @When("^I cancel saving the tech record details$")
    public void iCancelSavingTheDetails() {
        techRecordPageSteps.cancelSavingDetails();
    }

    @And("^I fill in additional product list details with \"([^\"]*)\"$")
    public void iFillInAdditionalProductListDetailsWithValue(String details) {
        techRecordPageSteps.fillInAdditionalProductListDetailsWithValue(details);
    }

    @When("^I fill in issuer with \"([^\"]*)\"$")
    public void iFillInIssuerWithValue(String issuer) {
        techRecordPageSteps.fillInIssuerWithValue(issuer);
    }

    @When("^I fill in brake weight with (\\d+)$")
    public void iFillInBrakeWeightWithValue(String weight) {
        techRecordPageSteps.fillInBrakeWeightWithValue(weight);
    }

    @And("^I upload adr document \"([^\"]*)\"$")
    public void iUploadAdrDocument(String fileName) {
        techRecordPageSteps.uploadAdrDocument(fileName);
    }

    @Then("^I confirm adr document \"([^\"]*)\" is uploaded$")
    public void iConfirmAdrDocumentIsUploaded(String fileName) {
        techRecordPageSteps.confirmAdrDocumentIsUploaded(fileName);
    }

    @And("^I confirm adr document \"([^\"]*)\" is added on the tank details$")
    public void iConfirmAdrDocumentIsAddedOnTheTankDetails(String fileName) {
        techRecordPageSteps.checkAdrDocumentPresentInTankDetails(fileName);
    }

    @When("^I download tank document \"([^\"]*)\"$")
    public void iDownloadTankDocument(String fileName) {
        techRecordPageSteps.downloadTankDocument(fileName);
    }

    @Then("^I should see error message \"(.*)\"$")
    public void iShouldSeeErrorMessage(String message) {
        techRecordPageSteps.checkErrorMessageIsPresent(message);
    }

    @When("^I go to view test record with index (\\d+)$")
    public void iClickViewOnTestRecordWithIndex(int testIndex) {
        techRecordPageSteps.clickViewForTestRecordWithIndex(testIndex);
    }

    @Then("^the \"([^\"]*)\" tech record section should be empty$")
    public void thenTheSectionShouldBeEmpty(String section) {
        techRecordPageSteps.checkSectionEmpty(section);
    }

    @Then("^the \"([^\"]*)\" tech record section should have (\\d+) entry$")
    public void techRecordSectionShouldHaveEntry(String section, int numberOfEntries) {
        techRecordPageSteps.checkNumberOfEntriesInSection(section, numberOfEntries);
    }

    @Then("^the \"([^\"]*)\" tech record section should have (\\d+) entries$")
    public void techRecordSectionShouldHaveEntries(String section, int numberOfEntries) {
        techRecordPageSteps.checkNumberOfEntriesInSection(section, numberOfEntries);
    }

    @Then("^tech record sections are displayed$")
    public void iShouldSeeTestRecordSections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkSectionIsPresent(stringMap.get("Section"));
        }
    }

    @Then("^tech record sections are not displayed$")
    public void iShouldNotSeeTestRecordSections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkSectionIsNotPresent(stringMap.get("Section"));
        }
    }

    @Then("^all tech record sections should be expanded$")
    public void checkAllSectionsAreExpanded() {
        techRecordPageSteps.checkAllSectionsAreExpanded();
    }

    @Then("^tech record fields of newly created test should have correct values$")
    public void techRecordFieldForNewlyCreatedTestShouldHaveValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkValueInTechRecordField(
                    genericBackendRequestSteps.getNewTestAttribute(stringMap.get("Field")), stringMap.get("Field"));
        }
    }

    @Then("^I should see \"([^\"]*)\" in \"([^\"]*)\" tech record section$")
    public void iShouldSeeInTestRecordSection(String text, String section) {
        techRecordPageSteps.checkTextIsPresentInSection(text, section);
    }

    @Then("^I should not see \"([^\"]*)\" in \"([^\"]*)\" tech record section$")
    public void iShouldNotSeeInTestRecordSection(String text, String section) {
        techRecordPageSteps.checkTextIsNotPresentInSection(text, section);
    }

    @Then("^tech record fields should be editable$")
    public void techRecordFieldsShouldBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkFieldEditable(stringMap.get("Field"));
        }
    }

    @Then("^tech record fields should not be editable$")
    public void techRecordFieldsShouldNotBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkFieldNotEditable(stringMap.get("Field"));
        }
    }

    @Then("^test record fields of newly created test should have correct values$")
    public void testRecordFieldForNewlyCreatedTestShouldHaveValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkValueInTechRecordField(
                    genericBackendRequestSteps.getNewTestAttribute(stringMap.get("Field")), stringMap.get("Field"));
        }
    }

    @Then("^I should not see Subsequent Inspection Type field$")
    public void iShouldNotSeeSubsequentInspectionTypeField() {
        techRecordPageSteps.iShouldNotSeeSubsequentInspectionTypeField();
    }

    @Then("^I should not see Subsequent Inspection Certificate field$")
    public void iShouldNotSeeSubsequentInspectionCertificateField() {
        techRecordPageSteps.iShouldNotSeeSubsequentInspectionCertificateField();
    }

    @Then("^I should not see Subsequent Inspection Expiry Date fields$")
    public void iShouldNotSeeSubsequentInspectionExpiryDateFields() {
        techRecordPageSteps.iShouldNotSeeSubsequentInspectionExpiryDateFields();
    }
}
