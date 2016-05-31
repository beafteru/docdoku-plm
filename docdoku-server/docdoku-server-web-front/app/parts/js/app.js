/*global define,App*/
define([
    'backbone',
    'mustache',
    'text!templates/part-permalink.html',
    'views/part-revision'
], function (Backbone, Mustache, template, PartRevisionView) {
	'use strict';

    var AppView = Backbone.View.extend({

        el: '#content',

        render: function () {
            this.$el.html(Mustache.render(template, {
                i18n: App.config.i18n
            })).show();
            this.$notifications = this.$('.notifications');
            return this;
        },

        onPartFetched:function(part){
            this.$('.part-revision').html(new PartRevisionView().render(part).$el);
        },

        showPartRevision:function(workspace, partNumber, partVersion){
            $.getJSON(App.config.contextPath + '/api/shared/' +  workspace + '/parts/'+partNumber+'-'+partVersion)
                .then(this.onPartFetched.bind(this), this.onError.bind(this));
        },

        showSharedEntity:function(uuid){
            this.uuid = uuid;
            $.getJSON(App.config.contextPath + '/api/shared/' + uuid + '/parts')
                .then(this.onSharedPartFetched.bind(this), this.onSharedPartError.bind(this));
        },

        onSharedPartFetched:function(part){
            this.$('.part-revision').html(new PartRevisionView().render(part, this.uuid).$el);
        },

        onSharedPartError:function(){
            debugger
        },

        onError:function(err){
            debugger
            if(err.status === 403 || err.status === 401){
                              // window.location.href = App.config.contextPath + '/?denied=true&originURL=' + encodeURIComponent(window.location.pathname + window.location.hash);
            }
        }

    });

    return AppView;
});
