Feature: CVSB-12375 - I want the ability to update an existing test record with new test type attributes, so that DVSA keeps accurate test record information
  As an admin user I can log in the VTM app
  And edit details in the test section of test types with version current, belonging to the queried vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  
  Scenario: Check buttons and hyperlinks work as expected
  AC1 - Ability to edit fields on the Test Record screen
  AC2 - Ability to notify the user that test details will be lost if they change a test type
  AC3 - 'Change' hyperlink is selected by mistake
  AC4 - Ability to select a new test type
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    When I open tech record "test history" section
    Then tech record fields should have values
      | Field               | Value     |
      | testResult-tRes-0-0 | PRS       |
      | testResult-tRes-1-0 | ABANDONED |
      | testResult-tRes-2-0 | PASS      |
    When I go to view test record with index 1
    # AC1
    Then wait until I see "Change test record"
    And I should be taken to the correct test record page
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And test record fields should have values
      | Field | Value         |
      | vin   | P012301230000 |
      | vrm   | CT70000       |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC2
    When I click "Change" link
    Then I should see "If you change the test type, some of the current test details will be lost."
    And I should see "Print a version of the current test record or save the details to refer to when entering the details for the new test type."
    And I should see "Change test type" button
    And I should see "Cancel" hyperlink in change test type modal
    # AC3
    When I click "Cancel" link in change test type modal
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And I should not see "If you change the test type, some of the current test details will be lost."
    # AC4
    When I click "Change" link
    Then I should see "Change test type" button
    When I click "Change test type" button
    Then I should be taken to the correct page for changing test type of test record
    When I go back to previous page
    Then I should see "Save test record"

  
  Scenario: Edit fields for Low Emissions Certificate (Lec) With Annual Test (group 16)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "pass" and test type "ldv" for new "hgv" vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                                            |
      | testResult-tRes-0-0 | PASS                                             |
      | testCode-tRes-0-0   | Low Emissions Certificate (Lec) With Annual Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
      | testExpiryDate    |
      | certificateNumber |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Emission details    |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | certificateNumber |
      | testExpiryDate    |
      | testTypeStartTime |
      | testTypeEndTime   |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Pass" as test result
    And I should see correct certificate number
    And I should see correct expiry date
    And I should see correct start time
    And I should see correct end time
    And I should see prohibition issued set to "No"
    When I set test result as "Fail"
    And I set certificate number as "Y123456"
    And I set expiry date to "01/06/2022"
    And I set start time to "09:6"
    And I set end time to "13:14"
    When I set prohibition issued to "Yes"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Fail       |
      | testCode                     | ldv        |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | certificateNumber            | Y123456    |
      | testExpiryDate               | 01/06/2022 |
      | testTypeStartTime            | 9:06 AM    |
      | testTypeEndTime              | 1:14 PM    |
      | prohibitionIssued            | Yes        |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Annual test (group 1)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "fail" and test type "aal" for new "psv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value       |
      | testResult-tRes-0-0 | FAIL        |
      | testCode-tRes-0-0   | Annual Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field               |
      | testNumber          |
      | testTypeEndDate     |
      | testTypeStartTime   |
      | testTypeEndTime     |
      | testTypeName        |
      | testExpiryDate      |
      | testAnniversaryDate |
      | certificateNumber   |
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section          |
      | Emission details |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | testResult             |
      | certificateNumber      |
      | testExpiryDate         |
      | testAnniversaryDate    |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "Fail" as test result
    And I should see correct certificate number
    And I should see correct expiry date
    And I should see correct anniversary date
    And I should see correct start time
    And I should see correct end time
    When I set test result as "Pass"
    And I set certificate number as "Y123456"
    And I set expiry date to "01/06/2022"
    And I set anniversary date to "01/06/2021"
    And I set start time to "16:6"
    And I set end time to "0:14"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
