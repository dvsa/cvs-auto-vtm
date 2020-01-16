package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.LoginPageSteps;

public class LoginPageStepDefinition {

    @Steps
    LoginPageSteps loginPageSteps;

    @After
    @When("^I clear the browser session$")
    public void clearSession() {
        loginPageSteps.clearSession();
    }

    @Given("^I login with admin credentials$")
    public void iLoginWithAdminCredentials() {
        loginPageSteps.iLoginWithAdminEmailAndPassword();
    }
}
