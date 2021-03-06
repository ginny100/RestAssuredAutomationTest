Feature: Test login functionality

Scenario Outline: Check if login is successful with valid credentials

Given the browser is open
And user is on the login page
When user enters <username> and <password>
And user clicks on the login button
Then user is navigated to the home page

Examples:
|username|password|
|Ginny   | 12345  |
|Jenny   | 67890  |