angular.module('gremoNaElektrikoApp.GradService', [])
	.factory('GradService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/grad');
		}
		
		factory.createGrad = function(grad ) {
			return $http.post('/gremoNaElektriko/grad', grad);
		}

		factory.deleteGrad = function(id) {
			return $http.delete('/gremoNaElektriko/grad/'+id);
		}
		
		factory.updateGrad = function(grad) {
			return $http.put('/gremoNaElektriko/grad', grad);
		}
		
		return factory;
	});