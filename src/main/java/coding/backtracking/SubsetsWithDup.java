package main.java.coding.backtracking;

import java.util.*;

public class SubsetsWithDup {

    public static void main(String[] args) {
        subsetsWithDup(new int [] {4,1,0});
    }

    static Map<String, List<Integer>> map = new HashMap<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        for(int i=0; i<nums.length+1; i++){
            helper( 0 , new LinkedList<Integer>(), i, nums);
        }

        return new LinkedList<List<Integer>>(map.values());
    }

    public static void helper(int first, LinkedList<Integer> list, int k, int[] nums){
        if(list.size()==k){
            List<Integer> listtmp = new LinkedList<Integer>(list);
            Collections.sort(listtmp);
            if(!map.containsKey(listtmp)){
                map.put(listtmp.toString(), new LinkedList<Integer>(listtmp));
            }
            return;
        }

        for(int i= first; i<nums.length; i++){
            list.add(nums[i]);

            helper(i+1, list,k, nums);

            list.removeLast();
        }


    }


}
