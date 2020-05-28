Feature: Show technical record accurately for queried psv - CVSB-10175
  As an admin user I can log in the VTM app
  And view the details of the technical records belonging to the queried psv

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "psv" vehicle
    And I create test record with status "submitted" and result "pass" and test type "lbp" for previously created vehicle


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
      | Section                    |
      | Vehicle summary            |
      | Body                       |
      | Weights                    |
      | Tyres                      |
      | Brakes                     |
#      | Dimensions                 |
#      | DDA (Disability Discrimination Act)                 |
      | Applicant                  |
      | Documents                  |
      | Notes                      |
      | Test history               |
      | Technical record history   |
    And tech record sections are not displayed
      | Section                    |
#      | ADR                        |
      | Purchaser details          |
      | Manufacturer details       |
      | Authorisation into service |
      | Letters of authorisation   |
      | Plates                     |
    And tech record fields of newly created tech record should have expected values
      | Field     |
      | vin       |
      | vrm       |
    When I open all tech record sections
    Then all tech record sections should be expanded
    And I should see "View" in "Test history" tech record section
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | testTypeEndTimestamp-tRes-0-0 |
      | certificateNumber-tRes-0-0    |
    And tech record fields should have values
      | Field                                           | Value                                   |
      # generic fields
      | status                                          | Current                                 |
      | record-completeness                             | Complete                                |
      | vrm-0                                           | E5F1I00                                 |
      # PSV tech records are structured correctly
      # 'vehicle summary' section
      | vehicleType                                     | PSV                                     |
      | regnDate                                        | 01/01/1995                              |
      | manufactureYear                                 | 1994                                    |
      | noOfaxles                                       | 2                                       |
      | dtpNumber                                       | 3798A                                   |
      | parkingBrakeMrkAxle-1                           | Axle 1                                  |
      | vehicleClassDescription                         | Large psv(ie: greater than 23 seats)    |
      | vehicleConfiguration                            | other                                   |
      | speedLimiterMrk                                 | No                                      |
      | tachoExemptMrk                                  | No                                      |
      | euroStandard                                    | 2                                       |
      | fuelpropulsionsystem                            | DieselPetrol                            |
      | numberOfWheelsDriven                            | 10                                      |
      | euVehicleCategory                               | m2                                      |
      | emissionsLimit                                  | 20                                      |
      | departmentalVehicleMarker                       | No                                      |
      | alterationMarker                                | Yes                                     |
      | test-vehicleSummary-seatsLowerDeck              | 30                                      |
      | test-vehicleSummary-seatsUpperDeck              | 26                                      |
      | vehicleSummary-standingCapacity                 | 10                                      |
      | vehicleSummary-vehicleSize                      | large                                   |
      | vehicleSummary-numberOfSeatbelts                | 56                                      |
      | vehicleSummary-seatbeltInstallationApprovalDate | 02/02/2020                              |
      # 'type approval' subsection
      | approvalType                                    | NTA                                     |
      | approvalTypeNumber                              | 123456                                  |
      | ntaNumber                                       | 12345                                   |
      | variantNumber                                   | 1234                                    |
      | variantVersionNumber                            | 123                                     |
      | vehicleSummary-coifSerialNumber                 | 12345678                                |
      | vehicleSummary-coifCertifierName                | 1234567890                              |
      | vehicleSummary-coifDate                         | 12/12/2020                              |
      # 'body' section
      | make                                            | Isuzu                                   |
      | model                                           | X40                                     |
      | modelLiteral                                    | 123                                     |
      | chassisMake                                     | Isuzu                                   |
      | chassisModel                                    | X40                                     |
      | bodyTypeDescription                             | Other                                   |
      | functionCode                                    | R                                       |
      | conversionRefNo                                 | 123456                                  |
      # 'weights' section
      | grossKerbWeight                                 | 40000                                   |
      | grossLadenWeight                                | 41000                                   |
      | grossGbWeight                                   | 39000                                   |
      | grossDesignWeight                               | 38000                                   |
      | grossUnladenWeight                              | 38000                                   |
      | kerbWeight-1                                    | 9999                                    |
      | ladenWeight-1                                   | 4000                                    |
      | gbWeight-1                                      | 8000                                    |
      | designWeight-1                                  | 8000                                    |
      | kerbWeight-2                                    | 7000                                    |
      | ladenWeight-2                                   | 7000                                    |
      | gbWeight-2                                      | 7000                                    |
      | designWeight-2                                  | 7000                                    |
      | maxTrainGbWeight                                | 14000                                   |
      | maxTrainDesignWeight                            | 14000                                   |
      # 'tyres' section
      | sppedRestriction                                | 10                                      |
      | tyreCode-1                                      | 383                                     |
      | tyreSize-1                                      | 385/65-22.5                             |
      | plyRating-1                                     | 1                                       |
      | speedCategorySymbol-1                           | a7                                      |
      | fitmentCode-1                                   | double                                  |
      | dataTrAxles-1                                   | 888                                     |
      | tyreCode-2                                      | 282                                     |
      | tyreSize-2                                      | 380/65-22.5                             |
      | plyRating-2                                     | 2                                       |
      | speedCategorySymbol-2                           | a8                                      |
      | fitmentCode-2                                   | single                                  |
      | dataTrAxles-2                                   | 777                                     |
      # 'brakes' section
      | brakes-brakeCode                  | 150                                           |
      | brakes-dataTrBrakeOne                  | 150                                           |
      | brakes-dataTrBrakeOne                  | 150                                           |
      | brakes-dataTrBrakeThree                  | 150                                           |
      | brakes-retarderBrakeOne                  | 150                                           |
      | brakes-retarderBrakeTwo                  | 150                                           |
      # 'brake force wheels not locked' subsection
      | brakes-retarderBrakeTwo                    | 151                                           |
      | brakes-retarderBrakeTwo             | No                                            |
      | brakes-retarderBrakeTwo                  | 140                                           |
      # 'brake force wheels up to half locked' subsection
      | brakes-retarderBrakeTwo                   | 141                                           |
      | brakes-retarderBrakeTwo             | Yes                                           |
      | brakes-retarderBrakeTwo             | Yes                                           |
      # 'dda' section
