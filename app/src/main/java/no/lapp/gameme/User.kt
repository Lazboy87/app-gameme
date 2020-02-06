package no.lapp.gameme

import android.provider.ContactsContract

class User{
    var id : Int = 0
    var name : String = ""
    var nickname : String = ""
    var email : String = ""
    var password : String = ""
    //var dateOfBirth : Int = 0


    constructor(name:String , nickname: String,email : String,password : String){
        this.name = name
        this.nickname = nickname
        this.email = email
        this.password = password
       // this.dateOfBirth = dateOfBirth



    }



}