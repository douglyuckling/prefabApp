Ext.define('PA.controller.GroceryList', {
    extend: 'Ext.app.Controller',
    stores: ['GroceryList'],
    models: ['GroceryListItem'],
    views: ['GroceryListPanel'],

    init: function() {
        this.control({
            'grocerylist tool[type=refresh]': {
                click: this.refreshList
            }
        });

        this.refreshList();
    },

    refreshList: function() {
        this.getGroceryListStore().load();
    }

});
