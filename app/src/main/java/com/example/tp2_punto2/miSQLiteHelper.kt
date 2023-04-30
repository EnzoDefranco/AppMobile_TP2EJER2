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

    fun getDataByCity(consulta: String): Array<Any>? {
        val db = this.readableDatabase
        val selectByCityQuery = "SELECT * FROM ciudad WHERE nombre = ?"
        val cursor = db.rawQuery(selectByCityQuery, arrayOf(consulta))
        if (cursor.moveToFirst()) {
            val data1 = cursor.getString(0)
            val data2 = cursor.getString(1)
            val data3 = cursor.getInt(2)
            cursor.close()
            return arrayOf(data1, data2, data3)
        } else {
            cursor.close()
            return null
        }
    }
    fun deleteByCity(consulta: String): Boolean{
        val db = this.writableDatabase
        val whereClause = "nombre = ?"
        val whereArgs = arrayOf(consulta)
        val deleteRows = db.delete("ciudad" , whereClause, whereArgs)
        db.close()
        return deleteRows > 0
    }

}

/*

fun getDataByCity(city: String): Array<Any>? {
        val db = this.readableDatabase
        val selectByCityQuery = "SELECT * FROM $TABLE_NAME WHERE $KEY_DATA2 = ?"
        val cursor = db.rawQuery(selectByCityQuery, arrayOf(city))
        if (cursor.moveToFirst()) {
            val data1 = cursor.getString(cursor.getColumnIndex(KEY_DATA1))
            val data2 = cursor.getString(cursor.getColumnIndex(KEY_DATA2))
            val data3 = cursor.getInt(cursor.getColumnIndex(KEY_DATA3))
            cursor.close()
            return arrayOf(data1, data2, data3)
        } else {
            cursor.close()
            return null
        }
    }

 */