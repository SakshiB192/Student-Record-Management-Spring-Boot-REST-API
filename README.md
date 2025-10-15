# Student Record Management

A Spring Boot project to manage student records with authentication and role-based access.

---

## Features
- User registration and login
- Role-based access: USER and ADMIN
- CRUD operations for students
- Secure password encryption (BCrypt)
- Basic Authentication for API security 

---

## Setup Steps

1. Clone repository:
   ```bash
   git clone https://github.com/<your-username>/Student-Record-Management.git
   cd Student-Record-Management

   Make sure Java 17+ and Maven are installed

Build the project:
mvn clean install

Run the project:
mvn spring-boot:run
Test APIs in Postman
## Database Setup

This project uses **MySQL** as the database.  

1. Create a database named `student_management`:

spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=Sakshi@123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
