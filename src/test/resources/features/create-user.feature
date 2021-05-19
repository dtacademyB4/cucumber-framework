Feature: Verify User Creation
  @temp
  Scenario: Verify user registration
    Given The user is on the homepage
    When The user navigates to Login page
    And The user enters a valid email address and click on create account button
    And The user passes the valid info and clicks on register
    Then The user should land on My Account page
    And The name should be correct