#    And test record sections are not displayed
#      | Section                     |
#      | Emission details            |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | aal        |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | None       |
      | certificateNumber            | Y123456    |
      | testExpiryDate               | 01/06/2022 |
      | testAnniversaryDate          | 01/06/2021 |
      | testTypeStartTime            | 4:06 PM    |
      | testTypeEndTime              | 12:14 AM   |
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |

  
  Scenario: Edit fields for Paid prohibition clearance (full inspection without certificate) test (group 2)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
  AC13 - Ability to update the Test Result to Abandoned (for a PSV)
  AC14 - Ability to update the Test Result to Abandoned (for a HGV or TRL)
  AC15 - Ability to update the Test Result to Abandoned (for a TIR test type)
    When I create test record with status "submitted" and result "prs" and test type "phl" for new "psv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                                                            |
      | testResult-tRes-0-0 | PRS                                                              |
      | testCode-tRes-0-0   | Paid Prohibition Clearance (Full Inspection Without Certificate) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field               |
      | testNumber          |
      | testTypeEndDate     |
      | testTypeStartTime   |
      | testTypeEndTime     |
      | testTypeName        |
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section          |
      | Emission details |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "PRS" as test result
    And I should see correct start time
    And I should see correct end time
    When I set test result as "Pass"
    And I set start time to "12:61"
    And I set end time to "14:59"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
#    And test record sections are not displayed
#      | Section                     |
#      | Emission details            |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | phl        |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | None       |
      | testTypeStartTime            | 1:01 PM    |
      | testTypeEndTime              | 2:59 PM    |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Voluntary brake test test (group 3)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "pass" and test type "qal" for new "psv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                |
      | testResult-tRes-0-0 | PASS                 |
      | testCode-tRes-0-0   | Voluntary Brake Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeEndDate        |
      | testTypeStartTime      |
      | testTypeEndTime        |
      | testTypeName           |
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | testTypeStartTime |
      | testTypeEndTime   |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Pass" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see prohibition issued set to "Yes"
    When I set test result as "Fail"
    And I set start time to "09:6"
    And I set end time to "13:60"
    When I set prohibition issued to "No"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Fail       |
      | testCode                     | qal        |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | None       |
      | testTypeStartTime            | 9:06 AM    |
      | testTypeEndTime              | 2:00 PM    |
      | prohibitionIssued            | No         |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Voluntary multi-check test (group 4)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "fail" and test type "qbv" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                 |
      | testResult-tRes-0-0 | FAIL                  |
      | testCode-tRes-0-0   | Voluntary Multi-check |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | testTypeStartTime |
      | testTypeEndTime   |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Fail" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see prohibition issued set to "No"
    When I set test result as "Pass"
    And I set start time to "09:6"
    And I set end time to "13:120"
    When I set prohibition issued to "Yes"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
