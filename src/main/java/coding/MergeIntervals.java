package main.java.coding;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String[] args) {
        //merge();
        insert(new int[][] {{1,3},{6,9}}
,new int[]{2,5});
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<=1) return intervals;

        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0],b[0]));

        LinkedList<int[]> list = new LinkedList<>();

        for(int[] interval: intervals){
            if(list.isEmpty() || list.getLast()[1]<interval[0])
                list.add(interval);
            else
                list.getLast()[1]= Math.max(list.getLast()[1],interval[1] );
        }

        return list.toArray(new int[list.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> merge = new LinkedList<>();
        int idx = 0;

        // insert newInterval
        while(idx<intervals.length && intervals[idx][1]<newInterval[0])
            merge.add(intervals[idx++]);

        merge.add(newInterval);

        //merge with rest of interval if needs
        while(idx<intervals.length){
            if(merge.getLast()[1]<intervals[idx][0])
                merge.add(intervals[idx]);
            else{
                merge.getLast()[0] = Math.min(merge.getLast()[0], intervals[idx][0]);
                merge.getLast()[1] = Math.max(merge.getLast()[1], intervals[idx][1]);
            }
            idx++;
        }

        return merge.toArray(new int[merge.size()][]);

    }
}
