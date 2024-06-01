package com.example.tripvista

import android.content.Intent
import android.net.Uri
import android.net.wifi.MloLink
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripvista.databinding.ActivityIndiaBinding
import com.example.tripvista.databinding.ActivityJapanBinding
import com.example.tripvista.databinding.ActivityPhilippinesBinding
import com.example.tripvista.databinding.ActivityUaeBinding

class India : AppCompatActivity() {

    private lateinit var binding: ActivityIndiaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set OnClickListener for the "Back" button
        binding.BackToHomeButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }

        binding.in1.setOnClickListener{
            openUrl("https://www.tripadvisor.com/Attraction_Review-g297683-d317329-Reviews-Taj_Mahal-Agra_Agra_District_Uttar_Pradesh.html")
        }

        binding.in2.setOnClickListener{
            openUrl("https://www.tripadvisor.com/Attraction_Review-g608474-d2049703-Reviews-Della_Adventure_Park-Lonavala_Pune_District_Maharashtra.html")
        }

        binding.in3.setOnClickListener{
            openUrl("https://www.tripadvisor.com/Attraction_Review-g297683-d319695-Reviews-Agra_Fort-Agra_Agra_District_Uttar_Pradesh.html")
        }
    }

    private fun openUrl(link: String) {

        val uri = Uri.parse(link)
        val inte = Intent(Intent.ACTION_VIEW, uri)

        startActivity(inte)
    }
}
