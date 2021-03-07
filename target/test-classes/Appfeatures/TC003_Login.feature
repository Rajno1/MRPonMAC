Feature: Login page feature

  Background: Login page validation
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login Page"

  @regression
  Scenario Outline: Validating login functionality
    When user enters username "<username>"
    And user enters password "<password>"
    When user clicks on login button
    And user gets the title of the page
    Then page title should be "- Maryland Residential Portal"
    Examples:
      | username  | password |
      | Applicant | Issi123# |

