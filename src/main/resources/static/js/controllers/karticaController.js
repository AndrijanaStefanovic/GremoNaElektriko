angular.module('mbrsApp.KarticaController',[])
    .controller('KarticaController', function ($scope, KarticaService) {
    
    	$scope.karticaList = [];
    	$scope.sortType     = 'imeVlasnika';  
		$scope.sortReverse  = false;  
    	
    	KarticaService.findAll()
    		.then(function successCallback(response) {
    			$scope.karticaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})

    	$scope.openCreateModal = function() {
    		$scope.kartica = {};
    		$('#createKarticaModal').modal('toggle');
    	}
    		
    	$scope.createKartica = function() {
    		KarticaService.createKartica($scope.kartica)
    			.then(function successCallback(response) {
    				$scope.karticaList.push(response.data);
    				 $('#createKarticaModal').modal('toggle');
    			})
    	}

    	$scope.deleteKartica = function(kartica) {
    		KarticaService.deleteKartica(kartica.id)
    			.then(function successCallback(response) {
    				var index = $scope.karticaList.indexOf(kartica);
    				$scope.karticaList.splice(index, 1); 
    		})
    	}
    	
    	$scope.openUpdateModal = function(kartica) {
    		$scope.kartica = kartica;
    		$('#updateKarticaModal').modal('toggle');
    	}
    	
    	$scope.updateKartica = function() {
    		KarticaService.updateKartica($scope.kartica)
    			.then(function successCallback(response) {
    				$('#updateKarticaModal').modal('toggle');
    		})
    	}
    	
    });