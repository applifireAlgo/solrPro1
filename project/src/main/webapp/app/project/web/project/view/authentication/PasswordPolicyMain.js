Ext.define('Project.project.web.project.view.authentication.PasswordPolicyMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PasswordPolicyMainController",
     "restURL": "/PasswordPolicy",
     "defaults": {
          "split": true
     },
     "requires": ["Project.project.shared.project.model.authentication.PasswordPolicyModel", "Project.project.web.project.controller.authentication.PasswordPolicyMainController", "Project.project.shared.project.viewmodel.authentication.PasswordPolicyViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "Password Policy",
               "name": "PasswordPolicyTreeContainer",
               "itemId": "PasswordPolicyTreeContainer",
               "restURL": "/PasswordPolicy",
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
                    "itemId": "PasswordPolicyTree",
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
                         "name": "policyName",
                         "itemId": "policyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "BBF33F5A-40A1-4999-B80A-83DEFD8A6705",
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
                    "viewModel": "PasswordPolicyViewModel",
                    "xtype": "form",
                    "displayName": "Password Policy",
                    "title": "Password Policy",
                    "name": "PasswordPolicy",
                    "itemId": "PasswordPolicy",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "policyName",
                         "itemId": "policyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BBF33F5A-40A1-4999-B80A-83DEFD8A6705",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{policyName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "policyDescription",
                         "itemId": "policyDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "policyDescription",
                         "margin": "5 5 5 5",
                         "fieldLabel": "policyDescription",
                         "fieldId": "13AA8A32-6490-476D-85DE-8A100C5650E7",
                         "bind": "{policyDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "maxPwdLength",
                         "itemId": "maxPwdLength",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "maxPwdLength",
                         "margin": "5 5 5 5",
                         "fieldLabel": "maxPwdLength",
                         "fieldId": "0C12D89C-4C85-40A6-AFD0-AD5BECA856D7",
                         "minValue": "0",
                         "maxValue": "32",
                         "bind": "{maxPwdLength}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minPwdLength",
                         "itemId": "minPwdLength",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minPwdLength",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minPwdLength<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "DDB3ED6E-FC8B-4E87-9B82-5DD3083B6E8F",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minPwdLength}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minCapitalLetters",
                         "itemId": "minCapitalLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minCapitalLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minCapitalLetters",
                         "fieldId": "8024C424-7AFF-4B95-A16F-CE7A312CFEC4",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minCapitalLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minSmallLetters",
                         "itemId": "minSmallLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minSmallLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minSmallLetters",
                         "fieldId": "2DDEE4AC-AFCC-4156-8D04-4D641C87BFC9",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minSmallLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minNumericValues",
                         "itemId": "minNumericValues",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minNumericValues",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minNumericValues",
                         "fieldId": "EACD4829-6499-4742-AA30-858DF6922432",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minNumericValues}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minSpecialLetters",
                         "itemId": "minSpecialLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minSpecialLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minSpecialLetters",
                         "fieldId": "6E19444B-A0D0-4011-B0D4-DF50B2C21FD9",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minSpecialLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "allowedSpecialLetters",
                         "itemId": "allowedSpecialLetters",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "allowedSpecialLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "allowedSpecialLetters",
                         "fieldId": "4C42AA8E-84D6-4907-916C-1FC13F1DFE57",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{allowedSpecialLetters}",
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
                         "customId": 470,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 470,
                              "customId": 835
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 470,
                              "customId": 836,
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
                              "parentId": 470,
                              "customId": 837,
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
                    "displayName": "Password Policy",
                    "title": "Details Grid",
                    "name": "PasswordPolicyGrid",
                    "itemId": "PasswordPolicyGrid",
                    "restURL": "/PasswordPolicy",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Policy Id",
                         "dataIndex": "policyId",
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
                         "header": "Name",
                         "dataIndex": "policyName",
                         "flex": 1
                    }, {
                         "header": "policyDescription",
                         "dataIndex": "policyDescription",
                         "flex": 1
                    }, {
                         "header": "maxPwdLength",
                         "dataIndex": "maxPwdLength",
                         "flex": 1
                    }, {
                         "header": "minPwdLength",
                         "dataIndex": "minPwdLength",
                         "flex": 1
                    }, {
                         "header": "minCapitalLetters",
                         "dataIndex": "minCapitalLetters",
                         "flex": 1
                    }, {
                         "header": "minSmallLetters",
                         "dataIndex": "minSmallLetters",
                         "flex": 1
                    }, {
                         "header": "minNumericValues",
                         "dataIndex": "minNumericValues",
                         "flex": 1
                    }, {
                         "header": "minSpecialLetters",
                         "dataIndex": "minSpecialLetters",
                         "flex": 1
                    }, {
                         "header": "allowedSpecialLetters",
                         "dataIndex": "allowedSpecialLetters",
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
               "viewModel": "PasswordPolicyViewModel",
               "xtype": "form",
               "displayName": "Password Policy",
               "title": "Password Policy",
               "name": "PasswordPolicy",
               "itemId": "PasswordPolicy",
               "bodyPadding": 10,
               "items": [{
                    "name": "policyName",
                    "itemId": "policyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BBF33F5A-40A1-4999-B80A-83DEFD8A6705",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{policyName}",
                    "columnWidth": 0.5
               }, {
                    "name": "policyDescription",
                    "itemId": "policyDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "policyDescription",
                    "margin": "5 5 5 5",
                    "fieldLabel": "policyDescription",
                    "fieldId": "13AA8A32-6490-476D-85DE-8A100C5650E7",
                    "bind": "{policyDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "maxPwdLength",
                    "itemId": "maxPwdLength",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "maxPwdLength",
                    "margin": "5 5 5 5",
                    "fieldLabel": "maxPwdLength",
                    "fieldId": "0C12D89C-4C85-40A6-AFD0-AD5BECA856D7",
                    "minValue": "0",
                    "maxValue": "32",
                    "bind": "{maxPwdLength}",
                    "columnWidth": 0.5
               }, {
                    "name": "minPwdLength",
                    "itemId": "minPwdLength",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minPwdLength",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minPwdLength<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "DDB3ED6E-FC8B-4E87-9B82-5DD3083B6E8F",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minPwdLength}",
                    "columnWidth": 0.5
               }, {
                    "name": "minCapitalLetters",
                    "itemId": "minCapitalLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minCapitalLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minCapitalLetters",
                    "fieldId": "8024C424-7AFF-4B95-A16F-CE7A312CFEC4",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minCapitalLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "minSmallLetters",
                    "itemId": "minSmallLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minSmallLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minSmallLetters",
                    "fieldId": "2DDEE4AC-AFCC-4156-8D04-4D641C87BFC9",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minSmallLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "minNumericValues",
                    "itemId": "minNumericValues",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minNumericValues",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minNumericValues",
                    "fieldId": "EACD4829-6499-4742-AA30-858DF6922432",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minNumericValues}",
                    "columnWidth": 0.5
               }, {
                    "name": "minSpecialLetters",
                    "itemId": "minSpecialLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minSpecialLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minSpecialLetters",
                    "fieldId": "6E19444B-A0D0-4011-B0D4-DF50B2C21FD9",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minSpecialLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "allowedSpecialLetters",
                    "itemId": "allowedSpecialLetters",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "allowedSpecialLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "allowedSpecialLetters",
                    "fieldId": "4C42AA8E-84D6-4907-916C-1FC13F1DFE57",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{allowedSpecialLetters}",
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
                    "customId": 470,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 470,
                         "customId": 835
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 470,
                         "customId": 836,
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
                         "parentId": 470,
                         "customId": 837,
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