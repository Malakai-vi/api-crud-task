# 🚀 Building a REST API with Spring Boot: Task Management

## 🌟 Project Goal

This repository contains a functional Backend Web Application Development project created with Java and the **Spring Boot (v3.5.8)** framework.

The main objective of this project is to serve as a practical resource for fellow students and developers looking to understand and apply the following key concepts.

### 🔑 Added Educational Value

To facilitate learning, **all source code (Controller, Repository, and Model) is commented line-by-line**, explaining:
* The **purpose** of each Spring annotation (e.g., `@RestController`, `@Autowired`).
* The **function** of each method and its relationship with the Database.
* Key **concepts** of JPA (Java Persistence API).

### Key Concepts to Learn

1.  **Layered Architecture:** Understanding the division into Model, Repository, and Controller.
2.  **Basic CRUD:** Implementing the four fundamental data management operations.
3.  **Data Persistence:** Using Spring Data JPA to save and retrieve information without writing raw SQL.
4.  **RESTful APIs:** Creating *endpoints* that respond to HTTP requests (GET, POST, PUT, DELETE).

## 🛠️ Stack and Prerequisites

To run this project, you will need the following:

* **Language:** Java Development Kit (JDK 17 or higher)
* **Framework:** Spring Boot 3.5.8
* **Dependency Manager:** Maven
* **Database:** H2 Database (In-memory, requires no external installation).
* **Testing Tool:** An HTTP client (I recommend the **REST Client** VS Code extension).

## 🧩 Construction Steps (Student Guide)

The project is divided into three main components that work together: 

### Step 1: The Model (The Data Structure)

The `Task.java` file defines the **shape** of the data we will store.
* `@Entity`: Tells Spring that this is a database table.
* `@Data` (Lombok): Saves us from writing *Getters* and *Setters*.

### Step 2: The Repository (The DB Access Layer)

The `TaskRepository.java` interface is the key to data persistence.
* By extending `JpaRepository<Task, Long>`, we **automatically** inherit methods like `save()`, `findAll()`, `findById()`, etc.
* This means **we write no SQL code**. Spring handles the translation of these methods into SQL statements (INSERT, SELECT, etc.).

### Step 3: The Controller (The HTTP Intermediary)

The `TaskController.java` is the "API guardian," responsible for mapping HTTP requests to the repository's actions.

| HTTP Method | URL Mapping | Action in the DB |
| :--- | :--- | :--- |
| `GET` | `/api/task` | `taskRepository.findAll()` |
| `POST` | `/api/task` | `taskRepository.save()` |
| `PUT` | `/api/task/{id}`| `taskRepository.save()` (after updating) |
| `DELETE` | `/api/task/{id}`| `taskRepository.deleteById()` |

---

## ⚙️ How to Get Started

### 1. Cloning and Execution

1.  Clone the project to your machine.
2.  Open the root folder in VS Code.
3.  Run the application from the terminal (ensure your JDK is configured):
    ```bash
    ./mvnw spring-boot:run
    ```
4.  The server should start on `http://localhost:8080`.

### 2. Functional Testing

Use the **`requests.http`** file included in the project root (requires the **REST Client** extension) to test the endpoints:

1.  **POST:** Create new tasks.
2.  **GET:** Retrieve the list of tasks.
3.  **PUT:** Update a task's status (e.g., to `completed: true`).
4.  **DELETE:** Remove tasks.

---

## 🎓 About the Author

I am Malakai Villegas, a recent graduate in Web Application Development. This project was a key exercise to consolidate my modern Java backend skills. 

I recommend this exercise to any programming student because it is the "Rosetta Stone" of backend development: if you understand the Model-Repository-Controller architecture and how Spring Data JPA works, you have the foundation to work with any modern framework (such as Laravel, Django, or Node.js/Express).


* **My LinkedIn profile:** (https://www.linkedin.com/in/malakai-villegas-pérez-8239b1339)

