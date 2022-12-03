#Author: Linh
@LoginApi
Feature: Check validation of two fields which have constraints each other

  @MainCase
  Scenario: Check validation of two fields which have constraints each other
    Given I have URL and method4 and RequestBodyName
      | URL                         | method4 | RequestBodyName                |
      | https://reqres.in/api/login | POST    | LoginApi/LoginRequestBody.json |
    When I send valid login request with "<FieldName1>" and "<Value1>" and "<FieldName2>" and "<Value2>"
    Then Check response return "<StatusCode>" and "Message"

