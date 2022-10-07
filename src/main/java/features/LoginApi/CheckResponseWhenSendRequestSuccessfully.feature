#Author: Linh
@LoginApi
Feature: Check response when send request successfully

  @MainCase
  Scenario: Check response when send request successfully
    Given I have URL and method and Request body file name
    When I send request
    Then I validate status code and token
