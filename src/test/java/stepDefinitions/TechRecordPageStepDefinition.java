package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import step.TechRecordPageSteps;

import java.util.List;
import java.util.Map;

public class TechRecordPageStepDefinition {

    @Steps
    TechRecordPageSteps techRecordPageSteps;

    @Then("^hgv tech record field should have value$")
    public void hgvTechRecordFieldShouldHaveValue(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i).get("Value"), techRecordPageSteps.getValueForTechRecordField(list.get(i).get("Field")));
        }
    }

    @Then("^trl tech record field should have value$")
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

    @Then("^I should open all sections$")
    public void iShouldAllSections() {
        techRecordPageSteps.openAllSections();
    }
}
