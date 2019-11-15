package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends GenericPage {
    @FindBy(css = "input[type='email']")
    private WebElementFacade emailInput;

    @FindBy(css = "input[type='submit']")
    private WebElementFacade nextScreen;

    @FindBy(css = "input[type='password']")
    private WebElementFacade passwordInput;

    @FindBy(css = "input[type='submit']")
    private WebElementFacade signIn;

    @FindBy(css = "div[role='heading']")
    private WebElementFacade header;

    @FindBy(css = "#loginHeader")
    private WebElementFacade loginHeader;

    public void inputEmail(String arg0){
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElement(header, "Sign in"));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.type(arg0);
    }

    public void goToPasswordScreen(){
        nextScreen.click();
    }

    public void inputPassword(String arg0){

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElement(header, "Enter password"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(passwordInput)));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.type(arg0);
    }

    public void signIn(){
        signIn.shouldBeEnabled();
        signIn.click();
    }

    public void additionalSignIn() {
        waitForTextToAppear(header, "Stay signed in?");
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(signIn));
        signIn.click();
    }
}
