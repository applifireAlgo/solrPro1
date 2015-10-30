Ext.define('Sales1.sales1.web.sales1.view.authentication.PasswordAlgoMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PasswordAlgoMainController",
     "restURL": "/PasswordAlgo",
     "defaults": {
          "split": true
     },
     "requires": ["Sales1.sales1.shared.sales1.model.authentication.PasswordAlgoModel", "Sales1.sales1.web.sales1.controller.authentication.PasswordAlgoMainController", "Sales1.sales1.shared.sales1.viewmodel.authentication.PasswordAlgoViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "Password Algo",
               "name": "PasswordAlgoTreeContainer",
               "itemId": "PasswordAlgoTreeContainer",
               "restURL": "/PasswordAlgo",
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
                    "itemId": "PasswordAlgoTree",
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
                         "name": "algoName",
                         "itemId": "algoName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "54022B4D-1880-4417-BEDE-9760E99EE637",
                         "minLength": "0",
                         "maxLength": "256"
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
                    "viewModel": "PasswordAlgoViewModel",
                    "xtype": "form",
                    "displayName": "Password Algo",
                    "title": "Password Algo",
                    "name": "PasswordAlgo",
                    "itemId": "PasswordAlgo",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "algorithm",
                         "itemId": "algorithm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Algorithm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Algorithm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5966D58A-3FB6-447A-B5AB-DFA4FBB881EB",
                         "minLength": "0",
                         "maxLength": "11",
                         "bind": "{algorithm}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoName",
                         "itemId": "algoName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "54022B4D-1880-4417-BEDE-9760E99EE637",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{algoName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoDescription",
                         "itemId": "algoDescription",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Description",
                         "fieldId": "F0C6CE60-E9D8-46B0-9FC1-8EB79E6A55A7",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{algoDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoIcon",
                         "itemId": "algoIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "C2F688C9-8F19-4CA7-B625-DBAE02ABAC37",
                         "minLength": "0",
                         "maxLength": "64",
                         "bind": "{algoIcon}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoHelp",
                         "itemId": "algoHelp",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Help",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Help",
                         "fieldId": "31744522-FDBD-41F9-875A-C2446B75F168",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{algoHelp}",
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
                         "customId": 393,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 393,
                              "customId": 53
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 393,
                              "customId": 54,
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
                              "parentId": 393,
                              "customId": 55,
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
                    "displayName": "Password Algo",
                    "title": "Details Grid",
                    "name": "PasswordAlgoGrid",
                    "itemId": "PasswordAlgoGrid",
                    "restURL": "/PasswordAlgo",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Algo Id",
                         "dataIndex": "algoId",
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
                         "header": "Algorithm",
                         "dataIndex": "algorithm",
                         "flex": 1
                    }, {
                         "header": "Name",
                         "dataIndex": "algoName",
                         "flex": 1
                    }, {
                         "header": "Description",
                         "dataIndex": "algoDescription",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "algoIcon",
                         "flex": 1
                    }, {
                         "header": "Help",
                         "dataIndex": "algoHelp",
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
               "viewModel": "PasswordAlgoViewModel",
               "xtype": "form",
               "displayName": "Password Algo",
               "title": "Password Algo",
               "name": "PasswordAlgo",
               "itemId": "PasswordAlgo",
               "bodyPadding": 10,
               "items": [{
                    "name": "algorithm",
                    "itemId": "algorithm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Algorithm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Algorithm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5966D58A-3FB6-447A-B5AB-DFA4FBB881EB",
                    "minLength": "0",
                    "maxLength": "11",
                    "bind": "{algorithm}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoName",
                    "itemId": "algoName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "54022B4D-1880-4417-BEDE-9760E99EE637",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{algoName}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoDescription",
                    "itemId": "algoDescription",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Description",
                    "fieldId": "F0C6CE60-E9D8-46B0-9FC1-8EB79E6A55A7",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{algoDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoIcon",
                    "itemId": "algoIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "C2F688C9-8F19-4CA7-B625-DBAE02ABAC37",
                    "minLength": "0",
                    "maxLength": "64",
                    "bind": "{algoIcon}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoHelp",
                    "itemId": "algoHelp",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Help",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Help",
                    "fieldId": "31744522-FDBD-41F9-875A-C2446B75F168",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{algoHelp}",
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
                    "customId": 393,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 393,
                         "customId": 53
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 393,
                         "customId": 54,
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
                         "parentId": 393,
                         "customId": 55,
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