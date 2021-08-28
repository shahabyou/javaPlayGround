package main.java.coding;

public class FirstMissingPositive {

    public static void main(String[] args) {

//        System.out.println(firstMissingPositive(new int[]{1,2,0}));
//        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{1}));
    }

    // 0 present
    // -1 missing
    public static int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) return 1;
        int n = nums.length;

        //1 iterate entire array make all item bigger than n and zero and negative to -1
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=0 || nums[i]>n)
                nums[i]=-1;
        }
        //2 use array as map iterate entire array make all place 0 where item less than n presented
        for(int i=0; i<nums.length; i++){
            if(nums[i]> 0) {
                int temp= nums[nums[i]-1];
                nums[nums[i]-1] = 0;
                if(temp-1==i)
                    continue;
                if(temp>0)
                     nums[i]=temp;
                else
                    nums[i] = -1;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==-1) return i+1;
        }
        return n+1;
    }
}
