package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.HeaderSteps;

public class HeaderStepDefinition {

    @Steps
    HeaderSteps headerSteps;

    @When("^I sign out from vtm app$")
    public void iSignOutFromVtmApp() {
        headerSteps.signOutFromVtmApp();

    }

    @When("^I go back to home page$")
    public void iGoBackToHomePage() {
        headerSteps.goBackToHomePage();
    }

    @Then("^the header title should be \"([^\"]*)\"$")
    public void headerTitleShouldBe(String title) {
        headerSteps.validateHeaderTitle(title);
    }

    @Then("^the header should contain user name \"([^\"]*)\"$")
    public void theHeaderShouldContainUserName(String name) {
        headerSteps.checkUserNameInHeader(name);

    }

    @Then("^the header should contain \"([^\"]*)\"$")
    public void headerShouldContain(String text) {
        headerSteps.checkTextInHeader(text);
    }
}
