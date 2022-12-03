#Author: Linh
@ListUserApi
Feature: List User

  @MainCase
  Scenario: List User
    Given I have URL and method
      | URL                                | method |
      | https://reqres.in/api/users?page=2 | GET    |
    When I will send a request
    Then I need validate status code and data
