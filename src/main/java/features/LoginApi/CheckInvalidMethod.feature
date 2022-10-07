#Author: Linh
@LoginApi
Feature: Check invalid method

  @MainCase
  Scenario: Check invalid method
  Given I have URL and method
  When I send request and check status code and message in response
  Then I validate status code and message  
