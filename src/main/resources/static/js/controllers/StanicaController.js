angular.module('gremoNaElektrikoApp.StanicaController',[])
    .controller('StanicaController', function ($scope, StanicaService , GradService ) {
    
    	$scope.stanicaList = [];
    	$scope.gradList = [];	
    	$scope.sortType     = 'adresa';
    	$scope.sortReverse  = false;  
    	$scope.searchKeyword = "";
    
    	StanicaService.findAll()
    		.then(function successCallback(response) {
    			$scope.stanicaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})

		GradService.findAll()
    		.then(function successCallback(response) {
    			$scope.gradList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})
    		

    	$scope.openCreateModal = function() {
    		$scope.stanica = {};
    		$scope.stanica.grad = {};
    		$('#createStanicaModal').modal('toggle');
    	}
    		
    	$scope.createStanica = function() {

    	StanicaService.createStanica($scope.stanica , $scope.stanica.grad.id )
    			.then(function successCallback(response) {
    				$scope.stanicaList.push(response.data);
    				 $('#createStanicaModal').modal('toggle');
    			})
    	}

    	$scope.deleteStanica = function(stanica) {
    		StanicaService.deleteStanica(stanica.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.stanicaList.indexOf(stanica);
    					$scope.stanicaList.splice(index, 1); 
    				}
    		})
    	}
    	
    	$scope.openUpdateModal = function(stanica) {
    		document.getElementById("updateSelectGrad").value = stanica.grad.id;
    		$scope.stanica = angular.copy(stanica);
    		$('#updateStanicaModal').modal('toggle');
    	}
    	
    	$scope.updateStanica = function() {
    		$scope.stanica.grad.id = document.getElementById("updateSelectGrad").value;
    		StanicaService.updateStanica($scope.stanica)
    			.then(function successCallback(response) {
    				$('#updateStanicaModal').modal('toggle');
    				StanicaService.findAll()
    					.then(function successCallback(response) {
    						$scope.stanicaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Greska");
    				})
    		})
    	}
    	
    	$scope.filterFunction = function(stanica) {
    		if($scope.searchKeyword == "")
    			return true;
    		var check = stanica.grad.naziv+" "+" ";
    		if(check.includes($scope.searchKeyword))
    	    {
    	       	return true; 
    	    }
    		return false;
    	};
    	
    });