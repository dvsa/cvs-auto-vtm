Feature: CVSB-10139 - Search for vehicle before creation
  As an admin user I can search for a vehicle in the create vehicle page
  And make sure that the vehicle I wish to create does not already exist

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And create new vehicle link should be present
    When I go to create tech record page
    Then I should see "Create new technical record"
    Then vin input field should be present

  Scenario: As the DVSA, we want to be able to search for a vehicle before creating it to ensure that it does not already exist
  AC1 - 'Create new technical record' page displays correct fields
  AC2 - Conditional logic for HGV
  AC3 - Conditional logic for PSV
  AC4 - Conditional logic for TRL
  AC5 - User successfully proceeds (since the vehicle does not already exist)
  AC6 - User clicks back button
    # AC7
    When I click "Back" link
    Then create new vehicle link should be present
    When I go to create tech record page
    Then I should see "Create new technical record"
    Then vin input field should be present
    # AC1
    Then I should see "Vehicle type"
    Then I should see "Vehicle identification number (VIN)" in "vin" field description
    Then I should see "Vehicle registration mark (VRM)" in "vrm" field description
    Then I should not see "Vehicle registration mark (VRM - optional)" in "vrm" field description
    Then I should see "Back" hyperlink
    Then I should see "Continue" button
    # AC2
    When I select vehicle type "hgv"
    Then I should see "Vehicle registration mark (VRM)" in "vrm" field description
    Then I should not see "Vehicle registration mark (VRM - optional)" in "vrm" field description
    When I click "Continue" button
    Then the header error contains "There is a problem"
    And the header error contains "Enter a VIN"
    And the header error contains "Enter a VRM"
    And the specific "vin" error contains "Enter a VIN"
    And the specific "vrm" error contains "Enter a VRM"
    # AC3
    When I select vehicle type "psv"
    Then I should see "Vehicle registration mark (VRM)" in "vrm" field description
    Then I should not see "Vehicle registration mark (VRM - optional)" in "vrm" field description
    When I click "Continue" button
    Then the header error contains "There is a problem"
    And the header error contains "Enter a VIN"
    And the header error contains "Enter a VRM"
    And the specific "vin" error contains "Enter a VIN"
    And the specific "vrm" error contains "Enter a VRM"
    # AC4
    When I select vehicle type "trailer"
    Then I should not see "Vehicle registration mark (VRM)" in "vrm" field description
    And I should see "Vehicle registration mark (VRM - optional)" in "vrm" field description
    And I click "Continue" button
    Then the header error contains "There is a problem"
    And the header error contains "Enter a VIN"
    And the header error does not contain "Enter a VRM"
    And the specific "vin" error contains "Enter a VIN"
    And there are no "vrm" related errors
    # AC5
    When I fill in vin "P12345678901234567890123"
    Then I should not see "P12345678901234567890123" in "vin" input field
    And I should see "P12345678901234567890" in "vin" input field
    And I fill in vrm "CT1234567890"
    And I should not see "CT1234567890" in "vrm" input field
    And I should see "CT123456" in "vrm" input field
    # AC6
    When I fill in random vin
    And I fill in random vrm
    And I select vehicle type "psv"
    And I click "Continue" button
    Then I should see "All content is available under the Open Government Licence v3.0, except where otherwise stated"

