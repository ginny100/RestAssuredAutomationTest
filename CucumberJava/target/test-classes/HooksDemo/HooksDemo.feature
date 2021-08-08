Feature: Check login functionality

@smoke
Scenario:
Given user is on the login page
When user enters valid username and password
And user clicks on the login button
Then user is navigated to the home page


Scenario:
Given user is on the login page
When user enters valid username and password
And user clicks on the login button
Then user is navigated to the home page