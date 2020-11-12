package austinwhite.tech.doesitfizzorbuzz

import android.content.Context
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

        val result: TextView = findViewById(R.id.resultView)
        val testButton: Button = findViewById(R.id.testButton)
        val input: EditText = findViewById(R.id.numberTest)
        val animateThis = AnimationActivity()


        testButton.setOnClickListener {
            val userInput = input.text.toString()

            result.text = fizzBuzzCheck(userInput)

            if (fizzBuzzCheck(userInput) == getString(R.string.fizzbuzz)){
                animateThis.scaler(result)
            }


        }



    }

    fun fizzBuzzCheck(userInput: String): String {
        val fizzbuzz = getString(R.string.fizzbuzz)
        val fizz = getString(R.string.fizz)
        val buzz = getString(R.string.buzz)
        val neither = getString(R.string.neither)
        val empty = getString(R.string.empty)


        when {
            userInput.isEmpty() -> { Toast.makeText(
                applicationContext,
                "There is no Input!",
                Toast.LENGTH_SHORT
            ).show() }
            userInput.toInt() == 0 -> {Toast.makeText(
                applicationContext,
                "Use a non-Zero number",
                Toast.LENGTH_SHORT
            ).show() }
            userInput.toInt() >= 1000000000 -> {Toast.makeText(
                applicationContext,
                "Number too high",
                Toast.LENGTH_SHORT
            ).show() }
            else -> return if (userInput.toInt() % 3 == 0 && userInput.toInt() % 5 == 0) {
                fizzbuzz
            } else if (userInput.toInt() % 3 == 0) {
                fizz
            } else if (userInput.toInt() % 5 == 0){
                buzz
            } else {
                "$userInput $neither"

            }
        }
        return empty
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.choices, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        /* R.id.home -> {
            startActivity(Intent(this@MainActivity, MainActivity::class.java))
            overridePendingTransition(0, 0)
            true
        } */
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
        R.id.goToRangeSumActivity -> {
            startActivity(Intent(this@MainActivity, RangeSumActivity::class.java))
            overridePendingTransition(0, 0)
            true
        }

        else -> super.onOptionsItemSelected(item)
    }


}

