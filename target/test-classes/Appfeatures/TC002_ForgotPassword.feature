Feature: Forgot Password feature

  Background: Login page validation
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login Page"

  Scenario Outline: validating password reset functionality
    Then forget password button should be display
    When user clicks on forgot password button
    And user gets the title of the page
    Then page title should be "ForgotPassword"
    When user enters Register email id "<email_id>"
    When user clicks on submit button
    Then it shows successfully message "Password has been changed successfully"
    Examples:
      | email_id                      |
      | rmaddigalla@issi-software.com |