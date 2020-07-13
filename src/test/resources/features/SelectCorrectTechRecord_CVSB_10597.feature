Feature: CVSB-10597 - Select correct vehicle when multiple vehicles are returned following a search
  As an admin user I can search for a vehicle in the search vehicle page
  After which I should be able to select the correct vehicle when multiple vehicles are returned following a search
  So that I can view the tech record of the correct vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Vehicle testing management"
    And I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    Then search vehicle input field should be present

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
    Then I should see "Vehicle summary"
    Then I should see "P012301230000"
    Then I click "Back" link
    When I search for vehicle with shared identifier "567123"
    # AC3
    Then I should see "Multiple technical records found matching this search"
    And the screen name should be "Select a technical record"
    Then tech record fields should have values
      | Field                   | Value                   |
      | selectTechnicalRecord-0 | Select technical record |
      | vin-0                   | XYZ321667788            |
      | vrm-0-tech-0            | TRL1234                 |
      | vehicleType-0           | TRL                     |
      # manufactureYear is null in DynamoDB
      | manufactureYear-0       | -                       |
      | make-0                  | MERCEDES                |
      | model-0                 | M200                    |
      | selectTechnicalRecord-1 | Select technical record |
      | vin-1                   | ABC789332211            |
      | vrm-0-tech-1            | HGV1234                 |
      | vehicleType-1           | HGV                     |
      | manufactureYear-1       | 1999                    |
      | make-1                  | VOLVO                   |
      # model is not present in DynamoDB at all
      | model-1                 | -                       |
      | selectTechnicalRecord-2 | Select technical record |
      | vin-2                   | SC123554433             |
      | vrm-0-tech-2            | HGV1234                 |
      | vehicleType-2           | HGV                     |
      | manufactureYear-2       | 1998                    |
      | make-2                  | VW                      |
      | model-2                 | VW2                     |
    And I should see correct heading for each tech record
    And technical records are alphabetically ordered by make
    # AC4 + AC5
    When I click link to select technical record with index 1
    Then I should see "Change technical record"
    When I open all tech record sections
    Then tech record fields should have values
      | Field               | Value        |
      | status              | Provisional  |
      | vin                 | XYZ321667788 |
      | vrm                 | TRL1234      |
      | vehicleType         | TRL          |
      # manufactureYear is null in DynamoDB
      | manufactureYear     | -            |
      | make                | MERCEDES     |
      | model               | M200         |
      | statusCode-0        | Provisional  |
      | reasonForCreation-0 | New Record   |
      | createdByName-0     | Catalin      |
      | createdAt-0         | 08/04/2020   |
      | statusCode-1        | Archived     |
      | reasonForCreation-1 | New Record   |
      | createdByName-1     | Catalin      |
      | createdAt-1         | 01/04/2020   |
    When I click "Back" link
    Then I should see "Multiple technical records found matching this search"
    When I click link to select technical record with index 2
    Then I should see "Change technical record"
    When I open all tech record sections
    Then tech record fields should have values
      | Field               | Value        |
      | status              | Current      |
      | vin                 | ABC789332211 |
      | vrm                 | HGV1234      |
      | vehicleType         | HGV          |
      | manufactureYear     | 1999         |
      | make                | VOLVO        |
      # model is not present in DynamoDB at all
      | model               | -            |
      | statusCode-0        | Current      |
      | reasonForCreation-0 | New Record   |
      | createdByName-0     | Catalin      |
      | createdAt-0         | 08/04/2020   |
      | statusCode-1        | Provisional  |
      | reasonForCreation-1 | New Record   |
      | createdByName-1     | Catalin      |
      | createdAt-1         | 01/04/2020   |
    When I click "Back" link
    Then I should see "Multiple technical records found matching this search"
    When I click link to select technical record with index 3
    When I open all tech record sections
    Then tech record fields should have values
      | Field               | Value        |
      | status              | Archived     |
      | vin                 | SC123554433  |
      | vrm                 | HGV1234      |
      | vehicleType         | HGV          |
      # manufactureYear is null in DynamoDB
      | manufactureYear     | 1998         |
      | make                | VW           |
      | model               | VW2          |
      | statusCode-0        | Archived     |
      | reasonForCreation-0 | New Record   |
      | createdByName-0     | Catalin      |
      | createdAt-0         | 08/04/2020   |
      | statusCode-1        | Archived     |
      | reasonForCreation-1 | New Record   |
      | createdByName-1     | Catalin      |
      | createdAt-1         | 01/04/2020   |
    When I click "Back" link
    Then I should see "Multiple technical records found matching this search"
    # AC6
    When I click "Back" link
    Then I should see "Search for a technical record"
    And I should see "Search criteria"










