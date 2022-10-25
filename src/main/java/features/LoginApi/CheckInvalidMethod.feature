#Author: Linh
@LoginApi
Feature: Check invalid method

  @MainCase
  Scenario: Check invalid method
    Given I have URL and method2
      | URL                         | method2 |
      | https://reqres.in/api/login | GET     |
    When I send request and check status code and message in response2
    Then I validate status code and message2
