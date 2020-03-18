
package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/SearchVehicleVinUnderNineCharacters_CVSB_11329.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class SearchVehicleVinUnderNineCharacters_CVSB_11329 {

}