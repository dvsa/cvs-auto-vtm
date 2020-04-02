package stepDefinitions;

import net.thucydides.core.annotations.Steps;
import step.TechRecordSelectionPageSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class TechRecordSelectionPageStepDefinition {

    @Steps
    TechRecordSelectionPageSteps techRecordSelectionPageSteps;

    @Then("^the screen name should be \"([^\"]*)\"$")
    public void screenNameShouldBe(String name) {
        techRecordSelectionPageSteps.validateSelectTechRecScreenName(name);
    }

    @And("^I should see - for an attribute with null value$")
    public void nullAttributeValueShouldBe() {
        techRecordSelectionPageSteps.validateNullAttributeValue();
    }

    @And("^I should see Select technical record hyperlink against each tech record$")
    public void techRecordHyperLinkShouldBe() {
        techRecordSelectionPageSteps.validateEachTechRecordWithHyperlink();
    }

    @And("^I should see the provisional tech record$")
    public void provisionalTechRecordShouldBe() {
        techRecordSelectionPageSteps.validateProvisionalTechRecord();
    }

    @And("^I should see the current tech record$")
    public void currentTechRecordShouldBe() {
        techRecordSelectionPageSteps.validateCurrentTechRecord();
    }

    @And("^I select a different technical record$")
    public void clickSecondSelectTechRecHyperlink(){
        techRecordSelectionPageSteps.clickSecondSelectTechRecHyperlink();
    }

    @And("^I should see the latest archived tech record$")
    public void archivedTechRecordShouldBe() {
        techRecordSelectionPageSteps.validateArchivedTechRecord();
    }

    @When("^I click on Select technical record hyperlink$")
    public void clickFirstSelectTechRecHyperlink(){
        techRecordSelectionPageSteps.clickFirstSelectTechRecHyperlink();
    }

    @And("^I should see all attributes of the vehicle$")
    public void VehicleAttributesShouldBeDisplayed() {
        techRecordSelectionPageSteps.validateAttributesOfVehicle();
    }

    @Then("^I should be the selected tech record$")
    public void SelectedVehicleShouldBeDisplayed(){
        techRecordSelectionPageSteps.validateSelectedVehicleIsDisplayed();
    }

    @And("^I should see technical record is numbered$")
    public void techRecordShouldBeNumbered(){
        techRecordSelectionPageSteps.validateTechRecordNumbering();
    }

    @And("^I should see make is alphabetically ordered$")
    public void alphabeticalOrderShouldBe(){
        techRecordSelectionPageSteps.validateMakeIsAlphabeticallyOrdered();
    }
}
