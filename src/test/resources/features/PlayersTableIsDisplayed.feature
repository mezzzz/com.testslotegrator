Feature: Players Table Is Displayed

  Scenario: check players Table Is Displayed
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is navigated to admin page
    And user click on table button
    Then players table is displayed


