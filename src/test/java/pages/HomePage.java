package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends GenericPage {
    @FindBy(css = "ion-card>ion-card-content>ion-button")
    private WebElementFacade createVehicle;

    @FindBy(css = "ion-searchbar>div.searchbar-input-container>input")
    private WebElementFacade searchVinVrmInput;

    @FindBy(css = "ion-searchbar>div.searchbar-input-container>ion-icon")
    private WebElementFacade searchButton;

    public void inputVinVrm(String arg0) {
        searchVinVrmInput.shouldBeVisible();
        searchVinVrmInput.shouldBeEnabled();
        searchVinVrmInput.type(arg0);
    }

    public void searchVehicle() {
        searchButton.click();
    }

    public void createVehicle() {
        createVehicle.click();
    }
}
