Ext.define('PA.controller.GroceryList', {
    extend: 'Ext.app.Controller',
    stores: ['GroceryList'],
    models: ['GroceryListItem'],
    views: ['GroceryListPanel'],

    init: function() {
        this.refreshList();
    },

    refreshList: function() {
        this.getStore('GroceryList').load();
    }

});
