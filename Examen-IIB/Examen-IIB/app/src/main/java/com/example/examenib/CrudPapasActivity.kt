package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_crud_papas.*


class CrudPapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_papas)

        val n = intent.getIntExtra("idPaciente",0)
        fillPage(n)

        btn_eliminar_paciente.setOnClickListener {
            Paciente.delete(Paciente.listaPaciente[n].id)
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.eliminar_paciente)}", Snackbar.LENGTH_LONG).show()
        }
        btn_actualizar_paciente.setOnClickListener {
            actualizarPaciente(n)
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.actualizar_paciente)}", Snackbar.LENGTH_LONG).show()
        }
        btn_crear_medicamentos.setOnClickListener {
            irACrearmedicamentos(n)
        }
        btn_gestionar_medicamento.setOnClickListener {
            irAListaHijos(n)
        }
    }

    fun eliminarPaciente(n : Int){
        Paciente.listaPaciente.removeAt(n)
        //goToManage(2)
    }

    fun actualizarPaciente(n : Int){
        var paciente = listOf(
            "nombre" to txt_crud_paciente_nombre.text.toString(),
            "apellido" to txt_crud_paciente_apellido.text.toString(),
            "fechaNacimiento" to txt_crud_fecha_paciente.text.toString(),
            "hijos" to txt_crud_hijos_paciente.text.toString().toInt(),
            "tieneSeguro" to checkBox.isChecked
        )
        Paciente.update(paciente, Paciente.listaPaciente[n].id)

    }


    fun irACrearmedicamentos(from: Int){
        val intent = Intent(
            this,
            CrearMedicamentosActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idPaciente", from)
        startActivity(intent)
    }

    fun irAListaHijos(from: Int){
        Log.i("http", "Error: llegue intent")
        val intent = Intent(
            this,
            ListViewHijosActivity :: class.java
        )
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("idPaciente", from)
        startActivity(intent)
    }

    fun fillPage(n : Int){
        val paciente = Paciente.listaPaciente[n]
        txt_crud_paciente_nombre.setText(paciente.nombre)
        txt_crud_paciente_apellido.setText(paciente.apellido)
        txt_crud_fecha_paciente.setText(paciente.fechaNacimiento)
        txt_crud_hijos_paciente.setText(""+paciente.hijos)
        checkBox.isChecked = paciente.tieneSeguro
    }
}
