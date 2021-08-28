package main.java.coding.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        binarySearch(new int[]{1,2,3,4,5}, 4);
        binarySearch(new int[]{1,2,3,4,5}, 2);
        binarySearch(new int[]{1,2,3,4,5}, 3);
        binarySearch(new int[]{1,2,4,5}, 4);
        binarySearch(new int[]{1,2,4,5}, 1);
        binarySearch(new int[]{1,2,4,5}, 3);

    }

    public static boolean binarySearch(int [] array, int target){
        int l=0 , r=array.length-1;

        while(l<=r){

            int mid = (r-l)/2 + l;

            if(target==array[mid])
                return true;
            if(target<array[mid])
               r=mid-1;
            else
                l=mid+1;
        }

        return false;

    }
}
