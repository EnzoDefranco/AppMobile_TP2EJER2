package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.view.View

import android.widget.TextView
import android.widget.Toast

class ModificarActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar)
        ciudadDBHELPER = miSQLiteHelper(this)
        var btnModificar = findViewById<Button>(R.id.btnModificar)

        btnModificar.setOnClickListener{
            val ciudad = findViewById<TextView>(R.id.ciudad_consulta).text.toString()
            val poblacion = findViewById<TextView>(R.id.poblacion_consulta).text.toString().toInt()
            if (ciudad.isNotEmpty() && poblacion >= 0){
                val mod = ciudadDBHELPER.modificarPoblacion(ciudad, poblacion)
                if (mod){
                    Toast.makeText(this, "La poblacion de la ciudad "+ciudad+" ha sido modificada", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "La ciudad ingresada no existe", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }




    }
}