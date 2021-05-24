package edu.ecu.cs.pirateplaces

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_NOT_CHECKED_IN =
    "com.bignerdranch.android.geoquiz.not_checked_in"

class CheckIn : AppCompatActivity() {

    private lateinit var checkInTextView: TextView
    private lateinit var checkInButton: Button

    private var notCheckedIn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        notCheckedIn = intent.getBooleanExtra(EXTRA_NOT_CHECKED_IN, true)

        checkInTextView = findViewById(R.id.not_checked_in_text_view)
        checkInButton= findViewById(R.id.check_in_button)

        val checkedInText = when {
            notCheckedIn -> R.string.not_checked_in
            else -> R.string.checked_in
        }
        checkInTextView.setText(checkedInText)
    }


    companion object {
        fun newIntent(packageContext: Context, checkInTrue: Boolean, currentPlace: Int): Intent
        {
            return Intent(packageContext, CheckIn::class.java).apply(){
                putExtra(EXTRA_NOT_CHECKED_IN, checkInTrue)
            }
        }
    }
}
