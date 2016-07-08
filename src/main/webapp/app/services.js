(function(angular) {
  var GreetFactory = function($resource) {
    return $resource('/greet');
  };
  
  GreetFactory.$inject = ['$resource'];
  angular.module("greetMessageApp.services").factory("GreetMessageService", GreetFactory);
}(angular));