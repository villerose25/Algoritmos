package easy;

import java.util.Arrays;

/*
    When is a number prime?
    * greater than 1
    * Non-divisible by anything except one and itself

    Algoritmo Sieve of Eratosthenes
    Definir un boolean array de size n y establecer todos los elementos en True, excepto 0 y 1
    2. loop de i from 2 asta el sqrt(N)
        si es primo entonces false

       return the sum of True(isPprime)
       de 1 al 34 -->
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        if (n < 2)
            return 0;

        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i=2; i< Math.ceil(Math.sqrt(n)); i++) { //move to square
            if(isPrime[i]) //if current element is prime?
                // all multiples are not prime
                for(int multiples_of_i = i*i; multiples_of_i < n; multiples_of_i +=i)
                    isPrime[multiples_of_i] = false;
        }
        return (int)Arrays.stream(isPrime)
                .filter(c-> c!= null && c==true)
                .count();
    }


    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
