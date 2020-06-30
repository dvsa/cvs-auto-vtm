Feature: CVSB-10083 - Display Adr details
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should see the adr fields in the adr section

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present

  @feature_bug @CVSB-16813
  Scenario: Displaying the Adr details
  AC1 - HGV/TRL tech records are structured correctly, ADR heading is now present
  AC2 - ADR heading contains the correct attributes
  AC3 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
    # AC1
    When I search for vehicle with identifier "ABCDEFGH999999"
    Then I should see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    # AC2 + AC3
    When I open tech record "ADR" section
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
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
      # Owner/operator details subsection
      # name and town have multiple empty spaces as value in DynamoDB, while postcode is null in DynamoDb
      | ownerDetails-name             | -                                  |
      | ownerDetails-street           | string                             |
      | ownerDetails-town             | -                                  |
      | ownerDetails-city             | string                             |
      | ownerDetails-postcode         | -                                  |
      # ADR details subsection
      | ADR-type                      | Centre Axle Tank                   |
      | ADR-approvalDate              | 10/10/2019                         |
      | ADR-permittedDangerousGoods   | FP <61 (FL)                        |
      | ADR-permittedDangerousGoods   | Explosives (type 3)                |
      # compatibilityGroupJ is not present in DynamoDB (same as being null)
      | ADR-compatibilityGroupJ       | -                                  |
      | ADR-additionalNotes-number-0  | 1                                  |
      | ADR-additionalNotes-number-1  | 2                                  |
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
      | tc2Type                       | Initial                            |
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
    When I open tech record "ADR" section
    Then tech record fields should have values
      | Field                         | Value                              |
      | ableToCarry                   | Yes                                |
      # Owner/operator details subsection
      # name and town have multiple empty spaces as value in DynamoDB, while postcode is null in DynamoDb
      | ownerDetails-name             | Mr A N                             |
      | ownerDetails-street           | Fox Road                           |
      | ownerDetails-town             | London                             |
      | ownerDetails-city             | London                             |
      | ownerDetails-postcode         | W5 5YZ                             |
      # ADR details subsection
      | ADR-type                      | Semi Trailer Battery               |
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
      | ADR-compatibilityGroupJ       | Yes                                |
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
      | ADR-productListUnNo-0         | UN7269                             |
      | ADR-productListUnNo-1         | UN26289                            |
      | ADR-productList               | 789                                |
      # specialProvisions is null in Dynamo DB
      | ADR-specialProvisions         | -                                  |
      # Tank inspections subsection
      | tc2Type                       | Initial                            |
      | tc2IntermediateApprovalNo     | TPE6536-01                         |
      | tc2IntermediateExpiryDate     | 01/10/2019                         |
      | tc3Type-0                     | Periodic                           |
      | tc3PeriodicNumber-0           | TPE6536-02                         |
      | tc3PeriodicExpiryDate-0       | 01/10/2019                         |
      # Memo 07/09 (3 month extension) subsection
      | memosApply                    | Yes                                |
      # Battery list subsection
      | listStatementApplicable       | Yes                                |
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
    And I search for vehicle with identifier "A00128821"
    Then wait until I see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I open tech record "ADR" section
    Then tech record fields should have values
      | Field                         | Value                              |
      # Tank details subsection
      # tankManufacturer is null in DynamoDB
      | ADR-tankManufacturer          | ROAD TANKER NORTHERN               |
      | ADR-yearOfManufacture         | 2007                               |
      | ADR-tankManufacturerSerialNo  | 07-1534                            |
      | ADR-tankTypeAppNo             | GB/FT/RSA/1134                     |
      | ADR-tankCode                  | LGBF                               |
      | ADR-substancesPermitted       | B                                  |
      | ADR-statement                 | B                                  |
      # Declarations seen subsection
      # brakeDeclarationsSeen, brakeDeclarationIssuer, brakeEndurance, weight and declarationsSeen are not present in DynamoDB (same as being null)
      | brakeDeclarationsSeen         | Yes                                |
      | brakeDeclarationIssuer        | -                                  |
      | brakeEndurance                | Yes                                |
      | weight                        | 29500                              |
      | declarationsSeen              | Yes                                |

  @feature_bug @CVSB-16813
  Scenario: Tank documents
  AC4 - User can see if an ADR record has documents attached
  AC5 - User clicks the call to action 'view' a document
    # AC4
    When I search for vehicle with identifier "ABCDEFGH654321"
    Then wait until I see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    When I upload adr document
    Then I confirm adr document is uploaded
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10083" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should not see "Save technical record"
    And I should not see "There is a problem"
    Then I confirm adr document is added on the tank details
    # AC5
    When I download tank document with index 1
    Then I should not see "There is a problem"
    And I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    And I remove all adr documents
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10083" as reason for tech record changes
    And I confirm saving the tech record changes
    And I should not see "Save technical record"
    Then I confirm adr documents are deleted from the tank details
    Then I should see "-" in the adr "Tank documents" subsection
