Feature: Show test accurately for queried vehicle
  As an admin user I can log in the VTM app
  And see all test results that have same system number as the queried vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And element with id "test-create-new-vehicle" should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And element with id "searchIdentifier" should be present

  Scenario: Search vehicle with multiple test results with same system number and different vins
  AC1 - User Searches For Vehicle With Multiple Test Results Having Same System Number And Different Vins
    # search using VIN
    When I search for vehicle with identifier "T72741999"
    Then wait until I see "Technical record"
    # user clicks the call to action to open test history section
    When I open "test history" section
    Then I should see "Test type"
    # the test history section should have three entries, one headings row and two actual tests
    And the "test history" section should have "3" entries
    Then hgv tech record fields should have values
      | Field               | Value      |
      | testCode-0          | Aav2       |
      | testEndTimestamp-0  | 15/01/2019 |
      | expiryDate-0        | -          |
      | certificateNumber-0 | -          |
      | testResult-0        | FAIL       |
      | testCode-1          | Pms        |
      | testEndTimestamp-1  | 14/01/2019 |
      | expiryDate-1        | 14/01/2020 |
      | certificateNumber-1 | 12334      |
      | testResult-1        | PASS       |
