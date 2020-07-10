Feature: As the DVSA, we want the ability to remove subsequent inspections from the ADR record,in case they are incorrectly added -
  CVSB-14893

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "hgv" vehicle with adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present

  Scenario: Check Remove Subsequent inspections on ADR Update Screen screen works as expected
  AC1 - "ADR UPDATE Screen": Multiple inspections are separated, and there is a call to action to 'Remove' a subsequent inspection
  AC2 - "ADR UPDATE Screen": User clicks the call to action to 'Remove' a subsequent inspection
    #AC1
    When I search for previously created vehicle
    Then I should see "Technical record"
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    When I open tech record "ADR" section
    And I add subsequent inspection of type "Exceptional" with certificate "12345678" and expiry date "20/08/2021"
    Then I should see "Remove"
    #AC2
    When I click "Remove" link
    Then I should not see Subsequent Inspection Type field
    Then I should not see Subsequent Inspection Certificate field
    Then I should not see Subsequent Inspection Expiry Date fields
    When I add initial inspection with certificate "98765" and expiry date "29/09/2021"
    And I add subsequent inspection of type "Exceptional" with certificate "12345678" and expiry date "20/08/2021"
    And I click the save technical record button
    And I enter "cvsb-14893" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should not see "Save technical record"
    And I should not see "There is a problem"
    Then tech record fields should have values
      | Field                     | Value        |
      | tc2Type                   | Initial      |
      | tc2IntermediateApprovalNo | 98765        |
      | tc2IntermediateExpiryDate | 29/09/2021   |
      | tc3Type-0                 | Exceptional  |
      | tc3PeriodicNumber-0       | 12345678     |
      | tc3PeriodicExpiryDate-0   | 20/08/2021   |
