package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class LoginPage extends GenericPage {

    private static final String EMAIL_INPUT = "input[type='email']";
    private static final String NEXT_SCREEN = "input[type='submit']";
    private static final String PASSWORD_INPUT = "input[type='password']";
    private static final String SIGN_IN = "input[type='submit']";
    private static final String HEADER = "div[role='heading']";
    private static final String OPTIONS = "#idA_PWD_SwitchToCredPicker";

    public void inputEmail(String emailAddress) {
        getDriver().manage().window().maximize();
        FluentWait wait = globalFluentWait(10, 250);
        wait.until(ExpectedConditions.textToBePresentInElement(findElementByCss(OPTIONS), "Sign-in option"));
        wait.until(ExpectedConditions.visibilityOf(findElementByCss(EMAIL_INPUT)));
        findElementByCss(EMAIL_INPUT).sendKeys(emailAddress);
    }

    public void goToPasswordScreen(){
        findElementByCss(NEXT_SCREEN).click();
    }

    public void inputPassword(String password) {
        FluentWait wait = globalFluentWait(10, 250);
//        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(findElementByCss(HEADER))));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(HEADER), "Enter password"));
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(findElementByCss(PASSWORD_INPUT))));
        wait.until(ExpectedConditions.visibilityOf(findElementByCss(PASSWORD_INPUT)));
        findElementByCss(PASSWORD_INPUT).sendKeys(password);
    }

    public void signIn() {
        FluentWait wait = globalFluentWait(10, 250);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SIGN_IN)));
        findElementByCss(SIGN_IN).click();
    }

    public void additionalSignIn() {
        FluentWait wait = globalFluentWait(10, 250);
        wait.until(ExpectedConditions.textToBePresentInElement(findElementByCss(HEADER), "Stay signed in?"));
        wait.until(ExpectedConditions.elementToBeClickable(findElementByCss(SIGN_IN)));
        findElementByCss(SIGN_IN).click();
    }
}
