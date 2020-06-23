Feature: ADR error handling for initial release - CVSB-14486
  As an admin user I can log in the VTM app
  After I search for a tech record
  And I try to edit adr details
  I proper errors shown if I don't fill all ADR fields properly

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: User add specific adr details like UN number, subsequent inspection, guidance not or dangerous good
  AC1 - User attempts to save data after exceeding a length restriction
  AC2 - User attempts to save data without having populated a mandatory field
  AC3 - User attempts to save data after entering letters or special characters in a 'number-only' field (can not be validated
  via automated test)
    When I search for vehicle with identifier "ABCDEFGH654321"
    Then wait until I see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    # AC2
    And I fill in applicant name with ""
    # AC1
    And I fill in applicant postcode with "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    # AC3 - can not be validated via automated test because of cross browser compatibility issues
    # And I fill in tank year of manufacture with "201O"
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-14486" as reason for tech record changes
    And I confirm saving the tech record changes
    And I should see "Save technical record"
    And I should see "There is a problem"
    And I should see error message ""adrDetails.applicantDetails.name" is not allowed to be empty"
    And I should see error message ""adrDetails.applicantDetails.postcode" length must be less than or equal to 25 characters long"
    When I click "Cancel" link
    Then I should not see "There is a problem"
