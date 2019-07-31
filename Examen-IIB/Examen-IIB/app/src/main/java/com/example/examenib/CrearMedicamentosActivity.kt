package com.example.examenib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
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
        val medicamento = listOf(
            "gramosAIngerir" to txt_gramos.text.toString().toInt(),
            "nombre" to txt_nombre_medicamento.text.toString(),
            "composicion" to txt_composicion.text.toString(),
            "usadoPara" to txt_usado.text.toString(),
            "fechaCaducidad" to txt_caducidad.text.toString(),
            "numeroPastillas" to txt_numero_pastilla.text.toString().toInt(),
            "latitud" to txt_latitud.text.toString(),
            "longitud" to txt_longitud.text.toString(),
            "idPaciente" to Paciente.listaPaciente[n].id
        )
        Medicamento.add(medicamento, n)


    }
}
