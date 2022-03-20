package com.example.androiddatabaselesson2phoneapp.util

class PhoneType {
    fun phoneTypes(): ArrayList<String> {
        var phoneTypeList = ArrayList<String>()
        phoneTypeList.add(Constant.iPhone)
        phoneTypeList.add(Constant.Samsung)
        phoneTypeList.add(Constant.Mi)
        phoneTypeList.add(Constant.Sony)
        phoneTypeList.add(Constant.Huawei)
        phoneTypeList.add(Constant.Artel)
        return phoneTypeList
    }
}