# Car Dealership

## Description

The Car Dealership app is a console-based application that facilitates the purchasing of cars. An employee can add cars to the lot and manage offers for those cars, while a customer can view the cars on the lot and make offers.

## Purpose

We want to see that you can meet deadlines and that you can code. You are expected to complete the following requirements and give a 5 minute presentation of your project to our QC team.

## Requirements
1. Functionality should reflect the below user stories.
2. Data is stored in a database.
3. A custom stored function is called to perform some portion of the functionality.
4. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
5. All input is received using the java.util.Scanner class.
6. Log4j is implemented to log events to a file.
7. A minimum of one (1) JUnit test is written to test some functionality.
8. You cannot use anything from java collections. All data structures must be self made.
9. Postgresql data base will be hosted using AWS RDS.


## User Stories

* As a user, I can login. ------------------------
* As an employee, I can add a car to the lot. ----------------------
* As a customer, I can view the cars on the lot. -------------------
* As a customer, I can make an offer for a car.------------------
* As an employee, I can accept or reject an offer for a car.-----------------
  
ADD TO USERCARS WHEN ACCEPTED

* As the system, I reject all other pending offers for a car when an offer is accepted.----------------
* As a user, I can register for a customer account.-------------
* As an employee, I can remove a car from the lot. ----------------------
  try and make remove by id
* As a customer, I can view the cars that I own. --------------------
* As a customer, I can view my remaining payments for a car.----
* As an employee, I can view all payments.
* As the system, I can calculate the monthly payment.----
* Add purchase option
clean up code
 make check offer , if no offers, no offer exists
  make payments
*TODO: make new table for payment/ then update car table.