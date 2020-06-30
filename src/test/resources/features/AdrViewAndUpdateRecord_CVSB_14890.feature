Feature: As the DVSA, we want to be able to capture ADR certificate notes on VTM so that these certificate notes
  can be displayed on the certificate - CVSB-14890

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  Scenario: Check ADR View and ADR Update Screen screen work as expected
  AC1 - "ADR VIEW Screen" displays a new field: 'ADR certificate notes'
  AC2 - "ADR UPDATE Screen" displays a new field: 'ADR certificate notes'
    #AC1
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I open tech record "ADR" section
    Then I should see "ADR certificate notes"
    #AC2
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    When I open tech record "ADR" section
    Then I should see "ADR certificate notes"
