Ext.define('PA.store.GroceryList', {
    extend: 'Ext.data.Store',
    model: 'PA.model.GroceryListItem',
    proxy: {
        type: 'rest',
        url : 'data/grocerylist',
        writer: { allowSingle: false },
        pageParam: undefined,
        limitParam: undefined,
        startParam: undefined
    }
});
