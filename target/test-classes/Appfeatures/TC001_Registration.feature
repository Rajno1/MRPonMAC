Feature: Registration feature

  Scenario Outline: Validating user registration
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login Page"
    Then Register button should be display
    When user clicks on Register button
    And user gets the title of the page
    Then page title should be "Register New User"
    When user fills the form from given sheet name "<SheetName>" and row number <RowNumber>
    And user clicks on Register button to submit the form
    Then it shows successfully message "User registration successful"

    Examples:
      | SheetName        | RowNumber |
      | RegistrationData | 0         |
