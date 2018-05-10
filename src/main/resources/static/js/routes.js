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
        
        .when('/radnoVreme',{
            templateUrl : 'html/RadnoVreme.html'
        })
        
        .when('/stavkaCenovnika',{
            templateUrl : 'html/StavkaCenovnika.html'
        })
        
        .when('/modelVozila',{
            templateUrl : 'html/ModelVozila.html'
        })
        
        .when('/cenovnik',{
            templateUrl : 'html/Cenovnik.html'
        })
        
        .when('/markaVozila',{
            templateUrl : 'html/MarkaVozila.html'
        })
        
        .when('/punjenje',{
            templateUrl : 'html/Punjenje.html'
        })
        
        .when('/grad',{
            templateUrl : 'html/Grad.html'
        })
        
        .when('/stanica',{
            templateUrl : 'html/Stanica.html'
        })
        
        .when('/tipPrikljucka',{
            templateUrl : 'html/TipPrikljucka.html'
        })
        
      
}]);