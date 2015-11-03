
/********************************************************************************************************

 * File Name:-ListViewBaseController.js

 * Date Created:-29-Sept-2015

 * Author:- Shrikrishna

 * Purpose :-

 
 *********************************************************************************************************
 Version   |	Date Modified    |  	Author 	   |	Modifications	

 * 1.0			29-Sept-2015 			 Shrikrishna			
								
 *********************************************************************************************************/


Ext.define('Sales1.view.fw.frameworkController.ListViewBaseController', {
     extend: 'Sales1.view.fw.frameworkController.FrameworkViewController',
     alias : 'controller.ListViewBaseController',
     /*********************Main Controller Functions*********************************/
     
     componentArray: [],
     templateDataStore: [],
     recordCount: -1,
     activeRecord: 0,
     
     uiClass : null,
     
     onPaginationClick: function(but) {
    	 debugger;
         var record;
         if (but.isFirst) {
              record = 0;
         } else if (but.isNext) {
              record = ++this.activeRecord;
         } else if (but.isPrev) {
              record = --this.activeRecord;
         } else if (but.isLast) {
              record = this.recordCount;
         } /** removing prev data from UI */
         var components = this.view.query(Ext.create(this.uiClass).xtype);
         for (var index = 0; index < components.length; index++) {
              components[index].destroy();
         }
         for (var index = 0; index < this.templateDataStore[record].data.length; index++) {
              var component = new Ext.create(this.uiClass);
              var componentConfigData = this.templateDataStore[record].data[index];
              component.controller.modifyComponents(componentConfigData);
              this.componentArray.push(component);
              this.view.add(component);
         }
    },
    
    init : function(){
    	if(this.view.templateConfig){
    		this.setListData(this.view.templateConfig);
    	} else {
    		Ext.Msg.alert('Error', "List view panel rendering failed.");
    	}
    },
    
    
    setListData : function(templateConfig){

    	this.uiClass = templateConfig.uiClass;
		var jsonData = {};
		var scope = this.getView();
		Ext.Ajax.request({
			url : templateConfig.url,
			method : templateConfig.requestMethodType,
			sender : scope,
			jsonData : jsonData,
			success : function(response, scope) {
				var responseData = Ext.JSON
						.decode(response.responseText);
				scope.sender.controller
						.configForm(responseData);
			},
			failure : function(response, scope) {
			}
		}, scope);
	},
    
    configForm : function(responseData){
    	debugger;
        if (this.componentArray == null) {
            this.componentArray = new Array();
       }
       responseData = responseData.response.data;
       var pageSize = this.view.pageSize ? this.view.pageSize : 25;
       for (var index = 0; index < responseData.length; index = index + pageSize) {
            var item = {
                 data: responseData.slice(index, index + pageSize)
            }
            this.templateDataStore.push(item);
            this.recordCount++;
       }
       for (var index = 0; index < responseData.length; index++) {
            var component = new Ext.create(this.uiClass);
            var componentConfigData = responseData[index];
            component.controller.modifyComponents(componentConfigData);
            this.componentArray.push(component);
            //this.view.add(component);
       }
       
       for(var index = 0 ; index< pageSize; index ++){
    	   this.view.add(this.componentArray[index]);
       }
       
  },
    
	 getValues : function(){
			var jsonData = [];
			for (var index = 0; index < this.componentArray.length; index++) {
					//if(this.componentArray[index].viewModel){
						//jsonData.push(this.componentArray[index].getViewModel().getData());
					//}
				if(this.componentArray[index]){
					jsonData.push(this.componentArray[index].getValues());
				}
			}
			return jsonData;
	    }
});