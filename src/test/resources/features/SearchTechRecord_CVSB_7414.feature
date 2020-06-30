Feature: CVSB-7414 - Search tech record
  As an admin user I can log in the VTM app
  And search for tech records using Vin, primary Vrm, partial Vin or trailerId

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: Search using full vin
  AC2 - User Searches For Technical Records Using Full VIN
  AC4 - User Searches For Technical Records Using Partial VIN
  AC5 - User Searches For Technical Records Using Primary VRM
  AC6 - User Searches For Technical Records Using Primary VRM in Z format
  AC7 - User Searches For Technical Records Using Trailer ID
    #search using full VIN
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "CT70000"
    When I click "Back" link
    Then I should see "Search for a technical record"
    #search using partial VIN
    When I search for vehicle with identifier "230000"
    Then wait until I see "CT70000"
    When I click "Back" link
    Then I should see "Search for a technical record"
    #search using primary VRM
    When I search for vehicle with identifier "CT70001"
    Then wait until I see "P012301230001"
    When I click "Back" link
    Then I should see "Search for a technical record"
    #search using trailer id
    When I search for vehicle with identifier "C123456"
    Then wait until I see "T12111000"
    #search using primary VRM
    When I click "Back" link
    And I select "Vehicle registration mark (VRM)" search criteria
    And I search for vehicle with identifier "CT70001"
    Then wait until I see "P012301230001"
    When I click "Back" link
    Then I should see "Search for a technical record"
    #search using full VIN
    And I select "Full vehicle identification number (VIN)" search criteria
    And I search for vehicle with identifier "P012301230000"
    Then wait until I see "CT70000"
    When I click "Back" link
    Then I should see "Search for a technical record"
    #search using partial VIN
    And I select "Partial VIN (last 6 characters)" search criteria
    And I search for vehicle with identifier "230000"
    Then wait until I see "CT70000"
    When I click "Back" link
    Then I should see "Search for a technical record"
    #search using trailer id
    And I select "Trailer ID" search criteria
    And I search for vehicle with identifier "C123456"
    Then wait until I see "T12111000"


  Scenario: Search technical record negative scenarios
  AC9 - User Searches For Technical Records Without Entering Any Search Criteria
    #search without entering any search criteria
    When I search for vehicle using wrong identifier ""
    Then the header error contains "There is a problem"
    And the header error contains "Enter a vehicle registration mark, trailer ID or vehicle identification number"
    And the specific error contains "Enter a vehicle registration mark, trailer ID or vehicle identification number"
