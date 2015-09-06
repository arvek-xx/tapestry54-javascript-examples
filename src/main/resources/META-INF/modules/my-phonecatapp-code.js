define([ 'angular' ], function(angular) {
	var phonecatApp = angular.module('phoneCatApp', []);

	phonecatApp.controller('PhoneListCtrl', function($scope, $http) {
		$http.get('rest/phones').success(function(data) {
			$scope.phones = data;
		});

		$scope.orderProp = 'age';
	});
});
