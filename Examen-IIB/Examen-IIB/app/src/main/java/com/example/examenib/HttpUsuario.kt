package com.example.examenib

import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class HttpUsuario {

    var url = MainActivity.url

    fun nuevoUsuario(body : Parameters){
        var currentUrl = "$url/Usuario"
        currentUrl
            .httpPost(body)
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var user = Klaxon().parse<Usuario>(data)
                        Usuario.nombre = user!!.nombre
                    }
                }
            }
    }
}