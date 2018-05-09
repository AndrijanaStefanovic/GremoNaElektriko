angular.module('gremoNaElektrikoApp.buttonDirective',[])
.directive('buttonDirective', function () {
	return {
        template : "<div ng-controller='ButtonController'><button type=\"button\" class=\"btn btn-info\" data-ng-click=\"test()\">Rucno pisano</button></div>"
    };
});