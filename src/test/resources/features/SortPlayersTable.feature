Feature: Correct Sort In Players Table By Username

  Scenario: check players Table Is Displayed
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is navigated to admin page
    And user click on table button
    Then players table is displayed
    Then user click sort button and check username order
