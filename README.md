# Amazon Automation using Selenium and TestNG

This project contains automated test cases for Amazon website using Selenium WebDriver in Java.

## Tools Used

- Java
- Selenium WebDriver
- TestNG
- Maven

## Automated Scenarios

### Test Case 1
- Open Amazon India
- Search for iPhone
- Open product page
- Print device price in console
- Add the product to cart

### Test Case 2
- Open Amazon India
- Search for Galaxy
- Open product page
- Print device price in console
- Add the product to cart

## Parallel Execution

Both test cases are executed in parallel using TestNG through the `testng.xml` suite configuration.

## How to Run

Open terminal inside the project folder and run:

```bash
mvn test