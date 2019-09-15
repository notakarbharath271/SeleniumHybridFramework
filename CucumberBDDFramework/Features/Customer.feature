Feature: Customer
 Background: Below common steps for each scenario
 	Given User launch Chrome Browser
	When User open url "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login Button
	Then User can view Dashboard

@sanity 
Scenario: Adding New Customer

 	
	When User click on customers Menu
	And click on customer Menu Item
	And click on Add New button
	Then User can view Add New customer page 
	When User enter customer info
	And click on save button
	Then User can view confirmation message "The new customer has been added sucessfully"
	And Close the browser
		
@regression		
Scenario: Search customer by EmailId
	
	When User click on customers Menu
	And click on customer Menu Item
	And Enter customer EmailId
	When Click on search button
	Then User should found Email in the search table
	And Close the browser 
@regression		
Scenario: Scearch customer by Name
		
	
	When User click on customers Menu
	And click on customer Menu Item
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User should found Name in the search table
	And Close the browser 