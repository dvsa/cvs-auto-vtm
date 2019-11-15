package step;

import net.thucydides.core.annotations.Step;
import pages.LoginPage;

public class LoginSteps {
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

    public void clearSession() {
        loginPage.clearSession();
    }
}