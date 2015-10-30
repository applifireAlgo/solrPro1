Ext.define('Sales1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Sales1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Sales1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
