package com.example.examenib

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crear_pacientes.*

class CrearPacientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_pacientes)

        btn_crear_paciente.setOnClickListener{
            crearPaciente()
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.insertar_paciente)}", Snackbar.LENGTH_LONG).show()

        }
    }

    fun crearPaciente(){
        val nombrePaciente = txt_nombre_paciente.text.toString()
        val apellidoPaciente = txt_apellido_paciente.text.toString()
        val fechaDeNacimiento = txt_fecha_nacimiento_paciente.text.toString()
        val hijos = txt_hijos.text.toString().toInt()
        val seguro =  btn_seguro.isChecked
        Paciente.listaPaciente.add(Paciente(nombrePaciente,apellidoPaciente,fechaDeNacimiento,hijos,seguro))
      /*  val intent = Intent(
            this,
            MainPapasActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)*/
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
