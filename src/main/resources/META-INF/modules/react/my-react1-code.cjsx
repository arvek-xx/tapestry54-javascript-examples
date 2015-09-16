define ['t5/core/dom', 'react'], (dom, React) ->

	Searching = React.createClass
		render: -> 
			a={
				"copyright": "Copyright (c) 2014 The New York Times Company.  All Rights Reserved.",
				"num_results": 44,
				"results": [
				    {
				        "display_name": "Print & E-Book Fiction",
				        "list_name": "Combined Print and E-Book Fiction",
				        "list_name_encoded": "combined-print-and-e-book-fiction",
				        "newest_published_date": "2014-12-14",
				        "oldest_published_date": "2011-02-13",
				        "updated": "WEEKLY"
				    },
				    {
				        "display_name": "Print & E-Book Nonfiction",
				        "list_name": "Combined Print and E-Book Nonfiction",
				        "list_name_encoded": "combined-print-and-e-book-nonfiction",
				        "newest_published_date": "2014-12-14",
				        "oldest_published_date": "2011-02-13",
				        "updated": "WEEKLY"
				    },
				    {
				        "display_name": "Hardcover Fiction",
				        "list_name": "Hardcover Fiction",
				        "list_name_encoded": "hardcover-fiction",
				        "newest_published_date": "2014-12-14",
				        "oldest_published_date": "2008-06-08",
				        "updated": "WEEKLY"
				    }]}

			a.results.forEach (res) ->
				console.log(res['display_name'])

			<form>
				<input type="text" placeholder="Search..." />
				<p>
				<input type="checkbox" />{' '}Only show products in stock
				</p>
				<h3>Products</h3>					
				<ul>
					<li>{this.props.products}</li>
				</ul>
			</form>
