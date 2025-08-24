# Banking System
BankingSystem

A simple Banking System web application built using Java Servlets, HTML, and Oracle Database.
This project demonstrates the core concepts of Servlets, JDBC, database triggers, and sequences in a banking context.

Features

🔑 Login Page – Users can log in using their email and password.

🗑 Delete Account – Users can delete their account from the database.

📄 Account Details Display – On successful login, user details are fetched from the database and displayed.

🔢 Auto-Increment ID with Sequence & Trigger – Oracle sequence (account_seq) along with a trigger (account_trigger) automatically assigns unique IDs when inserting a new account.

Technologies Used

Frontend: HTML, CSS (basic styling)

Backend: Java Servlets (Jakarta Servlet API)

Database: Oracle Database (JDBC, Sequence + Trigger for ID increment)

Server: Apache Tomcat

Database Setup
Create Table
CREATE TABLE accounts (
    id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    email VARCHAR2(100) UNIQUE,
    password VARCHAR2(100),
    mobile VARCHAR2(15),
    dob DATE,
    account_type VARCHAR2(20),
    created_at DATE DEFAULT SYSDATE
);

Create Sequence
CREATE SEQUENCE account_seq 
START WITH 1 
INCREMENT BY 1;

Create Trigger for Auto-Increment ID
CREATE OR REPLACE TRIGGER account_trigger
BEFORE INSERT ON accounts
FOR EACH ROW
BEGIN
   IF :NEW.id IS NULL THEN
      SELECT account_seq.NEXTVAL INTO :NEW.id FROM dual;
   END IF;
END;

Insert Sample Data
INSERT INTO accounts 
(first_name, last_name, email, password, mobile, dob, account_type) 
VALUES ('Vamsi', 'Andavarapu', 'test@gmail.com', '1234', '9876543210', DATE '2002-01-01', 'Savings');

How It Works

User opens the Login Page (login.html).

On login, request goes to LoginServlet which verifies credentials from the database.

If valid, user details are displayed.

Users can also delete their account using the DeleteAccount servlet.

When a new account is created, account_seq and account_trigger ensure that the id field is auto-generated.

Setup Instructions

Install Apache Tomcat (or any servlet container).

Configure Oracle JDBC connection in your servlet code.

Deploy the project on Tomcat (webapps folder).
