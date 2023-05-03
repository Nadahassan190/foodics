Feature: Google search

  Scenario: Search for a keyword and see the number of results
    Given I am on the Google search page
    When I search for "apple"
    Then I see the number of results on the page

  Scenario: Go to the next page and see the same number of results
    Given I am on the Google search page
    When I search for "banana"
    Then I see the number of results on the page
    When I go to the next page
    Then I see the same number of results on the next page

  Scenario: See different search suggestions
    Given I am on the Google search page
    When I search for "cherry"
    Then I see different search suggestions