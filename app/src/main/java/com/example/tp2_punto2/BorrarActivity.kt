package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BorrarActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.borrar)
        ciudadDBHELPER = miSQLiteHelper(this)


        var btnBorrar =  findViewById<Button>(R.id.btnBorrar)
        var ciudad = findViewById<TextView>(R.id.ciudad)
        ciudad.visibility = View.GONE
        btnBorrar.visibility=View.GONE



        var btnConsulta = findViewById<Button>(R.id.btnConsultar)
        btnConsulta.setOnClickListener{
            findViewById<TextView>(R.id.ciudad_consulta).visibility=View.GONE
            var consulta = findViewById<TextView>(R.id.ciudad_consulta).text.toString()
            val datalist = ciudadDBHELPER.buscarPorCiudad(consulta)
            if (datalist != null){

                btnConsulta.visibility=View.GONE
                btnBorrar.visibility=View.VISIBLE
                ciudad.visibility=View.VISIBLE

                findViewById<TextView>(R.id.ciudad).text = "Ciudad a borrar:  " + datalist[0] as String
                btnBorrar.setOnClickListener{
                    val delete = ciudadDBHELPER.deleteCiudad(consulta)
                    if (delete)
                        {
                            Toast.makeText(this, "Se ha borrado la ciudad " +consulta,Toast.LENGTH_LONG).show()
                            finish()
                        }
                        else
                        {
                            Toast.makeText(this, "No se ha borrado la ciudad" +consulta,Toast.LENGTH_LONG).show()
                        }
                }
            }
            else
            {
                Toast.makeText(this, "No se encontro la capital", Toast.LENGTH_SHORT).show()
            }
        }
    }
}