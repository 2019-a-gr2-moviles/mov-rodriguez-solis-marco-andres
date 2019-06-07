package com.example.miaplicacion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recicler_view.*
import kotlinx.android.synthetic.main.layout.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
        val recycler_view = rv_personas
        val actividad = this

        lista.add(Persona("Marco", "1722648217"))
        lista.add(Persona("Andrés", "17226483434"))
        lista.add(Persona("Rodrigo", "1722644545"))

        val adapatadorPersona = AdaptadorPersona(lista, actividad, recycler_view)

        rv_personas.adapter = adapatadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(this)

        adapatadorPersona.notifyDataSetChanged()
    }


}
