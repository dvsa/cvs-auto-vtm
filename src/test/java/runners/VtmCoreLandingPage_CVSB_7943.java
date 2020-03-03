package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/VtmCoreLandingPage_CVSB_7943.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class VtmCoreLandingPage_CVSB_7943 {

}