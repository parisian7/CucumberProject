Feature: scenario outline Test

  Background: Etsy navigation
    Given the user goes to the Etsy

  #Scenario Outline : and Scenario Template:  are same
  #Examples and Scenarios are same
  @etsyOutline
  Scenario Outline: Etsy Search validation with outline
    When the user search in Etsy with "<searchValue>"
    Then the user validate title "<title>" and url "<etsyUrl>"
    Examples:
      | searchValue | title                 | etsyUrl |
      | winter hat  | Winter hat \| Etsy | winter    |
      | hat         | Hat \| Etsy       |hat        |
      | winter soldier | Winter soldier \| Etsy | soldier |

