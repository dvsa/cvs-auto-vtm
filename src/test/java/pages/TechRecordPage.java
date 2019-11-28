package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TechRecordPage extends GenericPage {

    private static final String OPEN_CLOSE_ALL_SECTIONS = "a.govuk-link";
    private static final String OPEN_VEHICLE_SUMMARY_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_BODY_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_WEIGHTS_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_TYRES_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_DIMENSIONS_SECTION_ = "#test-fa-plus-summary";
    private static final String OPEN_ADR_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_NOTES_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_TEST_HISTORY_SECTION = "#test-fa-plus-summary";
    private static final String OPEN_TECHNICAL_RECORD_HISTORY_SECTION = "#test-fa-plus-summary";
    private static final String CLOSE_VEHICLE_SUMMARY_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_BODY_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_WEIGHTS_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_TYRES_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_DIMENSIONS_SECTION_ = "#test-fa-minus-summary";
    private static final String CLOSE_ADR_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_NOTES_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_TEST_HISTORY_SECTION = "#test-fa-minus-summary";
    private static final String CLOSE_TECHNICAL_RECORD_HISTORY_SECTION = "#test-fa-minus-summary";


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

    public void openSection(String arg0) {
        switch (arg0) {
            case "Vehicle summary":
                getDriver().findElement(By.cssSelector(OPEN_VEHICLE_SUMMARY_SECTION)).click();
                break;
            case "Body":
                getDriver().findElement(By.cssSelector(OPEN_BODY_SECTION)).click();
                break;
            case "Weights":
                getDriver().findElement(By.cssSelector(OPEN_WEIGHTS_SECTION)).click();
                break;
            case "Tyres":
                getDriver().findElement(By.cssSelector(OPEN_TYRES_SECTION)).click();
                break;
            case "Dimensions":
                getDriver().findElement(By.cssSelector(OPEN_DIMENSIONS_SECTION_)).click();
                break;
            case "ADR":
                getDriver().findElement(By.cssSelector(OPEN_ADR_SECTION)).click();
                break;
            case "Notes":
                getDriver().findElement(By.cssSelector(OPEN_NOTES_SECTION)).click();
                break;
            case "Test history":
                getDriver().findElement(By.cssSelector(OPEN_TEST_HISTORY_SECTION)).click();
                break;
            case "Technical record history":
                getDriver().findElement(By.cssSelector(OPEN_TECHNICAL_RECORD_HISTORY_SECTION)).click();
                break;
        }
    }

    public void closeSection(String arg0) {
        switch (arg0) {
            case "Vehicle summary":
                getDriver().findElement(By.cssSelector(CLOSE_VEHICLE_SUMMARY_SECTION)).click();
                break;
            case "Body":
                getDriver().findElement(By.cssSelector(CLOSE_BODY_SECTION)).click();
                break;
            case "Weights":
                getDriver().findElement(By.cssSelector(CLOSE_WEIGHTS_SECTION)).click();
                break;
            case "Tyres":
                getDriver().findElement(By.cssSelector(CLOSE_TYRES_SECTION)).click();
                break;
            case "Dimensions":
                getDriver().findElement(By.cssSelector(CLOSE_DIMENSIONS_SECTION_)).click();
                break;
            case "ADR":
                getDriver().findElement(By.cssSelector(CLOSE_ADR_SECTION)).click();
                break;
            case "Notes":
                getDriver().findElement(By.cssSelector(CLOSE_NOTES_SECTION)).click();
                break;
            case "Test history":
                getDriver().findElement(By.cssSelector(CLOSE_TEST_HISTORY_SECTION)).click();
                break;
            case "Technical record history":
                getDriver().findElement(By.cssSelector(CLOSE_TECHNICAL_RECORD_HISTORY_SECTION)).click();
                break;
        }
    }
}