package austinwhite.tech.doesitfizzorbuzz;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.jetbrains.annotations.NotNull;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;

@RunWith(AndroidJUnit4.class)
class RangeSumActivityTest {
    RangeSumActivity sumActivity = new RangeSumActivity();


    @org.junit.jupiter.api.Test
    public void rangeCheckTest() {
        String sum = sumActivity.rangeSum("1", "9");

        assertThat("3 + 5 + 6 + 9 = 23").isEqualTo(sum);
    }
}