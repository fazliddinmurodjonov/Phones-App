package com.example.androiddatabaselesson2phoneapp.model

interface DatabaseService {
    fun addPhone(phone: Phone)
    fun getPhoneById(id: Int): Phone
    fun getAllPhoneByType(type: String): ArrayList<Phone>

}