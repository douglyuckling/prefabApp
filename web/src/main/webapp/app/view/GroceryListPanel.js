Ext.define('PA.view.GroceryListPanel' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.grocerylist',

    tools: [{
        type: 'refresh'
    }],

    columns: [
        {text: 'Item',  dataIndex: 'name',  flex: 1},
        {text: 'Quantity', dataIndex: 'quantity', flex: 1}
    ]

});
