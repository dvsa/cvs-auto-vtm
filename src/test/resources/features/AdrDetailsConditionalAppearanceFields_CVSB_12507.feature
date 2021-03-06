Feature: Adr details conditional appearance of fields - CVSB-12507
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should see specific adr fields will appear only under certain conditions

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "trl" vehicle with adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: Check adr fields appear under certain conditions
  AC1 - Selecting "Explosives (type 2)" or "Explosives (type 3)" from "Permitted dangerous goods" selection makes "CompatilibityGroupJ" appear
  AC2 - User can only select statement OR product list
  AC3 - User selects statement
  AC4 - User selects product list
  AC5 - User selects Battery list applicable
  AC6 - User selects Manufacturer brake declaration
  AC7 - User selects Brake endurance
    When I search for previously created vehicle
    Then I should see "Technical record"
    And I should see "ADR" section heading
    And I should see the "vin" of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    Then I should see "Change technical record"
    When I open tech record "ADR" section
    When I click the change technical record button
    Then I should see "Save technical record"
    #selecting "Explosives (type 2)" or "Explosives (type 3)" from "Permitted dangerous goods" selection makes "Compatilibity Group J" appear
    When I select "Explosives (type 2)" dangerous good
    Then I should see "Compatibility group J"
    When I deselect "Explosives (type 2)" dangerous good
    Then I should not see "Compatibility group J"
    When I select "Explosives (type 3)" dangerous good
    Then I should see "Compatibility group J"
    When I deselect "Explosives (type 3)" dangerous good
    Then I should not see "Compatibility group J"
    #selecting "statement" will display "Reference number" field while selecting "product list" will display "Reference number", "UN number" and "Additional Details" fields
    When I select "Rigid tank" adr vehicle type
    Then I should not see "Battery list applicable"
    And I select substances permitted "class UN number" option
    And I select "Statement" from tank statement
    Then I should see "Reference number" statement field
    And I should not see product list fields
    When I select "Product List" from tank statement
    Then I should see "Reference number" product list field
    And I should see "UN number" product list field
    And I should see "Additional details" product list field
    And I should not see statement fields
    #selecting "yes" from "battery list applicable" will display "Reference number" field while selecting "no" will not display any field
    When I select "Rigid battery" adr vehicle type
    Then I should see "Battery list applicable"
    And I should not see battery list fields
    When I set battery list applicable to "Yes"
    Then I should see "Reference number" battery list field
    When I set battery list applicable to "No"
    Then I should not see battery list fields
    #selecting "manufacturer brake declaration" from "declaration seen" will display "Issuer" and "Brake endurance" fields
    When I select "Manufacturer brake declaration" checkbox
    Then I should see "Issuer" manufacturer brake declaration field
    And I should not see brake endurance fields
    When I select "Brake endurance" checkbox
    Then I should see "Weight(kg)" brake endurance field
    When I deselect "Brake endurance" checkbox
    Then I should not see brake endurance fields
    When I deselect "Manufacturer brake declaration" checkbox
    Then I should not see manufacturer brake declaration fields
