package org.example;

public class LargestPrimeFactor {
        public static void main(String[] args) {
            long number = 13195; // Number to find largest prime factor
            long largestPrimeFactor = findLargestPrimeFactor(number);
            System.out.println("Largest prime factor of " + number + " is: " + largestPrimeFactor);
        }

        public static long findLargestPrimeFactor(long n) {
            long largestPrime = -1;
            while (n % 2 == 0) {
                largestPrime = 2;
                n /= 2;
            }
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    largestPrime = i;
                    n /= i;
                }
            }
            if (n > 2)
                largestPrime = n;
            return largestPrime;
        }
}
