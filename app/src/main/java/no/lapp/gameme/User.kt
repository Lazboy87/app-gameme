package no.lapp.gameme




class User{
    var id : String? = ""
    var name : String = ""
    var nickname : String = ""
    var email : String = ""

    var age : String = ""




    constructor(
        id: String?, name:String, nickname: String,
        email: String,
         age: String
    ){
        this.id = id
        this.name = name
        this.nickname = nickname
        this.email = email

        this.age = age



    }



}