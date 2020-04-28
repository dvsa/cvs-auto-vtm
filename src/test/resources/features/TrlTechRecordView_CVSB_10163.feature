Feature: Show technical record accurately for queried trailer - CVSB-10163
  As an admin user I can log in the VTM app
  And view the details of the technical records belonging to the queried trailer

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "trl" vehicle
    And I create test record with status "submitted" and result "pass" and test type "rut" for previously created vehicle


  Scenario: I want to view detailed information for a trl, so that I can provide accurate information when a customer/VSA
  calls with questions regarding that vehicle
  AC1 - TRL tech record contains all the correct headings
  AC2 - Header section contains the Record completeness and Trailer ID attributes
  AC3 - Vehicle summary section contains all the correct attributes
  AC4 - 'Authorisation into service' section contains all the correct attributes
  AC5 - 'Letters of authorisation' section contains all the correct attributes
  AC6 - Body section contains all the correct attributes
  AC7 - Weights section contains all the correct attributes
  AC8 - Weights section contains all the correct attributes
  AC9 - Brakes section contains all the correct attributes
  AC10 - Dimensions section contains all the correct attributes
  AC11 - Applicant section contains all the correct attributes
  AC12 - Purchaser section contains all the correct attributes
  AC13 - Manufacturer section contains all the correct attributes
  AC14 - Documents section contains all the correct attributes
  AC15 - Plates section contains all the correct attributes
  AC16 - 'Test type' mapping within the 'Test history' section is updated
  AC17 - Technical record history' section contains all the correct attributes
  AC18 - ADR section, "Applicant details" label is updated to "Owner/operator details"
  AC19 - Test history section is displayed based on the systemNumber of the queried vehicle
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
      | Dimensions                 |
      | ADR                        |
      | Applicant                  |
      | Purchaser                  |
      | Manufacturer               |
      | Authorisation into service |
      | Letters of authorisation   |
      | Documents                  |
      | Notes                      |
      | Test history               |
      | Technical record history   |
      | Plates                     |
    And tech record fields of newly created tech record should have expected values
      | Field     |
      | vin       |
      | vrm       |
      | trailerId |
    When I open all tech record sections
    Then all tech record sections should be expanded
    And I should see "View" in "Test history" tech record section
    And test record fields of newly created test should have correct values
      | Field                         |
      | expiryDate-tRes-0-0           |
      | testTypeEndTimestamp-tRes-0-0 |
      | certificateNumber-tRes-0-0    |
    And tech record fields should have values
      | Field                            | Value                                         |
      # generic fields
      | status                           | Provisional                                   |
      | record-completeness              | Complete                                      |
      | vrm-0                            | E5F1I00                                       |
      # TRL tech records are structured correctly
      # 'vehicle summary' section
      | vehicleType                      | TRL                                           |
      | regnDate                         | 07/06/2019                                    |
      | firstUseDate                     | 08/06/2019                                    |
      | manufactureYear                  | 2019                                          |
      | noOfaxles                        | 2                                             |
      | dtpNumber                        | 3798B                                         |
      | parkingBrakeMrkAxle-1            | Axle 1                                        |
      | parkingBrakeMrkAxle-2            | Axle 2                                        |
      | suspensionType                   | F                                             |
      | roadFriendly                     | No                                            |
      | vehicleClassDescription          | 3 wheelers                                    |
      | vehicleConfiguration             | dolly                                         |
      | couplingType                     | Y                                             |
      | maxLoadOnCoupling                | 10000                                         |
      | frameDescription                 | Other                                         |
      | euVehicleCategory                | o2                                            |
      | departmentalVehicleMarker        | Yes                                           |
      | alterationMarker                 | No                                            |
      # 'type approval' subsection
      | approvalType                     | ECTA                                          |
      | approvalTypeNumber               | 123                                           |
      | ntaNumber                        | 1234                                          |
      | variantNumber                    | 123456                                        |
      | variantVersionNumber             | 1234567                                       |
      # 'body' section
      | make                             | Volvo                                         |
      | model                            | X6                                            |
      | bodyTypeDescription              | Tipper                                        |
      | functionCode                     | R                                             |
      | conversionRefNo                  | 12345678                                      |
      # 'weights' section
      | grossGbWeight                    | 40000                                         |
      | grossEecWeight                   | 41000                                         |
      | grossDesignWeight                | 42000                                         |
      | gbWeight-1                       | 12000                                         |
      | eecWeight-1                      | 11000                                         |
      | designWeight-1                   | 10000                                         |
      | gbWeight-2                       | 22000                                         |
      | eecWeight-2                      | 21000                                         |
      | designWeight-2                   | 20000                                         |
      # 'tyres' section
      | tyreUseCode                      | 2C                                            |
      | tyreCode-1                       | 463                                           |
      | tyreSize-1                       | 11-21.5                                       |
      | plyRating-1                      | AA                                            |
      | fitmentCode-1                    | double                                        |
      | dataTrAxles-1                    | 1                                             |
      | tyreCode-2                       | 462                                           |
      | tyreSize-2                       | 10-20.5                                       |
      | plyRating-2                      | AB                                            |
      | fitmentCode-2                    | single                                        |
      | dataTrAxles-2                    | 2                                             |
      # 'brakes' section
      | loadSensingValve                 | No                                            |
      | antilockBrakingSystem            | Yes                                           |
      | brakeActuator-1                  | 150                                           |
      | leverLength-1                    | 151                                           |
      | springBrakeParking-1             | No                                            |
      | brakeActuator-2                  | 140                                           |
      | leverLength-2                    | 141                                           |
      | springBrakeParking-2             | Yes                                           |
      # 'dimensions' section
      | length                           | 10000                                         |
      | width                            | 3000                                          |
      | frontAxleToRearAxle              | 1700                                          |
      | rearAxleToRearTrl                | 400                                           |
      | centreOfRearmostAxleToRearOfTrl  | 600                                           |
      | axleSpacing-axles-1              | Axle 1 to 2 (mm)                              |
      | axleSpacing-value-1              | 11000                                         |
      | couplingCenterToRearAxleMin      | 1000                                          |
      | couplingCenterToRearAxleMax      | 900                                           |
      | couplingCenterToRearTrlMin       | 800                                           |
      | couplingCenterToRearTrlMax       | 700                                           |
      # 'ADR' section
      # 'owner/operator details' subsection
      | ableToCarry                      | Yes                                           |
      | ownerDetails-name                | name                                          |
      | ownerDetails-street              | street                                        |
      | ownerDetails-town                | town                                          |
      | ownerDetails-city                | city                                          |
      | ownerDetails-postcode            | postcode                                      |
      # 'ADR details' subsection
      | ADR-type                         | Centre Axle Battery                           |
      | ADR-approvalDate                 | 15/10/2019                                    |
      | ADR-permittedDangerousGoods-0    | FP <61 (FL)                                   |
      | ADR-permittedDangerousGoods-1    | Explosives (type 3)                           |
      | ADR-compatibilityGroupJ          | No                                            |
      | ADR-additionalNotes-number-0     | 1                                             |
      | ADR-additionalNotes-number-1     | 2                                             |
      | ADR-adrTypeApprovalNo            | 1234                                          |
      # 'tank details' subsection
      | ADR-tankManufacturer             | tank manufacturer                             |
      | ADR-yearOfManufacture            | 0                                             |
      | ADR-tankManufacturerSerialNo     | 123456                                        |
      | ADR-tankTypeAppNo                | 123                                           |
      | ADR-tankCode                     | tank code                                     |
      | ADR-substancesPermitted          | Substances permitted under the tank code and any special provisions specified in 9 may be carried |
      | ADR-statement                    | statement_1234                                |
      | ADR-productListRefNo             | productList_1234                              |
      | ADR-productListUnNo-0            | 123456                                        |
      | ADR-productListUnNo-1            | 654321                                        |
      | ADR-productList                  | additional product list details               |
      | ADR-specialProvisions            | special provisions                            |
      # 'tank inspections' subsection
      | tc2Type                          | Initial                                       |
      | tc2IntermediateApprovalNo        | 456789                                        |
      | tc2IntermediateExpiryDate        | 01/12/2020                                    |
      | tc3Type-0                        | Intermediate                                  |
      | tc3PeriodicNumber-0              | 567890                                        |
      | tc3PeriodicExpiryDate-0          | 01/06/2020                                    |
      # 'memo 07/09 (3 month extension)' subsection
      | memosApply                       | Yes                                           |
      # 'tank documents' subsection
      | document-name-0                  | -                                             |
      # 'battery list' subsection
      | listStatementApplicable          | Yes                                           |
      | batteryListNumber                | 12345                                         |
      # 'declarations seen' subsection
      | brakeDeclarationsSeen            | Yes                                           |
      | brakeDeclarationIssuer           | brake declaration issuer                      |
      | brakeEndurance                   | Yes                                           |
      | weight                           | 1500                                          |
      | declarationsSeen                 | Yes                                           |
      # 'certificate' subsection
      | guidanceNotes                    | Yes                                           |
      # 'additional ADR details' subsection
      | additionalExaminerNotes          | additional examiner notes                     |
      # 'applicant' section
      | applicantDetails-name            | applicant name                                |
      | applicantDetails-address         | applicant address 1 applicant address 2       |
      | applicantDetails-postTown        | applicant post town                           |
      | applicantDetails-address3        | applicant address 3                           |
      | applicantDetails-postCode        | PO16 7GZ                                      |
      | applicantDetails-telephoneNumber | 123456                                        |
      | applicantDetails-emailAddress    | test@test.com                                 |
      # 'purchaser' section
      | purchaser-name                   | purchaser name                                |
      | purchaser-address                | purchaser address 1 purchaser address 2       |
      | purchaser-postTown               | purchaser post town                           |
      | purchaser-address3               | purchaser address 3                           |
      | purchaser-postCode               | PO16 7GA                                      |
      | purchaser-telephoneNumber        | 12345678                                      |
      | purchaser-emailAddress           | test1@test1.com                               |
      | purchaser-faxNumber              | 87654321                                      |
      | purchaser-purchaserNotes         | purchaser notes                               |
      # 'manufacturer' section
      | manufacturer-name                | manufacturer name                             |
      | manufacturer-address             | manufacturer address 1 manufacturer address 2 |
      | manufacturer-postTown            | manufacturer post town                        |
      | manufacturer-address3            | manufacturer address 3                        |
      | manufacturer-postCode            | PO16 7GB                                      |
      | manufacturer-telephoneNumber     | 1234567890                                    |
      | manufacturer-emailAddress        | test2@test2.com                               |
      | manufacturer-faxNumber           | 0987654321                                    |
      | manufacturer-manufacturerNotes   | manufacturer notes                            |
      # 'authorisation into service' section
      | cocIssueDate                     | 25/06/2019                                    |
      | dateReceived                     | 09/06/2019                                    |
      | datePending                      | 26/06/2019                                    |
      | dateAuthorised                   | 27/06/2019                                    |
      | dateRejected                     | 28/06/2019                                    |
      # 'letters of authorisation' section
      | letterType                       | Trailer rejection                             |
      | letterDateRequested              | 24/06/2019                                    |
      | letterContents                   | letter contents                               |
      # 'documents' section
      | microfilmDocumentType            | Trailer COC + Int Plate                       |
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
    And I should not see "Max train"
    And I should see "Type Approval"