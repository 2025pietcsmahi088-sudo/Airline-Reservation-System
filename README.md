# ✈️ Airline Reservation System

A desktop-based **Airline Reservation and Management System** built with **Java (Swing / AWT)** and **MySQL**, designed to streamline flight scheduling, passenger seat tracking, and administrative operations.

---

## 📌 Project Overview
- **Project Name:** Airline Reservation System
- **Submitted By:** Mahi Rajawat
- **Roll / Registration No:** PIET25CS088
- **Institution:** Poornima Institute of Engineering & Technology (PIET), Jaipur
- **Department:** Department of Computer Engineering
- **Academic Year:** 2026–27

---

## 🚀 Features
- 🔐 **Secure Admin Authentication:** Username and password validation against the database.
- 📊 **Interactive Dashboard:** Quick navigation to flight and reservation management modules.
- 🛫 **Flight Management (CRUD Operations):**
  - **View Flights:** Real-time tabular display of flight schedules and seat availability.
  - **Add Flight:** Easy-to-use form dialog to register new flights.
  - **Edit Flight:** Update routes, dates, timings, and capacity dynamically.
  - **Delete Flight:** Safe removal of obsolete flights with prompt confirmation.
  - **Refresh:** Immediate synchronization with the underlying database.
- 🗄️ **Relational Database Storage:** Powered by MySQL via JDBC for reliable record persistence.

---

## 🛠️ Technology Stack
- **Language:** Java (JDK 8+)
- **GUI Framework:** Java Swing & AWT
- **Database:** MySQL
- **Database Connectivity:** JDBC (Java Database Connectivity)
- **IDE:** IntelliJ IDEA / Eclipse / VS Code

---

## 📂 Project Structure
`	ext
Airline-Reservation-System/
├── src/
│   ├── Main.java               # Application entry point
│   └── ui/
│       └── LoginFrame.java     # Complete UI & business logic
├── database/
│   └── schema.sql              # MySQL database schema & sample data
├── docs/
│   └── SRS_Airline_Reservation_System.pdf # Full SRS documentation report
├── .gitignore
└── README.md
`

---

## ⚙️ How to Run the Project

### 1. Database Setup
1. Open **MySQL Workbench** or command line.
2. Execute the script in database/schema.sql:
   `sql
   source database/schema.sql;
   `

### 2. Compile and Run
1. Navigate to the src folder:
   `ash
   cd src
   javac -d ../bin Main.java ui/*.java
   `
2. Run the application:
   `ash
   java -cp ../bin Main
   `

---

## 📄 Documentation
Complete Software Requirement Specification (SRS) report is available in the [docs/](./docs/SRS_Airline_Reservation_System.pdf) directory.