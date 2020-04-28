package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/HgvTechRecordView_CVSB_10166.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)

public class HgvTechRecordView_CVSB_10166 {
}
