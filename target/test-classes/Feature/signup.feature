Feature: Validate flyaway signup 
@Smoke
Scenario Outline: Signup
Given navigate to flyaway page with for signup "<URL>"
Then click on signup link
When user enter the emailid as "<email>"
When user enter the password as "<password>"
When user enter the confirm password as "<confirmPassword>"
When user enter the name as "<name>"
When user enter the address as "<address>"
When user enter the city as "<city>"
And click on the signUp button
Examples:
|URL|email|password|confirmPassword|name|address|city|
|http://localhost:8080/FlyAway/|ojasvi.pratap17@gmail.com|123456789|123456789|Ojasvii|Delhi|NewDelhi|