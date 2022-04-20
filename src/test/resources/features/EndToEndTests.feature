Feature: Automated EndToEnd Tests

  Scenario Outline: Google search
    Given I navigate to google
    When I enter "<searchTerm>" in search
    And I click on search button
    Then I should see the search results for cucumber
    And Verify the Search Term

  Examples:
    |searchTerm|
    |example1|
    |example2|
    |example3|
    |example4|