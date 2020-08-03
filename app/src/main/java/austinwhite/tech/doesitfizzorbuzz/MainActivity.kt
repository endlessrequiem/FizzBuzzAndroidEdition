package austinwhite.tech.doesitfizzorbuzz

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animateThis = AnimationActivity()

        val result: TextView = findViewById(R.id.resultView)
        val testButton: Button = findViewById(R.id.testButton)
        val input: EditText = findViewById(R.id.numberTest)


        testButton.setOnClickListener {
            val userInput = input.text.toString()

            if (userInput.isEmpty()) { Toast.makeText(
                applicationContext,
                "No Input!",
                Toast.LENGTH_SHORT
            ).show() }
            else if (userInput.toInt() == 0) {Toast.makeText(
                applicationContext,
                "Use a non-Zero number",
                Toast.LENGTH_SHORT
            ).show() }
            else if (userInput.toInt() >= 1000000000) {Toast.makeText(
                applicationContext,
                "Number too high",
                Toast.LENGTH_SHORT
            ).show() }
            else {
                if (userInput.toInt() % 3 == 0 && userInput.toInt() % 5 == 0) {
                    result.text = getString(R.string.fizzbuzz)
                    animateThis.scaler(result)
                } else if (userInput.toInt() % 3 == 0) {
                    result.text = getString(R.string.fizz)
                } else if (userInput.toInt() % 5 == 0){
                    result.text = getString(R.string.buzz)
                } else {
                    result.text = (userInput + " " + getString(R.string.neither))

                }

            }
        }



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.choices, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.goToRangeCheckActivity -> {
            startActivity(Intent(this@MainActivity, RangeCheckActivity::class.java))
            overridePendingTransition(0, 0)
            true
        }
        R.id.goToGeneratorActivity -> {
            startActivity(Intent(this@MainActivity, GeneratorActivity::class.java))
            overridePendingTransition(0, 0)
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}

