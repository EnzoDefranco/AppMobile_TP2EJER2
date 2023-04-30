package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    lateinit var ciudadDBHELPER: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ciudadDBHELPER = miSQLiteHelper(this)

        ciudadDBHELPER.reiniciarBaseDeDatos()

        var btnCarga=findViewById<Button>(R.id.btn_CiudadCapital);
        btnCarga.setOnClickListener{
            val carga = Intent(this, CargarActivity::class.java)
            startActivity(carga)
        }

        var btnConsultar=findViewById<Button>(R.id.btnConsultar);
        btnConsultar.setOnClickListener{
            val consultar = Intent(this, ConsultarActivity::class.java)
            startActivity(consultar)
        }

        var btnBorrar=findViewById<Button>(R.id.btnBorrar);
        btnBorrar.setOnClickListener{
            val borrar = Intent(this, BorrarActivity::class.java)
            startActivity(borrar)
        }
        var btnBorrarCiudades=findViewById<Button>(R.id.btnBorrarCiudades);
        btnBorrarCiudades.setOnClickListener{
            val borrarCiu = Intent(this, BorrarCiudadesActivity::class.java)
            startActivity(borrarCiu)
        }

        var btnModificar=findViewById<Button>(R.id.btnModificarPoblacion);
        btnModificar.setOnClickListener{
            val mod = Intent(this, ModificarActivity::class.java)
            startActivity(mod)
        }


    }
}