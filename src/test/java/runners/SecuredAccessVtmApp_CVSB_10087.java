package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/SecuredAccessVtmApp_CVSB_10087.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class SecuredAccessVtmApp_CVSB_10087 {

}