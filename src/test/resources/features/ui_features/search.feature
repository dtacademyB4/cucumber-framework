
#@search
# -> tags can also be put on top of feature file to run everything in that feature file
Feature: Search functionality

Background:
    Given The user is on the homepage




  Scenario: Search for a product using search bar
    When The user enters a term "Blouse" to the search bar
    Then The search result should contain the term Blouse


  Scenario: Search for a product using search bar
    When The user enters a term "Chiffon Dress" to the search bar
    Then The search result should contain the term Blouse


  Scenario: Search for a product using invalid search term
    When The user enters a term "sdhgfgsjjsdfg" to the search bar
    Then The error message should be displayed.

   @smoke
  Scenario: Search for a product using search bar
    When The user enters a term "Faded Short Sleeve T-shirts" to the search bar
    Then The search result should contain the term Faded Short Sleeve T-shirts
        Then Whatever