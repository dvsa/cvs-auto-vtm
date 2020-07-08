Feature: Test record screen Specialist test
  As a VTM user, I want to be able to view a specialist test record,
  so that I can provide access the information when required

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  Scenario Outline:
  AC1 - View test record
  AC2 - Certificate number
    When I create test record with status "submitted" and result "pass" and test type "<test_type>" for new "<vehicle_type>" vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record sections are displayed
      | Section                             |
      | Vehicle summary                     |
      | Body                                |
      | Weights                             |
      | Tyres                               |
      | Brakes                              |
      | Dimensions                          |
      | DDA (Disability Discrimination Act) |
      | Applicant                           |
      | Documents                           |
      | Notes                               |
      | Test history                        |
      | Technical record history            |
    And tech record sections are not displayed
      | Section                    |
      | ADR                        |
      | Purchaser details          |
      | Manufacturer details       |
      | Authorisation into service |
      | Letters of authorisation   |
      | Plates                     |
    When I open all tech record sections
    Then I should see "Close all"
    And all tech record sections should be expanded
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | certificateNumber-tRes-0-0    |
      | testerName-0-0                |
    And I should see "View" in "Test history" tech record section
    And I should see "PASS" in "Test history" tech record section
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "View certificate"
    And I should see "Test record history"
    And I should see "Back" hyperlink
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
      | Seatbelt installation check |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |

    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should see "Test type" in "Test" test record section
    And I should see "Test code" in "Test" test record section
    And I should see "Result" in "Test" test record section
    And I should see "Reason for abandoning" in "Test" test record section
    And I should see "Additional details for abandoning" in "Test" test record section
    And I should see "Certificate number" in "Test" test record section
    And I should see "Certificate number (COIF)" in "Test" test record section
    And I should see "Test number" in "Test" test record section
    And I should see "Expiry date" in "Test" test record section
    And I should see "Anniversary date" in "Test" test record section
    And I should see "Test date" in "Test" test record section
    And I should see "Start time" in "Test" test record section
    And I should see "End time" in "Test" test record section
    And I should see "Prohibition issued" in "Test" test record section
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |
      | certificateNumber      |

    Examples:
      | vehicle_type  | test_type |
      | psv           | cel       |
      | psv           | ces       |
#      | psv           | chl       |
#      | psv           | chs       |
#      | psv           | ckl       |
#      | psv           | cks       |
#      | psv           | cml       |
#      | psv           | cms       |

  Scenario Outline:
  AC1 - View test record
  AC2 - Certificate number
    When I create test record with status "submitted" and result "pass" and test type "<test_type>" for new "<vehicle_type>" vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record sections are displayed
      | Section                             |
      | Vehicle summary                     |
      | Body                                |
      | Weights                             |
      | Tyres                               |
      | Brakes                              |
      | Dimensions                          |
      | DDA (Disability Discrimination Act) |
      | Applicant                           |
      | Documents                           |
      | Notes                               |
      | Test history                        |
      | Technical record history            |
    And tech record sections are not displayed
      | Section                    |
      | ADR                        |
      | Purchaser details          |
      | Manufacturer details       |
      | Authorisation into service |
      | Letters of authorisation   |
      | Plates                     |
    When I open all tech record sections
    Then I should see "Close all"
    And all tech record sections should be expanded
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | testerName-0-0                |
    And I should see "View" in "Test history" tech record section
    And I should see "PASS" in "Test history" tech record section
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "View certificate"
    And I should see "Test record history"
    And I should see "Back" hyperlink
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
      | Seatbelt installation check |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |

    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should see "Test type" in "Test" test record section
    And I should see "Test code" in "Test" test record section
    And I should see "Result" in "Test" test record section
    And I should see "Reason for abandoning" in "Test" test record section
    And I should see "Additional details for abandoning" in "Test" test record section
    And I should see "Certificate number (COIF)" in "Test" test record section
    And I should see "Test number" in "Test" test record section
    And I should see "Test date" in "Test" test record section
    And I should see "Start time" in "Test" test record section
    And I should see "End time" in "Test" test record section
    And I should see "Prohibition issued" in "Test" test record section
    And I should not see "Expiry date" in "Test" test record section
    And I should not see "Anniversary date" in "Test" test record section
