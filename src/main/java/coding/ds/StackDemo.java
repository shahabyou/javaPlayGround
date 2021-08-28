package main.java.coding.ds;

import java.util.ArrayList;
import java.util.List;

public class StackDemo {

    public static int i=-1;
    public static int[] array = new int[10];
    public static void main(String[] args) {

        push(100);
        System.out.println(peek());
        System.out.println( pop());

        for (int i = 0; i < 10; i++) {
            push(i);
        }
        push(100);
        System.out.println(peek());
        pop();
        for (int j = 0; j < 10; j++) {
            System.out.println( pop());
        }
    }

    public static void push(int val){
        if(i+1==array.length) return;
        array[++i] = val;
    }

    public static int pop(){
        if(i<0) return Integer.MIN_VALUE;
        return array[i--];
    }

    public static int peek(){
        return array[i];
    }
}
