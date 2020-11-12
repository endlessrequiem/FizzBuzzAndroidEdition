package austinwhite.tech.doesitfizzorbuzz

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test


class MainActivityTest {


    @Test
    fun fizzBuzzTest() {
        val fizzBuzzNumber = MainActivity()
        val userInput = "15"

        val fizzBuzzTest: String = fizzBuzzNumber.fizzBuzzCheck(userInput)
        assertEquals("FIZZBUZZ!", fizzBuzzTest)
    }
}