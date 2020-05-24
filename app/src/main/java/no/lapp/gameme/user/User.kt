package no.lapp.gameme.user




class User{
    var id : String? = ""
    var nickname : String = ""
    var email : String = ""

    var age : String = ""




    constructor(
        id: String?,  nickname: String,
        email: String,
         age: String
    ){
        this.id = id

        this.nickname = nickname
        this.email = email

        this.age = age



    }



}