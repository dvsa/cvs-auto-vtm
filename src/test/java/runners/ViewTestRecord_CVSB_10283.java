package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/ViewTestRecord_CVSB_10283.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class ViewTestRecord_CVSB_10283 {

}
