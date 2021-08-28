package main.java.coding.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
        System.out.println(list);
    }
    static List<String> list = new LinkedList<>();
    static int first = 0;
    static StringBuilder sb = new StringBuilder();
    public static List<String> letterCasePermutation(String s) {
        if(s.length() == sb.length()){
            list.add(sb.toString());
            return list;
        }
        int idx = sb.length();

            char cu = Character.toUpperCase(s.charAt(idx));
            char lc = Character.toLowerCase(s.charAt(idx));

            sb.append(cu);
            letterCasePermutation(s);
            sb.deleteCharAt(sb.length()-1);

            if(Character.isAlphabetic(lc)){
                sb.append(lc);
                letterCasePermutation(s);
                sb.deleteCharAt(sb.length()-1);
            }
        return list;
    }


}
