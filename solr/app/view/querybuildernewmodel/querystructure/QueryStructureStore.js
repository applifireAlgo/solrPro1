Ext.define('Sales1.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Sales1.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Sales1.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
