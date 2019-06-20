package com.example.contactos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mensaje.*

class MensajeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        btn_enviar.setOnClickListener {
            irARecicler()
        }
    }

    fun irARecicler(){
        val intent = Intent(
            this,
            ReciclerViewActivity::class.java
        )
        startActivity(intent)
    }
}
