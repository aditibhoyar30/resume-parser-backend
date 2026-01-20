# NextSkill - Advanced Resume Parser

A backend application that allows users to upload resumes (PDF/DOCX), parses key information, and stores structured resume data in a database.
This project focuses on file upload handling, backend processing, database design, and REST API development.

## 🚀 Project Overview

The Resume Parser Backend provides a REST API to:
- Upload resume files (PDF / DOCX)
- Validate file type and input
- Process resumes through a service layer
- Store extracted data in a relational database
- Verify stored data using H2 Console
The system is designed with real-world backend architecture principles, including layered design and database migrations.

## 🛠️ Technology Stack

### Backend
- **Spring Boot 3.2.5** - Main framework
- **Java 17** - Programming language
- **PostgreSQL** - Database
- **Apache Tika** - Text extraction from PDF/DOCX
- **Apache OpenNLP** - Natural Language Processing
- **Flyway** - Database migrations
- **Maven** - Build tool
 - Database migrations

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+
- 10MB free disk space for NLP models

## 🚀 Quick Start

### 1. Database Setup
```sql
CREATE DATABASE nextskill_db;
CREATE USER postgres WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE nextskill_db TO postgres;
```

### 2. Configuration
Copy `application.properties.template` to `application.properties` and update:
```properties
spring.datasource.password=your_password_here
```

### 3. Build and Run
```bash
cd backend
mvn clean compile
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Test the API
```bash
# Health check
curl http://localhost:8080/api/resume/health

# Upload resume (replace with your file)
curl -X POST -F "file=@resume.pdf" http://localhost:8080/api/resume/upload
```

## 📊 API Usage Examples

### Upload Resume
```bash
curl -X POST \
  -F "file=@resume.pdf" \
  http://localhost:8080/api/resume/upload
```

**Response:**
```json
{
    "resumeId": 1,
    "message": "Resume uploaded and parsed successfully.",
    "status": "success"
}
```
⚠️ Current Limitation (Known Issue)

At the current stage:
       - The system does not extract all resume fields perfectly
       - Fields such as:
                      full_name
                      summary
       - may be stored as null for some resumes

``` 
**NextSkill** - Making resume parsing intelligent and accurate! 🎯
