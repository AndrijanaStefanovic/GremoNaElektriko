var app = angular.module('gremoNaElektrikoApp.routes', ['ngRoute']);

app.config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/',{
            templateUrl : 'html/home.html'
        })
        
        .when('/vozilo',{
            templateUrl : 'html/Vozilo.html'
        })
        
        .when('/kartica',{
            templateUrl : 'html/Kartica.html'
        })
                
      
}]);