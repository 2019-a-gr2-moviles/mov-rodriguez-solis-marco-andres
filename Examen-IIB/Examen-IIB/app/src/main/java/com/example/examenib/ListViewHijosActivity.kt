package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_list_view_hijos.*

class ListViewHijosActivity : AppCompatActivity() {

    val namesList = arrayListOf<String>()

//    override fun onResume() {
//        super.onResume()
//
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_hijos)
        Log.i("http", "Error:!!!!!!!!!!!!!!!!11")
        val n = intent.getIntExtra("idPaciente", 0)
        getAll(n)
    }

    fun getAll(idPaciente: Int) {
        var currentUrl = "${MainActivity.url}/Medicamento?idPaciente=$idPaciente"

        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        val aux = Klaxon().parseArray<Medicamento>(data)

                        runOnUiThread {
                            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, aux)
                            lv_hijos.adapter = adapter
                            lv_hijos.onItemClickListener =
                                AdapterView.OnItemClickListener { parent, view, position, id ->
                                    var index = aux!![position].id
                                    Log.i("http", "ovy ajajaja $index , $idPaciente")
                                    goToIngredientDetail(index, idPaciente)


                                }
                        }
//                        try {
//                            val aux = Klaxon().parseArray<Paciente>(data)
//                            Paciente.listaPaciente = aux!!.toCollection(ArrayList())
//                            Medicamento.insertIntoList()
//                        }catch (e : Exception){
//                            Log.i("http", "Error buscando paciente: $e")
//                        }
                    }
                }
            }
    }

    fun initList(idPaciente: Int) {
        namesList.clear()
        val medicamentos = Paciente.listaPaciente[idPaciente].medicamentos
        medicamentos.forEach {
            namesList.add(it.nombre)
        }
        refreshList(idPaciente)
    }

    fun refreshList(idPaciente: Int) {
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

    fun goToIngredientDetail(position: Int, idPaciente: Int) {
        val intent = Intent(
            this,
            CrudHijosActivity::class.java
        )
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("medicamento", position)
        intent.putExtra("idPaciente", idPaciente)
        startActivity(intent)
        finish()
    }
}
