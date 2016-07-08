(function(angular) {
	  angular.module("greetMessageApp.controllers", []);
	  angular.module("greetMessageApp.services", []);
	  angular.module("greetMessageApp", ["ngResource", "greetMessageApp.controllers", "greetMessageApp.services"]);
	}(angular));