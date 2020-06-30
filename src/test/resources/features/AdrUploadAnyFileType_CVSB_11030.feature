Feature: CVSB-11030 - Supported file types upload/download
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
    When I open tech record "ADR" section
    Then I should see "Upload document"
    And I upload adr document "sample.pdf"
    Then I confirm adr document "sample.pdf" is uploaded
    And I upload adr document "example.ADR"
    Then I confirm adr document "example.ADR" is uploaded
    And I upload adr document "example.doc"
    Then I confirm adr document "example.doc" is uploaded
    And I upload adr document "example.docx"
    Then I confirm adr document "example.docx" is uploaded
    And I upload adr document "example.File"
    Then I confirm adr document "example.File" is uploaded
    And I upload adr document "example.html"
    Then I confirm adr document "example.html" is uploaded
    And I upload adr document "example.jpeg"
    Then I confirm adr document "example.jpeg" is uploaded
    And I upload adr document "example.oxps"
    Then I confirm adr document "example.oxps" is uploaded
    And I upload adr document "example.png"
    Then I confirm adr document "example.png" is uploaded
    And I upload adr document "example.tiff"
    Then I confirm adr document "example.tiff" is uploaded
    And I upload adr document "example.txt"
    Then I confirm adr document "example.txt" is uploaded
    And I upload adr document "example.xps"
    Then I confirm adr document "example.xps" is uploaded
    And I upload adr document "example.zip"
    Then I confirm adr document "example.zip" is uploaded
    When I click the save technical record button
    Then I should see "Enter reason for changing technical record"
    When I enter "cvsb-11030" as reason for tech record changes
    And I confirm saving the tech record changes
    Then I should not see "Save technical record"
    And I should not see "There is a problem"
    And I confirm adr document "sample.pdf" is added on the tank details
    And I confirm adr document "example.ADR" is added on the tank details
    And I confirm adr document "example.doc" is added on the tank details
    And I confirm adr document "example.docx" is added on the tank details
    And I confirm adr document "example.File" is added on the tank details
    And I confirm adr document "example.ADR" is added on the tank details
    And I confirm adr document "example.html" is added on the tank details
    And I confirm adr document "example.jpeg" is added on the tank details
    And I confirm adr document "example.oxps" is added on the tank details
    And I confirm adr document "example.png" is added on the tank details
    And I confirm adr document "example.tiff" is added on the tank details
    And I confirm adr document "example.txt" is added on the tank details
    And I confirm adr document "example.xps" is added on the tank details
    And I confirm adr document "example.zip" is added on the tank details
    When I download tank document "sample.pdf"
    And I should not see "There is a problem"
    When I download tank document "example.ADR"
    And I should not see "There is a problem"
    When I download tank document "example.doc"
    And I should not see "There is a problem"
    When I download tank document "example.docx"
    And I should not see "There is a problem"
    When I download tank document "example.File"
    And I should not see "There is a problem"
    When I download tank document "example.html"
    And I should not see "There is a problem"
    When I download tank document "example.jpeg"
    And I should not see "There is a problem"
    When I download tank document "example.oxps"
    And I should not see "There is a problem"
    When I download tank document "example.txt"
    And I should not see "There is a problem"
    When I download tank document "example.xps"
    And I should not see "There is a problem"
    When I download tank document "example.zip"
    And I should not see "There is a problem"
    When I download tank document "example.png"
    And I should not see "There is a problem"
    When I download tank document "example.tiff"
    And I should not see "There is a problem"
