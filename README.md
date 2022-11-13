# REST API for Online Plant Nursery Management
- It is a REST API application for Online Plant Nursery where a user can perform various CRUD operations. 
- Developed by a Team of 5 members which is executed within 5 Days
## Tech Stack
<img align="left" src="https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.png" alt="drawing" width="100"/>
<img align="left"  src="https://download.logo.wine/logo/Spring_Framework/Spring_Framework-Logo.wine.png" alt="drawing" width="100"/>
<img src="https://download.logo.wine/logo/MySQL/MySQL-Logo.wine.png" alt="drawing" width="100"/>
<img align = "left" src="https://www.dariawan.com/media/images/tech-spring-boot.width-1024.png" alt="drawing" width="100"/>
<img align="left"  src="https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png" alt="drawing" width="100"/>
<img  align="left" src="https://miro.medium.com/max/818/1*zc-LgogGtr7fFHF9e1M8wA.png" alt="drawing" width="100"/>
<img src="https://maven.apache.org/images/maven-logo-white-on-black.purevec.svg" alt="drawing" width="100"/>
<img src="https://zooz.github.io/predator/images/restapi.png" alt="drawing" width="100"/>

## Modules
- Login, Logout Module
- Admin Module
- Order Module 
- Customer,Address Module
- Plants Module
- Planters Module
- Seeds Module
## Features
- User and Admin authentication & validation with session uuid.
### Admin Features:
* Administrator Role for the entire application
* Only  admins can add/update/delete plants, planters, seeds from main database
* Admin can access the details of different users and orders.
### User Features:
* Registering themselves with application, and logging in to get the valid session token
* Viewing list of available plants, planters, seeds and order items of them.
* Only logged in user can access his orders, profile updation and other features.
## Contributors
- [Manoj Gajare](https://github.com/manojgajare123)
- [Rohit Kumar](https://github.com/Rohit9252)
- [Sumit Bokshi](https://github.com/sumitbokshi)
- [Sudip Karmakar](https://github.com/sudip40)
- [Arun Prasad](https://github.com/arunprazad001)

## Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
 - Update the port number, username and password as per your local database configuration.
 - For current application we have used the below properties.
```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/springboot;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```




# ER DIAGRAM OF PLANT NURSERY MANAGEMENT APPLICATION


![ER Diagram of Plant Nursery Project](https://user-images.githubusercontent.com/101380040/193456250-c8fea983-dd1c-4888-a967-94ebfad02748.jpeg)
