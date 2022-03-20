package com.example.androiddatabaselesson2phoneapp.model

class Phone {
    var id: Int? = null
    var name: String? = null
    var features: String? = null
    var type: String? = null

    constructor(id: Int?, name: String?, features: String?, type: String?) {
        this.id = id
        this.name = name
        this.features = features
        this.type = type
    }

    constructor(name: String?, features: String?, type: String?) {
        this.name = name
        this.features = features
        this.type = type
    }


}