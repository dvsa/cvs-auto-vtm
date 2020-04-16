package stepDefinitions;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericBackendRequestSteps;

public class GenericBackendRequestStepDefinition {

    @Steps
    GenericBackendRequestSteps genericBackendRequestSteps;

    @When("^I create \"([^\"]*)\" vehicle ([^\"]*) adr details$")
    public void getAuthenticationToken(String vehicleType, String withOrWithout) {
        genericBackendRequestSteps.createVehicle(vehicleType, withOrWithout);
    }
}
