Feature: Filter
  As a customer
  I want to apply filters
  so ican find desired product range

  Scenario: Filter
  Given user is on homepage
  When user enter product for search "Laptops"
  Then user should see respective laptops
  And select any product


