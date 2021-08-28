package main.java.coding.dp;

import java.util.Arrays;

public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int [] {2,3,1,1,4}));
        System.out.println(canJump2(new int [] {3,2,1,0,4}, 0));
    }
    public static boolean canJump(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        Arrays.fill(dp,false);

        int i = nums.length-1;
        dp[i] = true;
        while(0<--i){
            if(i+nums[i]>nums.length-1)
                dp[i] = false;
            else {
                dp[i] = dp[i + nums[i]];
            }
        }

        return dp[0];
    }

    public static boolean canJump2(int[] nums, int first) {
        if(first>= nums.length) return true;
        if(nums[first]==0) return false;

        int i = 0;

        while(i<=nums[first]){
            i++;
            boolean resp = canJump2(nums,first+i);
            if(resp) return true;
        }

        return false;
    }
}
