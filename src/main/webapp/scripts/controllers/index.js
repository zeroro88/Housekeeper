/*global define */

define(['app'], function(app) {
	'use strict';

	return {
		showPage : function(pageName) {
			if (pageName == null)
				pageName = 'home';

			console.log('Router => Showing page: ' + pageName);

		},
		hello : function() {
			console.log('In route /hi');
		}
	};
});
