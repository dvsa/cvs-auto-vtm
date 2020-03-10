package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTechRecordPage extends GenericPage {

    private static final String VIN_INPUT = "#test-vin";
    private static final String VRM_INPUT = "#test-vrm";
    private static final String HGV_VEHICLE_TYPE = "#test-radio-HGV";
    private static final String PSV_VEHICLE_TYPE = "#test-radio-PSV";
    private static final String TRAILER_VEHICLE_TYPE = "#test-radio-Trailer";
    private static final String CONTINUE_BUTTON = "#test-continue-btn";
    private static final String HEADER_ERROR = "#test-continue-btn";
    private static final String VEHICLE_TYPE_ERROR = "#vType-error";
    private static final String VIN_ERROR = "#vin-error";
    private static final String VRM_ERROR = "#vrm-error";


    public void fillInVin(String vin) {
        findElementByCss(VIN_INPUT).sendKeys(vin);
    }

    public void fillInVrm(String vrm) {
        findElementByCss(VRM_INPUT).sendKeys(vrm);
    }

    public void selectVehicleType(String vehicleType) throws Exception {
        String option = vehicleType.toLowerCase();
        switch (option) {
            case "hgv":
                findElementByCss(HGV_VEHICLE_TYPE).click();
                break;
            case "psv":
                findElementByCss(PSV_VEHICLE_TYPE).click();
                break;
            case "trailer":
                findElementByCss(TRAILER_VEHICLE_TYPE).click();
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid vehicle type");
        }
    }

    public void continueRecordCreationProcess() {
        findElementByCss(CONTINUE_BUTTON).click();
    }

    public void headerErrorContains(String text) {
        Assert.assertTrue(findElementByCss(HEADER_ERROR).getText().contains(text));
    }

    public void specificErrorContains(String errorType, String text) throws Exception {
        String option = errorType.toLowerCase();
        switch (option) {
            case "hgv":
                Assert.assertTrue(findElementByCss(VEHICLE_TYPE_ERROR).getText().contains(text));
                break;
            case "psv":
                Assert.assertTrue(findElementByCss(VIN_ERROR).getText().contains(text));
                break;
            case "trailer":
                Assert.assertTrue(findElementByCss(VRM_ERROR).getText().contains(text));
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid error type");
        }
    }
}
