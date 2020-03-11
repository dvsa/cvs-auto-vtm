package step;

import net.thucydides.core.annotations.Step;
import pages.CreateTechRecordPage;

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
    public void selectVehicleType(String vehicleType) throws Exception {
        createTechRecordPage.selectVehicleType(vehicleType);
    }

    @Step
    public void headerErrorContains(String text) {
        createTechRecordPage.headerErrorContains(text);
    }

    @Step
    public void specificErrorContains(String errorType, String text) throws Exception {
        createTechRecordPage.specificErrorContains(errorType, text);
    }

    @Step
    public void checkInputFieldText(String text, String input) throws Exception {
        createTechRecordPage.checkInputFieldText(text, input);
    }

    @Step
    public void clickContinueButton() {
        createTechRecordPage.clickContinueButton();
    }

    @Step
    public void headerErrorNotContains(String text) {
        createTechRecordPage.headerErrorNotContains(text);
    }

    @Step
    public void checkNotInputFieldText(String text, String input) throws Exception {
        createTechRecordPage.checkNotInputFieldText(text, input);
    }
}
