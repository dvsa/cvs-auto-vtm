package step;

import net.thucydides.core.annotations.Step;
import pages.TechRecordSelectionPage;

public class TechRecordSelectionPageSteps {

    TechRecordSelectionPage techRecordSelectionPage;

    @Step
    public void validateSelectTechRecScreenName(String name) {
        techRecordSelectionPage.validateTechRecScreen(name);
    }

    @Step
    public void techRecordsAlphabeticallyOrderedByMake() {
        techRecordSelectionPage.techRecordsAlphabeticallyOrderedByMake();
    }

    @Step
    public void clickOnHyperlinkForTechnicalRecordWithIndex(int index) {
        techRecordSelectionPage.clickOnHyperlinkForTechnicalRecordWithIndex(index);
    }

    @Step
    public void checkHeadingForEachTechRecord() {
        techRecordSelectionPage.checkHeadingForEachTechRecord();
    }
}

