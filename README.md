# assurity-repo

## Description:

## Using the API given below create an automated test with the listed acceptance criteria:

## Link:

##### API = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false

## Acceptance Criteria:

##### Name = "Carbon credits"

##### CanRelist = true

##### The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

## Instructions:

##### Your test needs to be written using a programming language of your choice (not a tool like SoapUI). Ensure you include a clear ReadMe

##### Submit your test to us in a format that lets us execute and review the code (it must be submitted in a public repository like Bitbucket or Github)

##### Your test must validate all the three acceptance criteria

##### Points will be awarded for meeting the criteria, style and the use of good practices and appropriate use of source control

##### We want to see your best work - no lazy coding or comments.

## Razvan's testing approach:

##### I have chosen to use SpringBoot with Kotlin as a basic framework on which to build my tests. I am also using IntelliJ IDEA as my development IDE. I have done this due to my familiarity with these development tools.

##### The test requirements consist of checking the 3 criteria mentioned in Acceptance Criteria. In order to keep the best practices of having tests as atomic as possible, I have split the testing implementation in 3 separate tests, which can be run individually or together as a suite.

##### The tests themselves are parameterized in order to easily accommodate a possibly expanding scope, where we want to check other criteria as well.

##### I have chosen to implement a Strategy design pattern for reading the input JSON from the API, in order to have the test application ready for a possible change in the input provider e.g. having some restful service with a Get functionality.

##### The entire implementation focuses on implementing the SOLID coding principles. 

## Possible improvements for later:

##### Provide a database for storing test run results, in order to have a historical view.

##### Create a Docker image with the testing application, so the API can be tested from anywhere, by usage of said image.