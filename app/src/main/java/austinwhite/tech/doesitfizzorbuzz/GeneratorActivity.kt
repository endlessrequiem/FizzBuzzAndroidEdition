package austinwhite.tech.doesitfizzorbuzz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class GeneratorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generator_activity)

        val animateThis = AnimationActivity()

        val generatedNumber: TextView = findViewById(R.id.generatedNumber)
        val fizzButton: Button = findViewById(R.id.fizzButton)
        val buzzButton: Button = findViewById(R.id.buzzButton)
        val fizzbuzzButton: Button = findViewById(R.id.fizzbuzzButton)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "FizzBuzz Number Generator"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        fizzButton.setOnClickListener {
            val fizzNumber = (1..100).random() * 3
            generatedNumber.text = fizzNumber.toString()
            animateThis.buttonScaler(generatedNumber, fizzButton, buzzButton, fizzbuzzButton)

        }

        buzzButton.setOnClickListener {
            val buzzNumber = (1..100).random() * 5
            generatedNumber.text = buzzNumber.toString()
            animateThis.buttonScaler(generatedNumber, fizzButton, buzzButton, fizzbuzzButton)

        }

        fizzbuzzButton.setOnClickListener {
            val fizzbuzzNumber = (1..100).random() * 3 * 5
            generatedNumber.text = fizzbuzzNumber.toString()
            animateThis.buttonScaler(generatedNumber, fizzButton, buzzButton, fizzbuzzButton)

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        overridePendingTransition(0, 0)
        return true
    }
}