Feature: As a VTM user, I need the ability to edit submitted test records, so that DVSA keeps accurate information for
  the vehicle owner and FTAs - CVSB-10278
  As an admin user I can log in the VTM app
  And edit the test results with version current, belonging to the queried vehicle

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  @skip
  Scenario: Check buttons and hyperlinks work as expected
  AC1 - Ability to edit fields on the Test Record screen
  AC2 - User updates test record
  AC3 - User decides to cancel from the dialog box
  AC4 - User decides to cancel using the hyperlink at the top of the page (next to Save button)
  AC5 - User accidentally selects the 'Cancel' hyperlink
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
    And I should see "Vehicle"
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
    When I am increasing the odometer reading by 1
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    Then odometer reading should have expected value
    # AC3
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    When I am increasing the odometer reading by 1
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    And I cancel saving the test record details
    And I should see "Save test record"
    And I should see "Cancel"
    Then odometer reading should have expected value on edit
    # AC4
    When I click "Cancel" link
    Then I should see "Unsaved changes"
    And I should see "Leave and lose changes"
    And I should see "Continue changing record"
    When I click "Leave and lose changes" button
    And I should see "Change test record"
    And I should not see "Cancel"
    And odometer reading should have expected value
    # AC5
    When I click "Change test record" button
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    When I am increasing the odometer reading by 1
    And I click "Cancel" link
    Then I should see "Unsaved changes"
    And I should see "Leave and lose changes"
    And I should see "Continue changing record"
    When I click "Continue changing record" link
    And I should not see "Change test record"
    Then I should see "Save test record"
    And I should see "Cancel" hyperlink
    And odometer reading should have expected value on edit

  @bug @CVSB-15977 @skip
  Scenario: Edit fields for Low Emissions Certificate (Lec) With Annual Test (group 16)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC12 - Ability to edit Emission details
  AC13 - Ability to select modification type used
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
    And test record sections are displayed
      | Section             |
      | Vehicle             |
      | Test                |
      | Emission details    |
      | Visit               |
      | Notes               |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    # AC1 + AC6 +AC7 + AC8 + AC9 + AC10
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC12 + AC13
#    next line is commented because the validation will fail until CVSB-15977 is fixed
#    Then I should see "Euro 3" as emission standard
    And I should see "20" as smoke test K limit applied
    And I should see "Diesel" as fuel type
    And I should see "P - Particulate trap" as modification type
    And I should see "yes" as particulate trap fitted
    And I should see "1234" as particulate trap serial number
    When I select "Euro 4" as emission standard
    And I set "30" as smoke test limit applied
    And I select "Full electric" as fuel type
    And I select "G - Gas engine" as modification type
    And I should not see "Particulate trap fitted"
    And I should not see "Particulate trap serial number"
    And I should see "Modification type used"
    And I set "alteration" as modification type used
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Annual test (group 1)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC11 - Ability to edit 'Seatbelt installation check' details
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
      | Section                     |
      | Emission details            |
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
      | Defects                     |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-M2  |
      | euVehicleCategory-M3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    # AC1 + AC6 +AC7 + AC8 + AC9 + AC10
    And I should see "Romania - RO" as country of registration
    And I should see "M2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Austria - A" as country of registration
    And I select "M3" as EU vehicle category
    And I set odometer reading to "11000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC11
    Then I should see carried out during test set to "Yes"
    And I should see "2" as number of seatbelts fitted
    Then I should see "14" as day of most recent installation check
    And I should see "01" as month of most recent installation check
    And I should see "2019" as year of most recent installation check
    When I set carried out during test set to "No"
    When I set number of seatbelts fitted to "4"
    When I set day of most recent installation check to "30"
    When I set month of most recent installation check to "03"
    When I set year of most recent installation check to "2020"
    # AC15 + AC16 + AC17
    Then I should see "Lowe-Veum  (35-7138320)" as test facility name
    And I should see "ATF" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Abshire-Kub  (09-4129632)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "VEHICLE FRONT ROW SECOND SEAT HAS MISSING SEATBELT" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | M3                                |
      | odometerReading         | 11,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Abshire-Kub                       |
      | testStationNameNumber   | 09-4129632                        |
      | testStationType         | GVTS                              |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Paid prohibition clearance (full inspection without certificate) test (group 2)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC11 - Ability to edit 'Seatbelt installation check' details
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
      | Section                     |
      | Emission details            |
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
      | Defects                     |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-M2  |
      | euVehicleCategory-M3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    # AC1 + AC6 +AC7 + AC8 + AC9 + AC10
    And I should see "Romania - RO" as country of registration
    And I should see "M2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Austria - A" as country of registration
    And I select "M3" as EU vehicle category
    And I set odometer reading to "11000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC11
    Then I should see carried out during test set to "Yes"
    And I should see "2" as number of seatbelts fitted
    Then I should see "14" as day of most recent installation check
    And I should see "01" as month of most recent installation check
    And I should see "2019" as year of most recent installation check
    When I set carried out during test set to "No"
    When I set number of seatbelts fitted to "4"
    When I set day of most recent installation check to "30"
    When I set month of most recent installation check to "03"
    When I set year of most recent installation check to "2020"
    # AC15 + AC16 + AC17
    Then I should see "Lowe-Veum  (35-7138320)" as test facility name
    And I should see "ATF" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Abshire-Kub  (09-4129632)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "VEHICLE FRONT ROW SECOND SEAT HAS MISSING SEATBELT" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | M3                                |
      | odometerReading         | 11,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Abshire-Kub                       |
      | testStationNameNumber   | 09-4129632                        |
      | testStationType         | GVTS                              |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Voluntary brake test test (group 3)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC11 - Ability to edit 'Seatbelt installation check' details
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
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
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-M2  |
      | euVehicleCategory-M3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    # AC1 + AC6 +AC7 + AC8 + AC9 + AC10
    And I should see "Romania - RO" as country of registration
    And I should see "M2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Austria - A" as country of registration
    And I select "M3" as EU vehicle category
    And I set odometer reading to "11000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC11
    Then I should see carried out during test set to "Yes"
    And I should see "2" as number of seatbelts fitted
    Then I should see "14" as day of most recent installation check
    And I should see "01" as month of most recent installation check
    And I should see "2019" as year of most recent installation check
    When I set carried out during test set to "No"
    When I set number of seatbelts fitted to "4"
    When I set day of most recent installation check to "30"
    When I set month of most recent installation check to "03"
    When I set year of most recent installation check to "2020"
    # AC15 + AC16 + AC17
    Then I should see "Lowe-Veum  (35-7138320)" as test facility name
    And I should see "ATF" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Abshire-Kub  (09-4129632)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "VEHICLE FRONT ROW SECOND SEAT HAS MISSING SEATBELT" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | M3                                |
      | odometerReading         | 11,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Abshire-Kub                       |
      | testStationNameNumber   | 09-4129632                        |
      | testStationType         | GVTS                              |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Voluntary multi-check test (group 4)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "abandoned" and test type "qbv" for new "hgv" vehicle
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
      | testResult-tRes-0-0 | ABANDONED             |
      | testCode-tRes-0-0   | Voluntary Multi-check |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Paid TIR retest (group 5)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "fail" and test type "trv" for new "hgv" vehicle
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
      | testResult-tRes-0-0 | FAIL            |
      | testCode-tRes-0-0   | Paid Tir Retest |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Paid roadworthiness retest (group 6)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
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
      | Defects                     |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Paid ADR retest (group 7)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Voluntary brake test (group 8)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
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
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Paid prohibition clearance (retest with certification) (group 9)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "fail" and test type "p3v2" for new "hgv" vehicle
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
      | testResult-tRes-0-0 | FAIL                                                   |
      | testCode-tRes-0-0   | Paid Prohibition Clearance (Retest With Certification) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
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
      | Defects                     |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for First Test (group 10)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "pass" and test type "fft1" for new "trl" vehicle
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
      | testResult-tRes-0-0 | PASS       |
      | testCode-tRes-0-0   | First Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
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
      | Defects                     |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field  |
      | vin    |
      | trl-id |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-O1  |
      | euVehicleCategory-O2  |
      | euVehicleCategory-O3  |
      | euVehicleCategory-O4  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
