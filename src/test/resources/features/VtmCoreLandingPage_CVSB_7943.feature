Feature: VTM Core Landing Page - CVSN-7943
  As an admin user I can log in the VTM app
  And the VTM Core Landing Page is rendered correctly

  
  Scenario: Login and validate VTM landing page content
  AC1 - VTM Landing Page Renders Correctly
  AC2 - User Clicks On Hyperlink for searching tech records
  AC3 - User Clicks On Hyperlink for creating a new tech record
    #AC1
    Given I login with admin credentials
    Then I should see "Select activity"
    And I should see "Search for a technical record" hyperlink
    And the "Search for a technical record" hyperlink description is correct
    And I should see "Create a new technical record" hyperlink
    And the "Create a new technical record" hyperlink description is correct
    #AC2
    When I go to search tech record page
    And I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    When I go back to home page
    #AC3
    And I go to create tech record page
    And I should see "Create new technical record"
    And vin input field should be present