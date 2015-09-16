define([ 'jquery' ], ($) ->
	return ->
		f35 = $('#f35left')
		speed = 4000
		
		repeat = (func, amount, argument) -> setInterval(func, amount, argument)
		
		resetCss = () -> f35.css({
			'position' : 'absolute',
			'top' : '100px',
			'width' : '60px',
			'margin-left' : '-500px',
			'z-index' : '-1',
			'visibility' : 'visible'})
			
		doFlyoverStart = () -> f35.animate({
			'margin-left' : '2000px'},{
			duration : speed,complete : -> resetCss()})
			
		resetCss()
		repeatIdStartFly = repeat(doFlyoverStart, 500, false))
