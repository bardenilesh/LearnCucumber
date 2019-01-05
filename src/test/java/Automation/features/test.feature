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
@tag
Feature: Test Data

@tag1
Scenario: Update Decertification Event
Given User is logged in to EQMS Application
When Navigate to Create Event Page
	And Update Details on Event Cause Detail Page
	And Click on Next Button
Then User should be successfully navigated to Event Information Page
When Update all fields in event information page
	And Enter Sub Division and Mile post
Then Chek the service unit and region is correctly populated
When Click on Next button
Then User should be navigate to Employee Information page
When Update all fields present on Employee Information page
 And Click on Update Event button
Then User should see the success message
 And Event should be updated successfully
	
	
