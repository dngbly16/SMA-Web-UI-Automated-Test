# SMA-Web-UI-Automated-Test
## Overview
This repository contains a Selenium WebDriver testing project that demonstrates automated testing of a demo website.
The project utilizes Selenium WebDriver, Selenium Grid, TestNG, IntelliJ IDE, and JDK 11 to perform end-to-end automated testing of the website.

## Project Structure
The project structure is organized as follows:
- `src/main/java`: Contains the test code.
- `src/main/drivers`: Store the WebDriver executable files (e.g., ChromeDriver, GeckoDriver).
- `TestData.xlsx`: Contains test data files (e.g., Excel files, CSV files).
- `testng.xml`: TestNG configuration file.
- `TestCase`: Contains test cases description and will contains test results.
- `pom.xml`: Store any third-party libraries or dependencies.
- `README.md`: The project's README file.
## Using Page Object Model (POM) Design Pattern
This project follows the Page Object Model (POM) design pattern, which separates the page elements and their interactions into separate classes.
This promotes code reusability, maintainability, and easier test case development. Page object classes can be found in the `src/main/java` directory.
## Tools and Technologies
- **Selenium WebDriver**: Used for automating browser interactions.
- **Selenium Grid**: Enables running tests in parallel on different browsers and platforms.
- **TestNG**: A testing framework for structuring and running tests.
- **IntelliJ IDEA**: The integrated development environment used for developing and running the project.
- **JDK 11**: The Java Development Kit version used for project development.
## Testing on Multiple Browsers
The project supports testing on multiple browsers, including Chrome and Firefox. You can specify the browser type as a parameter when running tests using the `testng.xml` file.
