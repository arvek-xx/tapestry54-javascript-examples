(function() {
	'use strict';
	require.config({
		paths : {
			'angular' : 'angular',
			'angular-route': 'angular-route',
			'angular-resource': 'angular-resource',
			'angular-animate': 'angular-animate',
			'phoneCatApp' : 'my-phonecatapp2-code'
		},
		shim : {
			'angular' : {
				'exports' : 'angular'
			},
			'angular-route' : {
				'exports' : 'angular-route',
				deps : [ 'angular' ]
			},
			'angular-resource' : {
				'exports' : 'angular-resource',
				deps : [ 'angular' ]
			},
			'angular-animate' : {
				'exports' : 'angular-animate',
				deps : [ 'angular' ]
			},
			'phoneCatApp' : {
				'exports' : 'phoneCatApp',
				deps : [ 'angular', 'angular-route', 'angular-resource', 'angular-animate' ]
			}
		}
	});
	define([ 'angular', 'phoneCatApp' ], function(angular) {
		angular.bootstrap(angular.element("body"), [ 'phoneCatApp' ]);
	});
}());