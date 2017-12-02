/**
 * Controller dell'html helloWorld gestito dalla direttiva helloWorld-Directive
 * Definiamo come oggetto proprio del controller la variabile "hello" che verra mostrata poi a video
 * 
 */
angular.module('filmRental').controller('helloWorldController', function(backEndCaller) {
	
	//Salvo il riferimento al controller in una variabile standard "vm" che verra referenziata in tutti i pinti di questo oggetto.
	//NB: si utilizza questa pratica in quanto "this" è un riferimento all'oggetto che esegue l'istruzione in JS. 
	//	Chiaro esempio lo abbiamo alla riga 18 e 23. La variabile è la stessa ma se usassimo "this" all'interno della callback 
	//	della promise avremo che this punta alla funzione stessa di callback
	var vm = this;
	
	//variabile visualizzata in pagina
	vm.hello = "helloWorld";
	
	//variabile visualizzata in pagina, rivalorizzata al completamento della chiamata post
	vm.dataFromBackEnd = "";
	
	//chiamata POST al Back-end
	backEndCaller.exampleControllerMethodCaller().then(function(data){
		//risoluzione asincrona della promise ritornata dal servizio backEndCaller
		vm.dataFromBackEnd = data;
	});
	
});