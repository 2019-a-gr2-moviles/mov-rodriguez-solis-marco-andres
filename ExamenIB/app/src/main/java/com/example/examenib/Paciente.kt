package com.example.examenib



class Paciente (var nombrePaciente: String,
                var apellidoPaciente: String,
                var fechaDeNacimiento: String,
                var hijos: Int,
                var seguro: Boolean) {

    companion object{
        val listaPaciente = arrayListOf<Paciente>(

        )
    }

    fun editarPaciente(nombrePaciente: String, apellidoPaciente: String, fechaDeNacimiento: String, hijos: Int, seguro: Boolean){
        this.nombrePaciente = nombrePaciente
        this.apellidoPaciente = apellidoPaciente
        this.fechaDeNacimiento = fechaDeNacimiento
        this.hijos = hijos
        this.seguro = seguro
    }
}