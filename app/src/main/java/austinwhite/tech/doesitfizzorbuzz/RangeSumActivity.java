package austinwhite.tech.doesitfizzorbuzz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class RangeSumActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.range_sum_activity);


        final EditText rangeMin  = findViewById(R.id.rangeMin);
        final EditText rangeMax  = findViewById(R.id.rangeMax);
        final TextView result  = findViewById(R.id.result);
        Button testButton  = findViewById(R.id.testButton);

        ActionBar actionbar = this.getSupportActionBar();
        assert actionbar != null;
        actionbar.setTitle("FizzBuzz Sum Range");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);


        testButton.setOnClickListener(view -> {
            String minString = rangeMin.getText().toString();
            String maxString = rangeMax.getText().toString();

            ArrayList<Integer> rangeList = new ArrayList<>();

            if (minString.isEmpty() || maxString.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Empty Input!", Toast.LENGTH_SHORT).show();

            } else if (Integer.parseInt(minString) > Integer.parseInt(maxString)) {
                Toast.makeText(getApplicationContext(), "Min is higher than Max!", Toast.LENGTH_SHORT).show();

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

                result.setText((rangeList.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", " +")
                        + " " + "=" + " " + sum
                ));
            }

        });

    }

    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        this.overridePendingTransition(0, 0);
        return true;
    }
}
