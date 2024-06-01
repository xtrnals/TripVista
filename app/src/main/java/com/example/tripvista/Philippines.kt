package com.example.tripvista

import android.content.Intent
import android.net.Uri
import android.net.wifi.MloLink
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripvista.databinding.ActivityPhilippinesBinding
import com.example.tripvista.databinding.ActivityUaeBinding

    class Philippines : AppCompatActivity() {

    private lateinit var binding: ActivityPhilippinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhilippinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set OnClickListener for the "Back" button
        binding.BackToHomeButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }

        binding.ph1.setOnClickListener{
            openUrl("https://www.tripadvisor.in/Attraction_Review-g294260-d338331-Reviews-White_Beach-Boracay_Malay_Aklan_Province_Panay_Island_Visayas.html")
        }

        binding.ph2.setOnClickListener{
            openUrl("https://www.tripadvisor.in/Attraction_Review-g298573-d310891-Reviews-Rizal_Park-Manila_Metro_Manila_Luzon.html")
        }

        binding.ph3.setOnClickListener{
            openUrl("https://www.tripadvisor.in/Attraction_Review-g298573-d548076-Reviews-Intramuros-Manila_Metro_Manila_Luzon.html")
        }
    }

    private fun openUrl(link: String) {

        val uri = Uri.parse(link)
        val inte = Intent(Intent.ACTION_VIEW, uri)

        startActivity(inte)
    }
}
