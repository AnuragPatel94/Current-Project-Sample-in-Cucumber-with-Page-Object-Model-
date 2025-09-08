Project Structure
src
 └── test
     ├── java
     │    ├── runner
     │    │    └── TestRunner.java
     │    ├── stepdefinitions
     │    │    └── LeaveApplySteps.java
     │    ├── pages
     │    │    └── LoginPage.java
     │    └── utils
     │         └── DriverFactory.java
     └── resources
          └── features
               └── LeaveApply.feature


  “I implemented a Hybrid BDD framework using Cucumber + TestNG. 
  The UI part is handled via Page Object Model (LoginPage), and the API part is validated using Rest Assured. 
  The feature file defines scenarios in Gherkin, making it easy for non-technical stakeholders to understand. 
  Step definitions call both Selenium and API validations, while the Driver Factory manages WebDriver lifecycle. 
  This ensures end-to-end hybrid testing with clean architecture.”             
