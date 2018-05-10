angular.module('gremoNaElektrikoApp.CenovnikService', [])
	.factory('CenovnikService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/cenovnik');
		}
		
		factory.createCenovnik = function(cenovnik ) {
			return $http.post('/gremoNaElektriko/cenovnik', cenovnik);
		}

		factory.deleteCenovnik = function(id) {
			return $http.delete('/gremoNaElektriko/cenovnik/'+id);
		}
		
		factory.updateCenovnik = function(cenovnik) {
			return $http.put('/gremoNaElektriko/cenovnik', cenovnik);
		}
		
		return factory;
	});