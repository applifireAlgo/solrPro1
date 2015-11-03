Ext.define('Project.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Project.view.mobileview.reportui.datachart.DataChartViewTab',
			'Project.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Project.view.mobileview.reportui.ReportViewController' ,
			'Project.view.mobileview.fw.DataPointPanel',
			'Project.view.mobileview.googlemaps.map.MapPanel'
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
