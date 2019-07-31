package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_crear_pacientes.*

class CrearPacientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_pacientes)

        btn_crear_paciente.setOnClickListener{
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.insertar_paciente)}", Snackbar.LENGTH_LONG).show()
            crearPaciente()
        }
    }

    fun crearPaciente(){

        var lista = listOf(
            "nombre" to txt_nombre_paciente.text.toString(),
            "apellido" to txt_apellido_paciente.text.toString(),
            "fechaNacimiento" to txt_fecha_nacimiento_paciente.text.toString(),
            "hijos" to txt_hijos.text.toString().toInt(),
            "tieneSeguro" to  btn_seguro.isChecked
        )
        Paciente.add(lista)
    }

    fun irAMainPapas(){
        val intent = Intent(
            this,
            MainPapasActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("forSnack", 1)
        startActivity(intent)
    }
}
