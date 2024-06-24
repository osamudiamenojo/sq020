package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full!");
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    
//
//    public static void main(String[] args) {
//        StackArray stack = new StackArray(5);
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//
//        System.out.println(stack.pop());  // Output: 30
//        System.out.println(stack.peek()); // Output: 20
//        System.out.println(stack.pop());  // Output: 20
//        System.out.println(stack.pop());  // Output: 10
//        System.out.println(stack.pop());  // Output: Stack is empty! -1
//    }
}

