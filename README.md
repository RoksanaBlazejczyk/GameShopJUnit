<img width="1400" height="733" alt="image" src="https://github.com/user-attachments/assets/84f6574b-de42-4245-8689-64cfe9400608" />


Retro Game Shop Management System
A Java-based console application for managing a retro video game shop, including features for inventory management, customer transactions, trade-ins, discounts, and file saving/reporting.
Overview
The Retro Game Shop System simulates the workflow of a small retro game shop.
It allows a Manager to manage game stock, and a Customer to buy and trade-in games.
The program maintains an inventory, tracks transactions, applies discounts, and saves reports to a file.
Users interact with the shop through a menu-driven interface that runs in the console.

Main Features
 Manager Functions
•	Add or restock games.
•	View current inventory.
•	Save inventory reports to a file.
Customer Functions
•	View available games.
•	Purchase games (with automatic discount formatting).
•	Trade in existing games.
•	View personal transaction history with timestamps.
File Handling
•	Generates a text report (inventory_report.txt) containing:
o	Inventory details (name, price, quantity).
o	Customer transactions.
o	Date and time of actions.
Discounts
•	Percentage-based discounts applied to purchases.
•	Prices always displayed with two decimal places (£50.00).

Object-Oriented Design
The system uses strong OOP principles and package organization:
r.blazejczyk.main          → Main entry point  
r.blazejczyk.userInterface → User interaction logic  
r.blazejczyk.customer      → Customer, Transaction, Discount, Purchase, TradeIn classes  
r.blazejczyk.game          → Game, Type, Inventory, Manager, SaveToFile classes  
Key Classes:
Class	Responsibility
Main	Launches the user interface
UserInterface	Displays menus and handles user choices
Inventory	Stores and manages available games
Game / Type	Represents individual games and their details
Manager	Oversees inventory management
Customer	Handles transactions, purchases, and trade-ins
Purchase / TradeIn	Defines transaction types
Discount	Applies and formats discounts
SaveToFile	Handles writing and appending data to files

How to Run
Prerequisites
•	Java JDK 17 or newer
•	Any IDE (e.g., IntelliJ IDEA, Eclipse) or terminal
Steps
1.	Clone or copy the project files.
2.	Ensure all .java files are in their correct package directories.
3.	Compile the project:
4.	javac r/blazejczyk/main/Main.java
5.	Run the main class:
6.	java r.blazejczyk.main.Main
7.	Use the interactive menu to explore features.

Example Output
==============================
Welcome to Retro Game Shop!
==============================
1. View Inventory
2. Buy a Game
3. Trade In a Game
4. View Transaction History
5. Exit
Choose an option: 2
Enter game name to buy: Zelda
Robert purchased Zelda for £63.00 (Qty: 1)
Example saved to inventory_report.txt:
Inventory Report
====================
Final Inventory:
Zelda - Quantity: 1 | Price: £63.00

Future Improvements
•	GUI interface using JavaFX or Swing.
•	Database integration (SQLite or MySQL).
•	Loyalty points for frequent customers.
•	Export inventory to CSV or Excel format.

 Author
Roksana Blazejczyk
HND Computing — New College Lanarkshire
