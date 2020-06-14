Feature: Validate search in Etsy

  Background: It will run before each scenarios
    Given the user goes to the Etsy

  @etsy @tt
  Scenario: Validation of search in etsy1
    When  the user search in Etsy with "winter hat"
    Then the user validate title "Winter hat | Etsy" and url "winter"

  @etsy
  Scenario: Validation of search in etsy2
    When  the user search in Etsy with "hat"
    Then the user validate title "Hat | Etsy" and url "hat"

  @etsy @tt
  Scenario: Validation of search in etsy3
    When  the user search in Etsy with "winter soldier"
    Then the user validate title "Winter soldier | Etsy" and url "soldier"