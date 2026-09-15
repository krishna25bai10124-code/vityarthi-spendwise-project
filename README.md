# vityarthi-spendwise-project

## Personal Expense Tracker

This is a simple Java project to keep track of personal expenses.

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
