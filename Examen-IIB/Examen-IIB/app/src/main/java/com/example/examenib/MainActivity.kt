package com.example.examenib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        var url = "http://172.29.65.113:1337"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Paciente.initializeList()
        btn_entrar.setOnClickListener{
            irAMainPapas()
        }
    }

    fun irAMainPapas(){
        Usuario.newUser(txt_usuario.text.toString())
        val intent = Intent(
            this,
            MainPapasActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
