Feature: See the completeness flag so that I can assess how complete the vehicle's technical record is - CVSB-11796

  @In_Test
  Scenario Outline: Scenario1
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I create "<vehicle>" vehicle with Record completeness "<record_completeness_flag>"

      Examples:
    | vehicle         | record_completeness_flag|
#    | trl             | skeleton                |
#    | trl             | testable                |
#    | trl             | complete                |
    | psv             | skeleton                |
#    | psv             | testable                |
#    | psv             | complete                |
#    | hgv             | skeleton                |
#    | hgv             | testable                |
#    | hgv             | complete                |
#    | car             | skeleton                |
#    | car             | testable                |
#    | car             | complete                |
#    | lgv             | skeleton                |
#    | lgv             | testable                |
#    | lgv             | complete                |
#    | motorcycle      | skeleton                |
#    | motorcycle      | testable                |
#    | motorcycle      | complete                |
