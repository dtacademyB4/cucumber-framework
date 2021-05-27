Feature: Verify database and ui interaction



  Scenario: Verify user registration
    Given  The user is on the homepage and database connection is established
    When The user registers using the following info
         | first name | last name |  password  |
         |  Duotech   | Batch4    |  duotechb4|
    Then The same information about the user should be created in the users table in the db

  @db_ui
  Scenario: Verify user email update through UI
    Given The user is on the homepage and database connection is established
    When The user with username "duotechb4" and password "duotechb4" updates the email on the UI
    Then The email database info for the same user should also be updated








