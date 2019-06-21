package com.example.contactos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_mensaje.*
import kotlinx.android.synthetic.main.layout.*

class MensajeActivity : AppCompatActivity() {

    private lateinit var hand: Handler
    private lateinit var run: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        hand = Handler()

        btn_enviar.setOnClickListener {
            Snackbar.make(it, "Mensaje de ayuda", Snackbar.LENGTH_LONG).show()
            run = Runnable {
                irARecicler()
            }
            hand.postDelayed(run, 3000)

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
