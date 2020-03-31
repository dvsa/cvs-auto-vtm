Feature: Adr details array appending
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to add specific adr details

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And element with id "test-search-vehicle" should be present

  @skip
  # because of ADR refactoring
  Scenario: User add specific adr details like UN number, subsequent inspection, guidance not or dangerous good
  AC1 - User clicks the call to action to "Add a UN number" (dynamo array = productListUnNo[])
  AC2 - User clicks the call to action to "Add a subsequent inspection" (dynamo array = tc3Details[])
  AC3 - User clicks the call to action to "Add a guidance note" (dynamo array = number[])
  AC4 - User clicks the call to action to "Add a dangerous good" (dynamo array = permittedDangerousGoods[])
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I open "ADR" section
    Then I should see "Change technical record"
    When I click the change technical record button
    Then I should see "Save technical record"
    #user adds a custom dangerous good using the "Add a dangerous good" link from "Permitted dangerous goods" sub-section
    When I input "test" custom dangerous good
    And I click "Add a dangerous good" adr details link
    And I select "test" custom dangerous good
    #user adds a guidance note using the "Add a guidance note" link from "Guidance notes" sub-section
    When I input "test" custom guidance note
    And I click "Add a guidance note" adr details link
    And I select "test" custom guidance note
    #user adds a UN number using the "Add a UN number" link from "Product List" sub-section under "Substances permitted" section
    When I select "Rigid tank" vehicle type
    And I select "Product List" from tank statement
    Then I should see "UN number" product list field
    When I click "Add a UN number" adr details link
    And I input "1234" as new UN number
    #user adds a subsequent inspection using the "Add a subsequent inspection" link from "Tank inspections" sub-section
    When I click "Add a subsequent inspection" adr details link
    Then I should see "Subsequent"
    And I should see the subsequent inspection fields
