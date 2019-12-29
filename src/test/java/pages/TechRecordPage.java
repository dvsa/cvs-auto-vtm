package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TechRecordPage extends GenericPage {

    private static final String OPEN_CLOSE_ALL_SECTIONS = "a.govuk-link";
    private static final String OPEN_VEHICLE_SUMMARY_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_BODY_SECTION = "#test-fa-plus-body";
    private static final String OPEN_WEIGHTS_SECTION = "#test-fa-plus-weights";
    private static final String OPEN_TYRES_SECTION = "#test-fa-plus-tyres";
    private static final String OPEN_DIMENSIONS_SECTION_ = "#test-fa-plus-dimensions";
    private static final String OPEN_ADR_SECTION = "#test-fa-plus-adr";
    private static final String OPEN_NOTES_SECTION = "#test-fa-plus-notes";
    private static final String OPEN_TEST_HISTORY_SECTION = "#test-fa-plus-testHistory";
    private static final String OPEN_TECHNICAL_RECORD_HISTORY_SECTION = "#test-fa-plus-techRecHistory";
    private static final String CLOSE_VEHICLE_SUMMARY_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_BODY_SECTION = "#test-fa-minus-body";
    private static final String CLOSE_WEIGHTS_SECTION = "#test-fa-minus-weights";
    private static final String CLOSE_TYRES_SECTION = "#test-fa-minus-tyres";
    private static final String CLOSE_DIMENSIONS_SECTION_ = "#test-fa-minus-dimensions";
    private static final String CLOSE_ADR_SECTION = "#test-fa-minus-adr";
    private static final String CLOSE_NOTES_SECTION = "#test-fa-minus-notes";
    private static final String CLOSE_TEST_HISTORY_SECTION = "#test-fa-minus-testHistory";
    private static final String CLOSE_TECHNICAL_RECORD_HISTORY_SECTION = "#test-fa-minus-techRecHistory";
    private static final String CHANGE_TECHNICAL_RECORD_DETAILS = "#test-change-btn";
    private static final String SAVE_TECHNICAL_RECORD_DETAILS = "#test-save-btn";
    private static final String FP_61_DANGEROUS_GOOD = "[id*='adrDetails.permittedDangerousGoods.FP']";
    private static final String AT_DANGEROUS_GOOD = "[id*='adrDetails.permittedDangerousGoods.AT']";
    private static final String HYDROGEN_PEROXIDE_DANGEROUS_GOOD = "[id*='adrDetails.permittedDangerousGoods.Class']";
    private static final String MEMU_DANGEROUS_GOOD = "[id*='adrDetails.permittedDangerousGoods.MEMU']";
    private static final String CARBON_DISULPHIDE_DANGEROUS_GOOD = "[id*='adrDetails.permittedDangerousGoods.Carbon']";
    private static final String HYDROGEN_DANGEROUS_GOOD = "[id*='adrDetails.permittedDangerousGoods.Hydrogen']";
    private static final String EXPLOSIVES_2_DANGEROUS_GOOD = "//label[contains(text(),'Explosives (type 2)')]/preceding-sibling::input";
    private static final String EXPLOSIVES_3_DANGEROUS_GOOD = "//label[contains(text(),'Explosives (type 3)')]/preceding-sibling::input";
    private static final String STATEMENT_FIELDS = "//input[@id='isStatement']/parent::div/following-sibling::*[1][@class='govuk-inset-text ng-star-inserted']";
    private static final String PRODUCT_LIST_FIELDS = "//input[@id='isProductListRefNo']/parent::div/following-sibling::*[1][@class='govuk-inset-text ng-star-inserted']";
    private static final String STATEMENT = "#isStatement";
    private static final String PRODUCT_LIST = "#isProductListRefNo";
    private static final String VEHICLE_TYPE = "#adrDetails\\.type";
    private static final String BATTERY_LIST_APPLICABLE = "#applicable";
    private static final String BATTERY_LIST_NOT_APPLICABLE = "#notApplicable";
    private static final String BATTERY_LIST_APPLICABLE_FIELDS = "//input[@id='batteryListNumber']/parent::div";
    private static final String MANUFACTURER_BRAKE_DECLARATION = "//input[@id='brakeDeclarationIssuer']/parent::div";
    private static final String BRAKE_ENDURANCE_DECLARATION = "//input[@id='weight']/parent::div";


    public String getValueForTechRecordField(String field) {
        WebElement element = getDriver().findElement(By.id("test-" + field));
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-" + field)));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        String techRecordFieldValue = element.getText();
        return techRecordFieldValue;
    }

    public void openAllSections() {

        WebElement element = getDriver().findElement(By.cssSelector("a.govuk-link"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.govuk-link")));
        wait.until(ExpectedConditions.textToBePresentInElement(find(By.cssSelector("a.govuk-link")), "Open all"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)))));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS))));
        getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)).click();
        waitForTextToAppear("Close all");
    }

    public void closeAllSections() {

        WebElement element = getDriver().findElement(By.cssSelector("a.govuk-link"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.govuk-link")));
        wait.until(ExpectedConditions.textToBePresentInElement(find(By.cssSelector("a.govuk-link")), "Close all"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)))));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS))));
        getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)).click();
        waitForTextToAppear("Open all");
    }

    public void openSection(String arg0) throws Exception {
        String option = arg0.toLowerCase();
        switch (option) {
            case "vehicle summary":
                getDriver().findElement(By.cssSelector(OPEN_VEHICLE_SUMMARY_SECTION)).click();
                break;
            case "body":
                getDriver().findElement(By.cssSelector(OPEN_BODY_SECTION)).click();
                break;
            case "weights":
                getDriver().findElement(By.cssSelector(OPEN_WEIGHTS_SECTION)).click();
                break;
            case "tyres":
                getDriver().findElement(By.cssSelector(OPEN_TYRES_SECTION)).click();
                break;
            case "dimensions":
                getDriver().findElement(By.cssSelector(OPEN_DIMENSIONS_SECTION_)).click();
                break;
            case "adr":
                getDriver().findElement(By.cssSelector(OPEN_ADR_SECTION)).click();
                break;
            case "notes":
                getDriver().findElement(By.cssSelector(OPEN_NOTES_SECTION)).click();
                break;
            case "test history":
                getDriver().findElement(By.cssSelector(OPEN_TEST_HISTORY_SECTION)).click();
                break;
            case "technical record history":
                getDriver().findElement(By.cssSelector(OPEN_TECHNICAL_RECORD_HISTORY_SECTION)).click();
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid section");
        }
    }

    public void closeSection(String arg0) throws Exception {
        String option = arg0.toLowerCase();
        switch (option) {
            case "vehicle summary":
                getDriver().findElement(By.cssSelector(CLOSE_VEHICLE_SUMMARY_SECTION)).click();
                break;
            case "body":
                getDriver().findElement(By.cssSelector(CLOSE_BODY_SECTION)).click();
                break;
            case "weights":
                getDriver().findElement(By.cssSelector(CLOSE_WEIGHTS_SECTION)).click();
                break;
            case "tyres":
                getDriver().findElement(By.cssSelector(CLOSE_TYRES_SECTION)).click();
                break;
            case "dimensions":
                getDriver().findElement(By.cssSelector(CLOSE_DIMENSIONS_SECTION_)).click();
                break;
            case "adr":
                getDriver().findElement(By.cssSelector(CLOSE_ADR_SECTION)).click();
                break;
            case "notes":
                getDriver().findElement(By.cssSelector(CLOSE_NOTES_SECTION)).click();
                break;
            case "test history":
                getDriver().findElement(By.cssSelector(CLOSE_TEST_HISTORY_SECTION)).click();
                break;
            case "technical record history":
                getDriver().findElement(By.cssSelector(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION)).click();
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid section");
        }
    }

    public void editTechRecordDetails() {
        getDriver().findElement(By.cssSelector(CHANGE_TECHNICAL_RECORD_DETAILS)).click();
    }

    public void saveTechRecordDetails() {
        getDriver().findElement(By.cssSelector(SAVE_TECHNICAL_RECORD_DETAILS));
    }

    public void deselectDangerousGoodCheckbox(String arg0) throws Exception {
        String option = arg0.toLowerCase();
        switch (option) {
            case "fp <61 (fl)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FP_61_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).click();
                }
                break;
            case "at":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(AT_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).click();
                }
                break;
            case "class 5.1 hydrogen peroxide (ox)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "memu":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MEMU_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).click();
                }
                break;
            case "carbon disulphide":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "hydrogen":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 2)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EXPLOSIVES_2_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.xpath(EXPLOSIVES_2_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.xpath(EXPLOSIVES_2_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 3)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EXPLOSIVES_3_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.xpath(EXPLOSIVES_3_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.xpath(EXPLOSIVES_3_DANGEROUS_GOOD)).click();
                }
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid dangerous good");
        }
    }

    public void selectDangerousGoodCheckbox(String arg0) throws Exception {
        String option = arg0.toLowerCase();
        switch (option) {
            case "fp <61 (fl)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FP_61_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).click();
                }
                break;
            case "at":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(AT_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).click();
                }
                break;
            case "class 5.1 hydrogen peroxide (ox)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "memu":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MEMU_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).click();
                }
                break;
            case "carbon disulphide":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "hydrogen":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 2)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EXPLOSIVES_2_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.xpath(EXPLOSIVES_2_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.xpath(EXPLOSIVES_2_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 3)":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EXPLOSIVES_3_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.xpath(EXPLOSIVES_3_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.xpath(EXPLOSIVES_3_DANGEROUS_GOOD)).click();
                }
                break;
            default:  // should be unreachable!
                throw new Exception(
                        "Invalid dangerous good");
        }
    }

    public void selectFromTankStatement(String arg0) {
        String option = arg0.toLowerCase();
        switch (option) {
            case "statement":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(STATEMENT)));
                getDriver().findElement(By.cssSelector(STATEMENT)).click();
                break;
            case "product list":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(PRODUCT_LIST)));
                getDriver().findElement(By.cssSelector(PRODUCT_LIST)).click();
                break;
        }
    }

    public void checkStatementField(String arg0) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(STATEMENT_FIELDS)));
        String elementText = getDriver().findElement(By.xpath(STATEMENT_FIELDS)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(arg0));
    }

    public void checkStatementFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.xpath(STATEMENT_FIELDS));
        Assert.assertEquals(0, elements.size());
    }

    public void checkProductListField(String arg0) {
        String elementText = getDriver().findElement(By.xpath(PRODUCT_LIST_FIELDS)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(arg0));
    }

    public void checkProductListFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.xpath(PRODUCT_LIST_FIELDS));
        Assert.assertEquals(0, elements.size());
    }

    public void selectVehicleType(String arg0) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(VEHICLE_TYPE)));
        Select vehicleType = new Select(getDriver().findElement(By.cssSelector(VEHICLE_TYPE)));
        try {
            vehicleType.selectByVisibleText(arg0);
        }
        catch (Exception e)
        {
            System.out.println("Invalid vehicle type");
            throw e;
        }
    }

    public void selectFromBatteryListApplicable(String arg0) {
        String option = arg0.toLowerCase();
        switch (option) {
            case "yes":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BATTERY_LIST_APPLICABLE)));
                getDriver().findElement(By.cssSelector(BATTERY_LIST_APPLICABLE)).click();
                break;
            case "no":
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BATTERY_LIST_NOT_APPLICABLE)));
                getDriver().findElement(By.cssSelector(BATTERY_LIST_NOT_APPLICABLE)).click();
                break;
        }
    }

    public void checkBatteryListApplicableField(String arg0) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(BATTERY_LIST_APPLICABLE_FIELDS)));
        String elementText = getDriver().findElement(By.xpath(BATTERY_LIST_APPLICABLE_FIELDS)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(arg0));
    }

    public void checkBatteryListApplicableFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.xpath(BATTERY_LIST_APPLICABLE_FIELDS));
        Assert.assertEquals(0, elements.size());
    }

    public void checkManufacturerBrakeDeclarationField(String arg0) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(MANUFACTURER_BRAKE_DECLARATION)));
        String elementText = getDriver().findElement(By.xpath(MANUFACTURER_BRAKE_DECLARATION)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(arg0));
    }

    public void checkManufacturerBrakeDeclarationFieldNotPresent(String arg0) {
        List<WebElement> elements = getDriver().findElements(By.xpath(MANUFACTURER_BRAKE_DECLARATION));
        Assert.assertEquals(0, elements.size());
    }

    public void checkBrakeEnduranceField(String arg0) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(BRAKE_ENDURANCE_DECLARATION)));
        String elementText = getDriver().findElement(By.xpath(BRAKE_ENDURANCE_DECLARATION)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(arg0));
    }

    public void checkBrakeEnduranceFieldNotPresent(String arg0) {
        List<WebElement> elements = getDriver().findElements(By.xpath(BRAKE_ENDURANCE_DECLARATION));
        Assert.assertEquals(0, elements.size());
    }
}