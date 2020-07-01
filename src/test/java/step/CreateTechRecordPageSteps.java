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
}
