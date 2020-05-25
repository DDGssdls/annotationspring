package com.spring.calculator;

public class MainCalculator {
    public int div(int i, int j){
        try {
            System.out.println("除法开始运行了!!!!");
            return i/j;
        }finally {
            System.out.println("finally");

        }
    }
}
