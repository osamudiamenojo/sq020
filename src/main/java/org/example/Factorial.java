package org.example;

public class Factorial {

    // Recursive method to calculate factorial
    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) return 1;


        // Recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // Test the factorial function
        int number = 5; // Example input
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
