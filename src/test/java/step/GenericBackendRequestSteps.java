package step;

import net.thucydides.core.annotations.Step;
import pages.GenericBackendRequestPage;

public class GenericBackendRequestSteps {

    GenericBackendRequestPage genericBackendRequestPage;

    @Step
    public void createVehicle(String vehicleType, String withOrWithout) {
        genericBackendRequestPage.goToAuthTokenUrl();
        genericBackendRequestPage.createVehicle(vehicleType, withOrWithout);
    }

    @Step
    public String getNewVehicleAttribute(String attribute) {
        return genericBackendRequestPage.getNewVehicleAttribute(attribute);
    }
}
