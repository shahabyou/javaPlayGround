package main.java.coding.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TreasureIslandII {

    public static void main(String[] args) {
        System.out.println(
                treasureIslandII(
                        new int [][]{
                                {'S', 'O', 'O', 'S', 'S'},
                                {'D', 'O', 'D', 'O', 'D'},
                                {'O', 'O', 'O', 'O', 'X'},
        {'X', 'D', 'D', 'O', 'O'},
        {'X', 'D', 'D', 'D', 'O'}
                        }
                )
        );
    }


    public static int treasureIslandII(int [][] grid){
        int shortestPath = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Queue<int []> queue = new LinkedList<>();
        final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){

                if(grid[i][j]!= 'S') continue;
                // source
                queue.add(new int[]{i,j,0});
                set.clear();
                while(!queue.isEmpty()) {
                     int [] node = queue.poll();
                     if(grid[node[0]][node[1]] == 'X') {
                         queue.clear();
                         shortestPath = Math.min(node[2], shortestPath);
                         break;
                     }
                     set.add( node[0] + "," + node[1]);
                    for (int[] dir: dirs) {
                        int x = node[0] + dir[0];
                        int y = node[1] + dir[1];
                        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 'S' || grid[x][y] == 'D' || set.contains(x +","+y) )continue;
                        queue.add(new int[]{x,y, node[2]+1});
                    }
                }
            }

        }

        return shortestPath==Integer.MAX_VALUE ? -1 : shortestPath;
    }

}
