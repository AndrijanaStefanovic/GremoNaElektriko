angular.module('gremoNaElektrikoApp.TipPrikljuckaController',[])
    .controller('TipPrikljuckaController', function ($scope, TipPrikljuckaService ) {
    
    	$scope.tipPrikljuckaList = [];
    	$scope.sortType     = 'naziv';
    	$scope.sortReverse  = false;  
    
    	TipPrikljuckaService.findAll()
    		.then(function successCallback(response) {
    			$scope.tipPrikljuckaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})


    	$scope.openCreateModal = function() {
    		$scope.tipPrikljucka = {};
    		$('#createTipPrikljuckaModal').modal('toggle');
    	}
    		
    	$scope.createTipPrikljucka = function() {

    	TipPrikljuckaService.createTipPrikljucka($scope.tipPrikljucka )
    			.then(function successCallback(response) {
    				$scope.tipPrikljuckaList.push(response.data);
    				 $('#createTipPrikljuckaModal').modal('toggle');
    			})
    	}

    	$scope.deleteTipPrikljucka = function(tipPrikljucka) {
    		TipPrikljuckaService.deleteTipPrikljucka(tipPrikljucka.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.tipPrikljuckaList.indexOf(tipPrikljucka);
    					$scope.tipPrikljuckaList.splice(index, 1); 
    				}
    		})
    	}
    	
    	$scope.openUpdateModal = function(tipPrikljucka) {
    		$scope.tipPrikljucka = angular.copy(tipPrikljucka);
    		$('#updateTipPrikljuckaModal').modal('toggle');
    	}
    	
    	$scope.updateTipPrikljucka = function() {
    		TipPrikljuckaService.updateTipPrikljucka($scope.tipPrikljucka)
    			.then(function successCallback(response) {
    				$('#updateTipPrikljuckaModal').modal('toggle');
    				TipPrikljuckaService.findAll()
    					.then(function successCallback(response) {
    						$scope.tipPrikljuckaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Greska");
    				})
    		})
    	}
    	
    	
    });