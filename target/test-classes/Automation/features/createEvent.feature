@tag
Feature: Create Event
	

@tag1
Scenario: Create Decertification Event
Given User is logged in to EQMS Application
When Navigate to Create Event Page
	And Enter Event Cause Detail
	And Click on Next Button
Then User should be successfully navigated to Event Information Page
When Enter all fields in event information page
	And Enter Sub Division and Mile post
Then Chek the service unit and region is correctly populated
When Click on Next button
Then User should be navigate to Employee Information page
When Enter all fields present on Employee Information page
 And Click on Create Event button
Then User should see the success message
 And Event should be created successfully
	

