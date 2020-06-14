Feature: Cucumber first test
@negative @smoke
  Scenario: First steps
    Given the user school name
    When the user print the name
    Then the user print the last name
    And the user print the city
    * the user print the state
    # for cucumber we need to use Gherkin language
    # Feature file starts with Feature: keyword
    # for every test cases we create the Scenario
    # We need to write the java code inside StepDefinitions