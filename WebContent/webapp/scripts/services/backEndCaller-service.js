/**
 * Servizio angular fruibile a tutte le componenti dell'app angular
 * Il servizio si occupa di gestire l'injection della componente $http che si utilizza per fare le chiamate a Back-end
 * 
 */
angular.module('filmRental').service('backEndCaller', function ($http) {
	
	//chiamata al servizio Java ExampleControllerMethod, promise ritornata al chiamante
	this.exampleControllerMethodCaller = function(parametri){
		return 	$http({
			  //tipo di chiamata
			  method: 'POST',
			  //URL di chiamata
			  url: 'http://localhost:8080/FilmRental/example/method',
			  //Payload di chiamata
			  data: {}
			}).then(function successCallback(response) {
				return response.data;
		  }, function errorCallback(response) {
			  console.log("errore di chiamata ExampleControllerMethodCaller");
		      //Implementare un eventuale gestione del caso di errore di chiamata
		  });
	};
});
