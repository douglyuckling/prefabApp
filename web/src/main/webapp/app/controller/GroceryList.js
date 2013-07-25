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
            'grocerylist tool[type=plus]': {
                click: this.onAddToolClicked
            },
            'grocerylist': {
                edit: this.onRowEdit,
                canceledit: this.onCancelRowEdit,
                delete: this.onRowDelete
            }
        });

        this.refreshList();
    },

    onRefreshToolClicked: function() {
        this.refreshList();
    },

    onAddToolClicked: function(toolComponent) {
        var groceryListPanel = toolComponent.up('grocerylist'),
            rowEditingPlugin = groceryListPanel.findPlugin('rowediting'),
            newGroceryListItem, newItemIndex;

        // Cancel an ongoing edit, if there is one.
        rowEditingPlugin.cancelEdit();

        // Create a new model instance and begin editing it...
        newGroceryListItem = this.getGroceryListItemModel().create({
            name: '',
            quantity: 1
        });

        newItemIndex = this.getGroceryListStore().getCount();
        this.getGroceryListStore().insert(newItemIndex, newGroceryListItem);
        groceryListPanel.getSelectionModel().select(newGroceryListItem);
        groceryListPanel.getView().focusRow(newItemIndex);
        rowEditingPlugin.startEdit(newItemIndex, 0);
    },

    onRowEdit: function() {
        this.getGroceryListStore().sync();
    },

    onCancelRowEdit: function(editor, context) {
        var record = context.record,
            wasFirstEditOnNewRecord = record.phantom && !record.dirty;

        if (wasFirstEditOnNewRecord) {
            this.getGroceryListStore().remove(record);
        }
    },

    onRowDelete: function(groceryListPanel, actionColumn, view, rowIndex, colIndex, item, e, record, row) {
        var rowEditingPlugin = groceryListPanel.findPlugin('rowediting');
        console.log(record);

        Ext.defer(function() {
            // Cancel an ongoing edit, if there is one.
            rowEditingPlugin.cancelEdit();

            this.getGroceryListStore().remove(record);
            this.getGroceryListStore().sync();
        }, 1, this);
    },

    refreshList: function() {
        this.getGroceryListStore().load();
    }

});
