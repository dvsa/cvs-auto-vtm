package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.ComparisonFailure;
import step.GenericPageSteps;

import java.util.List;
import java.util.Map;

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

    @Then("^I should see \"(.*)\"$")
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
            Thread.sleep(seconds * 1000);
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
        genericPageSteps.checkTextIsPresentInPage(text);
    }

    @Then("^I should see \"([^\"]*)\" hyperlink$")
    public void iShouldSeeHyperlink(String text) {
        genericPageSteps.checkTextIsPresentInHyperlink(text);
    }

    @Then("^I should see \"([^\"]*)\" hyperlink in change test type modal$")
    public void iShouldSeeHyperlinkInChangeTestTypeModal(String text) {
        genericPageSteps.checkTextIsPresentInHyperlinkInElement(text, "vtm-dialog-box-confirmation");
    }

    @When("^I go back to search page$")
    public void iGoBackToSearchPage() {
        genericPageSteps.goBackToSearchPage();
    }

    @Then("^I should see \"([^\"]*)\" button$")
    public void iShouldSeeButton(String text) {
        genericPageSteps.checkTextIsPresentInButton(text);
    }

    @When("^I click \"([^\"]*)\" link$")
    public void iClickLink(String text) {
        genericPageSteps.clickLink(text);
    }

    @When("^I click \"([^\"]*)\" link in change test type modal$")
    public void iClickLinkInChangeTestTypeModal(String text) {
        genericPageSteps.clickLinkInElement(text, "vtm-dialog-box-confirmation");
    }

    @Then("^the header error contains \"([^\"]*)\"$")
    public void headerErrorContains(String text) {
        genericPageSteps.headerErrorContains(text);
    }

    @Then("^the header error does not contain \"([^\"]*)\"$")
    public void headerErrorDoesNotContain(String text) {
        genericPageSteps.headerErrorNotContains(text);
    }

    @When("^I click \"([^\"]*)\" button$")
    public void iClickButton(String text) {
        genericPageSteps.clickButton(text);
    }

    @When("^I go back to previous page$")
    public void iGoBackToPreviousPage() {
        genericPageSteps.goBackToPreviousPage();
    }

    @Then("^I am taken to \"([^\"]*)\"$")
    public void iAmTakenTo(String url) {
        genericPageSteps.checkPageUrl(url);
    }

    @Then("^I should no longer see the sign out confirmation screen$")
    public void iShouldNoLongerSeeTheSignOutConfirmationScreen() {
        genericPageSteps.checkSignOutScreenNotPresent();
    }

    @Then("^I should see$")
    public void iShouldSee(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericPageSteps.checkTextIsPresentInPage(stringMap.get("Text"));
        }
    }

    @Then("^I should not see$")
    public void iShouldNotSee(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericPageSteps.checkTextIsNotPresentInPage(stringMap.get("Text"));
        }
    }

    @When("^I set values for fields$")
    public void iSetValuesForFields(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericPageSteps.setValueForField(stringMap.get("Field"), stringMap.get("Value"));
        }
    }

    @When("^I check values for fields$")
    public void iSetValuesForTechRecordFields(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericPageSteps.checkValueForField(stringMap.get("Field"), stringMap.get("Value"));
        }
    }

    @Then("^fields should be editable$")
    public void techRecordFieldsShouldBeEditable(DataTable dt) throws ComparisonFailure {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericPageSteps.checkFieldEditable(stringMap.get("Field"));
        }
    }
}
