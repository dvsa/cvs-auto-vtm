Feature: Search tech record
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to add specific adr details

  Background:
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And element with id "searchIdentifier" should be present

  @wip
  Scenario: Search using vin for HGV with current, provisional and archived tech records
  AC1 - HGV tech records are structured correctly, ADR heading is now present
  AC2 - ADR heading contains the correct attributes
  AC3 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
  AC4 - User can see if an ADR record has documents attached
  AC5 - User clicks the call to action 'download' a document
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    Then I should see "Vehicle summary" section heading
    Then I should see "Body" section heading
    Then I should see "Weights" section heading
    Then I should see "Tyres" section heading
    Then I should see "Dimensions" section heading
    Then I should see "ADR" section heading
    Then I should see "Notes" section heading
    Then I should see "Test history" section heading
    Then I should see "Technical record history" section heading
    When I open "ADR" section
    Then trl tech record fields should have values
      | Field                        | Value                                                                                             |
      | ableToCarry                  | Yes                                                                                               |
      | aplicantDetails-name         | string                                                                                            |
      | aplicantDetails-street       | string                                                                                            |
      | aplicantDetails-town         | string                                                                                            |
      | aplicantDetails-city         | string                                                                                            |
      | aplicantDetails-postcode     | string                                                                                            |
      | ADR-type                     | Centre axle tank                                                                                  |
      | ADR-approvalDate             | 10/10/2019                                                                                        |
      | ADR-permittedDangerousGoods  | FP <61 (FL)                                                                                       |
      | ADR-compatibilityGroupJ      | -                                                                                                 |
      | ADR-additionalNotes-number   | 1\n2                                                                                              |
      | ADR-adrTypeApprovalNo        | -                                                                                                 |
      | ADR-tankManufacturer         | string                                                                                            |
      | ADR-yearOfManufacture        | 0                                                                                                 |
      | ADR-tankManufacturerSerialNo | string                                                                                            |
      | ADR-tankTypeAppNo            | string                                                                                            |
      | ADR-tankCode                 | string                                                                                            |
      | ADR-substancesPermitted      | Substances permitted under the tank code and any special provisions specified in 9 may be carried |
      | ADR-statement                | string                                                                                            |
      | ADR-productListRefNo         | -                                                                                                 |
      | ADR-productListUnNo          | -                                                                                                 |
      | ADR-productList              | -                                                                                                 |
      | ADR-specialProvisions        | string                                                                                            |
      | tc2Type                      | initial                                                                                           |
      | tc2IntermediateApprovalNo    | -                                                                                                 |
      | tc2IntermediateExpiryDate    | -                                                                                                 |
      | memosApply                   | Yes                                                                                               |
      | listStatementApplicable      | -                                                                                                 |
      | batteryListNumber            | -                                                                                                 |
      | brakeDeclarationsSeen        | -                                                                                                 |
      | brakeDeclarationIssuer       | -                                                                                                 |
      | brakeEndurance               | -                                                                                                 |
      | weight                       | -                                                                                                 |
      | declarationsSeen             | -                                                                                                 |
      | guidanceNotes                | Yes                                                                                               |
      | additionalExaminerNotes      | string                                                                                            |










