import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/AdrDetailsArrayAppending_CVSB_10081.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class AdrDetailsArrayAppending_CVSB_10081 {

}
