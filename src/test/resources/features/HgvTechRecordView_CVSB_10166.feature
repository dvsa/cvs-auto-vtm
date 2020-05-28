Feature: Show technical record accurately for queried hgv - CVSB-10166
  As an admin user I can log in the VTM app
  And view the details of the technical records belonging to the queried psv

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "hgv" vehicle
    And I create test record with status "submitted" and result "pass" and test type "ruv" for previously created vehicle


  Scenario: I want to view detailed information for a hgv, so that I can provide accurate information when a customer/VSA
  calls with questions regarding that vehicle
  AC1 -  HGV tech record contains all the correct headings
  AC2 -  Header section contains the Record completeness attribute
  AC3 -  Vehicle summary section contains all the correct attributes
  AC4 -  Weights section contains all the correct attributes
  AC5 -  Dimensions section contains all the correct attributes
  AC6 -  Applicant section contains all the correct attributes
  AC7 -  Documents section contains all the correct attributes
  AC8 -  Plates section contains all the correct attributes
  AC9 -  'Test type' mapping within the 'Test history' section is updated
  AC10 -  'Technical record history' section contains all the correct attributes
  AC11 -  ADR section, "Applicant details" label is updated to "Owner/operator details"
  AC12 -  Test history section is displayed based on the systemNumber of the queried vehicle
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
      | Dimensions                 |
      | ADR                        |
      | Applicant                  |
      | Documents                  |
      | Notes                      |
      | Test history               |
      | Technical record history   |
      | Plates                     |
    And tech record sections are not displayed
      | Section                    |
      | Brakes                     |
      | Purchaser details          |
      | Manufacturer details       |
      | Authorisation into service |
      | Letters of authorisation   |
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
      | Field                            | Value                                         |
      # generic fields
      | status                           | Provisional                                   |
      | record-completeness              | Testable                                      |
      | vrm-0                            | E5F1I00                                       |
      # HGV tech records are structured correctly
      # 'vehicle summary' section
      | vehicleType                      | HGV                                           |
      | regnDate                         | 07/06/2018                                    |
      | manufactureYear                  | 2018                                          |
      | noOfaxles                        | 3                                             |
      | dtpNumber                        | 3798B                                         |
      | parkingBrakeMrkAxle-1            | Axle 1                                        |
      | parkingBrakeMrkAxle-3            | Axle 3                                        |
      | roadFriendly                     | No                                            |
      | vehicleClassDescription          | Heavy goods vehicle                           |
      | vehicleConfiguration             | rigid                                         |
      | speedLimiterMrk                  | Yes                                           |
      | tachoExemptMrk                   | No                                            |
      | euroStandard                     | 6                                             |
      | fuelpropulsionsystem             | Hybrid                                        |
      | drawbarCouplingFitted            | Yes                                           |
      | offRoad                          | Yes                                           |
      | numberOfWheelsDriven             | 4                                             |
      | euVehicleCategory                | n2                                            |
      | emissionsLimit                   | 20                                            |
      | departmentalVehicleMarker        | Yes                                           |
      | alterationMarker                 | No                                            |
      # 'type approval' subsection
      | approvalType                     | NTA                                           |
      | approvalTypeNumber               | 123456                                        |
      | ntaNumber                        | 12345                                         |
      | variantNumber                    | 1234                                          |
      | variantVersionNumber             | 123                                           |
      # 'body' section
      | make                             | Mercedes                                      |
      | model                            | B2                                            |
      | bodyTypeDescription              | Refrigerated                                  |
      | functionCode                     | H                                             |
      | conversionRefNo                  | 1234567                                       |
      # 'weights' section
      | grossGbWeight                    | 40000                                         |
      | grossEecWeight                   | 43000                                         |
      | grossDesignWeight                | 46000                                         |
      | trainGbWeight                    | 41000                                         |
      | trainEecWeight                   | 44000                                         |
      | trainDesignWeight                | 47000                                         |
      | maxTrainGbWeight                 | 42000                                         |
      | maxTrainEecWeight                | 45000                                         |
      | maxTrainDesignWeight             | 48000                                         |
      | gbWeight-1                       | 12000                                         |
      | eecWeight-1                      | 11000                                         |
      | designWeight-1                   | 10000                                         |
      | gbWeight-2                       | 22000                                         |
      | eecWeight-2                      | 21000                                         |
      | designWeight-2                   | 20000                                         |
      | gbWeight-3                       | 7000                                          |
      | eecWeight-3                      | 6000                                          |
      | designWeight-3                   | 5000                                          |
      # 'tyres' section
      | tyreUseCode                      | 2D                                            |
      | tyreCode-1                       | 363                                           |
      | tyreSize-1                       | 11-21.5                                       |
      | plyRating-1                      | AC                                            |
      | fitmentCode-1                    | single                                        |
      | dataTrAxles-1                    | 1                                             |
      | tyreCode-2                       | 362                                           |
      | tyreSize-2                       | 10-20.5                                       |
      | plyRating-2                      | AB                                            |
      | fitmentCode-2                    | double                                        |
      | dataTrAxles-2                    | 2                                             |
      | tyreCode-3                       | 364                                           |
      | tyreSize-3                       | 12-22.5                                       |
      | plyRating-3                      | AA                                            |
      | fitmentCode-3                    | single                                        |
      | dataTrAxles-3                    | 3                                             |
      # 'dimensions' section
      | length                           | 9000                                          |
      | width                            | 2500                                          |
      | frontAxleToRearAxle              | 1800                                          |
      | axleSpacing-axles-0              | Axle 1 to 2 (mm)                              |
      | axleSpacing-value-0              | 5000                                          |
      | axleSpacing-axles-1              | Axle 2 to 3 (mm)                              |
      | axleSpacing-value-1              | 6000                                          |
      | frontAxleTo5thWheelCouplingMin   | 900                                           |
      | frontAxleTo5thWheelCouplingMax   | 1000                                          |
      | frontAxleTo5thWheelMin           | 400                                           |
      | frontAxleTo5thWheelMax           | 1600                                          |
      # 'ADR' section
      # 'owner/operator details' subsection
      | ableToCarry                      | Yes                                           |
      | ownerDetails-name                | name                                          |
      | ownerDetails-street              | street                                        |
      | ownerDetails-town                | town                                          |
      | ownerDetails-city                | city                                          |
      | ownerDetails-postcode            | postcode                                      |
      # 'ADR details' subsection
      | ADR-type                         | Rigid Tank                                    |
      | ADR-approvalDate                 | 15/10/2019                                    |
      | ADR-permittedDangerousGoods-0    | FP <61 (FL)                                   |
      | ADR-permittedDangerousGoods-1    | Hydrogen                                      |
      | ADR-compatibilityGroupJ          | Yes                                           |
      | ADR-additionalNotes-number-0     | 3                                             |
      | ADR-additionalNotes-number-1     | 1                                             |
      | ADR-adrTypeApprovalNo            | 123456                                        |
      # 'tank details' subsection
      | ADR-tankManufacturer             | tank manufacturer2                            |
      | ADR-yearOfManufacture            | 1990                                          |
      | ADR-tankManufacturerSerialNo     | 12345678                                      |
      | ADR-tankTypeAppNo                | 1234                                          |
      | ADR-tankCode                     | tank code2                                    |
      | ADR-substancesPermitted          | Substances (class UN number and if necessary packing group and proper shipping name) may be carried  |
      | ADR-statement                    | statement_12345                               |
      | ADR-productListRefNo             | productList_12345                             |
      | ADR-productListUnNo-0            | 123456                                        |
      | ADR-productListUnNo-1            | 654321                                        |
      | ADR-productList                  | additional product list details1              |
      | ADR-specialProvisions            | special provisions1                           |
      # 'tank inspections' subsection
      | tc2Type                          | Initial                                       |
      | tc2IntermediateApprovalNo        | 123456789                                     |
      | tc2IntermediateExpiryDate        | 01/12/2021                                    |
      | tc3Type-0                        | Periodic                                      |
      | tc3PeriodicNumber-0              | 34567890                                      |
      | tc3PeriodicExpiryDate-0          | 01/06/2021                                    |
      # 'memo 07/09 (3 month extension)' subsection
      | memosApply                       | -                                             |
      # 'tank documents' subsection
      | document-name-0                  | -                                             |
      # 'battery list' subsection
      | listStatementApplicable          | No                                            |
      | batteryListNumber                | -                                             |
      # 'declarations seen' subsection
      | brakeDeclarationsSeen            | No                                            |
      | brakeDeclarationIssuer           | -                                             |
      | brakeEndurance                   | Yes                                           |
      | weight                           | 1996                                          |
      | declarationsSeen                 | No                                            |
      # 'certificate' subsection
      | guidanceNotes                    | Yes                                           |
      # 'additional ADR details' subsection
      | additionalExaminerNotes          | additional examiner notes1                    |
      # 'applicant' section
      | applicantDetails-name            | applicant name                                |
      | applicantDetails-address         | applicant address 1 applicant address 2       |
      | applicantDetails-postTown        | applicant post town                           |
      | applicantDetails-address3        | applicant address 3                           |
      | applicantDetails-postCode        | PO16 7GZ                                      |
      | applicantDetails-telephoneNumber | 123456                                        |
      | applicantDetails-emailAddress    | test@test.com                                 |
      # 'documents' section
      | microfilmDocumentType            | HGV COC + Int Plate                           |
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