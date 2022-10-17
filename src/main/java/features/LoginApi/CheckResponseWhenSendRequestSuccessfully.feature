#Author: Linh
@LoginApi
Feature: Check response when send request successfully

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have login URL and method and Request body file name
      | URL                         | method | RequestBodyName       |
      | https://reqres.in/api/login | POST   | LoginRequestBody.json |
    When I send request
    Then I validate status code and token
