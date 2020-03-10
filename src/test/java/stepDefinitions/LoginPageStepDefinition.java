package stepDefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import step.LoginPageSteps;

public class LoginPageStepDefinition {

    @Steps
    LoginPageSteps loginPageSteps;

    @Given("^I login with admin credentials$")
    public void iLoginWithAdminCredentials() {
        loginPageSteps.iLoginWithAdminEmailAndPassword();
    }
}
