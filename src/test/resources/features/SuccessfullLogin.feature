Feature: successful login

  Scenario: check login is successful
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is navigated to admin page


