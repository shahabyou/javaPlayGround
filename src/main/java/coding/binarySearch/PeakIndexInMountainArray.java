package main.java.coding.binarySearch;

import java.util.Collections;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        peakIndexInMountainArray(new int [] {3,5,3,2,0});
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;

        while(l<r){
            int mid = (r-l)/2 + l;
            if(arr[mid-1]< arr[mid] && arr[mid+1]<arr[mid])
                return mid;
            if(arr[mid]<arr[mid+1])
                l = mid ;
            else
                r = mid ;
        }


        return l;
    }
}
