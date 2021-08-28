package main.java.coding.topK;

import java.util.*;
import java.util.stream.Collectors;

public class FindClosestElements {

    public static void main(String[] args) {
        findClosestElementsSort( new int[]{0,0,1,2,3,3,4,7,7,8},
        3,
        5);
        findClosestElements( new int[]{0,0,1,2,3,3,4,7,7,8},
                3,
                5);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null||arr.length<=k)
            return Arrays.stream(arr).boxed().collect(Collectors.toList());

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a,b) -> Math.abs( x-b) - Math.abs( x-a)
        );

        for(int i=0; i < k; i++)
            heap.add(arr[i]);

        for(int i=k; i< arr.length; i++){
            int num = heap.poll();
            num = ( Math.abs( x-num) < Math.abs( x-arr[i]) ) ? num : arr[i];
            heap.add(num);
        }

        List<Integer> sortedArr  = new ArrayList<Integer>(heap);
        Collections.sort(sortedArr);
        return sortedArr;
    }


    public static List<Integer> findClosestElementsSort(int[] arr, int k, int x) {
        if(arr==null||arr.length<=k)
            return Arrays.stream(arr).boxed().collect(Collectors.toList());

       List<Integer> array =  Arrays.stream(arr).boxed().collect(Collectors.toList());
       Collections.sort(array,(a,b)-> Integer.compare(Math.abs(a-x), Math.abs(b-x)));
       return array.subList(0,k);
    }

}
