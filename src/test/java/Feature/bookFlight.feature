Feature: Validate flyaway book flight
@search
Scenario Outline: Validate book flight
Given navigate to flyaway "<URL>"
When user logged in using username and password "<username>" "<password>"
Then it will redirect to dashboard page
And click on home link now
And click on book flight
And Verify the message "<message>"
Then verify the booking confirmation message "<confirmation>"
Examples:
|URL|username|password|message|confirmation|
|http://localhost:8080/FlyAway/|ojasvi.pratap17@gmail.com|123456789|Click to complete booking| FLYAWAY - BOOKING CONFIRMATION |