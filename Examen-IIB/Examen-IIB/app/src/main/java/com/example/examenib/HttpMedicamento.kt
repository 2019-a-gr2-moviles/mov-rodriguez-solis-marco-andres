package com.example.examenib

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

class HttpMedicamento {
    var url = MainActivity.url

    fun getAll() {
        var currentUrl = "$url/Medicamento"

        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex =result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        try {
                            val aux = Klaxon().parseArray<Paciente>(data)
                            Paciente.listaPaciente = aux!!.toCollection(ArrayList())
                            Medicamento.insertIntoList()
                        }catch (e : Exception){
                            Log.i("http", "Error buscando paciente: $e")
                        }
                    }
                }
            }
    }

    fun new(body : Parameters, indexPaciente : Int){
        var currentUrl = "$url/Medicamento"

        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http", "Error : $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        val nuevoMedicamento = Klaxon().parse<Medicamento>(data)
                        if (nuevoMedicamento != null) {
                            Paciente.listaPaciente[indexPaciente].medicamentos.add(nuevoMedicamento)
                            Medicamento.listaMedicamento.add(nuevoMedicamento to indexPaciente)
                        }
                    }
                }
            }
    }

    fun update(body: Parameters, id: Int){
        var currentUrl = "$url/Medicamento/$id"

        currentUrl
            .httpPut(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var nuevoPaciente = Klaxon().parse<Medicamento>(data)
                        if(nuevoPaciente != null){
                            Paciente.initializeList()
                        }
                    }
                }
            }
    }

    fun delete(id : Int){
        var currentUrl = "$url/Medicamento/$id"

        currentUrl
            .httpDelete()
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var nuevoPaciente = Klaxon().parse<Medicamento>(data)
                        if(nuevoPaciente != null){
                            Paciente.initializeList()
                        }
                    }
                }
            }
    }
}