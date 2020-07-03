package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json", "pretty"},
        features = "src/test/resources/features/HgvTechRecordCreate_CVSB_10202.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class HgvTechRecordCreate_CVSB_10202 {

}
