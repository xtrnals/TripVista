package com.example.tripvista

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tripvista.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var backButton: Button
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var showPopupInstruc : Button
    private lateinit var textView3 : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView)
        backButton = findViewById(R.id.backButton)
        showPopupInstruc = findViewById(R.id.infoButton)
        textView3 = findViewById(R.id.textView3)


        showPopupInstruc.setOnClickListener{
            showPopup()
        }

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val name = intent.getStringExtra("name") // Retrieve the passed name from intent extras
        val text =
            "Welcome $name To TripVista!" // Concatenate the welcome message with the retrieved name
        textView.text = text

        //Load the animation
        val moveAnimation = AnimationUtils.loadAnimation(this, R.anim.move)

        //Apply the animation to text views
        textView.startAnimation(moveAnimation)
        textView3.startAnimation(moveAnimation)

        // Find ImageButtons by their IDs
        val uaeButton: ImageButton = findViewById(R.id.imageButton)
        val phButton: ImageButton = findViewById(R.id.imageButton2)
        val jpButton: ImageButton = findViewById(R.id.imageButton3)
        val inButton: ImageButton = findViewById(R.id.imageButton4)

        // Set click listeners for each ImageButton
        uaeButton.setOnClickListener {
            // Start a new activity when UAE button is clicked
            startNewActivity("UAE")
        }

        phButton.setOnClickListener {
            // Start a new activity when Philippines button is clicked
            startNewActivity("Philippines")
        }

        jpButton.setOnClickListener {
            // Start a new activity when Japan button is clicked
            startNewActivity("Japan")
        }

        inButton.setOnClickListener {
            // Start a new activity when India button is clicked
            startNewActivity("India")
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun startNewActivity(country: String) {
        // Create an Intent to start the new activity based on the selected country
        val intent = when (country) {
            "UAE" -> Intent(this, UAE::class.java)
            "Philippines" -> Intent(this, Philippines::class.java)
            "Japan" -> Intent(this, Japan::class.java)
            "India" -> Intent(this, India::class.java)
            else -> null
        }

        // Start the new activity if the intent is not null
        intent?.let {
            startActivity(it)
        }
    }

    private fun showPopup() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_info_popup, null)

        val width = 800
        val height = 650

        val instructWindow = PopupWindow(popupView, width, height, true)
        instructWindow.showAtLocation(popupView, Gravity.CENTER, 20, 100)

        val closeButton = popupView.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener{
            instructWindow.dismiss()
        }
    }
}