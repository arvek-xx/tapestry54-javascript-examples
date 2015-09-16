package no.mil.tap54.pages;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.HttpError;
import org.slf4j.Logger;

/**
 * Home page (prettify are used for code listings)
 */
@Import(module = { "prettify" }, stylesheet = { "prettify.css" })
public class Index
{
	@Inject
	private Logger logger;

	// Handle call with an unwanted context
	@Log
	Object onActivate(EventContext eventContext)
	{
		return eventContext.getCount() > 0 ? new HttpError(404, "Resource not found") : null;
	}
	
	/*
	 * Strings for use by <t:OutputRaw value="angularTypeCode" />
	 */
	public String getAngularBootstrapCode()
	{
		return "(function() {\n"
			+ "   'use strict';\n"
			+ "   require.config({\n"
			+ "      paths : {\n"
			+ "         'angular' : 'angular',\n"
			+ "         'todoApp' : 'my-angular-code'\n"
			+ "      },\n"
			+ "      shim : {\n"
			+ "         'angular' : {\n"
			+ "            'exports' : 'angular'\n"
			+ "         },\n"
			+ "         'todoApp' : {\n"
			+ "            'exports' : 'todoApp',\n"
			+ "            deps : [ 'angular' ]\n"
			+ "         }\n"
			+ "      }\n"
			+ "   });\n"
			+ "   define([ 'angular', 'todoApp' ], function(angular) {\n"
			+ "      angular.bootstrap(angular.element('body'), [ 'todoApp' ]);\n"
			+ "   });\n"
			+ "}());";
	}
	
	public String getAngularCode()
	{
		return "/*\n"
			+ " * angular-bootstrap.js loads 'angular.js' and 'todo-app.js'\n"
			+ "*/\n"
			+ "define([ 'angular' ], function(angular) {\n"
			+ "   angular.module('todoApp', []).controller('TodoListController', function() {\n"
			+ "      var todoList = this;\n"
			+ "      todoList.todos = [ {\n"
			+ "         text : 'Start with Tapestry 5.4',\n"
			+ "         done : true\n"
			+ "      }, {\n"
			+ "         text : 'Get angular',\n"
			+ "         done : true\n"
			+ "      }, {\n"
			+ "         text : 'Build a Tapestry/Angular app',\n"
			+ "         done : false\n"
			+ "      } ];\n\n"
			+ "      todoList.addTodo = function() {\n"
			+ "         todoList.todos.push({\n"
			+ "            text : todoList.todoText,\n"
			+ "            done : false\n"
			+ "         });\n"
			+ "         todoList.todoText = '';\n"
			+ "      };\n\n"
			+ "      todoList.remaining = function() {\n"
			+ "         var count = 0;\n"
			+ "         angular.forEach(todoList.todos, function(todo) {\n"
			+ "            count += todo.done ? 0 : 1;\n"
			+ "         });\n"
			+ "         return count;\n"
			+ "      };\n\n"
			+ "      todoList.archive = function() {\n"
			+ "         var oldTodos = todoList.todos;\n"
			+ "         todoList.todos = [];\n"
			+ "         angular.forEach(oldTodos, function(todo) {\n"
			+ "            if (!todo.done)\n"
			+ "            todoList.todos.push(todo);\n"
			+ "         });\n"
			+ "      };\n\n"
			+ "   });\n"
			+ "});";

	}
	
	/*
	 * Strings for use by <t:OutputRaw value="highchartJsCode" />
	 */
	public String getHighchartJsCode()
	{
		return "define([ 'jquery', 'highcharts' ], function($) {\n"
				+ "   $(function() {\n"
				+ "      var tag = $('#compare');\n"
				+ "      var dataTapestry = tag.attr('valueTapestry');\n"
				+ "      var dataAngular = tag.attr('valueAngular');\n"
				+ "      var dataHighcharts = tag.attr('valueHighcharts');\n"
				+ "      var category = tag.attr('category');\n\n"

				+ "      var myArray = [];\n"
				+ "      myArray.push(parseInt(dataTapestry));\n"
				+ "      myArray.push(parseInt(dataAngular));\n"
				+ "      myArray.push(parseInt(dataHighcharts));\n\n"
				+ "      $('#compare').highcharts({\n"
				+ "         chart : {\n"
				+ "            backgroundColor : {\n"
				+ "               linearGradient : [ 0, 0, 500, 500 ],\n"
				+ "               stops : [ [ 0, 'rgb(255, 255, 255)' ], [ 1, 'rgb(200, 200, 255)' ] ]\n"
				+ "            },\n"
				+ "            type : 'bar'\n"
				+ "         },\n"
				+ "         title : {\n"
				+ "            text : 'Comparing...'\n"
				+ "         },\n"
				+ "         xAxis : {\n"
				+ "            categories : [ 'Tapestry', 'Angular', 'Highcharts' ]\n"
				+ "         },\n"
				+ "         plotOptions : {\n"
				+ "            series : {\n"
				+ "               colorByPoint : true\n"
				+ "            }\n"
				+ "         },\n"
				+ "         yAxis : {\n"
				+ "            title : {\n"
				+ "               text : 'Popularity'\n"
				+ "            }\n"
				+ "         },\n"
				+ "         series : [ {\n"
				+ "            name : category,\n"
				+ "            data : myArray\n"
				+ "         } ]\n"
				+ "      });\n"
	    		+ "   );\n"
				+ "})";

	}

