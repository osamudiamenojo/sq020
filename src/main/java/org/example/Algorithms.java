package org.example;

import java.util.*;

public class Algorithms {


Stack<String> stack = new Stack<>();
        public static void main(String[] args) {
            System.out.println("Prime numbers between 1 to 100:");

            System.out.println(Math.pow(8,0.33333333));

            for (int i = 2; i <= 100; i++) {

                if (isPrime(i))
                    System.out.print(i + " ");
            }
        }
        //O(100)==O(1)
        //O(100n)== O(n)
    //O(2) + O(n)= O(1+n)= O(n)

        public static boolean isPrime(int n) {
            if (n <= 1)
                return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;

        }
    }








