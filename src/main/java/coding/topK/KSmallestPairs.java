package main.java.coding.topK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public static void main(String[] args) {
        kSmallestPairs(new int []{1,1,2}, new int[]{1,2,3}, 2);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (a,b) -> ( b[0]+b[1]) - (a[0]+a[1])
        );

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(heap.size()<k)
                    heap.add(new int[]{nums1[i],nums2[j]});
                else{
                    int [] pair = heap.peek();
                    if(pair[0]+pair[1] < nums1[i]+nums2[j])
                        break;
                    else {
                        heap.remove();
                        heap.add(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        while (!heap.isEmpty()){
            int [] num = heap.remove();
            lists.add(List.of(num[0],num[1]));
        }
        return lists;
    }
}
