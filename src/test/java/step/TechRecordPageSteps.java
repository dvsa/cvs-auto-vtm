package step;

import net.thucydides.core.annotations.Step;
import pages.TechRecordPage;

public class TechRecordPageSteps {

    TechRecordPage techRecordPage;

    @Step
    public String getValueForTechRecordField(String field) {
        return techRecordPage.getValueForTechRecordField(field);
    }

    @Step
    public void waitForTextToAppear(String arg0) {
        techRecordPage.waitForTextToAppear(arg0, 20);
    }

    @Step
    public void openAllSections() {
        techRecordPage.openAllSections();
    }

    @Step
    public void closeAllSections() {
        techRecordPage.closeAllSections();
    }

    @Step
    public void openSection(String arg0) {
        techRecordPage.openSection(arg0);
    }

    @Step
    public void closeSection(String arg0) {
        techRecordPage.closeSection(arg0);
    }
}
