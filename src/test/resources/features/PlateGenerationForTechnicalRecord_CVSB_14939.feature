Feature: Generate plates for technical records, so that we can supply plates with accurate information to the applicant - CVSB-14939

  Background:
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present

  Scenario Outline: The appearance of the 'call to action' - Status 'Provisional'
  AC1: The call to action to 'Send ministry plates', is not present if the technical record has a status of 'provisional' or 'archived'
    When I create "<vehicle>" vehicle
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    And I search for previously created vehicle
    And wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Provisional                 |
    Then I should not see "Send ministry plates"
      Examples:
      | vehicle |
      | hgv     |
      | trl     |

  Scenario Outline: The appearance of the 'call to action' - Status 'Archived'
  AC1: The call to action to 'Send ministry plates', is not present if the technical record has a status of 'provisional' or 'archived'
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I search for vehicle with identifier "<vehicle_identifier>"
    When I open all tech record sections
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Archived                    |
      | vehicleType         | <vehicle_type>              |
    Then I should not see "Send ministry plates"
      Examples:
        | vehicle_identifier | vehicle_type |
        | P012301230001      | HGV          |
        | T13541234          | TRL          |

  Scenario Outline: The appearance of the 'call to action', the confirmation modal, the partial population of a new object within the Plates[] array, using attributes sent from the FE
  AC2: The call to action to 'Send ministry plates', is present if the technical record has a status of 'current'
  AC3 - The user clicks the call to action to 'Send ministry plates'
  AC4 - The user clicks the call to action to 'Cancel'
  AC5 - The plate attributes are set, when the user clicks the call to action to 'Send ministry plate'
    #AC2
    When I create "<vehicle>" vehicle with adr details
    And I update previously created tech record
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    And I search for previously created vehicle
    And wait until I see "Technical record"
    And I should see the "vin" attribute of newly created vehicle
    And I open tech record "test history" section
    And the "test history" tech record section should have 1 entry
    And I should see the "vin" attribute of newly created vehicle
    And tech record fields should have values
      | Field               | Value                       |
      | status              | Current                     |
    Then I should see "Send ministry plates" button
    #AC3
    When I click "Send ministry plates" button
    Then wait until I see "Select reason for sending ministry plate"
    And I check values for fields
      | Field   | Value                      |
      | issue-0 | Issue original certificate |
    And I set values for fields
      | Field   | Value                      |
      | issue-1 | Issue replacement          |
    And I check values for fields
      | Field   | Value                      |
      | issue-1 | Issue replacement          |
    And I set values for fields
      | Field   | Value                      |
      | issue-0 | Issue original certificate |
    And I check values for fields
      | Field   | Value                      |
      | issue-0 | Issue original certificate |
    And the email address on the modal is filled with the email address within applicant details
    And I should see "Send ministry plates" button
    And I should see "Cancel" hyperlink
    #AC4
    When I click "Cancel" link
    Then I should see "Change technical record"
    And I should not see "Cancel"
    #AC5
    When I click "Send ministry plates" button
    And wait until I see "Select reason for sending ministry plate"
    And I check values for fields
      | Field   | Value                      |
      | issue-0 | Issue original certificate |
    And I click Send ministry plate button from send ministry plates modal
    Then I should see "Change technical record"
    And I should not see "Cancel"
    And I open tech record "plates" section
    And the "plates" tech record section should have 3 entries
    And tech record fields should have values
      | Field                            | Value          |
      | plateSerialNumber-0              | DIGIT          |
      | plateReasonForIssue-0            | Original       |
      | plateIssuer-0                    | VTM_USERNAME   |
      | plateIssueDate-0                 | TODAYS_DATE    |
    And I close tech record "plates" section
    When I click "Send ministry plates" button
    And wait until I see "Select reason for sending ministry plate"
    And I set values for fields
      | Field   | Value                      |
      | issue-1 | Issue replacement          |
    And I check values for fields
      | Field   | Value                      |
      | issue-1 | Issue replacement          |
    And I click Send ministry plate button from send ministry plates modal
    Then I should see "Change technical record"
    And I should not see "Cancel"
    And I open tech record "plates" section
    And the "plates" tech record section should have 4 entries
    And tech record fields should have values
      | Field                            | Value          |
      | plateSerialNumber-1              | DIGIT          |
      | plateReasonForIssue-1            | Replacement    |
      | plateIssuer-1                    | VTM_USERNAME   |
      | plateIssueDate-1                 | TODAYS_DATE    |
      Examples:
        | vehicle |
        | hgv     |
        | trl     |
