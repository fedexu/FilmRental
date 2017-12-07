/**
 * 	HelloWorld.html controller handled from the helloWorld-directive.
 * 	We define as controller's property the variable "hello" that would be display in the page. 
 * 
 * 
 */
angular.module('filmRental').controller('helloWorldController', function(backEndCaller) {

	/*
	 *	We save here the reference to the controller into a variable "vm" that will be used across the 
	 *	controller to be a reference to itself.
	 *	NB: we use this variable because the keyword "this" is a reference for the object that is 
	 *	executed where the this keyword is used. Example is the line 18 and 23. 
	 *	The variable is the same but if we are going to use "this" inside the promise callback function we have a reference 
	 *	to the function itself instead a reference of the controller.
	 * 
	 */
	var vm = this;
	
	//	variable that we are going to display into the page
	vm.hello = "helloWorld";
	
	//	variable displayed into page, at the end of the POST call the value will change.
	vm.dataFromBackEnd = "";
	
	//	POST call to Back-end
	backEndCaller.exampleControllerMethodCaller().then(function(data){
		//	Asynchronous resolve function of the promise. "data" value was the return of the Back-end call. 
		//	The call is handled by the service backEndCaller.
		vm.dataFromBackEnd = data;
	});
	
});