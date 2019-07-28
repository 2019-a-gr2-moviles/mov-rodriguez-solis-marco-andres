/**
 * Item.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string',
      required:true,
      minLength: 5,
      maxLength: 60
    },

    descripcion:{
      type: 'string',
      required:true,
      minLength: 10,
      maxLength: 100
    },

    precio:{
      type: 'number',
      required:true,
    },

    heroeConItem:{
      collection: 'itemPorHeroe',
      via: 'id_item'
    }

  },

};

