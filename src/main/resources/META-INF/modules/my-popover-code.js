define([ "jquery", "bootstrap/popover" ], function($, popover) {
    var $pop = $("#myPop");

    $pop.popover({
	placement : 'top'
    });
});