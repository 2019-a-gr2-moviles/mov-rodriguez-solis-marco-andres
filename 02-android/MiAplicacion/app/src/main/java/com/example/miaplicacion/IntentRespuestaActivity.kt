package com.example.miaplicacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*
import kotlinx.android.synthetic.main.content_main.*

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)

        btn_enviar_intent_respuesta.setOnClickListener{
            enviarIntentRepuesta()
        }

        btn_enviar_respuesta_propia.setOnClickListener {
            enviarIntentRespuestaPropia()
        }
    }

    fun enviarIntentRespuestaPropia(){
        val intentPropio = Intent(
            this,
            ResultadoPropioActivity::class.java
        )
        this.startActivityForResult(intentPropio, 305)
    }

    fun enviarIntentRepuesta(){
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        this.startActivityForResult(intentConRespuesta, 304)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            RESULT_OK ->{
                Log.i("intent-respuesta","LO LOGRAMOS ${Activity.RESULT_OK}")

                when(requestCode){
                    304 -> {
                        Log.i("intent-resúesta", "CONTACTO LLEGÓ")

                        val uri = data?.data
                        var cursor = contentResolver.query(uri,null,null,null,null)

                        cursor.moveToFirst()

                        val indiceTelefono = cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )

                        val telefono = cursor.getString(indiceTelefono)

                        Log.i("intent-respuesta","El telefono es: $telefono")
                    }

                    305 ->{
                        val nombre = data?.getStringExtra("nombreUsuario")
                        val edad = data?.getIntExtra("edadUsuario",0)

                        Log.i("intent-respuesta","Nombre: $nombre Edad: $edad")
                    }
                }
            }
            RESULT_CANCELED -> {
                Log.i("intent-respuesta","NO ESCOGIO")
            }
        }
    }
}
