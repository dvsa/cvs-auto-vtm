package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(css = "#idA_PWD_SwitchToCredPicker")
    private WebElementFacade options;

    @FindBy(css = "#loginHeader")
    private WebElementFacade loginHeader;

    public void inputEmail(String emailAddress) {
        getDriver().manage().window().maximize();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElement(options, "Sign-in option"));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.type(emailAddress);
    }

    public void goToPasswordScreen(){
        nextScreen.click();
    }

    public void inputPassword(String password) {
        new WebDriverWait(getDriver(), 10)
                .pollingEvery(Duration.ofMillis(250))
                .until(ExpectedConditions.textToBePresentInElement(header, "Enter password"));
        new WebDriverWait(getDriver(), 5)
                .pollingEvery(Duration.ofMillis(250))
                .until(ExpectedConditions.not(ExpectedConditions.stalenessOf(passwordInput)));
        new WebDriverWait(getDriver(), 10)
                .pollingEvery(Duration.ofMillis(250))
                .until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.type(password);
    }

    public void signIn() {
        signIn.shouldBeEnabled();
        signIn.click();
    }

    public void additionalSignIn() {
        waitForTextToAppear(header, "Stay signed in?");
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(signIn));
        signIn.click();
    }
}
