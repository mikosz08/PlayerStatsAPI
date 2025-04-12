# 🕹️ Player Stats API

A simple REST API built with Spring Boot for managing player profiles in a game-like system.

This project was created as part of my preparation for a Java internship, showcasing my ability to build clean, testable, and Docker-ready backend services.

---

## Features

- ✅ Create, Read, Update, Delete (CRUD) player profiles
- ✅ Database using H2
- ✅ Architecture (Controller → Service → Repository)
- ✅ Data validation and exception handling
- ✅ Unit testing with JUnit and Mockito
- ✅ Swagger UI documentation
- ✅ Docker and Docker Compose ready
- ✅ RabbitMQ Message Publishing

---

## Technologies

- Java 17
- Spring Boot 3.4
- Spring Data JPA
- H2 Database
- Lombok
- Jakarta Validation
- JUnit + Mockito
- Swagger (springdoc-openapi)
- Gradle

---

## Getting Started

### Running locally

1. Clone the repository:
   ```bash
   git clone https://github.com/mikosz08/PlayerStatsAPI.git
   cd PlayerStatsAPI
2. Run the appliaction
   ```bash
     ./gradlew bootRun
3.Access the API:

  Swagger UI: 
    http://localhost:8080/swagger-ui.html

  H2 Console: 
    http://localhost:8080/h2-console

        JDBC URL: jdbc:h2:mem:testdb
        Username: sa
        Password: (leave empty)

---

---

## 🧪 Testing

To run all unit tests:
```bash
./gradlew test
```

Tests cover:
- PlayerService (CRUD logic)
- Exception handling

---

## Example Requests

### POST `/api/players`
```json
{
  "username": "Geralt",
  "level": 10,
  "experiencePoints": 2000
}
```

### Response
```json
{
  "id": 1,
  "username": "Geralt",
  "level": 10,
  "experiencePoints": 2000
}
```

## 🐳 Docker

To build and run the app using Docker:

```bash
./gradlew build
docker build -t playerstats-api .
docker run -p 8080:8080 playerstats-api
```

---

## 👨‍🎓 Author

**mikosz08**  


---

![image](https://github.com/user-attachments/assets/bdb873ce-95bd-4af7-88db-8b90f4853444)
![image](https://github.com/user-attachments/assets/e4b7ee4f-a2ae-485a-b806-cd52611648a1)
![image](https://github.com/user-attachments/assets/035d8e08-d02e-47a2-b76b-0192c1bb5ab2)


> ℹ️ **Note:**  
> By default, the H2 Console is only accessible locally (`localhost`).  
> If you're running the app inside Docker and need access to the H2 console from your host machine,  
> you can enable it by adding the following to `application.properties`:
>
> ```properties
> spring.h2.console.settings.web-allow-others=true
> server.address=0.0.0.0
> ```

