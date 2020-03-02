package pages;

public class HomePage extends GenericPage {

    private static final String SEARCH_FOR_TECHNICAL_RECORD_LINK = "#test-create-new-vehicle";
    private static final String CREATE_TECHNICAL_RECORD_LINK = "#test-search-vehicle";
    private static String homePageUrl = null;

    public void goToSearchTechRecordPage() {
        findElementByCss(SEARCH_FOR_TECHNICAL_RECORD_LINK).click();
    };

    public void goToCreateTechRecordPage() {
        findElementByCss(SEARCH_FOR_TECHNICAL_RECORD_LINK).click();
    };
}
