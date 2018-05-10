angular.module('gremoNaElektrikoApp.StavkaCenovnikaService', [])
	.factory('StavkaCenovnikaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/stavkaCenovnika');
		}
		
		factory.createStavkaCenovnika = function(stavkaCenovnika , tipPrikljuckaId, cenovnikId) {
			return $http.post('/gremoNaElektriko/stavkaCenovnika'+'/'+tipPrikljuckaId+'/'+cenovnikId, stavkaCenovnika);
		}

		factory.deleteStavkaCenovnika = function(id) {
			return $http.delete('/gremoNaElektriko/stavkaCenovnika/'+id);
		}
		
		factory.updateStavkaCenovnika = function(stavkaCenovnika) {
			return $http.put('/gremoNaElektriko/stavkaCenovnika', stavkaCenovnika);
		}
		
		return factory;
	});