# FilmRental
Hello everybody, this is the little project that was used to teach me about
the basics of an Enterprise Application and was realized in the context of an internship.
It is currently maintained by me and my mentor Federico Peruzzi.

Here you will find a simple example of the following technologies and frameworks:
- Spring Boot (MVC - Rest)
- Hibernate  (Persistance)
- MySQL  (DB)
- Tomcat dbcp (DataStore)
- AngularJs (Presentation MVC)

The project is the solution of an exercise that was given to me in the form of the
following requirements:

============================ MENTOR UPDATE ==================================

The project was refactor and review for a fast developer starter project. 
For now the requirements is the same but the architecture of the project is solid and stable.
Interns need now to complete the integration of the Hibernate mapping and start to develop the feature required 


=============================================================================

The project simulates a Video Rental service with users and admins.

Users can: 
- View the films that currently are rented
- View the films catalogue which includes all film that they currently can rent 
	(with the number of copies left) and rent one. 
- Propose a new title to the administrators
(*) Each user can at most own 3 films simultaneously

Admins can:
- View the current active rents
- Add a new film into the catalogue (specifying the number of copies)
- View the suggestion list and move one into the catalogue (specifying the number of copies)

A record of all the rents must be maintained in the DB: it has to include rental 
date and return date for each film.


This is released as an Eclipse project with Maven so all you have to do is import and compile
(and hope). 
For the database use the sample Database within the installation of MySql. The name of the 
database is Sakila, create the Admin username with root password

The code is relased under GNU so happy editing and good luck! :)


Dario Ferrarotti
Federico Peruzzi


