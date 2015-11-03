Ext.define('Project.project.web.project.view.location.RegionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RegionMainController",
     "restURL": "/Region",
     "defaults": {
          "split": true
     },
     "requires": ["Project.project.shared.project.model.location.RegionModel", "Project.project.web.project.controller.location.RegionMainController", "Project.project.shared.project.model.location.CountryModel", "Project.project.shared.project.model.location.StateModel", "Project.project.shared.project.viewmodel.location.RegionViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "Region",
               "name": "RegionTreeContainer",
               "itemId": "RegionTreeContainer",
               "restURL": "/Region",
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
                    "itemId": "RegionTree",
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
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "76B6E4BD-B66E-47C6-A6EA-A27DB43C04FA",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "B1E2517A-D8F0-4F89-95DC-38A9B5CD595C",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.StateModel"
                         }
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name",
                         "fieldId": "58341740-4B9D-4661-A4B4-9F003FE5EC7A",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "regionCode1",
                         "itemId": "regionCode1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 1",
                         "fieldId": "10DFFCED-F496-4DFE-872C-4153FA3798A7",
                         "minValue": "0",
                         "maxValue": "3"
                    }, {
                         "name": "regionCodeChar2",
                         "itemId": "regionCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 2",
                         "fieldId": "FB291672-2897-4C03-AD05-351F87C4CDE6",
                         "minLength": "0",
                         "maxLength": "32"
                    }]
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
                    "viewModel": "RegionViewModel",
                    "xtype": "form",
                    "displayName": "Region",
                    "title": "Region",
                    "name": "Region",
                    "itemId": "Region",
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
                         "fieldId": "76B6E4BD-B66E-47C6-A6EA-A27DB43C04FA",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.CountryModel"
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
                         "fieldId": "B1E2517A-D8F0-4F89-95DC-38A9B5CD595C",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.StateModel"
                         },
                         "forceSelection": true,
                         "bind": "{stateId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "58341740-4B9D-4661-A4B4-9F003FE5EC7A",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{regionName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionCode1",
                         "itemId": "regionCode1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "10DFFCED-F496-4DFE-872C-4153FA3798A7",
                         "minValue": "0",
                         "maxValue": "3",
                         "bind": "{regionCode1}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionCodeChar2",
                         "itemId": "regionCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FB291672-2897-4C03-AD05-351F87C4CDE6",
                         "minLength": "0",
                         "maxLength": "32",
                         "bind": "{regionCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionDescription",
                         "itemId": "regionDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Region Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Description",
                         "fieldId": "510F5D89-A469-4476-84B7-457D97D44571",
                         "bind": "{regionDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionFlag",
                         "itemId": "regionFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "F10F3F2D-A6FD-4B9A-98CC-135EDEEE7B92",
                         "minLength": "0",
                         "maxLength": "128",
                         "bind": "{regionFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionLatitude",
                         "itemId": "regionLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Latitude",
                         "fieldId": "086A5C54-A419-4A28-8375-6B7CB73A98F5",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{regionLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionLongitude",
                         "itemId": "regionLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Longitude",
                         "fieldId": "DAFC43F0-84DE-4865-8B6B-9377F6F8B74B",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{regionLongitude}",
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
                         "customId": 967,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 967,
                              "customId": 502
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 967,
                              "customId": 503,
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
                              "parentId": 967,
                              "customId": 504,
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
                    "displayName": "Region",
                    "title": "Details Grid",
                    "name": "RegionGrid",
                    "itemId": "RegionGrid",
                    "restURL": "/Region",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Region Id",
                         "dataIndex": "regionId",
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
                         "header": "Region Name",
                         "dataIndex": "regionName",
                         "flex": 1
                    }, {
                         "header": "Region Code 1",
                         "dataIndex": "regionCode1",
                         "flex": 1
                    }, {
                         "header": "Region Code 2",
                         "dataIndex": "regionCodeChar2",
                         "flex": 1
                    }, {
                         "header": "Region Description",
                         "dataIndex": "regionDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "regionFlag",
                         "flex": 1
                    }, {
                         "header": "Region Latitude",
                         "dataIndex": "regionLatitude",
                         "flex": 1
                    }, {
                         "header": "Region Longitude",
                         "dataIndex": "regionLongitude",
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
               "viewModel": "RegionViewModel",
               "xtype": "form",
               "displayName": "Region",
               "title": "Region",
               "name": "Region",
               "itemId": "Region",
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
                    "fieldId": "76B6E4BD-B66E-47C6-A6EA-A27DB43C04FA",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.CountryModel"
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
                    "fieldId": "B1E2517A-D8F0-4F89-95DC-38A9B5CD595C",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.StateModel"
                    },
                    "forceSelection": true,
                    "bind": "{stateId}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionName",
                    "itemId": "regionName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "58341740-4B9D-4661-A4B4-9F003FE5EC7A",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{regionName}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionCode1",
                    "itemId": "regionCode1",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Code 1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Code 1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "10DFFCED-F496-4DFE-872C-4153FA3798A7",
                    "minValue": "0",
                    "maxValue": "3",
                    "bind": "{regionCode1}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionCodeChar2",
                    "itemId": "regionCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Code 2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FB291672-2897-4C03-AD05-351F87C4CDE6",
                    "minLength": "0",
                    "maxLength": "32",
                    "bind": "{regionCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionDescription",
                    "itemId": "regionDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Region Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Description",
                    "fieldId": "510F5D89-A469-4476-84B7-457D97D44571",
                    "bind": "{regionDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionFlag",
                    "itemId": "regionFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "F10F3F2D-A6FD-4B9A-98CC-135EDEEE7B92",
                    "minLength": "0",
                    "maxLength": "128",
                    "bind": "{regionFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionLatitude",
                    "itemId": "regionLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Latitude",
                    "fieldId": "086A5C54-A419-4A28-8375-6B7CB73A98F5",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{regionLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionLongitude",
                    "itemId": "regionLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Longitude",
                    "fieldId": "DAFC43F0-84DE-4865-8B6B-9377F6F8B74B",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{regionLongitude}",
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
                    "customId": 967,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 967,
                         "customId": 502
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 967,
                         "customId": 503,
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
                         "parentId": 967,
                         "customId": 504,
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