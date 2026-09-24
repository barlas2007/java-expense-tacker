# Java Expense Tracker

A Java expense management application built to practise object-oriented programming, database integration, testing, and backend development concepts.

## Features

- Add and manage expenses
- Search expenses by description
- Sort expenses by amount
- Calculate total, average, and highest spending
- Group expenses by category
- PostgreSQL database persistence
- CRUD operations using JDBC
- Parameterised SQL queries using PreparedStatement
- ResultSet mapping from database rows to Java objects
- Repository pattern for database access
- Transaction handling with commit and rollback
- Input validation and custom exceptions
- JUnit testing
- Maven project structure

## Tech Stack

- Java
- PostgreSQL
- SQL
- JDBC
- Maven
- JUnit
- Git
- GitHub

## Project Structure

- `Expense` — represents an expense and handles validation
- `ExpenseTracker` — contains expense analysis and business logic
- `ExpenseRepository` — handles database CRUD operations and transactions
- `DatabaseConnection` — manages PostgreSQL connections
- `Main` — application entry point
- `InvalidExpenseException` — custom validation exception

## Database Integration

The application connects to PostgreSQL using JDBC.

Database operations use `PreparedStatement` to safely execute parameterised SQL queries.

The repository layer handles:

- Create
- Read
- Update
- Delete
- Transaction-based multi-step inserts

Database rows are converted into Java objects using `ResultSet`.

## Transactions

The project includes transaction handling using:

- `setAutoCommit(false)`
- `commit()`
- `rollback()`

This ensures related database operations either complete together or are rolled back if one operation fails.

## Security

Database credentials are not stored directly in the source code.

The database password is read from an environment variable:

```java
System.getenv("DB_PASSWORD");
