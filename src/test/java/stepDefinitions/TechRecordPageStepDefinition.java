package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import step.TechRecordPageSteps;

import java.util.List;
import java.util.Map;

public class TechRecordPageStepDefinition {

    @Steps
    TechRecordPageSteps techRecordPageSteps;

    @Then("^hgv tech record fields should have values$")
    public void hgvTechRecordFieldShouldHaveValue(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i).get("Value"), techRecordPageSteps.getValueForTechRecordField(list.get(i).get("Field")));
        }
    }

    @Then("^trl tech record fields should have values$")
    public void trlTechRecordFieldShouldHaveValue(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(techRecordPageSteps.getValueForTechRecordField(list.get(i).get("Field")), list.get(i).get("Value"));
        }
    }

    @Then("^wait until I see \"([^\"]*)\"$")
    public void waitUntilISee(String arg0) throws Throwable {
        techRecordPageSteps.waitForTextToAppear(arg0);
    }

    @Then("^I open all sections$")
    public void iOpenAllSections() {
        techRecordPageSteps.openAllSections();
    }

    @Then("^I close all sections$")
    public void iCloAllSections() {
        techRecordPageSteps.closeAllSections();
    }

    @When("^I open \"([^\"]*)\" section$")
    public void iOpenSection(String arg0) throws Throwable {
        techRecordPageSteps.openSection(arg0);
    }

    @When("^I close \"([^\"]*)\" section$")
    public void iCloseSection(String arg0) throws Throwable {
        techRecordPageSteps.closeSection(arg0);
    }

    @When("^I click the change technical record button$")
    public void iClickChangeTechnicalRecordButton() {
        techRecordPageSteps.editTechRecordDetails();
    }

    @When("^I click the save technical record button$")
    public void iClickSaveTechnicalRecordButton() {
        techRecordPageSteps.saveTechRecordDetails();
    }

    @When("^I select \"([^\"]*)\" dangerous good$")
    public void iSelectDangerousGood(String arg0) throws Throwable {
        techRecordPageSteps.selectDangerousGoodCheckbox(arg0);
    }

    @When("^I deselect \"([^\"]*)\" dangerous good$")
    public void iDeselectDangerousGood(String arg0) throws Throwable {
        techRecordPageSteps.deselectDangerousGoodCheckbox(arg0);
    }

    @When("^I select \"([^\"]*)\" from tank statement$")
    public void iSelectFromTankStatement(String arg0) throws Throwable {
        techRecordPageSteps.iSelectFromTankStatement(arg0);
    }

    @Then("^I should see \"([^\"]*)\" statement field$")
    public void iShouldSeeStatementField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldSeeStatementField(arg0);
    }

    @Then("^I should not see statement fields$")
    public void iShouldNotSeeStatementFields() {
        techRecordPageSteps.iShouldNotSeeStatementFields();
    }

    @Then("^I should see \"([^\"]*)\" product list field$")
    public void iShouldSeeProductListField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldSeeProductListField(arg0);
    }

    @Then("^I should not see product list fields$")
    public void iShouldNotSeeProductListFields() {
        techRecordPageSteps.iShouldNotSeeProductListFields();
    }

    @When("^I select \"([^\"]*)\" vehicle type$")
    public void iSelectVehicleType(String arg0) throws Throwable {
        techRecordPageSteps.iSelectVehicleType(arg0);
    }

    @When("^I select \"([^\"]*)\" from battery list applicable$")
    public void iSelectFromBatteryListApplicable(String arg0) throws Throwable {
        techRecordPageSteps.iSelectFromBatteryListApplicable(arg0);
    }

    @Then("^I should see \"([^\"]*)\" battery list field$")
    public void iShouldSeeBatteryListField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldSeeBatteryListField(arg0);
    }

    @Then("^I should not see battery list fields$")
    public void iShouldNotSeeBatteryListFields() {
        techRecordPageSteps.iShouldNotSeeBatteryListFields();
    }

    @When("^I select \"([^\"]*)\" checkbox$")
    public void iSelectCheckbox(String arg0) throws Throwable {
        techRecordPageSteps.iSelectCheckbox(arg0);
    }

    @When("^I deselect \"([^\"]*)\" checkbox$")
    public void iDeselectCheckbox(String arg0) throws Throwable {
        techRecordPageSteps.iDeselectCheckbox(arg0);
    }

    @Then("^I should see \"([^\"]*)\" manufacturer brake declaration field$")
    public void iShouldSeeManufacturerBrakeDeclarationField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldSeeManufacturerBrakeDeclarationField(arg0);
    }

    @Then("^I should not see \"([^\"]*)\" manufacturer brake declaration field$")
    public void iShouldNotSeeManufacturerBrakeDeclarationField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldNotSeeManufacturerBrakeDeclarationField(arg0);
    }

    @Then("^I should see \"([^\"]*)\" brake endurance field$")
    public void iShouldSeeBrakeEnduranceField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldSeeBrakeEndurance(arg0);
    }

    @Then("^I should not see \"([^\"]*)\" brake endurance field$")
    public void iShouldNotSeeBrakeEnduranceField(String arg0) throws Throwable {
        techRecordPageSteps.iShouldNotSeeBrakeEndurance(arg0);
    }
}
