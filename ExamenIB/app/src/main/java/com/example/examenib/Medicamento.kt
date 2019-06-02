package com.example.examenib


class Medicamento(var gramos: String,
                  var nombreMedicamento: String,
                  var coomposicion:String,
                  var uso:String,
                  var fechaCaducidad: String,
                  var numeroPastillas:Int,
                  var paciente: Paciente) {
    companion object{
        val listaMedicamento = arrayListOf<Medicamento>(

        )
        fun busqueda(paciente: Paciente) : List<Medicamento>{
            val medicamento = listaMedicamento.filter { it.paciente == paciente }
            return medicamento
        }
    }

    fun editarMedicamento(gramos: String, nombreMedicamento: String,coomposicion: String, uso: String, fechaCaducidad: String,
                           numeroPastillas: Int){
        this.gramos = gramos
        this.nombreMedicamento = nombreMedicamento
        this.coomposicion = coomposicion
        this.uso = uso
        this.fechaCaducidad = fechaCaducidad
        this.numeroPastillas = numeroPastillas
    }

}