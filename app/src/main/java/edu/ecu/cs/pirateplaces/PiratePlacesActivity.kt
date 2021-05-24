package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

private const val TAG = "PiratePlacesActivity"

class PiratePlacesActivity : AppCompatActivity() {


    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var placesTextView: TextView
    private lateinit var checkInButton: Button
    private lateinit var namesTextView: TextView
    private lateinit var placesButton: Button

    private val piratePlacesViewModel: PiratePlacesViewModel by lazy {
        ViewModelProviders.of(this).get(PiratePlacesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pirate_places)

        placesButton = findViewById(R.id.places_button)
        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)
        placesTextView = findViewById(R.id.places_button)
        namesTextView = findViewById(R.id.people)
     //   checkInButton = findViewById(R.id.check_in_button)


        previousButton.setOnClickListener {
            if (piratePlacesViewModel.currentIndex == 0) {
                Toast.makeText(
                    this,
                    R.string.first_place_toast,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            else {
                piratePlacesViewModel.moveToPrevious()
                updatePlace() //new
            }
            }




            nextButton.setOnClickListener {

                if (piratePlacesViewModel.currentIndex + 1 == piratePlacesViewModel.numberOfPlaces) {
                    Toast.makeText(
                        this,
                        R.string.last_place_toast,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    piratePlacesViewModel.moveToNext()
                    updatePlace()
                }

            }
            updatePlace()
    placesButton.setOnClickListener {
        val notCheckedIn = true
        val currentPlace = piratePlacesViewModel.currentPlaceText
        val intent = CheckIn.newIntent(this@PiratePlacesActivity, notCheckedIn, currentPlace)
        startActivity(intent)

    }
      //  checkInButton.setOnClickListener {
   // ran out of time
    //    }
    }

    private fun updatePlace() {
        placesTextView.setText(piratePlacesViewModel.currentPlaceText)
        namesTextView.setText(piratePlacesViewModel.currentPeople)
    }
}



