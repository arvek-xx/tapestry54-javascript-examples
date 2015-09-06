(function() {
	'use strict';
	require.config({
		paths : {
			'angular' : 'angular',
			'todoApp' : 'my-angular-code'
		},
		shim : {
			'angular' : {
				'exports' : 'angular'
			},
			'todoApp' : {
				'exports' : 'todoApp',
				deps : [ 'angular' ]
			}
		}
	});
	define([ 'angular', 'todoApp' ], function(angular) {
		angular.bootstrap(angular.element("body"), [ 'todoApp' ]);
	});
}());