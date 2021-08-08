Feature: Check home page functionality

Background: user is logged in
Given user is on the login pge
When user enters username and password
And user clicks on the loggin button
Then user is navigated to the homepage

Scenario: check logout link
When user clicks on the welcome link
Then the logout link is displayed

Scenario: verify quick launch toolbar is present
When user clicks on the dashboard link
Then the quick launch toolbar is displayed