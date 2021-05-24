package edu.ecu.cs.pirateplaces

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

private const val TAG = "PiratePlacesViewModel"

class PiratePlacesViewModel : ViewModel() {
  var currentIndex = 0

    private val Places = listOf (
        Place(R.string.College_Hill,"Jordan, Connor, Anna" ),
        Place(R.string.West_End, "Rebecca, Kyle, Josh"),
        Place(R.string.Dowdy_Ficklen, "Sarah, Hannah, Jason"),
        Place(R.string.Joyner, "Michael, Bryan, Sue")
    )

    val numberOfPlaces: Int
    get() = Places.size

    val currentPeople: String
        get() = Places[currentIndex].people

    val currentPlaceText: Int
    get() = Places[currentIndex].textResid

    fun moveToNext() {
            currentIndex = (currentIndex + 1)

        }

    fun moveToPrevious() {
            currentIndex = (currentIndex - 1)
        }




    }


