Feature: Login

  Scenario: Customer can login
    Given I am on the loginPage
    When I input email ""
    And I go to password screen
    And I input password ""
    And I sign in
    And I wait until page is loaded
    Then I should see "CVS VTM Application"

  Scenario: Customer can login
    Given I am on the loginPage
    When I input email ""
    And I go to password screen
    Then I should see "This username may be incorrect."