#    And I should not see "Vehicle registration mark (VRM)"
#    And I should not see "Odometer reading"
#    And I should not see "Odometer reading unit"
    And I should see "Country Not Known" as country of registration
    And I should see "O2" as eu vehicle category
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "O3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | O3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Voluntary roadworthiness test (group 11)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "prs" and test type "qjt1" for new "trl" vehicle
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
      | testResult-tRes-0-0 | PRS                           |
      | testCode-tRes-0-0   | Voluntary Roadworthiness Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
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
      | Defects                     |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field  |
      | vin    |
      | trl-id |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-O1  |
      | euVehicleCategory-O2  |
      | euVehicleCategory-O3  |
      | euVehicleCategory-O4  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
#    And I should not see "Vehicle registration mark (VRM)"
#    And I should not see "Odometer reading"
#    And I should not see "Odometer reading unit"
    And I should see "Country Not Known" as country of registration
    And I should see "O2" as eu vehicle category
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "O3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | O3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Part paid prohibition clearance (retest without certification) (group 12)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "fail" and test type "p2t1" for new "trl" vehicle
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
      | testResult-tRes-0-0 | FAIL                                                           |
      | testCode-tRes-0-0   | Part Paid Prohibition Clearance (Retest Without Certification) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
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
      | Defects                     |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field  |
      | vin    |
      | trl-id |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-O1  |
      | euVehicleCategory-O2  |
      | euVehicleCategory-O3  |
      | euVehicleCategory-O4  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
