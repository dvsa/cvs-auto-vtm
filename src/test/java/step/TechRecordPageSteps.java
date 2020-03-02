package step;

import net.thucydides.core.annotations.Step;
import pages.TechRecordPage;

public class TechRecordPageSteps extends GenericPageSteps {

    TechRecordPage techRecordPage;

    @Step
    public String getValueForTechRecordField(String field) {
        return techRecordPage.getValueForTechRecordField(field);
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
    public void openSection(String arg0) throws Exception {
        techRecordPage.openSection(arg0);
    }

    @Step
    public void closeSection(String arg0) throws Exception {
        techRecordPage.closeSection(arg0);
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
    public void selectDangerousGoodCheckbox(String arg0) throws Exception {
        techRecordPage.selectDangerousGoodCheckbox(arg0);
    }

    @Step
    public void deselectDangerousGoodCheckbox(String arg0) throws Exception {
        techRecordPage.deselectDangerousGoodCheckbox(arg0);
    }

    @Step
    public void iSelectFromTankStatement(String arg0) {
        techRecordPage.selectFromTankStatement(arg0);
    }

    @Step
    public void iShouldSeeStatementField(String arg0) {
        techRecordPage.checkStatementField(arg0);
    }

    @Step
    public void iShouldSeeProductListField(String arg0) {
        techRecordPage.checkProductListField(arg0);
    }

    @Step
    public void iSelectVehicleType(String arg0) {
        techRecordPage.selectVehicleType(arg0);
    }

    @Step
    public void iSelectFromBatteryListApplicable(String arg0) {
        techRecordPage.selectFromBatteryListApplicable(arg0);
    }

    @Step
    public void iShouldSeeBatteryListField(String arg0) {
        techRecordPage.checkBatteryListApplicableField(arg0);
    }

    @Step
    public void iShouldNotSeeBatteryListFields() {
        techRecordPage.checkBatteryListApplicableFieldsNotPresent();
    }

    @Step
    public void iSelectCheckbox(String arg0) {
        techRecordPage.selectCheckbox(arg0);
    }

    @Step
    public void iDeselectCheckbox(String arg0) {
        techRecordPage.deselectCheckbox(arg0);
    }

    @Step
    public void iShouldSeeManufacturerBrakeDeclarationField(String arg0) {
        techRecordPage.checkManufacturerBrakeDeclarationField(arg0);
    }

    @Step
    public void iShouldNotSeeManufacturerBrakeDeclarationField(String arg0) {
        techRecordPage.checkManufacturerBrakeDeclarationFieldNotPresent(arg0);
    }

    @Step
    public void iShouldSeeBrakeEndurance(String arg0) {
        techRecordPage.checkBrakeEnduranceField(arg0);
    }

    @Step
    public void iShouldNotSeeBrakeEndurance(String arg0) {
        techRecordPage.checkBrakeEnduranceFieldNotPresent(arg0);
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
    public void iClickLink(String arg0) throws  Exception {
        techRecordPage.clickLink(arg0);
    }

    @Step
    public void goBackToSearchPage() {
        techRecordPage.goBackToSearchPage();
    }

    @Step
    public void iSelectCustomDangerousGoodCheckbox(String arg0) {
        techRecordPage.selectCustomDangerousGoodCheckbox(arg0);
    }

    @Step
    public void iDeselectCustomDangerousGoodCheckbox(String arg0) {
        techRecordPage.deselectCustomDangerousGoodCheckbox(arg0);
    }

    @Step
    public void iInputCustomDangerousGood(String arg0) {
        techRecordPage.inputCustomDangerousGood(arg0);
    }

    @Step
    public void iInputCustomGuidanceNote(String arg0) {
        techRecordPage.inputCustomGuidanceNote(arg0);
    }

    @Step
    public void iSelectCustomGuidanceNoteCheckbox(String arg0) {
        techRecordPage.selectCustomGuidanceNoteCheckbox(arg0);
    }

    @Step
    public void iDeselectCustomGuidanceNoteCheckbox(String arg0) {
        techRecordPage.deselectCustomGuidanceNoteCheckbox(arg0);
    }

    @Step
    public void iInputNewUnNumber(String arg0) {
        techRecordPage.inputUnNewNumber(arg0);
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
    public void iShouldSeeSectionHeading(String arg0) {
        techRecordPage.iShouldSeeSectionHeading(arg0);
    }
}
