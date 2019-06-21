package com.example.contactos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*
import kotlinx.android.synthetic.main.layout.*
import java.util.*

class ReciclerViewActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        var lista = arrayListOf<Contacto>()
        val recycler_view = rv_contactos
        val actividad = this

        lista.add(Contacto("Ana"))
        lista.add(Contacto("Benito"))
        lista.add(Contacto("Camila"))
        lista.add(Contacto("Daniel"))
        lista.add(Contacto("Fabricio"))
        lista.add(Contacto("Gabriela"))
        lista.add(Contacto("Hector"))
        lista.add(Contacto("Ignacio"))
        lista.add(Contacto("Josselyn"))
        lista.add(Contacto("Katy"))
        lista.add(Contacto("Laura"))

        iniciarRecyclerView(lista, this, rv_contactos)

    }

    fun iniciarRecyclerView(lista: List<Contacto>, actividad: ReciclerViewActivity, recycler_view: RecyclerView){

        val adapatadorPersona = AdaptadorPersona(lista, actividad, recycler_view)

        recycler_view.adapter = adapatadorPersona
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adapatadorPersona.notifyDataSetChanged()
    }

    fun irAMensaje(){
        val intent = Intent(
            this,
            MensajeActivity::class.java
        )
        startActivity(intent)
    }

    fun cambiar(texto:String){
        txt_llamando.text = texto
    }


}