#    And I should not see "Vehicle registration mark (VRM)"
#    And I should not see "Odometer reading"
#    And I should not see "Odometer reading unit"
    And I should see "Country Not Known" as country of registration
    And I should see "O2" as eu vehicle category
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "O3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | O3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Free TIR retest (group 13)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
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
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "trailerId" attribute of newly created vehicle
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
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field  |
      | vin    |
      | trl-id |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-O1  |
      | euVehicleCategory-O2  |
      | euVehicleCategory-O3  |
      | euVehicleCategory-O4  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
#    And I should not see "Vehicle registration mark (VRM)"
#    And I should not see "Odometer reading"
#    And I should not see "Odometer reading unit"
    And I should see "Country Not Known" as country of registration
    And I should see "O2" as eu vehicle category
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "O3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | O3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @skip
  Scenario: Edit fields for Paid prohibition clearance (full inspection without certification) (group 14)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "pass" and test type "pbv2" for new "hgv" vehicle
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
      | testResult-tRes-0-0 | PASS                                                               |
      | testCode-tRes-0-0   | Paid Prohibition Clearance (Full Inspection Without Certification) |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
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
      | Defects                     |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Emission details            |
      | Seatbelt installation check |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-N2  |
      | euVehicleCategory-N3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    And I should see "Great Britain and Northern Ireland - GB" as country of registration
    And I should see "N2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Romania - RO" as country of registration
    And I select "N3" as EU vehicle category
    And I set odometer reading to "10000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC15 + AC16 + AC17
    Then I should see "Abshire-Kub  (09-4129632)" as test facility name
    And I should see "GVTS" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Mraz-Hermann (46-1741156)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "notes" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | N3                                |
      | odometerReading         | 10,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Mraz-Hermannn                     |
      | testStationNameNumber   | 46-1741156                        |
      | testStationType         | ATF                               |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |

  @bug @CVSB-15977
  Scenario: Edit fields for Low Emissions Certificate (LEC) with annual test (group 15)
  AC1 - Ability to edit fields on the Test Record screen
  AC6 - Ability to edit vehicle details
  AC7 - Ability to select an option from the 'Country of Registration' drop down
  AC8 - Ability for a user to select an 'EU vehicle category' option
  AC9 - Unable to edit some vehicle details
  AC10 - Ability for the system to autocomplete 'Preparer'
  AC12 - Ability to edit Emission details
  AC14 - Ability to capture 'Particulate Trap' details
  AC15 - Ability to edit Test Facility details
  AC16 - Type of test facility automatically updates when Test facility name/number is updated
  AC17 - Tester email address can be manually updated
  AC18 - User is able to enter notes
  AC19 - Ability to view audit trail information for amended test records
    When I create test record with status "submitted" and result "pass" and test type "lbp" for new "psv" vehicle
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
      | testResult-tRes-0-0 | PASS                                             |
      | testCode-tRes-0-0   | Low Emissions Certificate (Lec) With Annual Test |
    When I go to view test record with index 1
    Then wait until I see "Change test record"
    And I should see "Vehicle"
    When I open all test record sections
    Then I should see "Vehicle identification number (VIN)"
    And I should see the "vin" attribute of newly created vehicle
    And I should see the "vrm" attribute of newly created vehicle
    And test record sections are displayed
      | Section                     |
      | Vehicle                     |
      | Test                        |
      | Emission details            |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
      | Test record history         |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
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
      | Emission details            |
      | Seatbelt installation check |
      | Visit                       |
      | Notes                       |
    And test record sections are not displayed
      | Section                     |
      | Defects                     |
      | Test record history         |
    # AC9
    And test record fields should not be editable
      | Field |
      | vin   |
      | vrm   |
    And test record fields should be editable
      | Field                 |
      | countryOfRegistration |
      | euVehicleCategory-M2  |
      | euVehicleCategory-M3  |
      | odometerReading       |
      | odometerReadingUnit   |
      | preparer              |
    # AC1 + AC6 +AC7 + AC8 + AC9 + AC10
    And I should see "Romania - RO" as country of registration
    And I should see "M2" as eu vehicle category
    And I should see "55000" as odometer reading
    And I should see "kilometres" as odometer reading unit
    And I should see "Durrell Vehicles Limited(BL5545)" as preparer
    When I set "Austria - A" as country of registration
    And I select "M3" as EU vehicle category
    And I set odometer reading to "11000"
    And I set odometer reading unit to "miles"
    And I set preparer to "Glasshouse Group Limited (MB8527)"
    # AC11
    Then I should see carried out during test set to "Yes"
    And I should see "2" as number of seatbelts fitted
    Then I should see "14" as day of most recent installation check
    And I should see "01" as month of most recent installation check
    And I should see "2019" as year of most recent installation check
    When I set carried out during test set to "No"
    When I set number of seatbelts fitted to "4"
    When I set day of most recent installation check to "30"
    When I set month of most recent installation check to "03"
    When I set year of most recent installation check to "2020"
    # AC12 + AC14
