package com.example.miaplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad__dos.*

class Actividad_Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad__dos)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getIntExtra("edad", 0)

        Log.i("intents","Nombre: $nombre")
        Log.i("intents","Edad: $edad")

        btn_actividad_uno.setOnClickListener {
            irAActividadUno()
        }
    }

    fun irAActividadUno(){
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
    }

}
