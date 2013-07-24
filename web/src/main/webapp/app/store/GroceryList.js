Ext.define('PA.store.GroceryList', {
    extend: 'Ext.data.Store',
    model: 'PA.model.GroceryListItem',
    proxy: {
        type: 'ajax',
        url : 'data/grocerylist',
        pageParam: undefined,
        limitParam: undefined,
        startParam: undefined
    }
});
