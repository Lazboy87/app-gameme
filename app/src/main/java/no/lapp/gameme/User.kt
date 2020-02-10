package no.lapp.gameme



class User{
    var id : Int = 0
    var name : String = ""
    var nickname : String = ""
    var email : String = ""
    var password : String = ""
    var age : Int = 0


    constructor(name:String , nickname: String,email : String,password : String,  age:Int ){
        this.name = name
        this.nickname = nickname
        this.email = email
        this.password = password
        this.age = age



    }



}