package no.lapp.gameme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase


class registerUser : AppCompatActivity() {

    lateinit var Fname:EditText
    lateinit var Lname:EditText
    lateinit var Nname:EditText
    lateinit var email:EditText
    lateinit var age:EditText
    lateinit var password:EditText
    lateinit var regbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        Fname = findViewById(R.id.firstname)
        Lname = findViewById(R.id.lastname)
        Nname = findViewById(R.id.nickname)
        email = findViewById(R.id.Email)
        age = findViewById(R.id.age)
        password = findViewById(R.id.PasswordReg)
        regbutton = findViewById(R.id.regbutton)

       regbutton.setOnClickListener(){saveUser()}




        }

    private fun saveUser() {
        val firstname= Fname.text.toString().toUpperCase().trim()
        val lastname= Lname.text.toString().toUpperCase().trim()
        val nickname= Nname.text.toString().toUpperCase().trim()
        val Email= email.text.toString().toUpperCase().trim()
        val Pass= password.text.toString().toUpperCase().trim()
        val Age = age.text.toString().toUpperCase().trim()



        if(firstname.isEmpty()){ Fname.error = "please enter first name"
            return }
        if(lastname.isEmpty()){ Lname.error = "please enter last name"
            return }
        if(nickname.isEmpty()){ Nname.error = "please enter nick name"
            return }
        if(Email.isEmpty()){ email.error = "please enter email"
            return }
        if(Pass.isEmpty()){ password.error = "please enter a Password"
            return }
        if(Age.isEmpty()){ age.error = "please enter your age"
            return }


        val ref = FirebaseDatabase.getInstance().getReference("Users")

        val  userId  = ref.push().key

        val user = User(userId,firstname+" "+lastname,nickname,Email,Pass,Age)

        if (userId != null) {



            ref.child(userId).setValue(user).addOnCompleteListener { Toast.makeText(applicationContext,"USER REGISTER SUCCESS! TAKING YOU TO LOGIN", Toast.LENGTH_LONG).show() }

            Handler().postDelayed({
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }, 4000)


        } else {



            if (userId != null) {
                ref.child(userId).setValue(user).addOnCanceledListener {
                    Toast.makeText(
                        applicationContext,
                        "Error contact support",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }






        }
    }
}


