package main.java.coding;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        System.out.println( minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        if(s==null || t==null || s.equals("") || t.equals("") || s.length()<t.length()) return "";
        if(s.equals(t)) return s;

        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray())
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);

        int b = 0;
        int f = 0;
        String str = "";
        Map<Character, Integer> map = new HashMap<>();

        while (b<s.length() && f<s.length()){

            while( f<s.length() && !tmap.containsKey(s.charAt(f))) f++;

            if(f<s.length()) {
                map.put(s.charAt(f), map.getOrDefault(s.charAt(f),0)+1);
                f++;
            }

            while (b<s.length() && b<f ) {
                if (compareMap(tmap, map)) {
                    if (str.equals("")) str = s.substring(b, f );
                    else str = str.length() > s.substring(b, f ).length() ? s.substring(b, f ) : str;
                    if(map.containsKey(s.charAt(b))) {
                        Integer value = map.get(s.charAt(b))-1;
                        if(value==0) map.remove(s.charAt(b));
                        else map.put(s.charAt(b), value);
                    }
                    b++;
                }else break;

            }


        }


        return str;
    }

    public static boolean compareMap(Map<Character, Integer> dic , Map<Character, Integer> map2){

        for (Map.Entry<Character, Integer> entry: dic.entrySet()) {
            if(!map2.containsKey(entry.getKey())) return false;
            if(map2.get(entry.getKey())<entry.getValue() ) return false;
        }

        return true;
    }


}
