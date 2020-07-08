package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/HgvTechRecordUpdate_CVSB_10235.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class HgvTechRecordUpdate_CVSB_10235 {

}
