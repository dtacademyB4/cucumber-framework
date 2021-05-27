Feature: Verify database side features


  Scenario: Verify the genres in the database


    When I send a query
    Then The following genres should be returned
      | rap        |
      | pop        |
      | techno     |
      | rnb        |
      | house      |
      | classical  |
      | jazz       |
      | electronic |
      | dance      |
      | reggae     |
      | reggaeton  |




  Scenario: Verify the column names from the users table
       When I send a request to retrieve the column names for users table
       Then The result should be the following
         | id         |
         | username   |
         | firstName  |
         | lastName   |
         | email      |
         | password   |
         | signUpDate |
         | profilePic |

  @db
  Scenario: Verify updating user details
    When I send and update statement to modify email for user with id 4 to "hello@gmail.com"
    Then I should see the updated email "hello@gmail.com" for the user with id 4


