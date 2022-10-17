#Author: Linh
@LoginApi
Feature: Check invalid URL

  @MainCase
  Scenario: Check invalid URL
  Given I have URL and method3
  When I send request and check status code and message in response3
  Then I validate status code and message3 
