Feature: CVSB-11329 - Search for vehicle in VTM when the full VIN is less than 9 characters
  This story will allow the DVSA to be able to search for a vehicle using:
  The last 6-characters of the VIN, in the scenario where these last 6 characters (can also be special characters) contain letters, not only numbers.
  The full VIN, in case that the VIN has 8 or less digits.

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    Then I should see "Search for a technical record"
    Then search vehicle input field should be present

  
  Scenario: As the DVSA, we want to be able to search for a vehicle using all possible search criterion
  AC1 - The search criteria selectors are displayed on the search screen
  AC2 - User selects the search criteria
  AC4 - Update error message when no technical record is returned
    # AC1 + AC2 + AC4
    Then "Vehicle registration mark, trailer ID or vehicle identification number" search option should be selected
    And other search criteria include "Vehicle registration mark (VRM)"
    And other search criteria include "Full vehicle identification number (VIN)"
    And other search criteria include "Partial VIN (last 6 characters)"
    And other search criteria include "Trailer ID"
    # search by entering random string using all search criterion
    When I search for vehicle using wrong identifier "random"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    When I select "Vehicle registration mark (VRM)" search criteria
    Then "Vehicle registration mark (VRM)" search option should be selected
    # search by entering random string using just VRM as search criteria
    When I search for vehicle using wrong identifier "random"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    When I select "Full vehicle identification number (VIN)" search criteria
    Then "Full vehicle identification number (VIN)" search option should be selected
    # search by entering random string using just VIN as search criteria
    When I search for vehicle using wrong identifier "random"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    When I select "Partial VIN (last 6 characters)" search criteria
    Then "Partial VIN (last 6 characters)" search option should be selected
    # search by entering random string using just partial VIN as search criteria
    When I search for vehicle using wrong identifier "random"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    When I select "Trailer ID" search criteria
    Then "Trailer ID" search option should be selected
    # search by entering random string using just Trailer ID as search criteria
    When I search for vehicle using wrong identifier "random"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"


  Scenario: As the DVSA, we want to be able to search for a vehicle using all possible search criterion
  AC3 - VSA submits the search input - search identifier and search criteria
    # AC3
    # using all search criterion
    # search by entering correct VIN string
    When I search for vehicle with identifier "P012301230123"
    Then wait until I see "Vehicle summary"
    # search by entering correct partial VIN string
    When I go back to previous page
    Then search vehicle input field should be present
    When I search for vehicle with identifier "230123"
    Then wait until I see "Vehicle summary"
    # search by entering correct primary VRM string
    When I go back to previous page
    Then search vehicle input field should be present
    When I search for vehicle with identifier "AD35GHT"
    Then wait until I see "Vehicle summary"
    # search by entering correct trailer id string
    When I go back to previous page
    Then search vehicle input field should be present
    When I search for vehicle with identifier "C000002"
    Then wait until I see "Vehicle summary"
    # search by entering correct VIN string that is under 8 characters
    When I go back to previous page
    Then search vehicle input field should be present
    When I search for vehicle using wrong identifier "VIN1"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"

    # using primary vrm as search criteria
    When I select "Vehicle registration mark (VRM)" search criteria
    # search by entering correct primary VRM string
    When I search for vehicle with identifier "AD35GHT"
    Then wait until I see "Vehicle summary"
    # search by entering correct VIN string when search criteria is primary VRM
    When I go back to previous page
    Then search vehicle input field should be present
    When I select "Vehicle registration mark (VRM)" search criteria
    When I search for vehicle using wrong identifier "P012301230123"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"

    # using VIN as search criteria
    When I select "Full vehicle identification number (VIN)" search criteria
    # search by entering correct VIN string
    When I search for vehicle with identifier "VIN1"
    Then wait until I see "Vehicle summary"
    # search by entering correct primary VRM string when search criteria is VIN
    When I go back to previous page
    Then search vehicle input field should be present
    When I select "Full vehicle identification number (VIN)" search criteria
    When I search for vehicle using wrong identifier "AD35GHT"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"

    # using partial VIN as search criteria
    When I select "Partial VIN (last 6 characters)" search criteria
    # search by entering correct partial VIN string
    When I search for vehicle with identifier "230123"
    Then wait until I see "Vehicle summary"
    # search by entering correct VIN string when search criteria is partial VIN
    When I go back to previous page
    Then search vehicle input field should be present
    When I select "Partial VIN (last 6 characters)" search criteria
    When I search for vehicle using wrong identifier "P012301230123"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"

    # using trailer id as search criteria
    When I select "Trailer ID" search criteria
    # search by entering correct trailer id string
    When I search for vehicle with identifier "C000002"
    Then wait until I see "Vehicle summary"
    # search by entering correct VIN string when search criteria is trailer id
    When I go back to previous page
    Then search vehicle input field should be present
    When I select "Trailer ID" search criteria
    When I search for vehicle using wrong identifier "P012301230123"
    Then the header error contains "There is a problem"
    And the header error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
    And the specific error contains "Vehicle not found, check the vehicle registration mark, trailer ID, vehicle identification number or change the search criteria to find a vehicle"
