Feature: Search tech record
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to add specific adr details

  Background:
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And element with id "searchIdentifier" should be present


  Scenario: Search using vin for HGV with current, provisional and archived tech records
  AC1 - HGV tech records are structured correctly, ADR heading is now present
  AC2 - ADR heading contains the correct attributes
  AC3 - "-" is displayed, when an attribute has a value of 'null' or space within DynamoDB
  AC4 - User can see if an ADR record has documents attached
  AC5 - User clicks the call to action 'download' a document
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "Technical record"
    When I open "ADR" section
    Then I should see "Change technical record"
