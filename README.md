# Java-Assignment

# Technology:
Spring Boot 2.5
Spring Data JPA
Java 1.8
In Memory DB – H2
REST Web Service
Junit
Mockito


# How to run application:
•	Download the application for GitHub and import it to IDE
•	Run the main class Spring Boot Application “JavaAssignmentApplication” class.
•	1st Requirement use http://localhost:8080/api/allUsersPosts this API which will give you all user’s posts consolidated information.

•	2nd requirement use below API’s:
o	#A: http://localhost:8080/api/addPost
o Request Body: {"title":"Title man","body":"Desc man","userId":1,"publish":false}

o	#B: http://localhost:8080/api/viewAllPost

•	A: API used for add new post to in memory DB and #B: API for fetch all posts details from db.

# How to run Test Cases:
•	There are two main Test Cases for this application.
o	JavaAssignmentApplicationIntegrationTest this file having application integration test.
o	AdminControllerTest is having Junit test cases for all API’s.
