angular.module('gremoNaElektrikoApp.StanicaService', [])
	.factory('StanicaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/stanica');
		}
		
		factory.createStanica = function(stanica , gradId) {
			return $http.post('/gremoNaElektriko/stanica'+'/'+gradId, stanica);
		}

		factory.deleteStanica = function(id) {
			return $http.delete('/gremoNaElektriko/stanica/'+id);
		}
		
		factory.updateStanica = function(stanica) {
			return $http.put('/gremoNaElektriko/stanica', stanica);
		}
		
		return factory;
	});