Feature: Search tech record
  As an admin user I can log in the VTM app
  And search for tech records using Vin, primary Vrm, partial Vin or trailerId

  Background: Check content in tech record search page
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And I should see "Search for a technical record"
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And element with id "searchIdentifier" should be present


  Scenario: Search using full vin
  AC2 - User Searches For Technical Records Using Full VIN
  AC4 - User Searches For Technical Records Using Partial VIN
  AC5 - User Searches For Technical Records Using Primary VRM
  AC6 - User Searches For Technical Records Using Primary VRM in Z format
  AC7 - User Searches For Technical Records Using Trailer ID
    #search using full VIN
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "CT70000"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using partial VIN
    Given I search for vehicle with identifier "230000"
    Then wait until I see "CT70000"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using primary VRM
    Given I search for vehicle with identifier "CT70001"
    Then wait until I see "P012301230001"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using primary VRM in Z number format
    Given I search for vehicle with identifier "112233Z"
    Then wait until I see "T12111000"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using trailer id
    Given I search for vehicle with identifier "C123456"
    Then wait until I see "T12111000"

