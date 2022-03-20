package com.example.androiddatabaselesson2phoneapp.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.androiddatabaselesson2phoneapp.model.DatabaseService
import com.example.androiddatabaselesson2phoneapp.model.Phone
import com.example.androiddatabaselesson2phoneapp.util.Constant

class PhoneDbHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table phone(${Constant.ID} integer not null primary key autoincrement unique,${Constant.NAME} text not null,${Constant.FEATURES} text not null,${Constant.TYPE} not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addPhone(phone: Phone) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME, phone.name)
        contentValues.put(Constant.FEATURES, phone.features)
        contentValues.put(Constant.TYPE, phone.type)
        database.insert(Constant.TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun getPhoneById(id: Int): Phone {
        val database = this.readableDatabase
        val cursor = database.query(
            Constant.TABLE_NAME,
            arrayOf(Constant.ID, Constant.NAME, Constant.FEATURES, Constant.TYPE),
            "${Constant.ID} = ?",
            arrayOf("$id"),
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        return Phone(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3)
        )
    }

    @SuppressLint("Recycle")
    override fun getAllPhoneByType(types: String): ArrayList<Phone> {
        val phoneList = ArrayList<Phone>()
        val query = "select * from ${Constant.TABLE_NAME} WHERE ${Constant.TYPE} = '$types'"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val phone = Phone(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )
                phoneList.add(phone)
            } while (cursor.moveToNext())
        }
        return phoneList
    }
}