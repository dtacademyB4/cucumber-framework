
#@all  -> tags can also be put on top of feature file to run everything in that feature file
Feature: Search functionality

  @smoke @regression
  Scenario: Search for a product using search bar
    Given The user is on the homepage
    When The user enters a term  Blouse to the search bar
    Then The search result should contain the term Blouse

    @test
  Scenario: Search for a product using invalid search term
    Given The user is on the homepage
    When The user enters a term sdhgfgsjjsdfg to the search bar
    Then The error message should be displayed.

      @temp
  Scenario: Search for a product using search bar
    Given The user is on the homepage
    When The user enters a term Faded Short Sleeve T-shirts to the search bar
    Then The search result should contain the term Faded Short Sleeve T-shirts