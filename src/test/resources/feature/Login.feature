@login
Feature: Login
  In order to maintain the medical records
  As a user
  I would like acces the OpenEMR portal

  Background: 
    Given I have browser with OpenEMR page

  @valid
  Scenario: Valid Credential
    When I enter username as "admin"
    And I Enter password as "pass"
    And I select language as "English (Indian)"
    And I click on login button
    Then I should get acess to portal with title as "OpenEMR"

  @invalid
  Scenario Outline: Invalid Credential
    When I enter username as "<username>"
    And I Enter password as "<password>"
    And I select language as "<language>"
    And I click on login button
    Then I should get error "Invalid username or password"

    Examples: 
      | username | password | language         |
      | admin    | qwer     | English (Indian) |
      | sample   | qwer     | English (Indian) |