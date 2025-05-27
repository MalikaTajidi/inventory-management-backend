# Inventory Management System - Backend

This is a backend application for a simple Inventory Management System built with Spring Boot. It supports two roles:

- **Admins** can add, view, and delete inventory items.
- **Customers** can view available items.

Admin endpoints are protected using HTTP Basic Authentication.  

---

## Technology Stack

- Java 17
- Spring Boot 3
- Spring Security (HTTP Basic Auth)
- Spring Data JPA
- PostgreSQL
- Bean Validation (Jakarta)

---


### Prerequisites

- [Java JDK 17](https://adoptium.net/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

---

###  1. Clone the Repository

```bash
git clone https://github.com/MalikaTajidi/inventory-management-backend.git
cd inventory-management-backend
````

---

### 2. Set Up the PostgreSQL Database

1. Create the database:

```sql
CREATE DATABASE inventory;
```

2. Run the SQL script to create the `items` table:

```bash
psql -U your_user -d inventory -f scripts/create_items_table.sql
```
### Note
You don’t need to run the script manually — Hibernate will automatically create the table at runtime based on the entity definitions
---

###  3. Configure Application Properties

Edit the file `src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory
spring.datasource.username=your_user
spring.datasource.password=your_password

spring.security.user.name=admin
spring.security.user.password=admin123
```

---

### 4. Run the Application

Start the Spring Boot app:

```bash
mvn spring-boot:run
```
### Note
If you're using an IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code (with the Java extensions installed), you can run the application directly from the IDE without installing Maven manually — most modern IDEs handle Maven builds internally.

The app will be available at:
 `http://localhost:8080`

---

##  Authentication

* HTTP Basic Auth is used for admin endpoints.
* Default admin credentials:

```
Username: admin
Password: admin123
```

---

## API Endpoints

### Admin (Requires Auth)

| Method | Endpoint            | Description       |
| ------ | ------------------- | ----------------- |
| GET    | `/admin/items`      | Get all items     |
| POST   | `/admin/items`      | Add a new item    |
| DELETE | `/admin/items/{id}` | Delete item by ID |

###  Customer (Public)

| Method | Endpoint | Description   |
| ------ | -------- | ------------- |
| GET    | `/items` | Get all items |

---

## Testing with Postman

1. Use HTTP Basic Auth with:

   * Username: `admin`
   * Password: `admin123`
2. For `POST` requests, set:

   * Header: `Content-Type: application/json`

Example request body for `POST /admin/items`:

```json
{
  "name": "Laptop",
  "price": 1200.50,
  "description": "High-end developer laptop"
}
```

---

## Database Schema

**items** table:

 SQL Script: `scripts/create_items_table.sql`
 Full Docs: `docs/submission.pdf`

---

## Folder Structure

```
inventory-management-backend/
├── inventory/src/                      # Source code
├── scripts/
│   └── create_items_table.sql
├── docs/
│   └── API-Documentation-MalikaTAJIDI.pdf
│   
|
└── README.md
```


