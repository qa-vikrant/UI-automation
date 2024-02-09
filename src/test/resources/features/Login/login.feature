Feature: User Login

  Scenario: Successfully move to Spicejet signup Page
    Given User is on Spicejet login page
    And User moves to signup page
    And User fills up all the valid details of Member Enrollment page
    Then user should see a submit button

