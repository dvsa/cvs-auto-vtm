package step;

import net.thucydides.core.annotations.Step;
import pages.TestRecordPage;

public class TestRecordPageSteps extends GenericPageSteps {

    TestRecordPage testRecordPage;

    public void checkTestRecordPageUrl() {
        testRecordPage.checkTestRecordPageUrl();
    }

    @Step
    public void openAllSections() {
        testRecordPage.openAllSections();
    }

    @Step
    public void closeAllSections() {
        testRecordPage.closeAllSections();
    }

    @Step
    public void openSection(String section) {
        testRecordPage.openSection(section);
    }

    @Step
    public void closeSection(String section) {
        testRecordPage.closeSection(section);
    }

    @Step
    public void setReasonForChanges(String reason) {
        testRecordPage.setReasonForChanges(reason);
    }

    @Step
    public void confirmSavingChanges() {
        testRecordPage.confirmSavingChanges();
    }

    @Step
    public void cancelSavingChanges() {
        testRecordPage.cancelSavingChanges();
    }

    @Step
    public void increaseOdometerReadingBy(int value) {
        testRecordPage.increaseOdometerReadingBy(value);
    }

    @Step
    public void checkTextIsPresentInSaveChangesModal(String text) {
        testRecordPage.checkTextIsPresentInSaveChangesModal(text);
    }

    @Step
    public void checkValueInTestRecordField(String value, String field) {
        testRecordPage.checkValueInTestRecordField(value, field);
    }

    @Step
    public void checkOdometerReadingValue() {
        testRecordPage.checkOdometerReadingValue();
    }

    @Step
    public void checkOdometerReadingValueOnEdit() {
        testRecordPage.checkOdometerReadingValueOnEdit();
    }

    @Step
    public void cancelSavingDetails() {
        testRecordPage.cancelSavingDetails();
    }

    @Step
    public void checkFieldEditable(String field) {
        testRecordPage.checkFieldEditable(field);
    }

    @Step
    public void checkFieldNotEditable(String field) {
        testRecordPage.checkFieldNotEditable(field);
    }

    @Step
    public void setValueForTestRecordInputField(String field, String value) {
        testRecordPage.setValueForTestRecordInputField(field, value);
    }

    @Step
    public void setValueForTestRecordRadioButtonField(String field, String value) {
        testRecordPage.setValueForTestRecordRadioButtonField(field, value);
    }

    @Step
    public void setValueForTestRecordSelectField(String field, String value) {
        testRecordPage.setValueForTestRecordSelectField(field, value);
    }

    @Step
    public void checkNumberOfEntriesInSection(String section, int numberOfEntries) {
        testRecordPage.checkNumberOfEntriesInSection(section, numberOfEntries);
    }

    @Step
    public void checkSectionIsExpanded(String section) {
        testRecordPage.checkSectionIsExpanded(section);
    }

    @Step
    public void checkAllSectionsAreExpanded() {
        testRecordPage.checkAllSectionsAreExpanded();
    }

    @Step
    public void checkAllSectionsAreCollapsed() {
        testRecordPage.checkAllSectionsAreCollapsed();
    }

    @Step
    public void expandSection(String section) {
        testRecordPage.expandSection(section);
    }

    @Step
    public void collapseSection(String section) {
        testRecordPage.collapseSection(section);
    }

    @Step
    public void checkSectionIsPresent(String section) {
        testRecordPage.checkSectionIsPresent(section);
    }

    @Step
    public void checkSectionIsNotPresent(String section) {
        testRecordPage.checkSectionIsNotPresent(section);
    }

    @Step
    public void checkTextIsPresentInSection(String field, String section) {
        testRecordPage.checkTextIsPresentInSection(field, section);
    }

    @Step
    public void checkTextIsNotPresentInSection(String field, String section) {
        testRecordPage.checkTextIsNotPresentInSection(field, section);
    }

    @Step
    public void checkSectionEmpty(String section) {
        testRecordPage.checkSectionEmpty(section);
    }

    @Step
    public void checkTestRecordInputFieldValue(String inputField, String value) {
        testRecordPage.checkTestRecordInputFieldValue(inputField, value);
    }

    @Step
    public void checkTestRecordRadioButtonFieldValue(String radioButtonField, String value) {
        testRecordPage.checkTestRecordRadioButtonFieldValue(radioButtonField, value);
    }

    @Step
    public void checkTestRecordSelectFieldValue(String selectField, String value) {
        testRecordPage.checkTestRecordSelectFieldValue(selectField, value);
    }

    @Step
    public void checkTestStationType(String value) {
        testRecordPage.checkTestStationType(value);
    }
}
