package com.example.examenib

import com.github.kittinunf.fuel.core.Parameters

class Paciente (var id: Int,
                var nombre: String,
                var apellido: String,
                var fechaNacimiento: String,
                var hijos: Int,
                var tieneSeguro: Boolean,
                var medicamentos: ArrayList<Medicamento>) {
    override fun toString():String{
        return this.nombre
    }

    companion object{
        var listaPaciente = arrayListOf<Paciente>(

        )
        var adapter = HttpPaciente()

        fun add(body : Parameters){
            adapter.new(body)
        }

        fun initializeList (){
            adapter.getAll()
        }

        fun delete(id : Int){
            adapter.delete(id)
        }

        fun update(body : Parameters, id : Int){
            adapter.edit(body,id)
        }

    }
}