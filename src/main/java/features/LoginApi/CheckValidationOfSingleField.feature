#Author: Linh
@ValidationCase
Feature: Check validation of single field

  @MainCase
  Scenario Outline: Check validation of single field
    Given I have login URL and method4 and RequestBodyName
      | URL                         | method4 | RequestBodyName                |
      | https://reqres.in/api/login | POST    | LoginApi/LoginRequestBody.json |
    When I send login valid login request with "<FieldName>" and "<Value>"
    Then Response return "<StatusCode>" and "<Message>"

    Examples: 
      | FieldName | Value              | StatusCode | Message                   |
      | email     | eve.holt@reqres.in |        200 |                           |
      | email     | missing            |        400 | Missing email or username |
      | email     | null               |        400 | Missing email or username |
      | email     | \\"\\"             |        400 | Missing email or username |
      | email     | true               |        400 | user not found            |
      | password  | eve.holt@reqres.in |        200 |                           |
      | password  | missing            |        400 | Missing password          |
      | password  | null               |        400 | Missing password          |
      | password  | \\"\\"             |        400 | Missing password          |
      | password  | true               |        200 |                           |
