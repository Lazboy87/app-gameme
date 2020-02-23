package no.lapp.gameme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.solver.widgets.Snapshot
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Userpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userpage)

        val TAG = "ClassName"


        var emailshow = findViewById<TextView>(R.id.userEmail)
        var nameshow = findViewById<TextView>(R.id.userName)
        var ageshow = findViewById<TextView>(R.id.userAge)
        var nickshow = findViewById<TextView>(R.id.userNick)





        val user = FirebaseAuth.getInstance().currentUser
        user?.let {

            val email = user.email
            val userref = FirebaseDatabase.getInstance().getReference("Users").orderByChild("email").equalTo(email)



            var listUSER= userref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (postSnapshot in dataSnapshot.children) {
                        var values = postSnapshot
                        var name = values.child("name").value.toString().trim()
                        var age = values.child("age").value.toString().trim()
                        var nickname = values.child("nickname").value.toString().trim()

                        nameshow.setText("Name:  "+name )
                        emailshow.setText("Email  :"+email)
                        ageshow.setText("Age  :"+age)
                        nickshow.setText("Nickname:  "+nickname)

                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                    // ...
                }
            })






        }



    }
}




