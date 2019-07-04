package com.example.miaplicacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        btn_devolver_respuesta.setOnClickListener {
            devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val nombre = "Marco"
        val edad = 23

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("mombreUsuario",nombre)
        intentRespuesta.putExtra("edadUsuario",edad)

        this.setResult(RESULT_OK, //Podemos enviar RESULT_OK o RESULT_CANCELED
            intentRespuesta)

        this.finish()
    }
}
