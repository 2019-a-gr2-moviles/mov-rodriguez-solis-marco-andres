package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_papas.*

class ListViewPapasActivity : AppCompatActivity() {
    private val namesList = arrayListOf<String>()

    override fun onResume() {
        super.onResume()
        val n = intent.getIntExtra("forSnack",0)
        when (n) {
            2 -> Snackbar.make(layout, "${Usuario.nombre} ${getString(R.string.eliminar_paciente)}", Snackbar.LENGTH_LONG).show()
            3 -> Snackbar.make(layout, "${Usuario.nombre} ${getString(R.string.actualizar_paciente)}", Snackbar.LENGTH_LONG).show()
        }
        iniciarLista()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_papas)
    }

    fun irADetallePaciente(position : Int){
        val intent = Intent(
            this,
            CrudPapasActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idPaciente", position)
        startActivity(intent)
    }


    fun iniciarLista(){
        namesList.clear()
        Paciente.listaPaciente.forEach {
            namesList.add(it.nombre)
        }
        actualizarLista()
    }

    fun actualizarLista(){
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            namesList
        )
        lv_papas_medicamentos.adapter = adapter
        lv_papas_medicamentos.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            irADetallePaciente(position)
        }
    }
}
