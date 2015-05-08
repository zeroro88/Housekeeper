'use strict';
// Require.js allows us to configure shortcut alias
require.config({
	// The shim config allows us to configure dependencies for
	// scripts that do not call define() to register a module
	shim: {
		underscore: { exports: '_' },
		backbone: {
			deps: [
				'underscore',
				'jquery'
			]
		},
		bootstrap: { deps: ['jquery'] },
		'backbone.marionette': {
			deps:['backbone'],
			exports:'marionette'
		}
	},
	paths: {
		jquery:'//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min',
		underscore: '//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min',
		backbone: '//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min',
		bootstrap:'//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min',
		'backbone.marionette': "//cdnjs.cloudflare.com/ajax/libs/backbone.marionette/2.4.1/backbone.marionette.min"
	},
	waitSeconds: 30,
	urlArgs: "bust=" + (function(){
		return new Date();
	}())
	/*urlArgs: "bust=" + (new Date().getTime())*/
});

require(['backbone.marionette'], 
			function(marionette) {
	
});