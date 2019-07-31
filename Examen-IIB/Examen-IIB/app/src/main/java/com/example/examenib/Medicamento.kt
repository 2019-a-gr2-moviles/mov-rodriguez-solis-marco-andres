package com.example.examenib

import com.github.kittinunf.fuel.core.Parameters

class Medicamento(var id: Int,
                  var gramosAIngerir: Int,
                  var nombre: String,
                  var composicion:String,
                  var usadoPara:String,
                  var fechaCaducidad: String,
                  var numeroPastillas:Int,
                  var latitud: String,
                  var longitud: String) {
    override fun toString():String{
        return this.nombre
    }
    companion object{
        var listaMedicamento = arrayListOf<Pair<Medicamento, Int>>(

        )

        val adapter = HttpMedicamento()

        fun add(body : Parameters, indexPaciente : Int){
            adapter.new(body, indexPaciente)
        }

        fun insertIntoList(){
            Paciente.listaPaciente.forEachIndexed { index, paciente ->
                paciente.medicamentos.forEach {
                    Medicamento.listaMedicamento.add(it to index)
                }
            }
        }

        fun update(body : Parameters, id: Int){
            adapter.update(body, id)
        }

        fun delete(id : Int){
            adapter.delete(id)
        }

    }


}