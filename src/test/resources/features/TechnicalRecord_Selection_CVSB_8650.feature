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
    # By default, the Tech Record shown should be the "current" one.
    Then the current record status is "Current"
    And there is a 'Technical record history' call to action below the status
    When I open "Technical record history" section
    Then I should see "Status"
    And I should see "Reason for creation"
    And I should see "Created by"
    And I should see "Created at"
    # Tech record has (3 iterations + 1 header row) = 4 entries.
    And the "technical record history" section should have "4" entries
    And hgv tech record fields should have values
      | Field                          | Value        |
      # Row 0
      | statusCode-0                   | Current      |
      | reasonForCreation-0            | New Vehicle1 |
      | createdByName-0                | Dvsa         |
      | createdAt-0                    | 24/06/2019   |
      # Row 1
      | statusCode-1                   | Provisional  |
      | reasonForCreation-1            | New Vehicle2 |
      | createdByName-1                | Dvsa2        |
      | createdAt-1                    | 25/06/2019   |
      # Row 2
      | statusCode-2                   | Archived     |
      | reasonForCreation-2            | New Vehicle3 |
      | createdByName-2                | -            |
      | createdAt-2                    | 26/06/2019   |
    # Ensure that the <View> button is not available for the current record only.
    And the 'View' link is not shown for the record with status "Current"
    And the 'View' link is shown for the record with status "Provisional"
    And the 'View' link is shown for the record with status "Archived"

  Scenario: AC2 - User clicks the call to action to view a different tech record
    When I click on "Technical record history"
    Then the current record status is "Current"
    And the 'View' link is not shown for the record with status "Current"
    # Verify selection of the "Provisional" record.
    When I click on the 'View' button for the technical record with status of "Provisional"
    Then the current record status is "Provisional"
    And the 'View' link is not shown for the record with status "Provisional"
    And the 'View' link is shown for the record with status "Current"
    And the 'View' link is shown for the record with status "Archived"
    ## And verify that the correct record details are shown.
    When I open "Vehicle summary" section
    Then hgv tech record fields should have values
      | Field                     | Value     |
      | manufactureYear           | 2017      |
    # Verify selection of the "Archived" record.
    When I click on the 'View' button for the technical record with status of "Archived"
    Then the current record status is "Archived"
    And the 'View' link is shown for the record with status "Provisional"
    And the 'View' link is shown for the record with status "Current"
    And the 'View' link is not shown for the record with status "Archived"
    ## And verify that the correct record details are shown.
    Then hgv tech record fields should have values
      | Field                     | Value     |
      | manufactureYear           | 2016      |
    # Verify selection of the "Current" record.
    When I click on the 'View' button for the technical record with status of "Current"
    Then the current record status is "Current"
    And the 'View' link is shown for the record with status "Provisional"
    And the 'View' link is not shown for the record with status "Current"
    And the 'View' link is shown for the record with status "Archived"
    ## And verify that the correct record details are shown.
    Then hgv tech record fields should have values
      | Field                     | Value     |
      | manufactureYear           | 2018      |

  Scenario: The ability to change the record is based on record status
    When I click on "Technical record history"
    # AC3 - User cannot change the fields of an 'archived' technical record
    # AC4 - User can change the fields of a 'provisional' or 'current' technical record
    When I click on the 'View' button for the technical record with status of "Archived"
    Then the 'Change technical record' button is "hidden"
    When I click on the 'View' button for the technical record with status of "Provisional"
    Then the 'Change technical record' button is "shown"
    When I click on the 'View' button for the technical record with status of "Archived"
    Then the 'Change technical record' button is "hidden"
    When I click on the 'View' button for the technical record with status of "Current"
    Then the 'Change technical record' button is "shown"

  Scenario: AC5 - User clicks the 'technical record history' call to action
    # When this button is clicked, the Technical Record History panel is opened, and information presented.
    When I click on "Technical record history"
    Then I should see "Status"
    And I should see "Reason for creation"
    And I should see "Created by"
    And I should see "Created at"
    # Tech record has (3 iterations + 1 header row) = 4 entries.
    And the "technical record history" section should have "4" entries
    And hgv tech record fields should have values
      | Field                          | Value        |
      # Row 0
      | statusCode-0                   | Current      |
      | reasonForCreation-0            | New Vehicle1 |
      | createdByName-0                | Dvsa         |
      | createdAt-0                    | 24/06/2019   |
      # Row 1
      | statusCode-1                   | Provisional  |
      | reasonForCreation-1            | New Vehicle2 |
      | createdByName-1                | Dvsa2        |
      | createdAt-1                    | 25/06/2019   |
      # Row 2
      | statusCode-2                   | Archived     |
      | reasonForCreation-2            | New Vehicle3 |
      | createdByName-2                | -            |
      | createdAt-2                    | 26/06/2019   |