package step;

import net.thucydides.core.annotations.Step;
import pages.TechRecordPage;

public class TechRecordPageSteps {

    TechRecordPage techRecordPage;

    @Step
    public String getValueForTechRecordField(String field) {
        return techRecordPage.getValueForTechRecordField(field);
    }

    @Step
    public void waitForTextToAppear(String arg0) {
        techRecordPage.waitForTextToAppear(arg0, 20);
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
}
