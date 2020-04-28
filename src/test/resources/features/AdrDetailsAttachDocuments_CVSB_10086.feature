Feature: Attaching documents to the ADR record + Upload + Download Attachments - CVSB-10086 + CVSB-10254
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to attach documents in ADR section

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present


  Scenario: Attaching documents to the ADR record
  AC1 - User selected a vehicle type that contained the word 'battery' or 'tank', and is therefore able to attach documents to the ADR record
  AC2 - User uploads documents to the ADR record
  AC3 - User uploads a document, cancels the "changing of the record", so therefore the document is not present in VTM
  AC4 - User uploads a document, saves the "changing of the record"
  AC5 - User 'removes' a document
  AC6 - User 'removes' a document, cancels the "changing of the record", so therefore the document is not removed
  AC7 - User 'removes' a document, saves the "changing of the record", so therefore the document is removed
  AC8 - User clicks the call to action 'view' a document
    # AC1
    When I search for vehicle with identifier "ABCDEFGH654321"
    Then I should see "Technical record"
    And I should see "ADR" section heading
    Then I should see "Change technical record"
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    Then I should see "Upload document"
    # AC2
    And I upload adr document
    Then I confirm adr document is uploaded
    # AC3
    When I click "Cancel" link
    Then I confirm adr document is not added on the tank details
    # AC4
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    And I upload adr document
    Then I confirm adr document is uploaded
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10086" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should not see "Save technical record"
    And I should not see "There is a problem"
    And I confirm adr document is added on the tank details
    # AC8
    When I download tank document with index 1
    And I should not see "There is a problem"
    # AC5
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    And I remove all adr documents
    Then I confirm adr documents are removed from the tank details
    Then I should see "-" in the adr "Tank documents" subsection
    # AC6
    When I click "Cancel" link
    Then I should see "Change technical record"
    When I open tech record "ADR" section
    Then I confirm adr documents are not deleted from the tank details
    # AC7
    When I click the change technical record button
    Then I should see "Save technical record"
    When I open tech record "ADR" section
    And I remove all adr documents
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-10086" as reason for tech record changes
    And I confirm saving the tech record changes
    And I should not see "Save technical record"
    And I should not see "There is a problem"
    And I confirm adr documents are deleted from the tank details
