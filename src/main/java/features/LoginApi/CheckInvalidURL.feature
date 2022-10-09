#Author: Linh
@LoginApi
Feature: Check invalid URL

  @MainCase
  Scenario: Check invalid URL
  Given I have URL and method
  When I send request and check status code and message in response
  Then I validate status code and message 
