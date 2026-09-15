# vityarthi-spendwise-project

## Personal Expense Tracker

### 1. Project Overview

SpendWise is a command-line based Personal Expense Manager developed using Java.

The application helps users manage their personal finances by recording income and expenses, viewing transaction history, searching transactions, analyzing expenses by category, calculating the total income and expenses, and checking the available balance.

The project is designed to run completely through the command line without requiring any graphical user interface.

### 2. Objectives

The main objectives of SpendWise are:

1. To provide a simple way to record income and expenses.
2. To maintain a history of financial transactions.
3. To categorize expenses.
4. To search transactions by category or date.
5. To calculate total income and expenses.
6. To calculate the remaining balance.
7. To store transaction data using file handling.
8. To demonstrate important Java programming concepts.

### 3. Technologies Used

-Java
-Java Collections Framework
-Java File Handling
-Object-Oriented Programming
-Command Line Interface

## Features

- Add expense
- View expenses
- Search expense by category
- Calculate total expenses
- Delete expense
- Save expense details in a file
- Load saved expenses
- Handles invalid input

## Requirements

- Java JDK
- Command Prompt or Terminal

## How to Run

First download or clone the project.

Open the project folder in Command Prompt.

Compile the program using:

javac -d out src/*.java

Run the program using:

java -cp out Main

## How to Use

After running the program, a menu will be displayed.

1. Add Expense
2. View Expenses
3. Search by Category
4. Calculate Total Expenses
5. Delete Expense
6. Exit

Enter the number according to the operation you want to perform.

## Project Files

Expense.java - stores the details of an expense.

ExpenseManager.java - manages adding, viewing, searching, deleting and saving expenses.

Main.java - contains the main menu and runs the program.

## Data Storage

The expense details are saved in the data folder in the file:

expenses.txt
