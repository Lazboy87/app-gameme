package no.lapp.gameme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_user.*


class registerUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val context = this

regbutton.setOnClickListener {
    if(firstname.text.toString().length > 3 &&
        lastname.text.toString().length > 3 &&
        Email.text.toString().length > 3 &&
        nickname.text.toString().length > 3 &&
        PasswordReg.text.toString().length > 3
    ){
        var user = User(firstname.text.toString()+ lastname.text.toString(),Email.text.toString(),nickname.text.toString(),PasswordReg.text.toString())
        var db = DBhandler(context)
        db.insertdata(user)
    }


}

    }
}
