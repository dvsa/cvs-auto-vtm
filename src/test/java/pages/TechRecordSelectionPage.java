package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



public class TechRecordSelectionPage extends GenericPage {

    TechRecordPage techRecordPage;

    private static final String SELECT_TECHNICAL_RECORD_SCREEN = "//h1[contains(.,'Select a technical record')]";
    private static final String NULL_ATTRIBUTE_VALUE = "(//dd[@class=\"govuk-summary-list__value\"])[10]";
    private static final String TECH_RECORD_HEADING = "//h3[@class=\"govuk-heading-m\"]";
    private static final String SELECT_TECH_REC_HYPERLINK = "//a[contains(.,'Select technical record')]";
    private static final String SELECT_TECH_REC_ONE_HYPERLINK = "(//a[contains(.,'Select technical record')])[1]";
    private static final String PROVISIONAL_MAKE = "(//dd[@class=\"govuk-summary-list__value\"])[5]";
    private static final String PROVISIONAL_MODEL = "(//dd[@class=\"govuk-summary-list__value\"])[6]";
    private static final String CURRENT_MAKE = "(//dd[@class=\"govuk-summary-list__value\"])[11]";
    private static final String CURRENT_MODEL = "(//dd[@class=\"govuk-summary-list__value\"])[12]";
    private static final String ARCHIVED_MAKE = "(//dd[@class=\"govuk-summary-list__value\"])[17]";
    private static final String ARCHIVED_MODEL = "(//dd[@class=\"govuk-summary-list__value\"])[18]";
    private static final String TECH_REC_ONE = "//h3[contains(.,'Technical record 1')]";
    private static final String TECH_REC_TWO = "//h3[contains(.,'Technical record 2')]";
    private static final String TECH_REC_THREE = "//h3[contains(.,'Technical record 3')]";
    private static final String SELECT_TECH_REC_TWO_HYPERLINK = "(//a[contains(.,'Select technical record')])[2]";
    private static final String VIN_LABEL_ATTRIBUTE = "//dt[contains(.,'Vehicle identification number (VIN)')]";
    private static final String VRM_LABEL_ATTRIBUTE = "//dt[contains(.,' Vehicle registration mark (VRM) ')]";
    private static final String VEHICLE_TYPE_LABEL_ATTRIBUTE = "//dt[contains(.,' Vehicle type')]";
    private static final String MANUFACTURE_YEAR_LABEL_ATTRIBUTE = "//dt[contains(.,'Year of manufacture')]";
    private static final String MAKE_LABEL_ATTRIBUTE = "//dt[contains(.,'Make')]";
    private static final String MODEL_LABEL_ATTRIBUTE = "//dt[contains(.,'Model')]";


    public void validateTechRecScreen(String title) {
        findElementByXpath(SELECT_TECHNICAL_RECORD_SCREEN).isDisplayed();
        Assert.assertTrue(findElementByXpath(SELECT_TECHNICAL_RECORD_SCREEN).getText().contentEquals(title));
    }

    public void validateNullAttribute() {
        findElementByXpath(NULL_ATTRIBUTE_VALUE).isDisplayed();
        Assert.assertTrue(findElementByXpath(NULL_ATTRIBUTE_VALUE).getText().contentEquals("-"));
    }

    public void validateProvisionalTechRecord() {
        if (findElementByXpath(PROVISIONAL_MAKE).isDisplayed() && findElementByXpath(PROVISIONAL_MODEL).isDisplayed()) ;
        Assert.assertTrue(findElementByXpath(PROVISIONAL_MAKE).getText().contentEquals("MERCEDES"));
        Assert.assertTrue(findElementByXpath(PROVISIONAL_MODEL).getText().contentEquals("M200"));
    }

    public void validateCurrentTechRecord() {
        if (findElementByXpath(CURRENT_MAKE).isDisplayed() && findElementByXpath(CURRENT_MODEL).isDisplayed()) ;
        Assert.assertTrue(findElementByXpath(CURRENT_MAKE).getText().contentEquals("VOLVO"));
        Assert.assertTrue(findElementByXpath(CURRENT_MODEL).getText().contentEquals("V8"));
    }

