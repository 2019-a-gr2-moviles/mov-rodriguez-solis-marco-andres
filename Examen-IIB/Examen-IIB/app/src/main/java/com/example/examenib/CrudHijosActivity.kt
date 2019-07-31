package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_crear_medicamentos.*
import kotlinx.android.synthetic.main.activity_crud_hijos.*
import kotlinx.android.synthetic.main.activity_list_view_hijos.*

class CrudHijosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_hijos)
        val idMedicamento = intent.getIntExtra("medicamento", 0)
        val idPaciente = intent.getIntExtra("idPaciente", 0)
        Log.i("http", "datos $idMedicamento , $idPaciente")
        if(idPaciente==0){

        }
        cargarMedicamento(idMedicamento)
      //  fillPage(n, idPaciente)
        btn_eliminar_medicamento.setOnClickListener {
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.eliminar_medicamento)}", Snackbar.LENGTH_LONG).show()
            eliminarMedicamento(idMedicamento, idPaciente)
        }
        btn_actualizar_medicamento.setOnClickListener {
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.actualizar_medicamento)}", Snackbar.LENGTH_LONG).show()
            actualizarMedicamento(idMedicamento, idPaciente)
        }
    }

    fun cargarMedicamento(idMedicamento: Int){
        var currentUrl = "${MainActivity.url}/Medicamento?id=$idMedicamento"

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
                        var medicamento= aux!![0]
                        Log.i("http", "Mi medicamento: $medicamento")

                        runOnUiThread {
                            txt_gramos_crud.setText(""+medicamento.gramosAIngerir)
                            txt_nombre_medicamento_crud.setText(medicamento.nombre)
                            txt_composicion_crud.setText(medicamento.composicion)
                            txt_uso_crud.setText(medicamento.usadoPara)
                            txt_caducidad_crud.setText(medicamento.fechaCaducidad)
                            txt_pastillas_crud.setText(""+ medicamento.numeroPastillas)
                            txt_latitud_crud.setText(medicamento.latitud)
                            txt_longitud_crud.setText(medicamento.longitud)
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

    fun irAListaHijos(from: Int){
        val intent = Intent(
            this,
            ListViewHijosActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idPaciente", from)
        startActivity(intent)
    }

    fun eliminarMedicamento(idMedicamento: Int, idPaciente :Int){
        var currentUrl = "${MainActivity.url}/Medicamento/$idMedicamento"

        currentUrl
            .httpDelete()
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
//                        var nuevoPaciente = Klaxon().parse<Medicamento>(data)
//                        if(nuevoPaciente != null){
//                            Paciente.initializeList()
//                        }
                    }
                }
            }
    }

    fun actualizarMedicamento(idMedicamento: Int, idPaciente: Int){

        val body = listOf(
            "gramosAIngerir" to txt_gramos_crud.text.toString().toInt(),
            "nombre" to txt_nombre_medicamento_crud.text.toString(),
            "composicion" to txt_composicion_crud.text.toString(),
            "usadoPara" to txt_uso_crud.text.toString(),
            "fechaCaducidad" to txt_caducidad_crud.text.toString(),
            "numeroPastillas" to txt_pastillas_crud.text.toString().toInt(),
            "latitud" to txt_latitud_crud.text.toString(),
            "longitud" to txt_longitud_crud.text.toString(),
            "idPaciente" to idPaciente
        )

        var currentUrl = "${MainActivity.url}/Medicamento/$idMedicamento"
        Log.i("http", "Body: $body")
        currentUrl
            .httpPut(body)
            .responseString{ request, response, result ->
                when(result) {
                    is Result.Failure ->{
                        val error = result.getException()
                        Log.i("http", "Error: $error")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var nuevoPaciente = Klaxon().parse<Medicamento>(data)
                        if(nuevoPaciente != null){
                            Paciente.initializeList()
                        }
                    }
                }
            }

//        Medicamento.update(body,Paciente.listaPaciente[idPaciente].medicamentos[idMedicamento].id)
//        irAListaHijos(idPaciente)

    }

    fun fillPage(idMedicamento : Int, idPaciente: Int){
        val medicamento = Paciente.listaPaciente[idPaciente].medicamentos[idMedicamento]
        txt_gramos_crud.setText(""+medicamento.gramosAIngerir)
        txt_nombre_medicamento_crud.setText(medicamento.nombre)
        txt_composicion_crud.setText(medicamento.composicion)
        txt_uso_crud.setText(medicamento.usadoPara)
        txt_caducidad_crud.setText(medicamento.fechaCaducidad)
        txt_pastillas_crud.setText(""+ medicamento.numeroPastillas)
        txt_latitud_crud.setText(medicamento.latitud)
        txt_longitud_crud.setText(medicamento.longitud)
    }
}
