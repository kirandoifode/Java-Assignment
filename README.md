# Java-Assignment

# Technology:
Spring Boot 2.5
Java 1.8
REST Web Service
Junit
Mockito


# How to run the application:
•	Download the application for GitHub and import it to IDE.
•	Run the main Spring Boot Application “JavaAssignmentApplication” class.
•	Then for 1st Requirement I have created this http://localhost:8080/api/allUsersPosts API which will give you all users posts consolidated information.

•	Then for 2nd requirement I have created two API which is as follows: First add records to DB then fetch it.
  # A: http://localhost:8080/api/addPost
    o Request Body: {"title":"Title man","body":"Desc man","userId":1,"publish":false}
  # B: http://localhost:8080/api/viewAllPost
    •	#A: API used for add new post to in memory DB and #B: API for fetch all posts details from db.

# I have created this http://localhost:8080/api/getUsersPostView api for shows 1st requirement details on browser with the help of thymeleaf.

# How to run the Test Cases:
•	I have created Two main Test Cases for this application.
•	JavaAssignmentApplicationIntegrationTest this file having application integration test.
•	AdminControllerTest is having Junit test cases for all API’s.

