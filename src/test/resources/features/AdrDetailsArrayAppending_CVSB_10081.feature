Feature: Adr details array appending - CVSB-10081
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to add specific adr details

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "hgv" vehicle with adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: User add specific adr details like UN number, subsequent inspection, guidance not or dangerous good
  AC1 - User clicks the call to action to "Add a UN number" (dynamo array = productListUnNo[])
  AC2 - User clicks the call to action to "Add a subsequent inspection" (dynamo array = tc3Details[])
#  AC3 - User clicks the call to action to "Add a guidance note" (dynamo array = number[])
#  AC4 - User clicks the call to action to "Add a dangerous good" (dynamo array = permittedDangerousGoods[])
    When I search for previously created vehicle
    Then I should see "Technical record"
    And I should see "ADR" section heading
    And I should see the vin of newly created vehicle
    And I should see the vrm of newly created vehicle
    And tech record fields should have values
      | Field  | Value       |
      | status | Provisional |
    Then I should see "Change technical record"
    When I open "ADR" section
    And I click the change technical record button
    Then I should see "Save technical record"
    #user adds a UN number using the "Add a UN number" link from "Product List" sub-section under "Substances permitted" section
    When I select substances permitted "class UN number" option
    Then I should see "Statement"
    Then I should see "Product list"
    When I select "Product list" from tank statement
    Then I should see "UN number" product list field
    And I should see "Add a UN number" hyperlink
    When I input "1234567890" as reference number
    And I input "UN1234" as new UN number
    And I add UN number "UN2345"
    And I add UN number "UN3456"
    And I remove UN number with index 2
    Then I should not see "UN2345"
    #user adds a subsequent inspection using the "Add a subsequent inspection" link from "Tank inspections" sub-section
    When I add initial inspection with certificate "123456" and expiry date "20/09/2020"
    And I click "Add a subsequent inspection" adr details link
    Then I should see "Subsequent"
    And I should see "Inspection type"
    When I add subsequent inspection with index 1 of type "Intermediate" with certificate "456789" and expiry date "20/10/2020"
    And I click the save technical record button
    And I enter "cvsb-10081" as reason for changes
    And I confirm saving the details
    Then I should not see "Save technical record"
    And I should not see "There is a problem"
    And I should not see "UN2345"
    Then tech record fields should have values
      | Field                     | Value        |
      | ADR-productListUnNo-0     | UN1234       |
      | ADR-productListUnNo-1     | UN3456       |
      | tc2Type                   | Initial      |
      | tc2IntermediateApprovalNo | 123456       |
      | tc2IntermediateExpiryDate | 20/09/2020   |
      | tc3Type-0                 | Intermediate |
      | tc3PeriodicNumber-0       | 456789       |
      | tc3PeriodicExpiryDate-0   | 20/10/2020   |
