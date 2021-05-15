Feature: Verify Home page details

  Scenario: Verify product names
    Given The user is on the homepage
    Then The following products should be displayed
      | Printed Summer Dress        |
      | Printed Summer Dress        |
      | Printed Chiffon Dress       |
      | Faded Short Sleeve T-shirts |
      | Blouse                      |
      | Printed Dress               |
      | Printed Dress               |
    And The page title should be "My Store"
#    Cucumber DataTable is used to pass multiple set of data into a SINGLE step


