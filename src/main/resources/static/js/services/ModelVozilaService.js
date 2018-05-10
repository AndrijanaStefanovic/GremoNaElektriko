angular.module('gremoNaElektrikoApp.ModelVozilaService', [])
	.factory('ModelVozilaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/modelVozila');
		}
		
		factory.createModelVozila = function(modelVozila , tipPrikljuckaId, markaVozilaId) {
			return $http.post('/gremoNaElektriko/modelVozila'+'/'+tipPrikljuckaId+'/'+markaVozilaId, modelVozila);
		}

		factory.deleteModelVozila = function(id) {
			return $http.delete('/gremoNaElektriko/modelVozila/'+id);
		}
		
		factory.updateModelVozila = function(modelVozila) {
			return $http.put('/gremoNaElektriko/modelVozila', modelVozila);
		}
		
		return factory;
	});