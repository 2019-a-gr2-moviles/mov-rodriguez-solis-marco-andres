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
