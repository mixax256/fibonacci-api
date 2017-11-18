package models;

import org.junit.Test;
import java.util.ArrayList;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;

public class FibonacciNumbersTest {
    @Test
    public void testCalcFibonacciNumbers() {
        ArrayList<Integer> result = FibonacciNumbers.calcFibonacciNumbers(18);
        int[] rigthValues = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597 };
        for ( int i = 0; i < 18; i++) {
            assertEquals( of( rigthValues[i] ), of( result.get(i) ) );
        }
    }
}
