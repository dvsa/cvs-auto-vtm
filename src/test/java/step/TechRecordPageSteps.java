package step;

import net.thucydides.core.annotations.Step;
import pages.TechRecordPage;

public class TechRecordPageSteps extends GenericPageSteps {

    TechRecordPage techRecordPage;

    @Step
    public void openAllSections() {
        techRecordPage.openAllSections();
    }

    @Step
    public void closeAllSections() {
        techRecordPage.closeAllSections();
    }

    @Step
    public void openSection(String section) {
        techRecordPage.openSection(section);
    }

    @Step
    public void closeSection(String section) {
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
    public void selectDangerousGoodCheckbox(String dangerousGood) {
        techRecordPage.selectDangerousGoodCheckbox(dangerousGood);
    }

    @Step
    public void deselectDangerousGoodCheckbox(String dangerousGood) {
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
    public void iSelectAdrVehicleType(String vehicleType) {
        techRecordPage.selectAdrVehicleType(vehicleType);
    }

    @Step
    public void setBatteryListApplicable(String option) {
        techRecordPage.setBatteryListApplicable(option);
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
    public void iClickAdrDetailsLink(String link) {
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
    public void iSelectGuidanceNoteCheckbox(String note) {
        techRecordPage.selectGuidanceNoteCheckbox(note);
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
    public void checkSectionIsPresent(String heading) {
        techRecordPage.checkSectionIsPresent(heading);
    }

    @Step
    public void checkNumberOfEntriesInSection(String section, int numberOfEntries) {
        techRecordPage.checkNumberOfEntriesInSection(section, numberOfEntries);
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
    public void checkAdrSubsectionIsNotPresent(String subsection) {
        techRecordPage.checkAdrSubsectionIsNotPresent(subsection);
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
    public void confirmSavingChanges() {
        techRecordPage.confirmSavingChanges();
    }

    @Step
    public void checkTextInAdrSubsection(String text, String subsection) {
        techRecordPage.checkTextInAdrSubsection(text, subsection);
    }

    @Step
    public void checkNumberOfTankDocuments() {
        techRecordPage.checkNumberOfTankDocuments();
    }

    @Step
    public void checkNumberOfTankDocumentsOnEdit() {
        techRecordPage.checkNumberOfTankDocumentsOnEdit();
    }

    @Step
    public void removeAllAdrDocuments() {
        techRecordPage.removeAllAdrDocuments();
    }

    @Step
    public void checkValueInTechRecordField(String value, String field) {
        techRecordPage.checkValueInTechRecordField(value, field);
    }

    @Step
    public void downloadTankDocument(int index) {
        techRecordPage.downloadTankDocument(index);
    }

    @Step
    public void downloadTankDocument(String fileName) {
        techRecordPage.downloadTankDocument(fileName);
    }

    @Step
    public void removeAdrDocuments(int index) {
        techRecordPage.removeAdrDocuments(index);
    }

    @Step
    public void removeAdrDocuments(String fileName) {
        techRecordPage.removeAdrDocuments(fileName);
    }

    @Step
    public void selectSubstancesPermittedOption(String substancesPermittedType) {
        techRecordPage.selectSubstancesPermittedOption(substancesPermittedType);
    }

    @Step
    public void setProductListReferenceNumber(String refNo) {
        techRecordPage.setProductListReferenceNumber(refNo);
    }

    @Step
    public void setBatteryListReferenceNumber(String refNo) {
        techRecordPage.setBatteryListReferenceNumber(refNo);
    }

    @Step
    public void removeUnNumber(int index) {
        techRecordPage.removeUnNumber(index);
    }

    @Step
    public void addInitialInspection(String certificateNo, String expiryDate) {
        techRecordPage.addInitialInspection(certificateNo, expiryDate);
    }

    @Step
    public void addSubsequentInspection(int index, String inspectionType, String certificateNo, String expiryDate) {
        techRecordPage.addSubsequentInspection(index, inspectionType, certificateNo, expiryDate);
    }

    @Step
    public void selectHasAdrDetails(String option) {
        techRecordPage.selectHasAdrDetails(option);
    }

    @Step
    public void addSubsequentInspection(String inspectionType, String certificateNo, String expiryDate) {
        techRecordPage.clickLink("Add a subsequent inspection");
        techRecordPage.addSubsequentInspection(inspectionType, certificateNo, expiryDate);
    }

    @Step
    public void fillInApplicantFieldWithValue(String applicantField, String value) {
        techRecordPage.fillInOwnerFieldWithValue(applicantField, value);
    }

    @Step
    public void setProcessedDate(String processedDate) {
        techRecordPage.setProcessedDate(processedDate);
    }

    @Step
    public void setCompatibilityGroupJ(String option) {
        techRecordPage.setCompatibilityGroupJ(option);
    }

    @Step
    public void fillInAdrApprovalTypeNumberWithValue(String approvalNo) {
        techRecordPage.fillInAdrApprovalTypeNumberWithValue(approvalNo);
    }

    @Step
    public void fillInTankFieldWithValue(String tankField, String value) {
        techRecordPage.fillInTankFieldWithValue(tankField, value);
    }

    @Step
    public void fillInSpecialProvisions(String provisions) {
        techRecordPage.fillInSpecialProvisions(provisions);
    }

    @Step
    public void setMemoTo(String option) {
        techRecordPage.setMemoTo(option);
    }

    @Step
    public void setCertificateRequiredTo(String option) {
        techRecordPage.setCertificateRequiredTo(option);
    }

    @Step
    public void fillInAdditionalAdrDetailsWith(String details) {
        techRecordPage.fillInAdditionalAdrDetailsWith(details);
    }

    @Step
    public void cancelSavingDetails() {
        techRecordPage.cancelSavingDetails();
    }

    @Step
    public void fillInAdditionalProductListDetailsWithValue(String details) {
        techRecordPage.fillInAdditionalProductListDetailsWithValue(details);
    }

    @Step
    public void fillInIssuerWithValue(String issuer) {
        techRecordPage.fillInIssuerWithValue(issuer);
    }

    @Step
    public void fillInBrakeWeightWithValue(String weight) {
        techRecordPage.fillInBrakeWeightWithValue(weight);
    }

    @Step
    public void uploadAdrDocument(String fileName) {
        techRecordPage.uploadAdrDocument(fileName);
    }

    @Step
    public void confirmAdrDocumentIsUploaded(String fileName) {
        techRecordPage.confirmAdrDocumentIsUploaded(fileName);
    }

    @Step
    public void checkAdrDocumentPresentInTankDetails(String fileName) {
        techRecordPage.checkAdrDocumentPresentInTankDetails(fileName);
    }

    @Step
    public void checkErrorMessageIsPresent(String message) {
        techRecordPage.checkErrorMessageIsPresent(message);
    }

    @Step
    public void clickViewForTestRecordWithIndex(int testIndex) {
        techRecordPage.clickViewForTestRecordWithIndex(testIndex);
    }

    @Step
    public void checkSectionEmpty(String section) {
        techRecordPage.checkSectionEmpty(section);
    }

    @Step
    public void setInputTechRecordField(String field, String country) {
        techRecordPage.setInputTechRecordField(field, country);
    }

    @Step
    public void setRadioButtonTechRecordField(String field, String value) {
        techRecordPage.setRadioButtonTechRecordField(field, value);
    }

    @Step
    public void setSelectTechRecordField(String field, String value) {
        techRecordPage.setSelectTechRecordField(field, value);
    }

    @Step
    public void checkAllSectionsAreExpanded() {
        techRecordPage.checkAllSectionsAreExpanded();
    }

    @Step
    public void checkTextIsPresentInSection(String text, String section) {
        techRecordPage.checkTextIsPresentInSection(text, section);
    }

    @Step
    public void checkTextIsNotPresentInSection(String text, String section) {
        techRecordPage.checkTextIsNotPresentInSection(text, section);
    }

    @Step
    public void checkSectionIsNotPresent(String section) {
        techRecordPage.checkSectionIsNotPresent(section);
    }
}
