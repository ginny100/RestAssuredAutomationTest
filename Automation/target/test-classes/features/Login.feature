Feature: Application Login

# Positive Scenario
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "Ginny" and password "12345"
Then Home page is populated
And Cards displayed are "true"

# Positive Scenario
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "Gin" and password "67890"
Then Home page is populated
And Cards displayed are "false" 