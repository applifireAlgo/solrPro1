Ext.define('Sales1.sales1.shared.sales1.model.contacts.ContactTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactTypeId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactType",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactTypeDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactTypeIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});