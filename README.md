# Basic CRUD Application using Spring Boot & Angular

## Setup
___
#### 1. MySQL Database Setup
Firstly, you need to access the Mysql console.
```bash
$ mysql -u root -p  
```
then create a user `spring` on your local machine and create a database `spring_users` then and grant privliges to that user on that database.
```sql
mysql> create user 'spring'@'localhost' identified by 'bboz12112';
mysql> create database spring_users;
mysql> grant all on spring_users.* to 'spring'@'localhost';
```
then source the mock data file.
```sql
mysql> source ./server/src/main/resources/users.sql;
```
**Any changes in the above script (database name, user, password) should be refelected in `application.properties` file**
#### 2. Start Application
Start the server with this default Spring Boot command.
```bash
$ cd server && ./mvnw spring-boot:run
```
for the client change directories and run the dev server.
```bash
$ cd client && yarn start
```
**Make sure to run `yarn install` in the client root directory.**

