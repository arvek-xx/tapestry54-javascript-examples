define([ "jquery", "bootstrap/tooltip" ], function($, tooltip) {
    var $tool = $("#myTool");

    $tool.tooltip({
	placement : 'top'
    });
});