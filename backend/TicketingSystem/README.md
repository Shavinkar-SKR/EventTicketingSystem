# TicketingSystems

1. INTRODUCTION

This system is intended to mimic an event management ticketing environment in real time. Ticket release (by vendors) and ticket purchase (by clients) are examples of concurrent processes that are handled by the Producer-Consumer paradigm. The objective is to use multi-threading and the concepts of object-oriented programming (OOP) to guarantee data integrity and seamless concurrency handling.


2. SETUP INSTRUCTIONS

2.1 Prerequisites:
Before running the application, ensure you have the following installed:

    Java: Version 22.0.1 or higher.
    Node.js: Version 20.16.0 or higher.
    Angular: Version 19.0.4
    IDE: Intellij IDEA, Eclipse, or Visual Studio Code.
    Maven or Gradle for Java projects.
    Angular CLI: if using a web based frontend.
    GSON for configuration management.

2.2 How to Build and Run the Application
Backend(SpringBoot)

    2.2.1 Navigate to the backend directoy
    "cd path-to-your-backend-project".
    2.2.2 Build the project
    "mvn clean install".
    2.2.3 Run the Spring Boot Application
    "mvn spring-boot:run".
    The backend server will start at:
    "http://localhost:8080"

Frontend (Angular)

    2.2.4 Navigate to the Frontend Directory:
    "cd path-to-your-angular-project".
    2.2.5 Install Dependencies:
    "npm install".
    2.2.6 Run the Angular Development Server:
    "ng serve".
    The frontend will be accessible at:
    "http://localhost:4200"


3. USAGE INSTRUCTIONS

How to Configure and Start the System

3.1 Open the application in your browser at:
http://localhost:4200

3.2 Configure the System:

Input values into the 7 configuration fields:
Total Tickets,
Ticket Release Rate,
Customer Retrieval Rate,
Maximum Ticket Capacity,
Number of Customers,
Number of Vendors,
Maximum ticket quantity by each customer

Ensure all input fields are filled with valid data before proceeding.

3.3 Start the System:

Click the Start button to initialize the ticketing system.
The backend will process ticket releases and purchases based on the input configuration.

3.4 Stop the System:

Click the Stop button to halt operations.
Logs and system status will be preserved if implemented.

4. EXPLANATION OF UI CCONTROLS

4.1 Start Button:

Initializes the system with the configuration parameters entered in the input fields.
Starts ticketing operations in real-time.

4.2 Stop Button:

Halts ticketing operations.
Preserves system state for review (if implemented)

4.3 Input Fields:

Total Tickets: Total number of tickets available.

Ticket Release Rate: Number of tickets released per unit time.

Customer Retrieval Rate: Number of tickets customers attempt to retrieve per unit time.

Maximum Ticket Capacity: Maximum tickets a customer can hold or a pool can manage.

Number of Customers: Number of customers participating to buy tickets.

Number of Vendors: Number of vendors participating to release tickets.

Maximum ticket quantity by each customer: Number of tickets each customer can buy.
