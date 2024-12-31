# Student Information System

A simple Student Information System using **Spring Boot** + **MySQL** + **Docker** + **Jenkins**.

## Features
- CRUD (Create, Read, Update, Delete) operations for a `Student`.
- Uses Spring Data JPA for database access.
- Docker containerization.
- Sample Jenkinsfile for CI/CD.
- Minimal front-end can be built or tested with Postman.

## How to Run Locally

1. **MySQL Setup**  
   - Create a database named `students_db`.
   - Use username/password = `root/password` (or change in `application.properties`).

2. **Build & Run**  
   ```bash
   mvn clean package
   java -jar target/StudentInfoSystem-1.0.0.jar
