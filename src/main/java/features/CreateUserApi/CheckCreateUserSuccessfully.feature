#Author: Linh
@CreateUserApi
Feature: Create user successfully

  @MainCase
  Scenario: Create user successfully
    Given I have login with URL and method and RequestBodyName
      | URL                         | method | RequestBodyName       |
      | https://reqres.in/api/users | POST   | CreateUserApi/CreateUserRequestBody.json |
    When I send with request
    Then I need validate status code and name and job
    