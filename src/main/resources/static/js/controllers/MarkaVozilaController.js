angular.module('gremoNaElektrikoApp.MarkaVozilaController',[])
    .controller('MarkaVozilaController', function ($scope, MarkaVozilaService ) {
    
    	$scope.markaVozilaList = [];
    	$scope.sortType     = 'naziv';
    	$scope.sortReverse  = false;  
    
    	MarkaVozilaService.findAll()
    		.then(function successCallback(response) {
    			$scope.markaVozilaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})


    	$scope.openCreateModal = function() {
    		$scope.markaVozila = {};
    		$('#createMarkaVozilaModal').modal('toggle');
    	}
    		
    	$scope.createMarkaVozila = function() {

    	MarkaVozilaService.createMarkaVozila($scope.markaVozila )
    			.then(function successCallback(response) {
    				$scope.markaVozilaList.push(response.data);
    				 $('#createMarkaVozilaModal').modal('toggle');
    			})
    	}

    	$scope.deleteMarkaVozila = function(markaVozila) {
    		MarkaVozilaService.deleteMarkaVozila(markaVozila.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.markaVozilaList.indexOf(markaVozila);
    					$scope.markaVozilaList.splice(index, 1); 
    				}
    		})
    	}
    	
    	$scope.openUpdateModal = function(markaVozila) {
    		$scope.markaVozila = angular.copy(markaVozila);
    		$('#updateMarkaVozilaModal').modal('toggle');
    	}
    	
    	$scope.updateMarkaVozila = function() {
    		MarkaVozilaService.updateMarkaVozila($scope.markaVozila)
    			.then(function successCallback(response) {
    				$('#updateMarkaVozilaModal').modal('toggle');
    				MarkaVozilaService.findAll()
    					.then(function successCallback(response) {
    						$scope.markaVozilaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Greska");
    				})
    		})
    	}
    	
    	
    });