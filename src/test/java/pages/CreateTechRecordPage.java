package pages;

import exceptions.AutomationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateTechRecordPage extends GenericPage {

    private static final String VIN_INPUT = "#test-vin";
    private static final String VIN_LABEL = "[for='test-vin']";
    private static final String VRM_INPUT = "#test-vrm";
    private static final String VRM_LABEL = "[for='test-vrm']";
    private static final String HGV_VEHICLE_TYPE = "#test-radio-HGV";
    private static final String PSV_VEHICLE_TYPE = "#test-radio-PSV";
    private static final String TRAILER_VEHICLE_TYPE = "#test-radio-Trailer";
    private static final String VEHICLE_TYPE_ERROR = "#vType-error";
    private static final String VIN_ERROR = "#vin-error";
    private static final String VRM_ERROR = "#vrm-error";
    private static final String VIN_EDIT_INPUT = "#test-edit-vin";
    private static final String VRM_EDIT_INPUT = "#test-edit-vrm";

    public void fillInVin(String vin) {
        findElementByCss(VIN_INPUT).clear();
        findElementByCss(VIN_INPUT).sendKeys(vin);
    }

    public void fillInVrm(String vrm) {
        findElementByCss(VRM_INPUT).clear();
        findElementByCss(VRM_INPUT).sendKeys(vrm);
    }

    public void selectVehicleType(String vehicleType) {
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
                throw new AutomationException("Invalid vehicle type " + vehicleType);
        }
    }

    public void specificErrorContains(String errorType, String text) {
        String option = errorType.toLowerCase();
        switch (option) {
            case "vehicle type":
                new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VEHICLE_TYPE_ERROR)));
                new WebDriverWait(getDriver(), 10).
                        until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(VEHICLE_TYPE_ERROR), text));
                break;
            case "vin":
                new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VIN_ERROR)));
                new WebDriverWait(getDriver(), 10).
                        until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(VIN_ERROR), text));
                break;
            case "vrm":
                new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VRM_ERROR)));
                new WebDriverWait(getDriver(), 10).
                        until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(VRM_ERROR), text));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid error type " + errorType);
        }
    }

    public void checkInputFieldText(String text, String input) {
        String option = input.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertTrue("Value for field vin is '" + findElementByCss(VIN_INPUT).getAttribute("value")
                        + "' and does not contain '" + text + "'", findElementByCss(VIN_INPUT).getAttribute("value").contains(text));
                break;
            case "vrm":
                Assert.assertTrue("Value for field vrm is '" + findElementByCss(VRM_INPUT).getAttribute("value")
                        + "' and does not contain '" + text + "'", findElementByCss(VRM_INPUT).getAttribute("value").contains(text));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid input type " + input);
        }
    }

    public void checkEditInputFieldText(String text, String input) {
        String option = input.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertTrue("Value for field vin is '" + findElementByCss(VIN_EDIT_INPUT).getAttribute("value")
                        + "' and does not contain '" + text + "'", findElementByCss(VIN_EDIT_INPUT).getAttribute("value").contains(text));
                break;
            case "vrm":
                Assert.assertTrue("Value for field vrm is '" + findElementByCss(VRM_EDIT_INPUT).getAttribute("value")
                        + "' and does not contain '" + text + "'", findElementByCss(VRM_EDIT_INPUT).getAttribute("value").contains(text));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid input type " + input);
        }
    }

    public void checkNotInputFieldText(String text, String input) {
        String option = input.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertFalse("Value for field vin is '" + findElementByCss(VIN_INPUT).getAttribute("value")
                        + "' and it contains '" + text + "'", findElementByCss(VIN_INPUT).getAttribute("value").contains(text));
                break;
            case "vrm":
                Assert.assertFalse("Value for field vrm is '" + findElementByCss(VRM_INPUT).getAttribute("value")
                        + "' and it contains '" + text + "'", findElementByCss(VRM_INPUT).getAttribute("value").contains(text));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid input type " + input);
        }
    }

    public void checkNotInputDescription(String description, String inputField) {
        String option = inputField.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertFalse("Description for field vin is '" + findElementByCss(VIN_LABEL).getText()
                        + "' and it contains '" + description + "'", findElementByCss(VIN_LABEL).getText().contains(description));
                break;
            case "vrm":
                Assert.assertFalse("Description for field vrm is '" + findElementByCss(VRM_LABEL).getText()
                        + "' and it contains '" + description + "'", findElementByCss(VRM_LABEL).getText().contains(description));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid input field type " + inputField);
        }
    }

    public void checkInputDescription(String description, String inputField) {
        String option = inputField.toLowerCase();
        switch (option) {
            case "vin":
                Assert.assertTrue("Description for field vin is '" + findElementByCss(VIN_LABEL).getText()
                        + "' and does not contain '" + description + "'", findElementByCss(VIN_LABEL).getText().contains(description));
                break;
            case "vrm":
                Assert.assertTrue("Description for field vrm is '" + findElementByCss(VRM_LABEL).getText()
                        + "' and does not contain '" + description + "'", findElementByCss(VRM_LABEL).getText().contains(description));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid input field type " + inputField);
        }
    }

    public void checkNoSpecificErrorForField(String fieldType) {
        String option = fieldType.toLowerCase();
        switch (option) {
            case "vehicle type":
                try {
                    Assert.assertEquals("Errors regarding vehicle type found", 0, getDriver().findElements(By.cssSelector(VEHICLE_TYPE_ERROR)).size());
                } catch (AssertionError e) {
                    List<WebElement> errors = getDriver().findElements(By.cssSelector(VEHICLE_TYPE_ERROR));
                    for (WebElement error : errors) {
                        if (error.isDisplayed()) {
                            throw new AutomationException("Errors regarding vehicle type found");
                        }
                    }
                }
                break;
            case "vin":
                try {
                    Assert.assertEquals("Errors regarding vin found", 0, getDriver().findElements(By.cssSelector(VIN_ERROR)).size());
                } catch (AssertionError e) {
                    List<WebElement> errors = getDriver().findElements(By.cssSelector(VEHICLE_TYPE_ERROR));
                    for (WebElement error : errors) {
                        if (error.isDisplayed()) {
                            throw new AutomationException("Errors regarding vin found");
                        }
                    }
                }
                break;
            case "vrm":
                try {
                    Assert.assertEquals("Errors regarding vrm found", 0, getDriver().findElements(By.cssSelector(VRM_ERROR)).size());
                } catch (AssertionError e) {
                    List<WebElement> errors = getDriver().findElements(By.cssSelector(VEHICLE_TYPE_ERROR));
                    for (WebElement error : errors) {
                        if (error.isDisplayed()) {
                            throw new AutomationException("Errors regarding vrm found");
                        }
                    }
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid field type " + fieldType);
        }
    }
}
