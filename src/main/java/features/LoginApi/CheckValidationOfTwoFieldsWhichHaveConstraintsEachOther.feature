#Author: Linh
@LoginApi
Feature: Check validation of two fields which have constraints each other

  @MainCase
  Scenario: Check validation of two fields which have constraints each other
    Given I have URL and method
  	When I send request and check status code and message in response
  	Then I validate status code and message