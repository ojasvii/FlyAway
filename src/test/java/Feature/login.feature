Feature: Validate flyaway login with correct credentials.
@Smoke
Scenario Outline: Validate Login
Given navigate to flyaway page with "<URL>"
When user logged in using username as "<username>"
When user logged in using password as "<password>"
Then dashboard page should be displayed
Examples:
|URL|username|password|
|http://localhost:8080/FlyAway/|ojasvi.pratap17@gmail.com|123456789|