(function() {
    'use strict';
    require.config({
	paths : {
	    'angular' : 'angular/angular',
	    'phoneCatApp' : 'angular/my-phonecatapp-code'
	},
	shim : {
	    'angular' : {
		'exports' : 'angular'
	    },
	    'phoneCatApp' : {
		'exports' : 'phoneCatApp',
		deps : [ 'angular' ]
	    }
	}
    });
    define([ 'angular', 'phoneCatApp' ], function(angular) {
	angular.bootstrap(angular.element("body"), [ 'phoneCatApp' ]);
    });
}());