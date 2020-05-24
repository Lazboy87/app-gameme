package no.lapp.gameme.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import no.lapp.gameme.R

class SplashScreen : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var textR: TextView
    private lateinit var textL: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        image= findViewById(R.id.imageLogo)
        textL= findViewById(R.id.LogotextL)
        textR= findViewById(R.id.LogotextR)

        animateImage()
        animateTextL()
        animateTextR()


        Handler().postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }


    private fun animateImage() {
        val rotate = AnimationUtils.loadAnimation(this,
            R.anim.top
        )

        image.animation = rotate


    }
    private fun animateTextL() {
        val left = AnimationUtils.loadAnimation(this,
            R.anim.left
        )

        textL.animation = left


    }

    private fun animateTextR() {
        val right = AnimationUtils.loadAnimation(this,
            R.anim.right
        )

        textR.animation = right


    }

}
