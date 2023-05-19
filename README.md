# HospitalManagement

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>
In order to simplify the management of patient and doctor data and appointments in a healthcare system, the Hospital Management API is a RESTful API. It offers endpoints for patient registration, authentication, scheduling appointments, and getting access to doctor information.
---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok

<br>

## Database Configuration
By adding the correct database URL, user name, and password to the application.properties file, you may connect to a MySQL database. It's time to update the following properties:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>

## Language Used
* Java

---
<br>

## Data Flow

1. Through the application's API endpoints, the user submits a request from the client side.
2. After receiving the request, the API routes it to the proper controller method.
3. The service class method is called by the controller function.
4. The controller class receives instructions from the method in the service class, which constructs logic and obtains or alters data from the database.
5. The controller method sends an API response.
6. The user receives the API's answer.

---

<br>

## API End Points 

The following endpoints are available in the API:
```
POST /patient/signup: Creates a new patient account.

POST /patient/signin: Authenticates a patient and generates an access token.

GET /patient/doctors: Retrieves a list of doctors available for appointments.

POST /doctor: Adds a new doctor to the system.

GET /doctor/{docId}/appointments: Retrieves appointments for a specific doctor.

POST /appointment: Creates a new appointment.
```

<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary
Using Spring Boot, Java, and MySQL, the hospital Management API was created as a RESTful API. It offers a complete answer for controlling appointments, patient and physician data, and more inside a healthcare system. Through the API, patients may register, log in, schedule appointments with available providers, and, if necessary, cancel appointments. A doctor's appointment schedule may be retrieved and entered to the system.



## Author

👤 **Nitesh Choudhary**

* GitHub: [Nitesh choudhary](https://github.com/nitesh1710)

* LinkedIn: [Nitesh choudhary](https://www.linkedin.com/in/niteshchoudhary17/)
    
---

## 🤝 Contributing

Contributions, issues and feature requests are welcome.
    
---
    
## Show your support

Give a ⭐️ if this project helped you!
    
---
    
## 📝 License

Copyright © 2023 [Nitesh Choudhary](https://github.com/nitesh1710).<br />
    
---
