package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class PiratePlacesActivity : AppCompatActivity() {

    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val Places = listOf (
        Place(R.string.College_Hill),
        Place(R.string.West_End),
        Place(R.string.Dowdy_Ficklen),
        Place(R.string.Joyner))


    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pirate_places)

        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)

        previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1)
            updateQuestion()
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1)
        if (currentIndex == Places.size) {
               Toast.makeText(
                   this,
                R.string.last_place_toast,
               Toast.LENGTH_SHORT)
                   .show()
            }

           else {
                updateQuestion()
            }

        }
       updateQuestion()
    }
    private fun updateQuestion () {
        val questionTextResId = Places[currentIndex].textResid
        questionTextView.setText(questionTextResId)
    }
}
