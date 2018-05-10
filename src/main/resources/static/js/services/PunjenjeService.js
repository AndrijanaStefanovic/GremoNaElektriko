angular.module('gremoNaElektrikoApp.PunjenjeService', [])
	.factory('PunjenjeService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/punjenje');
		}
		
		factory.createPunjenje = function(punjenje , voziloId, tipPrikljuckaId, stanicaId) {
			return $http.post('/gremoNaElektriko/punjenje'+'/'+voziloId+'/'+tipPrikljuckaId+'/'+stanicaId, punjenje);
		}

		factory.deletePunjenje = function(id) {
			return $http.delete('/gremoNaElektriko/punjenje/'+id);
		}
		
		factory.updatePunjenje = function(punjenje) {
			return $http.put('/gremoNaElektriko/punjenje', punjenje);
		}
		
		return factory;
	});