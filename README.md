Selenium Automation Framework
 Project Overview:
This project is a Selenium WebDriver automation framework developed using Java, TestNG, Maven, and Page Object Model (POM).
The framework is designed to automate functional test cases for a CRM application and provides reusable utilities for browser handling, test data, reporting, and common Selenium operations.
 Technologies Used:
Java
Selenium WebDriver
TestNG
Maven
Page Object Model (POM)
Apache POI
Extent Reports
Git & GitHub
Eclipse IDE
 Framework Structure
Automation-framework
│
├── src/main/java
│ ├── baseClass
│ ├── generic_utility
│ ├── object_repository
│ └── ...
│
├── src/test/java
│ ├── crm.activity
│ ├── crm.campaign
│ ├── crm.cases
│ ├── crm.contact
│ ├── crm.lead
│ ├── crm.login
│ ├── crm.opportunity
│ ├── crm.organization
│ └── crm.product
│
├── src/main/resources
├── pom.xml
└── testng.xml
✨ Key Features
Browser initialization and management
Page Object Model implementation
Reusable Selenium utilities
Explicit/implicit wait handling
Alert handling
Window handling
Frame handling
Dropdown handling using Selenium Select
Excel-based test data using Apache POI
Random test data generation
TestNG annotations and execution
TestNG listeners
Extent Reports
Maven dependency management
* Test Scenarios
The framework contains automation scenarios for modules such as:
Login
Organizations
Opportunities
Leads
Contacts
Products
Vendors
Campaigns
▶️ How to Run
Using Eclipse
Import the project into Eclipse.
Update Maven dependencies.
Configure the required test data.
Right-click the required TestNG class.
Select Run As → TestNG Test.
Using Maven
mvn clean test
* Reporting
Test execution results are generated using the configured reporting/listener implementation.
👩‍💻 Author
Nisha Bano
GitHub: nishakumar-jpk
