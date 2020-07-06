Feature: See the completeness flag so that I can assess how complete the vehicle's technical record is - CVSB-11796

  @In_Test
  Scenario Outline: See the completeness flag so that I can assess how complete the vehicle's technical record is - TRL
  AC1 - View a technical record - all vehicle types
  AC2 - Edit a technical record - all vehicle types
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "<vehicle>" vehicle with Record completeness "<record_completeness_flag>"
    And I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    And I search for previously created vehicle
    And wait until I see "Technical record"
    And tech record fields should have values
      | Field               | Value                       |
      | record-completeness | <record_completeness_value> |
    #AC2
    And I click the change technical record button
    Then I should see "Save technical record"
    And tech record fields should have values
      | Field               | Value                       |
      | record-completeness | <record_completeness_value> |
    And test record fields should not be editable
      | Field                 |
      | record-completeness   |

      Examples:
        | vehicle         | record_completeness_flag | record_completeness_value                                   |
        | trl             | skeleton                 | Skeleton  |
        | trl             | testable                 | Testable  |
        | trl             | complete                 | Complete                                                    |
        | psv             | skeleton                 | Skeleton |
        | psv             | testable                 | Testable |
        | psv             | complete                 | Complete                                                    |
        | hgv             | skeleton                 | Skeleton |
        | hgv             | testable                 | Testable |
        | hgv             | complete                 | Complete                                                    |
        | car             | skeleton                 | Skeleton |
        | car             | complete                 | Complete                                                    |
        | lgv             | skeleton                 | Skeleton |
        | lgv             | complete                 | Complete                                                    |
        | motorcycle      | skeleton                 | Skeleton |
        | motorcycle      | complete                 | Complete                                                    |
