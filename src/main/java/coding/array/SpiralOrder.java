package main.java.coding.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int a = 0;
        int b = 0;
        int c = matrix.length -1 ;
        int d = matrix[0].length -1 ;

        while(a<=c && b<=d){

            for(int i=b; i<=d; i++ ){
                list.add( matrix[a][i]);
            }

            for(int i=a+1; i<=c; i++ ){
                list.add( matrix[i][d]);
            }

            if (a < d && c < d) {
                for (int i = d - 1; a <= i; i--) {
                    list.add(matrix[c][i]);
                }

                for (int i = c - 1; a < i; i--) {
                    list.add(matrix[i][b]);
                }
            }
            a+=1;
            b+=1;
            c-=1;
            d-=1;
        }

        return list;
    }
}
