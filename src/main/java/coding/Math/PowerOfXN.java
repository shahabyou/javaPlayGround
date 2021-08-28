package main.java.coding.Math;

public class PowerOfXN {

    public static void main(String[] args) {
        System.out.println( powerOf(2,5));

        for(int i=5; 0<i; i/=2)
            System.out.println(i);
    }

    public static int powerOf(int x, int n){
        if(n==0) return 1;

        int num = x;
        if(n==1) return num;
        num = powerOf(x, n/2);
        if(n%2==1)
            num = num * num * x;
        else
            num = num * num;

        return num;

    }
}
