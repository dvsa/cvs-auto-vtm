package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.LoginPageSteps;

public class LoginPageStepDefinition {

    @Steps
    LoginPageSteps loginPageSteps;

    @After
    public void clearSession() {

        loginPageSteps.clearSession();
    }

    @Given("^I am on the loginPage$")
    public void iOpenTheLoginPage(){
        loginPageSteps.iOpenTheLoginPage();
    }

    @When("^I input email \"([^\"]*)\"$")
    public void iInputEmail(String arg0) throws Throwable {
        loginPageSteps.inputEmail(arg0);
    }

    @When("^I go to password screen$")
    public void iGoToPasswordScreen() throws Throwable {
        loginPageSteps.goToPasswordScreen();
    }

    @When("^I input password \"([^\"]*)\"$")
    public void iInputPassword(String arg0) throws Throwable {
        loginPageSteps.inputPassword(arg0);
    }

    @When("^I sign in$")
    public void iSignIn() throws Throwable {
        loginPageSteps.signIn();
    }

    @Then("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithEmailAndPassword(String arg0, String arg1) throws Throwable {
        loginPageSteps.iLoginWithEmailAndPassword(arg0, arg1);
    }

    @Given("^I login with admin credentials$")
    public void iLoginWithAdminCredentials() {
        loginPageSteps.iLoginWithAdminEmailAndPassword();
    }
}
