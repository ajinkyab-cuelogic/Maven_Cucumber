@ccipaddresses 
Feature: Test CC IP Addresses flow for phalanx application 
	I should be able to verify CC IP Addresses flow
Background: Flow from Homepage to IP Address list 
	Given I am logged in as admin user and click on CC IP Addresses menu 
	
Scenario: I want add CC IP Address 
	When I click on Add IP Address link
	And I enter IP Address details 
	And I click on create button on Add CC IP Address
	Then I should see page with message CC IP Address is successfully created 
	
Scenario: I update any CC IP Address from the list 
	When I click All IP Addresses link
	And I search CC IP address and I click edit icon
	And I update CC IP Address details and click on Update button
	Then I should see page with message CC IP Address is successfully updated
	
Scenario: I want delete CC IP Address 
	When I click All IP Addresses link
	And I search CC IP address and I click on Delete IP Address icon
	And I accept the Delete IP Address confirmation popup
	Then I should see page with message CC IP Address is successfully removed