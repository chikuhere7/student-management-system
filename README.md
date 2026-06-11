# Student Management System

## Overview

A RESTful Student Management System developed using Spring Boot and MySQL. The application provides CRUD operations for managing student records along with validation, exception handling, and API documentation using Swagger/OpenAPI.

## Features

* Create Student
* View All Students
* View Student By ID
* Update Student Details
* Delete Student
* Search Students By Name
* Input Validation
* Global Exception Handling
* Swagger/OpenAPI Documentation

## Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger/OpenAPI

## API Endpoints

* POST `/students` → Create Student
* GET `/students` → Get All Students
* GET `/students/{id}` → Get Student By ID
* PUT `/students/{id}` → Update Student
* DELETE `/students/{id}` → Delete Student
* GET `/students/search/{name}` → Search Students By Name

## Validation

* Name is required
* Valid email format required
* Course is required

## Exception Handling

Custom exception handling using:

* StudentNotFoundException
* GlobalExceptionHandler

## Swagger Documentation

Access Swagger UI at:

`http://localhost:9090/swagger-ui/index.html`

## Project Structure

* Controller Layer
* Service Layer
* Repository Layer
* DTO Layer
* Exception Handling Layer
* MySQL Database Integration

## Future Enhancements

* Spring Security
* JWT Authentication
* Role-Based Authorization
* Pagination and Sorting

## Author

**Saroj Jena**
