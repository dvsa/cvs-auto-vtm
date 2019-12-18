Feature: Search tech record
  As an admin user I can log in the VTM app
  And search for tech records using Vin, primary Vrm, partial Vin or trailerId

  Background: Check content in tech record search page
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And I should see "Search for a technical record"
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And element with id "searchIdentifier" should be present

  @skip
  Scenario: Search using full vin
  AC2 - User Searches For Technical Records Using Full VIN
  AC2 -
    Given I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    When I go back to search page

