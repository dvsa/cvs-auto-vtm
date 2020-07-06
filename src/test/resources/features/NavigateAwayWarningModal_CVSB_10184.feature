Feature: VTM headers and footers - CVSB-7409
  As an admin user I can log in the VTM app
  And the VTM headers and footers are rendered correctly


  Scenario: Navigate way from page whilst in edit mode triggers warning modal - check behavior whilst in edit mode
  AC1 - User clicks the 'on screen' back button (not the browser back button) (whilst editing a record)
  AC2 - User clicks 'Vehicle testing management' in the header (whilst editing a record)
  AC3 - User clicks the call to action to 'Leave and lose changes'
  AC4 - User clicks the call to action to 'Continue changing record'
    Given I login with admin credentials
    Then I should see "Select activity"
    And search vehicle link should be present
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    And search vehicle input field should be present
    # click 'Back' link whilst in edit mode on tech record page
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I click "Change technical record" button
    And I click "Back" link
    Then I should see "Unsaved changes"
    And I should see "If you leave this page, your changes will be lost."
    When I click "Leave and lose changes" button
    Then I should see "Search for a technical record"
    # click header link whilst in edit mode on tech record page
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I click "Change technical record" button
    And I go back to home page
    Then I should see "Unsaved changes"
    And I should see "If you leave this page, your changes will be lost."
    When I click "Leave and lose changes" button
    Then I should see "Select activity"
    # click 'Back' link whilst in edit mode on test record page
    When I go to search tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I open tech record "Test history" section
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    When I click "Change test record" button
    And I click "Back" link
    Then I should see "Unsaved changes"
    And I should see "If you leave this page, your changes will be lost."
    When I click "Leave and lose changes" button
    Then I should see "Technical record"
    # click header link whilst in edit mode on test record page
    When I open tech record "Test history" section
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    When I click "Change test record" button
    And I go back to home page
    Then I should see "Unsaved changes"
    And I should see "If you leave this page, your changes will be lost."
    When I click "Leave and lose changes" button
    Then I should see "Select activity"
    # click 'Back' link whilst on the create tech record page
    When I go to create tech record page
    Then I should see "Vehicle registration mark, trailer ID or vehicle identification number"
    When I search for vehicle with identifier "ABCDEFGH777777"
    Then wait until I see "Technical record"
    When I open tech record "Test history" section
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    When I click "Change test record" button
    And I click "Back" link
    Then I should see "Unsaved changes"
    And I should see "If you leave this page, your changes will be lost."
    When I click "Leave and lose changes" button
    Then I should see "Technical record"
    # click header link whilst on the create tech record page
    When I open tech record "Test history" section
    And I go to view test record with index 1
    Then wait until I see "Change test record"
    When I click "Change test record" button
    And I go back to home page
    Then I should see "Unsaved changes"
    And I should see "If you leave this page, your changes will be lost."
    When I click "Leave and lose changes" button
    Then I should see "Select activity"
    