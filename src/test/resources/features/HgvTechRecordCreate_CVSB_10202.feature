Feature: CVSB-10202 + CVSB-10619 - Create new HGVs in VTM
  As an admin user I can log in the VTM app
  And create new HGVs in VTM so that they can be tested accordingly

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to create tech record page
    Then I should see "Create new technical record"
    Then vin input field should be present


  Scenario: I want to create new HGVs in VTM so that they can be tested accordingly
  calls with questions regarding that vehicle
  AC1 -  Screen displays the correct fields
  AC2 -  User completes HGV fields
    When I select vehicle type "hgv"
    And I set vin to random value
    And I set vrm to random value
    And I click "Continue" button
    Then wait until I see "Vehicle summary"
    And sections in create tech record page are displayed
      | Section                  |
      | Vehicle summary          |
      | Body                     |
      | Weights                  |
      | Tyres                    |
      | Dimensions               |
      | Applicant                |
      | Documents                |
      | Notes                    |
    And sections in create tech record page are not displayed
      | Section                  |
      | Brakes                   |
      | ADR                      |
      | Test history             |
      | Technical record history |
      | Plates                   |
    And all sections in create tech record page should be expanded
    And I check values for fields
      | Field                          | Value |
      | edit-speedLimiterMrk           | No    |
      | edit-tachoExemptMrk            | No    |
      | edit-roadFriendly              | No    |
      | edit-drawbarCouplingFitted     | No    |
      | edit-offRoad                   | No    |
      | edit-departmentalVehicleMarker | No    |
    And I should see
      | Text                                     |
      | Vehicle type                             |
      | Date of first registration               |
      | Year of manufacture                      |
      | DTp number                               |
      | Speed limiter exempt                     |
      | Tacho exempt                             |
      | Euro standard                            |
      | Road friendly suspension                 |
      | Fuel/propulsion                          |
      | Drawbar coupling fitted                  |
      | Vehicle class                            |
      | Vehicle configuration                    |
      | Off road vehicle                         |
      | EU vehicle category                      |
      | Emission limit (optional)                |
      | Departmental vehicle marker              |
      | Approval type                            |
      | Approval type number (optional)          |
      | National type approval number (optional) |
      | Variant number (optional)                |
      | Make                                     |
      | Model                                    |
      | Body type                                |
      | Function (optional)                      |
      | Conversion reference number (optional)   |
      | Tyre use code (optional)                 |
      | Length (mm)                              |
      | Width (mm)                               |
      | Front axle to rear axle (mm)             |
      | Front of vehicle to 5th wheel coupling   |
      | Name                                     |
      | Building and street                      |
      | Town or city                             |
      | County (optional)                        |
      | Postcode (optional)                      |
      | Telephone number (optional)              |
      | Email address (optional)                 |
      | Microfilm document type (optional)       |
      | Microfilm roll number (optional)         |
      | Microfilm serial number (optional)       |
    And I should not see
      | Text                              |
      | Axles fitted with a parking brake |
      | Axle weight (kg)                  |
      | Tyre code                         |
      | Tyre size                         |
      | Ply rating (optional)             |
      | Fitment code                      |
      | Load index                        |
      | Axle 1 to axle 2 (mm)             |
    When I set values for fields
      | Field                               | Value                |
      | edit-regnDate-1-day                 | 10                   |
      | edit-regnDate-1-month               | 12                   |
      | edit-regnDate-1-year                | 2020                 |
      | edit-manufactureYear                | 1995                 |
      | edit-dtpNumber                      | 1234                 |
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
      | edit-tyreUseCode                    | 2C                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-name                           | Applicant name       |
      | edit-address1                       | Applicant address 1  |
      | edit-address2                       | Applicant address 2  |
      | edit-postTown                       | Applicant town       |
      | edit-address3                       | Applicant address 3  |
      | edit-postCode                       | 123WXZ               |
      | edit-telephoneNumber                | 1234567890           |
      | edit-emailAddress                   | test@applicant.com   |
      | edit-microfilmDocumentType          | HGV COC + Int Plate  |
      | edit-microfilmRollNumber            | 654321               |
      | edit-microfilmSerialNumber          | 87654321             |
      | edit-notes                          | hgv notes            |
    Then I should not see
      | Text                              |
      | Axles fitted with a parking brake |
      | Axle weight (kg)                  |
      | Tyre code                         |
      | Tyre size                         |
      | Ply rating (optional)             |
      | Fitment code                      |
      | Load index                        |
      | Axle 1 to axle 2 (mm)             |
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 2     |
    # these validations that follow are for 10619
    Then I should see
      | Text                              |
      | Axles fitted with a parking brake |
      | Axle weight (kg)                  |
      | Tyre code                         |
      | Tyre size                         |
      | Ply rating (optional)             |
      | Fitment code                      |
      | Load index                        |
      | Axle 1 to axle 2 (mm)             |
      | Axle 2                            |
