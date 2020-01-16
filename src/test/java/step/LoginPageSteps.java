package step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.exec.environment.EnvironmentUtils;
import pages.LoginPage;
import util.TypeLoader;

import java.util.Objects;
import java.util.Properties;

public class LoginPageSteps {

    LoginPage loginPage;

    @Step
    public void clearSession() {
        loginPage.clearSession();
    }

    @Step
    public void iLoginWithAdminEmailAndPassword() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        Properties properties = null;
        String username = "";
        String password = "";
        if (variables.getProperty("webdriver.driver")!="provided") {
            String FILE_PATH = "conf/environment.properties";

            try {
                properties = new Properties();
                properties.load(Objects.requireNonNull(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH)));

            } catch (Exception e) {
            }
            username = properties.getProperty("app.username");
            password = properties.getProperty("app.password");
        }
        else {
            username = TypeLoader.getAppUsername();
            password = TypeLoader.getAppPassword();
        }

        loginPage.open();
        loginPage.inputEmail(username);
        loginPage.goToPasswordScreen();
        loginPage.inputPassword(password);
        loginPage.signIn();
        loginPage.additionalSignIn();
    }
}