	/*
	 * Strings for use by <t:OutputRaw value="jchartJsCode" />
	 */
	public String getJchartJsCode()
	{
		return "define([ 'jquery', 'jchart' ], function($) {\n"
				+ "   $(function() {\n"
				+ "      $('#compare').jChart({ x_label : 'Popularity' });\n"
				+ "   });\n"
				+ "})";
	}

	/*
	 * Strings for use by <t:OutputRaw value="raphaelJsCode" />
	 */
	public String getRaphaelJsCode()
	{
		return "require([ 'raphael' ], function(Raphael) { require([ 'g.raphael' ], function() { require([ 'g.bar' ], function() {\n"
				+ "   var containerbar = document.getElementById('compare');\n"
				+ "   var paper = Raphael(containerbar, 550, 250);\n"
				+ "   var rect = paper.rect(0, 0, 550, 250);\n\n"
				+ "   rect.attr({\n\n"
				+ "      fill : '#d8d8ff'\n"
				+ "   });\n\n"
				+ "   fin = function () {\n"
				+ "      this.flag = paper.popup(this.bar.x, this.bar.y, this.bar.value || '0').insertBefore(this);\n"
				+ "   },\n"
				+ "   fout = function () {\n"
				+ "      this.flag.animate({opacity: 0}, 300, function () {this.remove();});\n"
				+ "   },\n"
				+ "   txtattr = { font: '18px &#34;Fontin Sans&#34;, Fontin-Sans, sans-serif' };\n\n"
				+ "   var dataTapestry = parseInt(containerbar.getAttribute('valueTapestry'));\n"
				+ "   var dataAngular = parseInt(containerbar.getAttribute('valueAngular'));\n"
				+ "   var dataRaphael = parseInt(containerbar.getAttribute('valueHighcharts'));\n"
				+ "   var category = containerbar.getAttribute('category');\n\n"
				+ "   var barCategory = paper.hbarchart(100, 40, 400, 200,\n"
				+ "      [[dataTapestry], [dataAngular], [dataRaphael]]).hover(fin, fout);\n\n"
				+ "   var textCategory = 	paper.text(250, 20, 'Comparing...').attr({ font: '16px sans-serif' });\n"
				+ "   var footerCategory = paper.text(250, 235, 'Popularity').attr({ font: '12px sans-serif' });\n"
				+ "   var labelTap = 	paper.text(50, 90, 'Tapestry').attr({ font: '14px sans-serif' });\n"
				+ "   var labelAng = 	paper.text(50, 135, 'Angular').attr({ font: '14px sans-serif' });\n"
				+ "   var labelRap = 	paper.text(50, 180, 'Raphael').attr({ font: '14px sans-serif' });\n\n"
				+ "   var group = paper.set();\n"
				+ "   group.push(barCategory, textCategory, labelTap, labelAng, labelRap);\n"
				+ "});});}); // after tree require";
	}

	/*
	 * Strings for use by <t:OutputRaw value="bootstrapTypeCode" />
	 */
	public String getBootstrapClassCode()
	{
		return "@Import(module = { &#34;bootstrap/popover&#34;, &#34;bootstrap/tooltip&#34;, &#34;my-popover-code&#34;, &#34;my-tooltip-code&#34; })\n"
				+ "public class Bootstrap\n"
				+ "{\n\n"
				+ "}\n";
	}

