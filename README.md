# Rest-Assured-Java-API-Automation
Demo of Rest Assured Java API Automation
API Automation Using Rest Assured & TestNG
This project provides a template for automating REST API testing across multiple environments using TestNG and the Rest Assured library.

Rest Assured Java API Automation CI

Prerequisites
Java
Maven
IntelliJ Community edition
Project structure
.github/                                              # GitHub workflow configurations
logs/                                                 # Log4j log files
reports/                                              # Extent HTML report files
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── restassured/
│   │           └── example/
│   │               ├── Category.java
│   │               ├── HttpMethod.java
│   │               ├── constant/                     # Project related constants including Application and Reporter contants
│   │               │   ├── ApplicationConstant.java
│   │               │   ├── AuthenticationConstant.java
│   │               │   ├── CommonConstant.java
│   │               │   └── ReporterConstant.java
│   │               ├── model/                        # Model classes which represents the request JSON payload
│   │               │   ├── AuthenticationRequest.java
│   │               │   ├── BookingDates.java
│   │               │   ├── BookingRequest.java
│   │               ├── service/
│   │               │   ├── ExtentReportService.java  # Extent report setup services
│   │               │   └── app/                      # Application service classes
│   │               │       ├── AuthenticationService.java
│   │               │       └── BookingService.java
│   │               └── util/                         # Utility methods
│   │                   ├── AnnotationReader.java
│   │                   └── FileReader.java
│   │                   └── JsonFormatter.java
│   │                   └── Log4jFilter.java
│   │                   └── RestClient.java
│   │                   └── TestListener.java
│   └── resources/                                    # Resource files for logging and reporting
│       ├── log4j2.xml
│       └── test-reporter.properties
├── test/
│   ├── java/
│   │   └── com/
│   │       └── restassured/
│   │           └── example/
│   │               └── test/
│   │                   ├── constant/                     # Test constants
│   │                   │   └── TestCategory.java
│   │                   ├── AuthTest.java                 # Authentication tests
│   │                   ├── BaseTest.java                 # Base test class setup
│   │                   ├── CreateBookingTest.java        # API test for creating a booking
│   │                   ├── DeleteBookingTest.java        # API test for deleting a booking
│   │                   ├── GetAllBookingsTest.java       # API test for fetching all bookings
│   │                   └── UpdateBookingTest.java        # API test for updating a booking
│   └── resources/
│       └── env/                                          # Environment configurations
│           ├── dev.properties
│           ├── pre-prod.properties
│           ├── prod.properties
│           ├── qa.properties
│           └── uat.properties
│       └── regression-suite.xml                          # TestNG regression test suite configuration
│       └── smoke-suite.xml                               # TestNG smoke test suite configuration
target/                                                   # Compiled code and build artifacts are stored here
.gitignore                                                # Specifies files and directories to be ignored by Git
LICENSE                                                   # License information for the project
pom.xml                                                   # Maven configuration file for dependencies and build settings
README.md                                                 # Repository overview and instructions (This file)

How to run tests

Using IntelliJ Community Edition

Go to Maven Profiles

Select dev, qa, uat, pre-prod or prod Maven Profile as the environment

Select the test classes on the src/test/java folder

Right-click and click on Run

Using Command Line

To run the smoke test suite against the UAT environment

mvn clean test -Puat,smoke-test

To run the regression test suite against the QA environment

mvn clean test -Pqa,regression-test

Note: By default, if no Maven profiles are selected, the tests will be executed on the dev environment.
