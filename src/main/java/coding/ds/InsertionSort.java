package main.java.coding.ds;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int [] array = new int[]{10,2,8,6,7,3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void insertionSort(int [] array){
        if(array==null|| array.length<=1) return;
        for (int i=1; i< array.length; i++){
            for(int j=i-1; 0<=j; j--){
                if(array[j+1] < array[j]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }else
                    break;
            }
        }
    }
}
