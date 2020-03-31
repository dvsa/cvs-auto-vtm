Feature: Display Adr details
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should see the adr fields in the adr section

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And element with id "test-search-vehicle" should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And element with id "searchIdentifier" should be present


  Scenario: Displaying the Adr details
  AC1 - HGV/TRL tech records are structured correctly, ADR heading is now present
  AC2 - ADR heading contains the correct attributes
  AC3 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
  AC4 - User can see if an ADR record has documents attached
  AC5 - User clicks the call to action 'view' a document
    # AC1
    When I search for vehicle with identifier "ABCDEFGH999999"
    Then wait until I see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    # AC2
    When I open "ADR" section
    Then I should see adr subsections
      | Subsection                     |
      | Applicant details              |
      | ADR details                    |
      | Tank details                   |
      | Tank inspections               |
      | Memo 07/09 (3 month extension) |
      | Tank documents                 |
      | Battery list                   |
      | Declarations seen              |
      | Certificate                    |
      | Additional ADR details         |
    Then tech record fields should have values
      | Field                         | Value                              |
      | ableToCarry                   | Yes                                |
      # Applicant details subsection
      # name and town have multiple empty spaces as value in DynamoDB, while postcode is null in DynamoDb
      | aplicantDetails-name          | -                                  |
      | aplicantDetails-street        | string                             |
      | aplicantDetails-town          | -                                  |
      | aplicantDetails-city          | string                             |
      | aplicantDetails-postcode      | -                                  |
      # ADR details subsection
      | ADR-type                      | Centre axle tank                   |
      | ADR-approvalDate              | 10/10/2019                         |
      | ADR-permittedDangerousGoods   | FP <61 (FL)                        |
      | ADR-permittedDangerousGoods   | Explosives (type 3)                |
      # compatibilityGroupJ is not present in DynamoDB (same as being null)
      | ADR-compatibilityGroupJ       | -                                  |
      | ADR-additionalNotes-number    | 1                                  |
      | ADR-additionalNotes-number    | 2                                  |
      # adrTypeApprovalNo is not present in DynamoDB (same as being null)
      | ADR-adrTypeApprovalNo         | -                                  |
      # Tank details subsection
      # tankManufacturer is null in DynamoDB
      | ADR-tankManufacturer          | -                                  |
      | ADR-yearOfManufacture         | 0                                  |
      | ADR-tankManufacturerSerialNo  | string                             |
      | ADR-tankTypeAppNo             | string                             |
      | ADR-tankCode                  | string                             |
      | ADR-substancesPermitted       | Substances permitted under the tank code and any special provisions specified in 9 may be carried |
      | ADR-statement                 | string                             |
      # productListRefNo and productListUnNo are not present in DynamoDB (same as being null)
      | ADR-productListRefNo          | -                                  |
      | ADR-productListUnNo           | -                                  |
      | ADR-productList               | string                             |
      | ADR-specialProvisions         | string                             |
      # Tank inspections subsection
      | tc2Type                       | initial                            |
      | tc2IntermediateApprovalNo     | 456789                             |
      | tc2IntermediateExpiryDate     | 30/12/2020                         |
      # Memo 07/09 (3 month extension) subsection
      | memosApply                    | Yes                                |
      # Battery list subsection
      # listStatementApplicable and batteryListNumber are not present in DynamoDB (same as being null)
      | listStatementApplicable       | -                                  |
      | batteryListNumber             | -                                  |
      # Declarations seen subsection
      # brakeDeclarationsSeen, brakeDeclarationIssuer, brakeEndurance, weight and declarationsSeen are not present in DynamoDB (same as being null)
      | brakeDeclarationsSeen         | -                                  |
      | brakeDeclarationIssuer        | -                                  |
      | brakeEndurance                | -                                  |
      | weight                        | -                                  |
      | declarationsSeen              | -                                  |
      # Certificate subsection
      | guidanceNotes                 | Yes                                |
      # Additional ADR details subsection
      | additionalExaminerNotes       | string                             |
    When I go back to search page
    And I search for vehicle with identifier "ABCDEFGH777778"
    Then wait until I see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I open "ADR" section
    Then tech record fields should have values
      | Field                         | Value                              |
      | ableToCarry                   | Yes                                |
      # Applicant details subsection
      # name and town have multiple empty spaces as value in DynamoDB, while postcode is null in DynamoDb
      | aplicantDetails-name          | Mr A N                             |
      | aplicantDetails-street        | Fox Road                           |
      | aplicantDetails-town          | London                             |
      | aplicantDetails-city          | London                             |
      | aplicantDetails-postcode      | W5 5YZ                             |
      # ADR details subsection
      | ADR-type                      | semi trailer battery               |
      # approvalDate is null in Dynamo DB
      | ADR-approvalDate              | -                                  |
      | ADR-permittedDangerousGoods   | FP <61 (FL)                        |
      | ADR-permittedDangerousGoods   | AT                                 |
      | ADR-permittedDangerousGoods   | Class 5.1 Hydrogen Peroxide (OX)   |
      | ADR-permittedDangerousGoods   | MEMU                               |
      | ADR-permittedDangerousGoods   | Carbon Disulphide                  |
      | ADR-permittedDangerousGoods   | Hydrogen                           |
      | ADR-permittedDangerousGoods   | Explosives (type 2)                |
      | ADR-permittedDangerousGoods   | Explosives (type 3)                |
      # compatibilityGroupJ is not present in DynamoDB (same as being null)
      | ADR-compatibilityGroupJ       | YES                                |
      # additionalNotes.number is an array with a null value
      | ADR-additionalNotes-number    | -                                  |
      # adrTypeApprovalNo is null in DynamoDB
      | ADR-adrTypeApprovalNo         | -                                  |
      # Tank details subsection
      # tankManufacturer is null in DynamoDB
      | ADR-tankManufacturer          | -                                  |
      | ADR-yearOfManufacture         | -                                  |
      | ADR-tankManufacturerSerialNo  | -                                  |
      | ADR-tankTypeAppNo             | -                                  |
      | ADR-tankCode                  | -                                  |
      | ADR-substancesPermitted       | Substances (class UN number and if necessary packing group and proper shipping name) may be carried |
      | ADR-statement                 | 4789237                            |
      # productListRefNo and productListUnNo are not present in DynamoDB (same as being null)
      | ADR-productListRefNo          | 111                                |
      | ADR-productListUnNo           | UN7269                             |
      | ADR-productListUnNo           | UN26289                            |
      | ADR-productList               | 789                                |
      # specialProvisions is null in Dynamo DB
      | ADR-specialProvisions         | -                                  |
      # Tank inspections subsection
      | tc2Type                       | initial                            |
      | tc2IntermediateApprovalNo     | TPE6536-01                         |
      | tc2IntermediateExpiryDate     | 01/10/2019                         |
      | tc3Type                       | periodic                           |
      | tc3PeriodicNumber             | TPE6536-02                         |
      | tc3PeriodicExpiryDate         | 01/10/2019                         |
      # Memo 07/09 (3 month extension) subsection
      | memosApply                    | Yes                                |
      # Battery list subsection
      | listStatementApplicable       | YES                                |
      | batteryListNumber             | H903                               |
      # Declarations seen subsection
      # brakeDeclarationsSeen, brakeDeclarationIssuer, brakeEndurance, weight and declarationsSeen are not present in DynamoDB (same as being null)
      | brakeDeclarationsSeen         | -                                  |
      | brakeDeclarationIssuer        | -                                  |
      | brakeEndurance                | -                                  |
      | weight                        | -                                  |
      | declarationsSeen              | -                                  |
      # Certificate subsection
      # guidance notes is empty array in Dynamo DB
      | guidanceNotes                 | -                                  |
      # Additional ADR details subsection
      # additionalExaminerNotes is null in DynamoDB
      | additionalExaminerNotes       | -                                  |
    When I go back to search page
    And I search for vehicle with identifier "A00004801"
    Then wait until I see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I open "ADR" section
    Then tech record fields should have values
      | Field                         | Value                              |
      # Declarations seen subsection
      # brakeDeclarationsSeen, brakeDeclarationIssuer, brakeEndurance, weight and declarationsSeen are not present in DynamoDB (same as being null)
      | brakeDeclarationsSeen         | -                                  |
      | brakeDeclarationIssuer        | -                                  |
      | brakeEndurance                | -                                  |
      | weight                        | -                                  |
      | declarationsSeen              | -                                  |
    #A00004801
