Feature: Login feature

  Scenario: User should be able to login with valid credentials
    Given User should be on the login page
    When User enter valid username
    And User enter valid password
    And User click on the login button
    Then User should successfully logged in
    But User should not see the login button
