package stepDefinitions;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.HeaderSteps;

public class HeaderStepDefinition {

    @Steps
    HeaderSteps headerSteps;

    @When("^I logout from vtm app$")
    public void iLogoutFromVtmApp() {
        headerSteps.logoutFromVtmApp();

    }

    @When("^I go back to home page$")
    public void iGoBackToHomehPage() {
        headerSteps.goBackToHomePage();
    }
}
