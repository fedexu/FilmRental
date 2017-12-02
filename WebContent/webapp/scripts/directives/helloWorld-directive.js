/**
 * Directive di esempio con cui andiamo a caricare il file HTML "helloWorld.html" 
 * associando come controller il file "helloWorld-controller.js" tramite il nome definito in angular "helloWorldController"
 * 
 */
angular.module('filmRental').directive('helloWorld', function () {
	return {
		restrict: 'EA',
		scope: true,
		//html che verra chiamato dalla direttiva appena definita
		templateUrl: '/FilmRental/webapp/views/helloWorld.html',
		link : function(scope, elm, $attrs) {
			//possibilita di inserire piu funzioni.
		    scope.$watch("esempio", function(newValue, oldValue) {
		    	//un watch linkato nella direttiva. 
		    	//Esempio se dovesse servire un controllo continuativo su variabili 
		    	//che stanno sopra la direttiva e non all'interno
		    });
		 },
		//collegamento al file di Controller che si decide di usare all'interno di una directive
		controller: 'helloWorldController',
		//ridenominazione del controller. Con questo prefisso si possono vedere in pagina (negli html gestiti dalla direttiva)
		//i valori propri dell'oggetto controller, quindi tutte le variabili all'interno del controller chiamate con "this."
		controllerAs: 'ctrl'
	  };
});