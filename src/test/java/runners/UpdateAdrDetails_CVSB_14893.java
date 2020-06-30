package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/UpdateAdrDetails_CVSB_14893.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class UpdateAdrDetails_CVSB_14893 {

}
