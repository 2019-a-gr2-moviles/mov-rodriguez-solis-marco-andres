/**
 * Empresa.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string'
    },

    usuariosDeEmpresa: { // Nombre de atributo de la relacion
      collection: 'usuario', // Nombre del modelo a relacionar
      via: 'fk_Empresa' // Nombre del atributo foreign key del otro modelo
    }
  },

};

