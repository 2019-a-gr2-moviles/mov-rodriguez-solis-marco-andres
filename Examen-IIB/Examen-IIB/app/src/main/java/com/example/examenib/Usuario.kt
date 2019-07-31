package com.example.examenib

class Usuario(var nombre: String) {
    companion object{
        var nombre : String = ""
        var adapter = HttpUsuario()

        fun newUser(name : String){
            var body = listOf(
                "nombre" to name
            )
            adapter.nuevoUsuario(body)
        }
    }
}