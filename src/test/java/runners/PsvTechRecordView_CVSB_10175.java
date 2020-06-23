package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/PsvTechRecordView_CVSB_10175.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)

public class PsvTechRecordView_CVSB_10175 {
}
