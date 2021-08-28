package main.java.coding;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static void main(String[] args) {
        checkInclusion("ab",
                "eidbaooo");
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;


        Map<Character, Integer> map1 = new HashMap<>();
        for(Character c: s1.toCharArray())
            map1.put( c, map1.getOrDefault(c,0) + 1);

        int r = 0 , l = 0;

        Map<Character, Integer> map2 = new HashMap<>();
        while(r<s1.length()-1 ){
            map2.put( s2.charAt(r), map2.getOrDefault(s2.charAt(r),0) + 1);
            r++;
        }

        while(r<s2.length()){
            map2.put( s2.charAt(r), map2.getOrDefault(s2.charAt(r),0) + 1);
            if(map1.equals(map2))
                return true;
            map2.put( s2.charAt(l), map2.get(s2.charAt(l)) - 1);
            if(map2.get(s2.charAt(l))==0)
                map2.remove(s2.charAt(l));
            l++;
            r++;

        }

        return false;
    }
}