#      | length                           | 9000                                          |
#      | width                            | 2500                                          |
#      | frontAxleToRearAxle              | 1800                                          |
      # 'dimensions' section
#      | length                           | 9000                                          |
#      | width                            | 2500                                          |
#      | frontAxleToRearAxle              | 1800                                          |
#      | axleSpacing-axles-0              | Axle 1 to 2 (mm)                              |
#      | axleSpacing-value-0              | 5000                                          |
#      | axleSpacing-axles-1              | Axle 2 to 3 (mm)                              |
#      | axleSpacing-value-1              | 6000                                          |
#      | frontAxleTo5thWheelCouplingMin   | 900                                           |
#      | frontAxleTo5thWheelCouplingMax   | 1000                                          |
#      | frontAxleTo5thWheelMin           | 400                                           |
#      | frontAxleTo5thWheelMax           | 1600                                          |
      # 'applicant' section
      | applicantDetails-name            | applicant name                                |
      | applicantDetails-address         | applicant address 1 applicant address 2       |
      | applicantDetails-postTown        | applicant post town                           |
      | applicantDetails-address3        | applicant address 3                           |
      | applicantDetails-postCode        | PO16 7GZ                                      |
      | applicantDetails-telephoneNumber | 123456                                        |
      | applicantDetails-emailAddress    | test@test.com                                 |
      # 'documents' section
      | microfilmDocumentType            | PSV COC + Int Plate                           |
      | microfilmRollNumber              | 55555                                         |
      | microfilmSerialNumber            | 4444                                          |
      # 'notes' section
      | notes                            | tech record note                              |
      # 'test history' section
      | testCode-tRes-0-0                | Part Paid Roadworthiness Retest               |
      | testResult-tRes-0-0              | PASS                                          |
      | testerName-0-0                   | Test Test                                     |
      # 'technical record history' section
      | statusCode-0                     | Provisional                                   |
      | reasonForCreation-0              | New Record                                    |
      | createdByName-0                  | Catalin                                       |
      | createdAt-0                      | TODAYS_DATE                                   |
      | lastUpdatedByName-0              | -                                             |
      | lastUpdatedAt-0                  | -                                             |
      # 'plates' section
      | plateSerialNumber-0              | 11111111                                      |
      | plateReasonForIssue-0            | Original                                      |
      | plateIssuer-0                    | Mr Jones                                      |
      | plateIssueDate-0                 | 02/02/2020                                    |
      | plateSerialNumber-1              | 22222222                                      |
      | plateReasonForIssue-1            | Replacement                                   |
      | plateIssuer-1                    | Mr Johnson                                    |
      | plateIssueDate-1                 | 01/01/2020                                    |
    And I should not see "Speed category symbol"
    And I should see "Type approval"
    And I should see "Brake force wheels not locked"
    And I should see "Brake force wheels up to half locked"