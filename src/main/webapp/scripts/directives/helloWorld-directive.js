/**
 * 	Example directive where we are going to load the HTML file "helloWorld.html"
 * 	with the controller "helloWorld-controller.js" file associated trougth the angular name injection "helloWorldController".
 * 
 */
angular.module('filmRental').directive('helloWorld', function () {
	return {
		restrict: 'EA',
		scope: true,
		//	The HTML loaded by the defined directive. 
		templateUrl: '/FilmRental/views/helloWorld.html',
		link : function(scope, elm, $attrs) {
			//	we can add function in the link property of the directive
		    scope.$watch("esempio", function(newValue, oldValue) {
		    	/*
		    	 * 	Example watch linked into the directive.
		    	 * 	If we need to add a watch to the variable that are 
		    	 * 	above the directive and not inside it we need to define it here.
		    	 */
		    });
		 },
		//	Injection of the controller we decided to use inside this directive.
		controller: 'helloWorldController',
		/*
		 * 	Redefinition of the controller name. With this prefix we can use into the page (into the HTML managed from this directive)
		 *	the controller value witch means all the variable declared into the controller defined with "this".
		 */ 
		controllerAs: 'ctrl'
	  };
});