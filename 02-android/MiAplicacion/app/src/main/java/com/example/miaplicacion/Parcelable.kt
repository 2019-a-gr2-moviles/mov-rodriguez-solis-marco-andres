package com.example.miaplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)


        val marco: Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")
        val cachetes: Mascota? = this.intent.getParcelableExtra<Mascota>("mascota")

        Log.i("parcelable", "Nombre: ${marco?.nombre}")
        Log.i("parcelable", "Edad: ${marco?.edad}")
        Log.i("parcelable", "Fecha: ${marco?.fechaNacimiento.toString()}")
        Log.i("parcelable", "Sueldo: ${marco?.sueldo}")

        Log.i("parcelable", "NombreMascota: ${cachetes?.nombre}")
        Log.i("parcelable", "Dueño: ${cachetes?.dueño?.nombre}")

        btn_menu.setOnClickListener{
            regresarMenu()
        }
    }

    fun regresarMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )

        startActivity(intentExplicito)
    }

}
