package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import step.TechRecordPageSteps;

import java.util.List;
import java.util.Map;

public class TechRecordPageStepDefinition {

    @Steps
    TechRecordPageSteps techRecordPageSteps;

    @Then("^tech record fields should have values$")
    public void techRecordFieldShouldHaveValue(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkValueInTechRecordField(stringMap.get("Value"), stringMap.get("Field"));
        }
    }

    @Then("^I open all sections$")
    public void iOpenAllSections() {
        techRecordPageSteps.openAllSections();
    }

    @Then("^I close all sections$")
    public void iCloAllSections() {
        techRecordPageSteps.closeAllSections();
    }

    @When("^I open \"([^\"]*)\" section$")
    public void iOpenSection(String section) throws Throwable {
        techRecordPageSteps.openSection(section);
    }

    @When("^I close \"([^\"]*)\" section$")
    public void iCloseSection(String section) throws Throwable {
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
    public void iSelectDangerousGood(String dangerousGood) throws Throwable {
        techRecordPageSteps.selectDangerousGoodCheckbox(dangerousGood);
    }

    @When("^I deselect \"([^\"]*)\" dangerous good$")
    public void iDeselectDangerousGood(String dangerousGood) throws Throwable {
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

    @When("^I select \"([^\"]*)\" vehicle type$")
    public void iSelectVehicleType(String vehicleType) {
        techRecordPageSteps.iSelectVehicleType(vehicleType);
    }

    @When("^I select \"([^\"]*)\" from battery list applicable$")
    public void iSelectFromBatteryListApplicable(String option) {
        techRecordPageSteps.iSelectFromBatteryListApplicable(option);
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
    public void iClickLink(String linkText) throws Throwable {
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

    @When("^I select \"([^\"]*)\" custom guidance note$")
    public void iSelectCustomGuidanceNote(String note) {
        techRecordPageSteps.iSelectCustomGuidanceNoteCheckbox(note);
    }

    @When("^I deselect \"([^\"]*)\" custom guidance note$")
    public void iDeselectCustomGuidanceNote(String note) {
        techRecordPageSteps.iDeselectCustomGuidanceNoteCheckbox(note);
    }

    @When("^I input \"([^\"]*)\" as new UN number$")
    public void iInputNewUnNumber(String unNumber) {
        techRecordPageSteps.iInputNewUnNumber(unNumber);
    }

    @Then("^I should see the subsequent inspection fields$")
    public void iShouldSeeTheSubsequentInspectionFields() {
        techRecordPageSteps.iShouldSeeTheSubsequentInspectionFields();
    }

    @Then("^I should see \"([^\"]*)\" section heading$")
    public void iShouldSeeSectionHeading(String heading) {
        techRecordPageSteps.iShouldSeeSectionHeading(heading);
    }

    @Then("^the \"([^\"]*)\" section should have \"([^\"]*)\" entries$")
    public void theSectionShouldHaveEntries(String section, String numberOfEntries) {
        techRecordPageSteps.checkNumberOfEntriesInSection(numberOfEntries, section);
    }

    @Then("^I should see \"([^\"]*)\" adr field$")
    public void iShouldSeeAdrField(String adrField) {
        techRecordPageSteps.checkAdrFieldDisplayed(adrField);
    }

    @Then("^I should see adr subsections$")
    public void iShouldSeeAdrSubsections(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            techRecordPageSteps.checkAdrSubsectionIsPresent(stringMap.get("Subsection"));
        }
    }

    @When("^I upload adr document$")
    public void iUploadAdrDocument() {
        techRecordPageSteps.uploadAdrDocument();
    }

    @When("^I enter \"([^\"]*)\" as reason for changes$")
    public void iEnterAsReasonForChanges(String reason) {
        techRecordPageSteps.setReasonForChanges(reason);
    }

    @When("^I confirm saving the details$")
    public void iConfirmSavingTheDetails() {
        techRecordPageSteps.confirmSavingDetails();
    }

    @Then("^I should see \"([^\"]*)\" in the adr \"([^\"]*)\" subsection$")
    public void iShouldSeeInTheAdrSubsection(String text, String subsection) {
        techRecordPageSteps.checkTextInAdrSubsection(text, subsection);
    }

    @Then("^I confirm adr document is uploaded$")
    public void iConfirmDocumentIsUploaded() {
        techRecordPageSteps.checkAdrDocumentIsUploaded();
    }

    @Then("^I confirm number of tank documents$")
    public void iConfirmNumberOfTankDocuments() {
        techRecordPageSteps.checkNumberOfTankDocuments();
    }

    @And("^I remove all adr documents$")
    public void iRemoveAllAdrDocuments() {
        techRecordPageSteps.removeAllAdrDocuments();
    }

    @When("^I download tank document with index (\\d+)$")
    public void iDownloadTankDocumentWithIndex(int index) {
        techRecordPageSteps.downloadTankDocument(index);
    }
}
