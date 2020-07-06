package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/NavigateAwayWarningModal_CVSB_10184.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class NavigateAwayWarningModal_CVSB_10184 {
}