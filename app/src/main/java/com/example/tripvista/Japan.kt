package com.example.tripvista

import android.content.Intent
import android.net.Uri
import android.net.wifi.MloLink
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripvista.databinding.ActivityJapanBinding
import com.example.tripvista.databinding.ActivityPhilippinesBinding
import com.example.tripvista.databinding.ActivityUaeBinding

class Japan : AppCompatActivity() {

    private lateinit var binding: ActivityJapanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJapanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set OnClickListener for the "Back" button
        binding.BackToHomeButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }

        binding.jp1.setOnClickListener{
            openUrl("https://www.tripadvisor.in/Attraction_Review-g298564-d321400-Reviews-Kinkakuji_Temple-Kyoto_Kyoto_Prefecture_Kinki.html")
        }

        binding.jp2.setOnClickListener{
            openUrl("https://www.tripadvisor.in/Attraction_Review-g298566-d320976-Reviews-Universal_Studios_Japan-Osaka_Osaka_Prefecture_Kinki.html")
        }

        binding.jp3.setOnClickListener{
            openUrl("https://www.tripadvisor.in/Attraction_Review-g298198-d319880-Reviews-Nara_Park-Nara_Nara_Prefecture_Kinki.html")
        }
    }

    private fun openUrl(link: String) {

        val uri = Uri.parse(link)
        val inte = Intent(Intent.ACTION_VIEW, uri)

        startActivity(inte)
    }
}
