Hello everybody, this README is for guide you to ricreate this project your own without downloading it.
This project was created by Dario Ferrarotti for learning the basicis of J2EE with some of his framework.
I'm going to describe now the main step I followed for help him to the build:

1 - First of all the build of the DataBase.
	The requirements of the FilmRental was in the main README file so see it ;)

2 - Build the Hibernate mapping and configuration with Eclipse ide.
	The intern need to do the configuration file and build the POJO class with the table mapping 
	annotation (use the annotation not the xml way). When it's done create a simple main class for call 
	all the DAO methods and print the data on the console for letting him to see all the work done 
	actually work well. Remember the @Override toString method on the model class, so him can easly call
	system.out.print(user); and the object stamp himself well. For the database connection, let the intern
	doing some research for the DataSource pattern and then create it on the TomCat. In this way it will be a
	clean nice project.

3 - Create the Spring layer for use all the data from the web, and build the true website.
	In this step the inter need to see the Spring configuration file and annotation, see where to put it 
	and create the jsp file and Spring controller so he can configure the TomCat server, run on it the project
	and use it.
	
	
For the packaging of the class use the standard Control - Business Logic - Model - DAO pattern.
In the Model create all the POJO class of the database mapping and in the DAO all the class you create
for access the DataBase: remebmer, all the DAO class need to return only a Model or basic 
class (string, int, boolean, ... nothing!). Remember the KISS rule ;)

In the Business Logic package put all the clas for the logic of the application, the BL class need to return 
behavior for the controller and use the class from the DAO layer.

In the Control simply put the flow of the website and the logic for invoking the BL.

Once the intern recreate this fully working project and understood the modules, try to implements new framework and 
new logic or requirements. Some excercise are implements in other branches of this Git project so if you want to follow
simply switch branch =) 

============================================================================================

The code is relased under GNU so happy editing and good luck! :)


Dario Ferrarotti
Federico Peruzzi
