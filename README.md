# FilmRental  by L.T

Hello everybody, I'm pretty new on IT Development, and this is my first project using a few 
different Java technologies for realize a simple Web Application.
It is currently maintained by me and my mentor Federico Peruzzi, during an internship's 
experience.

============================================================================================

On a functional point of view, this project inherits required guidelines written by Dario 
Ferrarotti, presented in the 'master' branch and reported below:

The project simulates a Video Rental service with users and admins.

Users can: 
- View the films that currently are rented
- View the films catalogue which includes all film that they currently can rent 
	(with the number of copies left) and rent one. 
- Propose a new title to the administrators.
- Return a copy rented.

Admins can:
- View all films currently in catalogue and the number of copies available for Users
- View the current active rents
- Add a new film into the catalogue (specifying the number of copies)
- View the suggestion list and move one into the catalogue (specifying the number of copies)


Technologies and frameworks used in this project version (branch dev_lt_jdbc):
- Apache Tomcat v.8.0.39(Container Server)
- Oracle JDBC API v.11.2.0.3 (Persistance)
- Oracle DB v.11g (DB)

============================================================================================

FIRST UPDATE : (DATABASE MANAGEMENT SYSTEM - ORACLE DBMS and JDBC API)
In the first version of this project (don't published on this Repository), we used to emulate
the storage and persistence of data informations using a few csv files, handled by some 
DAO and business logic's classes.
Instead of using different csv files, we introduce Oracle DBMS. Here we define a new DB_SCHEMA
and we created some Stored Procedures who will be called by JDBC API on the App.

============================================================================================

This is released as an Eclipse project WITHOUT Maven.
Maven will be used since the branch named dev_lt_spring_mvc.

The code is relased under GNU so happy editing and good luck! :)

Laura Tendola
Federico Peruzzi