package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/SearchVehicleBeforeCreation_CVSB_10139.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class SearchVehicleBeforeCreation_CVSB_10139 {

}