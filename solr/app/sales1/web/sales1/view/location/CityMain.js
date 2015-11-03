Ext.define('Sales1.sales1.web.sales1.view.location.CityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CityMainController",
     "restURL": "/City",
     "defaults": {
          "split": true
     },
     "requires": ["Sales1.sales1.shared.sales1.model.location.CityModel", "Sales1.sales1.web.sales1.controller.location.CityMainController", "Sales1.sales1.shared.sales1.model.location.CountryModel", "Sales1.sales1.shared.sales1.model.location.StateModel", "Sales1.sales1.shared.sales1.viewmodel.location.CityViewModel", "Ext.form.field.CustomDateField"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "City",
               "name": "CityTreeContainer",
               "itemId": "CityTreeContainer",
               "restURL": "/City",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CityTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "CityViewModel",
                    "xtype": "form",
                    "displayName": "City",
                    "title": "City",
                    "name": "City",
                    "itemId": "City",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "510D63FB-D44A-476B-9039-5AC09982E861",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Sales1.sales1.shared.sales1.model.location.CountryModel"
                         },
                         "forceSelection": true,
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E683825A-9A8D-4048-80C8-2C28048B500D",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Sales1.sales1.shared.sales1.model.location.StateModel"
                         },
                         "forceSelection": true,
                         "bind": "{stateId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityName",
                         "itemId": "cityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F49251F3-CA0F-4176-8322-EF396812D214",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{cityName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCodeChar2",
                         "itemId": "cityCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2C34E0B7-F1FD-4116-904C-1E0BACB1EEBB",
                         "minLength": "0",
                         "maxLength": "32",
                         "bind": "{cityCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCode",
                         "itemId": "cityCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Code1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "578A2740-F2F5-4479-8625-FB0BDB5AFF2B",
                         "minValue": "0",
                         "maxValue": "3",
                         "bind": "{cityCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityDescription",
                         "itemId": "cityDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "City Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Description",
                         "fieldId": "F4B27B3D-DF78-497C-B1D5-0BE525027682",
                         "bind": "{cityDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityFlag",
                         "itemId": "cityFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "E7FF9FAE-8735-48A8-9012-2FA2875F299B",
                         "minLength": "0",
                         "maxLength": "128",
                         "bind": "{cityFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLatitude",
                         "itemId": "cityLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Latitude",
                         "fieldId": "5F264E8B-749C-43E6-AE80-2D619FB7C02C",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{cityLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLongitude",
                         "itemId": "cityLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Longitude",
                         "fieldId": "EB945A6F-6D3D-475F-923E-423B9541FDA6",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{cityLongitude}",
                         "columnWidth": 0.5
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 85,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 85,
                              "customId": 346
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 85,
                              "customId": 347,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 85,
                              "customId": 348,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "City",
                    "title": "Details Grid",
                    "name": "CityGrid",
                    "itemId": "CityGrid",
                    "restURL": "/City",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "City Id",
                         "dataIndex": "cityId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "City Name",
                         "dataIndex": "cityName",
                         "flex": 1
                    }, {
                         "header": "City Code",
                         "dataIndex": "cityCodeChar2",
                         "flex": 1
                    }, {
                         "header": "City Code1",
                         "dataIndex": "cityCode",
                         "flex": 1
                    }, {
                         "header": "City Description",
                         "dataIndex": "cityDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "cityFlag",
                         "flex": 1
                    }, {
                         "header": "City Latitude",
                         "dataIndex": "cityLatitude",
                         "flex": 1
                    }, {
                         "header": "City Longitude",
                         "dataIndex": "cityLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "CityViewModel",
               "xtype": "form",
               "displayName": "City",
               "title": "City",
               "name": "City",
               "itemId": "City",
               "bodyPadding": 10,
               "items": [{
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "510D63FB-D44A-476B-9039-5AC09982E861",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "store": {
                         "data": [],
                         "model": "Sales1.sales1.shared.sales1.model.location.CountryModel"
                    },
                    "forceSelection": true,
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E683825A-9A8D-4048-80C8-2C28048B500D",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "store": {
                         "data": [],
                         "model": "Sales1.sales1.shared.sales1.model.location.StateModel"
                    },
                    "forceSelection": true,
                    "bind": "{stateId}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityName",
                    "itemId": "cityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F49251F3-CA0F-4176-8322-EF396812D214",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{cityName}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCodeChar2",
                    "itemId": "cityCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2C34E0B7-F1FD-4116-904C-1E0BACB1EEBB",
                    "minLength": "0",
                    "maxLength": "32",
                    "bind": "{cityCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCode",
                    "itemId": "cityCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Code1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "578A2740-F2F5-4479-8625-FB0BDB5AFF2B",
                    "minValue": "0",
                    "maxValue": "3",
                    "bind": "{cityCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityDescription",
                    "itemId": "cityDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "City Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Description",
                    "fieldId": "F4B27B3D-DF78-497C-B1D5-0BE525027682",
                    "bind": "{cityDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityFlag",
                    "itemId": "cityFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "E7FF9FAE-8735-48A8-9012-2FA2875F299B",
                    "minLength": "0",
                    "maxLength": "128",
                    "bind": "{cityFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLatitude",
                    "itemId": "cityLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Latitude",
                    "fieldId": "5F264E8B-749C-43E6-AE80-2D619FB7C02C",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{cityLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLongitude",
                    "itemId": "cityLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Longitude",
                    "fieldId": "EB945A6F-6D3D-475F-923E-423B9541FDA6",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{cityLongitude}",
                    "columnWidth": 0.5
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 85,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 85,
                         "customId": 346
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 85,
                         "customId": 347,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 85,
                         "customId": 348,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});