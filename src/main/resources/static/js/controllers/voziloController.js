angular.module('gremoNaElektrikoApp.VoziloController',[])
    .controller('VoziloController', function ($scope, VoziloService , KarticaService) {
    
    	$scope.voziloList = [];
    	$scope.karticaList = [];	
    	$scope.modelList = [];	
    	$scope.sortType     = 'registracioniBroj';
    	$scope.sortReverse  = false;  
    
    	VoziloService.findAll()
    		.then(function successCallback(response) {
    			$scope.voziloList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})

		KarticaService.findAll()
    		.then(function successCallback(response) {
    			$scope.karticaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})
    		


    	$scope.openCreateModal = function() {
    		$scope.vozilo = {};
    		$scope.vozilo.kartica = {}
    		$('#createVoziloModal').modal('toggle');
    	}
    		
    	$scope.createVozilo = function() {

    	VoziloService.createVozilo($scope.vozilo , $scope.vozilo.kartica.id)
    			.then(function successCallback(response) {
    				$scope.voziloList.push(response.data);
    				 $('#createVoziloModal').modal('toggle');
    			})
    	}

    	$scope.deleteVozilo = function(vozilo) {
    		VoziloService.deleteVozilo(vozilo.id)
    			.then(function successCallback(response) {
    				var index = $scope.voziloList.indexOf(vozilo);
    				$scope.voziloList.splice(index, 1); 
    		})
    	}
    	
    	$scope.openUpdateModal = function(vozilo) {
    		document.getElementById("updateSelectKartica").value = vozilo.kartica.id;
    		$scope.vozilo = angular.copy(vozilo);
    		$('#updateVoziloModal').modal('toggle');
    	}
    	
    	$scope.updateVozilo = function() {
    		$scope.vozilo.kartica.id = document.getElementById("updateSelectKartica").value;
    		VoziloService.updateVozilo($scope.vozilo)
    			.then(function successCallback(response) {
    				$('#updateVoziloModal').modal('toggle');
    				VoziloService.findAll()
    					.then(function successCallback(response) {
    						$scope.voziloList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Greska");
    				})
    		})
    	}
    	
    });