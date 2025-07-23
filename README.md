# Spring Boot CRUD with DynamoDB

A simple Spring Boot 3.x CRUD application using Java 24 and Amazon DynamoDB. This project demonstrates how to build RESTful APIs with Spring Boot while integrating with AWS DynamoDB as the primary data store.

## 🔧 Tech Stack

- Java 24
- Spring Boot 3.x
- Amazon DynamoDB (with AWS SDK v2)
- Gradle
- RESTful API design

## 📦 Features

- Create, Read, Update, Delete (CRUD) operations
- Integration with DynamoDB using AWS SDK
- Global exception handling
- Input validation
- Layered architecture (Controller → Service → Repository)

## 🚀 Getting Started

### Prerequisites
- Java 24+
- AWS credentials with DynamoDB access
- [DynamoDB Local](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html) (optional for local testing)

### Running the App

```bash
./gradlew bootrun