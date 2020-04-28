Feature: Search tech record - CVSB-10089
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should see all required attributes displayed for the tech record

  Background:
    Given I login with admin credentials
    Then I should see "Vehicle testing management"
    And I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    Then search vehicle input field should be present

  @bug @CVSB-15399
  Scenario: Search using vin for HGV with current, provisional and archived tech records
  AC1 - After searching, technical record with status "current" is displayed if it exists for this vehicle in DynamoDB
  AC4 - HGV tech records are structured correctly
  AC5 - User expands/collapses one heading
  AC6 - User clicks the call to action to "open all" headings
  AC7 - User clicks the call to action to "close all" headings
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space in DynamoDB
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    # user clicks the call to action to "open all" headings
    When I open all tech record sections
    Then I should see "Vehicle type"
    Then tech record fields should have values
      | Field                               | Value                |
      # after searching, technical record with status "current" is displayed if it exists for this vehicle in DynamoDB
      | status                              | Current              |
      | vin                                 | P012301230000        |
      | vrm                                 | CT70000              |
      | vrm-0                               | CT96000              |
      | vrm-1                               | CT96001              |
      | vrm-2                               | CT96002              |
      # HGV tech records are structured correctly
      | vehicleType                         | HGV                  |
      | ntaNumber                           | 123456               |
      | regnDate                            | 25/06/2019           |
      | manufactureYear                     | 2018                 |
      | noOfaxles                           | 2                    |
      | dtpNumber                           | 1234                 |
      | parkingBrakeMrkAxle-1               | Axle 1               |
      | parkingBrakeMrkAxle-2               | Axle 2               |
      | speedLimiterMrk                     | Yes                  |
      | tachoExemptMrk                      | Yes                  |
      | euroStandard                        | 9                    |
      | roadFriendly                        | Yes                  |
      | drawbarCouplingFitted               | Yes                  |
      | vehicleClassDescription             | Heavy goods vehicle  |
      | vehicleConfiguration                | semi-car transporter |
      | make                                | Isuzu                |
      | model                               | FM                   |
      | bodyTypeDescription                 | Other                |
      | functionCode                        | A                    |
      | conversionRefNo                     | 7891234              |
      # grossGbWeight and grossDesignWeight and grossEecWeight for the displayed tech record are not in the Dynamo tech record fields which means they are null
      | grossGbWeight                       | -                    |
      | grossEecWeight                      | -                    |
      | grossDesignWeight                   | -                    |
      | trainGbWeight                       | 1500                 |
      | trainEecWeight                      |                      |
      | trainDesignWeight                   | 2000                 |
      | maxTrainGbWeight                    | 1000                 |
      | maxTrainEecWeight                   | -                    |
      | maxTrainDesignWeight                | 500                  |
      | gbWeight-1                          | 1400                 |
      | eecWeight-1                         | -                    |
      | designWeight-1                      | 1800                 |
      | gbWeight-2                          | 1600                 |
      | eecWeight-2                         | -                    |
      | designWeight-2                      | 1900                 |
      | tyreUseCode                         | 2B                   |
      | tyreCode-1                          | 1234                 |
      | tyreSize-1                          | 295/80-22.5          |
      | plyRating-1                         | AB                   |
      | fitmentCode-1                       | single               |
      | dataTrAxles-1                       | 345                  |
      | tyreCode-2                          | 5678                 |
      | tyreSize-2                          | 295/80-22.5          |
      | plyRating-2                         | AB                   |
      | fitmentCode-2                       | double               |
      | dataTrAxles-2                       | 345                  |
      | length                              | 7500                 |
      | width                               | 2200                 |
      | frontAxleTo5thWheelCouplingMin      | 1700                 |
      | frontAxleTo5thWheelCouplingMax      | 1900                 |
      | frontAxleTo5thWheelMin              | 1200                 |
      | frontAxleTo5thWheelMax              | 1500                 |
      | ableToCarry                         | No                   |
      | notes                               | test note            |
      | testCode-tRes-0-0                   | Voluntary Test       |
      | testTypeEndTimestamp-tRes-0-0       | 14/01/2019           |
      | expiryDate-tRes-0-0                 | -                    |
      | certificateNumber-tRes-0-0          | 123412345            |
      | testResult-tRes-0-0                 | PRS                  |
      | testCode-tRes-1-0                   | Retest               |
      | testTypeEndTimestamp-tRes-1-0       | 07/01/2019           |
      # expiryDate for this test is " " in Dynamo
      | expiryDate-tRes-1-0                 | -                    |
      # certificateNumber for this test is null in Dynamo
      | certificateNumber-tRes-1-0          | -                    |
      | testResult-tRes-1-0                 | ABANDONED            |
      | testCode-tRes-2-0                   | Annual Test          |
      | testTypeEndTimestamp-tRes-2-0       | 14/01/2019           |
      | expiryDate-tRes-2-0                 | 24/01/2020           |
      | certificateNumber-tRes-2-0          | 123456789            |
      | testResult-tRes-2-0                 | PASS                 |
      | statusCode-0                        | Current              |
      | reasonForCreation-0                 | New Vehicle1         |
      | createdByName-0                     | Dvsa                 |
      | createdAt-0                         | 24/06/2019           |
      | statusCode-1                        | Provisional          |
      | reasonForCreation-1                 | New Vehicle2         |
      | createdByName-1                     | Dvsa2                |
      | createdAt-1                         | 25/06/2019           |
      | statusCode-2                        | Archived             |
      | reasonForCreation-2                 | New Vehicle3         |
      # createdByName for this tech record is null in Dynamo
      | createdByName-2                     | -                    |
      | createdAt-2                         | 26/06/2019           |
    # user clicks the call to action to "close all" headings
    When I close all tech record sections
    Then I should not see "Vehicle type"
    # user expands/collapses one heading
    When I open tech record "Vehicle summary" section
    Then I should see "Vehicle type"
    When I close tech record "Vehicle summary" section
    Then I should not see "Vehicle type"


  Scenario: Search using primary vrm for HGV with only archived tech records
  AC3 - After searching, the technical record with status "archived" and most recent "createdAt" is displayed, if this vehicle
  only has technical records with status "archived" in DynamoDB
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
   When I search for vehicle with identifier "CT70001"
   Then wait until I see "Technical record"
   When I open all tech record sections
   Then tech record fields should have values
     | Field                               | Value               |
     | status                              | Archived            |
     | vin                                 | P012301230001       |
     | vrm                                 | CT70001             |
     | vrm-0                               | CT98000             |
     | vehicleType                         | HGV                 |
     | ntaNumber                           | 123453              |
     | regnDate                            | 23/06/2019          |
     | manufactureYear                     | 2011                |
     | noOfaxles                           | 1                   |
     | dtpNumber                           | 1241                |
     # there are no axles that have "parkingBrakeFitted" set to "true" in dynamo
     | parkingBrakeMrk                     | -                   |
     | speedLimiterMrk                     | Yes                 |
     | tachoExemptMrk                      | Yes                 |
     | euroStandard                        | 4                   |
     | roadFriendly                        | Yes                 |
     | drawbarCouplingFitted               | No                  |
     | vehicleClassDescription             | Heavy goods vehicle |
     # vehicleConfiguration is "  " in Dynamo
     | vehicleConfiguration                | -                   |
     | make                                | Isuzu               |
     | model                               | FM                  |
     | bodyTypeDescription                 | Other               |
     | functionCode                        | A                   |
     | conversionRefNo                     | 7891234             |
     # gross GB weight and Design weight are not set in Dynamo which is equivalent for them being null
     | grossGbWeight                       | -                   |
     | grossEecWeight                      | -                   |
     | grossDesignWeight                   | -                   |
     | trainGbWeight                       | 1500                |
     | trainEecWeight                      | -                   |
     | trainDesignWeight                   | 2000                |
     | maxTrainGbWeight                    | 1000                |
     | maxTrainEecWeight                   | -                   |
     | maxTrainDesignWeight                | 500                 |
     | gbWeight-1                          | 1400                |
     | eecWeight-1                         | -                   |
     | designWeight-1                      | 1800                |
     | eecWeight-2                         | -                   |
     | gbWeight-2                          | 1600                |
     | designWeight-2                      | 1900                |
     | tyreUseCode                         | 2B                  |
     | tyreCode-1                          | 1234                |
     | tyreSize-1                          | 295/80-22.5         |
     | plyRating-1                         | AB                  |
     | fitmentCode-1                       | single              |
     | dataTrAxles-1                       | 345                 |
     | tyreCode-2                          | 5678                |
     | tyreSize-2                          | 295/80-22.5         |
     | plyRating-2                         | AB                  |
     | fitmentCode-2                       | single              |
     | dataTrAxles-2                       | 345                 |
     | length                              | 7500                |
     | width                               | 2200                |
     | frontAxleTo5thWheelCouplingMin      | 1700                |
     | frontAxleTo5thWheelCouplingMax      | 1900                |
     | frontAxleTo5thWheelMin              | 1200                |
     | frontAxleTo5thWheelMax              | 1500                |
     | ableToCarry                         | No                  |
     | notes                               | test note           |
     | testCode-tRes-0-0                   | Voluntary Test      |
     | testTypeEndTimestamp-tRes-0-0       | 14/01/2019          |
     | expiryDate-tRes-0-0                 | 14/04/2019          |
     | certificateNumber-tRes-0-0          | 123000              |
     | testResult-tRes-0-0                 | PRS                 |
     # after searching, the technical record with status "archived" and most recent "createdAt" is displayed, if this vehicle only has technical records with status "archived" in DynamoDB
     | statusCode-0                        | Archived            |
     | reasonForCreation-0                 | New Vehicle         |
     | createdByName-0                     | Dvsa4               |
     | createdAt-0                         | 25/06/2019          |
     | lastUpdatedByName-0                 | -                   |
     | lastUpdatedAt-0                     | 24/06/2019          |
     | statusCode-1                        | Archived            |
     | reasonForCreation-1                 | New Vehicle         |
     | createdByName-1                     | Dvsa3               |
     | createdAt-1                         | 24/06/2019          |
     | lastUpdatedByName-1                 | -                   |
     | lastUpdatedAt-1                     | 24/06/2019          |
     | statusCode-2                        | Archived            |
     # reasonForCreation and createdByName for this tech record are "  " in Dynamo
     | reasonForCreation-2                 | -                   |
     | createdByName-2                     | -                   |
     | createdAt-2                         | 23/06/2019          |
     | lastUpdatedByName-2                 | -                   |
     | lastUpdatedAt-2                     | 24/06/2019          |
     | plateSerialNumber-0                 | -                   |
     | plateReasonForIssue-0               | -                   |
     | plateIssuer-0                       | -                   |
     | plateIssueDate-0                    | -                   |


  Scenario: Search using trailer id for TRL with a provisional and an archived tech record
  AC2 - After searching, technical record with status "provisional" is displayed, if this vehicle does not have a technical
  record with status "current" in DynamoDB
  AC4 - TRL tech records are structured correctly
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
    When I search for vehicle with identifier "C123456"
    Then wait until I see "Technical record"
    When I open all tech record sections
    Then wait until I see "Close all"
    Then tech record fields should have values
      | Field                            | Value            |
      # after searching, technical record with status "provisional" is displayed if it exists for this vehicle in DynamoDB
      | status                           | Provisional      |
      | vin                              | T12111000        |
      | vrm                              | CT71000          |
      | secondaryVrms                    | -                |
      | trailerId                        | C123456          |
      # TRL tech records are structured correctly
      # vehicle summary section
      | vehicleType                      | TRL              |
      | regnDate                         | -                |
      | firstUseDate                     | 24/06/2019       |
      | manufactureYear                  | 2015             |
      | noOfaxles                        | 3                |
      | dtpNumber                        | 1237             |
      | parkingBrakeMrkAxle-2            | Axle 2           |
      | parkingBrakeMrkAxle-3            | Axle 3           |
      | suspensionType                   | Y                |
      | roadFriendly                     | Yes              |
      | vehicleClassDescription          | Trailer          |
      | vehicleConfiguration             | drawbar          |
      | couplingType                     | F                |
      | maxLoadOnCoupling                | 7000             |
      | frameDescription                 | -                |
      | euVehicleCategory                | n2               |
      | departmentalVehicleMarker        | -                |
      | alterationMarker                 | -                |
      # type approval subsection
      | approvalType                     | -                |
      | approvalTypeNumber               | -                |
      | ntaNumber                        | 123459           |
      | variantNumber                    | -                |
      | variantVersionNumber             | -                |
      # body section
      | make                             | Isuzu            |
      | model                            | F06              |
      | bodyTypeDescription              | Skip Loader      |
      | functionCode                     | -                |
      | conversionRefNo                  | 7891234          |
      # weights section
      | grossGbWeight                    | 1400             |
      | grossEecWeight                   | -                |
      | grossDesignWeight                | 1900             |
      | gbWeight-1                       | 1400             |
      | eecWeight-1                      | -                |
      | designWeight-1                   | 1800             |
      | gbWeight-2                       | 1600             |
      | eecWeight-2                      | -                |
      | designWeight-2                   | 1900             |
      | gbWeight-3                       | 1600             |
      | eecWeight-3                      | -                |
      # tyres section
      | tyreUseCode                      | 2B               |
      | tyreCode-1                       | 1234             |
      | tyreSize-1                       | 295/80-22.5      |
      | plyRating-1                      | AB               |
      | fitmentCode-1                    | single           |
      | dataTrAxles-1                    | 345              |
      | tyreCode-2                       | 5678             |
      | tyreSize-2                       | -                |
      | plyRating-2                      | -                |
      | fitmentCode-2                    | -                |
      | dataTrAxles-2                    | 345              |
      | tyreCode-3                       | 5678             |
      | tyreSize-3                       | 295/80-22.5      |
      | plyRating-3                      | AB               |
      | fitmentCode-3                    | single           |
      | dataTrAxles-3                    | 345              |
      # brakes section
      | loadSensingValve                 | Yes              |
      | antilockBrakingSystem            | Yes              |
      | brakeActuator-1                  | -                |
      | leverLength-1                    | -                |
      | springBrakeParking-1             | -                |
      | brakeActuator-2                  | 113              |
      | leverLength-2                    | 125              |
      | springBrakeParking-2             | Yes              |
      | brakeActuator-3                  | 113              |
      | leverLength-3                    | 125              |
      | springBrakeParking-3             | No               |
      # dimensions section
      | length                           | 5000             |
      | width                            | 2200             |
      | frontAxleToRearAxle              | 1700             |
      | rearAxleToRearTrl                | 400              |
      | centreOfRearmostAxleToRearOfTrl  | -                |
      | axleSpacing-axles-0              | Axle 1 to 2 (mm) |
      | axleSpacing-value-0              | 1200             |
      | couplingCenterToRearAxleMin      | 1000             |
      | couplingCenterToRearAxleMax      | 900              |
      | couplingCenterToRearTrlMin       | 800              |
      | couplingCenterToRearTrlMax       | 700              |
      # ADR section
      | ableToCarry                      | No               |
      # applicant section
      | applicantDetails-name            | -                |
      | applicantDetails-address         | -                |
      | applicantDetails-postTown        | -                |
      | applicantDetails-address3        | -                |
      | applicantDetails-postCode        | -                |
      | applicantDetails-telephoneNumber | -                |
      | applicantDetails-emailAddress    | -                |
      # purchaser section
      | purchaser-name                   | -                |
      | purchaser-address                | -                |
      | purchaser-postTown               | -                |
      | purchaser-address3               | -                |
      | purchaser-postCode               | -                |
      | purchaser-telephoneNumber        | -                |
      | purchaser-emailAddress           | -                |
      | purchaser-faxNumber              | -                |
      | purchaser-purchaserNotes         | -                |
      # manufacturer section
      | manufacturer-name                | -                |
      | manufacturer-address             | -                |
      | manufacturer-postTown            | -                |
      | manufacturer-address3            | -                |
      | manufacturer-postCode            | -                |
      | manufacturer-telephoneNumber     | -                |
      | manufacturer-emailAddress        | -                |
      | manufacturer-faxNumber           | -                |
      | manufacturer-manufacturerNotes   | -                |
      | cocIssueDate                     | -                |
      | dateReceived                     | -                |
      | datePending                      | -                |
      | dateAuthorised                   | -                |
      | dateRejected                     | -                |
      | letterType                       | -                |
      | letterDateRequested              | -                |
      | letterContents                   | -                |
      | microfilmDocumentType            | -                |
      | microfilmRollNumber              | -                |
      | microfilmSerialNumber            | -                |
      | notes                            | notes            |
      | testCode-tRes-0-0                | Voluntary Test   |
      | testTypeEndTimestamp-tRes-0-0    | 14/01/2019       |
      | expiryDate-tRes-0-0              | 30/01/2019       |
      | certificateNumber-tRes-0-0       | 12343489         |
      | testResult-tRes-0-0              | FAIL             |
      | testerName-0-0                   | Gica             |
      | testCode-tRes-1-0                | Voluntary Test   |
      | testTypeEndTimestamp-tRes-1-0    | 14/01/2019       |
      | expiryDate-tRes-1-0              | -                |
      | certificateNumber-tRes-1-0       | -                |
      | testResult-tRes-1-0              | PASS             |
      | testerName-1-0                   | Gica             |
      | statusCode-0                     | Provisional      |
      | reasonForCreation-0              | Registration     |
      | createdByName-0                  | Tester           |
      | createdAt-0                      | 23/06/2019       |
      | lastUpdatedByName-0              | -                |
      | lastUpdatedAt-0                  | 24/06/2019       |
      | statusCode-1                     | Archived         |
      | reasonForCreation-1              | New Trailer      |
      | createdByName-1                  | -                |
      | createdAt-1                      | 24/06/2019       |
      | lastUpdatedByName-1              | -                |
      | lastUpdatedAt-1                  | 24/06/2019       |
      | plateSerialNumber-0              | -                |
      | plateReasonForIssue-0            | -                |
      | plateIssuer-0                    | -                |
      | plateIssueDate-0                 | -                |
    And I should not see "Speed limiter exempt"
    And I should not see "Tacho exempt"


  Scenario: Search using partial vin for TRL with a current tech record and without primary or secondary vrms and without
  any axle that is fitted with a parking brake
  AC8 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
    When I search for vehicle with identifier "111111"
    Then wait until I see "Technical record"
    When I open all tech record sections
    Then wait until I see "Close all"
    Then tech record fields should have values
      | Field           | Value       |
      | status          | Current     |
      | vin             | T12111111   |
      | vrm             | -           |
      | secondaryVrms   | -           |
      | parkingBrakeMrk | -           |
