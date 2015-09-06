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
