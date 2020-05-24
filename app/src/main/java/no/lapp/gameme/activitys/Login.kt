package no.lapp.gameme.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import no.lapp.gameme.R


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)




         lateinit var auth: FirebaseAuth

        val TAG = "ClassName"

        var userinp = findViewById<TextView>(R.id.usernameinp)
        var passwordinp= findViewById<TextView>(R.id.passwordinp)
        val loginbtn= findViewById<Button>(R.id.loginbtn)
        val registerUserbtn = findViewById<Button>(R.id.Registerbtn)


        registerUserbtn.setOnClickListener{
            val intent = Intent(this, registerUser::class.java)
                startActivity(intent)
            finish()

        }


        fun updateUI(currentUser: FirebaseUser?) {
            val intent = Intent(this, Userpage::class.java)
            startActivity(intent)
            finish()
        }

        fun onStart() {
            super.onStart()
            // Check if user is signed in (non-null) and update UI accordingly.
            val currentUser = auth.currentUser
            updateUI(currentUser)
        }

        loginbtn.setOnClickListener{



            var email = userinp.getText().toString().trim()
            var pass = passwordinp.getText().toString().trim()

            auth = FirebaseAuth.getInstance()


            auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        Toast.makeText(baseContext, "Authentication sucsess.",
                            Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                        updateUI(user)
                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                       Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }


                }


    }




}}
