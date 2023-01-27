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

Feature: Title of your feature
  I want to use this for Logging in to Addactin app and search a hotel

# Instead of Scenario we write this as "Background" so that before any scenario is run background will be run as precondition
  Background: Login to Hotel app
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is traversed to Search Hotel page
    

		
		
  Scenario Outline: Search for Hotel
    Given user is on Search Hotel page
    When user selects "<location>", "<rooms>", "<check in date>", "<check out date>", "<adults>"
    And user clicks on search button
		And search results should be displayed
		And user selects Hotel "<Hotel>"
		And user clicks on continue button
		And user selects details "<First Name>", "<Last Name>", "<Billing Address>", "<CC No>", "<CC Type>", "<Expiry Month>", "<Expiry Year>", "<CVV Num>"
		
		

    Examples: 
    | username | password | location | rooms | check in date | check out date | adults | Hotel | First Name | Last Name | Billing Address | CC No | CC Type | Expiry Month | Expiry Year| CVV Num | 
		| santosh13 | Snoopy1234 | Melbourne | 1 - One | 13/01/2023 | 14/01/2023 | 1 - One | radiobutton_1 | Anjali | Dhawan | Test Address | 1122334455667788 | American Express | December | 2022 | 123 |
		 
