Ext.define('Sales1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Sales1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Sales1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
