Hello everybody, this README is to guide you to ricreate the project on your own without downloading it.
This project was created by Dario Ferrarotti to learn the basicis of J2EE with some of his frameworks.
I'm going to describe now the main step I followed to help him do the build:

1 - First of all the build of the DataBase.
	The requirements of the FilmRental was in the main README file so see it ;)

2 - Build the Hibernate mapping and configuration with Eclipse ide.
	The intern needs to write the configuration file and build the POJO classes with the table mapping 
	annotations (use the annotations, not the xml way). When it's done create a simple main class to call 
	all the DAO methods and print the data on the console to let him see that all the work done 
	actually works well. Remember the @Override toString method on the model class, so he can easly call
	system.out.print(user) and the object stamp himself easily. For the database connection, let the intern
	do some research for the DataSource pattern and then create it on the TomCat server. In this way it will be a
	clean nice project.

3 - Create the Spring layer to retrive the data from the web, and build the true website.
	In this step the intern needs to see the Spring configuration file and annotation, see where to put it 
	and create the jsp file and Spring controller so he can configure the TomCat server, run the project on it
	and use it.
	
	
For the packaging of the class use the standard Control - Business Logic - Model - DAO pattern.
In the Model create all the POJO class of the database mapping and in the DAO all the class you create
for access the DataBase: remebmer, all the DAO class need to return only a Model or basic 
class (string, int, boolean, ... nothing!). Remember the KISS rule ;)

In the Business Logic package put all the classes for the logic of the application, the BL class needs to return the
behavior for the controller and use the class from the DAO layer.

In the Control simply put the flow of the website and the logic for invoking the BL.

Once the intern recreate this fully working project and understood the modules, try to implements new framework and 
new logic or requirements. Some excercise are implements in other branches of this Git project so if you want to follow
simply switch branch =) 

============================================================================================

The code is relased under GNU so happy editing and good luck! :)


Dario Ferrarotti
Federico Peruzzi
