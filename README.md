# Java-Assignment

# Technology:
Spring Boot 2.5,
Spring Data JPA,
Java 1.8,
In Memory DB – H2,
REST Web Service,
Junit,
Mockito

# How to run application:
•	Download the application for GitHub and import it to IDE
•	Run the main class Spring Boot Application “JavaAssignmentApplication” class.
•	1st Requirement use http://localhost:8080/api/allUsersPosts this API which will give you all user’s posts consolidated information.

•	2nd requirement use below API’s:
•	#A: http://localhost:8080/api/addPost
•	Request Body: {"title":"Title man","body":"Desc man","userId":1,"publish":false}

•	#B: http://localhost:8080/api/viewAllPost

•	A: API used for add new post to in memory DB and #B: API for fetch all posts details from db.

This http://localhost:8080/api/viewPostByUserId/{id} Api used for fetching all posts by User Id.
This http://localhost:8080/api/viewAllAuditedPost/{audited} Api used for fetching all posts by audited flag - True/False.

# How to run Test Cases:
•	There are three main Test Cases for this application.
•	JavaAssignmentApplicationIntegrationTest this file having application integration test.
•	AdminControllerTest is having Junit test cases for all API’s.
•	AdminServiceTest is having Junit test cases for all API’s.
