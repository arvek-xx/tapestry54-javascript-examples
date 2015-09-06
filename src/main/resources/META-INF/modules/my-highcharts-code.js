define([ "jquery", "highcharts" ], function($) {
	$(function() {
		var tag = $('#compare');
		var dataTapestry = tag.attr("valueTapestry");
		var dataAngular = tag.attr("valueAngular");
		var dataHighcharts = tag.attr("valueHighcharts");
		var category = tag.attr("category");

		var myArray = [];
		myArray.push(parseInt(dataTapestry));
		myArray.push(parseInt(dataAngular));
		myArray.push(parseInt(dataHighcharts));

		$('#compare').highcharts(
				{
					chart : {
						backgroundColor : {
							linearGradient : [ 0, 0, 500, 500 ],
							stops : [ [ 0, 'rgb(255, 255, 255)' ],
									[ 1, 'rgb(200, 200, 255)' ] ]
						},
						type : 'bar'
					},
					title : {
						text : 'Comparing...'
					},
					xAxis : {
						categories : [ 'Tapestry', 'Angular', 'Highcharts' ]
					},
					plotOptions : {
						series : {
							colorByPoint : true
						}
					},
					yAxis : {
						title : {
							text : 'Popularity'
						}
					},
					series : [ {
						name : category,
						data : myArray
					} ]
				});
	});
})
