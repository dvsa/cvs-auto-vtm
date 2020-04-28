Feature: System displays Seatbelt installation check section - CVSB-15040
  This AC has a dependency on PSV Tech Records being developed.
  This document is the general structure mapping for the Test Record screen, i.e. it shows where to place each section and corresponding fields on the screen. 
  (Since these fields will vary depending on the test type ID. Refer to  Use_for_dynamic_functionality.xls for more information).

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "psv" vehicle
    And I create test record with status "submitted" and result "pass" and test type "aal" for previously created vehicle

    Scenario: I want to view a Seatbelt installation check section and all relevant details on a test specific to PSVs.
    AC1 - (AC6 ON 10283): System displays Seatbelt installation check section
      When I go to search tech record page
      Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
      And search vehicle input field should be present
      When I search for previously created vehicle
      Then wait until I see "Technical record"
      When I open tech record "test history" section
      And I go to view test record with index 1
      And wait until I see "Change test record"
      Then I should see "Seatbelt installation check"
      When I expand "Seatbelt installation check" test record section
      Then I should see "Carried out during test" in "Seatbelt installation check" test record section
      And I should see "Number of seatbelts fitted" in "Seatbelt installation check" test record section
      And I should see "Most recent installation check" in "Seatbelt installation check" test record section
      And test record fields should have values
        | Field                             | Value        |
        | seatbeltInstallationCheckDate     | Yes          |
        | numberOfSeatbeltsFitted           | 2            |
        | lastSeatbeltInstallationCheckDate | 14/01/2019   |
      When I collapse "Seatbelt installation check" test record section
      Then I should not see "Carried out during test"