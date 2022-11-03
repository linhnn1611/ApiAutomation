#Author: Linh
@UpdateUserApi
Feature: Check update user

  @MainCase
  Scenario: Title of your scenario
    Given I have url and method and request body
      | URL                           | Method | RequestBody                              |
      | https://reqres.in/api/users/2 | PUT    | UpdateUserApi/UpdateUserRequestBody.json |
    When I send request2
    Then I validate status code and message
