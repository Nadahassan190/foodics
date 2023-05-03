# foodics
A. A. Scope - using Selenium WebDriver with Java
Introduction
This project aims to automate the testing of the Google search functionality using Selenium WebDriver with Java. The project follows the Page Object Model (POM) design pattern for better code maintainability and reusability.

Prerequisites
Java JDK 1.8 or higher installed on your system.
Maven installed on your system.
IntelliJ IDEA or any other Java IDE installed on your system.
Setup Instructions
Clone the repository to your local machine.
Open the project in your preferred IDE.
Ensure that all the dependencies are downloaded by running the following command in the terminal:
bash
Copy
mvn clean install
Update the chromedriver path in the DriverFactory.java class present in src/main/java/utils package.
Run the test cases using the following command in the terminal:
bash
Copy
mvn test
Test Case Scenarios
testSearchForKeyword() - This test case verifies that a user can search for a keyword on Google and the search results are displayed on the UI. It follows the below steps:
Navigate to https://www.google.com.
Search for the keyword "Test Automation".
Verify that the search results are displayed on the UI.
testSearchForNewKeyword() - This test case verifies that a user can search for a new keyword on Google and the search results are displayed on the UI. It follows the below steps:
Navigate to https://www.google.com.
Search for the keyword "Selenium WebDriver".
Verify that the search results are displayed on the UI.
Scroll down to the bottom of the page.
Click on the "Next" button to navigate to the next page.
Verify that the number of search results on the second page is equal to the number of search results on the third page.
Verify that different search suggestions are displayed at the end of the page.
testCloseBrowserWindow() - This test case verifies that a user can close the browser window after completing the search on Google. It follows the below steps:
Navigate to https://www.google.com.
Search for the keyword "Java Programming".
Verify that the search results are displayed on the UI.
Close the browser window.
Framework Structure
The project follows the Page Object Model (POM) design pattern. The project structure is as follows:

src/main/java/pages - Contains the page classes that define the WebElements and methods for each page.
src/main/java/utils - Contains utility classes like DriverFactory, ConfigReader, and Logger.
src/test/java/tests - Contains the test classes that define the test case scenarios.
src/test/resources - Contains the configuration files and test data.
Conclusion
In conclusion, this project provides a basic understanding of how to automate web testing using Selenium WebDriver with Java and the Page Object Model (POM) design pattern. The project also provides a clear understanding of how to write reusable and maintainable code using proper coding standards.
