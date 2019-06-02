package com.example.examenib

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_hijos.*

class ListViewHijosActivity : AppCompatActivity() {

    val namesList = arrayListOf<String>()

    override fun onResume() {
        super.onResume()
        val n = intent.getIntExtra("idPaciente",0)
        initList(n)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_hijos)
    }

    fun initList(idPaciente : Int){
        namesList.clear()
        val ingredients = Medicamento.busqueda(Paciente.listaPaciente[idPaciente])
        ingredients.forEach {
            namesList.add(it.nombreMedicamento)
        }
        refreshList(idPaciente)
    }

    fun refreshList(idPaciente : Int){
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            namesList
        )
        lv_hijos.adapter = adapter
        lv_hijos.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            goToIngredientDetail(position, idPaciente)
        }
    }

    fun goToIngredientDetail(position : Int, pacienteID: Int){
        val intent = Intent(
            this,
            CrudHijosActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("medicamento", position)
        intent.putExtra("idPaciente", pacienteID)
        startActivity(intent)
    }
}
