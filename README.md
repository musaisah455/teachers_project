# Teacher Management API Project

A secure RESTful Spring Boot application for managing teachers' information (first name, last name, address, school) with JWT authentication, input validation, DTO pattern.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)  <!-- change if using H2 -->

## Table of Contents

- [Technologies/Features](#-technologies-/-features)
- [Installation & Setup](#-installation--setup)
- [Running the Application](#-running-the-application)
- [Teacher API Endpoints](#-api-endpoints)
- [Authentication](#-authentication)
- [Contributing](#-contributing)
- [License](#-license)

## Technologies/Features

- Java 17 or Higher version
- Spring Boot 3.2+
- Spring Security + JWT (register/login)
- Spring Data JPA
- A Relational Database (PostgreSQL)
- Lombok
- Request & Response DTOs
- Bean Validation (`@NotBlank`, `@Size`)
- Global exception handling
- Jakarta Validation
- Maven
- Git
- IDE: IntelliJ IDEA / VS Code / Eclipse

## Installation & Setup

1. Clone the repository

```bash
git clone https://github.com/musaisah455/teacher-project.git
cd teacher-project
```

Install dependencies
```
mvn clean install
```
## Running the Application

```
mvn spring-boot:run
```
From IDE: Run DemoApplication.java
Application starts at: http://localhost:8080/api/teachers

## Teacher API Endpoints

### Method----------Endpoint--------------Description-----------Auth-required?
#### POST----------------/auth/register------------Register new user------------No
#### POST----------------/auth/login----------------Login & get JWT------------No
#### POST----------------/api/teachers-------------Create new teacher----------Yes
#### GET------------------/api/teachers-------------Get all teachers------------Yes
#### GET-----------------/api/teachers/{id}--------Get teacher by ID------------Yes
#### PUT-----------------/teachers/{id}-----------Update teacher---------------Yes
#### DELETE-------------/teachers/{id}-------------Delete teacher---------------Yes

## Authentication

### Register a user

#### POST http://localhost:8080/auth/register
{

"username": "admin",

"password": "admin123",

"role": "ADMIN"

}

### Login with the username and password of the request body of the registered user and get JWT token

#### POST http://localhost:8080/auth/login
{

"username": "admin",

"password": "admin123"

}

#### Copy the token and use it in headers:
text Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

## Contributing

Fork the repository

Create your feature branch (git checkout -b feature/amazing-feature)

Commit your changes (git commit -m 'Add some amazing feature')

Push to the branch (git push origin feature/amazing-feature)

Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

Made by Musa in Abuja

Last updated: February 2026
