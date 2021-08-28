package main.java.coding.ds;

import java.util.Arrays;

/*
    search and find smallest element in the array and swap it with first element
    keep doing same process for the rest of unsorted part of array. find the smallest element
    and swap it with the most left element of unsorted array until all entire array gets sorted.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int [] array = new int[]{10,2,8,6,7,3};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int [] array){
        if (array==null || array.length<=1) return;

        int index = 0;
        for(int i=0; i<array.length; i++){
            index = i;
            for(int j=i+1; j< array.length; j++){
                if(array[j]<array[index])
                    index=j;
            }
            int tmp = array[i];
            array[i]=array[index];
            array[index]=tmp;
        }
    }
}
