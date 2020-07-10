package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/SeatbeltInstallationCheckSection_CVSB_15040.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class SeatbeltInstallationCheckSection_CVSB_15040 {

}
