#Author: Linh
@LoginApi
Feature: Check validation of single field

  @MainCase
  Scenario: Check validation of single field
    Given I have URL and method4 and data
      | URL                         | method4 | data                 |
      | https://reqres.in/api/login | POST    | LoginFieldValidation |
    When I send request and check status code and message in response4
    Then I validate status code and message4
