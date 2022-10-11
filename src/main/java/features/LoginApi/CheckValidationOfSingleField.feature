#Author: Linh
@LoginApi
Feature: Check validation of single field

  @Main
  Scenario: Check validation of single field
  	Given I have URL and method
  	When I send request and check status code and message in response
  	Then I validate status code and message