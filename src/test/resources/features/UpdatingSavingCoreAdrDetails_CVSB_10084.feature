Feature: CVSB-10084 - Updating and saving core adrDetails
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to update and save adr details

  Scenario: User adds adr details on a vehicle without ADR details
  AC1 - User clicks the call to action to change the technical record
  AC2 - User clicks the call to action to cancel the change
  AC3 - Technical record DOES NOT already have ADR details on it
  AC5 - User is presented with the adr fields for updating (this is the initial list of fields, before the vehicle type is chosen)
  AC6 - User enters the remaining details for their vehicle type
  AC9 - User backs out of actually saving the ADR details, after being presented with "Enter reason for changing technical record" modal
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "hgv" vehicle without adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then I should see "Technical record"
    And I should see "Change technical record"
    And I should see "ADR" section heading
    And I should see the "vin" of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "Technical record history" section
    When I open tech record "ADR" section
    And tech record fields should have values
      | Field                         | Value                              |
      | status                        | Provisional                        |
      # Adr details subsection
      | ableToCarry                   | No                                 |
      # Tech record history subsection
      | statusCode-0                  | Provisional                        |
      | reasonForCreation-0           | Something                          |
      | createdByName-0               | Sean                               |
      | createdAt-0                   | TODAYS_DATE                        |
    # AC1
    And I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    # AC2
    When I set the vehicle to be able to carry dangerous goods
    And I click "Cancel" link
    And I should not see "ADR details"
    Then tech record fields should have values
      | Field                         | Value                              |
      | ableToCarry                   | No                                 |
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    # AC3 + AC5
    When I set the vehicle to be able to carry dangerous goods
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
    When I fill in applicant name with "Bruce Lee"
    And I fill in applicant street with "10 Downing Street"
    And I fill in applicant town with "Luton"
    And I fill in applicant city with "London"
    And I fill in applicant postcode with "SW1A 2AA"
    And I select "Rigid tank" adr vehicle type
    Then I should not see "Battery list applicable"
    When I set processed date to "20/05/1996"
    And I select "Hydrogen" dangerous good
    And I select "Explosives (type 2)" dangerous good
    Then I should see "Compatibility group J"
    When I set compatibility group J to "Yes"
    And I fill in adr approval type number with "555666"
    And I select "1" guidance note
    And I select "V1B" guidance note
    And I fill in tank make with "tankMake"
    And I fill in tank year of manufacture with "2019"
    And I fill in tank manufacturer serial number with "987654"
    And I fill in tank manufacturer type approval number with "567890"
    And I fill in tank code with "CODE"
    And I select substances permitted "Substances permitted" option
    And I fill in special provisions with "Provisions"
    And I add initial inspection with certificate "123456" and expiry date "20/07/2021"
    And I add subsequent inspection of type "Periodic" with certificate "12345678" and expiry date "20/08/2021"
    And I set memo 07/09 to "Yes"
    And I upload adr document
    And I confirm adr document is uploaded
    And I select "Owner/operator declaration" checkbox
    And I set certificate required to "Yes"
    And I fill in additional adr details with "examiner note"
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10084" as reason for tech record changes
    And I confirm saving the tech record changes
    And I should not see "Save technical record"
    And I should not see "There is a problem"
    And I should see adr subsections
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
      | ownerDetails-name             | Bruce Lee                          |
      | ownerDetails-street           | 10 Downing Street                  |
      | ownerDetails-town             | Luton                              |
      | ownerDetails-city             | London                             |
      | ownerDetails-postcode         | SW1A 2AA                           |
      # ADR details subsection
      | ADR-type                      | Rigid Tank                         |
      | ADR-approvalDate              | 20/05/1996                         |
      | ADR-permittedDangerousGoods-0 | Hydrogen                           |
      | ADR-permittedDangerousGoods-1 | Explosives (type 2)                |
      | ADR-compatibilityGroupJ       | Yes                                |
      | ADR-adrTypeApprovalNo         | 555666                             |
      | ADR-additionalNotes-number-0  | 1                                  |
      | ADR-additionalNotes-number-1  | V1B                                |
      # Tank details subsection
      | ADR-tankManufacturer          | tankMake                           |
      | ADR-yearOfManufacture         | 2019                               |
      | ADR-tankManufacturerSerialNo  | 987654                             |
      | ADR-tankTypeAppNo             | 567890                             |
      | ADR-tankCode                  | CODE                               |
      | ADR-substancesPermitted       | Substances permitted under the tank code and any special provisions specified in 9 may be carried |
      | ADR-statement                 | -                                  |
      | ADR-productListRefNo          | -                                  |
      | ADR-productListUnNo           | -                                  |
      | ADR-productList               | -                                  |
      | ADR-specialProvisions         | Provisions                         |
      # Tank inspections subsection
      | tc2Type                       | Initial                            |
      | tc2IntermediateApprovalNo     | 123456                             |
      | tc2IntermediateExpiryDate     | 20/07/2021                         |
      | tc3Type-0                     | Periodic                           |
      | tc3PeriodicNumber-0           | 12345678                           |
      | tc3PeriodicExpiryDate-0       | 20/08/2021                         |
      # Memo 07/09 (3 month extension) subsection
      | memosApply                    | Yes                                |
      # Tank documents section
      | document-name-0               | sample.pdf                         |
      | document-view-0               | View                               |
      # Battery list subsection
      | listStatementApplicable       | -                                  |
      | batteryListNumber             | -                                  |
      # Declarations seen subsection
      | brakeDeclarationsSeen         | -                                  |
      | brakeDeclarationIssuer        | -                                  |
      | brakeEndurance                | -                                  |
      | weight                        | -                                  |
      | declarationsSeen              | Yes                                |
      # Certificate subsection
      | guidanceNotes                 | Yes                                |
      # Additional ADR details subsection
      | additionalExaminerNotes       | examiner note                      |
      # Tech record history subsection
      | statusCode-0                  | Provisional                        |
      | reasonForCreation-0           | Cvsb-10084                         |
      | createdByName-0               | VTM_USER_EMAIL                     |
      | createdAt-0                   | TODAYS_DATE                        |
      | statusCode-1                  | Archived                           |
      | reasonForCreation-1           | Something                          |
      | createdByName-1               | Sean                               |
      | createdAt-1                   | TODAYS_DATE                        |
      | lastUpdatedByName-1           | VTM_USER_EMAIL                     |
      | lastUpdatedAt-1               | TODAYS_DATE                        |
    When  I click the change technical record button
    Then I should see "Save technical record"
    Then I should see "Cancel" hyperlink
    Then I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
      | ADR details                    |
      | Tank details                   |
      | Tank inspections               |
      | Memo 07/09 (3 month extension) |
      | Tank documents                 |
      | Declarations seen              |
      | Certificate                    |
      | Additional ADR details         |
    Then I should not see adr subsections
      | Subsection                     |
      | Battery list                   |
    # AC6
    When I set processed date to "13/13/20200"
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10084" as reason for tech record changes
    And I confirm saving the tech record changes
    And I should see "Save technical record"
    And I should see "There is a problem"
    When I set the vehicle to not be able to carry dangerous goods
    Then I should not see "ADR details"
    When I click "Cancel" link
    # AC9
    Then I should see "Change technical record"
    And I should see "ADR details"
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see "Cancel" hyperlink
    When I set the vehicle to not be able to carry dangerous goods
    Then I should not see "ADR details"
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10084" as reason for tech record changes
    And I cancel saving the tech record details
    Then I should not see "Enter reason for changing technical record"
    And I should not see "There is a problem"
    When I click "Cancel" link
    Then I should see "Change technical record"
    And I should see adr subsections
      | Subsection                     |
      | Owner/operator details         |
      | ADR details                    |
      | Tank details                   |
      | Tank inspections               |
      | Memo 07/09 (3 month extension) |
      | Tank documents                 |
      | Declarations seen              |
      | Certificate                    |
      | Additional ADR details         |
      | Battery list                   |

  @feature_bug @CVSB-16818
  Scenario: User updates adr details on a vehicle with ADR details
  AC4 - Technical record DOES already have ADR details on it
  AC6 - User enters the remaining details for their vehicle type
  AC7 - User clicks the call to action to save the ADR details, is presented with "Enter reason for changing technical record" modal
  AC8 - User actually saves the ADR details (New technical record is created, existing technical record gets archived, audit fields get set on both)
  AC9 - User backs out of actually saving the ADR details, after being presented with "Enter reason for changing technical record" modal
    # AC4
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "hgv" vehicle with adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then I should see "Technical record"
    And I should see "ADR" section heading
    And I should see the "vin" of newly created vehicle
    And I should see the "vrm" of newly created vehicle
    When I open tech record "Technical record history" section
    And tech record fields should have values
      | Field                         | Value                              |
      | status                        | Provisional                        |
      # Tech record history subsection
      | statusCode-0                  | Provisional                        |
      | reasonForCreation-0           | Something                          |
      | createdByName-0               | Sean                               |
      | createdAt-0                   | TODAYS_DATE                        |
    Then I should see "Change technical record"
    When I open tech record "ADR" section
    And I should see "-" in the adr "Tank documents" subsection
    And tech record fields should have values
      | Field                         | Value                              |
      # Owner/operator details subsection
      | ownerDetails-name             | string                             |
      | ownerDetails-street           | string                             |
      | ownerDetails-town             | string                             |
      | ownerDetails-city             | string                             |
      | ownerDetails-postcode         | string                             |
      # ADR details subsection
      | ADR-type                      | Centre Axle Battery                |
      | ADR-approvalDate              | 15/10/2019                         |
      | ADR-permittedDangerousGoods-0 | FP <61 (FL)                        |
      | ADR-compatibilityGroupJ       | -                                  |
      | ADR-adrTypeApprovalNo         | -                                  |
      | ADR-additionalNotes-number-0  | 1                                  |
      | ADR-additionalNotes-number-1  | 2                                  |
      # Tank details subsection
      | ADR-tankManufacturer          | string                             |
      | ADR-yearOfManufacture         | 0                                  |
      | ADR-tankManufacturerSerialNo  | string                             |
      | ADR-tankTypeAppNo             | string                             |
      | ADR-tankCode                  | string                             |
      | ADR-substancesPermitted       | Substances permitted under the tank code and any special provisions specified in 9 may be carried |
      | ADR-statement                 | statement                          |
      | ADR-productListRefNo          | -                                  |
      | ADR-productListUnNo           | -                                  |
      | ADR-productList               | product list                       |
      | ADR-specialProvisions         | string                             |
      # Tank inspections subsection
      | tc2Type                       | Initial                            |
      | tc2IntermediateApprovalNo     | -                                  |
      | tc2IntermediateExpiryDate     | -                                  |
      # Memo 07/09 (3 month extension) subsection
      | memosApply                    | Yes                                |
      # Battery list subsection
      | listStatementApplicable       | -                                  |
      | batteryListNumber             | -                                  |
      # Declarations seen subsection
      | brakeDeclarationsSeen         | Yes                                |
      | brakeDeclarationIssuer        | dvsa                               |
      | brakeEndurance                | Yes                                |
      | weight                        | 1500                               |
      | declarationsSeen              | -                                  |
      # Certificate subsection
      | guidanceNotes                 | Yes                                |
      # Additional ADR details subsection
      | additionalExaminerNotes       | string                             |
    When I click the change technical record button
    Then I should see "Save technical record"
    And I should see adr subsections
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
    When I fill in applicant name with "Bruce Lee"
    And I fill in applicant street with "10 Downing Street"
    And I fill in applicant town with "Luton"
    And I fill in applicant city with "London"
    And I fill in applicant postcode with "SW1A 2AA"
    And I select "Rigid skeletal" adr vehicle type
    Then I should not see "Tank details"
    And I should not see adr subsections
      | Subsection                     |
      | Tank details                   |
      | Tank inspections               |
      | Memo 07/09 (3 month extension) |
      | Tank documents                 |
      | Battery list                   |
    And I set processed date to "20/05/1996"
    And I click "Cancel" link
    Then I should not see "Save technical record"
    And tech record fields should have values
      | Field                         | Value                              |
      # Owner/operator details subsection
      | ownerDetails-name             | string                             |
      | ownerDetails-street           | string                             |
      | ownerDetails-town             | string                             |
      | ownerDetails-city             | string                             |
      | ownerDetails-postcode         | string                             |
      # ADR details subsection
      | ADR-type                      | Centre Axle Battery                |
      | ADR-approvalDate              | 15/10/2019                         |
    # AC6
    When I click the change technical record button
    Then I should see "Save technical record"
    When I fill in applicant name with "Bruce Lee"
    And I fill in applicant street with "10 Downing Street"
    And I fill in applicant town with "Luton"
    And I fill in applicant city with "London"
    And I fill in applicant postcode with "SW1A 2AA"
    When I set processed date to "20/05/1996"
    And I select "Hydrogen" dangerous good
    And I select "Explosives (type 3)" dangerous good
    Then I should see "Compatibility group J"
    When I set compatibility group J to "No"
    And I fill in adr approval type number with "555666"
    And I select "3" guidance note
    And I select "T1B" guidance note
    And I fill in tank make with "tankMake"
    And I fill in tank year of manufacture with "2019"
    And I fill in tank manufacturer serial number with "987654"
    And I fill in tank manufacturer type approval number with "567890"
    And I fill in tank code with "CODE"
    Then I should not see "Statement"
    And I should not see "Product list"
    And I select substances permitted "class UN number" option
    Then I should see "Statement"
    And I should see "Product list"
    When I select "Product list" from tank statement
    And I input "12345678" as product list reference number
    And I input "UN333" as new UN number
    And I add UN number "UN444"
    And I fill in additional product list details with "product list details"
    And I fill in special provisions with "Provisions"
    And I add initial inspection with certificate "123456" and expiry date "20/07/2021"
    And I add subsequent inspection of type "Exceptional" with certificate "12345678" and expiry date "20/08/2021"
    And I set memo 07/09 to "No"
    And I upload adr document
    And I confirm adr document is uploaded
    And I set battery list applicable to "Yes"
    And I input "567890" as battery list reference number
    And I select "Manufacturer brake declaration" checkbox
    Then I should see "Issuer"
    And I should see "Brake endurance"
    When I fill in issuer with "Issuer"
    And I select "Brake endurance" checkbox
    Then I should see "Weight(kg)"
    When I fill in brake weight with 1000
    And I set certificate required to "No"
    And I fill in additional adr details with "examiner note"
    # AC7 + AC8
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10084" as reason for tech record changes
    And I confirm saving the tech record changes
    And I should not see "Save technical record"
    And I should not see "There is a problem"
    And I should see adr subsections
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
      | ownerDetails-name             | Bruce Lee                          |
      | ownerDetails-street           | 10 Downing Street                  |
      | ownerDetails-town             | Luton                              |
      | ownerDetails-city             | London                             |
      | ownerDetails-postcode         | SW1A 2AA                           |
      # ADR details subsection
      | ADR-type                      | Centre Axle Battery                |
      | ADR-approvalDate              | 20/05/1996                         |
      | ADR-permittedDangerousGoods-0 | FP <61 (FL)                        |
      | ADR-permittedDangerousGoods-1 | Hydrogen                           |
      | ADR-permittedDangerousGoods-2 | Explosives (type 3)                |
      | ADR-compatibilityGroupJ       | No                                 |
      | ADR-adrTypeApprovalNo         | 555666                             |
      | ADR-additionalNotes-number-0  | 1                                  |
      | ADR-additionalNotes-number-1  | 2                                  |
      | ADR-additionalNotes-number-2  | 3                                  |
      | ADR-additionalNotes-number-3  | T1B                                |
      # Tank details subsection
      | ADR-tankManufacturer          | tankMake                           |
      | ADR-yearOfManufacture         | 2019                               |
      | ADR-tankManufacturerSerialNo  | 987654                             |
      | ADR-tankTypeAppNo             | 567890                             |
      | ADR-tankCode                  | CODE                               |
      | ADR-substancesPermitted       | Substances (Class UN number and if necessary packing group and proper shipping name) may be carried  |
      | ADR-statement                 | -                                  |
      | ADR-productListRefNo          | 12345678                           |
      | ADR-productListUnNo-0         | UN333                              |
      | ADR-productListUnNo-1         | UN444                              |
      | ADR-productList               | product list details               |
      | ADR-specialProvisions         | Provisions                         |
      # Tank inspections subsection
      | tc2Type                       | Initial                            |
      | tc2IntermediateApprovalNo     | 123456                             |
      | tc2IntermediateExpiryDate     | 20/07/2021                         |
      | tc3Type-0                     | Exceptional                        |
      | tc3PeriodicNumber-0           | 12345678                           |
      | tc3PeriodicExpiryDate-0       | 20/08/2021                         |
      # Memo 07/09 (3 month extension) subsection
      | memosApply                    | -                                  |
      # Tank documents section
      | document-name-0               | sample.pdf                         |
      | document-view-0               | View                               |
      # Battery list subsection
      | listStatementApplicable       | Yes                                |
      | batteryListNumber             | 567890                             |
      # Declarations seen subsection
      | brakeDeclarationsSeen         | Yes                                |
      | brakeDeclarationIssuer        | Issuer                             |
      | brakeEndurance                | Yes                                |
      | weight                        | 1000                               |
      | declarationsSeen              | -                                  |
      # Certificate subsection
      | guidanceNotes                 | -                                  |
      # Additional ADR details subsection
      | additionalExaminerNotes       | examiner note                      |
      # Tech record history subsection
      | statusCode-0                  | Provisional                        |
      | reasonForCreation-0           | Cvsb-10084                         |
      | createdByName-0               | VTM_USER_EMAIL                     |
      | createdAt-0                   | TODAYS_DATE                        |
      | statusCode-1                  | Archived                           |
      | reasonForCreation-1           | Something                          |
      | createdByName-1               | Sean                               |
      | createdAt-1                   | TODAYS_DATE                        |
