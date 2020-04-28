Feature: Show test accurately for queried vehicle - CVSB-10283
  As an admin user I can log in the VTM app
  And view the details of the tests on the test results belonging to the queried vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present


  Scenario: I want to view detailed information for a hgv LEC test(lev) with result PASS, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC1 - System displays detailed information for a Test Record
  AC2 - Suppress/Expand sections
  AC3 - Suppress/Expand an individual section
  AC4 - System displays detailed information for a hgv test record depending on test type(lev) and test result(PASS)
  AC5 - System displays Emission details section
  AC7 - Return to the Tech Record screen
    When I create "hgv" vehicle without adr details
    And I create test record with status "submitted" and result "pass" and test type "lev" for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    # AC1 + AC2
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | PASS                            |
      | testCode-tRes-0-0   | Low Emissions Certificate (Lec) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Emission details            |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Seatbelt installation check |
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should not see "Trailer ID" in "Vehicle" test record section
    And I should see "Prohibition issued" in "Test" test record section
    # AC4 + AC5
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | testExpiryDate         |
      | certificateNumber      |
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields should have values
      | Field                        | Value                                   |
      | countryOfRegistration        | Great Britain and Northern Ireland - GB |
      | euVehicleCategory            | N2                                      |
      | odometerReading              | 55,000 kilometres                       |
      | preparer                     | Durrell Vehicles Limited - BL5545       |
      | testCode                     | Lev                                     |
      | testResult                   | Pass                                    |
      # reasonForAbandoning is null in DynamoDB
      | reasonForAbandoning          | -                                       |
      # reasonForAbandoning is " " in DynamoDB
      | additionalCommentsForAbandon | -                                       |
      | prohibitionIssued            | No                                      |
      | emissionStandard             | Euro 3                                  |
      | smokeTestKLimitApplied       | 20                                      |
      | fuelType                     | Diesel                                  |
      | modType                      | P - Particulate trap                    |
      | particulateTrapFitted        | Yes                                     |
      | particulateTrapSerialNumber  | 1234                                    |
      | testStationName              | Abshire-Kub - 09-4129632                |
      | testStationType              | GVTS                                    |
      | testerName                   | Test Test                               |
      | testerEmailAddress           | test@test-station.com                   |
      | additionalNotesRecorded      | notes                                   |
    # AC2 + AC3
    When I close all test record sections
    Then I should see "Open all"
    Then all test record sections should be collapsed
    When I expand "Vehicle" test record section
    Then I should see "Vehicle identification number (VIN)"
    When I collapse "Vehicle" test record section
    Then I should not see "Vehicle identification number (VIN)"
    # AC7
    When I click "Back" link
    Then I should see "Technical record"
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |


  Scenario: I want to view detailed information for a hgv LEC test(ldv) with result FAIL, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a hgv test record, depending on test type(ldv) and test result(FAIL)
  AC5 - System does not display Emission details section if the test result is not pass for a lec test
    When I create "hgv" vehicle without adr details
    And I create test record with status "submitted" and result "fail" and test type "ldv" for previously created vehicle
    And I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
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
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Defects                     |
      | Seatbelt installation check |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should not see "Trailer ID" in "Vehicle" test record section
    And I should see "Prohibition issued" in "Test" test record section
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | testExpiryDate         |
      | certificateNumber      |
    And I should see "Certificate number"
    And I should see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields should have values
      | Field                        | Value                                   |
      | countryOfRegistration        | Great Britain and Northern Ireland - GB |
      | euVehicleCategory            | N2                                      |
      | odometerReading              | 55,000 kilometres                       |
      | preparer                     | Durrell Vehicles Limited - BL5545       |
      | testCode                     | Ldv                                     |
      | testResult                   | Fail                                    |
      # reasonForAbandoning is null in DynamoDB
      | reasonForAbandoning          | -                                       |
      # reasonForAbandoning is " " in DynamoDB
      | additionalCommentsForAbandon | -                                       |
      | prohibitionIssued            | No                                      |
      | testStationName              | Abshire-Kub - 09-4129632                |
      | testStationType              | GVTS                                    |
      | testerName                   | Test Test                               |
      | testerEmailAddress           | test@test-station.com                         |
      | additionalNotesRecorded      | notes                                   |


  Scenario: I want to view detailed information for a hgv non-LEC test(ruv) with result ABANDONED, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a hgv Test Record depending on test type(ruv) and test result(ABANDONED)
  AC5 - System does not display Emission details section if the test type is not a lec one
    When I create "hgv" vehicle without adr details
    And I create test record with status "submitted" and result "abandoned" and test type "ruv" for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | ABANDONED                       |
      | testCode-tRes-0-0   | Part Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Seatbelt installation check |
      | Emission details            |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should not see "Trailer ID" in "Vehicle" test record section
    And I should not see "Prohibition issued" in "Test" test record section
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |
    And test record fields should have values
      | Field                        | Value                                   |
      | countryOfRegistration        | Great Britain and Northern Ireland - GB |
      | euVehicleCategory            | N2                                      |
      | odometerReading              | 55,000 kilometres                       |
      | preparer                     | Durrell Vehicles Limited - BL5545       |
      | testCode                     | Ruv                                     |
      | testResult                   | Abandoned                               |
      | reasonForAbandoning          | Reason for abandoning                   |
      | additionalCommentsForAbandon | Additional comments for abandon         |
      | deficiencyRef-0              | 1000.1500 (b) (d)                       |
      | deficiencyRef-0+span         | ADVISORY                                |
      | imNumber-imDescription-0     | 1000. im description 1                  |
      | itemNumber-itemDescription-0 | 1500. item description 1                |
      | deficiencyId-0               | (b) (d) -                               |
      | location-0                   | -                                       |
      | defect-prs-0                 | Yes                                     |
      | prohibition-0                | Yes                                     |
      | additionalInfo-0             | -                                       |
      | deficiencyRef-1              | 2000.2500 (a) (m)                       |
      | deficiencyRef-1+span         | MINOR                                   |
      | imNumber-imDescription-1     | 2000. im description 2                  |
      | itemNumber-itemDescription-1 | 2500. item description 2                |
      | deficiencyId-1               | (a) (m) deficiency text 2               |
      | location-1                   | Upper/Centre/1/2                        |
      | defect-prs-1                 | No                                      |
      | prohibition-1                | No                                      |
      | additionalInfo-1             | Seatbelt missing                        |
      | testStationName              | Abshire-Kub - 09-4129632                |
      | testStationType              | GVTS                                    |
      | testerName                   | Test Test                               |
      | testerEmailAddress           | test@test-station.com                   |
      | additionalNotesRecorded      | notes                                   |


  Scenario: I want to view detailed information for a hgv non-LEC test(ruv) with result PASS, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a hgv Test Record depending on test type(ruv) and test result(PASS)
  AC5 - System does not display Emission details section if the test type is not a lec one
    When I create "hgv" vehicle without adr details
    And I create test record with status "submitted" and result "pass" and test type "ruv" without defects for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | PASS                            |
      | testCode-tRes-0-0   | Part Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Seatbelt installation check |
      | Emission details            |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should not see "Trailer ID" in "Vehicle" test record section
    And I should not see "Prohibition issued" in "Test" test record section
    And "defects" test record section should be empty
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |
    And test record fields should have values
      | Field                        | Value                                   |
      | countryOfRegistration        | Great Britain and Northern Ireland - GB |
      | euVehicleCategory            | N2                                      |
      | odometerReading              | 55,000 kilometres                       |
      | preparer                     | Durrell Vehicles Limited - BL5545       |
      | testCode                     | Ruv                                     |
      | testResult                   | Pass                                    |
      | reasonForAbandoning          | -                                       |
      | additionalCommentsForAbandon | -                                       |
      | testStationName              | Abshire-Kub - 09-4129632                |
      | testStationType              | GVTS                                    |
      | testerName                   | Test Test                               |
      | testerEmailAddress           | test@test-station.com                         |
      | additionalNotesRecorded      | notes                                   |


  Scenario: I want to view detailed information for a hgv non-LEC test(ruv) with result PRS, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a hgv Test Record depending on test type(ruv) and test result(prs)
  AC5 - System does not display Emission details section if the test type is not a lec one
    When I create "hgv" vehicle without adr details
    And I create test record with status "submitted" and result "prs" and test type "ruv" for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | PRS                             |
      | testCode-tRes-0-0   | Part Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Seatbelt installation check |
      | Emission details            |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should not see "Trailer ID" in "Vehicle" test record section
    And I should not see "Prohibition issued" in "Test" test record section
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |
    And test record fields should have values
      | Field                        | Value                                   |
      | countryOfRegistration        | Great Britain and Northern Ireland - GB |
      | euVehicleCategory            | N2                                      |
      | odometerReading              | 55,000 kilometres                       |
      | preparer                     | Durrell Vehicles Limited - BL5545       |
      | testCode                     | Ruv                                     |
      | testResult                   | Prs                                     |
      | reasonForAbandoning          | -                                       |
      | additionalCommentsForAbandon | -                                       |
      | deficiencyRef-0              | 1000.1500 (b) (d)                       |
      | deficiencyRef-0+span         | ADVISORY                                |
      | imNumber-imDescription-0     | 1000. im description 1                  |
      | itemNumber-itemDescription-0 | 1500. item description 1                |
      | deficiencyId-0               | (b) (d) -                               |
      | location-0                   | -                                       |
      | defect-prs-0                 | Yes                                     |
      | prohibition-0                | Yes                                     |
      | additionalInfo-0             | -                                       |
      | deficiencyRef-1              | 2000.2500 (a) (m)                       |
      | deficiencyRef-1+span         | MINOR                                   |
      | imNumber-imDescription-1     | 2000. im description 2                  |
      | itemNumber-itemDescription-1 | 2500. item description 2                |
      | deficiencyId-1               | (a) (m) deficiency text 2               |
      | location-1                   | Upper/Centre/1/2                        |
      | defect-prs-1                 | No                                      |
      | prohibition-1                | No                                      |
      | additionalInfo-1             | Seatbelt missing                        |
      | testStationName              | Abshire-Kub - 09-4129632                |
      | testStationType              | GVTS                                    |
      | testerName                   | Test Test                               |
      | testerEmailAddress           | test@test-station.com                   |
      | additionalNotesRecorded      | notes                                   |


  Scenario: I want to view detailed information for a trl non-LEC test(rut) with result FAIL, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a trl Test Record depending on test type(rut) and test result(FAIL)
  AC5 - System does not display Emission details section if the test type is not a lec one
    When I create "trl" vehicle without adr details
    And I create test record with status "submitted" and result "fail" and test type "rut" for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | FAIL                            |
      | testCode-tRes-0-0   | Part Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Seatbelt installation check |
      | Emission details            |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should not see "Odometer reading" in "Vehicle" test record section
    And I should see "Trailer ID" in "Vehicle" test record section
    And I should not see "Prohibition issued" in "Test" test record section
    And tech record fields of newly created tech record should have expected values
      | Field     |
      | vin       |
      | trailerId |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |
    And test record fields should have values
      | Field                        | Value                             |
      | vrm                          | -                                 |
      | countryOfRegistration        | Country Not Known                 |
      | euVehicleCategory            | O2                                |
      | preparer                     | Durrell Vehicles Limited - BL5545 |
      | testResult                   | Fail                              |
      | testCode                     | Rut                               |
      | reasonForAbandoning          | -                                 |
      | additionalCommentsForAbandon | -                                 |
      | deficiencyRef-0              | 3000.3500 (c)                     |
      | deficiencyRef-0+span         | DANGEROUS                         |
      | imNumber-imDescription-0     | 3000. im description 1            |
      | itemNumber-itemDescription-0 | 3500. item description 1          |
      | deficiencyId-0               | (c)   deficiency text 1           |
      | location-0                   | Inner/Front/1                     |
      | defect-prs-0                 | No                                |
      | prohibition-0                | No                                |
      | additionalInfo-0             | Missing trailer component         |
      | deficiencyRef-1              | 4000.4500 (d) (v)                 |
      | deficiencyRef-1+span         | MAJOR                             |
      | imNumber-imDescription-1     | 4000. im description 2            |
      | itemNumber-itemDescription-1 | 4500. item description 2          |
      | deficiencyId-1               | (d) (v) deficiency text 2         |
      | location-1                   | Upper/Centre/1/2                  |
      | defect-prs-1                 | Yes                               |
      | prohibition-1                | Yes                               |
      | additionalInfo-1             | -                                 |
      | testStationName              | Abshire-Kub - 09-4129632          |
      | testStationType              | GVTS                              |
      | testerName                   | Test Test                         |
      | testerEmailAddress           | test@test-station.com             |
      | additionalNotesRecorded      | -                                 |


  Scenario: I want to view detailed information for a trl non-LEC test(rut) with result PASS, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a trl Test Record depending on test type(rut) and test result(PASS)
  AC5 - System does not display Emission details section if the test type is not a lec one
    When I create "trl" vehicle without adr details
    And I create test record with status "submitted" and result "pass" and test type "rut" without defects for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | PASS                            |
      | testCode-tRes-0-0   | Part Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Seatbelt installation check |
      | Emission details            |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should not see "Odometer reading" in "Vehicle" test record section
    And I should see "Trailer ID" in "Vehicle" test record section
    And I should not see "Prohibition issued" in "Test" test record section
    And "defects" test record section should be empty
    And tech record fields of newly created tech record should have expected values
      | Field     |
      | vin       |
      | trailerId |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |
    And test record fields should have values
      | Field                        | Value                             |
      | countryOfRegistration        | Country Not Known                 |
      | euVehicleCategory            | O2                                |
      | preparer                     | Durrell Vehicles Limited - BL5545 |
      | testCode                     | Rut                               |
      | testResult                   | Pass                              |
      | reasonForAbandoning          | -                                 |
      | additionalCommentsForAbandon | -                                 |
      | testStationName              | Abshire-Kub - 09-4129632          |
      | testStationType              | GVTS                              |
      | testerName                   | Test Test                         |
      | testerEmailAddress           | test@test-station.com             |
      | additionalNotesRecorded      | -                                 |

  
  Scenario: I want to view detailed information for a trl non-LEC test(rut) with result PRS, so that I can provide accurate
  information when a customer/VSA calls with questions regarding a submitted test
  AC4 - System displays detailed information for a trl Test Record depending on test type(rut) and test result(prs)
  AC5 - System does not display Emission details section if the test type is not a lec one
    When I create "trl" vehicle without adr details
    And I create test record with status "submitted" and result "prs" and test type "rut" for previously created vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    When I open tech record "test history" section
    Then the "test history" tech record section should have 1 entry
    Then tech record fields should have values
      | Field               | Value                           |
      | testResult-tRes-0-0 | PRS                             |
      | testCode-tRes-0-0   | Part Paid Roadworthiness Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    # AC5
    And test record sections are not displayed
      | Section                     |
      | Seatbelt installation check |
      | Emission details            |
    # AC4
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should not see "Odometer reading" in "Vehicle" test record section
    And I should see "Trailer ID" in "Vehicle" test record section
    And I should not see "Prohibition issued" in "Test" test record section
    And tech record fields of newly created tech record should have expected values
      | Field     |
      | vin       |
      | trailerId |
    And I should see "Certificate number"
    And I should not see "Expiry date"
    And I should not see "Anniversary date"
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testEndTimestamp       |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |
    And test record fields should have values
      | Field                        | Value                             |
      | vrm                          | -                                 |
      | countryOfRegistration        | Country Not Known                 |
      | euVehicleCategory            | O2                                |
      | preparer                     | Durrell Vehicles Limited - BL5545 |
      | testResult                   | Prs                               |
      | testCode                     | Rut                               |
      | reasonForAbandoning          | -                                 |
      | additionalCommentsForAbandon | -                                 |
      | deficiencyRef-0              | 3000.3500 (c)                     |
      | deficiencyRef-0+span         | DANGEROUS                         |
      | imNumber-imDescription-0     | 3000. im description 1            |
      | itemNumber-itemDescription-0 | 3500. item description 1          |
      | deficiencyId-0               | (c)   deficiency text 1           |
      | location-0                   | Inner/Front/1                     |
      | defect-prs-0                 | No                                |
      | prohibition-0                | No                                |
      | additionalInfo-0             | Missing trailer component         |
      | deficiencyRef-1              | 4000.4500 (d) (v)                 |
      | deficiencyRef-1+span         | MAJOR                             |
      | imNumber-imDescription-1     | 4000. im description 2            |
      | itemNumber-itemDescription-1 | 4500. item description 2          |
      | deficiencyId-1               | (d) (v) deficiency text 2         |
      | location-1                   | Upper/Centre/1/2                  |
      | defect-prs-1                 | Yes                               |
      | prohibition-1                | Yes                               |
      | additionalInfo-1             | -                                 |
      | testStationName              | Abshire-Kub - 09-4129632          |
      | testStationType              | GVTS                              |
      | testerName                   | Test Test                         |
      | testerEmailAddress           | test@test-station.com             |
      | additionalNotesRecorded      | -                                 |
