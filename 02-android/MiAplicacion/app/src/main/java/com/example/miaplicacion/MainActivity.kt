package com.example.miaplicacion

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_actividad__dos.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        btn_actividad_dos.setOnClickListener {
            irAActividadDos()
        }

        btn_parcelable.setOnClickListener {
            irParcelable()
        }

        btn_toast.setOnClickListener{
            irToast()
        }

        btn_adapter.setOnClickListener{
            irAList()
        }
        btn_recycler.setOnClickListener {
            irARecycler()
        }

        btn_intent_respuesta.setOnClickListener {
            irAIntentRespuesta()
        }
        btn_conexion.setOnClickListener{
            irAConexion()
        }
        btn_mapa.setOnClickListener {
            irAMapa()
        }
    }

    fun irAActividadDos(){
        val intent = Intent(
            this,
            Actividad_Dos::class.java
        )
       // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        intent.putExtra("nombre", "Marco")
        intent.putExtra("edad", 22)
        startActivity(intent)
    }

    fun irParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val marco = Usuario("Marco", 22, Date(),12.12)
        intentExplicito.putExtra("usuario", marco)

        val cachetes = Mascota("Chispita", marco)
        intentExplicito.putExtra("mascota", cachetes)

        startActivity(intentExplicito)

    }

    fun irToast(){
        val intentExplicito = Intent(
            this,
            Main2Activity::class.java
        )

        startActivity(intentExplicito)
    }

    fun irAList(){
        val intentExplicito= Intent(
            this,
            ListViewActivity::class.java
        )

        startActivity(intentExplicito)
    }

    fun irARecycler(){
        val intent = Intent(
            this,
            ReciclerViewActivity::class.java
        )
        startActivity(intent)
    }

    fun irAIntentRespuesta(){
        val intentRespuesta = Intent(
            this,
            IntentRespuestaActivity::class.java
        )
        startActivity(intentRespuesta)
    }

    fun irAConexion(){
        val intentConexion = Intent(
            this,
            ConexionHTTPActivity::class.java
        )
        startActivity(intentConexion)
    }

    fun irAMapa(){
        val intentMapa = Intent(
            this,
            MapsActivity::class.java
        )
        startActivity(intentMapa)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
