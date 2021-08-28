package main.java.coding.ds;

import java.util.Arrays;

/*
 we receive an array of integer to sort it.
 for this , we compare two item in array and swap them if the first item is bigger than the second one.
 we keep continue (doing) that until we reach the last pair. So now the last item is largest number.
 Every time we reapte it we move the largest item to the right.
SO we keep a pointer for this part and this part is always sorted part of the array.
again repeat same process but up to the sorted pointer.

 continue the mentioned process for
 */
public class BubbleSort {

    public static void main(String[] args) {

        int [] array = new int[]{10,2,8,6,7,3};


        for(int i=0; i<array.length-1;i++)
        {
            if(array[i]>array[i+1]){
                int tmp = array[i];
                array[i]=array[i+1];
                array[i+1]=tmp;
            }
        }
        System.out.println(Arrays.toString(array));

//        int [] array =bubbleSort(new int[]{10,2,8,6,7,3});
//        System.out.println(Arrays.toString(array));
//        array =bubbleSort(new int[]{10});
//        System.out.println(Arrays.toString(array));
//        array =bubbleSort(new int[]{10,2});
//        System.out.println(Arrays.toString(array));
//        array =bubbleSort(new int[]{});
//        System.out.println(Arrays.toString(array));
//        array =bubbleSort(null);
//        System.out.println(Arrays.toString(array));
    }

    public static int[] bubbleSort(int [] array){
        if(array==null || array.length ==0) return array;

        for(int i=array.length-1; 0<i;i--){
            for (int j=0; j<i ;j++)
                if(array[j]>array[j+1]){
                    int tmp= array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }

        }
        return array;
    }


}