#      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | qbv        |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 9:06 AM    |
      | testTypeEndTime              | 3:00 PM    |
      | prohibitionIssued            | Yes        |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Paid TIR retest (group 5)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "pass" and test type "trv" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value           |
      | testResult-tRes-0-0 | PASS            |
      | testCode-tRes-0-0   | Paid Tir Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeEndDate        |
      | testTypeStartTime      |
      | testTypeEndTime        |
      | testTypeName           |
      | certificateNumber      |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | testTypeStartTime |
      | testTypeEndTime   |
      | certificateNumber |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Pass" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct certificate number
    And I should see prohibition issued set to "No"
    When I set test result as "Pass"
    And I set start time to "09:6"
    And I set end time to "18:20"
    And I set certificate number as "Y123456"
    When I set prohibition issued to "Yes"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | trv        |
      | certificateNumber            | Y123456    |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 9:06 AM    |
      | testTypeEndTime              | 6:20 PM    |
      | prohibitionIssued            | Yes        |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Paid roadworthiness retest (group 6)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "pass" and test type "qpv" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                      |
      | testResult-tRes-0-0 | PASS                       |
      | testCode-tRes-0-0   | Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeEndDate        |
      | testTypeStartTime      |
      | testTypeEndTime        |
      | testTypeName           |
      | certificateNumber      |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Defects             |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | certificateNumber      |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "Pass" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct certificate number
    When I set test result as "PRS"
    And I set start time to "12:61"
    And I set end time to "14:59"
    And I set certificate number as "Y123456"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | PRS        |
      | testCode                     | qpv        |
      | certificateNumber            | Y123456    |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 1:01 PM    |
      | testTypeEndTime              | 2:59 PM    |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Paid ADR retest (group 7)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "prs" and test type "arv" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value           |
      | testResult-tRes-0-0 | PRS             |
      | testCode-tRes-0-0   | Paid Adr Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
      | testExpiryDate    |
      | certificateNumber |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testExpiryDate    |
      | certificateNumber |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "PRS" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct expiry date
    And I should see correct certificate number
    And I should see prohibition issued set to "No"
    When I set test result as "Fail"
    And I set start time to "09:6"
    And I set end time to "18:20"
    And I set expiry date to "01/06/2021"
    And I set certificate number as "Y123456"
    When I set prohibition issued to "Yes"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Fail       |
      | testCode                     | arv        |
      | testExpiryDate               | 01/06/2021 |
      | certificateNumber            | Y123456    |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 9:06 AM    |
      | testTypeEndTime              | 6:20 PM    |
      | prohibitionIssued            | Yes        |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Voluntary brake test (group 8)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "fail" and test type "qav3" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                |
      | testResult-tRes-0-0 | FAIL                 |
      | testCode-tRes-0-0   | Voluntary Brake Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeEndDate        |
      | testTypeStartTime      |
      | testTypeEndTime        |
      | testTypeName           |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | testTypeStartTime |
      | testTypeEndTime   |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Fail" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see prohibition issued set to "No"
    When I set test result as "PRS"
    And I set start time to "09:6"
    And I set end time to "18:20"
    When I set prohibition issued to "Yes"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | PRS        |
      | testCode                     | qav3       |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 9:06 AM    |
      | testTypeEndTime              | 6:20 PM    |
      | prohibitionIssued            | Yes        |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Paid prohibition clearance (retest with certification) (group 9)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "prs" and test type "p3v2" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                                                  |
      | testResult-tRes-0-0 | PRS                                                    |
      | testCode-tRes-0-0   | Paid Prohibition Clearance (Retest With Certification) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeEndDate        |
      | testTypeStartTime      |
      | testTypeEndTime        |
      | testTypeName           |
      | testExpiryDate         |
      | testAnniversaryDate    |
      | certificateNumber      |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Defects             |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And I should see "Certificate number"
#    And I should see "Expiry date"
#    And I should see "Anniversary date"
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | certificateNumber      |
      | testExpiryDate         |
      | testAnniversaryDate    |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "PRS" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct certificate number
    And I should see correct expiry date
    And I should see correct anniversary date
    When I set test result as "Fail"
    And I set start time to "12:45"
    And I set end time to "14:59"
    And I set expiry date to "01/06/2021"
    And I set anniversary date to "01/06/2022"
    And I set certificate number as "Y123456"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Fail       |
      | testCode                     | p3v2       |
      | certificateNumber            | Y123456    |
      | testExpiryDate               | 01/06/2021 |
      | testAnniversaryDate          | 01/06/2022 |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 12:45 PM   |
      | testTypeEndTime              | 2:59 PM    |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for First Test (group 10)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "prs" and test type "fft1" for new "trl" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And I should see the "trailerId" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value      |
      | testResult-tRes-0-0 | PRS        |
      | testCode-tRes-0-0   | First Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
    Then test record fields should have values
      | Field | Value |
      | vrm   | -     |
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field               |
      | testNumber          |
      | testTypeEndDate     |
      | testTypeStartTime   |
      | testTypeEndTime     |
      | testTypeName        |
      | testExpiryDate      |
      | testAnniversaryDate |
      | certificateNumber   |
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field               |
      | testNumber          |
      | testTypeEndDate     |
      | testTypeStartTime   |
      | testTypeEndTime     |
      | testTypeName        |
      | testExpiryDate      |
      | testAnniversaryDate |
      | certificateNumber   |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Defects             |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And I should see "Certificate number"
