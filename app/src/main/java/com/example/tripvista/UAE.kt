package com.example.tripvista

import android.content.Intent
import android.net.Uri
import android.net.wifi.MloLink
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripvista.databinding.ActivityUaeBinding

class UAE : AppCompatActivity() {

    private lateinit var binding: ActivityUaeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUaeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set OnClickListener for the "Back" button
        binding.BackToHomeButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }

        binding.uae1.setOnClickListener{
            openUrl("https://www.tripadvisor.com/Attraction_Review-g295424-d676922-Reviews-Burj_Khalifa-Dubai_Emirate_of_Dubai.html")
        }

        binding.uae2.setOnClickListener{
            openUrl("https://www.tripadvisor.com/Attraction_Review-g295424-d1936354-Reviews-The_Dubai_Fountain-Dubai_Emirate_of_Dubai.html")
        }

        binding.uae3.setOnClickListener{
            openUrl("https://www.tripadvisor.com/Attraction_Review-g294013-d1940985-Reviews-Ferrari_World_Abu_Dhabi-Abu_Dhabi_Emirate_of_Abu_Dhabi.html")
        }
    }

    private fun openUrl(link: String) {

        val uri = Uri.parse(link)
        val inte = Intent(Intent.ACTION_VIEW, uri)

        startActivity(inte)
    }
}
