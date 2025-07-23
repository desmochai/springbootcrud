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
- Java v24+
- Gradle v8+
- AWS credentials with DynamoDB access
- [DynamoDB Local](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html) (optional for local testing)

### Running the App

```bash
./gradlew bootrun
```

### API Endpoints

| Method | Endpoint       | Description       |
|--------|----------------|-------------------|
| GET    | `/items`       | Get all items     |
| GET    | `/items/{id}`  | Get item by ID    |
| POST   | `/items`       | Create new item   |
| PUT    | `/items/{id}`  | Update item       |
| DELETE | `/items/{id}`  | Delete item       |

### 📁 Suggested Project Structure

com.desmochai.springbootcrud
├── controller     # Handles incoming HTTP requests
├── service        # Business logic layer
├── repository     # DynamoDB interaction layer
├── model          # Data models / DTOs
└── config         # Configuration (AWS and other)

### 🧪 TODOs
	•	Add Swagger UI
	•	Add unit/integration tests
	•	Dockerize the app
	•	CI/CD pipeline (GitHub Actions)