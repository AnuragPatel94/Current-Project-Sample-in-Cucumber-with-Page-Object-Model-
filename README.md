Project Structure
src/test/java
 ├── runner
 │    └── TestRunner.java
 ├── stepdefinitions
 │    └── LeaveApplySteps.java
 ├── pages
 │    ├── LoginPage.java
 │    ├── DashboardPage.java
 │    └── LeaveApplyPage.java
 └── utils
      └── DriverFactory.java

src/test/resources/features
 └── LeaveApply.feature

Run For Maven cmd
mvn clean test -Dbase.uri=https://glbg.servergi.com:8072/SIMWEBGLB/Employee/Leave%20Apply

Project Explaination
“We implemented a Hybrid BDD framework using Cucumber + TestNG, where UI is automated using Page Object Model and Selenium, while APIs are validated using Rest Assured. Both UI and API validations run in the same scenario, ensuring true end-to-end testing.”
