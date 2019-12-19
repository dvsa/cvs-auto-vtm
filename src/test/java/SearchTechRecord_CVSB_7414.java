import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/SearchTechRecord_CVSB_7414.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class SearchTechRecord_CVSB_7414 {

}