Feature: Search tech record
  As an admin user I can log in the VTM app
  After I search for a tech record
  I should be able to add specific adr details


  Scenario: As the DVSA, we want VTM to be securely accessible so that it cannot be accessed by unauthorised users
  AC1 - User Is Not Authenticated Via AD, And Is Therefore Presented With The AD Authorisation Screen (VTM Login Screen)
  AC2 - User Enters AD Credentials, And Is Logged Into VTM
  AC3 - User Is Already Authenticated Via AD, And Is Therefore Presented With The VTM Landing Page
  AC6 - User logs out of VTM via the logout button
    #AC1 + AC2
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And I should see "Search for a technical record"
    And element with id "searchIdentifier" should be present
    #AC3
    When I navigate away from vtm app and then go back to vtm
    Then I should see "Search for a technical record"
    #AC6
    When I logout from vtm app
    Then I should see "Pick an account"


  Scenario: As the DVSA, we want VTM to be securely accessible so that it cannot be accessed by unauthorised users
  AC7 - User is logged out of VTM after clearing browser cache
  AC8 - User closes browser without logging out, reopens browser, still logged into VTM
    Given I login with admin credentials
    Then I should see "Vehicle Testing Management"
    And I should see "Search for a technical record"
    And element with id "searchIdentifier" should be present
    #user closes browser without logging out, reopens browser, still logged into VTM (is equivalent to hard refresh since we do not use session storage, just local storage)
    When I clear session storage
    When I search for vehicle with identifier "P012301230000"
    Then wait until I see "CT70000"
    #user is logged out of VTM after clearing browser cache
    When I clear the browser session
    Then I should see "You've signed out of your account"








