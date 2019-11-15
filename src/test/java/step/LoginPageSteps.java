package step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.exec.environment.EnvironmentUtils;
import pages.LoginPage;
import util.TypeLoader;

import java.util.Properties;

public class LoginPageSteps {

    LoginPage loginPage;

    @Step
    public void iOpenTheLoginPage(){
        loginPage.open();
    }

    @Step
    public void inputEmail(String arg0) {
        loginPage.inputEmail(arg0);
    }

    @Step
    public void goToPasswordScreen() {
        loginPage.goToPasswordScreen();
    }

    @Step
    public void inputPassword(String arg0) {
        loginPage.inputPassword(arg0);
    }

    @Step
    public void signIn() {
        loginPage.signIn();
        loginPage.additionalSignIn();
    }

    @Step
    public void clearSession() {
        loginPage.clearSession();
    }

    @Step
    public void iLoginWithEmailAndPassword(String arg0, String arg1) {
        loginPage.open();
        loginPage.inputEmail(arg0);
        loginPage.goToPasswordScreen();
        loginPage.inputPassword(arg1);
        loginPage.signIn();
        loginPage.additionalSignIn();
    }

    public void iLoginWithAdminEmailAndPassword() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        Properties properties = null;
        String username = "";
        String password = "";
        if (variables.getProperty("webdriver.driver")!="provided") {
            String FILE_PATH = "conf/environment.properties";

            try {
                properties = new Properties();
                properties.load(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH));

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
