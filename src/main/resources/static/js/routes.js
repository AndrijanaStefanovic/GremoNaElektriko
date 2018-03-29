var app = angular.module('mbrsApp.routes', ['ngRoute']);

app.config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/',{
            templateUrl : 'html/home.html'
        })
        
        .when('/kartica',{
            templateUrl : 'html/kartica.html'
        })
        
        .when('/vozilo',{
            templateUrl : 'html/vozilo.html'
        })
    
    	
    
}]);