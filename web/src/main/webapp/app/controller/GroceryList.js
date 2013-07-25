Ext.define('PA.controller.GroceryList', {
    extend: 'Ext.app.Controller',
    stores: ['GroceryList'],
    models: ['GroceryListItem'],
    views: ['GroceryListPanel'],

    init: function() {
        this.control({
            'grocerylist tool[type=refresh]': {
                click: this.onRefreshToolClicked
            },
            'grocerylist': {
                edit: this.onRowEdit
            }
        });

        this.refreshList();
    },

    onRefreshToolClicked: function() {
        this.refreshList();
    },

    onRowEdit: function() {
        this.getGroceryListStore().sync();
    },

    refreshList: function() {
        this.getGroceryListStore().load();
    }

});
