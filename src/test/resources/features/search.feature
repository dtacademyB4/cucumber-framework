Feature: Search functionality


  Scenario: Search for a product using search bar
    Given The user is on the homepage
    When The user enters a term Blouse to the search bar
    Then The search result should contain the term Blouse