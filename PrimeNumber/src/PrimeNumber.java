import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class PrimeNumber {
    public static boolean IsPrime( int input ) {
        int divisors = 0;
        if ( input == 1 )
            return false;
        for ( int i = 1; i <= input; i++ ) {
            if ( input % i == 0 )
                divisors++;
        }

        if ( divisors > 2 )
            return false;
        else
            return true;
    }

    public static ArrayList<Integer> getPrimes( int start, int numberOfPrimes ) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int found = 0;
        if ( IsPrime( start ) )
            found = -1;
        while ( found != numberOfPrimes ) {
            while ( start == start ) {
                if ( IsPrime( start ) ) {
                    primeNumbers.add( start );
                    found++;
                    break;
                }
                start++;
            }
            start++;
        }
        return primeNumbers;
    }

    public static ArrayList<Integer> getPrimeInRange( int low, int high ) {
        int primes = 0;

        for ( int i = low; i <= high; i++ ) {
            if ( IsPrime( i ) )
                primes++;
        }

        return getPrimes( low, primes );
    }

    public static void main( String[] args ) {
        Scanner stdin = new Scanner( in );
        out.print( "Please type in any integer to check if it is prime (Input 0 if you do not want to check any more prime numbers): " );
        while ( stdin.hasNext() ) {
            int input = stdin.nextInt();
            if ( input == 0 )
                break;
            String ifUnigue = "";
            if ( IsPrime( input ) ) {
                out.println( "That is a prime number." );
            }
            else {
                if ( input == 1 )
                    ifUnigue += "That is a unique number.";
                out.println( "That is not a prime number. " + ifUnigue );
            }
            out.print( "How many prime numbers do you need after your starting number: " );
            int numberPrimes = stdin.nextInt();
            ArrayList<Integer> allPrimes = getPrimes( input, numberPrimes );
            if ( allPrimes.get( 0 ) == input ) {
                allPrimes.remove( 0 );
            }
            String allNums = "";
            for ( int i : allPrimes ) {
                if ( i >= 2 ) {
                    allNums += i + " ";
                }
            }
            out.println( "The prime numbers are " + allNums );
            out.println();
            out.print( "Please type in any integer to check if it is prime (Input 0 if you do not want to check any more prime numbers): " );
        }
    }
}