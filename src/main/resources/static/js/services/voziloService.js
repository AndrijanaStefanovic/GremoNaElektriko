angular.module('mbrsApp.VoziloService', [])
	.factory('VoziloService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/mbrs/vozilo');
		}

		factory.createVozilo = function(vozilo, karticaId) {
			return $http.post('/mbrs/vozilo/'+karticaId, vozilo);
		}
		
		factory.deleteVozilo = function(id) {
			return $http.delete('/mbrs/vozilo/'+id);
		}
		
		factory.updateVozilo = function(vozilo) {
			return $http.put('/mbrs/vozilo', vozilo);
		}
		
		return factory;
	});