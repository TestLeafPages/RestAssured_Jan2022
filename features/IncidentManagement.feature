@smoke
Feature: IncidentManagement

#Background:
#Given Set EndPoint for the server
#And Set up the Authentication as 'admin' and 'Tuna@123'

Scenario: Create a new Incident

When place the post request
Then Verify the status code as 201
And Print the Response body
And Print the Response ContentType


Scenario Outline: Create a new Incident with body

When place the post request with body as '<shortDescription>' and '<category>'
Then Verify the status code as 201
And Print the Response body
And Print the Response ContentType

Examples:
|shortDescription|category|
|Create Incident with body as string 1|hardware|
|Create Incident with body as string 2|hardware|

#|filepath|
#|./data/CreateIncident1.json|
#|./data/CreateIncident2.json|







