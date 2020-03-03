package step;

import net.thucydides.core.annotations.Step;
import pages.Header;

public class HeaderSteps extends GenericPageSteps {

    Header header;

    @Step
    public void logoutFromVtmApp() {
        header.logoutFromVtmApp();
    }

    @Step
    public void goBackToHomePage() {
        header.clickHeaderLink();
    }
}
