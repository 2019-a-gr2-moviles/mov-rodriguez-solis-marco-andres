/**
 * Heroe.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string',
      required: true,
      minLength: 5,
      maxLength: 50
    },

    tipo:{
      type: 'string',
      required: true,
      minLength: 5,
      maxLength: 30
    },

    rol_principal:{
      type: 'string',
      required: true,
      minLength: 5,
      maxLength: 20
    },

    habilidad_final:{
      type: 'string',
      required: true,
      minLength: 5,
      maxLength: 60
    },

    itemizacionHeroe:{
      collection: 'itemPorHeroe',
      via:'id_heroe'
    }


  },

};

