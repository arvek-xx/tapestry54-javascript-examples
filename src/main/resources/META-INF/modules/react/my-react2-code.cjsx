define ['t5/core/dom', 'react', 'jquery'], (dom, React, $) ->

	React.createClass
	 getInitialState: ->
	  return {data: []}
	
	 componentDidMount: ->
	  $.ajax(
	   url: 'rest/phones'
	   dataType: 'json', cache: false
	   success: ((data) ->  
	    this.setState({data: data})
	    console.log({data})
	    ).bind(this)
	   error: ((xhr, status, err) -> 
	    console.error(this.props.url, status, err.toString())
	    ).bind(this)
	  )
	 render: ->
 		<p>{this.state.data}</p>

	