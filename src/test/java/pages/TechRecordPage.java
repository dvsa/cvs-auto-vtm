package pages;

import exceptions.AutomationException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;
import util.TypeLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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
    private static final String FP_61_DANGEROUS_GOOD = "#permittedGood_0";
    private static final String AT_DANGEROUS_GOOD = "#permittedGood_1";
    private static final String HYDROGEN_PEROXIDE_DANGEROUS_GOOD = "#permittedGood_2";
    private static final String MEMU_DANGEROUS_GOOD = "#permittedGood_3";
    private static final String CARBON_DISULPHIDE_DANGEROUS_GOOD = "#permittedGood_4";
    private static final String HYDROGEN_DANGEROUS_GOOD = "#permittedGood_5";
    private static final String EXPLOSIVES_2_DANGEROUS_GOOD = "#permittedGood_6";
    private static final String EXPLOSIVES_3_DANGEROUS_GOOD = "#permittedGood_7";
    private static final String GUIDANCE_NOTE_1 = "#note_0";
    private static final String GUIDANCE_NOTE_1A = "#note_1";
    private static final String GUIDANCE_NOTE_2 = "#note_2";
    private static final String GUIDANCE_NOTE_3 = "#note_3";
    private static final String GUIDANCE_NOTE_V1B = "#note_4";
    private static final String GUIDANCE_NOTE_T1B = "#note_5";
    private static final String STATEMENT_FIELDS = "#conditional-selectStatement";
    private static final String PRODUCT_LIST_FIELDS = "#conditional-select_productlist_N";
    private static final String STATEMENT = "#select_statement_Y";
    private static final String PRODUCT_LIST = "#select_productlist_N";
    private static final String ADR_VEHICLE_TYPE = "#vehicleType";
    private static final String BATTERY_LIST_APPLICABLE = "#listStatementApplicable-Yes";
    private static final String BATTERY_LIST_NOT_APPLICABLE = "#listStatementApplicable-No";
    private static final String BATTERY_LIST_APPLICABLE_FIELDS = "#conditional-battery-list-applicable";
    private static final String BATTERY_LIST_REFERENCE_NUMBER = "#batteryListNumber";
    private static final String MANUFACTURER_BRAKE_DECLARATION = "#conditional-brakeDeclarationsSeen";
    private static final String MANUFACTURER_BRAKE_DECLARATION_ISSUER = "#brakeDeclarationIssuer";
    private static final String BRAKE_ENDURANCE_DECLARATION = "#conditional-brakeEndurance";
    private static final String BRAKE_ENDURANCE_WEIGHT= "#weight";
