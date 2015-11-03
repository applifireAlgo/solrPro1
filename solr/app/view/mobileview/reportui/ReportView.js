Ext.define('Sales1.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Sales1.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Sales1.view.mobileview.reportui.datachart.DataChartViewTab',
			'Sales1.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Sales1.view.mobileview.reportui.ReportViewController' ,
			'Sales1.view.mobileview.fw.DataPointPanel',
			'Sales1.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
