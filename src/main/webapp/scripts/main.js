'use strict';
// Require.js allows us to configure shortcut alias
require.config({
	// The shim config allows us to configure dependencies for
	// scripts that do not call define() to register a module
	shim : {
		underscore : {
			exports : '_'
		},
		backbone : {
			deps : ['underscore', 'jquery']
		},
		bootstrap : {
			deps : ['jquery']
		},
		marionette : {
			exports : 'Backbone.Marionette',
			deps : ['backbone']
		},
	},
	paths: {
		underscore: '../bower_components/underscore/underscore',
		backbone: '../bower_components/backbone/backbone',
		marionette: '../bower_components/backbone.marionette/lib/backbone.marionette',
		jquery: '../bower_components/jquery/dist/jquery',
		tpl: 'lib/tpl',
        bootstrap: '../bower_components/bootstrap/dist/js/bootstrap'
	},

	waitSeconds : 30,
	// urlArgs : "bust=" + ( function() {
	// return new Date();
	// }())
	/*urlArgs: "bust=" + (new Date().getTime())*/
});

require(['app', 'modules/Pages', 'jquery', 'bootstrap'], function(app, PagesModule) {
	'use strict';

	app.addInitializer(function() {
		PagesModule.start();
	});

	app.start();
});
