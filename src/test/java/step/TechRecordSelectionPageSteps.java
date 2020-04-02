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
    public void validateNullAttributeValue() {
        techRecordSelectionPage.validateNullAttribute();
    }

    @Step
    public void validateEachTechRecordWithHyperlink() {
        techRecordSelectionPage.validateEachTechRecordWithHyperlink();
    }
    @Step
    public void validateProvisionalTechRecord() {
        techRecordSelectionPage.validateProvisionalTechRecord();
    }

    @Step
    public void clickSecondSelectTechRecHyperlink() {
        techRecordSelectionPage.clickSecondSelectTechRecHyperlink();
    }

    @Step
    public void validateCurrentTechRecord() {
        techRecordSelectionPage.validateCurrentTechRecord();
    }

    @Step
    public void validateArchivedTechRecord() {
        techRecordSelectionPage.validateArchivedTechRecord();
    }

    @Step
    public void clickFirstSelectTechRecHyperlink() {
        techRecordSelectionPage.clickFirstSelectTechRecHyperlink();
    }

    @Step
    public void validateAttributesOfVehicle() {
        techRecordSelectionPage.validateAttributesOfVehicle();
    }

    @Step
    public void validateSelectedVehicleIsDisplayed() {
        techRecordSelectionPage.validateSelectedVehicleIsDisplayed();
    }

    @Step
    public void validateTechRecordNumbering() {
        techRecordSelectionPage.validateTechRecordNumbering();
    }

    @Step
    public void validateMakeIsAlphabeticallyOrdered() {
        techRecordSelectionPage.validateMakeIsAlphabeticallyOrdered();
    }
}

