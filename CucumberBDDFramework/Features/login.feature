Feature: Login Feature
@sanity
Scenario: Login with Valid Credentials.
Given User launch Chrome Browser
	When User open url "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login Button
	Then Page title should be "Dashboard / nopCommerce administration"
	When Usre click on log out link
	Then Page title should be "Your store. Login"
	And Close the browser 
@regression
Scenario Outline: Login Data Driven 
	Given User launch Chrome Browser 
	When User open url "http://admin-demo.nopcommerce.com/login" 
	And User enter Email as "<email>" and Password as "<password>" 
	And Click on Login Button 
	Then Page title should be "Dashboard / nopCommerce administration" 
	When Usre click on log out link 
	Then Page title should be "Your store. Login" 
	And Close the browser
	
	Examples: 
		| email | password |
		| admin@yourstore.com	|	admin |
		| admin@yourstore.com	|	admin |