Ext.define('PA.view.GroceryListPanel' ,{
    extend: 'Ext.grid.Panel',
    uses: ['Ext.grid.plugin.RowEditing'],
    alias: 'widget.grocerylist',

    tools: [{
        type: 'refresh'
    }, {
        type: 'plus'
    }],

    columns: [{
        text: 'Item',
        dataIndex: 'name',
        flex: 1,
        editor: {
            xtype: 'textfield',
            allowOnlyWhitespace: false,
            emptyText: 'New list item'
        }
    }, {
        text: 'Quantity',
        dataIndex: 'quantity',
        flex: 1,
        editor: {
            xtype: 'numberfield',
            allowBlank: false
        }
    }],

    plugins: [{
        ptype: 'rowediting',
        clicksToEdit: 1
    }]

});
