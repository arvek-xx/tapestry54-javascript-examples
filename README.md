# tapestry54-javascript-examples
Tapestry 5.4 - makes things simple!

Different techniques to easily include different javascript libraries/framework in Tapestry 5.4.

Eksample of using AngularJS inside Tapestry.

1. Bootstrap Angular:
<pre>
(function() {
	'use strict';
	require.config({
		paths : {
			'angular' : 'angular',
			'todoApp' : 'my-angular-code'
		},
		shim : {
			'angular' : {
				'exports' : 'angular'
			},
			'todoApp' : {
				'exports' : 'todoApp',
				deps : [ 'angular' ]
			}
		}
	});
	define([ 'angular', 'todoApp' ], function(angular) {
		angular.bootstrap(angular.element("body"), [ 'todoApp' ]);
	});
}());
</pre>

2. Write Angular code:
<pre>
define([ 'angular' ], function(angular) {
	angular.module('todoApp', []).controller('TodoListController', function() {
		var todoList = this;
		todoList.todos = [ {
			text : 'Start with Tapestry 5.4',
			done : true
		}, {
			text : 'Get angular',
			done : true
		}, {
			text : 'Build a Tapestry/Angular app',
			done : false
		} ];

		todoList.addTodo = function() {
			todoList.todos.push({
				text : todoList.todoText,
				done : false
			});
			todoList.todoText = '';
		};

		todoList.remaining = function() {
			var count = 0;
			angular.forEach(todoList.todos, function(todo) {
				count += todo.done ? 0 : 1;
			});
			return count;
		};

		todoList.archive = function() {
			var oldTodos = todoList.todos;
			todoList.todos = [];
			angular.forEach(oldTodos, function(todo) {
				if (!todo.done)
					todoList.todos.push(todo);
			});
		};

	});
});
</pre>

3. Import in class-file:
<pre>
@Import(module = { "angular-bootstrap" }, stylesheet = { "my-angular-code.css" })
</pre>

4. Edit template-file
<pre>
<html t:type="layout" title="Tapestry 5.4 with AngularJS"
	xmlns:t="http://tapestry.apache.org/schema/tapestry_5_4.xsd"
	xmlns:p="tapestry:parameter">

<!-- <body ng-app="todoApp"> done from 'angular-bootstrap' -->
<body>
	<div class="well">
		<p>This is a simple todo-list angular application inside Tapestry.</p>
	</div>

	<div ng-controller='TodoListController'>
		<h2>Todo</h2>
		<div ng-controller='TodoListController as todoList'>
			<span>{{todoList.remaining()}} of {{todoList.todos.length}} remaining</span>
			[ <a href="" ng-click='todoList.archive()'>archive</a> ]
			<ul class="unstyled">
				<li ng-repeat='todo in todoList.todos'>
					<input type="checkbox" ng-model='todo.done' /> <span class='done-{{todo.done}}'>{{todo.text}}</span>
				</li>
			</ul>
			
			<form ng-submit='todoList.addTodo()'>
				<input type="text" ng-model='todoList.todoText' size="30" placeholder="add new todo here" />
				<input class="btn-primary" type="submit" value="add" />
			</form>
		</div>
	</div> <!-- end ng-controller -->
</body>
</html>
</pre>