    public void clickSecondSelectTechRecHyperlink() {
        findElementByXpath(SELECT_TECH_REC_TWO_HYPERLINK).click();
    }

    public void validateArchivedTechRecord() {
        if (findElementByXpath(ARCHIVED_MAKE).isDisplayed() && findElementByXpath(ARCHIVED_MODEL).isDisplayed()) ;
        Assert.assertTrue(findElementByXpath(ARCHIVED_MAKE).getText().contentEquals("VOLVO"));
        Assert.assertTrue(findElementByXpath(ARCHIVED_MODEL).getText().contentEquals("V8"));
    }

    public void validateEachTechRecordWithHyperlink() {

        List<WebElement> elements1 = getDriver().findElements(By.xpath(TECH_RECORD_HEADING));
        List<WebElement> elements2 = getDriver().findElements(By.xpath(SELECT_TECH_REC_HYPERLINK));
        Assert.assertEquals(elements1.size(), elements2.size());

        findElementByXpath(SELECT_TECH_REC_ONE_HYPERLINK).isDisplayed();
    }

    public void clickFirstSelectTechRecHyperlink() {
        findElementByXpath(SELECT_TECH_REC_ONE_HYPERLINK).click();
    }

    public void validateSelectedVehicleIsDisplayed() {
        techRecordPage.checkVinIsDisplayed();
    }

    public void validateTechRecordNumbering() {
        findElementByXpath(TECH_REC_ONE).getText().contentEquals("Technical record 1");
        findElementByXpath(TECH_REC_TWO).getText().contentEquals("Technical record 2");
        findElementByXpath(TECH_REC_THREE).getText().contentEquals("Technical record 3");
    }

    public void validateAttributesOfVehicle() {
        if (findElementByXpath(VIN_LABEL_ATTRIBUTE).isDisplayed() &&
                findElementByXpath(VRM_LABEL_ATTRIBUTE).isDisplayed() &&
                findElementByXpath(VEHICLE_TYPE_LABEL_ATTRIBUTE).isDisplayed() &&
                findElementByXpath(MANUFACTURE_YEAR_LABEL_ATTRIBUTE).isDisplayed() &&
                findElementByXpath(MAKE_LABEL_ATTRIBUTE).isDisplayed() &&
                findElementByXpath(MODEL_LABEL_ATTRIBUTE).isDisplayed()) {

            List<WebElement> elements = getDriver().findElements(By.xpath(TECH_RECORD_HEADING));
            List<WebElement> elements1 = getDriver().findElements(By.xpath(VIN_LABEL_ATTRIBUTE));
            List<WebElement> elements2 = getDriver().findElements(By.xpath(VRM_LABEL_ATTRIBUTE));
            List<WebElement> elements3 = getDriver().findElements(By.xpath(VEHICLE_TYPE_LABEL_ATTRIBUTE));
            List<WebElement> elements4 = getDriver().findElements(By.xpath(MANUFACTURE_YEAR_LABEL_ATTRIBUTE));
            List<WebElement> elements5 = getDriver().findElements(By.xpath(MAKE_LABEL_ATTRIBUTE));
            List<WebElement> elements6 = getDriver().findElements(By.xpath(MODEL_LABEL_ATTRIBUTE));

            Assert.assertEquals(elements.size(), elements1.size(), elements2.size());
            Assert.assertEquals(elements.size(), elements3.size(), elements4.size());
            Assert.assertEquals(elements.size(), elements5.size(), elements6.size());
        }
    }

    public void validateMakeIsAlphabeticallyOrdered() {

        List<String> actualList = new ArrayList<>();
        actualList.add(PROVISIONAL_MAKE);
        actualList.add(CURRENT_MAKE);
        actualList.add(ARCHIVED_MAKE);

        List<String> sortedList = new ArrayList<>(actualList);
        Collections.sort(sortedList);

        assertThat(actualList.equals(sortedList)).isTrue();
    }
}

