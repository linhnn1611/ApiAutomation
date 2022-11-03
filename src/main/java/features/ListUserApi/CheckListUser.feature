#Author: Linh
@ListUserApi
Feature: List User

  @MainCase
  Scenario: List User
    Given I have URL and method
      | URL                                | method |
      | https://reqres.in/api/users?page=2 | GET    |
    When I send request
    Then I validate status code and data
