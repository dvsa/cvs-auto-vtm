package pages;

import exceptions.AutomationException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TypeLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestRecordPage extends GenericPage {

    private static final String OPEN_CLOSE_ALL_SECTIONS = "button.govuk-accordion__open-all";
    private static final String OPEN_VEHICLE_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_TEST_SECTION = "#test-fa-plus-body";
    private static final String OPEN_DEFECTS_SECTION = "#test-fa-plus-weights";
    private static final String OPEN_VISIT_SECTION = "#test-fa-plus-tyres";
    private static final String OPEN_NOTES_SECTION = "#test-fa-minus-notes";
    private static final String OPEN_TEST_HISTORY_SECTION = "#test-fa-minus-testHistory";
    private static final String CLOSE_VEHICLE_SECTION = "#test-fa-plus-summary";
    private static final String CLOSE_TEST_SECTION = "#test-fa-plus-body";
    private static final String CLOSE_DEFECTS_SECTION = "#test-fa-plus-weights";
    private static final String CLOSE_VISIT_SECTION = "#test-fa-plus-tyres";
    private static final String CLOSE_NOTES_SECTION = "#test-fa-minus-notes";
    private static final String CLOSE_TEST_HISTORY_SECTION = "#test-fa-minus-testHistory";
    private static final String CHANGES_REASON_TEXT_AREA = "#test-reasonForCreation";
    private static final String CONFIRM_SAVE_CHANGES_MODAL = "vtm-dialog-box button";
    private static final String CANCEL_SAVE_CHANGES_MODAL = "vtm-dialog-box a";
    private static final String REASON_FOR_CHANGES_MODAL = "mat-dialog-container";
    private static final String ODOMETER_READING = "#test-odometerReading";
    private static final String ODOMETER_READING_UNIT = "#test-odometerReadingUnit";
    private static final String CHANGE_TECHNICAL_RECORD_DETAILS = "div.ng-star-inserted>button.govuk-button";
    private static final String SAVE_TECHNICAL_RECORD_DETAILS = "div.ng-star-inserted>button.govuk-button";
    private static final String VEHICLE_SECTION = "vtm-vehicle";
    private static final String TEST_SECTION = "vtm-test-section";
    private static final String SEATBELT_INSTALLATION_CHECK_SECTION = "vtm-seatbelt-installation-check";
    private static final String EMISSIONS_DETAILS_SECTION = "vtm-emission-details";
    private static final String VISIT_SECTION = "vtm-visit";
    private static final String NOTES_SECTION = "vtm-notes";
    private static final String TEST_RECORD_HISTORY_SECTION = "vtm-test-history";

    static String odometerReading;
    static String odometerReadingOnEdit;
    static String odometerReadingUnit;

    public void checkTestRecordPageUrl() {
        Assert.assertTrue("The expected url '" + TechRecordPage.testRecordPageUrl + "' does not match actual one '"
                + getDriver().getCurrentUrl() + "'", getDriver().getCurrentUrl().contentEquals(TechRecordPage.testRecordPageUrl));
    }

    public void checkChangeTestTypePageUrl() {
        String[] parts = TechRecordPage.testRecordPageUrl.split("[/?.]");
        Assert.assertTrue("The expected url does not contain 'select-test-type/"
                + parts[8] + "'", getDriver().getCurrentUrl().contains("select-test-type/" +
                parts[8]));
    }

    public void openAllSections() {
        if (!(findElementByCss(OPEN_CLOSE_ALL_SECTIONS).getText().contains("Close all"))) {
            WebElement element = getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS));
            FluentWait wait = globalFluentWait(10, 200);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)));
            wait.until(ExpectedConditions.textToBePresentInElement(find(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)), "Open all"));
            Actions actions = new Actions(getDriver());
            actions.moveToElement(element);
            actions.perform();
            new WebDriverWait(getDriver(), 5).
                    until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)))));
            new WebDriverWait(getDriver(), 5).
                    until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS))));
            getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)).click();
            waitForTextToAppear("Close all");
        }
    }

    public void closeAllSections() {

        WebElement element = getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS));
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)));
        wait.until(ExpectedConditions.textToBePresentInElement(find(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)), "Close all"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)))));
        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS))));
        getDriver().findElement(By.cssSelector(OPEN_CLOSE_ALL_SECTIONS)).click();
        waitForTextToAppear("Open all");
    }

    public void openSection(String section) {
        String option = section.toLowerCase();
        Actions actions = new Actions(getDriver());
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "vehicle":
                if (getDriver().findElements(By.cssSelector(CLOSE_VEHICLE_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_VEHICLE_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_VEHICLE_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_VEHICLE_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_VEHICLE_SECTION)).click();
                }
                break;
            case "test":
                if (getDriver().findElements(By.cssSelector(CLOSE_TEST_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_TEST_SECTION)));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_TEST_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_TEST_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_TEST_SECTION)).click();
                }
                break;
            case "defects":
                if (getDriver().findElements(By.cssSelector(CLOSE_DEFECTS_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_DEFECTS_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_DEFECTS_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_DEFECTS_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_DEFECTS_SECTION)).click();
                }
                break;
            case "visit":
                if (getDriver().findElements(By.cssSelector(CLOSE_VISIT_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPEN_VISIT_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OPEN_VISIT_SECTION)));
                    actions.moveToElement(findElementByCss(OPEN_VISIT_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(OPEN_VISIT_SECTION)).click();
                }
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
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section '" + option + "'");
        }
        actions.perform();
    }

    public void closeSection(String section) {
        String option = section.toLowerCase();
        Actions actions = new Actions(getDriver());
        FluentWait wait = globalFluentWait(5, 200);
        switch (option) {
            case "vehicle":
                if (getDriver().findElements(By.cssSelector(OPEN_VEHICLE_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_VEHICLE_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_VEHICLE_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_VEHICLE_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_VEHICLE_SECTION)).click();
                }
                break;
            case "test":
                if (getDriver().findElements(By.cssSelector(OPEN_TEST_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_TEST_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_TEST_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_TEST_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_TEST_SECTION)).click();
                }
                break;
            case "defects":
                if (getDriver().findElements(By.cssSelector(OPEN_DEFECTS_SECTION)).size() == 0) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CLOSE_DEFECTS_SECTION)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CLOSE_DEFECTS_SECTION)));
                    actions.moveToElement(findElementByCss(CLOSE_DEFECTS_SECTION));
                    actions.perform();
                    getDriver().findElement(By.cssSelector(CLOSE_DEFECTS_SECTION)).click();
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
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section '" + option + "'");
        }
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
        findElementByCss(CONFIRM_SAVE_CHANGES_MODAL).click();
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
        odometerReading = odometerReadingOnEdit;
    }

    public void cancelSavingChanges() {
        findElementByCss(CANCEL_SAVE_CHANGES_MODAL).click();
        FluentWait wait = globalFluentWait(2, 200);
        wait.until(ExpectedConditions.not(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(REASON_FOR_CHANGES_MODAL))));
    }

    public void increaseOdometerReadingBy(int value) {
        String initialValue = findElementByCss(ODOMETER_READING).getAttribute("value");
        odometerReadingUnit = findElementByCss(ODOMETER_READING_UNIT).getAttribute("value");
        int newOdometerReading = Integer.parseInt(initialValue) + value;
        findElementByCss(ODOMETER_READING).clear();
        findElementByCss(ODOMETER_READING).sendKeys(Integer.toString(newOdometerReading));
        odometerReadingOnEdit = Integer.toString(newOdometerReading);
    }

    public void checkTextIsPresentInSaveChangesModal(String text) {
        checkTextIsPresentInElementWithCssSelector(REASON_FOR_CHANGES_MODAL, text);
    }

    public void checkValueInTestRecordField(String value, String field) {
        if (value.equals("TODAYS_DATE")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            value = dateFormat.format(date);
        }
        if (value.equals("VTM_USER_EMAIL")) {
            value = TypeLoader.getAppUsername().substring(0, 1).toUpperCase() + TypeLoader.getAppUsername().substring(1);
        }
        if (value.equals("VTM_USER")) {
            value = TypeLoader.getAppUsername().split("-")[0];
        }
        if (StringUtils.isNumeric(value)) {
            Assert.assertTrue("Expected value '" + value + "' for field '" + field + "' is not the actual one '"
                    + getValueInTestRecordField(field) + "'", getValueInTestRecordField(field).contentEquals(value));
        }
        else {
            Assert.assertTrue("Expected value '" + value + "' for field '" + field + "' is not the actual one '"
                    + getValueInTestRecordField(field) + "'", getValueInTestRecordField(field).contains(value));
        }
    }

    public String getValueInTestRecordField(String field) {
        WebElement element = getDriver().findElement(By.cssSelector("#test-" + field));
        FluentWait wait = globalFluentWait(10, 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#test-" + field)));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        return element.getText();
    }

    public void checkOdometerReadingValue() {
        int no = Integer.parseInt(odometerReading);
        String actualOdometerReading = String.format("%,d", no);;
        Assert.assertTrue("Expected value '" + actualOdometerReading + "' for 'odometerReading' is not contained in '"
                + getDriver().findElement(By.cssSelector(ODOMETER_READING)).getText() + "'",
                getDriver().findElement(By.cssSelector(ODOMETER_READING)).getText().contains(actualOdometerReading));
        Assert.assertTrue("Expected value '" + odometerReadingUnit + "' for 'odometerReading' is not contained in '"
                + getDriver().findElement(By.cssSelector(ODOMETER_READING)).getText() + "'",
                getDriver().findElement(By.cssSelector(ODOMETER_READING)).getText().contains(odometerReadingUnit));
    }

    public void checkOdometerReadingValueOnEdit() {
        Assert.assertTrue("Expected value '" + odometerReadingOnEdit + "' for 'odometerReading' is not contained in '"
                + findElementByCss(ODOMETER_READING).getAttribute("value") + "'",
                findElementByCss(ODOMETER_READING).getAttribute("value").contentEquals(odometerReadingOnEdit));
    }

    public void cancelSavingDetails() {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CANCEL_SAVE_CHANGES_MODAL)));
        findElementByCss(CANCEL_SAVE_CHANGES_MODAL).click();
    }

    public void checkNumberOfEntriesInSection(String section, int numberOfEntries) {
        FluentWait wait = globalFluentWait(10, 250);
        String option = section.toLowerCase();
        if (option.contentEquals("test record history")) {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("vtm-test-history tbody>tr"), numberOfEntries));
            Assert.assertEquals("Expected number of entries '" + numberOfEntries + "' differs than actual number '" +
                            getDriver().findElements(By.cssSelector("vtm-test-history tbody>tr")).size() + "'",
                    numberOfEntries, getDriver().findElements(By.cssSelector("vtm-test-history tbody>tr")).size());
        }
        else {
            throw new AutomationException("Invalid test record section '" + option + "'");
        }
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
        Assert.assertEquals("Not all sections are expanded", 8, getDriver().findElements
                (By.cssSelector("#accordion-default div[class*='govuk-accordion__section--expanded']")).size());
    }

    public void checkAllSectionsAreCollapsed() {
        Assert.assertEquals("Not all sections are collapsed", 0, getDriver().findElements
                (By.cssSelector("#accordion-default div[class*='govuk-accordion__section--expanded']")).size());
    }

    public void expandSection(String section) {
        if (findElementByXpath("//span[text() = '" + section + "']").isDisplayed()) {
            if (findElementByXpath("//span[text() = '" + section + "']/following-sibling::button")
                    .getAttribute("aria-expanded").contentEquals("false")) {
                findElementByXpath("//span[text() = '" + section + "']/..").click();
            }
            else {
                System.out.println("Test record section '" + section + "' is already expanded");
            }
        }
        else {
            throw new AutomationException(
                    "Test record section '" + section + "' is not visible!");
        }
    }

    public void collapseSection(String section) {
        if (findElementByXpath("//span[text() = '" + section + "']").isDisplayed()) {
            if (findElementByXpath("//span[text() = '" + section + "']/following-sibling::button")
                    .getAttribute("aria-expanded").contentEquals("true")) {
                findElementByXpath("//span[text() = '" + section + "']/..").click();
            }
            else {
                System.out.println("Test record section '" + section + "' is already collapsed");
            }
        }
        else {
            throw new AutomationException(
                    "Test record section '" + section + "' is not visible!");
        }
    }

    public void checkSectionIsPresent(String section) {
        List<WebElement> sections = getDriver().findElements(By.cssSelector("vtm-accordion span.govuk-link"));
        boolean found = false;
        boolean isVisible = false;
        for (WebElement element : sections) {
            if (element.getText().contentEquals(section)) {
                found = true;
                if (element.isDisplayed()) {
                    isVisible = true;
                }
                break;
            }
        }
        if (!(found)) {
            throw new AutomationException("Either section '" + section + "' is not displayed but it should be or " +
                    "the section name '" + section + "' is invalid");
        }
        if (!(isVisible)) {
            throw new AutomationException("Test record section '" + section + "' is not displayed but it should be");
        }
    }

    public void checkSectionIsNotPresent(String section) {
        List<WebElement> sections = getDriver().findElements(By.cssSelector("vtm-accordion span.govuk-link"));
        boolean found = false;
        boolean isVisible = false;
        for (WebElement element : sections) {
            if (element.getText().contentEquals(section)) {
                found = true;
                if (element.isDisplayed()) {
                    isVisible = true;
                }
                break;
            }

        }
        if ((found) && (isVisible)) {
            throw new AutomationException("Test record section '" + section + "' is displayed but it should not be");
        }
    }

    public void checkTextIsNotPresentInSection(String field, String section) {
        FluentWait wait = globalFluentWait(8, 300);
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(2)"), field)));
                break;
            case "test":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(3)"), field)));
                break;
            case "defects":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(4)"), field)));
                break;
            case "seatbelt installation check":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(5)"), field)));
                break;
            case "emission details":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(6)"), field)));
                break;
            case "visit":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(7)"), field)));
                break;
            case "notes":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(8)"), field)));
                break;
            case "test record history":
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(9)"), field)));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section '" + option + "'");
        }
    }

    public void checkTextIsPresentInSection(String field, String section) {
        FluentWait wait = globalFluentWait(15, 300);
        String option = section.toLowerCase();
        switch (option) {
            case "vehicle":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(2)"), field));
                break;
            case "test":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(3)"), field));
                break;
            case "defects":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(4)"), field));
                break;
            case "seatbelt installation check":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(5)"), field));
                break;
            case "emission details":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(6)"), field));
                break;
            case "visit":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(7)"), field));
                break;
            case "notes":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(8)"), field));
                break;
            case "test record history":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#accordion-default>:nth-child(9)"), field));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section '" + option + "'");
        }
    }

    public void checkSectionEmpty(String section) {
        String option = section.toLowerCase();
        switch (option) {
            case "defects":
                Assert.assertEquals("Section '" + section + "' is not empty", 0, getDriver().
                        findElements(By.cssSelector("vtm-defects>*")).size());
                break;
            case "test record history":
                Assert.assertEquals("Section '" + section + "' is not empty", 0, getDriver().
                        findElements(By.cssSelector("vtm-yest-history>*")).size());
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Invalid test record section " + section);
        }
    }

    public void checkTestStationType(String value) {
        WebElement element = getDriver().findElement(By.cssSelector("div.section--test-station>span"));
        Assert.assertTrue("Value for type of test facility is '" + element.getText() + "' but should be '" + value + "'",
                element.getText().contentEquals(value));
    }
}