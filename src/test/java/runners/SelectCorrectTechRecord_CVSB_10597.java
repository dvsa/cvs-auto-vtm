package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/SelectCorrectTechRecord_CVSB_10597.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class SelectCorrectTechRecord_CVSB_10597 {
}
