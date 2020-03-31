package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/AdrDetailsAttachDocuments_CVSB_10086.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class AdrDetailsAttachDocuments_CVSB_10086 {
}
