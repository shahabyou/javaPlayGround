package main.java.coding.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(topKFrequent(
                new int[]{1,1,1,2,2,3}, 2
        ));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(heap.isEmpty() || heap.size()<k)
                heap.add(entry);
            else if(heap.peek().getValue() < entry.getValue()){
                heap.poll();
                heap.add(entry);
            }
        }


        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.peek().getKey();
            heap.poll();
        }
        return top;
    }
}
