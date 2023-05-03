package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CargarActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cargar)
        ciudadDBHELPER = miSQLiteHelper(this)
        val btnGuardar = findViewById<Button>(R.id.guardar_button)

        var btnAtras = findViewById<Button>(R.id.atras_button)
        btnAtras.setOnClickListener {
            finish() // Cierra la actividad actual y vuelve a la anterior
        }

        btnGuardar.setOnClickListener {
            var nombre = findViewById<TextView>(R.id.ciudad_text).text.toString()
            var pais = findViewById<TextView>(R.id.pais_text).text.toString()
            var poblacion = findViewById<TextView>(R.id.poblacion_text).text.toString().toInt()
            val datalist = ciudadDBHELPER.buscarPorCiudad(nombre)
            if (datalist == null) {
                var datos = ciudadDBHELPER.agregarCiudad(nombre, pais, poblacion)
                if (datos) {
                    Toast.makeText(this, "Se guardaron los datos", Toast.LENGTH_SHORT).show()
                    findViewById<TextView>(R.id.ciudad_text).setText("")
                    findViewById<TextView>(R.id.pais_text).setText("")
                    findViewById<TextView>(R.id.poblacion_text).setText("")
                } else {
                    Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Error al guardar los datos, la ciudad ya existe",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}