package com.example.contactos

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.support.design.widget.Snackbar

class AdaptadorPersona(private val listaContactos: List<Contacto>,
                       private val contexto: ReciclerViewActivity,
                       private val recyclerView: RecyclerView):RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var nombreTextView: TextView
        var accionBoton: ImageButton

        init{


            nombreTextView = view.findViewById(R.id.txt_view_nombre) as TextView
            accionBoton = view.findViewById(R.id.btn_enviar_mensaje) as ImageButton

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout
            layout.setOnClickListener {
                Log.i("recycler-view","Layout presionado")
            }

            accionBoton.setOnClickListener {
                Snackbar.make(it, "Envió el mensaje", Snackbar.LENGTH_LONG).show()
                contexto.irAMensaje()

            }

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorPersona.MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.layout, p0,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorPersona.MyViewHolder, position: Int) {
        val contacto = listaContactos[position]

        myViewHolder.nombreTextView.text = contacto.nombre

    }

}