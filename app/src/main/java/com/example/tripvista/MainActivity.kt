package com.example.tripvista

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button
    private lateinit var confirmButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        clearButton = findViewById(R.id.clearButton)
        confirmButton = findViewById(R.id.confirmButton)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        clearButton.setOnClickListener {
            editText.text.clear()
        }

        confirmButton.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isEmpty()) {
                // Show toast message when EditText is empty
                Toast.makeText(this, "Name Field is empty.", Toast.LENGTH_SHORT).show()
            } else {
                // Proceed to start SecondActivity
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("name", inputText)
                }
                startActivity(intent)
            }
        }
    }
}

