package main.java.coding.array;

public class FindUnsortedSubarray {

    public static void main(String[] args) {
        int num[] = new int[]{1,2,3,4};



        System.out.println(findUnsortedSubarray(num));
    }

    public static int findUnsortedSubarray(int[] num) {
        int bp =0;
        while (bp<num.length-1 && num[bp]<num[bp+1]) bp++;

        for(int i=bp+1; i<num.length && 0<bp; i++){
            while(num[i]<=num[bp] && 0<bp)
                bp--;
        }

        int bd = num.length-1;
        while(0<bd && num[bd-1]< num[bd]) bd--;
        for(int i=bd+1; 0<=i && 0<bd; i--){
            while(num[i]>=num[bd] && bd<num.length-1)
                bd++;
        }

        return bd-bp<0 ? 0 : bd-bp;
    }
}
