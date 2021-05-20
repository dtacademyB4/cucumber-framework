Feature: Verify User Creation

  Scenario: Verify user registration
    Given The user is on the homepage
    When The user navigates to Login page
    And The user enters a valid email address and click on create account button
    And The user passes the valid info and clicks on register
    Then The user should land on My Account page
    And The name should be correct




  Scenario: Verify user registration using datatable
    Given The user is on the homepage
    When The user navigates to Login page
    And The user enters a valid email address and click on create account button
    And The user passes the following info and clicks on register
| first_name | last_name | password | Street Address      | City  | State   | Zip Code | Phone        |
| Lemmy      | Innocenti | QVLpeC   | 70 Graceland Circle | Tampa | Florida | 33661    | 515-225-0199 |
    Then The user should land on My Account page
    And The name should be correct

@temp
  Scenario Outline: Verify user registration using scenario outline
    Given The user is on the homepage
    When The user navigates to Login page
    And The user enters a valid email address and click on create account button
    And The user passes the following info and clicks on register
| first_name   | last_name   | password   | Street Address   | City   | State   | Zip Code   | Phone   |
| <first_name> | <last_name> | <password> | <Street Address> | <City> | <State> | <Zip Code> | <Phone> |
    Then The user should land on My Account page
    And The name should be correct

    Examples:
| first_name | last_name  | password    | Street Address      | City           | State        | Zip Code | Phone        |
| Lemmy      | Innocenti  | QVLpeC      | 70 Graceland Circle | Tampa          | Florida      | 33661    | 515-225-0199 |
| Goldi      | Hearfield  | 5ELQjynv3lw | 8634 Eastwood Place | New Orleans    | Louisiana    | 70124    | 504-864-7349 |
| Daisie     | Spridgeon  | 0ljG5SoBm   | 24674 Forest Park   | Salt Lake City | Utah         | 84199    | 801-340-6765 |
| Kliment    | Huxtable   | Z7NvpJ7oB1  | 2546 Oriole Center  | Pittsburgh     | Pennsylvania | 15215    | 412-529-9524 |
| Kerianne   | Doddemeede | rV7NBj      | 3557 Iowa Center    | Mobile         | Alabama      | 36616    | 251-839-5757 |
| Robena     | Dodshon    | qUqCn6      | 63 Nova Drive       | Elmira         | New York     | 14905    | 607-341-1537 |


    






