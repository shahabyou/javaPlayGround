package main.java.coding.ds;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] array = new int[]{10,2,8,6,7,3};
        mergeSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void mergeSort(int[] array, int start, int end){
        if(end<=start) return;
        int mid = (end+1-start)/2 + start;
        mergeSort(array, start, mid-1);
        mergeSort(array, mid , end);
        merge(array, start , mid , end);
    }

    public static void merge(int[] array, int start, int mid, int end){
        int [] left = Arrays.copyOfRange(array,start, mid);
        int [] right  = Arrays.copyOfRange(array,mid, end+1);
        int i=0;
        int j=0;
        int k = start;
        while (i<left.length && j<right.length){
            if(left[i]<right[j]){
               array[k++] = left[i++];
            }else {
                array[k++] = right[j++];
            }
        }
        while (i<left.length )  array[k++] = left[i++];

        while (j<right.length )  array[k++] = right[j++];
    }

}
