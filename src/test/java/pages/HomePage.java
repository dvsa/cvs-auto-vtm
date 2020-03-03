package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends GenericPage {

    private static final String SEARCH_FOR_TECHNICAL_RECORD_LINK = "#test-create-new-vehicle";
    private static final String CREATE_TECHNICAL_RECORD_LINK = "#test-search-vehicle";
    private static final String SEARCH_FOR_TECHNICAL_RECORD_LINK_TITLE = "Search for a technical record";
    private static final String SEARCH_FOR_TECHNICAL_RECORD_LINK_DESCRIPTION = "Manage technical records, test records " +
            "and issue certificates or documents";
    private static final String CREATE_TECHNICAL_RECORD_LINK_TITLE = "Create a new technical record";
    private static final String CREATE_TECHNICAL_RECORD_LINK_DESCRIPTION = "Create records for PSVs, HGVs and trailers";

    public void goToSearchTechRecordPage() {
        findElementByCss(SEARCH_FOR_TECHNICAL_RECORD_LINK).click();
    };

    public void goToCreateTechRecordPage() {
        findElementByCss(CREATE_TECHNICAL_RECORD_LINK).click();
    };

    public void hyperlinkDescriptionIsCorrect(String hyperlinkTitle) {
        if (hyperlinkTitle.equals(SEARCH_FOR_TECHNICAL_RECORD_LINK_TITLE)) {
            Assert.assertNotNull("Hyperlink description is incorrect!",
                    getDriver().findElement(By.xpath("//a[text() = '" + hyperlinkTitle + "']/../../" +
                            "p[text() = '" + SEARCH_FOR_TECHNICAL_RECORD_LINK_DESCRIPTION + "']")));
        }
        else if (hyperlinkTitle.equals(CREATE_TECHNICAL_RECORD_LINK_TITLE)) {
            Assert.assertNotNull("Hyperlink description is incorrect!",
                    getDriver().findElement(By.xpath("//a[text() = '" + hyperlinkTitle + "']/../../" +
                            "p[text() = '" + CREATE_TECHNICAL_RECORD_LINK_DESCRIPTION + "']")));
        }
    }
}
