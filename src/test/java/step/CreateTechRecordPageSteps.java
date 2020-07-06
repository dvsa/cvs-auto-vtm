package step;

import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import pages.CreateTechRecordPage;

import java.util.Random;

public class CreateTechRecordPageSteps extends GenericPageSteps {

    CreateTechRecordPage createTechRecordPage;

    @Step
    public void fillInVin(String vin) {
        createTechRecordPage.fillInVin(vin);
    }

    @Step
    public void fillInVrm(String vrm) {
        createTechRecordPage.fillInVrm(vrm);
    }

    @Step
    public void selectVehicleType(String vehicleType) {
        createTechRecordPage.selectVehicleType(vehicleType);
    }

    @Step
    public void specificErrorContains(String errorType, String text) {
        createTechRecordPage.specificErrorContains(errorType, text);
    }

    @Step
    public void specificErrorNotContains(String errorType, String text) {
        createTechRecordPage.specificErrorNotContains(errorType, text);
    }

    @Step
    public void checkInputFieldText(String text, String input) {
        createTechRecordPage.checkInputFieldText(text, input);
    }

    @Step
    public void checkEditInputFieldText(String text, String input) {
        createTechRecordPage.checkEditInputFieldText(text, input);
    }

    @Step
    public void checkNotInputFieldText(String text, String input) {
        createTechRecordPage.checkNotInputFieldText(text, input);
    }

    @Step
    public void checkInputDescription(String text, String field) {
        createTechRecordPage.checkInputDescription(text, field);
    }

    @Step
    public void checkNotInputDescription(String text, String field) {
        createTechRecordPage.checkNotInputDescription(text, field);
    }

    @Step
    public void checkNoSpecificErrorForField(String fieldType) {
        createTechRecordPage.checkNoSpecificErrorForField(fieldType);
    }

    @Step
    public String fillInRandomVin() {
        String randomVin = RandomStringUtils.randomAlphanumeric(new Random().nextInt(13) + 3).toUpperCase() + RandomStringUtils.randomNumeric(6);
        createTechRecordPage.fillInVin(randomVin);
        return randomVin;
    }

    @Step
    public String fillInRandomVrm() {
        String randomVrm = RandomStringUtils.randomAlphanumeric(new Random().nextInt(6) + 3).toUpperCase();
        createTechRecordPage.fillInVrm(randomVrm);
        return randomVrm;
    }

    @Step
    public String setVinToRandomValue() {
        return createTechRecordPage.setVinToRandomValue();
    }

    @Step
    public String setVrmToRandomValue() {
        return createTechRecordPage.setVrmToRandomValue();
    }

    @Step
    public void checkSectionIsPresent(String section) {
        createTechRecordPage.checkSectionIsPresent(section);
    }

    @Step
    public void checkSectionIsNotPresent(String section) {
        createTechRecordPage.checkSectionIsNotPresent(section);
    }

    @Step
    public void checkAllSectionsAreExpanded() {
        createTechRecordPage.checkAllSectionsAreExpanded();
    }

    @Step
    public void checkAllSectionsAreCollapsed() {
        createTechRecordPage.checkAllSectionsAreCollapsed();
    }

    @Step
    public void setValueForTechRecordInputField(String field, String value) {
        createTechRecordPage.setValueForInputField(field, value);
    }

    @Step
    public void setValueForTechRecordRadioButtonField(String field, String value) {
        createTechRecordPage.setValueForRadioButtonField(field, value);
    }

    @Step
    public void setValueForTechRecordSelectField(String field, String value) {
        createTechRecordPage.setValueForSelectField(field, value);
    }

    @Step
    public void checkTestRecordInputFieldValue(String inputField, String value) {
        createTechRecordPage.checkValueForInputField(inputField, value);
    }

    @Step
    public void checkTestRecordRadioButtonFieldValue(String radioButtonField, String value) {
        createTechRecordPage.checkValueForRadioButtonField(radioButtonField, value);
    }

    @Step
    public void checkTestRecordSelectFieldValue(String selectField, String value) {
        createTechRecordPage.checkValueForSelectField(selectField, value);
    }

    @Step
    public void checkFieldEditable(String field) {
        createTechRecordPage.checkFieldEditable(field);
    }

    @Step
    public void checkFieldNotEditable(String field) {
        createTechRecordPage.checkFieldNotEditable(field);
    }
}
