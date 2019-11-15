package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TechRecordPage extends GenericPage {

    @FindBy(css = "ion-searchbar>div.searchbar-input-container>input")
    private WebElementFacade searchInput;

    @FindBy(css = "ion-searchbar>div.searchbar-input-container>ion-icon")
    private WebElementFacade searchButton;

    @FindBy(css = "div.open-close-all a")
    private WebElementFacade openCloseAll;

    public void inputVehicleIdentifier(String arg0) {
        searchInput.shouldBeVisible();
        searchInput.shouldBeEnabled();
        searchInput.type(arg0);
    }

    public void searchVehicle() {
        searchButton.click();
    }

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
        waitForTextToAppear("Open all");
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(openCloseAll)));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(openCloseAll));
        openCloseAll.click();
        waitForTextToAppear("Vehicle type");
    }
}