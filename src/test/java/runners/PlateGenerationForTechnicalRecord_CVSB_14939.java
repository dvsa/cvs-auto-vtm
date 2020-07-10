package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json", "pretty"},
        features = "src/test/resources/features/PlateGenerationForTechnicalRecord_CVSB_14939.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)

public class PlateGenerationForTechnicalRecord_CVSB_14939 {
}
