Feature: Validate flyaway search flight
@search
Scenario Outline: Validate search flight
Given navigate to flyaway page "<URL>"
When user logged in using username "<username>"
When user logged in using password "<password>"
Then dashboard page should display
And click on home link
And click on source and select value 
And click on destination and select value
Then click on submit button
Examples:
|URL|username|password|
|http://localhost:8080/FlyAway/|ojasvi.pratap17@gmail.com|123456789|