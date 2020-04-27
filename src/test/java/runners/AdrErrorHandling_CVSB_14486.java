package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/AdrErrorHandling_CVSB_14486.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class AdrErrorHandling_CVSB_14486 {

}