package main.java.coding;

import java.util.*;

public class Amazon {

    public static void main(String[] args) {

    }

    static Map<String, Map<String,Integer>> map = new HashMap<>();
    public static void addProduct(String product, String [] items){
        if(product==null || product.isEmpty() ) return;
        Map<String,Integer> map1 = new HashMap<>();
        Arrays.stream(items).forEach( e->
                map1.put(e, (new Random()).nextInt())
        );
        map.putIfAbsent( product, map1);
    }

    public static String getPopular(String product){
return "";
    }
}
