Feature: Search tech record
  As an admin user I can log in the VTM app
  And search for tech records using Vin, primary Vrm, partial Vin or trailerId

  Background: Check content in tech record search page
    Given I login with admin credentials
    Then I should see "Select activity"
    And element with id "test-create-new-vehicle" should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And element with id "searchIdentifier" should be present

  @skip
  # because search is covered in tests for CVSB-11329
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
    When I search for vehicle with identifier "230000"
    Then wait until I see "CT70000"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using primary VRM
    When I search for vehicle with identifier "CT70001"
    Then wait until I see "P012301230001"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using primary VRM in Z number format
    When I search for vehicle with identifier "112233Z"
    Then wait until I see "P1234567890123"
    When I go back to search page
    Then I should see "Search for a technical record"
    #search using trailer id
    When I search for vehicle with identifier "C123456"
    Then wait until I see "T12111000"

  @skip
  # until CVSB-10597 is fixed
  Scenario: Search technical record negative scenarios
  AC9 - User Searches For Technical Records Without Entering Any Search Criteria
  AC10 - Partial VIN search returns duplicated full VINs
  AC11 - VRM search returns multiple vehicles
    #partial VIN search returns duplicated full VINs
    When I search for vehicle using wrong identifier "678413"
    Then the header error contains "There is a problem"
    And the header error contains "Multiple vehicles found, search using the full vehicle identification number"
    And the specific error contains "Multiple vehicles found, search using the full vehicle identification number"
    Then wait until I see search error message ""
    #search without entering any search criteria
    When I search for vehicle using wrong identifier ""
    Then the header error contains "There is a problem"
    And the header error contains "Enter a vehicle registration mark, trailer ID or vehicle identification number"
    And the specific error contains "Enter a vehicle registration mark, trailer ID or vehicle identification number"
    #VRM search returns multiple vehicles
    Given I search for vehicle using wrong identifier "CT70VRL"
    Then the header error contains "There is a problem"
    And the header error contains "Multiple vehicles found, search using the full vehicle identification number"
    And the specific error contains "Multiple vehicles found, search using the full vehicle identification number"
