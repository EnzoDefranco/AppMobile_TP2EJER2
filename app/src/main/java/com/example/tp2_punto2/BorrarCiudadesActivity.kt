package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.view.View

import android.widget.TextView
import android.widget.Toast

class BorrarCiudadesActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.borrarciudades)

        ciudadDBHELPER = miSQLiteHelper(this)


        var btnBorrar =  findViewById<Button>(R.id.btnBorrar)
        var pais = findViewById<TextView>(R.id.pais)
        pais.visibility = View.GONE
        btnBorrar.visibility= View.GONE



        var btnConsulta = findViewById<Button>(R.id.btnConsultar)
        btnConsulta.setOnClickListener{
            findViewById<TextView>(R.id.pais_consulta).visibility= View.GONE
            var consulta = findViewById<TextView>(R.id.pais_consulta).text.toString()
            val datalist = ciudadDBHELPER.buscarPorPais(consulta)
            if (datalist != null){

                btnConsulta.visibility= View.GONE
                btnBorrar.visibility= View.VISIBLE
                pais.visibility= View.VISIBLE

                findViewById<TextView>(R.id.pais).text = "Se borrarán TODAS las ciudades del pais: " +consulta
                btnBorrar.setOnClickListener{
                    val delete = ciudadDBHELPER.deletePais(consulta)
                    if (delete)
                    {
                        Toast.makeText(this, "Se han borrado la ciudades del pais:  " +consulta, Toast.LENGTH_LONG).show()
                        finish()
                    }
                    else
                    {
                        finish()
                        Toast.makeText(this, "No se han borrado la ciudades" +consulta, Toast.LENGTH_LONG).show()
                    }
                }
            }
            else
            {
                Toast.makeText(this, "No se encontro el pais", Toast.LENGTH_SHORT).show()
                finish()
            }
        }



    }
}