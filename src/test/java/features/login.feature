Feature: Odyssey Application Demo

  Scenario Outline: Add a product to the cart
    Given user should navigate to the application
    And user should login by providing "<username>" and "<password>"
    And user should search the "<book>"
    When user clicks the Add to cart button
    Then user should check the cart item quantity

    Examples: 
      | username                | password | book                   |
      | velusasi.1202@gmail.com | ruby30@K | karna the king of anga |
