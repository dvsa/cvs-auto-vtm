Feature: CVSB-10760 - Search Vehicle Special Characters
  As an admin, I can search for vehicles which contain special characters
  And I am able to view and manage vehicles which contain special characters

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  Scenario: As the DVSA, we want to be able to search for vehicles which contain special characters
  AC1. "Vehicle Search" is executed using special characters
  AC2. "Vehicle Create Search" is executed using special characters
    When I create "hgv" vehicle with identifiers containing special characters
    When I go to search tech record page
    Then I should see "Search for a technical record"
    Then search vehicle input field should be present
    Then "Vehicle registration mark, trailer ID or vehicle identification number" search option should be selected
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    When I go back to previous page
    Then search vehicle input field should be present
    When I select "Vehicle registration mark (VRM)" search criteria
    Then "Vehicle registration mark (VRM)" search option should be selected
    When I search for previously created vehicle after "vrm"
    Then wait until I see "Technical record"
    When I go back to previous page
    Then search vehicle input field should be present
    And I select "Full vehicle identification number (VIN)" search criteria
    Then "Full vehicle identification number (VIN)" search option should be selected
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    When I go back to previous page
    Then search vehicle input field should be present
    When I select "Partial VIN (last 6 characters)" search criteria
    Then "Partial VIN (last 6 characters)" search option should be selected
    When I search for previously created vehicle after "partial vin"
    Then wait until I see "Technical record"
    # AC2
    When I go back to home page
    And I go to create tech record page
    And I should see "Create new technical record"
    When I select vehicle type "hgv"
    When I fill in vin with previously created vehicle
    When I fill in vrm with previously created vehicle
    And I click "Continue" button
    Then the header error contains "There is a problem"
    And the header error contains "A technical record with this VRM already exists, check the VRM or change the existing technical record"

  Scenario: As the DVSA, we want to be able to search for vehicles which contain special characters
  AC3. "Vehicle Create Search" executed using special characters did not find a pre-existing vehicle, hence, the VIN/VRM passed to the tech record entry screen is displayed in decoded format, rather than encoded format
    And I go to create tech record page
    And I should see "Create new technical record"
    When I select vehicle type "hgv"
    When I fill in vin "AA00001111/55555"
    Then I should see "AA00001111/55555" in "vin" input field
    And I fill in vrm "ZZX^X"
    And I should see "ZZX^X" in "vrm" input field
    And I click "Continue" button
    Then wait until I see "Vehicle summary"
    Then I should see "AA00001111/55555" in "vin" edit input field
    And I should see "ZZX^X" in "vrm" edit input field
