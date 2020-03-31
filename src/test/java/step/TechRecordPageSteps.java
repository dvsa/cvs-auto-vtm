package step;

import net.thucydides.core.annotations.Step;
import pages.TechRecordPage;

public class TechRecordPageSteps extends GenericPageSteps {

    TechRecordPage techRecordPage;

    @Step
    public String getValueInTechRecordField(String field) {
        return techRecordPage.getValueInTechRecordField(field);
    }

    @Step
    public void openAllSections() {
        techRecordPage.openAllSections();
    }

    @Step
    public void closeAllSections() {
        techRecordPage.closeAllSections();
    }

    @Step
    public void openSection(String section) throws Exception {
        techRecordPage.openSection(section);
    }

    @Step
    public void closeSection(String section) throws Exception {
        techRecordPage.closeSection(section);
    }

    @Step
    public void editTechRecordDetails() {
        techRecordPage.editTechRecordDetails();
    }

    @Step
    public void saveTechRecordDetails() {
        techRecordPage.saveTechRecordDetails();
    }

    @Step
    public void selectDangerousGoodCheckbox(String dangerousGood) throws Exception {
        techRecordPage.selectDangerousGoodCheckbox(dangerousGood);
    }

    @Step
    public void deselectDangerousGoodCheckbox(String dangerousGood) throws Exception {
        techRecordPage.deselectDangerousGoodCheckbox(dangerousGood);
    }

    @Step
    public void iSelectFromTankStatement(String option) {
        techRecordPage.selectFromTankStatement(option);
    }

    @Step
    public void iShouldSeeStatementField(String field) {
        techRecordPage.checkStatementField(field);
    }

    @Step
    public void iShouldSeeProductListField(String field) {
        techRecordPage.checkProductListField(field);
    }

    @Step
    public void iSelectVehicleType(String vehicleType) {
        techRecordPage.selectVehicleType(vehicleType);
    }

    @Step
    public void iSelectFromBatteryListApplicable(String option) {
        techRecordPage.selectFromBatteryListApplicable(option);
    }

    @Step
    public void iShouldSeeBatteryListField(String field) {
        techRecordPage.checkBatteryListApplicableField(field);
    }

    @Step
    public void iShouldNotSeeBatteryListFields() {
        techRecordPage.checkBatteryListApplicableFieldsNotPresent();
    }

    @Step
    public void iSelectCheckbox(String checkbox) {
        techRecordPage.selectCheckbox(checkbox);
    }

    @Step
    public void iDeselectCheckbox(String checkbox) {
        techRecordPage.deselectCheckbox(checkbox);
    }

    @Step
    public void iShouldSeeManufacturerBrakeDeclarationField(String field) {
        techRecordPage.checkManufacturerBrakeDeclarationField(field);
    }

    @Step
    public void iShouldNotSeeManufacturerBrakeDeclarationFields() {
        techRecordPage.checkManufacturerBrakeDeclarationFieldsNotPresent();
    }

    @Step
    public void iShouldSeeBrakeEnduranceField(String text) {
        techRecordPage.checkBrakeEnduranceField(text);
    }

    @Step
    public void iShouldNotSeeBrakeEnduranceFields() {
        techRecordPage.checkBrakeEnduranceFieldsNotPresent();
    }

    @Step
    public void iShouldNotSeeStatementFields() {
        techRecordPage.checkStatementFieldsNotPresent();
    }

    @Step
    public void iShouldNotSeeProductListFields() {
        techRecordPage.checkProductListFieldsNotPresent();
    }

    @Step
    public void iClickAdrDetailsLink(String link) throws  Exception {
        techRecordPage.iClickAdrDetailsLink(link);
    }

    @Step
    public void iSelectCustomDangerousGoodCheckbox(String customDangerousGood) {
        techRecordPage.selectCustomDangerousGoodCheckbox(customDangerousGood);
    }

    @Step
    public void iDeselectCustomDangerousGoodCheckbox(String customDangerousGood) {
        techRecordPage.deselectCustomDangerousGoodCheckbox(customDangerousGood);
    }

    @Step
    public void iInputCustomDangerousGood(String customDangerousGood) {
        techRecordPage.inputCustomDangerousGood(customDangerousGood);
    }

    @Step
    public void iInputCustomGuidanceNote(String note) {
        techRecordPage.inputCustomGuidanceNote(note);
    }

    @Step
    public void iSelectCustomGuidanceNoteCheckbox(String note) {
        techRecordPage.selectCustomGuidanceNoteCheckbox(note);
    }

    @Step
    public void iDeselectCustomGuidanceNoteCheckbox(String note) {
        techRecordPage.deselectCustomGuidanceNoteCheckbox(note);
    }

    @Step
    public void iInputNewUnNumber(String unNumber) {
        techRecordPage.inputUnNewNumber(unNumber);
    }

    @Step
    public void iInputForTheUnNumber(String unNumber, String ordinal) {
        techRecordPage.inputForTheUnNumber(unNumber, ordinal);
    }

    @Step
    public void iShouldSeeTheSubsequentInspectionFields() {
        techRecordPage.checkSubsequentInspectionFields();
    }

    @Step
    public void iShouldSeeSectionHeading(String heading) {
        techRecordPage.iShouldSeeSectionHeading(heading);
    }

    @Step
    public void checkNumberOfEntriesInSection(String numberOfEntries, String section) {
        techRecordPage.checkNumberOfEntriesInSection(numberOfEntries, section);
    }

    @Step
    public void checkAdrFieldDisplayed(String adrField) {
        techRecordPage.checkAdrFieldDisplayed(adrField);
    }

    @Step
    public void checkAdrSubsectionIsPresent(String subsection) {
        techRecordPage.checkAdrSubsectionIsPresent(subsection);
    }

    @Step
    public void uploadAdrDocument() {
        techRecordPage.uploadAdrDocument();
    }

    @Step
    public void setReasonForChanges(String reason) {
        techRecordPage.setReasonForChanges(reason);
    }

    @Step
    public void confirmSavingDetails() {
        techRecordPage.confirmSavingDetails();
    }

    @Step
    public void checkTextInAdrSubsection(String text, String subsection) {
        techRecordPage.checkTextInAdrSubsection(text, subsection);
    }

    @Step
    public void checkAdrDocumentIsUploaded() {
        techRecordPage.checkAdrDocumentIsUploaded();
    }

    @Step
    public void checkNumberOfTankDocuments() {
        techRecordPage.checkNumberOfTankDocuments();
    }


    @Step
    public void removeAllAdrDocuments() {
        techRecordPage.removeAllAdrDocuments();
    }

    @Step
    public void checkValueInTechRecordField(String value, String field) {
        techRecordPage.checkValueInTechRecordField(value, field);
    }
}
