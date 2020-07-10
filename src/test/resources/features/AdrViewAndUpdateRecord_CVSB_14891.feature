Feature: As the DVSA, we want the fields on the VTM ADR screen to be appropriately named so we know how to correctly
  populate these fields - CVSB-14891

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  Scenario: Check ADR View and ADR Update Screen screen work as expected
  AC1 - "ADR VIEW Screen": Applicant Details label is updated to 'Owner/operator details'
  AC2 - "ADR UPDATE Screen": Applicant Details label is updated to 'Owner/operator details'
  AC3 - "ADR UPDATE Screen": Optional fields say "(optional)" at the end of their label
    #vehicleType = Artic Tractor
    #AC1
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "P1234567890123"
    Then wait until I see "Technical record"
    When I open tech record "ADR" section
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
     #AC2
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
     #AC3
    When I select "Explosives (type 2)" dangerous good
    Then I should see "Compatibility group J (optional)"
    Then I should see "Guidance notes (optional)"
    Then I should see "ADR type approval number (optional)"
    Then I should see "Manufacturer brake declaration (optional)"
    And I select "Manufacturer brake declaration" checkbox
    Then I should see "Issuer"
    And I should see "Brake endurance"
    Then I should see "Owner/operator declaration (optional)"
    Then I should see "Certificate required (optional)"
    Then I should see "Additional ADR notes (optional)"
    Then I should see "ADR certificate notes (optional)"
    And I click "Cancel" link
    When I go back to search page
    #vehicleType = Centre Axle tank
    #AC1
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I open tech record "ADR" section
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
    #AC2
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
    #AC3
    When I select "Explosives (type 2)" dangerous good
    Then I should see "Compatibility group J (optional)"
    Then I should see "Guidance notes (optional)"
    Then I should see "ADR type approval number (optional)"
    And I select substances permitted "class UN number" option
    Then I should see "Statement"
    And I should see "Product list"
    When I select "Statement" from tank statement
    Then I should see "Reference number (optional)"
    When I select "Product list" from tank statement
    Then I should see "Reference number (optional)"
    Then I should see "UN number (optional)"
    Then I should see "Additional details (optional)"
    Then I should see "Special provisions (optional)"
    And I add subsequent inspection of type "Exceptional" with certificate "12345678" and expiry date "20/08/2021"
    Then I should see "Inspection type (optional)"
    Then I should see "Certificate number (optional)"
    Then I should see "Expiry date (optional)"
    And I add subsequent inspection of type "Periodic" with certificate "123678" and expiry date "29/08/2021"
    Then I should see "Inspection type (optional)"
    Then I should see "Certificate number (optional)"
    Then I should see "Expiry date (optional)"
    Then I should see "Memo 07/09 (3 month extension) applied (optional)"
    Then I should see "Manufacturer brake declaration (optional)"
    And I select "Manufacturer brake declaration" checkbox
    Then I should see "Issuer"
    And I should see "Brake endurance"
    Then I should see "Owner/operator declaration (optional)"
    Then I should see "Certificate required (optional)"
    Then I should see "Additional ADR notes (optional)"
    Then I should see "ADR certificate notes (optional)"
    And I click "Cancel" link
    When I go back to search page
    #vehicleType = Centre Axle Battery
    #AC1
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "ABCDEFGH888888"
    Then wait until I see "Technical record"
    When I open tech record "ADR" section
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
    #AC2
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
    #AC3
    When I select "Explosives (type 2)" dangerous good
    Then I should see "Compatibility group J (optional)"
    Then I should see "Guidance notes (optional)"
    Then I should see "ADR type approval number (optional)"
    And I select substances permitted "class UN number" option
    Then I should see "Statement"
    And I should see "Product list"
    When I select "Statement" from tank statement
    Then I should see "Reference number (optional)"
    When I select "Product list" from tank statement
    Then I should see "Reference number (optional)"
    Then I should see "UN number (optional)"
    Then I should see "Additional details (optional)"
    Then I should see "Special provisions (optional)"
    And I add subsequent inspection of type "Exceptional" with certificate "12345678" and expiry date "20/08/2021"
    Then I should see "Inspection type (optional)"
    Then I should see "Certificate number (optional)"
    Then I should see "Expiry date (optional)"
    And I add subsequent inspection of type "Periodic" with certificate "123678" and expiry date "29/08/2021"
    Then I should see "Inspection type (optional)"
    Then I should see "Certificate number (optional)"
    Then I should see "Expiry date (optional)"
    Then I should see "Memo 07/09 (3 month extension) applied (optional)"
    Then I should see "Battery list applicable (optional)"
    Then I should see "Manufacturer brake declaration (optional)"
    And I select "Manufacturer brake declaration" checkbox
    Then I should see "Issuer"
    And I should see "Brake endurance"
    Then I should see "Owner/operator declaration (optional)"
    Then I should see "Certificate required (optional)"
    Then I should see "Additional ADR notes (optional)"
    Then I should see "ADR certificate notes (optional)"
