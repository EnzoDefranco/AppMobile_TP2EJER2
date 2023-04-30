package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}