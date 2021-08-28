package main.java.coding;

import java.util.Arrays;

public class DuplicateZeros {

    public static void main(String[] args) {
        int [] arr = new int[]{1,0,0,0};
        duplicateZeros(arr );
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int zeroCount = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0) continue;

            while(i<arr.length && arr[i]==0){
                zeroCount++;
                i++;
            }

            if(i==arr.length) return;
            System.arraycopy(arr, i, arr, i + zeroCount, arr.length-zeroCount-i);
            Arrays.fill(arr, i, i + zeroCount, 0);
            i+=(zeroCount-1);
            zeroCount=0;
        }
    }
}
