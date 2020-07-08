package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/ViewSpecialistTestRecord_CVSB_10362.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class ViewSpecialistTestRecord_CVSB_10362 {

}
