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
    }],

    initComponent: function() {
        var me = this;

        this.addEvents('delete');

        this.columns.push({
            xtype:'actioncolumn',
            width:50,
            icon: 'resources/theme-neptune/images/tools/tool-close-dark.png',
            tooltip: 'Delete',
            handler: function() {
                var actioncolumn = this;
                me.fireEventArgs('delete', [me, actioncolumn].concat(Array.prototype.slice.call(arguments, 0)));
            }
        });

        this.callParent(arguments);
    }

});
