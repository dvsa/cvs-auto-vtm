Feature: As a VTM user, I want the ability to generate a certificate for a PSV/HGV,
  so that DVSA can provide the customer with a duplicate/replacement certificate

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  Scenario Outline: General certificate generation - PSV
  AC1: 'View certificate' button is available for selection
  AC2: 'View certificate' button is only available when the Test Record is in view-mode
  AC3: Ability to download a certificate (Post-implementation)
  AC4: Ability to generate a certificate
  AC8: Ability to download a VTP20 certificate
  AC9: Ability to download a VTP30 certificate
  AC10: Ability to download a VTP20 & VTP30 certificate
    #AC1
    When I create test record with status "<status>" and result "<result>" and test type "<test_type>" for new "<vehicle>" vehicle
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    And I search for previously created vehicle
    And wait until I see "Technical record"
    Then I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    And the "test history" tech record section should have 1 entry
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should be taken to the correct test record page
    And I should see "View certificate" button
    #AC2
    When I click "Change test record" button
    And I should see "Save test record"
    And I should not see "View certificate"
    And I click "Cancel" link
    Then I should see "Unsaved changes"
    When I click "Leave and lose changes" button
    Then wait until I see "Change test record"
    And I should not see "Cancel"
    And I should see "View certificate" button
    #AC3 + AC8 + AC9 + AC10
    When I click "View certificate" button
    Then I should not see "There is a problem"
    And I should not see "A digital certificate could not be found for this test. Try resaving this test record to generate a new certificate or manually issue a copy using the information on this page."
    #AC4
    When I click "Change test record" button
    Then I should see "Save test record"
    When I open all test record sections
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    And I click "Save test record" button
    And I enter "cvsb-10710" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    When I click "View certificate" button
    Then I should not see "There is a problem"
    Then I should not see "A digital certificate could not be found for this test. Try resaving this test record to generate a new certificate or manually issue a copy using the information on this page."

      Examples:
        | status    | result | test_type | vehicle |
        | submitted | pass   | aal       | psv     |
        | submitted | fail   | adl       | psv     |
        | submitted | prs    | wdl       | psv     |

  Scenario Outline: General certificate generation - HGV
  AC1: 'View certificate' button is available for selection
  AC2: 'View certificate' button is only available when the Test Record is in view-mode
  AC3: Ability to download a certificate (Post-implementation)
  AC4: Ability to generate a certificate
  A11: Ability to download a VTG5 certificate
  AC12: Ability to download a VTG30 certificate
  AC13: Ability to download a VTG5 & VTG30 certificate
    #AC1
    When I create "hgv" vehicle without adr details
    And I create test record with status "<status>" and result "<result>" and test type "<test_type>" for previously created vehicle
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    And I search for previously created vehicle
    And wait until I see "Technical record"
    Then I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    And the "test history" tech record section should have 1 entry
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should be taken to the correct test record page
    And I should see "View certificate" button
    #AC2
    When I click "Change test record" button
    And I should see "Save test record"
    And I should not see "View certificate"
    And I click "Cancel" link
    Then I should see "Unsaved changes"
    When I click "Leave and lose changes" button
    Then wait until I see "Change test record"
    And I should not see "Cancel"
    And I should see "View certificate" button
    #AC3 + AC11 + AC12 + AC13
    When I click "View certificate" button
    Then I should not see "There is a problem"
    And I should not see "A digital certificate could not be found for this test. Try resaving this test record to generate a new certificate or manually issue a copy using the information on this page."
    #AC4
    When I click "Change test record" button
    Then I should see "Save test record"
    When I open all test record sections
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    And I click "Save test record" button
    And I enter "cvsb-10710" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    When I click "View certificate" button
    Then I should not see "There is a problem"
    Then I should not see "A digital certificate could not be found for this test. Try resaving this test record to generate a new certificate or manually issue a copy using the information on this page."

      Examples:
        | status    | result | test_type |
        | submitted | pass   | ffv2      |
        | submitted | fail   | aav2      |
        | submitted | prs    | aav2      |


  Scenario Outline: General certificate generation
  AC7: Unable to download a certificate
    When I create "hgv" vehicle with adr details
    And I create test record with status "<status>" and result "<result>" and test type "<test_type>" for previously created vehicle
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    And I search for previously created vehicle
    And wait until I see "Technical record"
    Then I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    And the "test history" tech record section should have 1 entry
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "View certificate" button
    When I click "View certificate" button
    Then the header error contains "There is a problem"
    And the header error contains "A digital certificate could not be found for this test. Try resaving this test record to generate a new certificate or manually issue a copy using the information on this page."
    # Next steps are used to make sure that the certificate has not been generated in the meantime
    When I go back to previous page
    And I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    When I should see "View certificate" button
    And I click "View certificate" button
    Then the header error contains "There is a problem"
    And the header error contains "A digital certificate could not be found for this test. Try resaving this test record to generate a new certificate or manually issue a copy using the information on this page."

      Examples:
      | status    | result | test_type |
      | submitted | fail   | arv       |
      | submitted | prs    | drv       |
