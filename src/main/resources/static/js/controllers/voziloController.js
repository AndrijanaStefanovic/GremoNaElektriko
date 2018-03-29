angular.module('mbrsApp.VoziloController',[])
    .controller('VoziloController', function ($scope, VoziloService, KarticaService) {
    	
    	$scope.vozila = [];
    	$scope.kartice = [];
    	$scope.sortType     = 'registracioniBroj'; 
		$scope.sortReverse  = false;  
		$scope.searchKeyword = "";
    	
    	VoziloService.findAll()
    		.then(function successCallback(response) {
    			$scope.vozila = response.data;
    		}, function errorCallback(respose){
    			toastr.error("Greska");
    		})
    	
    	//ZOOM
    	KarticaService.findAll()
    		.then(function successCallback(response) {
    			$scope.kartice = response.data;
    		}, function errorCallback(respose){
    			toastr.error("Greska");
    		})
    		
    	$scope.openCreateModal = function() {
    		$scope.vozilo = {};
    		$scope.vozilo.kartica = {};
    		$('#createVoziloModal').modal('toggle');
    	}
    	
    	$scope.createVozilo = function() {
    		VoziloService.createVozilo($scope.vozilo, $scope.vozilo.kartica.id)
    			.then(function successCallback(response) {
    				$scope.vozila.push(response.data);
    				 $('#createVoziloModal').modal('toggle');
    			})
    	}
    	
    	$scope.deleteVozilo = function(vozilo) {
    		VoziloService.deleteVozilo(vozilo.id)
    			.then(function successCallback(response) {
    				var index = $scope.vozila.indexOf(vozilo);
    				$scope.vozila.splice(index, 1); 
    			}, function errorCallback(respose) {
    				toastr.error("Greska!");
    			})
  
    	}
    	
    	$scope.openUpdateModal = function(vozilo) {
    		$scope.vozilo = vozilo;
    		$('#updateVoziloModal').modal('toggle');
    	}
    	
    	$scope.updateVozilo = function() {
    		VoziloService.updateVozilo($scope.vozilo)
    			.then(function successCallback(response) {
    				$('#updateVoziloModal').modal('toggle');
    		})
    	}
    	
    	$scope.filterFunction = function(vozilo) {
    		if($scope.searchKeyword == "")
    			return true;
    		var check = vozilo.kartica.imeVlasnika.concat(" "+vozilo.kartica.prezimeVlasnika);
    		if(check.includes($scope.searchKeyword))
    	    {
    	       	return true; 
    	    }
    		return false;
    	};
    	
    });