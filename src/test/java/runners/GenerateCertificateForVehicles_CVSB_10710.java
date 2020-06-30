package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json", "pretty"},
        features = "src/test/resources/features/GenerateCertificateForVehicles_CVSB_10710.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class GenerateCertificateForVehicles_CVSB_10710 {
}
