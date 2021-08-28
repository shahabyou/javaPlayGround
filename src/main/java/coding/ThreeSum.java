package main.java.coding;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        /*
          nums[i]+nums[j]=-nums[k];
         */
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length-2; i++) {
            List<Integer> list = twoSum(nums,i, -nums[i]);
            if (list!=null){
                Collections.sort(list);
                map.putIfAbsent(list.toString(),list);
            }

        }

        return new ArrayList<>(map.values());
    }

    public static List<Integer> twoSum(int[] nums, int idx,int target) {
        if(nums==null || nums.length<=1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(i==idx) continue;
            if(map.containsKey(nums[i])){
                return Arrays.asList(-target, nums[ map.get(nums[i])],nums[i]);
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}
