package main.java.allJava;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Character>  set = new HashSet<>();
        String str = "This is a set test to find all unique characters";

        for(int i=0; i<str.length(); i++){
            if(!set.contains(str.charAt(i)))
                set.add(str.charAt(i));
        }


        System.out.println(set);
        set.remove(' ');
        System.out.println(set);
    }
}