	public String getBootstrapTmlCode()
	{
		return "&lt;html t:type=&#34;layout&#34 title=&#34;Bootstrap Popover and ToolTip&#34;\n"
				+ "xmlns:t=&#34;http://tapestry.apache.org/schema/tapestry_5_4.xsd&#34;&gt\n\n"
				+ "   &lt;button type=&#34;button&#34; class=&#34;btn btn-lg btn-primary&#34;\n"
				+ "      data-toggle=&#34;popover&#34; id=&#34;myPop&#34; title=&#34;Bootstrap popover title&#34;\n"
				+ "      data-content=&#34;And here's some amazing content.&#34;&gt;\n"
				+ "         Click to see 'Popover'\n"
				+ "   &lt;/button&gt;\n"
				+ "   &nbsp;\n"
				+ "   &lt;button type=&#34;button&#34; class=&#34;btn btn-lg btn-success&#34;\n"
				+ "      data-toggle=&#34;tooltip&#34; id=&#34;myTool&#34; title=&#34;This is the Bootstrap tooltip&#34;&gt;\n"
				+ "         Mouse-over to see 'Tooltip'\n"
				+ "   &lt;/button&gt;\n"
				+ "   &lt;br/&gt;\n"			
				+ "&lt;/html&gt;";				

	}
	public String getBootstrapJsCode()
	{
		return "define(['jquery', 'bootstrap/popover'], function($, popover) {\n"
				+ "   var $pop = $('#myPop');\n"
				+ "\n"
				+ "   $pop.popover({placement : 'top'});\n"
				+ "});";
	}
	
	/*
	 * Strings for use by <t:OutputRaw value="coffeeTypeCode" />
	 */
	public String getCoffeeClassCode()
	{
		return "@Import(module = { &#34;my-coffee-code&#34; })\n"
				+ "public class Coffee\n"
				+ "{\n\n"
				+ "}\n";
	}

	public String getCoffeeTmlCode()
	{
		return "&lt;html t:type=&#34;layout&#34; title=&#34;Coffee&#34;\n"
				+ "xmlns:t=&#34;http://tapestry.apache.org/schema/tapestry_5_4.xsd&#34;&gt;\n\n"
				+ "   &lt;img src=&#34;${context:images/F-35.png}&#34; alt=&#34;F-35&#34; id=&#34;f35left&#34; /&gt;&#34;\n\n"
				+ "   &lt;p&gt;Simple Coffee script (and JQuery)&lt;/p&gt;\n\n"
				+ "&lt;/html&gt;";				

	}
	public String getCoffeeJsCode()
	{
		return "define([ 'jquery' ], ($) ->\n"
				+ "   return ->\n"
				+ "      f35 = $('#f35left')\n"
				+ "      speed = 4000\n\n"
				+ "      repeat = (func, amount, argument) -> setInterval(func, amount, argument)\n\n"
				+ "      resetCss = () -> f35.css({\n"
				+ "         'position' : 'absolute',\n"
				+ "         'top' : '100px',\n"
				+ "         'width' : '60px',\n"
				+ "         'margin-left' : '-500px',\n"
				+ "         'z-index' : '-1',\n"
				+ "         'visibility' : 'visible'})\n\n"
				+ "      doFlyoverStart = () -> f35.animate({\n"
				+ "         'margin-left' : '2000px'},{\n"
				+ "         duration : speed,complete : -> resetCss()})\n\n"
				+ "      resetCss()\n"
				+ "      repeatIdStartFly = repeat(doFlyoverStart, 500, false))";
	}

	/*
	 * Strings for use by <t:OutputRaw value="reactTypeCode" />
	 */
	public String getReactPomCode()
	{
		return "...\n"
				+ "&lt;dependency&gt;\n"
				+ "   &lt;groupId&gt;de.eddyson&lt;/groupId&gt;\n"
				+ "   &lt;artifactId&gt;tapestry-react&lt;/artifactId&gt;\n"
				+ "   &lt;version&gt;0.1.2&lt;/version&gt;\n"
				+ "&lt;/dependency&gt;\n"
				+ "...\n"
				+ "&lt;repository&gt;\n"
				+ "   &lt;id&gt;jcenter&lt;/id&gt;\n"
				+ "   &lt;url&gt;https://jcenter.bintray.com&lt;/url&gt;\n"
				+ "&lt;/repository&gt;\n"
				+ "...";
	}
	public String getReactTapestryJsCode()
	{
		return "define ['t5/core/dom', 'react'], (dom, React) ->\n"
				+ "   React.createClass\n"
				+ "      render: -> &lt;div&gt;Hello {this.props.name}&lt;/div&gt;";
	}
	public String getReactTapestryTmlCode()
	{
		return "&lt;html t:type=&#34;layout&#34; title=&#34;React (tapestry-react)&#34;\n"
				+ "xmlns:t=&#34;http://tapestry.apache.org/schema/tapestry_5_4.xsd&#34;\n"
				+ "xmlns:p=&#34;tapestry:parameter&#34;\n"
				+ "xmlns:r=&#34;tapestry-library:react&#34;&gt;\n\n"
				+ "   &lt;r:reactcomponent module=&#34;react/my-react-code&#34; name=&#34;${nameFromClassFile}&#34; /&gt;\n\n"
				+ "&lt;/html&gt;";
	}

}
