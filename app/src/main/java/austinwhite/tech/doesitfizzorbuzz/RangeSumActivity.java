package austinwhite.tech.doesitfizzorbuzz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import kotlin.jvm.internal.Intrinsics;

import static austinwhite.tech.doesitfizzorbuzz.R.id.goToGeneratorActivity;


public class RangeSumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.range_sum_activity);


        final EditText rangeMin = findViewById(R.id.rangeMin);
        final EditText rangeMax = findViewById(R.id.rangeMax);
        final TextView result = findViewById(R.id.result);
        Button testButton = findViewById(R.id.testButton);

        ActionBar actionbar = this.getSupportActionBar();
        assert actionbar != null;
        actionbar.setTitle("FizzBuzz Sum Range");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);


        testButton.setOnClickListener(view -> {
            String minString = rangeMin.getText().toString();
            String maxString = rangeMax.getText().toString();
            result.setText(rangeSum(minString, maxString));

        });

    }

    public String rangeSum(String minString, String maxString) {

        ArrayList<Integer> rangeList = new ArrayList<>();

        if (minString.isEmpty() || maxString.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Empty Input!", Toast.LENGTH_SHORT).show();

        } else if (Integer.parseInt(minString) > Integer.parseInt(maxString)) {
            Toast.makeText(getApplicationContext(), "Min is higher than Max!", Toast.LENGTH_SHORT).show();

        } else if (Integer.parseInt(maxString) - Integer.parseInt(minString) > 10000) {
            Toast.makeText(getApplicationContext(), "Range too high! (Limit 10,000)", Toast.LENGTH_SHORT).show();

        } else {
            int min = Integer.parseInt(minString);
            int max = Integer.parseInt(maxString);

            for (int i = min; i <= max; i++) {

                if (i % 5 == 0 && i % 3 == 0) {
                    rangeList.add(i);
                } else if (i % 5 == 0) {
                    rangeList.add(i);
                } else if (i % 3 == 0) {
                    rangeList.add(i);
                }

            }

            int sum = rangeList.stream()
                    .mapToInt(a -> a)
                    .sum();

            return rangeList.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", " +")
                    + " " + "=" + " " + sum;
        }
        return String.valueOf(R.string.empty);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.choices, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(RangeSumActivity.this, MainActivity.class));
                overridePendingTransition(0, 0);
                result = true;
                break;
            case R.id.goToRangeCheckActivity:
                startActivity(new Intent(RangeSumActivity.this, RangeCheckActivity.class));
                overridePendingTransition(0, 0);
                result = true;
                break;
            case R.id.goToGeneratorActivity:
                startActivity(new Intent(RangeSumActivity.this, GeneratorActivity.class));
                overridePendingTransition(0, 0);
                result = true;
                break;
           /* case R.id.goToRangeSumActivity:
                startActivity(new Intent(RangeSumActivity.this, RangeSumActivity.class));
                overridePendingTransition(0, 0);
                result = true;
                break; */

        }
        if (!result) {
            result = super.onOptionsItemSelected(item);
        }
        return result;
    }


    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        this.overridePendingTransition(0, 0);
        return true;
    }
}
