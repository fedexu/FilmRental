# FilmRental
Hello everybody, this is the little project that was used to teach me about
the basics of an Enterprise Application and was realized in the context of an internship.
It is currently maintained by me and my mentor Federico Peruzzi.

Here you will find a simple example of the following technologies and frameworks:
- Spring 4.3.3 (MVC)
- Hibernate 4.3.5 (Persistance)
- MySQL 5.1.3 (DB)
- Tomcat dbcp 7.0.55(DataStore)

The project is the solution of an exercise that was given to me in the form of the
following requirements:

============================================================================================
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

(ADDITION) A record of all the rents must be maintained in the DB: it has to include rental 
date and return date for each film.

============================================================================================

This is released as an Eclipse project with Maven so all you have to do is import and compile
(and hope). 
There is also a simple script to help you populate the DB which shall be named "videorental"
and have username "root" password "1234" to be executed immediately.

The code is relased under GNU so happy editing and good luck! :)


Dario Ferrarotti
Federico Peruzzi
