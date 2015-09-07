define([ 'angular' ], function(angular) {
    'use strict';

    /*
     * "App"
     */
    var phonecatApp = angular.module('phoneCatApp', [ 'ngRoute', 'phonecatAnimations', 'phonecatControllers',
	    'phonecatFilters', 'phonecatServices' ]);

    phonecatApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/phones', {
	    templateUrl : 'partials/phone-list.html',
	    controller : 'PhoneListCtrl'
	}).when('/phones/:phoneId', {
	    templateUrl : 'partials/phone-detail.html',
	    controller : 'PhoneDetailCtrl'
	}).otherwise({
	    redirectTo : '/phones'
	});
    } ]);

    /*
     * "Controllers"
     */
    var phonecatControllers = angular.module('phonecatControllers', []);

    phonecatControllers.controller('PhoneListCtrl', [ '$scope', 'Phone', function($scope, Phone) {
	$scope.phones = Phone.query();
	$scope.orderProp = 'age';
    } ]);

    phonecatControllers.controller('PhoneDetailCtrl', [ '$scope', '$routeParams', 'Phone',
	    function($scope, $routeParams, Phone) {
		$scope.phone = Phone.get({
		    phoneId : $routeParams.phoneId
		}, function(phone) {
		    $scope.mainImageUrl = phone.images[0];
		});

		$scope.setImage = function(imageUrl) {
		    $scope.mainImageUrl = imageUrl;
		};
	    } ]);

    /*
     * "Filters"
     */
    angular.module('phonecatFilters', []).filter('checkmark', function() {
	return function(input) {
	    return input ? '\u2713' : '\u2718';
	};
    });

    /* Services */
    var phonecatServices = angular.module('phonecatServices', [ 'ngResource' ]);

    phonecatServices.factory('Phone', [ '$resource', function($resource) {
	return $resource('phones/:phoneId.json', {}, {
	    query : {
		method : 'GET',
		params : {
		    phoneId : 'phones'
		},
		isArray : true
	    }
	});
    } ]);

    /*
     * "Animations"
     */
    var phonecatAnimations = angular.module('phonecatAnimations', [ 'ngAnimate' ]);

    phonecatAnimations.animation('.phone', function() {

	var animateUp = function(element, className, done) {
	    if (className != 'active') {
		return;
	    }
	    element.css({
		position : 'absolute',
		top : 500,
		left : 0,
		display : 'block'
	    });

	    jQuery(element).animate({
		top : 0
	    }, done);

	    return function(cancel) {
		if (cancel) {
		    element.stop();
		}
	    };
	}

	var animateDown = function(element, className, done) {
	    if (className != 'active') {
		return;
	    }
	    element.css({
		position : 'absolute',
		left : 0,
		top : 0
	    });

	    jQuery(element).animate({
		top : -500
	    }, done);

	    return function(cancel) {
		if (cancel) {
		    element.stop();
		}
	    };
	}

	return {
	    addClass : animateUp,
	    removeClass : animateDown
	};
    });

});