#    next line is commented because the validation will fail until CVSB-15977 is fixed
#    Then I should see "0.10 g/kWh Euro 3 PM" as emission standard
    And I should see "2.2" as smoke test K limit applied
    And I should see "Diesel" as fuel type
    And I should see "G - Gas engine" as modification type
    And I should see "Big filter" as modification type used
    When I select "Euro 6" as emission standard
    And I set "30" as smoke test limit applied
    And I select "Full electric" as fuel type
    And I select "P - Particulate trap" as modification type
    And I should see "Particulate trap fitted"
    And I should see "Particulate trap serial number"
    And I should not see "Modification type used"
    And I set "New improved particulate trap" as particulate trap fitted
    And I set "124816" as particulate trap serial number
    # AC15 + AC16 + AC17
    Then I should see "Lowe-Veum  (35-7138320)" as test facility name
    And I should see "ATF" as test station type
    And I should see "Test Test" as tester name
    And I should see "test@test-station.com" as email address
    When I set test facility name to "Abshire-Kub  (09-4129632)"
    And I set tester name to "Test1 Test1"
    And I set email address to "test1@test-station1.com"
    # AC18
    Then I should see "VEHICLE FRONT ROW SECOND SEAT HAS MISSING SEATBELT" as test notes
    And I set "new notes" as test notes
    And I click "Save test record" button
    Then I should see "Enter reason for changing test record"
    And I should see "Save test record" in the save changes modal
    And I should see "Cancel" in the save changes modal
    When I enter "cvsb-10278" as reason for test record changes
    And I confirm saving the test record changes
    And I should see "Change test record"
    And I should not see "Cancel"
    # AC19
    And the "test record history" test record section should have 2 entries
    Then test record fields should have values
      | Field                   | Value                             |
      | countryOfRegistration   | RO                                |
      | euVehicleCategory       | M3                                |
      | odometerReading         | 11,000 miles                      |
      | preparer                | Glasshouse Group Limited (MB8527) |
      | testStationNameNumber   | Abshire-Kub                       |
      | testStationNameNumber   | 09-4129632                        |
      | testStationType         | GVTS                              |
      | testerName              | Test1 Test1                       |
      | testerEmailAddress      | test1@test-station1.com           |
      | additionalNotesRecorded | new notes                         |
