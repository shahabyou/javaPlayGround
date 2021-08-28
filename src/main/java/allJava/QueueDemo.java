package main.java.allJava;

import java.util.Deque;
import java.util.LinkedList;

public class QueueDemo {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();

        // put all odd and even together
        for (int i=0; i<10 ; i++)
            if(i%2==0)
                deque.offerFirst(i);
            else
                deque.offerLast(i);
        System.out.println(deque);// [8, 6, 4, 2, 0, 1, 3, 5, 7, 9]




    }


}
