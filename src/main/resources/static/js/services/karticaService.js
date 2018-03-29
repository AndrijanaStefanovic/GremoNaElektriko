angular.module('mbrsApp.KarticaService', [])
	.factory('KarticaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/mbrs/kartica');
		}
		
		factory.createKartica = function(kartica) {
			return $http.post('/mbrs/kartica', kartica);
		}
		
		factory.deleteKartica = function(id) {
			return $http.delete('/mbrs/kartica/'+id);
		}
		
		factory.updateKartica = function(kartica) {
			return $http.put('/mbrs/kartica', kartica);
		}
		
		return factory;
	});