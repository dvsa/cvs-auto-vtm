package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json", "pretty"},
        features = "src/test/resources/features/EditTestRecord_CVSB_10278.feature",
        glue = {"stepDefinitions"},
        tags = {"@smoke"}
)
public class EditTestRecord_CVSB_10278 {

}
