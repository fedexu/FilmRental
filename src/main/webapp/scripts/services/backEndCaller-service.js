/**
 * 	Angular Service that can be used from all the components of the AngularJs application.
 *	The service uses the injection $http that we use for calling the Back-end asynchronous.
 * 
 */
angular.module('filmRental').service('backEndCaller', function ($http) {
	
	//	Call of the Java service EcampleControllerMethod, the method return a promise to the caller.
	this.exampleControllerMethodCaller = function(parametri){
		return 	$http({
			  //	Type of the call.
			  method: 'POST',
			  //	URL of the call.
			  url: 'http://localhost:8080/FilmRental/example/method',
			  //	Payload of the call.
			  data: {}
			}).then(function successCallback(response) {
				return response.data.payload;
		  }, function errorCallback(response) {
			  console.log("errore di chiamata ExampleControllerMethodCaller");
			  //	Manage of the error returned from Back-end
		  });
	};
});
