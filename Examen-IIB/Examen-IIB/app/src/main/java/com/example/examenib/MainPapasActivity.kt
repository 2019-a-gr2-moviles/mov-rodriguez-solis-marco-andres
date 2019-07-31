package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_papas.*

class MainPapasActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_papas)


        btn_gestionar_paciente.setOnClickListener{
            irAListViewPacientes()
        }

        btn_crear_medicamentos.setOnClickListener{
            irACrearPaciente()
        }

        btn_mapa.setOnClickListener {
            irAMapa()
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

    fun irAMapa(){
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
