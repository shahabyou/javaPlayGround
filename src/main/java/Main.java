package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("test".equals(null));
        System.out.println("t & p");
//        checkSet(null);
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5,6,7));

        System.out.println(list);
        List<Integer> list1 = list.stream().filter(e->List.of(5,6,7).contains(e)).collect(Collectors.toList());
        list.removeAll(list1);
        System.out.println(list.toString());
        list.addAll(list1);
        System.out.println(list.toString());

    }

    public static void checkSet(Set set){
        if(set.isEmpty())
            System.out.println("null");
        else
            System.out.println("may null");

    }
}
