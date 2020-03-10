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
        createTechRecordPage.fillInVin(vrm);
    }

    @Step
    public void selectVehicleType(String vehicleType) throws Exception {
        createTechRecordPage.selectVehicleType(vehicleType);
    }

    @Step
    public void continueRecordCreationProcess() {
        createTechRecordPage.continueRecordCreationProcess();
    }

    @Step
    public void headerErrorContains(String text) {
        createTechRecordPage.headerErrorContains(text);
    }

    @Step
    public void specificErrorContains(String errorType, String text) throws Exception {
        createTechRecordPage.specificErrorContains(errorType, text);
    }
}
