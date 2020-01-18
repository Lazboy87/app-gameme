package no.lapp.gameme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userinp = findViewById<TextView>(R.id.usernameinp)
        var passwordinp= findViewById<TextView>(R.id.passwordinp)
        val loginbtn= findViewById<Button>(R.id.loginbtn)





        loginbtn.setOnClickListener{
            var username = userinp.editableText.toString()
            var password = passwordinp.editableText.toString()
            println(username)
            println(password)

            if(username  == "lasse@lasse.com" && password == "lasse87") {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }else{}
        }


    }


}
