package com.example.tp2_punto2
import android.view.View
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Context

class ConsultarActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consultar)
        ciudadDBHELPER = miSQLiteHelper(this)

        findViewById<TextView>(R.id.ciudad).visibility = View.GONE
        findViewById<TextView>(R.id.pais).visibility = View.GONE
        findViewById<TextView>(R.id.poblacion).visibility = View.GONE

        var btn = findViewById<Button>(R.id.btnConsultar)
        var btnAtras = findViewById<Button>(R.id.atras_button)
        btnAtras.setOnClickListener{
            finish() // Cierra la actividad actual y vuelve a la anterior
        }
        btn.setOnClickListener{
            var consulta = findViewById<TextView>(R.id.ciudad_consulta).text.toString()
            val datalist = ciudadDBHELPER.buscarPorCiudad(consulta)
            if (datalist != null){

                findViewById<TextView>(R.id.ciudad_consulta).visibility = View.GONE
                findViewById<TextView>(R.id.ciudad).visibility = View.VISIBLE
                findViewById<TextView>(R.id.pais).visibility = View.VISIBLE
                findViewById<TextView>(R.id.poblacion).visibility = View.VISIBLE
                findViewById<TextView>(R.id.ciudad).text = "Ciudad consultada: " + datalist[0] as String
                findViewById<TextView>(R.id.pais).text = "País: " + datalist[1] as String
                findViewById<TextView>(R.id.poblacion).text = "Población aproximada: " + datalist[2].toString()
            }
            else
            {
                Toast.makeText(this, "No se encontro la capital", Toast.LENGTH_SHORT).show()
            }
        }


    }
}