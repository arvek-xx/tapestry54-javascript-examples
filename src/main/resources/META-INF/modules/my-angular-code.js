/*
 * angular-bootstrap.js loads 'angular.js' and 'todo-app.js'
 */
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
