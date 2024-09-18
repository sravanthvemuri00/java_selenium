Feature: Login to salesforce page
  @sc01
  Scenario: Error message validation with invalid data
    Given user navigate to salesforce application
    When user enter username "abc" and password "xyz"
    And user clicks the login button
    Then user validates error message

  @sc02
  Scenario: validation with valid data
  #  Given user navigate to salesforce application
    Then user enter username "standard_user" and password "secret_sauce"
    And user clicks the login button
    Then validate page title


  @sc03
  Scenario Outline: multiple validation
    When user enter username "<username>" and password "<password>"
    And user clicks the login button
    Then validate page title
    Examples:
    |username|password|
    |standard_user|secret_sauce|


  @sc04
  Scenario Outline: multiple validation
#    Given user navigate to salesforce application
    When user enter username "<username>" and password "<password>"
    And user clicks the login button
    And sort with dynamic
    Examples:
      |username|password|
      |standard_user|secret_sauce|

  @sc05
  Scenario: excel validation
    When user enter username and password by excel
    And user clicks the login button
    Then validate page title
