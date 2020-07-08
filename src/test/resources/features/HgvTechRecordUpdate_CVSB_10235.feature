Feature: Update HGVs in VTM - CVSB-10235

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present


  Scenario: I want to be able to update HGV tech records so that our HGV tech records reflect the most
  up to date information
  AC1 - The call to action to 'Change technical record', is only present if the technical record has a status
  of 'current' or 'provisional'
  AC2. The call to action to 'Change technical record', is not present if the technical record has a status
  of 'archived'
  AC3. User clicks the call to action to change the technical record
  AC4. User clicks the call to action to cancel the change
    #AC1 + AC3
    When I create "hgv" vehicle without adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then I should see "Technical record"
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    Then I should see "Change technical record"
    When I click "Change technical record" button
    #AC17
    When I open all tech record sections
    And I check values for fields
      | Field                               | Value                |
      | edit-regnDate-1-day                 | 01                   |
      | edit-regnDate-1-month               | 01                   |
      | edit-regnDate-1-year                | 1985                 |
      | edit-manufactureYear                | 1984                 |
      | edit-dtpNumber                      | 3798A                |
      | edit-axle-1                         | unchecked            |
      | edit-axle-2                         | unchecked            |
      | edit-speedLimiterMrk                | No                   |
      | edit-tachoExemptMrk                 | No                   |
      | edit-euroStandard                   | 2                    |
      | edit-roadFriendly                   | No                   |
      | edit-drawbarCouplingFitted          | No                   |
      | edit-offRoad                        | No                   |
      | edit-numberOfWheelsDriven           | 4                    |
      | edit-emissionsLimit                 | 20                   |
      | edit-departmentalVehicleMarker      | No                   |
      | edit-approvalTypeNumber             | 1234                 |
      | edit-ntaNumber                      | 0000514903           |
      | edit-variantNumber                  | 324324               |
      | edit-variantVersionNumber           | 345                  |
      | edit-make                           | VOLVO                |
      | edit-model                          | F12-33               |
      | edit-grossGbWeight                  | 25000                |
      | edit-grossEecWeight                 | 26000                |
      | edit-grossDesignWeight              | 33500                |
      | edit-trainGbWeight                  | 41000                |
      | edit-trainEecWeight                 | 25000                |
      | edit-trainDesignWeight              | 59500                |
      | edit-maxTrainGbWeight               | 44000                |
      | edit-maxTrainEecWeight              | 2500                 |
      | edit-maxTrainDesignWeight           | 2800                 |
      | edit-gbWeight-1                     | 7700                 |
      | edit-eecWeight-1                    | 7600                 |
      | edit-designWeight-1                 | 7500                 |
      | edit-gbWeight-2                     | 9500                 |
      | edit-eecWeight-2                    | 10000                |
      | edit-designWeight-2                 | 13000                |
      | edit-tyreUseCode                    | 2B                   |
      | edit-tyreCode-1                     | 462                  |
      | edit-tyreSize-1                     | 12-22.5              |
      | edit-dataTrAxles-1                  | 2                    |
      | edit-tyreCode-2                     | 462                  |
      | edit-tyreSize-2                     | 12-22.5              |
      | edit-dataTrAxles-2                  | 2                    |
      | edit-length                         | 10000                |
      | edit-width                          | 2000                 |
      | edit-frontAxleToRearAxle            | 1000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 1400                 |
      | edit-frontAxleTo5thWheelCouplingMax | 1300                 |
      | edit-frontAxleTo5thWheelMin         | 1200                 |
      | edit-frontAxleTo5thWheelMax         | 1100                 |
      | edit-axleSpacing-value-1            | 11000                |
      | edit-name                           | applicant name       |
      | edit-address1                       | applicant address 1  |
      | edit-address2                       | applicant address 2  |
      | edit-postTown                       | applicant post town  |
      | edit-address3                       | applicant address 3  |
      | edit-postCode                       | PO16 7GZ             |
      | edit-telephoneNumber                | 123456               |
      | edit-emailAddress                   | test@test.com        |
      | edit-microfilmRollNumber            | 12346                |
      | edit-microfilmSerialNumber          | 1234                 |

    And I should see "2" as No of axles on tech record create page
    And I should see "Electric" as Fuel propulsion system on tech record create page
    And I should see "heavy goods vehicle" as Vehicle class on tech record create page
    And I should see "articulated" as Vehicle configuration on tech record create page
    And I should see "n2" as EU vehicle category on tech record create page
    And I should see "NTA" as Approval type on tech record create page
    And I should see "other" as Body type on tech record create page
    And I should see "single" as Fitment Code on tech record create page
    And I should see "HGV COC + Int Plate" as Microfilm document type on tech record create page
    #AC4
    When I set values for fields
      | Field                               | Value                |
      | edit-regnDate-1-day                 | 10                   |
      | edit-regnDate-1-month               | 12                   |
      | edit-regnDate-1-year                | 2020                 |
      | edit-manufactureYear                | 1995                 |
      | edit-noOfAxles                      | 3                    |
      | edit-dtpNumber                      | 1234                 |
      | edit-axle-1                         | checked              |
      | edit-axle-2                         | checked              |
      | edit-speedLimiterMrk                | Yes                  |
      | edit-tachoExemptMrk                 | Yes                  |
      | edit-euroStandard                   | 6                    |
      | edit-roadFriendly                   | Yes                  |
      | edit-fuelPropulsionSystem           | Hybrid               |
      | edit-drawbarCouplingFitted          | Yes                  |
      | edit-vehicleClass-description       | heavy goods vehicle  |
      | edit-vehicleConfiguration           | semi-car transporter |
      | edit-offRoad                        | Yes                  |
      | edit-numberOfWheelsDriven           | 4                    |
      | edit-euVehicleCategory              | n2                   |
      | edit-emissionsLimit                 | 2.2                  |
      | edit-departmentalVehicleMarker      | Yes                  |
      | edit-approvalType                   | NTA                  |
      | edit-approvalTypeNumber             | 1234                 |
      | edit-ntaNumber                      | 12345                |
      | edit-variantNumber                  | 123456               |
      | edit-variantVersionNumber           | 1234567              |
      | edit-make                           | Mercedes             |
      | edit-model                          | Vito                 |
      | edit-bodyType-description           | articulated          |
      | edit-functionCode                   | Rigid                |
      | edit-conversionRefNo                | 4321                 |
      | edit-grossGbWeight                  | 1500                 |
      | edit-grossEecWeight                 | 1400                 |
      | edit-grossDesignWeight              | 1300                 |
      | edit-trainGbWeight                  | 1200                 |
      | edit-trainEecWeight                 | 1100                 |
      | edit-trainDesignWeight              | 1000                 |
      | edit-maxTrainGbWeight               | 900                  |
      | edit-maxTrainEecWeight              | 800                  |
      | edit-maxTrainDesignWeight           | 700                  |
      | edit-gbWeight-1                     | 800                  |
      | edit-eecWeight-1                    | 700                  |
      | edit-designWeight-1                 | 700                  |
      | edit-gbWeight-2                     | 800                  |
      | edit-eecWeight-2                    | 700                  |
      | edit-designWeight-2                 | 700                  |
      | edit-tyreUseCode                    | 2C                   |
      | edit-tyreCode-1                     | 675                  |
      | edit-tyreSize-1                     | 3ER                  |
      | edit-plyRating-1                    | 3R                   |
      | edit-fitmentCode-1                  | single               |
      | edit-dataTrAxles-1                  | 34                   |
      | edit-tyreCode-2                     | 675                  |
      | edit-tyreSize-2                     | 3ER                  |
      | edit-plyRating-2                    | 3R                   |
      | edit-fitmentCode-2                  | single               |
      | edit-dataTrAxles-2                  | 34                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-axleSpacing-value-1            | 3500                 |
      | edit-name                           | Applicant name       |
      | edit-address1                       | Applicant address 1  |
      | edit-address2                       | Applicant address 2  |
      | edit-postTown                       | Applicant town       |
      | edit-address3                       | Applicant address 3  |
      | edit-postCode                       | 3RT23                |
      | edit-telephoneNumber                | 897564278            |
      | edit-emailAddress                   | wiz@abc.com          |
      | edit-microfilmDocumentType          | HGV COC + Int Plate  |
      | edit-microfilmRollNumber            | 65432                |
      | edit-microfilmSerialNumber          | 8765                 |
      | edit-notes                          | Notes                |
    Then I should see "Save technical record"
    When I click "Cancel" link
    And tech record fields should have values
      | Field                            | Value                                     |
      # 'vehicle summary' subsection
      | vehicleType                      | HGV                                       |
      | regnDate                         | 01/01/1985                                |
      | manufactureYear                  | 1984                                      |
      | noOfaxles                        | 2                                         |
      | dtpNumber                        | 3798A                                     |
      | parkingBrakeMrk                  | -                                         |
      | vehicleClassDescription          | Heavy goods vehicle                       |
      | vehicleConfiguration             | articulated                               |
      | euVehicleCategory                | n2                                        |
      | departmentalVehicleMarker        | No                                        |
      | alterationMarker                 | No                                        |
      | speedLimiterMrk                  | No                                        |
      | tachoExemptMrk                   | No                                        |
      | euroStandard                     | 2                                         |
      | fuelpropulsionsystem             | Electric                                  |
      | numberOfWheelsDriven             | 4                                         |
      | emissionsLimit                   | 20                                        |
      | drawbarCouplingFitted            | No                                        |
      | offRoad                          | No                                        |
      | roadFriendly                     | No                                        |
      # 'type approval' subsection
      | approvalType                     | NTA                                       |
      | approvalTypeNumber               | 1234                                      |
      | ntaNumber                        | 0000514903                                |
      | variantNumber                    | 324324                                    |
      | variantVersionNumber             | 345                                       |
      # 'body' section
      | make                             | VOLVO                                     |
      | model                            | F12-33                                    |
      | bodyTypeDescription              | Other                                     |
      | functionCode                     | A                                         |
      | conversionRefNo                  | -                                         |
      # 'weights' section
      | grossGbWeight                    | 25000                                     |
      | grossEecWeight                   | 26000                                     |
      | grossDesignWeight                | 33500                                     |
      | trainGbWeight                    | 41000                                     |
      | trainEecWeight                   | 25000                                     |
      | trainDesignWeight                | 59500                                     |
      | maxTrainGbWeight                 | 44000                                     |
      | maxTrainEecWeight                | 2500                                      |
      | maxTrainDesignWeight             | 2800                                      |
      | gbWeight-1                       | 7700                                      |
      | eecWeight-1                      | 7600                                      |
      | designWeight-1                   | 7500                                      |
      | gbWeight-2                       | 9500                                      |
      | eecWeight-2                      | 10000                                     |
      | designWeight-2                   | 13000                                     |
      # 'tyres' section
      | tyreUseCode                      | 2B                                        |
      | tyreCode-1                       | 462                                       |
      | tyreSize-1                       | 12-22.5                                   |
      | plyRating-1                      | -                                         |
      | fitmentCode-1                    | single                                    |
      | dataTrAxles-1                    | 2                                         |
      | tyreCode-2                       | 462                                       |
      | tyreSize-2                       | 12-22.5	                                 |
      | plyRating-2                      | -                                         |
      | fitmentCode-2                    | double                                    |
      | dataTrAxles-2                    | 2                                         |
      # 'dimensions' section
      | length                           | 10000                                     |
      | width                            | 2000                                      |
      | frontAxleToRearAxle              | 1000                                      |
      | axleSpacing-axles-1              | Axle 1 to 2 (mm)                          |
      | axleSpacing-value-1              | 11000                                     |
      | frontAxleTo5thWheelCouplingMin   | 1400                                      |
      | frontAxleTo5thWheelCouplingMax   | 1300                                      |
      | frontAxleTo5thWheelMin           | 1200                                      |
      | frontAxleTo5thWheelMax           | 1100                                      |
      # 'ADR' section
      | ableToCarry                      | No                                        |
      # 'applicant' section
      | applicantDetails-name            | applicant name                            |
      | applicantDetails-address         | applicant address 1 applicant address 2   |
      | applicantDetails-postTown        | applicant post town                       |
      | applicantDetails-address3        | applicant address 3                       |
      | applicantDetails-postCode        | PO16 7GZ                                  |
      | applicantDetails-telephoneNumber | 123456                                    |
      | applicantDetails-emailAddress    | test@test.com                             |
      # 'documents' section
      | microfilmDocumentType            | HGV COC + Int Plate                       |
      | microfilmRollNumber              | 12346                                     |
      | microfilmSerialNumber            | 1234                                      |
      # 'notes' section
      | notes                            | -                                         |
      # 'test history' section
      | testCode-tRes-0-0                | -                                         |
      | testTypeEndTimestamp-tRes-0-0    | -                                         |
      | expiryDate-tRes-0-0              | -                                         |
      | certificateNumber-tRes-0-0       | -                                         |
      | testResult-tRes-0-0              | -                                         |
      | testerName-0-0                   | -                                         |
      # 'technical record history' section
      | statusCode-0                     | Provisional                               |
      | reasonForCreation-0              | Something                                 |
      | createdByName-0                  | Sean                                      |
      | createdAt-0                      | TODAYS_DATE                               |
      | lastUpdatedByName-0              | -                                         |
      | lastUpdatedAt-0                  | -                                         |
      # 'plates' section
      | plateSerialNumber-0              | 123456                                    |
      | plateReasonForIssue-0            | Replacement                               |
      | plateIssuer-0                    | issuer                                    |
      | plateIssueDate-0                 | 31/12/2100                                |
    #AC5
    When I click "Change technical record" button
    When I set values for fields
      | Field                               | Value                |
      | edit-regnDate-1-day                 | 10                   |
      | edit-regnDate-1-month               | 12                   |
      | edit-regnDate-1-year                | 2020                 |
      | edit-manufactureYear                | 1995                 |
      | edit-noOfAxles                      | 2                    |
      | edit-dtpNumber                      | 1234                 |
      | edit-axle-1                         | checked              |
      | edit-axle-2                         | checked              |
      | edit-speedLimiterMrk                | Yes                  |
      | edit-tachoExemptMrk                 | Yes                  |
      | edit-euroStandard                   | 6                    |
      | edit-roadFriendly                   | Yes                  |
      | edit-fuelPropulsionSystem           | Hybrid               |
      | edit-drawbarCouplingFitted          | Yes                  |
      | edit-vehicleClass-description       | heavy goods vehicle  |
      | edit-vehicleConfiguration           | semi-car transporter |
      | edit-offRoad                        | Yes                  |
      | edit-numberOfWheelsDriven           | 4                    |
      | edit-euVehicleCategory              | n2                   |
      | edit-emissionsLimit                 | 2.2                  |
      | edit-departmentalVehicleMarker      | Yes                  |
      | edit-approvalType                   | NTA                  |
      | edit-approvalTypeNumber             | 1234                 |
      | edit-ntaNumber                      | 12345                |
      | edit-variantNumber                  | 123456               |
      | edit-variantVersionNumber           | 1234567              |
      | edit-make                           | Mercedes             |
      | edit-model                          | Vito                 |
      | edit-bodyType-description           | articulated          |
      | edit-functionCode                   | Rigid                |
      | edit-conversionRefNo                | 4321                 |
      | edit-grossGbWeight                  | 1500                 |
      | edit-grossEecWeight                 | 1400                 |
      | edit-grossDesignWeight              | 1300                 |
      | edit-trainGbWeight                  | 1200                 |
      | edit-trainEecWeight                 | 1100                 |
      | edit-trainDesignWeight              | 1000                 |
      | edit-maxTrainGbWeight               | 900                  |
      | edit-maxTrainEecWeight              | 800                  |
      | edit-maxTrainDesignWeight           | 700                  |
      | edit-gbWeight-1                     | 800                  |
      | edit-eecWeight-1                    | 700                  |
      | edit-designWeight-1                 | 700                  |
      | edit-gbWeight-2                     | 800                  |
      | edit-eecWeight-2                    | 700                  |
      | edit-designWeight-2                 | 700                  |
      | edit-tyreUseCode                    | 2C                   |
      | edit-tyreCode-1                     | 675                  |
      | edit-tyreSize-1                     | 3ER                  |
      | edit-plyRating-1                    | 3R                   |
      | edit-fitmentCode-1                  | single               |
      | edit-dataTrAxles-1                  | 34                   |
      | edit-tyreCode-2                     | 675                  |
      | edit-tyreSize-2                     | 3ER                  |
      | edit-plyRating-2                    | 3R                   |
      | edit-fitmentCode-2                  | single               |
      | edit-dataTrAxles-2                  | 34                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-axleSpacing-value-1            | 3500                 |
      | edit-name                           | Applicant name       |
      | edit-address1                       | Applicant address 1  |
      | edit-address2                       | Applicant address 2  |
      | edit-postTown                       | Applicant town       |
      | edit-address3                       | Applicant address 3  |
      | edit-postCode                       | 3RT23                |
      | edit-telephoneNumber                | 897564278            |
      | edit-emailAddress                   | wiz@abc.com          |
      | edit-microfilmDocumentType          | HGV COC + Int Plate  |
      | edit-microfilmRollNumber            | 65432                |
      | edit-microfilmSerialNumber          | 8765                 |
      | edit-notes                          | Notes                |
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    #AC6
    When I enter "cvsb-10235" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should see "Change technical record"
    And I should not see "There is a problem"
    And tech record fields should have values
      | Field                            | Value                                     |
      # 'vehicle summary' subsection
      | vehicleType                      | HGV                                       |
      | regnDate                         | 10/12/2020                                |
      | manufactureYear                  | 1995                                      |
      | noOfaxles                        | 2                                         |
      | dtpNumber                        | 1234                                      |
      | parkingBrakeMrkAxle-1            | Axle 1                                    |
      | parkingBrakeMrkAxle-2            | Axle 2                                    |
      | vehicleClassDescription          | Heavy goods vehicle                       |
      | vehicleConfiguration             | semi-car transporter                      |
      | euVehicleCategory                | n2                                        |
      | departmentalVehicleMarker        | Yes                                       |
      | alterationMarker                 | No                                        |
      | speedLimiterMrk                  | Yes                                       |
      | tachoExemptMrk                   | Yes                                       |
      | euroStandard                     | 6                                         |
      | fuelpropulsionsystem             | Hybrid                                    |
      | numberOfWheelsDriven             | 4                                         |
      | emissionsLimit                   | 2.2                                       |
      | drawbarCouplingFitted            | Yes                                       |
      | offRoad                          | Yes                                       |
      | roadFriendly                     | Yes                                       |
      # 'type approval' subsection
      | approvalType                     | NTA                                       |
      | approvalTypeNumber               | 1234                                      |
      | ntaNumber                        | 12345                                     |
      | variantNumber                    | 123456                                    |
      | variantVersionNumber             | 1234567                                   |
      # 'body' section
      | make                             | Mercedes                                  |
      | model                            | Vito                                      |
      | bodyTypeDescription              | Articulated                               |
      | functionCode                     | r                                         |
      | conversionRefNo                  | 4321                                      |
      # 'weights' section
      | grossGbWeight                    | 1500                                      |
      | grossEecWeight                   | 1400                                      |
      | grossDesignWeight                | 1300                                      |
      | trainGbWeight                    | 1200                                      |
      | trainEecWeight                   | 1100                                      |
      | trainDesignWeight                | 1000                                      |
      | maxTrainGbWeight                 | 900                                       |
      | maxTrainEecWeight                | 800                                       |
      | maxTrainDesignWeight             | 700                                       |
      | gbWeight-1                       | 800                                       |
      | eecWeight-1                      | 700                                       |
      | designWeight-1                   | 700                                       |
      | gbWeight-2                       | 800                                       |
      | eecWeight-2                      | 700                                       |
      | designWeight-2                   | 700                                       |
      # 'tyres' section
      | tyreUseCode                      | 2C                                        |
      | tyreCode-1                       | 675                                       |
      | tyreSize-1                       | 3ER                                       |
      | plyRating-1                      | 3R                                        |
      | fitmentCode-1                    | single                                    |
      | dataTrAxles-1                    | 34                                        |
      | tyreCode-2                       | 675                                       |
      | tyreSize-2                       | 3ER	                                     |
      | plyRating-2                      | 3R                                        |
      | fitmentCode-2                    | single                                    |
      | dataTrAxles-2                    | 34                                        |
      # 'dimensions' section
      | length                           | 5500                                      |
      | width                            | 2500                                      |
      | frontAxleToRearAxle              | 5000                                      |
      | frontAxleTo5thWheelCouplingMin   | 4000                                      |
      | frontAxleTo5thWheelCouplingMax   | 4500                                      |
      | frontAxleTo5thWheelMin           | 3000                                      |
      | frontAxleTo5thWheelMax           | 3500                                      |
      | axleSpacing-value-1              | 3500                                      |
      | axleSpacing-axles-1              | Axle 1 to 2 (mm)                          |
      # 'ADR' section
      | ableToCarry                      | No                                        |
      # 'applicant' section
      | applicantDetails-name            | Applicant name                            |
      # CVSB-17197
      | applicantDetails-address         | Applicant address 1 Applicant address 2   |
      | applicantDetails-postTown        | Applicant town                            |
      | applicantDetails-address3        | Applicant address 3                       |
      | applicantDetails-postCode        | 3RT23                                     |
      | applicantDetails-telephoneNumber | 897564278                                 |
      | applicantDetails-emailAddress    | wiz@abc.com                               |
      # 'documents' section
      | microfilmDocumentType            | HGV COC + Int Plate                       |
      | microfilmRollNumber              | 65432                                     |
      | microfilmSerialNumber            | 8765                                      |
      # CVSB-17197
      # 'notes' section
      | notes                            | Notes                                     |
      # 'test history' section
      | testCode-tRes-0-0                | -                                         |
      | testTypeEndTimestamp-tRes-0-0    | -                                         |
      | expiryDate-tRes-0-0              | -                                         |
      | certificateNumber-tRes-0-0       | -                                         |
      | testResult-tRes-0-0              | -                                         |
      | testerName-0-0                   | -                                         |
      # 'technical record history' section
      | statusCode-0                     | Provisional                               |
      | reasonForCreation-0              | Cvsb-10235                                |
      | createdByName-0                  | VTM_USER_EMAIL                            |
      | createdAt-0                      | TODAYS_DATE                               |
      | lastUpdatedByName-0              | -                                         |
      | lastUpdatedAt-0                  | -                                         |
      | statusCode-1                     | Archived                                  |
      | reasonForCreation-1              | Something                                 |
      | createdByName-1                  | Sean                                      |
      | createdAt-1                      | TODAYS_DATE                               |
      | lastUpdatedByName-1              | VTM_USER_EMAIL                            |
      | lastUpdatedAt-1                  | TODAYS_DATE                               |
      # 'plates' section
      | plateSerialNumber-0              | 123456                                    |
      | plateReasonForIssue-0            | Replacement                               |
      | plateIssuer-0                    | issuer                                    |
      | plateIssueDate-0                 | 31/12/2100                                |
    When I click "Change technical record" button
    When I set values for fields
      | Field                               | Value                |
      | edit-regnDate-1-day                 | 10                   |
      | edit-regnDate-1-month               | 12                   |
      | edit-regnDate-1-year                | 2020                 |
      | edit-manufactureYear                | 1995                 |
      | edit-noOfAxles                      | 2                    |
      | edit-dtpNumber                      | 1234                 |
      | edit-axle-1                         | checked              |
      | edit-axle-2                         | checked              |
      | edit-speedLimiterMrk                | Yes                  |
      | edit-tachoExemptMrk                 | Yes                  |
      | edit-euroStandard                   | 6                    |
      | edit-roadFriendly                   | Yes                  |
      | edit-fuelPropulsionSystem           | Hybrid               |
      | edit-drawbarCouplingFitted          | Yes                  |
      | edit-vehicleClass-description       | heavy goods vehicle  |
      | edit-vehicleConfiguration           | semi-car transporter |
      | edit-offRoad                        | Yes                  |
      | edit-numberOfWheelsDriven           | 4                    |
      | edit-euVehicleCategory              | n2                   |
      | edit-emissionsLimit                 | 2.2                  |
      | edit-departmentalVehicleMarker      | Yes                  |
      | edit-approvalType                   | NTA                  |
      | edit-approvalTypeNumber             | 1234                 |
      | edit-ntaNumber                      | 12345                |
      | edit-variantNumber                  | 123456               |
      | edit-variantVersionNumber           | 1234567              |
      | edit-make                           | Mercedes             |
      | edit-model                          | Vito                 |
      | edit-bodyType-description           | articulated          |
      | edit-functionCode                   | Rigid                |
      | edit-conversionRefNo                | 4321                 |
      | edit-grossGbWeight                  | 1500                 |
      | edit-grossEecWeight                 | 1400                 |
      | edit-grossDesignWeight              | 1300                 |
      | edit-trainGbWeight                  | 1200                 |
      | edit-trainEecWeight                 | 1100                 |
      | edit-trainDesignWeight              | 1000                 |
      | edit-maxTrainGbWeight               | 900                  |
      | edit-maxTrainEecWeight              | 800                  |
      | edit-maxTrainDesignWeight           | 700                  |
      | edit-gbWeight-1                     | 800                  |
      | edit-eecWeight-1                    | 700                  |
      | edit-designWeight-1                 | 700                  |
      | edit-gbWeight-2                     | 800                  |
      | edit-eecWeight-2                    | 700                  |
      | edit-designWeight-2                 | 700                  |
      | edit-tyreUseCode                    | 2C                   |
      | edit-tyreCode-1                     | 675                  |
      | edit-tyreSize-1                     | 3ER                  |
      | edit-plyRating-1                    | 3R                   |
      | edit-fitmentCode-1                  | single               |
      | edit-dataTrAxles-1                  | 34                   |
      | edit-tyreCode-2                     | 675                  |
      | edit-tyreSize-2                     | 3ER                  |
      | edit-plyRating-2                    | 3R                   |
      | edit-fitmentCode-2                  | single               |
      | edit-dataTrAxles-2                  | 34                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-axleSpacing-value-1            | 3500                 |
      | edit-name                           | Applicant name       |
      | edit-address1                       | Applicant address 1  |
      | edit-address2                       | Applicant address 2  |
      | edit-postTown                       | Applicant town       |
      | edit-address3                       | Applicant address 3  |
      | edit-postCode                       | 3RT23                |
      | edit-telephoneNumber                | 897564278            |
      | edit-emailAddress                   | wiz@abc.com          |
      | edit-microfilmDocumentType          | HGV COC + Int Plate  |
      | edit-microfilmRollNumber            | 65432                |
      | edit-microfilmSerialNumber          | 8765                 |
      | edit-notes                          | Notes                |
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    #AC7
    And I cancel saving the tech record details
    Then I should not see "Enter reason for creating technical record"
    And I check values for fields
      | Field                               | Value                |
      | edit-speedLimiterMrk                | Yes                  |
      | edit-tachoExemptMrk                 | Yes                  |
      | edit-roadFriendly                   | Yes                  |
      | edit-drawbarCouplingFitted          | Yes                  |
      | edit-offRoad                        | Yes                  |
      | edit-departmentalVehicleMarker      | Yes                  |
      | edit-regnDate-1-day                 | 10                   |
      | edit-regnDate-1-month               | 12                   |
      | edit-regnDate-1-year                | 2020                 |
      | edit-manufactureYear                | 1995                 |
      | edit-dtpNumber                      | 1234                 |
      | edit-axle-1                         | checked              |
      | edit-axle-2                         | checked              |
      | edit-euroStandard                   | 6                    |
      | edit-numberOfWheelsDriven           | 4                    |
      | edit-emissionsLimit                 | 2.2                  |
      | edit-approvalTypeNumber             | 1234                 |
      | edit-ntaNumber                      | 12345                |
      | edit-variantNumber                  | 123456               |
      | edit-variantVersionNumber           | 1234567              |
      | edit-make                           | Mercedes             |
      | edit-model                          | Vito                 |
      | edit-functionCode                   | Rigid                |
      | edit-conversionRefNo                | 4321                 |
      | edit-grossGbWeight                  | 1500                 |
      | edit-grossEecWeight                 | 1400                 |
      | edit-grossDesignWeight              | 1300                 |
      | edit-trainGbWeight                  | 1200                 |
      | edit-trainEecWeight                 | 1100                 |
      | edit-trainDesignWeight              | 1000                 |
      | edit-maxTrainGbWeight               | 900                  |
      | edit-maxTrainEecWeight              | 800                  |
      | edit-maxTrainDesignWeight           | 700                  |
      | edit-gbWeight-1                     | 800                  |
      | edit-eecWeight-1                    | 700                  |
      | edit-designWeight-1                 | 700                  |
      | edit-gbWeight-2                     | 800                  |
      | edit-eecWeight-2                    | 700                  |
      | edit-designWeight-2                 | 700                  |
      | edit-tyreUseCode                    | 2C                   |
      | edit-tyreCode-1                     | 675                  |
      | edit-tyreSize-1                     | 3ER                  |
      | edit-plyRating-1                    | 3R                   |
      | edit-dataTrAxles-1                  | 34                   |
      | edit-tyreCode-2                     | 675                  |
      | edit-tyreSize-2                     | 3ER                  |
      | edit-plyRating-2                    | 3R                   |
      | edit-dataTrAxles-2                  | 34                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-axleSpacing-value-1            | 3500                 |
      | edit-name                           | Applicant name       |
      | edit-address1                       | Applicant address 1  |
      | edit-address2                       | Applicant address 2  |
      | edit-postTown                       | Applicant town       |
      | edit-address3                       | Applicant address 3  |
      | edit-postCode                       | 3RT23                |
      | edit-telephoneNumber                | 897564278            |
      | edit-emailAddress                   | wiz@abc.com          |
      | edit-microfilmRollNumber            | 65432                |
      | edit-microfilmSerialNumber          | 8765                 |
      | edit-notes                          | Notes                |
    #AC11
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 3     |
    Then I should see
      | Text                                     |
      | Axle 1                                   |
      | Axle 2                                   |
      | Axle 3                                   |
      | Axle weight (kg)                         |
      | Axle 1                                   |
      | GB                                       |
      | EEC (optional)                           |
      | Design                                   |
      | Axle 2                                   |
      | GB                                       |
      | EEC (optional)                           |
      | Design                                   |
      | Axle 3                                   |
      | GB                                       |
      | EEC (optional)                           |
      | Design                                   |
      | Axle 1                                   |
      | Tyre code                                |
      | Tyre size                                |
      | Ply rating (optional)                    |
      | Fitment code                             |
      | Load index (optional)                    |
      | Axle 2                                   |
      | Tyre code                                |
      | Tyre size                                |
      | Ply rating (optional)                    |
      | Fitment code                             |
      | Load index (optional)                    |
      | Axle 3                                   |
      | Tyre code                                |
      | Tyre size                                |
      | Ply rating (optional)                    |
      | Fitment code                             |
      | Load index (optional)                    |
      | Axle 1 to axle 2 (mm)                    |
      | Axle 2 to axle 3 (mm)                    |
    #AC12
    When I set values for fields
      | Field                               | Value                |
      | edit-axle-1                         | checked              |
      | edit-axle-2                         | checked              |
      | edit-axle-3                         | checked              |
      | edit-axleSpacing-value-1            | 110                  |
      | edit-axleSpacing-value-2            | 201                  |
      | edit-gbWeight-3                     | 800                  |
      | edit-eecWeight-3                    | 700                  |
      | edit-designWeight-3                 | 700                  |
      | edit-tyreCode-3                     | 675                  |
      | edit-tyreSize-3                     | 3ER                  |
      | edit-plyRating-3                    | 3R                   |
      | edit-fitmentCode-3                  | single               |
      | edit-dataTrAxles-3                  | 34                   |
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10235" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should see "Change technical record"
    And I should not see "There is a problem"
    And tech record fields should have values
      | Field                            | Value                    |
      | axleSpacing-axles-1              | Axle 1 to 2 (mm)         |
      | axleSpacing-value-1              | 110                      |
      | axleSpacing-axles-2              | Axle 2 to 3 (mm)         |
      | axleSpacing-value-2              | 201                      |
    #AC13
    When I click "Change technical record" button
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 4     |
    And I check values for fields
      | Field                          | Value                |
      | edit-axleSpacing-value-1       | 110                  |
      | edit-axleSpacing-value-2       | 201                  |
      | edit-gbWeight-1                | 800                  |
      | edit-eecWeight-1               | 700                  |
      | edit-designWeight-1            | 700                  |
      | edit-gbWeight-2                | 800                  |
      | edit-eecWeight-2               | 700                  |
      | edit-designWeight-2            | 700                  |
      | edit-gbWeight-3                | 800                  |
      | edit-eecWeight-3               | 700                  |
      | edit-designWeight-3            | 700                  |
      | edit-tyreUseCode               | 2C                   |
      | edit-tyreCode-1                | 675                  |
      | edit-tyreSize-1                | 3ER                  |
      | edit-plyRating-1               | 3R                   |
      | edit-dataTrAxles-1             | 34                   |
      | edit-tyreCode-2                | 675                  |
      | edit-tyreSize-2                | 3ER                  |
      | edit-plyRating-1               | 3R                   |
      | edit-dataTrAxles-2             | 34                   |
      | edit-tyreCode-3                | 675                  |
      | edit-tyreSize-3                | 3ER                  |
      | edit-plyRating-3               | 3R                   |
      | edit-dataTrAxles-3             | 34                   |
    When I set values for fields
      | Field                               | Value                |
      | edit-axle-4                         | checked              |
      | edit-gbWeight-4                     | 800                  |
      | edit-eecWeight-4                    | 700                  |
      | edit-designWeight-4                 | 700                  |
      | edit-tyreCode-4                     | 675                  |
      | edit-tyreSize-4                     | 3ER                  |
      | edit-plyRating-4                    | 3R                   |
      | edit-fitmentCode-4                  | single               |
      | edit-dataTrAxles-4                  | 34                   |
      | edit-axleSpacing-value-1            | 110                  |
      | edit-axleSpacing-value-2            | 201                  |
      | edit-axleSpacing-value-3            | 435                  |
    #AC14
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 3     |
    And I check values for fields
      | Field                          | Value                |
      | edit-axleSpacing-value-1       | 110                  |
      | edit-axleSpacing-value-2       | 201                  |
      | edit-gbWeight-1                | 800                  |
      | edit-eecWeight-1               | 700                  |
      | edit-designWeight-1            | 700                  |
      | edit-gbWeight-2                | 800                  |
      | edit-eecWeight-2               | 700                  |
      | edit-designWeight-2            | 700                  |
      | edit-gbWeight-3                | 800                  |
      | edit-eecWeight-3               | 700                  |
      | edit-designWeight-3            | 700                  |
      | edit-tyreUseCode               | 2C                   |
      | edit-tyreCode-1                | 675                  |
      | edit-tyreSize-1                | 3ER                  |
      | edit-plyRating-1               | 3R                   |
      | edit-dataTrAxles-1             | 34                   |
      | edit-tyreCode-2                | 675                  |
      | edit-tyreSize-2                | 3ER                  |
      | edit-plyRating-1               | 3R                   |
      | edit-dataTrAxles-2             | 34                   |
      | edit-tyreCode-3                | 675                  |
      | edit-tyreSize-3                | 3ER                  |
      | edit-plyRating-3               | 3R                   |
      | edit-dataTrAxles-3             | 34                   |
    Then I should not see
      | Text                              |
      | Axle 4                            |
      | Axle 3 to axle 4 (mm)             |
    #AC18
    When I close all tech record sections
    Then I should not see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Text                                         |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Tyre use code (optional)                     |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm)                                 |
      | Maximum (mm)                                 |
      | Front axle to 5th wheel                      |
      | Minimum (mm)                                 |
      | Maximum (mm)                                 |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
    Then I should see "Open all"
    #AC15
    When I open tech record "Vehicle summary" section
    Then I should see
      | Text                                   |
      | Vehicle type                           |
      | Date of first registration             |
      | Year of manufacture                    |
      | Number of axles                        |
      | DTp number                             |
      | Axles fitted with a parking brake      |
      | Speed limiter exempt                   |
      | Tacho exempt                           |
      | Euro standard                          |
      | Road friendly suspension               |
      | Fuel/propulsion system                 |
      | Drawbar coupling fitted                |
      | Vehicle class                          |
      | Vehicle configuration                  |
      | Off road vehicle                       |
      | Number of wheels driven                |
      | EU vehicle category                    |
      | Emission limit (optional)              |
      | Departmental vehicle marker            |
    Then I should not see
      | Text                              |
      | Make                              |
      | Vehicle weight (kg)               |
      | Tyre use code (optional)          |
      | Length (mm)                       |
      | Able to carry dangerous goods     |
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "Vehicle summary" section
    When I open tech record "Body" section
    Then I should see
      | Text                                   |
      | Make                                   |
      | Model                                  |
      | Body type                              |
      | Function (optional)                    |
      | Conversion reference number (optional) |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Vehicle weight (kg)               |
      | Tyre use code (optional)          |
      | Length (mm)                       |
      | Able to carry dangerous goods     |
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "Body" section
    When I open tech record "Weights" section
    Then I should see
      | Text                                   |
      | Gross vehicle weight                   |
      | GB                                     |
      | EEC (optional)                         |
      | Design                                 |
      | Gross train weight                     |
      | GB                                     |
      | EEC (optional)                         |
      | Design                                 |
      | Max train weight                       |
      | GB                                     |
      | EEC (optional)                         |
      | Design                                 |
      | Axle 1                                 |
      | GB                                     |
      | EEC (optional)                         |
      | Design                                 |
      | Axle 2                                 |
      | GB                                     |
      | EEC (optional)                         |
      | Design                                 |
      | Axle 3                                 |
      | GB                                     |
      | EEC (optional)                         |
      | Design                                 |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Make                              |
      | Tyre use code (optional)          |
      | Length (mm)                       |
      | Able to carry dangerous goods     |
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "Weights" section
    When I open tech record "Tyres" section
    Then I should see
      | Text                                   |
      | Tyre use code (optional)               |
      | Axle 1                                 |
      | Tyre code                              |
      | Tyre size                              |
      | Ply rating (optional)                  |
      | Fitment code                           |
      | Load index (optional)                  |
      | Axle 2                                 |
      | Tyre code                              |
      | Tyre size                              |
      | Ply rating (optional)                  |
      | Fitment code                           |
      | Load index (optional)                  |
      | Axle 3                                 |
      | Tyre code                              |
      | Tyre size                              |
      | Ply rating (optional)                  |
      | Fitment code                           |
      | Load index (optional)                  |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Make                              |
      | Vehicle weight (kg)               |
      | Length (mm)                       |
      | Able to carry dangerous goods     |
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "Tyres" section
    When I open tech record "Dimensions" section
    Then I should see
      | Text                                   |
      | Length (mm)                            |
      | Width (mm)                             |
      | Front axle to rear axle (mm)           |
      | Front of vehicle to 5th wheel coupling |
      | Minimum (mm)                           |
      | Maximum (mm)                           |
      | Front axle to 5th wheel                |
      | Minimum (mm)                           |
      | Maximum (mm)                           |
      | Axle 1 to axle 2 (mm)                  |
      | Axle 2 to axle 3 (mm)                  |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Make                              |
      | Vehicle weight (kg)               |
      | Tyre use code (optional)          |
      | Able to carry dangerous goods     |
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "Dimensions" section
    When I open tech record "ADR" section
    Then I should see
      | Text                              |
      | Able to carry dangerous goods     |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Make                              |
      | Vehicle weight (kg)               |
      | Tyre use code (optional)          |
      | Length (mm)                       |
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "ADR" section
    When I open tech record "Applicant" section
    Then I should see
      | Text                                   |
      | Name                                   |
      | Building and street                    |
      | Town or city                           |
      | County (optional)                      |
      | Postcode (optional)                    |
      | Telephone number (optional)            |
      | Email address (optional)               |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Make                              |
      | Vehicle weight (kg)               |
      | Tyre use code (optional)          |
      | Length (mm)                       |
      | Able to carry dangerous goods     |
      | Microfilm document type (optional)|
    When I close tech record "Applicant" section
    When I open tech record "Documents" section
    Then I should see
      | Text                                   |
      | Microfilm document type (optional)     |
      | Microfilm roll number (optional)       |
      | Microfilm serial number (optional)     |
    Then I should not see
      | Text                              |
      | Vehicle type                      |
      | Make                              |
      | Vehicle weight (kg)               |
      | Tyre use code (optional)          |
      | Length (mm)                       |
      | Able to carry dangerous goods     |
      | Name                              |
    When I close tech record "Documents" section
    When I open tech record "Notes" section
    When I set values for fields
      | Field                               | Value                |
      | edit-notes                          | hgv notes            |
    Then I should not see
      | Text                               |
      | Vehicle type                       |
      | Make                               |
      | Vehicle weight (kg)                |
      | Tyre use code (optional)           |
      | Length (mm)                        |
      | Able to carry dangerous goods     |
      | Name                               |
      | Microfilm document type (optional) |
    When I close tech record "Notes" section
    #AC16
    When I open all tech record sections
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
    # AC7
    When I close tech record "Documents" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
    When I close tech record "Applicant" section
    Then I should not see
      | Text                                         |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Able to carry dangerous goods                |
    When I close tech record "ADR" section
    Then I should not see
      | Text                                         |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
    When I close tech record "Dimensions" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
    When I close tech record "Tyres" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Tyre use code (optional)                     |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
    When I close tech record "Weights" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Tyre use code (optional)                     |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
    When I close tech record "Body" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
    Then I should see
      | Text                                         |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
    When I close tech record "Vehicle summary" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
      | Able to carry dangerous goods                |
      | Name                                         |
      | Building and street                          |
      | Town or city                                 |
      | County (optional)                            |
      | Postcode (optional)                          |
      | Telephone number (optional)                  |
      | Email address (optional)                     |
      | Length (mm)                                  |
      | Width (mm)                                   |
      | Front axle to rear axle (mm)                 |
      | Front of vehicle to 5th wheel coupling       |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Front axle to 5th wheel                      |
      | Minimum (mm) (optional)                      |
      | Maximum (mm) (optional)                      |
      | Axle 1 to axle 2 (mm)                        |
      | Axle 2 to axle 3 (mm)                        |
      | Axle 1                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 2                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Axle 3                                       |
      | Tyre code                                    |
      | Tyre size                                    |
      | Ply rating (optional)                        |
      | Fitment code                                 |
      | Load index (optional)                        |
      | Gross vehicle weight                         |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Gross train weight                           |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Max train weight                             |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 1                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 2                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Axle 3                                       |
      | GB                                           |
      | EEC (optional)                               |
      | Design                                       |
      | Make                                         |
      | Model                                        |
      | Body type                                    |
      | Function (optional)                          |
      | Conversion reference number (optional)       |
      | Vehicle type                                 |
      | Date of first registration                   |
      | Year of manufacture                          |
      | Number of axles                              |
      | DTp number                                   |
      | Axles fitted with a parking brake            |
      | Speed limiter exempt                         |
      | Tacho exempt                                 |
      | Euro standard                                |
      | Road friendly suspension                     |
      | Fuel/propulsion system                       |
      | Drawbar coupling fitted                      |
      | Vehicle class                                |
      | Vehicle configuration                        |
      | Off road vehicle                             |
      | Number of wheels driven                      |
      | EU vehicle category                          |
      | Emission limit (optional)                    |
      | Departmental vehicle marker                  |
      | Approval type                                |
      | Approval type number (optional)              |
      | National type approval number (optional)     |
      | Variant number (optional)                    |
      | Variant version number (optional)            |
    When I click "Cancel" link
   #AC1
    When I click "Back" link
    Then I should see "Search for a technical record"
    When I search for vehicle with identifier "P012301230000"
    Then I should see "Technical record"
    And tech record fields should have values
      | Field  | Value       |
      | status | Current     |
    Then I should see "Change technical record"
    #AC2
    When I click "Back" link
    When I search for vehicle with identifier "P012301230001"
    Then I should see "Technical record"
    And tech record fields should have values
      | Field  | Value       |
      | status | Archived    |
    Then I should not see "Change technical record"
    When I click "Back" link

  Scenario: I want to be able to update HGV tech records so that our HGV tech records reflect the most
  up to date information
  AC19 - Manually update provisional to current
    #AC19
    When I create "hgv" vehicle without adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for previously created vehicle
    Then I should see "Technical record"
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    Then I should see "Change technical record"
    When I click "Change technical record" button
    When I set values for fields
      | Field                           | Value                |
      | edit-statusCode                 | Current              |
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10235" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should see "Change technical record"
    And I should not see "There is a problem"
    When I open tech record "Technical record history" section
    And tech record fields should have values
      | Field                            | Value               |
      | status                           | Current             |
      | record-completeness              | Complete            |
      # 'technical record history' section
      | statusCode-0                     | Current             |
      | reasonForCreation-0              | Cvsb-10235          |
      | createdByName-0                  | VTM_USER_EMAIL      |
      | createdAt-0                      | TODAYS_DATE         |
      | lastUpdatedByName-0              | -                   |
      | lastUpdatedAt-0                  | -                   |
      | statusCode-1                     | Archived            |
      | reasonForCreation-1              | Something           |
      | createdByName-1                  | Sean                |
      | createdAt-1                      | TODAYS_DATE         |
      | lastUpdatedByName-1              | VTM_USER_EMAIL      |
      | lastUpdatedAt-1                  | TODAYS_DATE         |
























