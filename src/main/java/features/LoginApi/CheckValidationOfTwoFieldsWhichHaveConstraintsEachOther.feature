#Author: Linh
@LoginApi
Feature: Check validation of two fields which have constraints each other

  @MainCase
  Scenario: Check validation of two fields which have constraints each other
    Given I have URL and method5 and data
      | URL                         | method5 | data                 |
      | https://reqres.in/api/login | POST    | LoginFieldValidation |
    When I send request and check status code and message in response5
    Then I validate status code and message5
