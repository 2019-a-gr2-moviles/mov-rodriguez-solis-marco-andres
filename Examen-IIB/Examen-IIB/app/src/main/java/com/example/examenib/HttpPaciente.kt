package com.example.examenib

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.*
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.result.Result

class HttpPaciente {
    val url = MainActivity.url

    fun getAll() {
        var currentUrl = "$url/Paciente"

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

    fun new(body : Parameters){
        var currentUrl = "$url/Paciente"

        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var nuevoPaciente = Klaxon().parse<Paciente>(data)
                        Paciente.listaPaciente.add(nuevoPaciente!!)
                    }
                }
            }
    }

    fun edit(body: Parameters, id: Int){
        var currentUrl = "$url/Paciente/$id"

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
                        var nuevoPaciente = Klaxon().parse<Paciente>(data)
                        if(nuevoPaciente != null){
                            Paciente.initializeList()
                        }
                    }
                }
            }
    }

    fun delete(id : Int){
        var currentUrl = "$url/Paciente/$id"

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
                        var nuevoPaciente = Klaxon().parse<Paciente>(data)
                        if(nuevoPaciente != null){
                            Paciente.initializeList()
                        }
                    }
                }
            }
    }

}