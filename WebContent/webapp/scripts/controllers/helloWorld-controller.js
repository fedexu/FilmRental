/**
 * Controller dell'html helloWorld gestito dalla direttiva helloWorld-Directive
 * Definiamo come oggetto proprio del controller la variabile "hello" che verra mostrata poi a video
 * 
 */
angular.module('filmRental').controller('helloWorldController', function(backEndCaller) {
	
	//variabile visualizzata in pagina
	this.hello = "helloWorld";
	
	//variabile visualizzata in pagina, rivalorizzata al completamento della chiamata post
	this.dataFromBackEnd = "";
	
	//chiamata POST al Back-end
	backEndCaller.exampleControllerMethodCaller().then(function(data){
		//risoluzione asincrona della promise ritornata dal servizio backEndCaller
		this.dataFromBackEnd = data;
	});
	
});