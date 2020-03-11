package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTechRecordPage extends GenericPage {

    private static final String VIN_INPUT = "#test-vin";
    private static final String VRM_INPUT = "#test-vrm";
    private static final String HGV_VEHICLE_TYPE = "#test-radio-HGV";
    private static final String PSV_VEHICLE_TYPE = "#test-radio-PSV";
    private static final String TRAILER_VEHICLE_TYPE = "#test-radio-Trailer";
    private static final String CONTINUE_BUTTON = "#test-continue-btn";
    private static final String HEADER_ERROR = "div.govuk-error-summary";
    private static final String VEHICLE_TYPE_ERROR = "#vType-error";
    private static final String VIN_ERROR = "#vin-error";
    private static final String VRM_ERROR = "#vrm-error";
    private static final String SPINNER = "div.spinner-container";
    private static final String HEADER_SPECIFIC_ERRORS = "div.govuk-error-summary>span.govuk-error-message";

    public void fillInVin(String vin) {
        findElementByCss(VIN_INPUT).clear();
        findElementByCss(VIN_INPUT).sendKeys(vin);
    }

    public void fillInVrm(String vrm) {
        findElementByCss(VRM_INPUT).clear();
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

    public void headerErrorContains(String text) {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 15).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(HEADER_ERROR), text));
        findElementByCss(VIN_INPUT).click();
    }

    public void specificErrorContains(String errorType, String text) throws Exception {
        String option = errorType.toLowerCase();
        switch (option) {
            case "vehicle type":
                new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VEHICLE_TYPE_ERROR)));
                new WebDriverWait(getDriver(), 15).
                        until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(VEHICLE_TYPE_ERROR), text));
                break;
            case "vin":
                new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VIN_ERROR)));
                new WebDriverWait(getDriver(), 15).
                        until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(VIN_ERROR), text));
                break;
            case "vrm":
                new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VRM_ERROR)));
                new WebDriverWait(getDriver(), 15).
                        until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(VRM_ERROR), text));
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid error type");
        }
    }

    public void checkInputFieldText(String text, String input) throws Exception {
        String option = input.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertTrue(findElementByCss(VIN_INPUT).getAttribute("value").contains(text));
                break;
            case "vrm":
                Assert.assertTrue(findElementByCss(VRM_INPUT).getAttribute("value").contains(text));
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid input type");
        }
    }

    public void clickContinueButton() {
        findElementByCss(CONTINUE_BUTTON).click();
        try {
            new WebDriverWait(getDriver(), 1).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
    }

    public void headerErrorNotContains(String text) {
        waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_SPECIFIC_ERRORS)));
        Assert.assertFalse(findElementByCss(HEADER_SPECIFIC_ERRORS).getText().contains(text));
    }

    public void checkNotInputFieldText(String text, String input) throws Exception {
        String option = input.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertFalse(findElementByCss(VIN_INPUT).getAttribute("value").contains(text));
                break;
            case "vrm":
                Assert.assertFalse(findElementByCss(VRM_INPUT).getAttribute("value").contains(text));
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid input type");
        }
    }
}