#    And I should see "Expiry date"
#    And I should see "Anniversary date"
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | certificateNumber      |
      | testExpiryDate         |
      | testAnniversaryDate    |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "PRS" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct certificate number
    And I should see correct expiry date
    And I should see correct anniversary date
    When I set test result as "Pass"
    And I set start time to "12:45"
    And I set end time to "14:59"
    And I set expiry date to "01/06/2021"
    And I set anniversary date to "01/06/2022"
    And I set certificate number as "Y123456"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
#      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | fft1       |
      | certificateNumber            | Y123456    |
      | testExpiryDate               | 01/06/2021 |
      | testAnniversaryDate          | 01/06/2022 |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 12:45 PM   |
      | testTypeEndTime              | 2:59 PM    |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Voluntary roadworthiness test (group 11)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "fail" and test type "qjt1" for new "trl" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And I should see the "trailerId" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                         |
      | testResult-tRes-0-0 | FAIL                          |
      | testCode-tRes-0-0   | Voluntary Roadworthiness Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
    Then test record fields should have values
      | Field | Value |
      | vrm   | -     |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
      | certificateNumber |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Defects             |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And I should see "Certificate number"
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | certificateNumber      |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "Fail" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct certificate number
    When I set test result as "Pass"
    And I set start time to "12:45"
    And I set end time to "14:59"
    And I set certificate number as "Y123456"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
#      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | qjt1       |
      | certificateNumber            | Y123456    |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 12:45 PM   |
      | testTypeEndTime              | 2:59 PM    |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Part paid prohibition clearance (retest without certification) (group 12)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "pass" and test type "p2t1" for new "trl" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And I should see the "trailerId" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                                                          |
      | testResult-tRes-0-0 | PASS                                                           |
      | testCode-tRes-0-0   | Part Paid Prohibition Clearance (Retest Without Certification) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
    And test record fields should have values
      | Field | Value |
      | vrm   | -     |
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Defects             |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | certificateNumber      |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "Pass" as test result
    And I should see correct start time
    And I should see correct end time
    When I set test result as "PRS"
    And I set start time to "12:45"
    And I set end time to "14:59"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | PRS        |
      | testCode                     | p2t1       |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | -          |
      | testTypeStartTime            | 12:45 PM   |
      | testTypeEndTime              | 2:59 PM    |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Free TIR retest (group 13)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "abandoned" and test type "rft" for new "trl" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And I should see the "trailerId" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value           |
      | testResult-tRes-0-0 | ABANDONED       |
      | testCode-tRes-0-0   | Free Tir Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
    And test record fields should have values
      | Field | Value |
      | vrm   | -     |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
      | certificateNumber |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | testTypeStartTime |
      | testTypeEndTime   |
      | certificateNumber |
      | prohibitionIssued |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Abandoned" as test result
    And I should see correct start time
    And I should see correct end time
    And I should see correct certificate number
    And I should see prohibition issued set to "No"
    When I set test result as "Pass"
    And I set start time to "09:6"
    And I set end time to "18:20"
    And I set certificate number as "Y123456"
    When I set prohibition issued to "Yes"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
