#Author: Linh
Feature: Check delete user

  @MainCase
  Scenario: Check delete user
    Given I have url and method
      | URL                           | method |
      | https://reqres.in/api/users/2 | DELETE |
    When I will send request
    Then I check status code and response body
