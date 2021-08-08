Feature: login functionality test

Scenario: Check login with valid credentials
Given user is on the login page
When user enters valid username and password
And user clicks on the login button
Then user is navigated to the home page

@smoke
Scenario: Check login with invalid credentials
Given user is on the login page
When user enters invalid username and password
And user clicks on the login button
Then an error message is displayed - invalid credentials