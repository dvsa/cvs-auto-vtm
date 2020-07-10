Feature: Show test accurately for queried vehicle - CVSB-12661
  As an admin user I can log in the VTM app
  And see all test results that have same system number as the queried vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: Search vehicle with multiple test results with same system number and different vins
  AC1 - User Searches For Vehicle With Multiple Test Results Having Same System Number And Different Vins
    # search using VIN
    When I search for vehicle with identifier "T72741999"
    Then wait until I see "Technical record"
    # user clicks the call to action to open test history section
    When I open tech record "test history" section
    Then I should see "Test type"
    # the test history section should have two entries
    And the "test history" tech record section should have 2 entries
    Then tech record fields should have values
      | Field                         | Value       |
      | testCode-tRes-0-0             | Annual Test |
      | testTypeEndTimestamp-tRes-0-0 | 15/01/2019  |
      | expiryDate-tRes-0-0           | -           |
      | certificateNumber-tRes-0-0    | -           |
      | testResult-tRes-0-0           | FAIL        |
      | testCode-tRes-1-0             | Annual Test |
      | testTypeEndTimestamp-tRes-1-0 | 14/01/2019  |
      | expiryDate-tRes-1-0           | 14/01/2020  |
      | certificateNumber-tRes-1-0    | 12334       |
      | testResult-tRes-1-0           | PASS        |
