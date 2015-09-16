define ['t5/core/dom', 'react'], (dom, React) ->
	React.createClass
		render: -> <div>Hello {this.props.name}</div>