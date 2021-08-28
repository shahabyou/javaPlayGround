package main.java.coding.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {

        System.out.println(reorganizeString("aaaabbc"));
    }

    public static String reorganizeString(String s) {
        if(s==null || s.length()==0) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );

        heap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while ( !heap.isEmpty()){

            Map.Entry<Character, Integer> c1 = heap.poll();

            Map.Entry<Character, Integer> c2=null;
            if(!heap.isEmpty())
                c2 = heap.poll();

            if(sb.length()!=0 && c1.getKey()==sb.charAt(sb.length()-1))
                return "";

            sb.append(c1.getKey());
            if(c1.getValue()>1) {
                c1.setValue(c1.getValue()-1);
                heap.add(c1);
            }

            if(sb.length()!=0 && c2!=null && c2.getKey()==sb.charAt(sb.length()-1))
                return "";

            if (c2!=null){
                sb.append(c2.getKey());
                if(c2.getValue()>1) {
                    c2.setValue(c2.getValue()-1);
                    heap.add(c2);
                }
            }


        }
        return sb.toString();
    }

    }