#      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value                           |
      | testResult                   | Pass                            |
      | testCode                     | rft                             |
      | certificateNumber            | Y123456                         |
      | reasonForAbandoning          | -                               |
      | additionalCommentsForAbandon | Additional comments for abandon |
      | testTypeStartTime            | 9:06 AM                         |
      | testTypeEndTime              | 6:20 PM                         |
      | prohibitionIssued            | Yes                             |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |


  Scenario: Edit fields for Paid prohibition clearance (full inspection without certification) (group 14)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC10 - Prohibition issued only displays in the Defects section
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "abandoned" and test type "pbv2" for new "hgv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                                                              |
      | testResult-tRes-0-0 | ABANDONED                                                          |
      | testCode-tRes-0-0   | Paid Prohibition Clearance (Full Inspection Without Certification) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should not see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Defects             |
      | Visit               |
      | Notes               |
      | Test record history |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    # AC10
    And I should not see "Prohibition issued" in "Test" test record section
    And I should see "Prohibition issued" in "Defects" test record section
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field                  |
      | testResult             |
      | testTypeStartTime      |
      | testTypeEndTime        |
    # AC5 + AC6 + AC7
    And I should see "Abandoned" as test result
    And I should see correct start time
    And I should see correct end time
    When I set test result as "Fail"
    And I set start time to "12:45"
    And I set end time to "14:59"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value                           |
      | testResult                   | Fail                            |
      | testCode                     | pbv2                            |
      | reasonForAbandoning          | -                               |
      | additionalCommentsForAbandon | Additional comments for abandon |
      | testTypeStartTime            | 12:45 PM                        |
      | testTypeEndTime              | 2:59 PM                         |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |

  
  Scenario: Edit fields for Low Emissions Certificate (LEC) with annual test (group 15)
  AC5 - Ability to change the test result
  AC6 - The test number remains the same when the test record is updated
  AC7 - Ability to edit test type fields for a test that is NOT abandoned
  AC9 - Prohibition issued is updated from Yes to No
  AC12 - Unable to edit some test fields
    When I create test record with status "submitted" and result "fail" and test type "lbp" for new "psv" vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                                            |
      | testResult-tRes-0-0 | FAIL                                             |
      | testCode-tRes-0-0   | Low Emissions Certificate (Lec) With Annual Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Test record history"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field             |
      | testNumber        |
      | testTypeEndDate   |
      | testTypeStartTime |
      | testTypeEndTime   |
      | testTypeName      |
      | testExpiryDate    |
      | certificateNumber |
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
    And the "test record history" test record section should have 1 entry
    And test record fields should have values
      | Field                  | Value          |
      | testVersion-curr       | Current        |
      | reasonForCreation-curr | Test conducted |
      | createdByName-curr     | Test Test      |
      | createdAt-curr         | TODAYS_DATE    |
      | lastUpdatedByName-curr | -              |
      | lastUpdatedAt-curr     | -              |
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
      | Test record history         |
    # AC12
    And test record fields should not be editable
      | Field            |
      | vin              |
      | vrm              |
      | testTypeName     |
      | testCode         |
      | testNumber       |
      | testTypeEndDate  |
    And test record fields should be editable
      | Field             |
      | testResult        |
      | certificateNumber |
      | testExpiryDate    |
      | testTypeStartTime |
      | testTypeEndTime   |
    # AC5 + AC6 + AC7 + AC9
    And I should see "Fail" as test result
    And I should see correct certificate number
    And I should see correct expiry date
    And I should see correct start time
    And I should see correct end time
    And I should see prohibition issued set to "Yes"
    When I set test result as "Pass"
    Then test record sections are displayed
      | Section          |
      | Emission details |
    And I set certificate number as "Y123456"
    And I set expiry date to "01/06/2021"
    And I set start time to "23:9"
    And I set end time to "0:0"
    When I set prohibition issued to "No"
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-12375" as reason for test record changes
    And I confirm saving the test record changes
    Then I should see "Change test record"
    And I should not see "Cancel"
    And the "test record history" test record section should have 2 entries
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Emission details            |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Seatbelt installation check |
    And test record fields should have values
      | Field                        | Value      |
      | testResult                   | Pass       |
      | testCode                     | lbp        |
      | reasonForAbandoning          | -          |
      | additionalCommentsForAbandon | None       |
      | certificateNumber            | Y123456    |
      | testExpiryDate               | 01/06/2021 |
      | testTypeStartTime            | 11:09 PM   |
      | testTypeEndTime              | 12:00 AM   |
      | prohibitionIssued            | No         |
    And test record fields of newly created test should have expected values
      | Field      |
      | testNumber |