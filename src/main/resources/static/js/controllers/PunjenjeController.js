angular.module('gremoNaElektrikoApp.PunjenjeController',[])
    .controller('PunjenjeController', function ($scope, PunjenjeService , VoziloService , TipPrikljuckaService , StanicaService ) {
    
    	$scope.punjenjeList = [];
    	$scope.voziloList = [];	
    	$scope.tipPrikljuckaList = [];	
    	$scope.stanicaList = [];	
    	$scope.sortType     = 'pocetakPunjenja';
    	$scope.sortReverse  = false;  
    	$scope.searchKeyword = "";
    
    	$scope.initDateTimePickerPocetakPunjenja = function() {
			$('#dateTimePocetakPunjenja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
			$('#updateDateTimePocetakPunjenja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
		}
		
    	$scope.initDateTimePickerKrajPunjenja = function() {
			$('#dateTimeKrajPunjenja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
			$('#updateDateTimeKrajPunjenja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
		}
		
    	PunjenjeService.findAll()
    		.then(function successCallback(response) {
    			$scope.punjenjeList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})

		VoziloService.findAll()
    		.then(function successCallback(response) {
    			$scope.voziloList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})
    		
		TipPrikljuckaService.findAll()
    		.then(function successCallback(response) {
    			$scope.tipPrikljuckaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})
    		
		StanicaService.findAll()
    		.then(function successCallback(response) {
    			$scope.stanicaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Greska");
    		})
    		

    	$scope.openCreateModal = function() {
    		$scope.punjenje = {};
    		$scope.punjenje.vozilo = {};
    		$scope.punjenje.tipPrikljucka = {};
    		$scope.punjenje.stanica = {};
    		$('#createPunjenjeModal').modal('toggle');
    	}
    		
    	$scope.createPunjenje = function() {
    		var pocetakPunjenja = $('#dateTextFieldPocetakPunjenja').val();
    		$scope.punjenje.pocetakPunjenja = moment(pocetakPunjenja, 'DD-MM-YYYY HH:mm');
    		var krajPunjenja = $('#dateTextFieldKrajPunjenja').val();
    		$scope.punjenje.krajPunjenja = moment(krajPunjenja, 'DD-MM-YYYY HH:mm');

    	PunjenjeService.createPunjenje($scope.punjenje , $scope.punjenje.vozilo.id , $scope.punjenje.tipPrikljucka.id , $scope.punjenje.stanica.id )
    			.then(function successCallback(response) {
    				$scope.punjenjeList.push(response.data);
    				 $('#createPunjenjeModal').modal('toggle');
    			})
    	}

    	$scope.deletePunjenje = function(punjenje) {
    		PunjenjeService.deletePunjenje(punjenje.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.punjenjeList.indexOf(punjenje);
    					$scope.punjenjeList.splice(index, 1); 
    				}
    		})
    	}
    	
    	$scope.openUpdateModal = function(punjenje) {
    		document.getElementById("updateSelectVozilo").value = punjenje.vozilo.id;
    		document.getElementById("updateSelectTipPrikljucka").value = punjenje.tipPrikljucka.id;
    		document.getElementById("updateSelectStanica").value = punjenje.stanica.id;
			$("#updateDateTextFieldPocetakPunjenja").val(moment(punjenje.pocetakPunjenja).format('DD-MM-YYYY HH:mm'));
			$("#updateDateTextFieldKrajPunjenja").val(moment(punjenje.krajPunjenja).format('DD-MM-YYYY HH:mm'));
    		$scope.punjenje = angular.copy(punjenje);
    		$('#updatePunjenjeModal').modal('toggle');
    	}
    	
    	$scope.updatePunjenje = function() {
    		$scope.punjenje.vozilo.id = document.getElementById("updateSelectVozilo").value;
    		$scope.punjenje.tipPrikljucka.id = document.getElementById("updateSelectTipPrikljucka").value;
    		$scope.punjenje.stanica.id = document.getElementById("updateSelectStanica").value;
    		var pocetakPunjenja = $('#updateDateTextFieldPocetakPunjenja').val();
    		$scope.punjenje.pocetakPunjenja = moment(pocetakPunjenja, 'DD-MM-YYYY HH:mm');
    		var krajPunjenja = $('#updateDateTextFieldKrajPunjenja').val();
    		$scope.punjenje.krajPunjenja = moment(krajPunjenja, 'DD-MM-YYYY HH:mm');
    		PunjenjeService.updatePunjenje($scope.punjenje)
    			.then(function successCallback(response) {
    				$('#updatePunjenjeModal').modal('toggle');
    				PunjenjeService.findAll()
    					.then(function successCallback(response) {
    						$scope.punjenjeList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Greska");
    				})
    		})
    	}
    	
    	$scope.filterFunction = function(punjenje) {
    		if($scope.searchKeyword == "")
    			return true;
    		var check = punjenje.vozilo.registracioniBroj+" "+punjenje.tipPrikljucka.naziv+" "+punjenje.stanica.adresa+" "+" ";
    		if(check.includes($scope.searchKeyword))
    	    {
    	       	return true; 
    	    }
    		return false;
    	};
    	
    });