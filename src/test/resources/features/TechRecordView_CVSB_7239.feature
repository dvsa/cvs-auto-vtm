Feature: Search tech record
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should see all required attributes displayed for the tech record

  Background:
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"


  Scenario: Search using vin for HGV with current, provisional and archived tech records
  AC1 - After searching, technical record with status "current" is displayed if it exists for this vehicle in DynamoDB
  AC4 - HGV tech records are structured correctly
  AC5 - User expand/collapses one heading
  AC6 - User clicks the call to action to "open all" headings
  AC7 - User clicks the call to action to "close all" headings
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space in DynamoDB
    Given I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    When I open all sections
    Then I should see "Vehicle type"
    Then hgv tech record fields should have values
      | Field                          | Value                |
      | status                         | Current              |
      | vin                            | P012301230000        |
      | vrm                            | CT70000              |
      | vrm-0                          | CT96000              |
      | vrm-1                          | CT96001              |
      | vrm-2                          | CT96002              |
      | vehicleType                    | HGV                  |
      | ntaNumber                      | 123456               |
      | regnDate                       | 25/06/2019           |
      | manufactureYear                | 2018                 |
      | noOfaxles                      | 2                    |
      | dtpNumber                      | 1234                 |
      | parkingBrakeMrkAxle-1          | Axle 1               |
      | parkingBrakeMrkAxle-2          | Axle 2               |
      | speedLimiterMrk                | YES                  |
      | tachoExemptMrk                 | YES                  |
      | euroStandard                   | 9                    |
      | roadFriendly                   | YES                  |
      | drawbarCouplingFitted          | YES                  |
      | vehicleClassDescription        | Heavy goods vehicle  |
      | vehicleConfiguration           | Semi-car transporter |
      | make                           | Isuzu                |
      | model                          | FM                   |
      | bodyTypeDescription            | Other                |
      | functionCode                   | A                    |
      | conversionRefNo                | 7891234              |
      # grossGbWeight and grossDesignWeight for the displayed tech record are not in the Dynamo tech record fields which means they are null
      | grossGbWeight                  | -                    |
      | grossDesignWeight              | -                    |
      | trainGbWeight                  | 1500                 |
      | trainDesignWeight              | 2000                 |
      | maxTrainGbWeight               | 1000                 |
      | minTrainGbWeight               | 500                  |
      | gbWeight-1                     | 1400                 |
      | designWeight-1                 | 1800                 |
      | gbWeight-2                     | 1600                 |
      | designWeight-2                 | 1900                 |
      | tyreUseCode                    | 2B                   |
      | tyreCode-1                     | 1234                 |
      | tyreSize-1                     | 295/80-22.5          |
      | plyRating-1                    | AB                   |
      | fitmentCode-1                  | single               |
      | dataTrAxles-1                  | 345                  |
      | tyreCode-2                     | 5678                 |
      | tyreSize-2                     | 295/80-22.5          |
      | plyRating-2                    | AB                   |
      | fitmentCode-2                  | double               |
      | dataTrAxles-2                  | 345                  |
      | length                         | 7500                 |
      | width                          | 2200                 |
      | frontAxleTo5thWheelCouplingMin | 1700                 |
      | frontAxleTo5thWheelCouplingMax | 1900                 |
      | frontAxleTo5thWheelMin         | 1200                 |
      | frontAxleTo5thWheelMax         | 1500                 |
      | notes                          | test note            |
      | testCode-0                     | Aav2                 |
      | testEndTimestamp-0             | 14/01/2019           |
      | expiryDate-0                   | 24/01/2020           |
      | certificateNumber-0            | 123456789            |
      | testResult-0                   | PASS                 |
      | testCode-1                     | Aav2                 |
      | testEndTimestamp-1             | 15/01/2019           |
      # expiryDate for this test is " " in Dynamo
      | expiryDate-1                   | -                    |
      # certificateNumber for this test is null in Dynamo
      | certificateNumber-1            | -                    |
      | testResult-1                   | ABANDONED            |
      | testCode-2                     | Aav2                 |
      | testEndTimestamp-2             | 16/10/2019           |
      | expiryDate-2                   | 17/01/2019           |
      | certificateNumber-2            | 123412345            |
      | testResult-2                   | PRS                  |
      | statusCode-0                   | Current              |
      | reasonForCreation-0            | New Vehicle1         |
      | createdByName-0                | Dvsa                 |
      | createdAt-0                    | 24/06/2019           |
      | statusCode-1                   | Provisional          |
      | reasonForCreation-1            | New Vehicle2         |
      | createdByName-1                | Dvsa2                |
      | createdAt-1                    | 25/06/2019           |
      | statusCode-2                   | Archived             |
      | reasonForCreation-2            | New Vehicle3         |
      # createdByName for this tech record is null in Dynamo
      | createdByName-2                | -                    |
      | createdAt-2                    | 26/06/2019           |
    When I close all sections
    Then I should not see "Vehicle type"
    When I open "Vehicle summary" section
    Then I should see "Vehicle type"
    When I close "Vehicle summary" section
    Then I should not see "Vehicle type"


  Scenario: Search using primary vrm for HGV with only archived tech records
  AC3 - After searching, the technical record with status "archived" and most recent "createdAt" is displayed, if this vehicle only has technical records with status "archived" in DynamoDB
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
    Given I search for vehicle with identifier "CT70001"
    Then wait until I see "Technical record"
    Then I open all sections
    Then hgv tech record fields should have values
      | Field                          | Value         |
      | status                         | Archived      |
      | vin                            | P012301230001 |
      | vrm                            | CT70001       |
      | vrm-0                          | CT98000       |
      | vehicleType                    | HGV           |
      # ntaNumber and regnDate for the displayed tech record are "  " in Dynamo
      | ntaNumber                      | -             |
      | regnDate                       | -             |
      | manufactureYear                | 2013          |
      | noOfaxles                      | 1             |
      # dtpNumber for the displayed tech record is "  " in Dynamo
      | dtpNumber                      | -             |
      | parkingBrakeMrkAxle-1          | Axle 1        |
      | speedLimiterMrk                | NO            |
      | tachoExemptMrk                 | NO            |
      # euroStandard for the displayed tech record "  " in Dynamo
      | euroStandard                   | -             |
      | roadFriendly                   | NO            |
      | drawbarCouplingFitted          | NO            |
      # vehicleClass description, vehicleConfiguration, make and model for the displayed tech record are "  " in Dynamo
      | vehicleClassDescription        | -             |
      | vehicleConfiguration           | -             |
      | make                           | -             |
      | model                          | -             |
      # bodyType description is null in Dynamo
      | bodyTypeDescription            | -             |
      # functionCode, conversionRefNo for the displayed tech record are "  " in Dynamo
      | functionCode                   | -             |
      | conversionRefNo                | -             |
      | grossGbWeight                  | 1400          |
      | grossDesignWeight              | 1900          |
      | trainGbWeight                  | 1500          |
      | trainDesignWeight              | 2000          |
      | maxTrainGbWeight               | 1000          |
      | minTrainGbWeight               | 500           |
      | gbWeight-1                     | 1400          |
      | designWeight-1                 | 1800          |
      # tyreUseCode for the displayed tech record are for"  " in Dynamo
      | tyreUseCode                    | -             |
      | tyreCode-1                     | 1234          |
      # tyreSize, plyRating, fitmentCode for the displayed tech record are "  " in Dynamo
      | tyreSize-1                     | -             |
      | plyRating-1                    | -             |
      | fitmentCode-1                  | -             |
      | dataTrAxles-1                  | 345           |
      | length                         | 7500          |
      | width                          | 2500          |
      | frontAxleTo5thWheelCouplingMin | 1700          |
      | frontAxleTo5thWheelCouplingMax | 1900          |
      | frontAxleTo5thWheelMin         | 1200          |
      | frontAxleTo5thWheelMax         | 1500          |
      # notes for the displayed tech record is "  " in Dynamo
      | notes                          | -             |
      | testCode-0                     | Aav2          |
      | testEndTimestamp-0             | 19/01/2019    |
      | expiryDate-0                   | 14/04/2019    |
      | certificateNumber-0            | 123000        |
      | testResult-0                   | PRS           |
      | statusCode-0                   | Archived      |
      # reasonForCreation and createdByName for this tech record are "  " in Dynamo
      | reasonForCreation-0            | -             |
      | createdByName-0                | -             |
      | createdAt-0                    | 23/06/2019    |
      | statusCode-1                   | Archived      |
      | reasonForCreation-1            | New Vehicle   |
      | createdByName-1                | Dvsa3         |
      | createdAt-1                    | 24/06/2019    |
      | statusCode-2                   | Archived      |
      | reasonForCreation-2            | New Vehicle   |
      | createdByName-2                | Dvsa4         |
      | createdAt-2                    | 25/06/2019    |


  Scenario: Search using trailer id for TRL with a provisional and an archived tech record
  AC2 - After searching, technical record with status "provisional" is displayed, if this vehicle does not have a technical record with status "current" in DynamoDB
  AC4 - TRL tech records are structured correctly
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
    Given I search for vehicle with identifier "C123456"
    Then wait until I see "Technical record"
    When I open all sections
    Then wait until I see "Close all"
    Then trl tech record fields should have values
      | Field                       | Value        |
      | status                      | Provisional  |
      | vin                         | T12111000    |
      | vrm                         | 112233Z      |
      | secondaryVrms               | -            |
      | vehicleType                 | TRL          |
      | ntaNumber                   | 123459       |
      | manufactureYear             | 2015         |
      | noOfaxles                   | 3            |
      | dtpNumber                   | 1237         |
      | parkingBrakeMrkAxle-2       | Axle 2       |
      | parkingBrakeMrkAxle-3       | Axle 3       |
      | loadSensingValve            | YES          |
      | antilockBrakingSystem       | YES          |
      | brakeActuator               | 113          |
      | leverLength                 | 125          |
      | springBrakeParking          | YES          |
      | suspensionType              | Y            |
      | roadFriendly                | YES          |
      | vehicleClassDescription     | Trailer      |
      | vehicleConfiguration        | Drawbar      |
      | couplingType                | F            |
      | maxLoadOnCoupling           | 7000         |
      | make                        | Isuzu        |
      | model                       | F06          |
      | bodyTypeDescription         | Skip Loader  |
      | conversionRefNo             | 7891234      |
      | grossGbWeight               | 1400         |
      | grossDesignWeight           | 1900         |
      | gbWeight-1                  | 1400         |
      | designWeight-1              | 1800         |
      | gbWeight-2                  | 1600         |
      | designWeight-2              | 1900         |
      | gbWeight-3                  | 1600         |
      | designWeight-3              | 1900         |
      | tyreUseCode                 | 2B           |
      | tyreCode-1                  | 1234         |
      | tyreSize-1                  | 295/80-22.5  |
      | plyRating-1                 | AB           |
      | fitmentCode-1               | single       |
      | dataTrAxles-1               | 345          |
      | tyreCode-2                  | 5678         |
      # tyreSize, plyRating for this axle are both null in Dynamo
      | tyreSize-2                  | -            |
      | plyRating-2                 | -            |
      # fitmentCode for this axle " " in Dynamo
      | fitmentCode-2               | -            |
      | dataTrAxles-2               | 345          |
      | tyreCode-3                  | 5678         |
      | tyreSize-3                  | 295/80-22.5  |
      | plyRating-3                 | AB           |
      | fitmentCode-3               | single       |
      | dataTrAxles-3               | 345          |
      | length                      | 5000         |
      | width                       | 2200         |
      | frontAxleToRearAxle         | 1700         |
      | rearAxleToRearTrl           | 400          |
      | couplingCenterToRearAxleMin | 1000         |
      | couplingCenterToRearAxleMax | 900          |
      | couplingCenterToRearTrlMin  | 800          |
      | couplingCenterToRearTrlMax  | 700          |
      | notes                       | notes        |
      | testCode-0                  | Aav2         |
      | testEndTimestamp-0          | 17/01/2019   |
      # expiryDate and certificateNumber for this test are both null in Dynamo
      | expiryDate-0                | -            |
      | certificateNumber-0         | -            |
      | testResult-0                | PASS         |
      | testCode-1                  | Aav2         |
      | testEndTimestamp-1          | 18/10/2019   |
      | expiryDate-1                | 30/01/2019   |
      | certificateNumber-1         | 12343489     |
      | testResult-1                | FAIL         |
      | statusCode-0                | Provisional  |
      | reasonForCreation-0         | Registration |
      | createdByName-0             | Tester       |
      | createdAt-0                 | 23/06/2019   |
      | statusCode-1                | Archived     |
      | reasonForCreation-1         | New Trailer  |
      # createdByName for this tech record is " " in Dynamo
      | createdByName-1             | -            |
      | createdAt-1                 | 24/06/2019   |
    And I should not see "Date of first registration"
    And I should not see "Speed limiter exempt"
    And I should not see "Tacho exempt"


  Scenario: Search using partial vin for TRL with a current tech record and without primary or secondary vrms and without any axle that is fitted with a parking brake
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
    Given I search for vehicle with identifier "111111"
    Then wait until I see "Technical record"
    When I open all sections
    Then wait until I see "Close all"
    Then trl tech record fields should have values
      | Field           | Value       |
      | status          | Current     |
      | vin             | T12111111   |
      | vrm             | -           |
      | secondaryVrms   | -           |
      | parkingBrakeMrk | -           |
