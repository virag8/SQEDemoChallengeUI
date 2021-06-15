## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: Ruslan_Kashapau@epam.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 1.   Book Valid Order with any quantity (>1), pizza type & toppings - verify order is successful by asserting cost, dialog
 2.   Book Order with quantity: 0/-ve/non-integer and other valid inputs and assert order should not be successful.
 3.   Form checks for mandatory parameters (one or many parameters)
 4.   Form formatting checks for parameters like email, phone (one or many parameters)   
 5.   Book Valid Order with max quantity (like >100k), pizza type & toppings - verify order is successful by asserting cost, dialog
 6.   Book Order with phone: non-integer and other valid inputs and assert order should not be successful.
 7.   Book Order with same toppings & other valid inputs and assert warning/order should not successful
 8.   Book Order with only all mandatory fields and without any optional fields, assert warning/order should not successful
 9.   Reset button should clear all fields
10.   Book Valid Re-Order with any quantity (>1), pizza type & toppings - verify order is successful by asserting cost, dialog closing
11.   Book pizza with 0/1/2 toppings and pizza types should be displayed based on the pizza toppings#count
12.   


#### Defects
 1.   Email, phone format is not mandatory
 2.   Payment type is not mandatory
 3.   Pizza with quantity 0/non-integer/-ve give order successful message
 4.   Pizza with high quantity (>100k) calculates wrong cost
 5.   Pizza type displayed without appropriate toppings
 6.   Same toppings allowed for the pizza type
 7.   

