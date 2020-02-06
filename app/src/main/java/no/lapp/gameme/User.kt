package no.lapp.gameme

import android.provider.ContactsContract

class User{
    var id : Int = 0
    var name : String = ""
    var nicknname : String = ""
    var email : String = ""
    var dateOfBirth : Int = 0


    constructor(name:String , nickname: String,email : String, dateOfBirth : Int ){
        this.name = name
        this.nicknname = nicknname
        this.email = email
        this.dateOfBirth = dateOfBirth



    }



}