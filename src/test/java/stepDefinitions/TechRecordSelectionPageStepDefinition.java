package stepDefinitions;

import cucumber.api.PendingException;
import net.thucydides.core.annotations.Steps;
import step.TechRecordSelectionPageSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class TechRecordSelectionPageStepDefinition {

    @Steps
    TechRecordSelectionPageSteps techRecordSelectionPageSteps;

    @Then("^the screen name should be \"([^\"]*)\"$")
    public void screenNameShouldBe(String name) {
        techRecordSelectionPageSteps.validateSelectTechRecScreenName(name);
    }


    @Then("^technical records are alphabetically ordered by make$")
    public void techRecordsAlphabeticallyOrderedByMake(){
        techRecordSelectionPageSteps.techRecordsAlphabeticallyOrderedByMake();
    }

    @When("^I click link to select technical record with index (\\d+)$")
    public void clickLinkSelectTechnicalRecordWithIndex(int index) {
        techRecordSelectionPageSteps.clickOnHyperlinkForTechnicalRecordWithIndex(index);
    }

    @Then("^I should see correct heading for each tech record$")
    public void shouldSeeCorrectHeadingForEachTechRecord() {
        techRecordSelectionPageSteps.checkHeadingForEachTechRecord();
    }
}
