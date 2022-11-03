#Author: Linh
@CreateUserApi
Feature: Create user successfully

  @MainCase
  Scenario: Create user successfully
    Given I have login URL and method and Request body file name
      | URL                         | method | RequestBodyName       |
      | https://reqres.in/api/users | POST   | /CreateUserApi/CreateUserRequestBody.json |
    When I send request
    Then I validate status code and name and job
    