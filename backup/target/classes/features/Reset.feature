@regression
Feature: user should be able to login to the system

    #valid reset
  Scenario: user could reset password successfully
    Given user navigates to login page
    When user click on forgetPassword
    Then user navigate to forgetPage and enter his email "leqaahani@example.com"
    And user click on Recovery Button
    And password will be reset