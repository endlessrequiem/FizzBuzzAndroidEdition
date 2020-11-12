package austinwhite.tech.doesitfizzorbuzz

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.choices, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.home -> {
            startActivity(Intent(this@GeneratorActivity, MainActivity::class.java))
            overridePendingTransition(0, 0)
            true
        }
        R.id.goToRangeCheckActivity -> {
            startActivity(Intent(this@GeneratorActivity, RangeCheckActivity::class.java))
            overridePendingTransition(0, 0)
            true
        }
        /* R.id.goToGeneratorActivity -> {
            startActivity(Intent(this@GeneratorActivity, GeneratorActivity::class.java))
            overridePendingTransition(0, 0)
            true
        } */
        R.id.goToRangeSumActivity -> {
            startActivity(Intent(this@GeneratorActivity, RangeSumActivity::class.java))
            overridePendingTransition(0, 0)
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        overridePendingTransition(0, 0)
        return true
    }
}