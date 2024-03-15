package com.firstproject.firstproject;

public class Fibonacci {

    public int fib(int n) {
        if (n==0 || n==1) { return 1; }
        else { return fib(n-1) + fib(n-2); }
    }

    public String fibStr(int n) {
        return Integer.toString(fib(n));
//        return "ooi";
    }

}
