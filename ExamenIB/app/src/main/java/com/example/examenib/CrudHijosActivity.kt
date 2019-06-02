package com.example.examenib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crud_hijos.*

class CrudHijosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_hijos)
        val n = intent.getIntExtra("ingredient", 0)
        val foodID = intent.getIntExtra("foodID", 0)
        fillPage(n, foodID)
        btn_eliminar_medicamento.setOnClickListener {
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.eliminar_medicamento)}", Snackbar.LENGTH_LONG).show()
            eliminarMedicamento(n, foodID)
        }
        btn_actualizar_medicamento.setOnClickListener {
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.actualizar_medicamento)}", Snackbar.LENGTH_LONG).show()
            actualizarMedicamento(n, foodID)
        }
    }

    fun eliminarMedicamento(idMedicamento: Int, idPaciente :Int){
        Medicamento.listaMedicamento.remove(Medicamento.busqueda(Paciente.listaPaciente[idPaciente])[idMedicamento])
    }

    fun actualizarMedicamento(idMedicamento: Int, idPaciente: Int){
        val gramos = txt_gramos_crud.text.toString()
        val nombreMedicamento = txt_nombre_medicamento_crud.text.toString()
        val composicion = txt_composicion_crud.text.toString()
        val uso = txt_uso_crud.text.toString()
        val fecha = txt_caducidad_crud.text.toString()
        val pastillas = txt_pastillas_crud.text.toString().toInt()
        Medicamento.busqueda(Paciente.listaPaciente[idPaciente])[idMedicamento].editarMedicamento(gramos, nombreMedicamento,
            composicion, uso , fecha, pastillas)
    }

    fun fillPage(idMedicamento : Int, idPaciente: Int){
        val medicamento = Medicamento.busqueda(Paciente.listaPaciente[idPaciente])[idMedicamento]
        txt_gramos_crud.setText(""+medicamento.gramos)
        txt_nombre_medicamento_crud.setText(medicamento.nombreMedicamento)
        txt_composicion_crud.setText(medicamento.coomposicion)
        txt_uso_crud.setText(medicamento.uso)
        txt_caducidad_crud.setText(medicamento.fechaCaducidad)
        txt_pastillas_crud.setText(""+ medicamento.numeroPastillas)
    }
}
