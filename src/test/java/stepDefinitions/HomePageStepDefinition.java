package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.HomePageSteps;

public class HomePageStepDefinition {

    @Steps
    HomePageSteps homePageSteps;

    @When("^I search for vehicle with identifier \"([^\"]*)\"$")
    public void iSearchForVehicleWithIdentifier(String arg0) throws Throwable {
        homePageSteps.inputVehicleIdentifier(arg0);
        homePageSteps.searchVehicle();
    }

    @When("^I wait until page is loaded$")
    public void iWaitUntilPageIsLoaded() throws Throwable {
        homePageSteps.waitForPageToLoad();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSeeText(String arg0) throws Throwable {
        homePageSteps.checkTextIsPresentInPage(arg0);
    }

    @Then("^I should not see \"([^\"]*)\"$")
    public void iShouldNotSeeText(String arg0) throws Throwable {
        homePageSteps.checkTextIsNotPresentInPage(arg0);
    }

    @Then("^I wait (\\d+) seconds$")
    public void iWaitSeconds(int arg0) {
        try {
            Thread.sleep(arg0*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
