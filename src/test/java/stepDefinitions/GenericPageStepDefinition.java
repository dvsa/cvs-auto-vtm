package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericPageSteps;

public class GenericPageStepDefinition {

    @Steps
    GenericPageSteps genericPageSteps;

    @After
    @When("^I clear the browser session$")
    public void clearSession() {
        genericPageSteps.clearSession();
    }

    @When("^I wait until page is loaded$")
    public void iWaitUntilPageIsLoaded() {
        genericPageSteps.waitForPageToLoad();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSeeText(String text) {
        genericPageSteps.checkTextIsPresentInPage(text);
    }

    @Then("^I should not see \"([^\"]*)\"$")
    public void iShouldNotSeeText(String text) {
        genericPageSteps.checkTextIsNotPresentInPage(text);
    }

    @Then("^I wait (\\d+) seconds$")
    public void iWaitSeconds(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^element with id \"([^\"]*)\" should be present$")
    public void elementWithIdShouldBePresent(String id) {
        genericPageSteps.elementWithIdShouldBePresent(id);
    }

    @When("^I navigate away from vtm app and then go back to vtm")
    public void iNavigateAwayFromVtmAndGoBack() {
        genericPageSteps.navigateAwayFromVtmAndGoBack();
    }

    @When("^I clear session storage$")
    public void iClearSessionStorage() {
        genericPageSteps.clearSessionStorage();
    }

    @When("^refresh the page$")
    public void refreshThePage() {
        genericPageSteps.refreshPage();
    }

    @Then("^wait until I see \"([^\"]*)\"$")
    public void waitUntilISee(String text) {
        genericPageSteps.waitForTextToAppear(text);
    }

    @Then("^I should see \"([^\"]*)\" hyperlink$")
    public void iShouldSeeHyperlink(String text) {
        genericPageSteps.checkTextIsPresentInHyperlink(text);
    }

    @When("^I go back to search page$")
    public void iGoBackToSearchPage() {
        genericPageSteps.goBackToSearchPage();
    }
}
