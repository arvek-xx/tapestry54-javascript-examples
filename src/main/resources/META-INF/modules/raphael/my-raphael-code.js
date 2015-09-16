// Raphael can't bee used with RequireJS (define) - therefore AMD
// After googling: http://devhike.blogspot.no/2013/05/use-raphaeljs-with-amd-recent-official.html
// None compability with RequireJS: http://veerasundar.com/blog/2013/02/loading-raphael-js-via-require-js/
require([ 'raphael/raphael' ], function(Raphael) { require([ 'raphael/g.raphael' ], function() { require([ 'raphael/g.bar' ], function() {
	var containerbar = document.getElementById('compare');
	var paper = Raphael(containerbar, 550, 250);
	var rect = paper.rect(0, 0, 550, 250);
	
	rect.attr({
	    fill : '#d8d8ff'
	});

	fin = function () {
	    this.flag = paper.popup(this.bar.x, this.bar.y, this.bar.value || '0').insertBefore(this);
	},
	fout = function () {
	    this.flag.animate({opacity: 0}, 300, function () {this.remove();});
	},
	txtattr = { font: '18px "Fontin Sans", Fontin-Sans, sans-serif' };

	var dataTapestry = parseInt(containerbar.getAttribute('valueTapestry'));
	var dataAngular = parseInt(containerbar.getAttribute('valueAngular'));
	var dataRaphael = parseInt(containerbar.getAttribute('valueHighcharts'));
	var category = containerbar.getAttribute('category');
	var myColors = ['#7cb5ec', '#434348', '#90ed7d']; // change default colors simular to Highchart

	var barCategory = paper.hbarchart(100, 40, 400, 200, [[dataTapestry], [dataAngular], [dataRaphael]], 
		{colors: myColors}).hover(fin, fout);
    
	var textCategory = paper.text(250, 20, 'Comparing...').attr({ font: '16px sans-serif' });
	var footerCategory = paper.text(250, 235, 'Popularity').attr({ font: '12px sans-serif' });
	var labelTap = paper.text(50, 90, 'Tapestry').attr({ font: '14px sans-serif' });
	var labelAng = paper.text(50, 135, 'Angular').attr({ font: '14px sans-serif' });
	var labelRap = paper.text(50, 180, 'Raphael').attr({ font: '14px sans-serif' });
	
	var group = paper.set();
	group.push(barCategory, textCategory, labelTap, labelAng, labelRap);
});});}); // after tree require