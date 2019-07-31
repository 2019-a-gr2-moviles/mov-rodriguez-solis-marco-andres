/**
 * Medicamento.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    gramosAIngerir: {
      
      type: 'number'
    
    },

    nombre: {
      type: 'string'
    
    },

    composicion: {
      type: 'string'
  
    },

    usadoPara: {
      type: 'string'

    },

    fechaCaducidad: {
 
      type: 'string'
    },

    numeroPastillas: {

      type: 'number'
 
    },
    
    latitud: {
      type: 'string'
    },

    longitud: {
      type: 'string'
    },
    
    paciente_fk: {         
      model: 'Paciente'  
    }

  },

};

