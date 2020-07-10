Feature: Select technical record from record history
  As an admin user I can log in the VTM app
  And when viewing a technical record
  I can select historical versions of the record

  Background:
    Given I login with admin credentials
    When I go to search tech record page
    And I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"

  Scenario: AC1 - The page displays correct fields
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Current                     |
    And I should see "Technical record history" hyperlink
    When I open tech record "Technical record history" section
    Then I should see "Status"
    And I should see "Reason for creation"
    And I should see "Created by"
    And I should see "Created at"
    And the "technical record history" tech record section should have 3 entries
    And tech record fields should have values
      | Field                          | Value        |
      | statusCode-0                   | Current      |
      | reasonForCreation-0            | New Vehicle1 |
      | createdByName-0                | Dvsa         |
      | createdAt-0                    | 24/06/2019   |
      | statusCode-1                   | Provisional  |
      | reasonForCreation-1            | New Vehicle2 |
      | createdByName-1                | Dvsa2        |
      | createdAt-1                    | 25/06/2019   |
      | statusCode-2                   | Archived     |
      | reasonForCreation-2            | New Vehicle3 |
      | createdByName-2                | -            |
      | createdAt-2                    | 26/06/2019   |
    And the 'View' link is not shown for the record with status "Current"
    And the 'View' link is shown for the record with status "Provisional"
    And the 'View' link is shown for the record with status "Archived"

  Scenario: AC2 - User clicks the call to action to view a different tech record
    When I open tech record "technical record history" section
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Current                     |
    And the 'View' link is not shown for the record with status "Current"
    When I click on the 'View' button for the technical record with status of "Provisional"
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Provisional                 |
    And the 'View' link is not shown for the record with status "Provisional"
    And the 'View' link is shown for the record with status "Current"
    And the 'View' link is shown for the record with status "Archived"
    When I open tech record "Vehicle summary" section
    And tech record fields should have values
      | Field                     | Value     |
      | manufactureYear           | 2017      |
    When I click on the 'View' button for the technical record with status of "Archived"
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Archived                    |
    And the 'View' link is shown for the record with status "Provisional"
    And the 'View' link is shown for the record with status "Current"
    And the 'View' link is not shown for the record with status "Archived"
    And tech record fields should have values
      | Field                     | Value     |
      | manufactureYear           | 2016      |
    When I click on the 'View' button for the technical record with status of "Current"
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Current                     |
    And the 'View' link is shown for the record with status "Provisional"
    And the 'View' link is not shown for the record with status "Current"
    And the 'View' link is shown for the record with status "Archived"
    And tech record fields should have values
      | Field                     | Value     |
      | manufactureYear           | 2018      |

  Scenario: The ability to change the record is based on record status
  AC3 - User cannot change the fields of an 'archived' technical record
  AC4 - User can change the fields of a 'provisional' or 'current' technical record
    When I open tech record "technical record history" section
    When I click on the 'View' button for the technical record with status of "Archived"
    Then I should not see "Change technical record"
    When I click on the 'View' button for the technical record with status of "Provisional"
    Then I should see "Change technical record"
    When I click on the 'View' button for the technical record with status of "Archived"
    Then I should not see "Change technical record"
    When I click on the 'View' button for the technical record with status of "Current"
    Then I should see "Change technical record"

  Scenario: AC5 - User clicks the 'technical record history' call to action
    When I click "Technical record history" link
    Then I should see "Status"
    And I should see "Reason for creation"
    And I should see "Created by"
    And I should see "Created at"
    And the "technical record history" tech record section should have 3 entries
    And tech record fields should have values
      | Field                          | Value        |
      | statusCode-0                   | Current      |
      | reasonForCreation-0            | New Vehicle1 |
      | createdByName-0                | Dvsa         |
      | createdAt-0                    | 24/06/2019   |
      | statusCode-1                   | Provisional  |
      | reasonForCreation-1            | New Vehicle2 |
      | createdByName-1                | Dvsa2        |
      | createdAt-1                    | 25/06/2019   |
      | statusCode-2                   | Archived     |
      | reasonForCreation-2            | New Vehicle3 |
      | createdByName-2                | -            |
      | createdAt-2                    | 26/06/2019   |
