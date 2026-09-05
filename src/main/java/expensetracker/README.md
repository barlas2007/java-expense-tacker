# Java Expense Tracker

A console-based expense management application built in Java.

The project was developed to practise object-oriented programming, Java collections, exception handling, file persistence, streams, Maven and automated testing with JUnit.

## Features

- Add and display expenses
- Search expenses by description
- Sort expenses by amount
- Calculate total spending
- Calculate average spending
- Find the highest expense
- View unique expense categories
- Calculate spending totals by category
- Validate expense descriptions, categories and amounts
- Save expenses to a file
- Load saved expenses between program runs

## Technologies

- Java
- Maven
- JUnit 5
- Java Collections
- Java Streams
- File I/O

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── expensetracker/
│           ├── Expense.java
│           ├── ExpenseTracker.java
│           ├── InvalidExpenseException.java
│           └── Main.java
└── test/
    └── java/
        └── expensetracker/
            ├── ExpenseTest.java
            └── ExpenseTrackerTest.java