package step;

import net.thucydides.core.annotations.Step;
import pages.Header;

public class HeaderSteps extends GenericPageSteps {

    Header header;

    @Step
    public void signOutFromVtmApp() {
        header.signOutFromVtmApp();
    }

    @Step
    public void goBackToHomePage() {
        header.goBackToHomePage();
    }

    @Step
    public void validateHeaderTitle(String title) {
        header.validateHeaderTitle(title);
    }

    @Step
    public void checkAdminUserNameInHeader() {
        header.checkAdminUserNameInHeader();
    }

    @Step
    public void checkTextInHeader(String text) {
        header.checkTextInHeader(text);
    }
}
