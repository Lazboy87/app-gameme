package no.lapp.gameme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var userinp = findViewById<TextView>(R.id.usernameinp)
        var passwordinp= findViewById<TextView>(R.id.passwordinp)
        val loginbtn= findViewById<Button>(R.id.loginbtn)





        loginbtn.setOnClickListener{
            var username = userinp.editableText.toString()
            var password = passwordinp.editableText.toString()

            if(username  == "lasse@lasse.com" && password == "lasse87") {
                val intent = Intent(this, Userpage::class.java)
                startActivity(intent)
            }else{}
        }


    }


}
