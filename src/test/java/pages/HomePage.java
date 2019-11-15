package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends GenericPage {

    private static final String SEARCH_INPUT = ".sc-ion-searchbar-md-h";

    public void inputVehicleIdentifier(String arg0) {
//        searchVinVrmInput.shouldBeVisible();
//        searchVinVrmInput.shouldBeEnabled();
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(SEARCH_INPUT)));
        findElementByCss(SEARCH_INPUT).sendKeys(arg0);
    }

    public void searchVehicle() {
        findElementByCss(SEARCH_INPUT).sendKeys(Keys.ENTER);
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                textToBePresentInElement(getDriver().findElement(By.cssSelector(".grid-container-technical-record-status")), "Status"));
    }
}
