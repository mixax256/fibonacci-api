package models;

import java.util.ArrayList;

public class FibonacciNumbers {
    public static ArrayList<Integer> calcFibonacciNumbers( int number ) {
        ArrayList<Integer> result = new ArrayList<>();

        if ( number <= 0 ) return result;

        if ( number == 1 ) {
            result.add(0);
        }
        else {

            result.add(0); result.add(1);
            for (int i = 2; i < number; i++) {
                result.add( result.get( i - 1 ) + result.get( i - 2 ) );
            }
        }

        return result;
    }
}
