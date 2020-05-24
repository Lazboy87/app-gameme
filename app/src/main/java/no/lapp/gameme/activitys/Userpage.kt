package no.lapp.gameme.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import no.lapp.gameme.R

class Userpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userpage)

        val TAG = "ClassName"


        var nickshow = findViewById<TextView>(R.id.userNick)





        val user = FirebaseAuth.getInstance().currentUser
        user?.let {

            val email = user.email
            val userref = FirebaseDatabase.getInstance().getReference("Users").orderByChild("email").equalTo(email)



            var listUSER= userref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (postSnapshot in dataSnapshot.children) {
                        var values = postSnapshot

                        var nickname = values.child("nickname").value.toString().trim()


                        nickshow.setText(nickname)

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




