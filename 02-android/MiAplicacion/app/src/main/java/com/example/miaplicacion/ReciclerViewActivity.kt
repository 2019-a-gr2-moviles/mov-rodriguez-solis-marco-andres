package com.example.miaplicacion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*
import kotlinx.android.synthetic.main.layout.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
      //  val recycler_view = rv_personas
        // val actividad = this


        lista.add(Persona("Marco", "1722648217"))
        lista.add(Persona("Andrés", "17226483434"))
        lista.add(Persona("Rodrigo", "1722644545"))

        iniciarRecyclerView(lista, this, rv_personas)

    }

    fun iniciarRecyclerView(lista: List<Persona>, actividad: ReciclerViewActivity, recycler_view: RecyclerView){

        val adapatadorPersona = AdaptadorPersona(lista, actividad, recycler_view)

        recycler_view.adapter = adapatadorPersona
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adapatadorPersona.notifyDataSetChanged()
    }

    fun cambiarNombreTextView(texto:String){
        txt_titulo_rv.text = texto
    }


}
