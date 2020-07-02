package step;

import net.thucydides.core.annotations.Step;
import pages.GenericBackendRequestPage;

public class GenericBackendRequestSteps {

    GenericBackendRequestPage genericBackendRequestPage;

    @Step
    public void createTechRecord(String vehicleType, String withWithoutAdr) {
        genericBackendRequestPage.goToAuthTokenUrl();
        genericBackendRequestPage.createTechRecord(vehicleType, withWithoutAdr);
    }

    @Step
    public void createTestRecord(String testStatus, String testResult, String testCode, boolean withWithoutDefects) {
        genericBackendRequestPage.createTestRecord(testStatus, testResult, testCode, withWithoutDefects);
    }

    @Step
    public String getNewVehicleAttribute(String attribute) {
        return genericBackendRequestPage.getNewVehicleAttribute(attribute);
    }

    @Step
    public String getNewTestAttribute(String attribute) {
        return genericBackendRequestPage.getNewTestTypeAttribute(attribute);
    }

    @Step
    public void createTechRecord(String vehicleType) {
        genericBackendRequestPage.goToAuthTokenUrl();
        genericBackendRequestPage.createTechRecord(vehicleType);
    }

    @Step
    public void createTechRecordWithRecordCompleteness(String vehicleType, String recordCompleteness) {
        genericBackendRequestPage.goToAuthTokenUrl();
        genericBackendRequestPage.createTechRecordWithRecordCompleteness(vehicleType, recordCompleteness);
    }

    @Step
    public void updateTestRecord() {
        genericBackendRequestPage.updateTestRecord();
    }

    @Step
    public void createTestRecordWithStatusAndResultAndTestTypeForNewVehicle(String status, String result, String testType,
                                                                            String vehicleType) {
        genericBackendRequestPage.goToAuthTokenUrl();
        genericBackendRequestPage.createTestRecordWithStatusAndResultAndTestTypeForNewVehicle(status, result, testType,
                vehicleType);
    }
}
