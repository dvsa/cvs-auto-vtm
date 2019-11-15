package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.LoginSteps;

public class LoginStepDefinition {
    @Steps
    LoginSteps loginSteps;

    @After
    public void clearSession() {
        loginSteps.clearSession();
    }

    @Given("^I am on the loginPage$")
    public void iOpenTheLoginPage(){
        loginSteps.iOpenTheLoginPage();
    }

    @When("^I input email \"([^\"]*)\"$")
    public void iInputEmail(String arg0) throws Throwable {
        loginSteps.inputEmail(arg0);
    }

    @When("^I go to password screen$")
    public void iGoToPasswordScreen() throws Throwable {
        loginSteps.goToPasswordScreen();
    }

    @When("^I input password \"([^\"]*)\"$")
    public void iInputPassword(String arg0) throws Throwable {
        loginSteps.inputPassword(arg0);
    }

    @When("^I sign in$")
    public void iSignIn() throws Throwable {
        loginSteps.signIn();
    }
}