/*global define */

define(['backbone', 'marionette'], function(Backbone, Marionette) {
	'use strict';

	var app = new Marionette.Application();

	return window.app = app;
});
