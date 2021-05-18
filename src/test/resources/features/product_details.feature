
Feature: Validate product details


  Scenario:  Validate the price of a product
    Given The user is on the homepage
    When The user clicks on a product "Faded Short Sleeve T-shirts"
    Then The user should be taken to product details page with title "Faded Short Sleeve T-shirts"
    And The price of the product should be 16.51
    And The default quantity should be 1


  Scenario:  Validate the price of a product
    Given The user is on the homepage
    When The user clicks on a product "Blouse"
    Then The user should be taken to product details page with title "Blouse"
    And The price of the product should be 27.00
    And The default quantity should be 1


  Scenario:  Validate the price of a product
    Given The user is on the homepage
    When The user clicks on a product "Printed Chiffon Dress"
    Then The user should be taken to product details page with title "Printed Chiffon Dress"
    And The price of the product should be 16.40
    And The default quantity should be 2


  @temp
    Scenario: Verify Product details
      Given The user is on the homepage
      When The user clicks on a product "Faded Short Sleeve T-shirts"
      Then The product details should be the following
        | Name                        | Condition| Composition  | Style | Price | Size |
        | Faded Short Sleeve T-shirts | New      |  Cotton      | Casual| 16.51 | S    |
