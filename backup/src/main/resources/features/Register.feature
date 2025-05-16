@regression
Feature: Register Functionality

  Scenario: User registers successfully
    Given User go to register page
    When User select the type of gender
    And User enter the first and last name
    And User enter the email
    And User enter and confirm the password
    And User click on register button
    Then success message is displayed
