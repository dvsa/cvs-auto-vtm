Feature: Test details screen
  As an admin user I can log in the VTM app
  After I search for a tech record
  Then I should be able to navigate to test details screen

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present


  Scenario: Navigate to test details screen
  AC1 - The test history table, on the tech record screen, now has a tester name column
  AC2 - 'View' link is displayed for each record in the test history section on the tech record page
  AC3 - Navigate to the Test Record screen when 'View' is selected
    # AC1+AC2
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "A00004965"
    Then wait until I see "Technical record"
    When I open tech record "test history" section
    Then the "test history" tech record section should be empty
    When I go back to home page
    Then I should see "Select activity"
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    When I open tech record "test history" section
    Then I should see "View" in "Test history" tech record section
    And tech record fields should have values
      | Field          | Value |
      | testerName-0-0 | Gica  |
      | view-0         | View  |
      | testerName-1-0 | Gica  |
      | view-1         | View  |
      | testerName-2-0 | Gica  |
      | view-2         | View  |
    # AC3
    When I go to view test record with index 1
    Then I should be taken to the correct test record page


  Scenario: Navigate to test details screen
  AC3 - Navigate to the Test Record screen when 'View' is selected
  AC4 - Only 'Current' test records are displayed in the 'Test History' section of the 'Tech Record'
    # AC3
    When I create "hgv" vehicle
    And I create test record with status "submitted" and result "pass" and test type "ruv" for previously created vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    When I open tech record "test history" section
    Then I should see "View" in "Test history" tech record section
    And test record fields of newly created test should have correct values
      | Field          |
      | testerName-0-0 |
    When I update previously created test record
    And I go back to home page
    Then I should see "Select activity"
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    When I open tech record "test history" section
    And test record fields of newly created test should have correct values
      | Field          |
      | testerName-0-0 |
    # AC4
    When I go to view test record with index 1
    Then I should be taken to the correct test record page
    Then wait until I see "Change test record"
    When I open all test record sections
    And I should see "notes"