#    And I should not see "Certificate number" in "Test" test record section
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |

    Examples:
      | vehicle_type  | test_type |
      | psv           | cgl       |
      | psv           | cgs       |


  Scenario Outline:
  AC1 - View test record
  AC2 - Certificate number
    When I create test record with status "submitted" and result "pass" and test type "<test_type>" for new "<vehicle_type>" vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record sections are displayed
      | Section                             |
      | Vehicle summary                     |
      | Body                                |
      | Weights                             |
      | Tyres                               |
      | Brakes                              |
      | Dimensions                          |
      | DDA (Disability Discrimination Act) |
      | Applicant                           |
      | Documents                           |
      | Notes                               |
      | Test history                        |
      | Technical record history            |
    And tech record sections are not displayed
      | Section                    |
      | ADR                        |
      | Purchaser details          |
      | Manufacturer details       |
      | Authorisation into service |
      | Letters of authorisation   |
      | Plates                     |
    When I open all tech record sections
    Then I should see "Close all"
    And all tech record sections should be expanded
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | testerName-0-0                |
    And I should see "View" in "Test history" tech record section
    And I should see "PASS" in "Test history" tech record section
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "View certificate"
    And I should see "Test record history"
    And I should see "Back" hyperlink
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should see "Test type" in "Test" test record section
    And I should see "Test code" in "Test" test record section
    And I should see "Result" in "Test" test record section
    And I should see "Reason for abandoning" in "Test" test record section
    And I should see "Additional details for abandoning" in "Test" test record section
    And I should see "Certificate number" in "Test" test record section
    And I should see "Test number" in "Test" test record section
    And I should see "Test date" in "Test" test record section
    And I should see "Start time" in "Test" test record section
    And I should see "End time" in "Test" test record section
    And I should see "Prohibition issued" in "Test" test record section
    And I should not see "Expiry date" in "Test" test record section
    And I should not see "Anniversary date" in "Test" test record section
    And I should not see "Certificate number (COIF)" in "Test" test record section
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |

    Examples:
      | vehicle_type  | test_type |
      | psv           | ycs       |
      | psv           | ygl       |
#      | psv           | yll       |


  Scenario Outline:
  AC1 - View test record
  AC2 - Certificate number
    When I create test record with status "submitted" and result "pass" and test type "<test_type>" for new "<vehicle_type>" vehicle
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then wait until I see "Technical record"
    And tech record sections are displayed
      | Section                             |
      | Vehicle summary                     |
      | Body                                |
      | Weights                             |
      | Tyres                               |
      | Brakes                              |
      | Dimensions                          |
      | DDA (Disability Discrimination Act) |
      | Applicant                           |
      | Documents                           |
      | Notes                               |
      | Test history                        |
      | Technical record history            |
    And tech record sections are not displayed
      | Section                    |
      | ADR                        |
      | Purchaser details          |
      | Manufacturer details       |
      | Authorisation into service |
      | Letters of authorisation   |
      | Plates                     |
    When I open all tech record sections
    Then I should see "Close all"
    And all tech record sections should be expanded
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | testerName-0-0                |
    And I should see "View" in "Test history" tech record section
    And I should see "PASS" in "Test history" tech record section
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "View certificate"
    And I should see "Test record history"
    And I should see "Back" hyperlink
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Defects                     |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
    When I open all test record sections
    Then I should see "Close all"
    And all test record sections should be expanded
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    And I should see "Vehicle identification number (VIN)" in "Vehicle" test record section
    And I should see "Vehicle registration mark (VRM)" in "Vehicle" test record section
    And I should see "Odometer reading" in "Vehicle" test record section
    And I should see "Test type" in "Test" test record section
    And I should see "Test code" in "Test" test record section
    And I should see "Result" in "Test" test record section
    And I should see "Reason for abandoning" in "Test" test record section
    And I should see "Additional details for abandoning" in "Test" test record section
    And I should see "Test number" in "Test" test record section
    And I should see "Test date" in "Test" test record section
    And I should see "Start time" in "Test" test record section
    And I should see "End time" in "Test" test record section
    And I should see "Prohibition issued" in "Test" test record section
    And I should not see "Expiry date" in "Test" test record section
    And I should not see "Anniversary date" in "Test" test record section
    And I should not see "Certificate number" in "Test" test record section
    And I should not see "Certificate number (COIF)" in "Test" test record section
    And test record fields of newly created test should have expected values
      | Field                  |
      | testNumber             |
      | testTypeStartTimestamp |
      | testTypeEndTimestamp   |
      | testTypeName           |

    Examples:
      | vehicle_type  | test_type |
      | psv           | yzs       |
      | psv           | yxl       |
#      | psv           | yzl       |

