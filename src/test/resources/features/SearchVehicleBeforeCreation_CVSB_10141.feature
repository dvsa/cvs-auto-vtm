Feature: Search for vehicle before creation
  As an admin user I can search for a vehicle in the create vehicle page
  And make sure that the vehicle I wish to create does not already exist

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And element with id "test-create-new-vehicle" should be present
    When I go to create tech record page
    Then I should see "Create new technical record"
    Then element with id "test-vin" should be present

  Scenario: As the DVSA, we want to be able to search for a vehicle before creating it to ensure that it does not already exist
  AC1 - User does not successfully proceed (since the VIN already exists on a vehicle stored in CVS)
  AC2 - User does not successfully proceed (since the VRM already exists on a vehicle stored in CVS)
  AC3 - User cannot break a length restriction
  AC4 - User cannot proceed without entering the VIN
  AC5 - User cannot proceed without selecting a vehicle type
  AC6 - User cannot proceed without entering a VRM on a HGV/PSV (VRM is only mandatory on HGV/PSV)
  AC7 - User attempts to proceed without entering multiple mandatory fields (for example, both vehicle type and VIN)
    #AC1
    