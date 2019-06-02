package com.example.examenib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crear_medicamentos.*

class CrearMedicamentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_medicamentos)
        val n = intent.getIntExtra("idPaciente", 0)
        btn_guardar_medicamento.setOnClickListener{
            crearMedicamento(n)
            Snackbar.make(it, "${Usuario.nombre} ${getString(R.string.insertar)}", Snackbar.LENGTH_LONG).show()
        }
    }

    fun crearMedicamento(n : Int){
        val gramos = txt_gramos.text.toString()
        val nombreMedicamento = txt_nombre_medicamento.text.toString()
        val composicion = txt_composicion.text.toString()
        val uso = txt_usado.text.toString()
        val fechaCaducidad = txt_caducidad.text.toString()
        val numeroPastillas = txt_numero_pastilla.text.toString().toInt()
        Medicamento.listaMedicamento.add(Medicamento(gramos,nombreMedicamento,composicion,uso,fechaCaducidad,numeroPastillas,
            Paciente.listaPaciente[n]))
    }
}
