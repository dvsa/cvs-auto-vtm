Feature: Select correct vehicle when multiple vehicles are returned following a search
  As an admin user I can search for a vehicle in the search vehicle page
  After which I should be able to select the correct vehicle when multiple vehicles are returned following a search
  So that I can view the tech record of the correct vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And element with id "test-search-vehicle" should be present
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    Then element with id "searchIdentifier" should be present

  Scenario: As the DVSA, we want to be able to select the correct vehicle when multiple vehicles are returned following
  a search, so that we can view the tech record of the correct vehicle
  AC1 - A single vehicle is retrieved from DynamoDB, therefore the tech record is displayed on VTM
  AC2 - A single vehicle is retrieved from DynamoDB. The tech record is displayed.The user clicks the call to action to go back
  AC3 - Multiple vehicles are retrieved from DynamoDB. The user is presented with a list of matching vehicles
  AC4 - Multiple vehicles are retrieved from DynamoDB. The user selects one. The tech record is displayed for that vehicle
  AC5 - Multiple vehicles are retrieved from DynamoDB. The user is viewing the tech record, and decides to go back to 'Select a technical record'
  AC6 - Multiple vehicles are retrieved DynamoDB - The user goes back from the tech record list to the search screen
    # AC1 + AC2
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "Vehicle summary"
    Then I should see the searched Vin
    Then I go back to search page
    Then I perform another search
    # AC3 + AC4
    Then the screen name should be "Select a technical record"
    And I should see all attributes of the vehicle
    And I should see - for an attribute with null value
    And I should see Select technical record hyperlink against each tech record
    #And I should see the provisional tech record
    And I should see the current tech record
    #And I should see the latest archived tech record
    And I should see make is alphabetically ordered
    And I should see technical record is numbered
    # AC5
    When I click on Select technical record hyperlink
    Then I should be the selected tech record
    Then I go back to the Select technical record page
    Then the screen name should be "Select a technical record"
    And I select a different technical record
    Then I go back to the Select technical record page
    # AC6
    Then I go back to search page
    Then I perform another search










