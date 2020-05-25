Feature: Login Feature
  This feature deals with the login functionality of Phalanx Application

  Scenario: Login with correct username and password
    Given I navigate to login page
    When I enter email and password
    And I click on login button
    Then I should see the Home page

  Scenario: Check Login with incorrect parameters
    Given I navigate to login page
    When I enter email as "aj-agent@yopmail.com" and password as "Pass@12345"
    And I click on login button
    Then I should see the Login page with error message

  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
