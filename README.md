# Rest-Assured-Java-API-Automation
Demo of Rest Assured Java API Automation
API Automation Using Rest Assured & TestNG
This project provides a template for automating REST API testing across multiple environments using TestNG and the Rest Assured library.

Rest Assured Java API Automation CI

Prerequisites

     Java
     Maven
     TestNG
     IntelliJ Community edition
     extent reporter
     Rest Assured
     CI/CD GitHUB actions

The URL for APIs are given below
   https://restful-booker.herokuapp.com/apidoc/index.html
     
Project structure

.
¦   .gitignore
¦   LICENSE
¦   pom.xml
¦   README.md
¦   
+---.github
¦   +---workflows
¦           rest-assured-java-ci.yml
¦           
+---.idea
¦       .gitignore
¦       workspace.xml
¦       
+---logs
¦       log-2025-07-08-13-59-23.log
¦       
+---reports
¦   +---html-reports
¦           test_execution_results_2025-07-08 13-59-23.html
¦           
+---src
¦   +---main
¦   ¦   +---java
¦   ¦   ¦   +---com
¦   ¦   ¦       +---restassured
¦   ¦   ¦           +---example
¦   ¦   ¦               ¦   Category.java
¦   ¦   ¦               ¦   HttpMethod.java
¦   ¦   ¦               ¦   
¦   ¦   ¦               +---constant
¦   ¦   ¦               ¦       ApplicationConstant.java
¦   ¦   ¦               ¦       AuthenticationConstant.java
¦   ¦   ¦               ¦       CommonConstant.java
¦   ¦   ¦               ¦       ReporterConstant.java
¦   ¦   ¦               ¦       
¦   ¦   ¦               +---model
¦   ¦   ¦               ¦       AuthenticationRequest.java
¦   ¦   ¦               ¦       BookingDates.java
¦   ¦   ¦               ¦       BookingRequest.java
¦   ¦   ¦               ¦       
¦   ¦   ¦               +---service
¦   ¦   ¦               ¦   ¦   ExtentReportService.java
¦   ¦   ¦               ¦   ¦   
¦   ¦   ¦               ¦   +---app
¦   ¦   ¦               ¦           AuthenticationService.java
¦   ¦   ¦               ¦           BookingService.java
¦   ¦   ¦               ¦           
¦   ¦   ¦               +---util
¦   ¦   ¦                       AnnotationReader.java
¦   ¦   ¦                       FileReader.java
¦   ¦   ¦                       JsonFormatter.java
¦   ¦   ¦                       Log4jFilter.java
¦   ¦   ¦                       RestClient.java
¦   ¦   ¦                       TestListener.java
¦   ¦   ¦                       
¦   ¦   +---resources
¦   ¦           log4j2.xml
¦   ¦           test-reporter.properties
¦   ¦           
¦   +---test
¦       +---java
¦       ¦   +---com
¦       ¦       +---restassured
¦       ¦           +---example
¦       ¦               +---test
¦       ¦                   ¦   AuthTest.java
¦       ¦                   ¦   BaseTest.java
¦       ¦                   ¦   CreateBookingTest.java
¦       ¦                   ¦   DeleteBookingTest.java
¦       ¦                   ¦   GetAllBookingsTest.java
¦       ¦                   ¦   UpdateBookingTest.java
¦       ¦                   ¦   
¦       ¦                   +---constant
¦       ¦                           TestCategory.java
¦       ¦                           
¦       +---resources
¦           ¦   regression-suite.xml
¦           ¦   smoke-suite.xml
¦           ¦   
¦           +---env
¦                   dev.properties
¦                   pre-prod.properties
¦                   prod.properties
¦                   qa.properties
¦                   uat.properties
¦                   
+---target
    +---classes
    ¦   ¦   log4j2.xml
    ¦   ¦   test-reporter.properties
    ¦   ¦   
    ¦   +---com
    ¦       +---restassured
    ¦           +---example
    ¦               ¦   Category.class
    ¦               ¦   HttpMethod.class
    ¦               ¦   
    ¦               +---constant
    ¦               ¦       ApplicationConstant.class
    ¦               ¦       AuthenticationConstant.class
    ¦               ¦       CommonConstant.class
    ¦               ¦       ReporterConstant.class
    ¦               ¦       
    ¦               +---model
    ¦               ¦       AuthenticationRequest.class
    ¦               ¦       BookingDates.class
    ¦               ¦       BookingRequest.class
    ¦               ¦       
    ¦               +---service
    ¦               ¦   ¦   ExtentReportService.class
    ¦               ¦   ¦   
    ¦               ¦   +---app
    ¦               ¦           AuthenticationService.class
    ¦               ¦           BookingService.class
    ¦               ¦           
    ¦               +---util
    ¦                       AnnotationReader.class
    ¦                       FileReader.class
    ¦                       JsonFormatter.class
    ¦                       Log4jFilter.class
    ¦                       RestClient$1.class
    ¦                       RestClient.class
    ¦                       TestListener.class
    ¦                       
    +---generated-sources
    ¦   +---annotations
    +---generated-test-sources
    ¦   +---test-annotations
    +---maven-status
    ¦   +---maven-compiler-plugin
    ¦       +---compile
    ¦       ¦   +---default-compile
    ¦       ¦           createdFiles.lst
    ¦       ¦           inputFiles.lst
    ¦       ¦           
    ¦       +---testCompile
    ¦           +---default-testCompile
    ¦                   createdFiles.lst
    ¦                   inputFiles.lst
    ¦                   
    +---surefire-reports
    ¦   ¦   bullet_point.png
    ¦   ¦   collapseall.gif
    ¦   ¦   emailable-report.html
    ¦   ¦   failed.png
    ¦   ¦   index.html
    ¦   ¦   jquery-3.6.0.min.js
    ¦   ¦   navigator-bullet.png
    ¦   ¦   passed.png
    ¦   ¦   skipped.png
    ¦   ¦   TEST-TestSuite.xml
    ¦   ¦   testng-failed.xml
    ¦   ¦   testng-reports.css
    ¦   ¦   testng-reports.js
    ¦   ¦   testng-reports1.css
    ¦   ¦   testng-reports2.js
    ¦   ¦   testng-results.xml
    ¦   ¦   TestSuite.txt
    ¦   ¦   
    ¦   +---API Automation Demo Regression Test Suite
    ¦   ¦       Regression Test.html
    ¦   ¦       Regression Test.xml
    ¦   ¦       testng-failed.xml
    ¦   ¦       
    ¦   +---junitreports
    ¦           TEST-com.restassured.example.test.CreateBookingTest.xml
    ¦           TEST-com.restassured.example.test.DeleteBookingTest.xml
    ¦           TEST-com.restassured.example.test.UpdateBookingTest.xml
    ¦           
    +---test-classes
        ¦   regression-suite.xml
        ¦   smoke-suite.xml
        ¦   
        +---com
        ¦   +---restassured
        ¦       +---example
        ¦           +---test
        ¦               ¦   AuthTest.class
        ¦               ¦   BaseTest.class
        ¦               ¦   CreateBookingTest.class
        ¦               ¦   DeleteBookingTest.class
        ¦               ¦   GetAllBookingsTest.class
        ¦               ¦   UpdateBookingTest.class
        ¦               ¦   
        ¦               +---constant
        ¦                       TestCategory.class
        ¦                       
        +---env
                dev.properties
                pre-prod.properties
                prod.properties
                qa.properties
                uat.properties
                

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

How to check reports:-

  After running the mvn commands , you can see the reports under
  
        1) reports/html-reports
        
        2) target/surefire-reports/emailable-report.html
        
        3) target/surefire-reports/index.html
