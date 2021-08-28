package main.java.coding.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CourseSchadule {

    public static void main(String[] args) {
        canFinish(5, new int[][]{
                {1,4},{2,4},{3,1},{3,2}});
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1) return true;
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses;i++){

            map.put(i,new LinkedList<Integer>());
        }

        for(int[] pair: prerequisites){
            map.get(pair[0]).addLast(pair[1]);
        }

        for(int i=0; i<numCourses; i++){

            if(!dfs(map, i, new HashSet<>())){
                return false;
            }
        }

        return true;
    }

    public static boolean dfs( HashMap<Integer, LinkedList<Integer>> map , int current, HashSet<Integer> visited){
        if(visited.contains(current))
            return false;

        visited.add(current);
        for(Integer course: map.get(current)){
            if(!dfs(map,course,visited))
                return false;
        }
        visited.remove(current);
        return true;
    }

}
