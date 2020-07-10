Feature: CVSB-10202 + CVSB-10619 + CVSB-15867 - Create new HGVs in VTM
  As an admin user I can log in the VTM app
  And create new HGVs in VTM so that they can be tested accordingly

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to create tech record page
    Then I should see "Create new technical record"
    Then vin input field should be present


  Scenario: CVSB-10202 - I want to create new HGVs in VTM so that they can be tested accordingly
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
      | edit-microfilmRollNumber            | 65432                |
      | edit-microfilmSerialNumber          | 8765                 |
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

  Scenario: CVSB-10619 - I want to create new HGVs in VTM so that they can be tested accordingly
  AC1 -  User clicks the call to action to 'go back'
  AC2 -  Fields dynamically display, based on the 'number of axles' selected
  AC4 -  User increases the number of axles
  AC5 -  User decreases the number of axles
  AC6 -  User expands one heading
  AC7 -  User contracts one heading
  AC8 -  User clicks the call to action to "open all" headings
  AC9 -  User clicks the call to action to "close all" headings
    #AC1
    When I select vehicle type "hgv"
    And I set vin to random value
    And I set vrm to random value
    And I click "Continue" button
    Then wait until I see "Vehicle summary"
    When I click "Back" link
    Then I should see "Create new technical record"
    #AC2
    When I select vehicle type "hgv"
    And I set vin to random value
    And I set vrm to random value
    And I click "Continue" button
    Then wait until I see "Vehicle summary"
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 2     |
    Then I should see
      | Text                                     |
      | Axle 1                                   |
      | Axle 2                                   |
      | Axle weight (kg)                         |
      | Axle 1                                   |
      | GB                                       |
      | EEC (optional)                           |
      | Design                                   |
      | Axle 2                                   |
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
      | Axle 1 to axle 2 (mm)                    |
    #AC3
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 3     |
    Then I should see
      | Text                                     |
      | Axle 1 to axle 2 (mm)                    |
      | Axle 2 to axle 3 (mm)                    |
    When I set values for fields
      | Field                               | Value                |
      | edit-axleSpacing-value-1            | 110                  |
      | edit-axleSpacing-value-2            | 201                  |
    #AC4
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 4     |
    And I check values for fields
      | Field                          | Value |
      | edit-axleSpacing-value-1       | 110   |
      | edit-axleSpacing-value-2       | 201   |
    Then I should see
      | Text                                   |
      | Axle 1 to axle 2 (mm)                  |
      | Axle 2 to axle 3 (mm)                  |
      | Axle 3 to axle 4 (mm)                  |
    When I set values for fields
      | Field                          | Value |
      | edit-axleSpacing-value-3       | 426   |
    #AC5
    When I set values for fields
      | Field          | Value |
      | edit-noOfAxles | 3     |
    And I check values for fields
      | Field                          | Value |
      | edit-axleSpacing-value-1       | 110   |
      | edit-axleSpacing-value-2       | 201   |
    Then I should not see
      | Text                              |
      | Axle 3 to axle 4 (mm)             |
    #AC6 + AC9
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
      | Name                              |
      | Microfilm document type (optional)|
    When I close tech record "Dimensions" section
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
      | Name                               |
      | Microfilm document type (optional) |
    When I close tech record "Notes" section
    # AC8
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
    When I close tech record "Dimensions" section
    Then I should not see
      | Text                                         |
      | Microfilm document type (optional)           |
      | Microfilm roll number (optional)             |
      | Microfilm serial number (optional)           |
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

  @ci_bug @CVSB-17051 @CVSB-17052
  Scenario:CVSB-15867 - I want to Save and Cancel the creation of new HGVs in VTM
  AC3 -  User clicks the call to action to save the technical record, is presented with
  "Enter reason for creating technical record" modal
  AC4 -  User actually saves the technical record details (after completing the reasonForCreation modal)
  AC5 -  User cancels out of actually saving the technical record, after being presented with
  "Enter reason for creating technical record" modal
    When I select vehicle type "hgv"
    And I set vin to random value
    And I set vrm to random value
    And I click "Continue" button
    Then wait until I see "Vehicle summary"
    #AC3 (from CVSB-15867) + AC3 (from CVSB-10619)
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
      | edit-axle-3                         | checked              |
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
      | edit-gbWeight-3                     | 800                  |
      | edit-eecWeight-3                    | 700                  |
      | edit-designWeight-3                 | 700                  |
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
      | edit-tyreCode-3                     | 675                  |
      | edit-tyreSize-3                     | 3ER                  |
      | edit-plyRating-3                    | 3R                   |
      | edit-fitmentCode-3                  | single               |
      | edit-dataTrAxles-3                  | 34                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-axleSpacing-value-1            | 3500                 |
      | edit-axleSpacing-value-2            | 3500                 |
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
    #AC4
    Then I should see "Enter reason for creating technical record"
    #AC5
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
      | edit-axle-3                         | checked              |
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
      | edit-gbWeight-3                     | 800                  |
      | edit-eecWeight-3                    | 700                  |
      | edit-designWeight-3                 | 700                  |
      | edit-tyreUseCode                    | 2C                   |
      | edit-tyreCode-1                     | 675                  |
      | edit-tyreSize-1                     | 3ER                  |
      | edit-plyRating-1                    | 3R                   |
      | edit-dataTrAxles-1                  | 34                   |
      | edit-tyreCode-2                     | 675                  |
      | edit-tyreSize-2                     | 3ER                  |
      | edit-plyRating-2                    | 3R                   |
      | edit-dataTrAxles-2                  | 34                   |
      | edit-tyreCode-3                     | 675                  |
      | edit-tyreSize-3                     | 3ER                  |
      | edit-plyRating-3                    | 3R                   |
      | edit-dataTrAxles-3                  | 34                   |
      | edit-length                         | 5500                 |
      | edit-width                          | 2500                 |
      | edit-frontAxleToRearAxle            | 5000                 |
      | edit-frontAxleTo5thWheelCouplingMin | 4000                 |
      | edit-frontAxleTo5thWheelCouplingMax | 4500                 |
      | edit-frontAxleTo5thWheelMin         | 3000                 |
      | edit-frontAxleTo5thWheelMax         | 3500                 |
      | edit-axleSpacing-value-1            | 3500                 |
      | edit-axleSpacing-value-2            | 3500                 |
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
    And I should see "3" as No of axles on tech record create page
    And I should see "Hybrid" as Fuel propulsion system on tech record create page
    And I should see "heavy goods vehicle" as Vehicle class on tech record create page
    And I should see "semi-car transporter" as Vehicle configuration on tech record create page
    And I should see "n2" as EU vehicle category on tech record create page
    And I should see "NTA" as Approval type on tech record create page
    And I should see "articulated" as Body type on tech record create page
    And I should see "single" as Fitment Code on tech record create page
    And I should see "HGV COC + Int Plate" as Microfilm document type on tech record create page
    When I click the save technical record button
    Then I should see "Enter reason for creating technical record"
    When I enter "cvsb-15867" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should see "Change technical record"
    And I should not see "There is a problem"
    And tech record fields should have values
      | Field                            | Value                                         |
      | status                           | Provisional                                   |
      | record-completeness              | complete                                      |
      | functionCode                     | r                                             |
      # 'technical record history' section
      | statusCode-0                     | Provisional                                   |
      | reasonForCreation-0              | Cvsb-15867                                    |
      | createdByName-0                  | VTM_USER_EMAIL                                |
      | createdAt-0                      | TODAYS_DATE                                   |
      | lastUpdatedByName-0              | -                                             |
      | lastUpdatedAt-0                  | -                                             |
