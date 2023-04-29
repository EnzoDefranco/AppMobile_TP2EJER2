package com.example.tp2_punto2
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "ciudad.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE ciudad (nombre TEXT, pais TEXT, poblacion INTEGER)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS ciudad"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun agregarCiudad(nombre: String, pais: String, poblacion: Int): Boolean {
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("pais", pais)
        datos.put("poblacion", poblacion)

        val db = this.writableDatabase
        val resul = db.insert("ciudad", null, datos)
        return resul != (-1).toLong()
    }

}