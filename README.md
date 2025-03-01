# mortgage-management
Mortgage Eligibility Management System


This project can be executed in Swagger-UI / Postman to run the implemented REST APIs.

H2 Database is used to store the data and perform the CRUD operations.
This project is implemented with below 3 endpoints:

Create MortgageRate: api/add/interest-rates
Get MortgageRates : api/interest-rates
Check Mortgage Eligibility Check : api/mortgage-check


Execution of Project:

Maven import and run the Project in local IDE with Maven Clean,  Maven Install and then as SpringBoot Application.
Navigate to any Browser and login to the H2 Database with JDBC URL same as in the application.properties: jdbc:h2:mem:testdb. Test and Connect it.
URL: http://localhost:8080/h2-console

Once, you navigate to the Database, you can view the table that we have created through our Microservice: MORTGAGE_RATE.
Execute the Select Query using the RUN command above.

Now, in another tab navigate to the Swagger UI:  http://localhost:8080/swagger-ui/index.html
We can Test our APIs here as below steps:

Step1: Add the objects into MORTGAGE_RATE table using the POST API: api/add/interest-rates

Step2 : After adding the Data in above API, we can get the details of available Mortgage Rates through GET API : api/interest-rates
Here, I have written and commented a code in MortgageService.getInterestRates. which can written the List<Long> only Interest rates available.

Step3: We can check the Mortgage Eligibility condition in the POST API: api/mortgage-check with the conditions such as Mortgage Value should not exceed 4times the income and home value.