//    private static final String ADD_DANGEROUS_GOOD_LINK = "a.add-dangerous-note";
//    private static final String ADD_GUIDANCE_NOTE_LINK = "a.add-guidance-note";
    private static final String ADD_SUBSEQUENT_INSPECTION_LINK = "vtm-tank-inspections-edit a";
    private static final String ADD_UN_NUMBER_LINK = "#conditional-select_productlist_N div>a";
    private static final String CUSTOM_DANGEROUS_GOOD_INPUT = "a.add-dangerous-note+input";
    private static final String GUIDANCE_NOTE_INPUT = "a.add-guidance-note+input";
    private static final String NEW_UN_NUMBER_INPUT = "#productListUnNumber_";
    private static final String PRODUCT_LIST_ADDITIONAL_DETAILS = "#productList";
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
    private static final String HAS_ADR_DETAILS = "#hasADR-Yes";
    private static final String HAS_NOT_ADR_DETAILS = "#hasADR-No";
    private static final String APPLICANT_NAME = "#name";
    private static final String APPLICANT_STREET = "#street";
    private static final String APPLICANT_TOWN = "#town";
    private static final String APPLICANT_CITY = "#city";
    private static final String APPLICANT_POSTCODE = "#postcode";
    private static final String DATE_PROCESSED_DAY = "[id^=approvalDate][id$='day']";
    private static final String DATE_PROCESSED_MONTH = "[id^=approvalDate][id$='month']";
    private static final String DATE_PROCESSED_YEAR = "[id^=approvalDate][id$='year']";
    private static final String COMPATIBILITY_GROUP_J_YES = "#compatibilityGroupJ-Yes";
    private static final String COMPATIBILITY_GROUP_J_NO = "#compatibilityGroupJ-No";
    private static final String APPROVAL_TYPE_NO = "#adrTypeApprovalNo";
    private static final String TANK_MANUFACTURER = "#tankManufacturer";
    private static final String TANK_YEAR_OF_MANUFACTURE = "#yearOfManufacture";
    private static final String TANK_MANUFACTURER_SERIAL_NO = "#tankManufacturerSerialNo";
    private static final String TANK_TYPE_APPROVAL_NUMBER = "#tankTypeAppNo";
    private static final String TANK_CODE = "#tankCode";
    private static final String SPECIAL_PROVISIONS = "#specialProvisions";
    private static final String MEMO_07_09_YES = "#memosApply-Yes";
    private static final String MEMO_07_09_NO = "#memosApply-No";
    private static final String CERTIFICATE_REQUIRED_YES = "#guidanceNotes-Yes";
    private static final String CERTIFICATE_REQUIRED_NO = "#guidanceNotes-No";
    private static final String ADDITIONAL_ADR_DETAILS = "#additionalExaminerNotes";
    private static final String CANCEL_SAVE_DETAILS_MODAL = "vtm-adr-reason-modal a";
    private static final String ERROR_BLOCK = "span.govuk-error-message";

    static String testRecordPageUrl;
    private static int noOfDocuments;
    private static int noOfDocumentsOnEdit;


    public String getValueInTechRecordField(String field) {
        WebElement element = getDriver().findElement(By.cssSelector("#test-" + field));
        FluentWait wait = globalFluentWait(10, 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#test-" + field)));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        return element.getText();
    }

    public void openAllSections() {

        WebElement element = getDriver().findElement(By.cssSelector("a.govuk-link"));
        FluentWait wait = globalFluentWait(10, 200);
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
        FluentWait wait = globalFluentWait(10, 200);
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
                        "Invalid tech record section '" + option + "'");
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
                        "Invalid tech record section '" + option + "'");
        }
    }

    public void editTechRecordDetails() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHANGE_TECHNICAL_RECORD_DETAILS)));
        getDriver().findElement(By.cssSelector(CHANGE_TECHNICAL_RECORD_DETAILS)).click();
    }

    public void saveTechRecordDetails() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SAVE_TECHNICAL_RECORD_DETAILS)));
        getDriver().findElement(By.cssSelector(SAVE_TECHNICAL_RECORD_DETAILS)).click();
    }

    public void deselectDangerousGoodCheckbox(String dangerousGood) {
        FluentWait wait = globalFluentWait(5, 200);
        String option = dangerousGood.toLowerCase();
        switch (option) {
            case "fp <61 (fl)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FP_61_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).click();
                }
                break;
            case "at":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(AT_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).click();
                }
                break;
            case "class 5.1 hydrogen peroxide (ox)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "memu":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MEMU_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).click();
                }
                break;
            case "carbon disulphide":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "hydrogen":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 2)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EXPLOSIVES_2_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(EXPLOSIVES_2_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(EXPLOSIVES_2_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 3)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EXPLOSIVES_3_DANGEROUS_GOOD)));
                if (getDriver().findElement(By.cssSelector(EXPLOSIVES_3_DANGEROUS_GOOD)).isSelected()) {
                    getDriver().findElement(By.cssSelector(EXPLOSIVES_3_DANGEROUS_GOOD)).click();
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid dangerous good '" + option + "'");
        }
    }

    public void selectDangerousGoodCheckbox(String dangerousGood) {
        String option = dangerousGood.toLowerCase();
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "fp <61 (fl)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FP_61_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(FP_61_DANGEROUS_GOOD)).click();
                }
                break;
            case "at":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(AT_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(AT_DANGEROUS_GOOD)).click();
                }
                break;
            case "class 5.1 hydrogen peroxide (ox)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_PEROXIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "memu":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MEMU_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(MEMU_DANGEROUS_GOOD)).click();
                }
                break;
            case "carbon disulphide":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(CARBON_DISULPHIDE_DANGEROUS_GOOD)).click();
                }
                break;
            case "hydrogen":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(HYDROGEN_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 2)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EXPLOSIVES_2_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(EXPLOSIVES_2_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(EXPLOSIVES_2_DANGEROUS_GOOD)).click();
                }
                break;
            case "explosives (type 3)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EXPLOSIVES_3_DANGEROUS_GOOD)));
                if (!(getDriver().findElement(By.cssSelector(EXPLOSIVES_3_DANGEROUS_GOOD)).isSelected())) {
                    getDriver().findElement(By.cssSelector(EXPLOSIVES_3_DANGEROUS_GOOD)).click();
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException(
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
        Assert.assertTrue("Text '" + field + "' was not found in '" + elementText + "'!", elementText.contains(field));
        Assert.assertTrue("Element with css selector '" + STATEMENT_FIELDS + "' is not displayed",
                getDriver().findElement(By.cssSelector(STATEMENT_FIELDS)).isDisplayed());
    }

    public void checkStatementFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(STATEMENT_FIELDS));
        if (elements.size() > 0) {
            Assert.assertFalse("Element with css selector '" + STATEMENT_FIELDS + "' is displayed",
                    getDriver().findElement(By.cssSelector(STATEMENT_FIELDS)).isDisplayed());
        }
    }

    public void checkProductListField(String field) {
        String elementText = getDriver().findElement(By.cssSelector(PRODUCT_LIST_FIELDS)).getText();
        Assert.assertTrue("Text '" + field + "' was not found in '" + elementText + "'!", elementText.contains(field));
        Assert.assertTrue("Element with css selector '" + PRODUCT_LIST_FIELDS + "' is not displayed",
                getDriver().findElement(By.cssSelector(PRODUCT_LIST_FIELDS)).isDisplayed());
    }

    public void checkProductListFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(PRODUCT_LIST_FIELDS));
        if (elements.size() > 0) {
            Assert.assertFalse("Element with css selector '" + PRODUCT_LIST_FIELDS + "' is displayed",
                    getDriver().findElement(By.cssSelector(PRODUCT_LIST_FIELDS)).isDisplayed());
        }
    }

    public void selectAdrVehicleType(String type) {
        FluentWait wait = globalFluentWait(5, 250);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADR_VEHICLE_TYPE)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ADR_VEHICLE_TYPE)));
        try {
            WebElement option = findElementByCss("option[value*='" + type.toLowerCase() + "']");
            if (!option.isSelected()) {
                option.click();
            }
        }
        catch (Exception e)
        {
            throw new AutomationException("Invalid adr vehicle type '" + type + "'");
        }
    }

    public void setBatteryListApplicable(String batteryListApplicableOption) {
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
        Assert.assertTrue("Text '" + text + "' was not found in '" + elementText + "'!", elementText.contains(text));
        Assert.assertTrue("Element with css selector '" + BATTERY_LIST_APPLICABLE_FIELDS + "' is not displayed",
                getDriver().findElement(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)).isDisplayed());
    }

    public void checkBatteryListApplicableFieldsNotPresent() {
        FluentWait wait = globalFluentWait(3, 200);
        List<WebElement> elements = getDriver().findElements(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS));
        if (elements.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)));
            Assert.assertFalse("Element with css selector '" + BATTERY_LIST_APPLICABLE_FIELDS + "' is displayed",
                    getDriver().findElement(By.cssSelector(BATTERY_LIST_APPLICABLE_FIELDS)).isDisplayed());
        }
    }

    public void checkManufacturerBrakeDeclarationField(String fieldName) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)));
        String elementText = getDriver().findElement(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)).getText();
        Assert.assertTrue("Text was not found!", elementText.contains(fieldName));
        Assert.assertTrue("Element with css selector '" + MANUFACTURER_BRAKE_DECLARATION + "' is not displayed",
                getDriver().findElement(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)).isDisplayed());
    }

    public void checkManufacturerBrakeDeclarationFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION));
        if (elements.size() > 0) {
            Assert.assertFalse("Element with css selector '" + MANUFACTURER_BRAKE_DECLARATION + "' is displayed",
                    getDriver().findElement(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION)).isDisplayed());
        }
    }

    public void checkBrakeEnduranceField(String fieldName) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(BRAKE_ENDURANCE_DECLARATION)));
        String elementText = getDriver().findElement(By.cssSelector(BRAKE_ENDURANCE_DECLARATION)).getText();
        Assert.assertTrue("Text '" + fieldName + "' was not found in '" + elementText + "'!",
                elementText.contains(fieldName));
        Assert.assertTrue("Element with css selector '" + BRAKE_ENDURANCE_DECLARATION + "' is not displayed",
                getDriver().findElement(By.cssSelector(BRAKE_ENDURANCE_DECLARATION)).isDisplayed());
    }

    public void checkBrakeEnduranceFieldsNotPresent() {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(BRAKE_ENDURANCE_DECLARATION));
        if (elements.size() > 0) {
            Assert.assertFalse("Element with css selector '" + BRAKE_ENDURANCE_DECLARATION + "' is displayed",
                    getDriver().findElement(By.cssSelector(BRAKE_ENDURANCE_DECLARATION)).isDisplayed());
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
        getDriver().findElement(By.cssSelector(CUSTOM_DANGEROUS_GOOD_INPUT)).clear();
        getDriver().findElement(By.cssSelector(CUSTOM_DANGEROUS_GOOD_INPUT)).sendKeys(customDangerousGood);
    }

    public void inputCustomGuidanceNote(String note) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_INPUT)));
        getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_INPUT)).clear();
        getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_INPUT)).sendKeys(note);
    }

    public void selectGuidanceNoteCheckbox(String note) {
        String option = note.toLowerCase();
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "1":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_1)));
                if (!getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1)).click();
                }
                break;
            case "1a":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_1A)));
                if (!getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1A)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1A)).click();
                }
                break;
            case "2":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_2)));
                if (!getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_2)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_2)).click();
                }
                break;
            case "3":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_3)));
                if (!getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_3)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_3)).click();
                }
                break;
            case "v1b":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_V1B)));
                if (!getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_V1B)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_V1B)).click();
                }
                break;
            case "t1b":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_T1B)));
                if (!getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_T1B)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_T1B)).click();
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid guidance note '" + option + "'");
        }
    }

    public void deselectCustomGuidanceNoteCheckbox(String note) {
        String option = note.toLowerCase();
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "1":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_1)));
                if (getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1)).click();
                }
                break;
            case "1a":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_1A)));
                if (getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1A)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_1A)).click();
                }
                break;
            case "2":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_2)));
                if (getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_2)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_2)).click();
                }
                break;
            case "3":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_3)));
                if (getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_3)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_3)).click();
                }
                break;
            case "v1b":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_V1B)));
                if (getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_V1B)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_V1B)).click();
                }
                break;
            case "t1b":
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(GUIDANCE_NOTE_T1B)));
                if (getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_T1B)).isSelected()) {
                    getDriver().findElement(By.cssSelector(GUIDANCE_NOTE_T1B)).click();
                }
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid guidance note '" + option + "'");
        }
    }

    public void inputUnNewNumber(String unNumber) {
        int noUnNumberInputFields = getDriver().findElements(By.cssSelector("[id^='productListUnNumber_']")).size();
        int lastIndex = noUnNumberInputFields - 1;
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(NEW_UN_NUMBER_INPUT + lastIndex)));
        getDriver().findElement(By.cssSelector(NEW_UN_NUMBER_INPUT + lastIndex)).clear();
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

    public void checkNumberOfEntriesInSection(String section, int numberOfEntries) {
        String option = section.toLowerCase();
        switch (option) {
            case "test history":
                Assert.assertEquals("Expected number of entries '" + numberOfEntries + "' differs than actual number '" +
                                getDriver().findElements(By.cssSelector(VEHICLE_SUMMARY_SECTION)).size() + "'",
                        numberOfEntries, getDriver().findElements(By.cssSelector(TEST_HISTORY_SECTION)).size() - 1);
                break;
            case "technical record history":
                Assert.assertEquals("Expected number of entries '" + numberOfEntries + "' differs than actual number '" +
                        getDriver().findElements(By.cssSelector(VEHICLE_SUMMARY_SECTION)).size() + "'",
                        numberOfEntries, getDriver().findElements(By.cssSelector(TECHNICAL_RECORD_HISTORY_SECTION)).size() - 1);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid tech record section '" + option + "'");
        }
    }

    public void checkAdrFieldDisplayed(String adrField) {
        Assert.assertTrue("Adr field '" + adrField + "' is not displayed", findElementByCss("#test-" + adrField).isDisplayed());
    }

    public void checkAdrSubsectionIsPresent(String subsection) {
        FluentWait wait = globalFluentWait(10, 300);
        String option = subsection.toLowerCase();
        switch (option) {
            case "owner/operator details":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-applicant-details")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-applicant-details")));
                break;
            case "adr details":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-adr-details")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-adr-details")));
                break;
            case "tank details":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-tank-details")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-tank-details")));
                break;
            case "tank inspections":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-tank-inpections")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-tank-inpections")));
                break;
            case "memo 07/09 (3 month extension)":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-memo")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-tank-inpections")));
                break;
            case "tank documents":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-tank-documents")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-tank-documents")));
                break;
            case "battery list":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-battery-list-applicable")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-battery-list-applicable")));
                break;
            case "declarations seen":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-declaration-seen")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-declaration-seen")));
                break;
            case "certificate":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-certificate")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-certificate")));
                break;
            case "additional adr details":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("vtm-additional-adr-details")));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-additional-adr-details")));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid adr subsection '" + option + "'");
        }
    }

    public void checkAdrSubsectionIsNotPresent(String subsection) {
        FluentWait wait = globalFluentWait(10, 300);
        String option = subsection.toLowerCase();
        switch (option) {
            case "owner/operator details":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-applicant-details")));
                break;
            case "adr details":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-adr-details")));
                break;
            case "tank details":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-tank-details")));
                break;
            case "tank inspections":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-tank-inpections")));
                break;
            case "memo 07/09 (3 month extension)":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-memo")));
                break;
            case "tank documents":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-tank-documents")));
                break;
            case "battery list":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-battery-list-applicable")));
                break;
            case "declarations seen":
            case "declaration seen":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-declaration-seen")));
                break;
            case "certificate":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-certificate")));
                break;
            case "additional adr details":
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("vtm-additional-adr-details")));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid adr subsection '" + option + "'");
        }
    }

    public void uploadAdrDocument(String fileName) {
        String workingDir = System.getProperty("user.dir");
        WebElement addFile = findElementByXpath(".//input[@type='file']");
        ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
        addFile.sendKeys(workingDir + "/src/main/resources/loader/upload/" + fileName);
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
    }

    public void uploadAdrDocument() {
        String workingDir = System.getProperty("user.dir");
        WebElement addFile = findElementByXpath(".//input[@type='file']");
        ((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
        addFile.sendKeys(workingDir + "/src/main/resources/loader/upload/sample.pdf");
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
        wait.until(ExpectedConditions.elementToBeClickable(findElementByCss(CHANGES_REASON_TEXT_AREA)));
        findElementByCss(CHANGES_REASON_TEXT_AREA).clear();
        String[] letters = reason. split("");
        for (int i = 0; i < reason.length(); i++) {
            try {
                Thread.sleep(100);
                findElementByCss(CHANGES_REASON_TEXT_AREA).sendKeys(letters[i]);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(CHANGES_REASON_TEXT_AREA), "value", reason));
    }

    public void confirmSavingChanges() {
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
                        By.cssSelector("vtm-applicant-details h2+*"), text));
                break;
            case "adr details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-adr-new-details h2+*"), text));
                break;
            case "tank details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-tank-details h2+*"), text));
                break;
            case "tank inspections":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-tank-inpections h2+*"), text));
                break;
            case "memo 07/09 (3 month extension)":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-memo h2+*"), text));
                break;
            case "tank documents":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-tank-documents h2+*"), text));
                break;
            case "battery list":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-battery-list-applicable h2+*"), text));
                break;
            case "declarations seen":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-declaration-seen h2+*"), text));
                break;
            case "certificate":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-certificate h2+*"), text));
                break;
            case "vtm-additional-adr-details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector("vtm-additional-adr-details h2+*"), text));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid adr subsection '" + option + "'");
        }
    }

    public void checkNumberOfTankDocumentsOnEdit() {
        Assert.assertEquals("The number of tank documents in the edit for is " + getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'Remove')]")).size() + " instead of " + noOfDocumentsOnEdit,
                noOfDocumentsOnEdit, getDriver().findElements(By.xpath("//vtm-tank-documents//a[contains(text(),'Remove')]")).size());
    }

    public void checkNumberOfTankDocuments() {
        Assert.assertEquals("The number of tank documents in the edit for is " + getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'View')]")).size() + " instead of " + noOfDocuments,
                noOfDocuments, getDriver().findElements(By.xpath("//vtm-tank-documents//a[contains(text(),'View')]")).size());
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
        if (value.equals("TODAYS_DATE")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            value = dateFormat.format(date);
        }
        if (value.equals("VTM_USER_EMAIL")) {
            value = TypeLoader.getAppUsername().substring(0, 1).toUpperCase() + TypeLoader.getAppUsername().substring(1);
        }
        if (StringUtils.isNumeric(value)) {
            Assert.assertTrue("Expected value '" + value + "' for field '" + field + "' is not the actual one '"
                    + getValueInTechRecordField(field) + "'", getValueInTechRecordField(field).contentEquals(value));
        }
        else {
            Assert.assertTrue("Expected value '" + value + "' for field '" + field + "' is not the actual one '"
                    + getValueInTechRecordField(field) + "'", getValueInTechRecordField(field).contains(value));
        }
    }

    public void downloadTankDocument(int index) {
        List<WebElement> viewDocuments = getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'View')]"));
        FluentWait wait = globalFluentWait(3, 200);
        wait.until(ExpectedConditions.elementToBeClickable(viewDocuments.get(index-1)));
        viewDocuments.get(index-1).click();
    }

    public void downloadTankDocument(String fileName) {
        WebElement viewDocument = getDriver().findElement(
                By.xpath("//vtm-tank-documents//td[contains(text(),'" + fileName + "')]//following-sibling::td[1]/a"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByXpath("//vtm-tank-documents//td[contains(text(),'" + fileName +
                "')]//following-sibling::td[1]/a"));
        actions.perform();
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(viewDocument));
        viewDocument.click();
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void removeAdrDocuments(int index) {
        List<WebElement> documents = getDriver().findElements(
                By.xpath("//vtm-tank-documents//a[contains(text(),'Remove')]"));
        documents.get(index-1).click();
    }

    public void removeAdrDocuments(String fileName) {
        WebElement removeDocument = getDriver().findElement(
                By.xpath("//vtm-tank-documents//td[contains(text(),'" + fileName + "')]//following-sibling::td[2]/a"));
        FluentWait wait = globalFluentWait(3, 200);
        wait.until(ExpectedConditions.elementToBeClickable(removeDocument));
        removeDocument.click();
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

    public void setProductListReferenceNumber(String refNo) {
        findElementByCss(PRODUCT_LIST_REF_NUMBER).clear();
        findElementByCss(PRODUCT_LIST_REF_NUMBER).sendKeys(refNo);
    }

    public void setBatteryListReferenceNumber(String refNo) {
        findElementByCss(BATTERY_LIST_REFERENCE_NUMBER).clear();
        findElementByCss(BATTERY_LIST_REFERENCE_NUMBER).sendKeys(refNo);
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
        findElementByCss(INITIAL_INSPECTION_CERTIFICATE).clear();
        findElementByCss(INITIAL_INSPECTION_CERTIFICATE).sendKeys(certificateNo);
        String[] date = expiryDate.split("/");
        if (date.length != 3) {
            throw new AutomationException("The date is not in proper format dd/MM/YYYY");
        }
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_DAY).clear();
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_DAY).sendKeys(date[0]);
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_MONTH).clear();
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_MONTH).sendKeys(date[1]);
        findElementByCss(INITIAL_INSPECTION_EXPIRY_DATE_YEAR).clear();
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
                SUBSEQUENT_INSPECTION_CERTIFICATE).clear();
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_CERTIFICATE).sendKeys(certificateNo);
        String[] date = expiryDate.split("/");
        if (date.length != 3) {
            throw new AutomationException("The date is not in proper format dd/MM/YYYY");
        }
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_DAY).clear();
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_DAY).sendKeys(date[0]);
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_MONTH).clear();
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_MONTH).sendKeys(date[1]);
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_YEAR).clear();
        findElementByCss("[formarrayname='tc3Details']>div:nth-of-type(" + index + ") " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_YEAR).sendKeys(date[2]);

    }

    public void selectHasAdrDetails(String option) {
        FluentWait wait = globalFluentWait(5, 200);
        switch(option.toLowerCase()) {
            case "be":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HAS_ADR_DETAILS)));
                scrollToAndClickByCss(HAS_ADR_DETAILS);
                break;
            case "not be":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HAS_NOT_ADR_DETAILS)));
                scrollToAndClickByCss(HAS_NOT_ADR_DETAILS);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid option '" + option + "'");
        }
    }

    public void addSubsequentInspection(String inspectionType, String certificateNo, String expiryDate) {
        Select selectInspectionType = new Select(findElementByCss("div[formarrayname='tc3Details']>div:last-of-type "
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
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_CERTIFICATE).clear();
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_CERTIFICATE).sendKeys(certificateNo);
        String[] date = expiryDate.split("/");
        if (date.length != 3) {
            throw new AutomationException("The date is not in proper format dd/MM/YYYY");
        }
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_DAY).clear();
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_DAY).sendKeys(date[0]);
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_MONTH).clear();
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_MONTH).sendKeys(date[1]);
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_YEAR).clear();
        findElementByCss("div[formarrayname='tc3Details']>div:last-of-type " +
                SUBSEQUENT_INSPECTION_EXPIRY_DATE_YEAR).sendKeys(date[2]);
    }

    public void fillInApplicantFieldWithValue(String applicantField, String value) {
        FluentWait wait = globalFluentWait(5, 200);
        switch(applicantField.toLowerCase()) {
            case "name":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(APPLICANT_NAME)));
                inputText(findElementByCss(APPLICANT_NAME), value);
                break;
            case "street":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(APPLICANT_STREET)));
                inputText(findElementByCss(APPLICANT_STREET), value);
                break;
            case "town":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(APPLICANT_TOWN)));
                inputText(findElementByCss(APPLICANT_TOWN), value);
                break;
            case "city":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(APPLICANT_CITY)));
                inputText(findElementByCss(APPLICANT_CITY), value);
                break;
            case "postcode":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(APPLICANT_POSTCODE)));
                inputText(findElementByCss(APPLICANT_POSTCODE), value);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid applicant details field '" + applicantField + "'");
        }
    }

    public void setProcessedDate(String processedDate) {
        String[] date = processedDate.split("/");
        if (date.length != 3) {
            throw new AutomationException("The date is not in proper format dd/MM/YYYY");
        }
        findElementByCss(DATE_PROCESSED_DAY).clear();
        findElementByCss(DATE_PROCESSED_DAY).sendKeys(date[0]);
        findElementByCss(DATE_PROCESSED_MONTH).clear();
        findElementByCss(DATE_PROCESSED_MONTH).sendKeys(date[1]);
        findElementByCss(DATE_PROCESSED_YEAR).clear();
        findElementByCss(DATE_PROCESSED_YEAR).sendKeys(date[2]);
    }

    public void setCompatibilityGroupJ(String option) {
        FluentWait wait = globalFluentWait(5, 200);
        switch(option.toLowerCase()) {
            case "yes":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(COMPATIBILITY_GROUP_J_YES)));
                scrollToAndClickByCss(COMPATIBILITY_GROUP_J_YES);
                break;
            case "no":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(COMPATIBILITY_GROUP_J_NO)));
                scrollToAndClickByCss(COMPATIBILITY_GROUP_J_NO);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid compatibility group J option '" + option + "'");
        }
    }

    public void fillInAdrApprovalTypeNumberWithValue(String approvalNo) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(APPROVAL_TYPE_NO)));
        findElementByCss(APPROVAL_TYPE_NO).clear();
        findElementByCss(APPROVAL_TYPE_NO).sendKeys(approvalNo);
    }

    public void fillInTankFieldWithValue(String tankField, String value) {
        FluentWait wait = globalFluentWait(5, 200);
        switch(tankField.toLowerCase()) {
            case "make":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(TANK_MANUFACTURER)));
                findElementByCss(TANK_MANUFACTURER).clear();
                findElementByCss(TANK_MANUFACTURER).sendKeys(value);
                break;
            case "year of manufacture":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(TANK_YEAR_OF_MANUFACTURE)));
                findElementByCss(TANK_YEAR_OF_MANUFACTURE).clear();
                findElementByCss(TANK_YEAR_OF_MANUFACTURE).sendKeys(value);
                break;
            case "manufacturer serial number":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(TANK_MANUFACTURER_SERIAL_NO)));
                findElementByCss(TANK_MANUFACTURER_SERIAL_NO).clear();
                findElementByCss(TANK_MANUFACTURER_SERIAL_NO).sendKeys(value);
                break;
            case "manufacturer type approval number":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(TANK_TYPE_APPROVAL_NUMBER)));
                findElementByCss(TANK_TYPE_APPROVAL_NUMBER).clear();
                findElementByCss(TANK_TYPE_APPROVAL_NUMBER).sendKeys(value);
                break;
            case "code":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(TANK_CODE)));
                findElementByCss(TANK_CODE).clear();
                findElementByCss(TANK_CODE).sendKeys(value);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid tank details field '" + tankField + "'");
        }
    }

    public void fillInSpecialProvisions(String provisions) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPECIAL_PROVISIONS)));
        findElementByCss(SPECIAL_PROVISIONS).clear();
        findElementByCss(SPECIAL_PROVISIONS).sendKeys(provisions);
    }


    public void setMemoTo(String option) {
        FluentWait wait = globalFluentWait(5, 200);
        switch(option.toLowerCase()) {
            case "yes":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MEMO_07_09_YES)));
                scrollToAndClickByCss(MEMO_07_09_YES);
                break;
            case "no":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MEMO_07_09_NO)));
                scrollToAndClickByCss(MEMO_07_09_NO);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid memo 07/09 option '" + option + "'");
        }
    }

    public void setCertificateRequiredTo(String option) {
        FluentWait wait = globalFluentWait(5, 200);
        switch(option.toLowerCase()) {
            case "yes":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CERTIFICATE_REQUIRED_YES)));
                scrollToAndClickByCss(CERTIFICATE_REQUIRED_YES);
                break;
            case "no":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CERTIFICATE_REQUIRED_NO)));
                scrollToAndClickByCss(CERTIFICATE_REQUIRED_NO);
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid certificate required option '" + option + "'");
        }
    }

    public void fillInAdditionalAdrDetailsWith(String details) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ADDITIONAL_ADR_DETAILS)));
        findElementByCss(ADDITIONAL_ADR_DETAILS).clear();
        findElementByCss(ADDITIONAL_ADR_DETAILS).sendKeys(details);
    }

    public void cancelSavingDetails() {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CANCEL_SAVE_DETAILS_MODAL)));
        findElementByCss(CANCEL_SAVE_DETAILS_MODAL).click();
    }

    public void fillInAdditionalProductListDetailsWithValue(String details) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(PRODUCT_LIST_ADDITIONAL_DETAILS)));
        findElementByCss(PRODUCT_LIST_ADDITIONAL_DETAILS).clear();
        findElementByCss(PRODUCT_LIST_ADDITIONAL_DETAILS).sendKeys(details);
    }

    public void fillInIssuerWithValue(String issuer) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MANUFACTURER_BRAKE_DECLARATION_ISSUER)));
        findElementByCss(MANUFACTURER_BRAKE_DECLARATION_ISSUER).clear();
        findElementByCss(MANUFACTURER_BRAKE_DECLARATION_ISSUER).sendKeys(issuer);
    }

    public void fillInBrakeWeightWithValue(String weight) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BRAKE_ENDURANCE_WEIGHT)));
        findElementByCss(BRAKE_ENDURANCE_WEIGHT).clear();
        findElementByCss(BRAKE_ENDURANCE_WEIGHT).sendKeys(weight);
    }

    public void confirmAdrDocumentIsUploaded(String fileName) {
        int numberOfExistingDocuments = getDriver().findElements(By.cssSelector
                ("vtm-tank-documents tr>td:nth-of-type(2)")).size();
        int actualIndex = numberOfExistingDocuments - 1;
        Assert.assertEquals("Filename is '" + findElementByCss("#test-document-name-" + actualIndex).getText()
                + "' instead of '" + fileName +"'", fileName, findElementByCss("#test-document-name-" + actualIndex).getText());
        Assert.assertEquals("'View' link for uploaded document is not present", "View",
                findElementByCss("#test-document-view-" + actualIndex).getText());
        Assert.assertEquals("'Remove' link for uploaded document is not present", "Remove",
                findElementByCss("#test-document-remove-" + actualIndex).getText());
    }

    public void checkAdrDocumentPresentInTankDetails(String fileName) {
        List<WebElement> files = getDriver().findElements(By.cssSelector("[id^='test-document-name-']"));
        int i = 0;
        for (WebElement file : files) {
            if (fileName.contentEquals(file.getText())) {
                break;
            }
            else {
                i++;
            }
        }
        Assert.assertNotEquals("File with name '" + fileName + "' was not found in the tank documents sections",
                files.size(), i);
    }

    public void checkErrorMessageIsPresent(String message) {
        checkTextInElementWithCssSelector(ERROR_BLOCK, message);
    }

    public void clickViewForTestRecordWithIndex(int testIndex) {
        FluentWait wait = globalFluentWait(5, 300);
        int actualIndex = testIndex - 1;
        getDriver().findElement(By.cssSelector("[id^='test-view-" + actualIndex + "']>a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("vtm-test-record")));
        waitForAngularRequestsToFinish();
    }

    public void checkSectionEmpty(String section) {
        String option = section.toLowerCase();
        FluentWait wait = globalFluentWait(5, 300);
        switch (option) {
            case "test history":
                wait.until(ExpectedConditions.numberOfElementsToBe
                        (By.cssSelector(TEST_HISTORY_SECTION + ":not([class])"), 1));
                break;
            case "technical record history":
                wait.until(ExpectedConditions.numberOfElementsToBe
                        (By.cssSelector(TECHNICAL_RECORD_HISTORY_SECTION + ":not([class])"), 1));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid tech record section " + section);
        }
    }

    public void setInputTechRecordField(String field, String country) {
        WebElement element = getDriver().findElement(By.id("test-" + field));
        element.clear();
        element.sendKeys(country);
    }

    public void setRadioButtonTechRecordField(String field, String value) {
        WebElement element = getDriver().findElement(By.id("test-" + field + "-" + value));
        element.click();
    }

    public void setSelectTechRecordField(String field, String value) {
        Select selectElement = new Select(getDriver().findElement(By.id("test-" + field)));
        selectElement.selectByValue(value);
    }

    public void checkSectionIsExpanded(String section) {
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle":
                Assert.assertTrue("The '" + section + "' section is not expanded",
                        findElementByCss("#accordion-default>:nth-child(2) div").getAttribute("class").contains("expanded"));
                break;
            case "test":
                Assert.assertTrue("The '" + section + "' section is not expanded",
                        findElementByCss("#accordion-default>:nth-child(3) div").getAttribute("class").contains("expanded"));
                break;
            case "defects":
                if (findElementByCss("#accordion-default>:nth-child(5) div").isDisplayed()) {
                    Assert.assertTrue("The '" + section + "' section is not expanded",
                            findElementByCss("#accordion-default>:nth-child(4) div").getAttribute("class").contains("expanded"));
                }
                break;
            case "seatbelt installation check":
                if (findElementByCss("#accordion-default>:nth-child(5) div").isDisplayed()) {
                    Assert.assertTrue("The '" + section + "' section is not expanded",
                            findElementByCss("#accordion-default>:nth-child(5) div").getAttribute("class").contains("expanded"));
                }
                break;
            case "emission details":
                if (findElementByCss("#accordion-default>:nth-child(6) div").isDisplayed()) {
                    Assert.assertTrue("The '" + section + "' section is not expanded",
                            findElementByCss("#accordion-default>:nth-child(6) div").getAttribute("class").contains("expanded"));
                }
                break;
            case "visit":
                Assert.assertTrue("The '" + section + "' section is not expanded",
                        findElementByCss("#accordion-default>:nth-child(7) div").getAttribute("class").contains("expanded"));
                break;
            case "notes":
                Assert.assertTrue("The '" + section + "' section is not expanded",
                        findElementByCss("#accordion-default>:nth-child(8) div").getAttribute("class").contains("expanded"));
                break;
            case "test record history":
                Assert.assertTrue("The '" + section + "' section is not expanded",
                        findElementByCss("#accordion-default>:nth-child(9) div").getAttribute("class").contains("expanded"));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section '" + option + "'");
        }
    }

    public void checkSectionIsCollapsed(String section) {
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle":
                Assert.assertTrue("The '" + section + "' section is not collapsed",
                        findElementByCss("#accordion-default>:nth-child(2) div").getAttribute("class").contains("expanded"));
                break;
            case "test":
                Assert.assertTrue("The '" + section + "' section is not collapsed",
                        findElementByCss("#accordion-default>:nth-child(3) div").getAttribute("class").contains("expanded"));
                break;
            case "defects":
                if (findElementByCss("#accordion-default>:nth-child(4) div").isDisplayed()) {
                    Assert.assertTrue("The '" + section + "' section is not collapsed",
                            findElementByCss("#accordion-default>:nth-child(4) div").getAttribute("class").contains("expanded"));
                }
                break;
            case "seatbelt installation check":
                if (findElementByCss("#accordion-default>:nth-child(5) div").isDisplayed()) {
                    Assert.assertTrue("The '" + section + "' section is not collapsed",
                            findElementByCss("#accordion-default>:nth-child(5) div").getAttribute("class").contains("expanded"));
                }
                break;
            case "emission details":
                if (findElementByCss("#accordion-default>:nth-child(6) div").isDisplayed()) {
                    Assert.assertTrue("The '" + section + "' section is not collapsed",
                            findElementByCss("#accordion-default>:nth-child(6) div").getAttribute("class").contains("expanded"));
                }
                break;
            case "visit":
                Assert.assertTrue("The '" + section + "' section is not collapsed",
                        findElementByCss("#accordion-default>:nth-child(7) div").getAttribute("class").contains("expanded"));
                break;
            case "notes":
                Assert.assertTrue("The '" + section + "' section is not collapsed",
                        findElementByCss("#accordion-default>:nth-child(8) div").getAttribute("class").contains("expanded"));
                break;
            case "test record history":
                Assert.assertTrue("The '" + section + "' section is not collapsed",
                        findElementByCss("#accordion-default>:nth-child(9) div").getAttribute("class").contains("expanded"));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section '" + option + "'");
        }
    }

    public void checkAllSectionsAreExpanded() {
        Assert.assertEquals("Not all sections are expanded", 17, getDriver().findElements
                (By.cssSelector("mat-expansion-panel-header[aria-expanded='true']")).size());
    }

    public void checkAllSectionsAreCollapsed() {
        Assert.assertEquals("Not all sections are collapsed", 0, getDriver().findElements
                (By.cssSelector("mat-expansion-panel-header[aria-expanded='true']")).size());
    }

    public void checkTextIsNotPresentInSection(String text, String section) {
        FluentWait wait = globalFluentWait(8, 300);
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-0"), text)));
                break;
            case "body":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-1"), text)));
                break;
            case "weights":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-2"), text)));
                break;
            case "tyres":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-3"), text)));
                break;
            case "brakes":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-4"), text)));
                break;
            case "dimensions":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-5"), text)));
                break;
            case "adr":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-6"), text)));
                break;
            case "applicant":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-7"), text)));
                break;
            case "purchaser":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-13"), text)));
                break;
            case "manufacturer":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-14"), text)));
                break;
            case "authorisation into service":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-15"), text)));
                break;
            case "letters of authorisation":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-16"), text)));
                break;
            case "documents":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-8"), text)));
                break;
            case "notes":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-9"), text)));
                break;
            case "test history":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-10"), text)));
                break;
            case "technical record history":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-11"), text)));
                break;
            case "plates":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.id
                        ("cdk-accordion-child-12"), text)));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid tech record section '" + option + "'");
        }
    }

    public void checkTextIsPresentInSection(String text, String section) {
        FluentWait wait = globalFluentWait(8, 300);
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-0"), text));
                break;
            case "body":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-1"), text));
                break;
            case "weights":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-2"), text));
                break;
            case "tyres":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-3"), text));
                break;
            case "brakes":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-4"), text));
                break;
            case "dimensions":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-5"), text));
                break;
            case "adr":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-6"), text));
                break;
            case "applicant":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-7"), text));
                break;
            case "purchaser":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-13"), text));
                break;
            case "manufacturer":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-14"), text));
                break;
            case "authorisation into service":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-15"), text));
                break;
            case "letters of authorisation":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-16"), text));
                break;
            case "documents":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-8"), text));
                break;
            case "notes":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-9"), text));
                break;
            case "test history":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-10"), text));
                break;
            case "technical record history":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-11"), text));
                break;
            case "plates":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cdk-accordion-child-12"), text));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid tech record section '" + option + "'");
        }
    }
}