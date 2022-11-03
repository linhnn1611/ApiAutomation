#Author: Linh
@LoginApi
Feature: Check invalid URL

  @MainCase
  Scenario: Check invalid URL
    Given I have URL and method and Request Body
      | URL                             | method | RequestBodyName |
      | https://reqres.in/api111/login1 | POST   |                 |
    When I send request and check status code and message in response3
    Then I validate status code and message3
