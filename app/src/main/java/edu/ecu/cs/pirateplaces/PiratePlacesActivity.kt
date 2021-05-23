package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.jar.Attributes

class PiratePlacesActivity : AppCompatActivity() {

    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var placesTextView: TextView
    private lateinit var namesTextView: TextView

    private val Places = listOf (
        Place(R.string.College_Hill,"Jordan, Connor, Anna" ),
        Place(R.string.West_End, "Rebecca, Kyle, Josh"),
        Place(R.string.Dowdy_Ficklen, "Sarah, Hannah, Jason"),
        Place(R.string.Joyner, "Michael, Bryan, Sue")
    )


    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pirate_places)

        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)
        placesTextView= findViewById(R.id.places)

        previousButton.setOnClickListener {
            if (currentIndex == 0) {
                Toast.makeText(
                    this,
                    R.string.first_place_toast,
                    Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                currentIndex = (currentIndex - 1)
                updatePlace()
            }
        }
        nextButton.setOnClickListener {
        if (currentIndex + 1 == Places.size) {
               Toast.makeText(
                   this,
                R.string.last_place_toast,
               Toast.LENGTH_SHORT)
                   .show()
            }

           else {
            currentIndex = (currentIndex + 1)
                updatePlace()
            }

        }
       updatePlace()
    }
    private fun updatePlace () {
        val placesTextResId = Places[currentIndex].textResid
        val namesTextResId =Places[currentIndex].people
        placesTextView.setText(placesTextResId)
        namesTextView.setText(namesTextResId)
    }

}

