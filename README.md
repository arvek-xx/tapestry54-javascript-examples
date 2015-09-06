# tapestry54-javascript-examples
Tapestry 5.4 - makes things simple!

Different techniques to easily include different javascript libraries/framework in Tapestry 5.4.

Eksample of using AngularJS inside Tapestry:
1. Bootstrap Angular:
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

