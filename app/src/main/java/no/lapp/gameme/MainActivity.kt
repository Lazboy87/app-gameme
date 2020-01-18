package no.lapp.gameme

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

        loginbtn.setOnClickListener{}





    }
}
