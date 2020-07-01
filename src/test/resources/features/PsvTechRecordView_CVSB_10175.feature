Feature: Show technical record accurately for queried psv - CVSB-10175
  As an admin user I can log in the VTM app
  And view the details of the technical records belonging to the queried psv

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "psv" vehicle
    And I create test record with status "submitted" and result "pass" and test type "lbp" for previously created vehicle

  @ci_bug @CVSB-15621 @CVSB-15579
  Scenario: I want to view detailed information for a psv, so that I can provide accurate information when a customer/VSA
  calls with questions regarding that vehicle
  AC1 -  PSV tech records are structured correctly
  AC2 -  User expands one heading
  AC3 -  User clicks the call to action to "open all" headings
  AC4 -  User clicks the call to action to "close all" headings
  AC5 -  "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
  AC6 -  Test history section is displayed based on the systemNumber of the queried vehicle
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
    And tech record fields of newly created tech record should have expected values
      | Field |
      | vin   |
      | vrm   |
    When I open all tech record sections
    Then all tech record sections should be expanded
    And I should see "View" in "Test history" tech record section
    And I should see "Speed category symbol"
    And I should see "Type Approval"
    And I should see "Brake force wheels not locked"
    And I should see "Brake force wheels up to half locked"
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | testTypeEndTimestamp-tRes-0-0 |
      | certificateNumber-tRes-0-0    |
    And tech record fields should have values
      | Field                            | Value                                            |
      # generic fields
      | status                           | Provisional                                      |
      | record-completeness              | Testable                                         |
      | vrm-0                            | PSV223344                                        |
      # PSV tech records are structured correctly
      # 'vehicle summary' section
      | vehicleType                      | PSV                                              |
      | regnDate                         | 01/01/1995                                       |
      | manufactureYear                  | 1994                                             |
      | noOfaxles                        | 2                                                |
      | dtpNumber                        | 3799A                                            |
      | parkingBrakeMrkAxle-1            | Axle 1                                           |
      | vehicleClassDescription          | Large psv(ie: greater than 23 seats)             |
      | vehicleConfiguration             | other                                            |
      | speedLimiterMrk                  | No                                               |
      | tachoExemptMrk                   | No                                               |
      | euroStandard                     | 2                                                |
      | fuelpropulsionsystem             | DieselPetrol                                     |
      | numberOfWheelsDriven             | 4                                                |
      | euVehicleCategory                | m2                                               |
      | emissionsLimit                   | 20                                               |
      | departmentalVehicleMarker        | No                                               |
      | alterationMarker                 | Yes                                              |
      | seatsLowerDeck                   | 30                                               |
      | seatsUpperDeck                   | 26                                               |
      | standingCapacity                 | 10                                               |
      | vehicleSize                      | large                                            |
      | numberOfSeatbelts                | 56                                               |
      | seatbeltInstallationApprovalDate | 02/02/2020                                       |
      # 'type approval' subsection
      | approvalType                     | NTA                                              |
      | approvalTypeNumber               | 1234                                             |
      | ntaNumber                        | 123456                                           |
      | variantNumber                    | 12345                                            |
      | variantVersionNumber             | 1234567                                          |
      | coifSerialNumber                 | 12345678                                         |
      | coifCertifierName                | 1234567890                                       |
      # 'body' section
      | bodyMake                         | Isuzu                                            |
      | bodyModel                        | X30                                              |
      | modelLiteral                     | 123                                              |
      | chassisMake                      | Isuzu                                            |
      | chassisModel                     | X40                                              |
      | bodyTypeDescription              | Other                                            |
      | functionCode                     | R                                                |
      | conversionRefNo                  | 12346                                            |
      # 'weights' section
      | grossKerbWeight                  | 40000                                            |
      | grossLadenWeight                 | 41000                                            |
      | grossGbWeight                    | 39000                                            |
      | grossDesignWeight                | 38000                                            |
      | unladenWeight                    | 37000                                            |
      | kerbWeight-1                     | 9999                                             |
      | ladenWeight-1                    | 4000                                             |
      | gbWeight-1                       | 7000                                             |
      | designWeight-1                   | 8000                                             |
      | kerbWeight-2                     | 7500                                             |
      | ladenWeight-2                    | 9000                                             |
      | gbWeight-2                       | 6500                                             |
      | designWeight-2                   | 6000                                             |
      | maxTrainGbWeight                 | 14000                                            |
      | trainDesignWeight                | 13000                                            |
      # 'tyres' section
      | speedRestriction                 | 10                                               |
      | tyreCode-1                       | 383                                              |
      | tyreSize-1                       | 385/65-22.5                                      |
      | plyRating-1                      | 1                                                |
      | speedCategorySymbol-1            | a7                                               |
      | fitmentCode-1                    | double                                           |
      | dataTrAxles-1                    | 888                                              |
      | tyreCode-2                       | 282                                              |
      | tyreSize-2                       | 380/65-22.5                                      |
      | plyRating-2                      | 2                                                |
      | speedCategorySymbol-2            | a8                                               |
      | fitmentCode-2                    | single                                           |
      | dataTrAxles-2                    | 777                                              |
      # 'brakes' section
      | brakeCode                        | brCode                                           |
      | dataTrBrakeOne                   | 312677                                           |
      | dataTrBrakeTwo                   | 98765                                            |
      | dataTrBrakeThree                 | 9876543                                          |
      | retarderBrakeOne                 | electric                                         |
      | retarderBrakeTwo                 | exhaust                                          |
      # 'brake force wheels not locked' subsection
      | serviceBrakeForceA               | 4                                                |
      | secondaryBrakeForceA             | 3                                                |
      | parkingBrakeForceA               | 2                                                |
      # 'brake force wheels up to half locked' subsection
      | serviceBrakeForceB               | 7                                                |
      | secondaryBrakeForceB             | 6                                                |
      | parkingBrakeForceB               | 5                                                |
      # 'dda' section
      | certificateIssued                | Yes                                              |
      | wheelchairCapacity               | 20                                               |
      | wheelchairFittings               | wheelchair fittings                              |
      | wheelchairLiftPresent            | No                                               |
      | wheelchairLiftInformation        | wheelchair lift info                             |
      | wheelchairRampPresent            | Yes                                              |
      | wheelchairRampInformation        | wheelchair ramp info                             |
      | minEmergencyExits                | 1                                                |
      | outswing                         | 100 cm                                           |
      | ddaSchedules                     | schedule                                         |
      | seatbeltsFitted                  | 2                                                |
      | ddaNotes                         | dda notes                                        |
      # 'dimensions' section
      | length                           | 13760                                            |
      | width                            | 2480                                             |
      | height                           | 4562                                             |
      | frontAxleToRearAxle              | 1000                                             |
      # 'applicant' section
      | applicantDetails-name            | applicant name                                   |
      | applicantDetails-address         | applicant address 1 applicant address 2          |
      | applicantDetails-postTown        | applicant post town                              |
      | applicantDetails-address3        | applicant address 3                              |
      | applicantDetails-postCode        | PO16 7GZ                                         |
      | applicantDetails-telephoneNumber | 123456                                           |
      | applicantDetails-emailAddress    | test@test.com                                    |
      # 'documents' section
      | microfilmDocumentType            | PSV Miscellaneous                                |
      | microfilmRollNumber              | 55555                                            |
      | microfilmSerialNumber            | 4444                                             |
      # 'notes' section
      | remarks                          | remarks                                          |
      | dispensations                    | dispensations                                    |
      # 'test history' section
      | testCode-tRes-0-0                | Low Emissions Certificate (Lec) With Annual Test |
      | testResult-tRes-0-0              | PASS                                             |
      | testerName-0-0                   | Test Test                                        |
      # 'technical record history' section
      | statusCode-0                     | Provisional                                      |
      | reasonForCreation-0              | Because                                          |
      | createdByName-0                  | Sean                                             |
      | createdAt-0                      | TODAYS_DATE                                      |
      | lastUpdatedByName-0              | -                                                |
      | lastUpdatedAt-0                  | -                                                |
      # field belonging to 'type approval subsection' that is not in correct format so this step will fail
      | coifDate                         | 12/12/2020                                       |
    # following lines are commented because fields were not yet removed from page
    And I should not see "Road friendly suspension"
    And I should not see "Load sensing valve"
    And I should not see "Antilock braking system"