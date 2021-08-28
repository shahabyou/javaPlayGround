package main.java.coding;

import java.util.*;

public class ThreeSumClosest {

    public static void main(String[] args) {

        /*
          nums[i]+nums[j]=-nums[k];
         */
        int i =  threeSumClosest(new int[]{-1,1,2,-4}, 1);
        System.out.println(i);
    }


    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {

            int s= i+1;
            int e=  nums.length-1;
            int current = Integer.MAX_VALUE;
            while (s<e){
                current = nums[i]+nums[s]+nums[e];
                if(current<target)
                    s++;
                else
                    e--;

                sum = Math.abs(target - current) < Math.abs(target - sum) ? current : sum;

            }
        }

        return sum;
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
