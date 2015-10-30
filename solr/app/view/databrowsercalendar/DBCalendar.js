Ext.define('Sales1.view.databrowsercalendar.DBCalendar', {
	extend : 'Sales1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Sales1.view.databrowsercalendar.DBCalendarController',
	             'Sales1.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
