#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Verify you can book a room from the non admin website
  I want to use this template for my feature file

 # Scenario Outline: Verify you can log in
#    Given I am on the login
  #  When user enters <username> and <password>
  #  Then I should be on the booking page

 #   Examples: 
 #     | username | password |
 #     | admin    | password |

  Scenario Outline: Verify you can book a room
    Given I am on the booking page
    When I select the setting
    And I select the room type
    And I set Accessible to true
    And I enter <roomnumber> and <price>
    And I hit create
    Then  booking is listed

    Examples: 
      | roomnumber | price |
      |        108 |   326 |
     
