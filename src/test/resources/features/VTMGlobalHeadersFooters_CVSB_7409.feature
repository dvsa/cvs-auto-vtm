Feature: VTM headers and footers
  As an admin user I can log in the VTM app
  And the VTM headers and footers are rendered correctly

  Background:
    Given I login with admin credentials
    Then I should see "Vehicle testing management"


  Scenario: Login and validate VTM headers and footers
  AC1 - Header matches the design
  AC2 - Footer matches the design
  AC3 - User clicks privacy notice in footer
  AC4 - User attempts to sign out of VTM
  AC5 - User cancels on the confirmation page
  AC6 - User proceeds with signing out
  AC7 - User clicks crown copyright in the footer
  AC8 - User clicks open government license in the footer
  AC9 - User clicks 'Vehicle testing management' in the header
    # AC1
    Then the header title should be "Vehicle testing management"
    And the header should contain user name "VTM Admin1"
    And the header should contain "Sign out"
    # AC2
    Then the footer should contain "Privacy notice"
    And the footer should contain "Crown copyright"
    And the footer should contain "All content is available under the Open Government Licence v3.0, except where otherwise stated"
    And the footer should contain copyright logo
    And the footer should contain ogl logo


  Scenario: Check footer links
  AC3 - User clicks privacy notice in footer
  AC7 - User clicks crown copyright in the footer
  AC8 - User clicks open government license in the footer
  AC9 - User clicks 'Vehicle testing management' in the header
    # AC3
    When I click "Privacy notice" link
    Then I am taken to "https://dvsaintranet.dft.gov.uk/task/protective-monitoring-of-dvsa-it/"
    # AC7
    When I go back to previous page
    Then wait until I see "Crown copyright"
    And I click "Crown copyright" link
    Then I am taken to "https://www.nationalarchives.gov.uk/information-management/re-using-public-sector-information/uk-government-licensing-framework/crown-copyright/"
    # AC8
    When I go back to previous page
    Then wait until I see "Open Government Licence v3.0"
    And I click "Open Government Licence v3.0" link
    Then I am taken to "https://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/"
    # AC9
    When I go back to previous page
    And wait until I see "Search for a technical record"
    When I go to search tech record page
    And wait until I see "Vehicle testing management"
    And wait until I see "Vehicle registration mark, trailer ID or vehicle identification number"
    And wait until I see "All content is available under the Open Government Licence v3.0, except where otherwise stated"
    And I click "Vehicle testing management" link
    Then I should see "Select activity"
    And I should see "Search for a technical record" hyperlink
    And I should see "Create a new technical record" hyperlink


  Scenario: Sign out of VTM
  AC4 - User attempts to sign out of VTM
  AC5 - User cancels on the confirmation page
  AC6 - User proceeds with signing out
    # AC4
    When I sign out from vtm app
    Then I should see "Are you sure you want to sign out?"
    # AC5
    When I click "Cancel" link
    Then I should no longer see the sign out confirmation screen
    #AC6
    When I sign out from vtm app
    Then I should see "Are you sure you want to sign out?"
    When I click "Yes, sign out" button
    Then I should see "Pick an account"
