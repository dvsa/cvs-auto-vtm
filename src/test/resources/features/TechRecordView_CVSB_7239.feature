Feature: Search tech record
  As an admin user I can log in the VTM app
  And search for tech records using Vin, primary Vrm, partial Vin or trailerId

  Background:
    Given I login with admin credentials
    Then I should see "CVS VTM Application"


  Scenario: HGV tech record page with current, provisional and archived tech records
    Given I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    Then I should open all sections
    Then hgv tech record field should have value
      | Field                          | Value                |
      | status                         | Current              |
      | vin                            | P012301230000        |
      | vrm                            | CT70000              |
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
      | frontAxleTo5thWheelCouplingMin | -                    |
      | frontAxleTo5thWheelCouplingMax | -                    |
      | frontAxleTo5thWheelMin         | 1200                 |
      | frontAxleTo5thWheelMax         | 1500                 |
      | notes                          | test note            |
      | testCode-0                     | Aav2                 |
      | testEndTimestamp-0             | 14/01/2019           |
      | expiryDate-0                   | -                    |
      | certificateNumber-0            | 123456789            |
      | testResult-0                   | PASS                 |
      | testCode-1                     | Aav2                 |
      | testEndTimestamp-1             | 14/01/2019           |
      | expiryDate-1                   | -                    |
      | certificateNumber-1            | -                    |
      | testResult-1                   | ABANDONED            |
      | testCode-2                     | Aav2                 |
      | testEndTimestamp-2             | 14/01/2019           |
      | expiryDate-2                   | -                    |
      | certificateNumber-2            | 123412345            |
      | testResult-2                   | PRS                  |
      | statusCode-0                   | Current              |
      | reasonForCreation-0            | New Vehicle1         |
      | createdBy-0                    | Dvsa                 |
      | createdAt-0                    | 24/06/2019           |
      | statusCode-1                   | Provisional          |
      | reasonForCreation-1            | New Vehicle2         |
      | createdBy-1                    | Dvsa2                |
      | createdAt-1                    | 25/06/2019           |
      | statusCode-2                   | Archived             |
      | reasonForCreation-2            | New Vehicle3         |
      | createdBy-2                    | -                    |
      | createdAt-2                    | 26/06/2019           |
#      | vrm-1                          | CT96000              |
#      | vrm-2                          | CT96001              |
#      | vrm-3                          | CT96002              |

  @skip
  Scenario: HGV tech record page with only archived tech records and multiple records with values only space characters
    Given I search for vehicle with identifier "230001"
    Then wait until I see "Technical record"
    Then I should open all sections
    Then hgv tech record field should have value
      | Field                          | Value         |
      | status                         | Archived      |
      | vin                            | P012301230001 |
      | vrm                            | CT70001       |
      | vehicleType                    | HGV           |
      | ntaNumber                      | -             |
      | regnDate                       | -             |
      | manufactureYear                | 2013          |
      | noOfaxles                      | 1             |
      | dtpNumber                      | -             |
      | parkingBrakeMrkAxle-1          | Axle 1        |
      | speedLimiterMrk                | NO            |
      | tachoExemptMrk                 | NO            |
      | euroStandard                   | -             |
      | roadFriendly                   | NO            |
      | drawbarCouplingFitted          | NO            |
      | vehicleClassDescription        | -             |
      | vehicleConfiguration           | -             |
      | make                           | -             |
      | model                          | -             |
      | bodyTypeDescription            | -             |
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
      | tyreUseCode                    | -             |
      | tyreCode-1                     | 1234          |
      | tyreSize-1                     | -             |
      | plyRating-1                    | -             |
      | fitmentCode-1                  | -             |
      | dataTrAxles-1                  | 345           |
      | length                         | 7500          |
      | width                          | 2500          |
      | frontAxleTo5thWheelCouplingMin | -             |
      | frontAxleTo5thWheelCouplingMax | -             |
      | frontAxleTo5thWheelMin         | 1200          |
      | frontAxleTo5thWheelMax         | 1500          |
      | notes                          | -             |
#      | testCode-0                     | Aav2          |
#      | testEndTimestamp-0             | 14/01/2019    |
#      | expiryDate-0                   | -             |
#      | certificateNumber-0            | 123000        |
#      | testResult-0                   | PRS           |
      | statusCode-0                   | Archived      |
      | reasonForCreation-0            | -             |
      | createdBy-0                    | -             |
      | createdAt-0                    | 23/06/2019    |
      | statusCode-1                   | Archived      |
      | reasonForCreation-1            | New Vehicle   |
      | createdBy-1                    | Dvsa3         |
      | createdAt-1                    | 24/06/2019    |
      | statusCode-2                   | Archived      |
      | reasonForCreation-2            | New Vehicle   |
      | createdBy-2                    | Dvsa4         |
      | createdAt-2                    | 25/06/2019    |
#      | vrm-1                          | CT96000       |

  @skip
  Scenario: HGV tech record page with only one current tech records and multiple records with value null
    Given I search for vehicle with identifier "CT70002"
    Then wait until I see "Technical record"
    Then I should open all sections
    Then hgv tech record field should have value
      | Field                          | Value         |
      | status                         | Current       |
      | vin                            | P012301230002 |
      | vrm                            | CT70002       |
      | vehicleType                    | HGV           |
      | ntaNumber                      | -             |
      | regnDate                       | -             |
      | manufactureYear                | -             |
      | noOfaxles                      | 2             |
      | dtpNumber                      | -             |
#      | parkingBrakeMrkAxle-1          | -             |
      | speedLimiterMrk                | -             |
      | tachoExemptMrk                 | -             |
      | euroStandard                   | -             |
      | roadFriendly                   | NO            |
      | drawbarCouplingFitted          | -             |
      | vehicleClassDescription        | -             |
      | vehicleConfiguration           | -             |
      | make                           | -             |
      | model                          | -             |
      | bodyTypeDescription            | -             |
      | functionCode                   | -             |
      | conversionRefNo                | -             |
      | grossGbWeight                  | -             |
      | grossDesignWeight              | -             |
      | trainGbWeight                  | -             |
      | trainDesignWeight              | -             |
      | maxTrainGbWeight               | -             |
      | minTrainGbWeight               | -             |
      | gbWeight-1                     | -             |
      | designWeight-1                 | -             |
      | gbWeight-2                     | -             |
      | designWeight-2                 | -             |
      | tyreUseCode                    | -             |
      | tyreCode-1                     | -             |
      | tyreSize-1                     | -             |
      | plyRating-1                    | -             |
      | fitmentCode-1                  | -             |
      | dataTrAxles-1                  | -             |
      | tyreCode-2                     | 5678          |
      | tyreSize-2                     | 295/80-22.5   |
      | plyRating-2                    | AB            |
      | fitmentCode-2                  | single        |
      | dataTrAxles-2                  | 345           |
      | length                         | -             |
      | width                          | -             |
      | frontAxleTo5thWheelCouplingMin | -             |
      | frontAxleTo5thWheelCouplingMax | -             |
      | frontAxleTo5thWheelMin         | -             |
      | frontAxleTo5thWheelMax         | -             |
      | notes                          | -             |
      | statusCode-0                   | Current       |
      | reasonForCreation-0            | -             |
      | createdBy-0                    | -             |
      | createdAt-0                    | 24/06/2019    |
#      | vrm-1                          | CT97001       |
