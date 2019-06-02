package com.example.examenib

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crud_papas.*

class CrudPapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_papas)

        val n = intent.getIntExtra("idPaciente",0)
        fillPage(n)
        btn_eliminar_paciente.setOnClickListener {
            eliminarPaciente(n)
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
        Paciente.listaPaciente[n].editarPaciente(
            txt_crud_paciente_nombre.text.toString(),
            txt_crud_paciente_apellido.text.toString(),
            txt_crud_fecha_paciente.text.toString(),
            txt_crud_hijos_paciente.text.toString().toInt(),
            checkBox.isChecked
        )
        //goToManage(3)
    }

    fun irALista(from : Int){
        val intent = Intent(
            this,
            ListViewPapasActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("forSnack", from)
        startActivity(intent)
    }

    fun irACrearmedicamentos(from: Int){
        val intent = Intent(
            this,
            CrearMedicamentosActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("foodID", from)
        startActivity(intent)
    }

    fun irAListaHijos(from: Int){
        val intent = Intent(
            this,
            ListViewHijosActivity :: class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("foodID", from)
        startActivity(intent)
    }

    fun fillPage(n : Int){
        val paciente = Paciente.listaPaciente[n]
        txt_crud_paciente_nombre.setText(paciente.nombrePaciente)
        txt_crud_paciente_apellido.setText(paciente.apellidoPaciente)
        txt_crud_fecha_paciente.setText(paciente.fechaDeNacimiento)
        txt_crud_hijos_paciente.setText(""+paciente.hijos)
        checkBox.isChecked = paciente.seguro
    }
}
