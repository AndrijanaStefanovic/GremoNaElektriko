angular.module('gremoNaElektrikoApp.CenovnikController',[])
    .controller('CenovnikController', function ($scope, CenovnikService ) {
    
    	$scope.cenovnikList = [];
    	$scope.sortType     = 'datum';
    	$scope.sortReverse  = false;  
    
    	$scope.initDateTimePickerDatum = function() {
			$('#dateTimeDatum').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
			$('#updateDateTimeDatum').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
		}
		
    	CenovnikService.findAll()
    		.then(function successCallback(response) {
    			$scope.cenovnikList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})


    	$scope.openCreateModal = function() {
    		$scope.cenovnik = {};
    		$('#createCenovnikModal').modal('toggle');
    	}
    		
    	$scope.createCenovnik = function() {
    		var datum = $('#dateTextFieldDatum').val();
    		$scope.cenovnik.datum = moment(datum, 'DD-MM-YYYY HH:mm');

    	CenovnikService.createCenovnik($scope.cenovnik )
    			.then(function successCallback(response) {
    				$scope.cenovnikList.push(response.data);
    				 $('#createCenovnikModal').modal('toggle');
    			})
    	}

    	$scope.deleteCenovnik = function(cenovnik) {
    		CenovnikService.deleteCenovnik(cenovnik.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.cenovnikList.indexOf(cenovnik);
    					$scope.cenovnikList.splice(index, 1); 
    				}
    		})
    	}
    	
    	$scope.openUpdateModal = function(cenovnik) {
			$("#updateDateTextFieldDatum").val(moment(cenovnik.datum).format('DD-MM-YYYY HH:mm'));
    		$scope.cenovnik = angular.copy(cenovnik);
    		$('#updateCenovnikModal').modal('toggle');
    	}
    	
    	$scope.updateCenovnik = function() {
    		var datum = $('#updateDateTextFieldDatum').val();
    		$scope.cenovnik.datum = moment(datum, 'DD-MM-YYYY HH:mm');
    		CenovnikService.updateCenovnik($scope.cenovnik)
    			.then(function successCallback(response) {
    				$('#updateCenovnikModal').modal('toggle');
    				CenovnikService.findAll()
    					.then(function successCallback(response) {
    						$scope.cenovnikList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Greska");
    				})
    		})
    	}
    	
    	
    });