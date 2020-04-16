Feature: Adr details array appending - CVSB-11030
  As an admin user I can download any file type
  After I previously upload them

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "hgv" vehicle with adr details
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: User uploads and downloads all supported file types
  AC1 - User can upload and download documents of any type
    # AC1
    When I search for previously created vehicle
    Then I should see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open "ADR" section
    Then I should see "Upload document"
    And I upload adr document "sample.pdf"
    Then I confirm adr document "sample.pdf" is uploaded
    And I upload adr document "sample-1.pdf"
    Then I confirm adr document "sample-1.pdf" is uploaded
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-11030" as reason for changes
    And I confirm saving the details
    Then I should not see "Save technical record"
    And I should not see "There is a problem"
    And I confirm adr document "sample.pdf" is added on the tank details
    And I confirm adr document "sample-1.pdf" is added on the tank details
    When I download tank document "sample.pdf"
    And I should not see "There is a problem"
    When I download tank document "sample-1.pdf"
    And I should not see "There is a problem"
