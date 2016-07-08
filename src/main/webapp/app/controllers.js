(function(angular) {
  var GreetMessageController = function($scope, GreetMessageService) {
	  var greet = GreetMessageService.get(function() {
		   $scope.greet = greet;
		
    });
    
    $scope.addGreet = function(messageOfDay) {
     var newGreet =  new GreetMessageService({
        messageOfDay: messageOfDay
      }).$save(function(newGreet) {
        $scope.greet.messageOfDay = newGreet.messageOfDay;
      });
      $scope.newGreet = "";
    };
    
  };
  
  GreetMessageController.$inject = ['$scope', 'GreetMessageService'];
  angular.module("greetMessageApp.controllers").controller("GreetMessageController", GreetMessageController);
}(angular));