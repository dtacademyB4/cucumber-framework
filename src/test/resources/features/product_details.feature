
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



    Scenario: Verify Product details
      Given The user is on the homepage
      When The user clicks on a product "Faded Short Sleeve T-shirts"
      Then The product details should be the following
        | Name                        | Condition| Composition  | Style | Price | Size |
        | Faded Short Sleeve T-shirts | New      |  Cotton      | Casual| 16.51 | S    |



  Scenario: Verify Product details using Datatable
    Given The user is on the homepage
    When The user clicks on a product "Blouse"
    Then The product details should be the following using
      | Name   | Condition | Composition | Style       | Price   | Size |
      | Blouse | New       | Cotton      | Casual      | 27.00   | S    |


  Scenario Outline: Verify Product details using Scenario Outline
    Given The user is on the homepage
    When The user clicks on a product "<productName>"
    Then The product details should be the following using
      | Name          | Condition | Composition | Style   | Price   | Size   |
      | <productName> | <cond>    | <material>  | <style> | <price> | <size> |

    Examples:

      | productName                 | cond | material  | style  | price | size |
      | Faded Short Sleeve T-shirts | New  | Cotton    | Casual | 16.51 | S    |
      | Blouse                      | New  | Cotton    | Casual | 27.00 | S    |
      | Printed Dress               | New  | Cotton    | Girly  | 26.00 | S    |
      | Printed Summer Dress        | New  | Viscose   | Casual | 28.98 | S    |
      | Printed Chiffon Dress       | New  | Polyester | Girly  | 16.40 | S    |

  @temp
    Scenario: Verify Product details using external Excel file

      Given The user is on the homepage
      Then The product details should match the info in an excel file "testData.xlsx" and sheet "Sheet1"
