Feature: : Search
  As an end user
  I want do search
  So taht I can see desired products

  Scenario: Search for a Product
    Given user is on homepage
    When user search for "Laptops"
    Then user should see respective products

  Scenario Outline: Search for a Product
    Given user is on homepage
    When user search for "<item>"
    Then user should see respective products

    Examples:
      |  item |
      | cable |
      |televission|
      |Cookers     |