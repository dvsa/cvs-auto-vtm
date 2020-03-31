package pages;

import exceptions.AutomationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class TechRecordPage extends GenericPage {

    private static final String OPEN_CLOSE_ALL_SECTIONS = "div.open-close-all a";
    private static final String OPEN_VEHICLE_SUMMARY_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_BODY_SECTION = "#test-fa-plus-body";
    private static final String OPEN_WEIGHTS_SECTION = "#test-fa-plus-weights";
    private static final String OPEN_TYRES_SECTION = "#test-fa-plus-tyres";
    private static final String OPEN_DIMENSIONS_SECTION = "#test-fa-plus-dimensions";
    private static final String OPEN_ADR_SECTION = "#test-fa-plus-adr";
    private static final String OPEN_NOTES_SECTION = "#test-fa-plus-notes";
    private static final String OPEN_TEST_HISTORY_SECTION = "#test-fa-plus-testHistory";
    private static final String OPEN_TECHNICAL_RECORD_HISTORY_SECTION = "#test-fa-plus-techRecHistory";
    private static final String CLOSE_VEHICLE_SUMMARY_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_BODY_SECTION = "#test-fa-minus-body";
    private static final String CLOSE_WEIGHTS_SECTION = "#test-fa-minus-weights";
    private static final String CLOSE_TYRES_SECTION = "#test-fa-minus-tyres";
    private static final String CLOSE_DIMENSIONS_SECTION = "#test-fa-minus-dimensions";
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
    private static final String STATEMENT_FIELDS = "#conditional-selectStatement";
    private static final String PRODUCT_LIST_FIELDS = "#conditional-select_productlist_N";
    private static final String STATEMENT = "#select_statement_Y";
    private static final String PRODUCT_LIST = "#select_productlist_N";
    private static final String ADR_VEHICLE_TYPE = "#vehicleType";
    private static final String BATTERY_LIST_APPLICABLE = "#listStatementApplicable-Yes";
    private static final String BATTERY_LIST_NOT_APPLICABLE = "#listStatementApplicable-No";
    private static final String BATTERY_LIST_APPLICABLE_FIELDS = "#conditional-battery-list-applicable";
    private static final String BATTERY_LIST_NUMBER = "#batteryListNumber";
    private static final String MANUFACTURER_BRAKE_DECLARATION = "#conditional-brakeDeclarationsSeen";
    private static final String MANUFACTURER_BRAKE_ISSUER = "#brakeDeclarationIssuer";
    private static final String BRAKE_ENDURANCE_DECLARATION = "#conditional-brakeEndurance";
    private static final String BRAKE_ENDURANCE_WEIGHT= "#weight";
//    private static final String ADD_DANGEROUS_GOOD_LINK = "a.add-dangerous-note";
//    private static final String ADD_GUIDANCE_NOTE_LINK = "a.add-guidance-note";
    private static final String ADD_SUBSEQUENT_INSPECTION_LINK = "vtm-tank-inspections-edit a";
    private static final String ADD_UN_NUMBER_LINK = "#conditional-select_productlist_N div>a";
    private static final String CUSTOM_DANGEROUS_GOOD_INPUT = "a.add-dangerous-note+input";
    private static final String GUIDANCE_NOTE_INPUT = "a.add-guidance-note+input";
    private static final String NEW_UN_NUMBER_INPUT = "#productListUnNumber_";
    private static final String VEHICLE_SUMMARY_SECTION = "vtm-vehicle-summary>table tr";
    private static final String BODY_SECTION = "vtm-body>table tr";
    private static final String WEIGHTS_SECTION = "vtm-weights>table tr";
    private static final String TYRES_SECTION = "vtm-tyres>table tr";
    private static final String DIMENSIONS_SECTION_ = "vtm-dimensions>table tr";
    private static final String ADR_SECTION = "vtm-adr-details-view>table tr";
    private static final String NOTES_SECTION = "vtm-notes>table tr";
    private static final String TEST_HISTORY_SECTION = "vtm-test-history>table tr";
    private static final String TECHNICAL_RECORD_HISTORY_SECTION = "vtm-tech-rec-history>table tr";
    private static final String CHANGES_REASON_TEXT_AREA = "#reasonForCreation";
    private static final String CONFIRM_SAVE_CHANGES = "vtm-adr-reason-modal>button";
    private static final String SUBSTANCES_PERMITTED_PERMITTED = "//label[contains(text(),'Substances permitted')]/preceding-sibling::input";
    private static final String SUBSTANCES_PERMITTED_CLASS_NUMBER = "//label[contains(text(),'class UN number')]/preceding-sibling::input";
    private static final String PRODUCT_LIST_REF_NUMBER = "#productListRefNumber";
    private static final String INITIAL_INSPECTION_CERTIFICATE = "#tc2IntermediateApprovalNo";
    private static final String INITIAL_INSPECTION_EXPIRY_DATE_DAY = "[id^=tc2IntermediateExpiryDate][id$='day']";
    private static final String INITIAL_INSPECTION_EXPIRY_DATE_MONTH = "[id^=tc2IntermediateExpiryDate][id$='month']";
    private static final String INITIAL_INSPECTION_EXPIRY_DATE_YEAR = "[id^=tc2IntermediateExpiryDate][id$='year']";
    private static final String SUBSEQUENT_INSPECTION_TYPE = "[id^=tc3Type-]";
    private static final String SUBSEQUENT_INSPECTION_CERTIFICATE = "[id^=tc3PeriodicNumber-]";
    private static final String SUBSEQUENT_INSPECTION_EXPIRY_DATE_DAY = "[id^=tc3PeriodicExpiryDate][id$='day']";
    private static final String SUBSEQUENT_INSPECTION_EXPIRY_DATE_MONTH = "[id^=tc3PeriodicExpiryDate][id$='month']";
    private static final String SUBSEQUENT_INSPECTION_EXPIRY_DATE_YEAR = "[id^=tc3PeriodicExpiryDate][id$='year']";

    private static int noOfDocuments;
    private static int noOfDocumentsOnEdit;


    public String getValueInTechRecordField(String field) {
        WebElement element = getDriver().findElement(By.id("test-" + field));
        FluentWait wait = globalFluentWait(20, 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test-" + field)));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        return element.getText();
    }

    public void openAllSections() {

        WebElement element = getDriver().findElement(By.cssSelector("a.govuk-link"));
        FluentWait wait = globalFluentWait(20, 200);
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
        FluentWait wait = globalFluentWait(20, 200);
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

    public void openSection(String section) {
        String option = section.toLowerCase();
        Actions actions = new Actions(getDriver());
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "vehicle summary":
                if (getDriver().findElements(By.cssSelector(CLOSE_VEHICLE_SUMMARY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_VEHICLE_SUMMARY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_VEHICLE_SUMMARY_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_VEHICLE_SUMMARY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_VEHICLE_SUMMARY_SECTION)).click();
                }
                break;
            case "body":
                if (getDriver().findElements(By.cssSelector(CLOSE_BODY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_BODY_SECTION)));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_BODY_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_BODY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_BODY_SECTION)).click();
                }
                break;
            case "weights":
                if (getDriver().findElements(By.cssSelector(CLOSE_WEIGHTS_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_WEIGHTS_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_WEIGHTS_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_WEIGHTS_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_WEIGHTS_SECTION)).click();
                }
                break;
            case "tyres":
                if (getDriver().findElements(By.cssSelector(CLOSE_TYRES_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_TYRES_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_TYRES_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_TYRES_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_TYRES_SECTION)).click();
                }
                break;
            case "dimensions":
                if (getDriver().findElements(By.cssSelector(CLOSE_DIMENSIONS_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_DIMENSIONS_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_DIMENSIONS_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_DIMENSIONS_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_DIMENSIONS_SECTION)).click();
                }
                break;
            case "adr":
                if (getDriver().findElements(By.cssSelector(CLOSE_ADR_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_ADR_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_ADR_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_ADR_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_ADR_SECTION)).click();
                }
                noOfDocuments = getDriver().findElements(
                        By.xpath("//vtm-tank-documents//a[contains(text(),'View')]")).size();
                noOfDocumentsOnEdit = getDriver().findElements(
                        By.xpath("//vtm-tank-documents//a[contains(text(),'View')]")).size();
                break;
            case "notes":
                if (getDriver().findElements(By.cssSelector(CLOSE_NOTES_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_NOTES_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_NOTES_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_NOTES_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_NOTES_SECTION)).click();
                }
                break;
            case "test history":
                if (getDriver().findElements(By.cssSelector(CLOSE_TEST_HISTORY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_TEST_HISTORY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_TEST_HISTORY_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_TEST_HISTORY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_TEST_HISTORY_SECTION)).click();
                }
                break;
            case "technical record history":
                if (getDriver().findElements(By.cssSelector(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_TECHNICAL_RECORD_HISTORY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_TECHNICAL_RECORD_HISTORY_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_TECHNICAL_RECORD_HISTORY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_TECHNICAL_RECORD_HISTORY_SECTION)).click();
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid section '" + option + "'");
        }
        actions.perform();
    }

    public void closeSection(String section) {
        String option = section.toLowerCase();
        Actions actions = new Actions(getDriver());
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "vehicle summary":
                if (getDriver().findElements(By.cssSelector(OPEN_VEHICLE_SUMMARY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_VEHICLE_SUMMARY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_VEHICLE_SUMMARY_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_VEHICLE_SUMMARY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_VEHICLE_SUMMARY_SECTION)).click();
                }
                break;
            case "body":
                if (getDriver().findElements(By.cssSelector(OPEN_BODY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_BODY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_BODY_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_BODY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_BODY_SECTION)).click();
                }
                break;
            case "weights":
                if (getDriver().findElements(By.cssSelector(OPEN_WEIGHTS_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_WEIGHTS_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_WEIGHTS_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_WEIGHTS_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_WEIGHTS_SECTION)).click();
                }
                break;
            case "tyres":
                if (getDriver().findElements(By.cssSelector(OPEN_TYRES_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_TYRES_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_TYRES_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_TYRES_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_TYRES_SECTION)).click();
                }
                break;
            case "dimensions":
                if (getDriver().findElements(By.cssSelector(OPEN_DIMENSIONS_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_DIMENSIONS_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_DIMENSIONS_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_DIMENSIONS_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_DIMENSIONS_SECTION)).click();
                }
                break;
            case "adr":
                if (getDriver().findElements(By.cssSelector(OPEN_ADR_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_ADR_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_ADR_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_ADR_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_ADR_SECTION)).click();
                }
                break;
            case "notes":
                if (getDriver().findElements(By.cssSelector(OPEN_NOTES_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_NOTES_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_NOTES_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_NOTES_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_NOTES_SECTION)).click();
                }
                break;
            case "test history":
                if (getDriver().findElements(By.cssSelector(OPEN_TEST_HISTORY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_TEST_HISTORY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_TEST_HISTORY_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_TEST_HISTORY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_TEST_HISTORY_SECTION)).click();
                }
                break;
            case "technical record history":
                if (getDriver().findElements(By.cssSelector(OPEN_TECHNICAL_RECORD_HISTORY_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION)).click();
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid section '" + option + "'");
        }
    }

    public void editTechRecordDetails() {
        FluentWait wait = globalFluentWait(20, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHANGE_TECHNICAL_RECORD_DETAILS)));
        getDriver().findElement(By.cssSelector(CHANGE_TECHNICAL_RECORD_DETAILS)).click();
    }

    public void saveTechRecordDetails() {
        FluentWait wait = globalFluentWait(20, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SAVE_TECHNICAL_RECORD_DETAILS)));
        getDriver().findElement(By.cssSelector(SAVE_TECHNICAL_RECORD_DETAILS)).click();
    }

    public void deselectDangerousGoodCheckbox(String dangerousGood) throws Exception {
        String option = dangerousGood.toLowerCase();
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
                        "Invalid dangerous good '" + option + "'");
        }
    }

    public void selectDangerousGoodCheckbox(String dangerousGood) throws Exception {
        String option = dangerousGood.toLowerCase();
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
                        "Invalid dangerous good '" + option + "'");
        }
    }

    public void selectFromTankStatement(String statementType) {
        FluentWait wait = globalFluentWait(10, 200);
        String option = statementType.toLowerCase();
        switch (option) {
            case "statement":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(STATEMENT)));
                scrollToAndClickByCss(STATEMENT);
                break;
            case "product list":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(PRODUCT_LIST)));
                scrollToAndClickByCss(PRODUCT_LIST);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid statement type");
        }
    }

    public void checkStatementField(String field) {
        String elementText = getDriver().findElement(By.cssSelector(STATEMENT_FIELDS)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(field));
        Assert.assertTrue(getDriver().findElement(By.cssSelector(STATEMENT_FIELDS)).isDisplayed());
    }

    public void checkStatementFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(STATEMENT_FIELDS));
        if (elements.size() > 0) {
            Assert.assertFalse(getDriver().findElement(By.cssSelector(STATEMENT_FIELDS)).isDisplayed());
        }
    }

    public void checkProductListField(String field) {
        String elementText = getDriver().findElement(By.cssSelector(PRODUCT_LIST_FIELDS)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(field));
        Assert.assertTrue(getDriver().findElement(By.cssSelector(PRODUCT_LIST_FIELDS)).isDisplayed());
    }

    public void checkProductListFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(PRODUCT_LIST_FIELDS));
        if (elements.size() > 0) {
            Assert.assertFalse(getDriver().findElement(By.cssSelector(PRODUCT_LIST_FIELDS)).isDisplayed());
        }
    }

    public void selectAdrVehicleType(String type) {
        FluentWait wait = globalFluentWait(5, 250);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADR_VEHICLE_TYPE)));
        Select vehicleType = new Select(getDriver().findElement(By.cssSelector(ADR_VEHICLE_TYPE)));
        try {
            vehicleType.selectByVisibleText(type);
        }
        catch (Exception e)
        {
            System.out.println("Invalid vehicle type");
            throw e;
        }
    }

    public void selectFromBatteryListApplicable(String batteryListApplicableOption) {
        String option = batteryListApplicableOption.toLowerCase();
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "yes":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BATTERY_LIST_APPLICABLE)));
                scrollToAndClickByCss(BATTERY_LIST_APPLICABLE);
                break;
            case "no":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BATTERY_LIST_NOT_APPLICABLE)));
                scrollToAndClickByCss(BATTERY_LIST_NOT_APPLICABLE);
                break;
        }
    }

    public void checkBatteryListApplicableField(String text) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)));
        String elementText = getDriver().findElement(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(text));
        Assert.assertTrue(getDriver().findElement(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)).isDisplayed());
    }

    public void checkBatteryListApplicableFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS));
        if (elements.size() > 0) {
            Assert.assertFalse(getDriver().findElement(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)).isDisplayed());
        }
    }

    public void checkManufacturerBrakeDeclarationField(String fieldName) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)));
        String elementText = getDriver().findElement(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(fieldName));
        Assert.assertTrue(getDriver().findElement(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)).isDisplayed());
    }

    public void checkManufacturerBrakeDeclarationFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION));
        if (elements.size() > 0) {
            Assert.assertFalse(getDriver().findElement(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)).isDisplayed());
        }
    }

    public void checkBrakeEnduranceField(String fieldName) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(BRAKE_ENDURANCE_DECLARATION)));
        String elementText = getDriver().findElement(By.cssSelector(BRAKE_ENDURANCE_DECLARATION)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(fieldName));
        Assert.assertTrue(getDriver().findElement(By.cssSelector(BRAKE_ENDURANCE_DECLARATION)).isDisplayed());
    }

    public void checkBrakeEnduranceFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(BRAKE_ENDURANCE_DECLARATION));
        if (elements.size() > 0) {
            Assert.assertFalse(getDriver().findElement(By.cssSelector(BRAKE_ENDURANCE_DECLARATION)).isDisplayed());
        }
    }

    public void iClickAdrDetailsLink(String text) {
        FluentWait wait = globalFluentWait(3, 200);
        String option = text.toLowerCase();
        switch (option) {
//            case "add a dangerous good":
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADD_DANGEROUS_GOOD_LINK)));
//                getDriver().findElement(By.cssSelector(ADD_DANGEROUS_GOOD_LINK)).click();
//                break;
//            case "add a guidance note":
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADD_GUIDANCE_NOTE_LINK)));
//                getDriver().findElement(By.cssSelector(ADD_GUIDANCE_NOTE_LINK)).click();
//                break;
            case "add a subsequent inspection":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADD_SUBSEQUENT_INSPECTION_LINK)));
                getDriver().findElement(By.cssSelector(ADD_SUBSEQUENT_INSPECTION_LINK)).click();
                break;
            case "add a un number":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADD_UN_NUMBER_LINK)));
                getDriver().findElement(By.cssSelector(ADD_UN_NUMBER_LINK)).click();
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Non existent link '" + option + "'");
        }
    }

    public void selectCustomDangerousGoodCheckbox(String dangerousGood) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#adrDetails\\.permittedDangerousGoods\\." + dangerousGood)));
        if (!(getDriver().findElement(By.cssSelector("#adrDetails\\.permittedDangerousGoods\\." + dangerousGood)).isSelected())) {
            getDriver().findElement(By.cssSelector("#adrDetails\\.permittedDangerousGoods\\." + dangerousGood)).click();
        }
    }

    public void deselectCustomDangerousGoodCheckbox(String dangerousGood) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#adrDetails\\.permittedDangerousGoods\\." + dangerousGood)));
        if (getDriver().findElement(By.cssSelector("#adrDetails\\.permittedDangerousGoods\\." + dangerousGood)).isSelected()) {
            getDriver().findElement(By.cssSelector("#adrDetails\\.permittedDangerousGoods\\." + dangerousGood)).click();
        }
    }

    public void inputCustomDangerousGood(String customDangerousGood) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CUSTOM_DANGEROUS_GOOD_INPUT)));
        getDriver().findElement(By.cssSelector(CUSTOM_DANGEROUS_GOOD_INPUT)).sendKeys(customDangerousGood);
    }

    public void inputCustomGuidanceNote(String note) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_INPUT)));
        getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_INPUT)).sendKeys(note);
    }

    public void selectCustomGuidanceNoteCheckbox(String note) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#adrDetails\\.additionalNotes\\." + note)));
        if (!(getDriver().findElement(By.cssSelector("#adrDetails\\.additionalNotes\\." + note)).isSelected())) {
            getDriver().findElement(By.cssSelector("#adrDetails\\.additionalNotes\\." + note)).click();
        }
    }

    public void deselectCustomGuidanceNoteCheckbox(String note) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#adrDetails\\.additionalNotes\\." + note)));
        if (getDriver().findElement(By.cssSelector("#adrDetails\\.additionalNotes\\." + note)).isSelected()) {
            getDriver().findElement(By.cssSelector("#adrDetails\\.additionalNotes\\." + note)).click();
        }
    }

    public void inputUnNewNumber(String unNumber) {
        int noUnNumberInputFields = getDriver().findElements(By.cssSelector("[id^='productListUnNumber_']")).size();
        int lastIndex = noUnNumberInputFields - 1;
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(NEW_UN_NUMBER_INPUT + lastIndex)));
        getDriver().findElement(By.cssSelector(NEW_UN_NUMBER_INPUT + lastIndex)).sendKeys(unNumber);
    }

    public void iShouldSeeSectionHeading(String heading) {
        String section = heading.toLowerCase();
        FluentWait wait = globalFluentWait(5, 200);
        switch (section) {
            case "vehicle summary":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-0")), heading));
                break;
            case "body":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-1")), heading));
                break;
            case "weights":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-2")), heading));
                break;
            case "tyres":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-3")), heading));
                break;
            case "dimensions":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-4")), heading));
                break;
            case "adr":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-5")), heading));
                break;
            case "notes":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-6")), heading));
                break;
            case "test history":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-7")), heading));
                break;
            case "technical record history":
                wait.until(ExpectedConditions.textToBePresentInElement(find(By.id("mat-expansion-panel-header-8")), heading));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Non existent section '" + section + "'");
        }
    }

    public void checkNumberOfEntriesInSection(String numberOfEntries, String section) {
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle summary":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(VEHICLE_SUMMARY_SECTION)).size());
                break;
            case "body":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(BODY_SECTION)).size());
                break;
            case "weights":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(WEIGHTS_SECTION)).size());
                break;
            case "tyres":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(TYRES_SECTION)).size());
                break;
            case "dimensions":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(DIMENSIONS_SECTION_)).size());
                break;
            case "adr":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(ADR_SECTION)).size());
                break;
            case "notes":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(NOTES_SECTION)).size());
                break;
            case "test history":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(TEST_HISTORY_SECTION)).size());
                break;
            case "technical record history":
                Assert.assertEquals(Integer.parseInt(numberOfEntries), getDriver().findElements(By.cssSelector(TECHNICAL_RECORD_HISTORY_SECTION)).size());
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid section '" + option + "'");
        }
    }

    public void checkAdrFieldDisplayed(String adrField) {
        Assert.assertTrue(findElementByCss("#test-" + adrField).isDisplayed());
    }

    public void checkAdrSubsectionIsPresent(String subsection) {
        FluentWait wait = globalFluentWait(20, 300);
        String option = subsection.toLowerCase();
        switch (option) {
            case "applicant details":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-applicant-details")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "adr details":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-adr-details")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "tank details":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-tank-details")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "tank inspections":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-tank-inpections")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "memo 07/09 (3 month extension)":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-memo")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "tank documents":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-tank-documents")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "battery list":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-battery-list-applicable")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "declarations seen":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-declaration-seen")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "certificate":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-certificate")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            case "additional adr details":
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//vtm-additional-adr-details")));
                Assert.assertTrue(findElementByText(subsection).isDisplayed());
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid adr subsection '" + option + "'");
        }
    }

    public void uploadAdrDocument() {
        String workingDir = System.getProperty("user.dir");
        WebElement addFile = findElementByXpath(".//input[@type='file']");
        ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
        addFile.sendKeys(workingDir + "/src/main/resources/loader/sample.pdf");
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            FluentWait wait = globalFluentWait(10, 300);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SPINNER)));
            } catch (NoSuchElementException e) {
                System.out.println("Spinner no longer in the page DOM");
            }
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
        waitForAngularRequestsToFinish();
        noOfDocumentsOnEdit++;
    }

    public void setReasonForChanges(String reason) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHANGES_REASON_TEXT_AREA)));
        findElementByCss(CHANGES_REASON_TEXT_AREA).sendKeys(reason);
    }

    public void confirmSavingDetails() {
        findElementByCss(CONFIRM_SAVE_CHANGES).click();
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            FluentWait wait = globalFluentWait(10, 300);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SPINNER)));
            } catch (NoSuchElementException e) {
                System.out.println("Spinner no longer in the page DOM");
            }
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
        noOfDocuments = noOfDocumentsOnEdit;
    }

    public void checkTextInAdrSubsection(String text, String subsection) {
        checkAdrSubsectionIsPresent(subsection);
        FluentWait wait = globalFluentWait(3, 200);
        String option = subsection.toLowerCase();
        switch (option) {
            case "applicant details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-applicant-details"), text));
                break;
            case "adr details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-adr-new-details"), text));
                break;
            case "tank details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-tank-details"), text));
                break;
            case "tank inspections":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-tank-inpections"), text));
                break;
            case "memo 07/09 (3 month extension)":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-memo"), text));
                break;
            case "tank documents":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-tank-documents"), text));
                break;
            case "battery list":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-battery-list-applicable"), text));
                break;
            case "declarations seen":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-declaration-seen"), text));
                break;
            case "certificate":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-certificate"), text));
                break;
            case "vtm-additional-adr-details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//vtm-additional-adr-details"), text));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid adr subsection '" + option + "'");
        }
    }

    public void checkNumberOfTankDocumentsOnEdit() {
        Assert.assertEquals(noOfDocumentsOnEdit, getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'Remove')]")).size());
    }

    public void checkNumberOfTankDocuments() {
        Assert.assertEquals(noOfDocuments, getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'View')]")).size());
    }

    public void removeAllAdrDocuments() {
        List<WebElement> documents = getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'Remove')]"));
        for (WebElement document : documents) {
            document.click();
            noOfDocumentsOnEdit--;
        }
    }

    public void checkValueInTechRecordField(String value, String field) {
        try {
                Assert.assertTrue(getValueInTechRecordField(field)
                        .contains(value));
            } catch (AssertionError e) {
                throw new AssertionError("Expected value '" + value + "' for field '" +
                        field + "' was not found, actual value was '" +
                        getValueInTechRecordField(field) + "'");
            }
    }

    public void downloadTankDocument(int index) {
        List<WebElement> viewDocuments = getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'View')]"));
        FluentWait wait = globalFluentWait(3, 200);
        wait.until(ExpectedConditions.elementToBeClickable(viewDocuments.get(index-1)));
        viewDocuments.get(index-1).click();
    }

    public void removeAdrDocuments(int index) {
        List<WebElement> documents = getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'Remove')]"));
        documents.get(index-1).click();
    }

    public void selectSubstancesPermittedOption(String substancesPermittedType) {
        FluentWait wait = globalFluentWait(10, 200);
        switch (substancesPermittedType) {
            case "Substances permitted":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBSTANCES_PERMITTED_PERMITTED)));
                scrollToAndClickByXpath(SUBSTANCES_PERMITTED_PERMITTED);
                break;
            case "class UN number":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBSTANCES_PERMITTED_CLASS_NUMBER)));
                scrollToAndClickByXpath(SUBSTANCES_PERMITTED_CLASS_NUMBER);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid substances permitted option");
        }
    }

    public void setReferenceNumber(String refNo) {
        findElementByCss(PRODUCT_LIST_REF_NUMBER).sendKeys(refNo);
    }

    public void removeUnNumber(int index) {
        int actualIndex = index -1;
        WebElement removeUnNumber = getDriver().findElement(
                By.cssSelector("#productListUnNumber_" + actualIndex + "+span>a"));
        FluentWait wait = globalFluentWait(3, 200);
        wait.until(ExpectedConditions.elementToBeClickable(removeUnNumber));
        removeUnNumber.click();
    }

    public void addInitialInspection(String certificateNo, String expiryDate) {
        findElementByCss(INITIAL_INSPECTION_CERTIFICATE).sendKeys(certificateNo);
        String[] date = expiryDate.split("/");
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_DAY).sendKeys(date[0]);
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_MONTH).sendKeys(date[1]);
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_YEAR).sendKeys(date[2]);
    }

    public void addSubsequentInspection(int index, String inspectionType, String certificateNo, String expiryDate) {
        Select selectInspectionType = new Select(findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") "
                + SUBSEQUENT_INSPECTION_TYPE));
        switch(inspectionType.toLowerCase()) {
            case "intermediate":
                selectInspectionType.selectByIndex(0);
                break;
            case "periodic":
                selectInspectionType.selectByIndex(1);
                break;
            case "exceptional":
                selectInspectionType.selectByIndex(2);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid subsequent inspection type '" + inspectionType + "'");
        }
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_CERTIFICATE).sendKeys(certificateNo);
        String[] date = expiryDate.split("/");
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_DAY).sendKeys(date[0]);
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_MONTH).sendKeys(date[1]);
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_YEAR).sendKeys(date[2]);

    }
}