angular.module('gremoNaElektrikoApp.VoziloService', [])
	.factory('VoziloService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/vozilo');
		}
		
		factory.createVozilo = function(vozilo , modelVozilaId, karticaId) {
			return $http.post('/gremoNaElektriko/vozilo'+'/'+modelVozilaId+'/'+karticaId, vozilo);
		}

		factory.deleteVozilo = function(id) {
			return $http.delete('/gremoNaElektriko/vozilo/'+id);
		}
		
		factory.updateVozilo = function(vozilo) {
			return $http.put('/gremoNaElektriko/vozilo', vozilo);
		}
		
		return factory;
	});