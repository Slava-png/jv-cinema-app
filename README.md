# 🎥Cinema Project🎥
## Project description:
This project imitates the work of a cinema service. The project has been built on the REST-principles. It supports reservation tickets, registration, authentication and CRUD operations.
## 🚀Features
- Role based authorization
- Find user by email (only for ADMIN)
- Create a cinema hall (only for ADMIN)
- Create a movie (only for ADMIN)
- Create, update and delete movie sessions (only for ADMIN)
- Find available movie sessions
- Add movie session to a shopping cart (only for USER)
- Get shopping cart for a current user (only for USER)
- Complete order (buy tickets from shopping cart) (only for USER)
- Get orders history (only for USER)
## 📂Structure
* `config` - contains all configurations for Spring and Hibernate
* `controller` - contains endpoints
* `dao` - communication with DB
* `dto` - used for http request/response 
* `exception` - custom exceptions
* `lib` - custom validators for email and password
* `model` - models for entities in DB
* `security` - responsible for UserDetails
* `service` - contains business logic and connects controller with dao
* `service/mapper` - contains mappers for dtos
* `util` - contains patterns required for parsing json data
## 🔧Endpoints
* POST: `/register` (all) - register new user;
* GET:  `/cinema-halls` (user/admin) - get a list of all cinema halls;
* POST: `/cinema-halls` (admin) - add a new cinema hall;
* GET:  `/movies` (user/admin) - get a list of all movies;
* POST: `/movies` (admin) - add a new movie;
* GET:  `/movie-sessions/available` (user/admin) - get available movie sessions by date;
* PUT:  `/movie-sessions/{id}` (admin/root) - update movie session;
* POST: `/movie-sessions` (admin) - add a new movie session;
* DELETE: `/movie-sessions/{id}` (admin/root) - delete movie session.
* POST: `/orders/complete` (user) - create a new order for current user;
* GET: `/orders` (user) - get a list of orders for current user;
* PUT: `/shopping-carts/movie-sessions` (user) - creates a ticket and adds it to the shopping cart of current user;
* GET: `/shopping-carts/by-user` (user) - get shopping cart of current user;
* GET: `/users/by-email (admin)` - find user by email;
## ⚙️Used technologies and libraries:
* JDK 17;
* Spring 5.3.20;
* Spring Security 5.6.10;
* Hibernate 5.6.14.Final;
* MySQL 8.0.22;
* HQL
* Tomcat 9.0.73;
* Maven 3.1.1;
## 🔨Steps how to run:
- make sure you have JDK 17 installed on your system;
- make sure you have Tomcat and MySQL installed on your system;
- clone this repository;
- open this project (you can do this using Intellij IDEA or another development environment);
- configure the database connection parameters in the resources/db.properties file;
- configure a local Tomcat configuration in your IDE;
- run the Tomcat configuration and deploy the application;






