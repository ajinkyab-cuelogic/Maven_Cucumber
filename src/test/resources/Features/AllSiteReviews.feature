@reviews
Feature: To test Guest Reviews when logged in as Superadmin 
	I should accept, decline and delete hotel reviews
	
Background: Flow from Homepage to Guest Reviews list 
	Given I am logged in as admin user and click on Guest Reviews menu
	
Scenario: Admin user Accept Hotel Review
	When I click on All Site Reviews link 
	And I select Review 
	And I click on Accept button 
	Then I should see page with message Selected review accepted successfully

Scenario: Admin user Delete Hotel Review	
	When I click on All Site Reviews link 
	And I select Review
	And I click on Delete button 
	Then I should see page with message Selected review deleted successfully
	
Scenario: Admin user Decline Hotel Review	
	When I click on All Site Reviews link 
	And I select Review 
	And I click on Decline button 
	Then I should see page with message Selected review declined successfully
	
