package com.example.tp2_punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btncarga=findViewById<Button>(R.id.btn_CiudadCapital);
        btncarga.setOnClickListener{
            val carga = Intent(this, CargarActivity::class.java)
            startActivity(carga)
        }
    }
}