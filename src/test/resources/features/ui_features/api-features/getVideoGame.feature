Feature: Verify GET VideoGame endpoint


  Scenario: Verify Get videogame happy path
    Given The base uri is initialized
    And The header is "Accept" and "application/json" and Video game id is 1
    When The user sends GET request to the endpoint
    Then The response status code should be 200 and response body should be correct for video game with id 1


  @api
  Scenario Outline: Verify PUT request using data driven testing
    Given The base uri is initialized
    And The user passes the following info for POJO
      | id   | name   | release   | score   | category   | rating   |
      | <id> | <name> | <release> | <score> | <category> | <rating> |
    When The user sends PUT request to the endpoint
    Then The status code should be 200 and the same info must be returned as a POJO

    Examples:

      | id | name          | release    | score | category  | rating |
      | 1  | Mario         | 2005-10-01 | 86    | Adventure | 78     |
      | 2  | Zelda         | 1998-10-01 | 45    | Arcade    | 34     |
      | 3  | Double Dragon | 1988-10-01 | 23    | FPS       | 12     |
      | 4  | Battletoads   | 1990-10-01 | 32    | Strategy  | 12     |




