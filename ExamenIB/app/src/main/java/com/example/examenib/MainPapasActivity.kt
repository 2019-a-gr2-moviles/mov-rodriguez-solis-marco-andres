package com.example.examenib

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main_papas.*

class MainPapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_papas)

        val n = intent.getIntExtra("forSnack",0)
        Log.i("snack", "$n")
        when (n) {
            1 -> {
                Snackbar.make(paciente_layout, "${Usuario.nombre} ${getString(R.string.eliminar_paciente)}", Snackbar.LENGTH_LONG)
                    .show()
                Log.i("snack", "insert")
            }
            0 -> Log.i("snack", "no")
        }

        btn_gestionar_paciente.setOnClickListener{
            irAListViewPacientes()
        }

        btn_crear_medicamentos.setOnClickListener{
            irACrearPaciente()
        }

    }
    fun irAListViewPacientes(){
        val intent = Intent(
            this,
            ListViewPapasActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irACrearPaciente(){
        val intent = Intent(
            this,
            CrearPacientesActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
