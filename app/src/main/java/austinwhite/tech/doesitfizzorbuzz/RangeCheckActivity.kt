package austinwhite.tech.doesitfizzorbuzz

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RangeCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.range_check_activity)

        val rangeMin: EditText = findViewById(R.id.rangeMin)
        val rangeMax: EditText = findViewById(R.id.rangeMax)
        val result: TextView = findViewById(R.id.result)
        val testButton: Button = findViewById(R.id.testButton)



        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "FizzBuzz Range"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        testButton.setOnClickListener {
            val min = rangeMin.text.toString()
            val max = rangeMax.text.toString()

            val resultArr = ArrayList<String>()

            val minInt = min.toInt()
            val maxInt = max.toInt()

            if (min.isEmpty() || max.isEmpty()) {
                Toast.makeText(
                applicationContext,
                "No Input!",
                Toast.LENGTH_SHORT
            ).show()}
            else if (minInt > maxInt) {Toast.makeText(
                applicationContext,
                "Min is higher than Max!",
                Toast.LENGTH_SHORT
            ).show()}
            else if (maxInt - minInt >= 50000) {Toast.makeText(
                applicationContext,
                "Limit: 50,000",
                Toast.LENGTH_SHORT
            ).show()}

            else if (maxInt == 0 || minInt == 0) {Toast.makeText(
                applicationContext,
                "Use a non-Zero number",
                Toast.LENGTH_SHORT
            ).show()}
            else {
                for (x in minInt..maxInt) {
                    if (x % 3 == 0 && x % 5 == 0) {
                        resultArr.add(getString(R.string.fizzbuzz))
                    } else if (x % 3 == 0) {
                        resultArr.add(getString(R.string.fizz))
                    } else if (x % 5 == 0){
                        resultArr.add(getString(R.string.buzz))
                    } else {
                        resultArr.add(x.toString())
                    }
                }

                result.text = resultArr.toString().replace("[", "").replace("]", "")
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        overridePendingTransition(0, 0)
        return true
    }
}