@call 
Feature: Cal Recording module In order to test call recording module by login with superadmin 
Background: Flow from homepage to Call Recordings 

	Given I am logged in as admin user and click on Call Recordings menu 
	
Scenario: Admin creates new Recording View 
	When I click on Add Recording View link 
	And I enter recording details and click on create button
	Then I should see page with message Recording view was successfully created 
	
Scenario: Admin views recording view page 
	When I click on All Recording View link 
	And I click on view icon from recording view list 
	Then I should see recording view page 
	
	
Scenario: Admin updates recording view from the list 
	When I click on All Recording View link 
	And I click edit icon from the recording list 
	And I update the recording view details and click on Update button 
	Then I should see page with message Recording view was successfully updated
	
	
Scenario: Admin deletes an recording view from the list 
	When I click on All Recording View link 
	And I click on delete icon from the recording view list 
	Then I should see page with message Recording view was successfully deleted