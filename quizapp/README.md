
# Quiz Application (Monolithic)

This project is a monolithic Quiz Application built using Spring Boot. It allows users to create quizzes with multiple-choice questions, submit their answers, and receive their results. The application follows the MVC (Model-View-Controller) architecture and utilizes JPA for database interactions, with PostgreSQL as the database.





## Technologies Used

1. Spring Boot: For building the backend services.
2. Spring Data JPA: For simplifying the data access layer and  managing the database.
3. PostgreSQL: As the relational database to store quizzes.  
4. Lombok: To reduce boilerplate code for models.
5. Postman: For API testing.
6. Java: The primary programming language for the backend logic.
7. Maven: For managing dependencies and building the project.


## Installation

Clone the repository

```bash
https://github.com/SulphuricVein/quiz_monolithic.git
cd quiz-application

```
Install PostgreSQL if not already installed.    
Create a new database named questions_db.

Update the application’s application.properties or application.yml file with your PostgreSQL credentials:

```bash
spring.application.name=quiz-service
server.port=8090
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/questionsdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Build and run the application
```bash
mvn clean install
mvn spring-boot:run
```
    
## API Endpoints

Create a quiz
```
POST http://localhost:8090/quiz/category/{category}/{count}/{title}
```

Fetch quiz
```
GET http://localhost:8090/quiz/{id}
```
Submit answers
```
POST http://localhost:8090/quiz/submit/{id}
```