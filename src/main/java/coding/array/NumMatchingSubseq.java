package main.java.coding.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumMatchingSubseq {

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{ "a","bb","acd","ace"}));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int num = 0;
        HashMap<Character, HashSet<String>> dic = new HashMap<>();
        for (String word : words) {
            if(dic.containsKey(word.charAt(0))){
                dic.get(word.charAt(0)).add(word);
            }else{
                HashSet<String> set= new HashSet<>();
                set.add(word);
                dic.put(word.charAt(0),set);
            }
        }

        for(int i=0; i<s.length(); i++){
            if(dic.containsKey(s.charAt(i))){

                HashSet<String> set = dic.get(s.charAt(i));
                dic.remove(s.charAt(i));

                for (String word: set) {
                    if(word.length()==1) num++;
                    else{
                        if(dic.containsKey(word.charAt(1))){
                            dic.get(word.charAt(1)).add(word.substring(1));
                        }else{
                            HashSet<String> nset = new HashSet<>();
                            nset.add(word.substring(1));
                            dic.put(word.charAt(1),nset);
                        }
                    }
                }
            }
        }
        return num;
    }
}
