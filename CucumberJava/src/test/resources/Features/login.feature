@SmokeFeature
Feature: Feature to test login functionality

@smoketest
Scenario: Check if login is successful with valid credentials

Given user is on the login page
When user enters username and password
And user clicks on the login button
Then user is navigated to the home page
