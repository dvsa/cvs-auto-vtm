import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/TechRecordView_CVSB_7239.feature",
        glue = {"stepDefinitions"},
        tags = {"not @skip"}
)
public class TechRecordView_CVSB_7239 {

}