define(function () {
	var Folder = Backbone.Model.extend({
		defaults: {
			home: false
		},
		url: function() {
			if (this.get("id")) {
				return "/api/workspaces/" + APP_CONFIG.workspaceId + "/folders/" + this.get("id");
			} else if (this.collection) {
				return this.collection.url;
			}
		},
	});
	return Folder;
});
