Feature: Search tech record
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to add specific adr details

  @skip
  Scenario: As the DVSA, we want VTM to be securely accessible so that it cannot be accessed by unauthorised users
  AC1 - User Is Not Authenticated Via AD, And Is Therefore Presented With The AD Authorisation Screen (VTM Login Screen)
  AC2 - User Enters AD Credentials, And Is Logged Into VTM
  AC3 - User Is Already Authenticated Via AD, And Is Therefore Presented With The VTM Landing Page
  AC8 - User closes browser without logging out, reopens browser, still logged into VTM
  AC6 - User logs out of VTM via the logout button
    #AC1 + AC2
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And I should see "Search for a technical record"
    And element with id "searchIdentifier" should be present
    #AC3
    When I navigate away from vtm app and then go back to vtm
    Then I should see "Search for a technical record"
    #AC8 - closing the browser is equivalent to clearing the session storage
    When I clear session storage
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "CT70000"
    #AC6
    When I logout from vtm app
    Then I should see "Pick an account"
