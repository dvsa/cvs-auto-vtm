package pages;

import exceptions.AutomationException;
import org.junit.Assert;

public class Footer extends GenericPage {

    private static final String FOOTER = "vtm-footer";
    private static final String COPYWRIGHT_LOGO = "a.govuk-footer__copyright-logo";
    private static final String OGL_LOGO = "svg.govuk-footer__licence-logo";


    public void checkTextInFooter(String text) {
        Assert.assertTrue(findElementByCss(FOOTER).getText().contains(text));
    }

    public void checkFooterLogo(String logoType) {
        String logo = logoType.toLowerCase();
        switch (logo) {
            case "copyright":
                Assert.assertNotNull(findElementByCss(COPYWRIGHT_LOGO));
                break;
            case "ogl":
                Assert.assertNotNull(findElementByCss(OGL_LOGO));
                break;
            default:  // should be unreachable!
                throw new AutomationException(
                        "Non existent logo type");
        }

    }
}
