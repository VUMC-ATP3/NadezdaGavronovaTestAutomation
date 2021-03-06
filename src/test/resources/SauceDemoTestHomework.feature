Feature: SauceDemo Login, Add to cart, Checkout overview, Finish
  User is able to login with correct credentials, to add item to the cart, go to checkout, to add correct data and
  to finish order, at the end go to home page.

@browser
Scenario: User is able to login with correct credentials
  Given user is navigated to page 'https://www.saucedemo.com/'
  Then user sees title of page 'Swag Labs'
  When user enters login 'standard_user' and password 'secret_sauce'
  And user clicks button to login
  Then user is successfully logged in page

@browser
Scenario: User is able to add item to the cart and this item is in the cart
  Given user is navigated to page 'https://www.saucedemo.com/'
  When user enters login 'standard_user' and password 'secret_sauce'
  And user clicks button to login
  When user adds item to cart
  And user clicks cart button
  Then user sees name of page 'YOUR CART'
  And user sees item 'Sauce Labs Backpack'

  @browser
  Scenario: User is able to add data and see correct data on checkout page
    Given user is navigated to page 'https://www.saucedemo.com/'
    When user enters login 'standard_user' and password 'secret_sauce'
    And user clicks button to login
    When user adds item to cart
    And user clicks cart button
    When user clicks checkout button
    When user enter name 'Laima' and lastname 'Gulbja' and zip 'LV-1012'
    And user clicks continue button
    Then checkout data is correct

  @browser
  Scenario: User is able to create order
    Given user is navigated to page 'https://www.saucedemo.com/'
    When user enters login 'standard_user' and password 'secret_sauce'
    And user clicks button to login
    When user adds item to cart
    And user clicks cart button
    When user clicks checkout button
    When user enter name 'Iveta' and lastname 'Pirkstiņa' and zip 'LV-1012'
    And user clicks continue button
    And user clicks finish button
    Then order is created successfully

  @browser
  Scenario Outline: User sees correct error message about fields obligatory
    Given user is navigated to page 'https://www.saucedemo.com/'
    When user enters login 'standard_user' and password 'secret_sauce'
    And user clicks button to login
    When user adds item to cart
    And user clicks cart button
    When user clicks checkout button
    When user enter name '<name>' and lastname '<lastname>' and zip '<zip>'
    And user clicks continue button
    Then user sees error '<error text>'
    Examples:
      | name  | lastname | zip     | error text                     |
      |       |          |         | Error: First Name is required  |
      |       | Firsova  | LV-2345 | Error: First Name is required  |
      | Olga  |          | LV-1015 | Error: Last Name is required   |
      | Laura | Greke    |         | Error: Postal Code is required |








