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
    # AC4 + AC5 + AC6 + AC7
    When I click continue button
    Then the header error contains "There is a problem"
    And the header error contains "Enter a VIN"
    And the header error contains "Enter a VRM"
    And the header error contains "Select a vehicle type"
    And the specific "vin" error contains "Enter a VIN"
    And the specific "vrm" error contains "Enter a VRM"
    And the specific "vehicle type" error contains "Select a vehicle type"
    When I select vehicle type "trailer"
    And I click continue button
    Then the header error does not contain "Enter a VRM"
    Then the header error does not contain "Select a vehicle type"
    # AC3
    When I fill in vin "P12345678901234567890123"
    Then I should not see "P12345678901234567890123" in "vin" input field
    And I should see "P12345678901234567890" in "vin" input field
    And I fill in vrm "CT1234567890"
    And I should not see "CT1234567890" in "vrm" input field
    And I should see "CT123456" in "vrm" input field
    # AC1
    When I fill in vin "P012301230000"
    And I fill in vrm "ABCDEFGH"
    And I select vehicle type "hgv"
    And I click continue button
    Then the header error contains "There is a problem"
    And the header error contains "A technical record with this VIN already exists, check the VIN or change the existing technical record"
    And the specific "vin" error contains "A technical record with this VIN already exists, check the VIN or change the existing technical record"
    # AC2
    When I fill in vin "P012301234567"
    And I fill in vrm "CT70000"
    And I select vehicle type "psv"
    And I click continue button
    Then the header error contains "There is a problem"
    And the header error contains "A technical record with this VRM already exists, check the VIN or change the existing technical record"
    And the specific "vrm" error contains "A technical record with this VRM already exists, check the VIN or change the existing technical record"
