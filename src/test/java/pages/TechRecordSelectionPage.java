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

    private static final String SELECT_TECHNICAL_RECORD_SCREEN = "h1";

    public void validateTechRecScreen(String title) {
        findElementByCss(SELECT_TECHNICAL_RECORD_SCREEN).isDisplayed();
        Assert.assertTrue("Text in element with css selector '" + SELECT_TECHNICAL_RECORD_SCREEN + "' is "
                        + findElementByCss(SELECT_TECHNICAL_RECORD_SCREEN).getText() + "and it does not contain " + title,
                findElementByCss(SELECT_TECHNICAL_RECORD_SCREEN).getText().contentEquals(title));
    }

    public void techRecordsAlphabeticallyOrderedByMake() {

        List<String> actualList = new ArrayList<>();

        List<WebElement> makes = getDriver().findElements(By.cssSelector("[id^=test-make]"));
        for (WebElement make : makes) {
            actualList.add(make.getText());
        }

        List<String> sortedList = new ArrayList<>(actualList);
        Collections.sort(sortedList);

        assertThat(actualList.equals(sortedList)).isTrue();
    }

    public void clickOnHyperlinkForTechnicalRecordWithIndex(int index) {
        int actualIndex = index -1;
        WebElement link = findElementByCss("#test-selectTechnicalRecord-" + actualIndex);
        link.click();
    }

    public void checkHeadingForEachTechRecord() {
        List<WebElement> headings = getDriver().findElements(By.cssSelector("body h3.govuk-heading-m"));
        for (int i = 0; i< headings.size(); i++) {
            int actualIndex = i + 1;
            Assert.assertEquals("Actual heading text '" + headings.get(i).getText() + "' differs from expected value 'Technical record " + actualIndex + "'",
                    "Technical record " + actualIndex, headings.get(i).getText());
        }
    }
}

