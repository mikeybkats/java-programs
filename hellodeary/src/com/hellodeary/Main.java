package com.hellodeary;

public class Main {
    public static void main(String[] args) {
        int number = add(1, 5);
        System.out.println("Hello, World");
        System.out.println(number);
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
