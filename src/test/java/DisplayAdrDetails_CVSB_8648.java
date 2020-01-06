import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/DisplayAdrDetails_CVSB_8648.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class DisplayAdrDetails_CVSB_8648 {

}