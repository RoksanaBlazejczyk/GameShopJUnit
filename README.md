
<img width="1536" height="1024" alt="aaa" src="https://github.com/user-attachments/assets/cbb88e35-7811-4ce9-a43b-5f5fe3259883" />

🎮 Retro Game Shop Management System

A Java-based console app that lets you manage a retro video game shop — including inventory control, customer purchases, trade-ins, discounts, and automatic report saving.

🕹️ Overview

The Retro Game Shop System simulates how a small retro gaming store operates.
It allows two main user roles:

Manager – to handle stock management.

Customer – to browse, buy, and trade in games.

The program keeps track of all games in stock, logs transactions, applies discounts automatically, and saves reports to a file.
Everything runs through a simple, menu-based console interface.

✨ Main Features
👩‍💼 Manager Options

Add new games or restock existing ones

View the current inventory<img width="1536" height="1024" alt="aaa" src="https://github.com/user-attachments/assets/2a727a7d-fb1e-44c9-b82e-fdcd6244ecaf" />


Save an inventory report to a file

🧑‍💻 Customer Options

Browse available games

Buy games (with automatic discount formatting)

Trade in old games

View personal transaction history, complete with timestamps

🗂️ File Handling

Automatically creates a text report (inventory_report.txt) that includes:

Current inventory (name, price, quantity)

Customer transactions

Dates and times of all actions

💸 Discounts

Percentage-based discounts applied to purchases

Prices always shown with two decimal places (e.g., £50.00)

🧱 Object-Oriented Design

The system follows solid OOP principles and a clean package structure:

Package	Purpose
r.blazejczyk.main	Main entry point
r.blazejczyk.userInterface	Handles user menus and input
r.blazejczyk.customer	Customer, Transaction, Discount, Purchase, TradeIn classes
r.blazejczyk.game	Game, Type, Inventory, Manager, SaveToFile classes

Key Classes:

Class	Responsibility
Main	Starts the application
UserInterface	Displays menus and processes user choices
Inventory	Manages the list of games
Game / Type	Represents each game and its details
Manager	Handles stock management
Customer	Manages customer purchases and trade-ins
Purchase / TradeIn	Define transaction types
Discount	Applies discounts to purchases
SaveToFile	Writes reports and transaction logs to files
⚙️ How to Run

Requirements:

Java JDK 17 or newer

Any IDE (like IntelliJ IDEA or Eclipse) or command line

Steps:

Clone or copy the project files.

Make sure all .java files are in their correct package directories.

Compile the project:

javac r/blazejczyk/main/Main.java


Run the program:

java r.blazejczyk.main.Main


Use the interactive menu to explore features.

🧾 Example Output
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


Example entry in inventory_report.txt:

Inventory Report
====================
Final Inventory:
Zelda - Quantity: 1 | Price: £63.00

🚀 Future Improvements

Add a graphical interface (JavaFX or Swing)

Integrate with a database (SQLite or MySQL)

Introduce loyalty points for frequent customers

Export inventory data to CSV or Excel

👩‍💻 Author

Roksana Blazejczyk
HND Computing — New College Lanarkshire
